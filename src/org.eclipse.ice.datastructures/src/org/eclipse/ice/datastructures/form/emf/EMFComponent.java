/*******************************************************************************
 * Copyright (c) 2012, 2014 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.ice.datastructures.form.emf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.ice.datastructures.ICEObject.Component;
import org.eclipse.ice.datastructures.ICEObject.ICEJAXBHandler;
import org.eclipse.ice.datastructures.ICEObject.ICEObject;
import org.eclipse.ice.datastructures.componentVisitor.IComponentVisitor;
import org.eclipse.ice.datastructures.form.TreeComposite;
import org.xml.sax.SAXException;

/**
 * The EMFComponent is a realization of the Component interface that
 * encapsulates the data in an Eclipse Modeling Framework (EMF) Ecore model
 * tree. EMFComponent takes a valid XML schema file (*.xsd) and generates an
 * Ecore model using the EMF utility class, XMLProcessor. This Ecore model is
 * then mapped to an EMFTreeComposite, a subclass of TreeComposite that keeps
 * track of a given Ecore tree node's structural EAttribute features and keeps
 * the Ecore model updated upon user modification to those attributes.
 * EMFComponent provides serialization and de-serialization routines for the
 * encapsulated XML resource.
 * 
 * @author Alex McCaskey
 */
@XmlRootElement(name = "EMFComponent")
public class EMFComponent extends ICEObject implements Component {

	/**
	 * Reference to the EMFTreeComposite which provides a representation of the
	 * Ecore model that the ICE UI expects and can visualization for user
	 * manipulation. This tree represents DocumentRoot in the EMF tree, so it
	 * should only have 1 child.
	 * 
	 */
	@XmlElement(name = "EMFTreeComposite")
	private EMFTreeComposite iceEMFTree;

	/**
	 * Reference to the XMLProcessor that is used to read and write the
	 * EMFComponent's XML Resource.
	 * 
	 */
	private XMLProcessor xmlProcessor;

	/**
	 * Reference to the EMF XML Resource that contains the Ecore domain model.
	 * 
	 */
	private XMLResource xmlResource;

	/**
	 * The nullary constructor
	 * 
	 */
	public EMFComponent() {
		super();
		iceEMFTree = new EMFTreeComposite();
		xmlResource = new XMLResourceImpl();
	}

	/**
	 * The constructor, takes a Java file pointing to the XML schema model.
	 * 
	 * @param file The XML Schema
	 */
	public EMFComponent(File file) {
		super();

		// Initialize class data
		iceEMFTree = new EMFTreeComposite();
		xmlResource = new XMLResourceImpl();

		// Make sure we have a valid File object.
		if (file != null) {
			// Create a new XMLProcessor to be used in creating
			// and persisting XML Resources
			try {
				xmlProcessor = new XMLProcessor(URI.createFileURI(file
						.getAbsolutePath()));
			} catch (SAXException e) {
				e.printStackTrace();
			}

			// Get the package containing the model
			EPackage ePackage = (EPackage) xmlProcessor.getEPackageRegistry()
					.values().toArray()[0];

			// Get the TreeIterator to walk over the elements
			TreeIterator<EObject> tree = ePackage.eAllContents();
			while (tree.hasNext()) {
				// Get the Element
				EObject obj = tree.next();

				// We only care about EClass instances bc those
				// are the nodes of the tree.
				if (obj instanceof EClass) {
					EClass eClass = (EClass) obj;
					// Add the new EMFTreeComposite corresponding to the current
					// EClass instance to the mapping
					if ("DocumentRoot".equals(eClass.getName())) {
						// This will give us a root node, and the constructor
						// will take care of constructing possible exemplar
						// children nodes.
						iceEMFTree = new EMFTreeComposite(eClass);
						break;
					}
				}
			}
		}

		return;
	}

	/**
	 * Return the generated EMFTreeComposite that represents the Ecore domain
	 * model.
	 * 
	 * @return
	 */
	public TreeComposite getEMFTreeComposite() {
		return iceEMFTree;
	}

	/**
	 * Save the XMLResource to the given Java File.
	 * 
	 * @param saveFile
	 * @return
	 */
	public boolean save(File saveFile) {

		// Local Declarations
		boolean created = false;
		FileOutputStream outputStream = null;

		try {
			// If the file already exists, we are
			// going to overwrite it, so delete it first
			if (saveFile.exists()) {
				saveFile.delete();
			}

			// Create the file
			created = saveFile.createNewFile();

			if (created) {
				// Create the output stream
				outputStream = new FileOutputStream(saveFile);

				xmlResource.getContents().clear();
				xmlResource.getContents().add(iceEMFTree.getEcoreNode());

				// Direct the XMLProcessor to save the Resource
				xmlProcessor.save(outputStream, xmlResource, null);

				// Indicate success
				return true;
			} else {
				System.out
						.println("[EMFComponent] Could not create save file.");
				return false;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Load the XML file with a given XML schema. This method should be used 
	 * in conjuction with the nullary constructor. 
	 * 
	 * @param schema
	 * @param file
	 * @return
	 */
	public boolean load(File schema, File file) {
		// Create a new XMLProcessor to be used in creating
		// and persisting XML Resources
		try {
			xmlProcessor = new XMLProcessor(URI.createFileURI(schema
					.getAbsolutePath()));
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		}

		return load(file);
	}

	/**
	 * Load the given File as an XMLResource.
	 * 
	 * @param file
	 * @return
	 */
	public boolean load(File file) {

		// Local Declarations
		EObject documentRoot = null;

		if (xmlProcessor != null) {
			try {
				xmlResource = (XMLResource) xmlProcessor.load(
						new FileInputStream(file), null);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		if (xmlResource != null) {
			documentRoot = (EObject) xmlResource.getContents().get(0);
		} else {
			return false;
		}

		if (documentRoot != null) {
			iceEMFTree = new EMFTreeComposite(documentRoot);
			mapToEMFTreeComposite(documentRoot.eContents().get(0), iceEMFTree);
		} else {
			return false;
		}

		return true;
	}

	/**
	 * This private method recursively walks the EObject tree and creates 
	 * a EMFTreeComposite representing the XML data. 
	 * 
	 * @param rootNode
	 * @param parent
	 */
	private void mapToEMFTreeComposite(EObject rootNode, EMFTreeComposite parent) {

		// Get the EClass Meta Data and
		// this EObject's children
		EList<EObject> subChildren = rootNode.eContents();

		// If we have no children, then create a EMFTreeComposite
		// representing rootNode and set it as the child of
		// the incoming parent
		if (subChildren.isEmpty()) {
			parent.setNextChild(new EMFTreeComposite(rootNode));
		} else {
			// If this rootNode does have children, then recursively walk and
			// create EMFTreeComposites of them

			// Create a EMFTreeComposite for this rootNode EObject
			EMFTreeComposite thisTreeNode = new EMFTreeComposite(rootNode);

			// Loop over its children to map from Ecore to EMFTreeComposite
			for (EObject obj : subChildren) {
				mapToEMFTreeComposite(obj, thisTreeNode);
			}

			// Set thisTreeNode as the child of the incoming
			// parent
			parent.setNextChild(thisTreeNode);
		}

		return;

	}

	/**
	 * This operation is used to check equality between the EMFComponent and
	 * another EMFComponent. It returns true if the EMFComponents are equal and
	 * false if they are not.
	 * 
	 */
	public boolean equals(Object otherEMFComponent) {
		// begin-user-code

		// Check if they are the same reference in memory
		if (this == otherEMFComponent) {
			return true;
		}

		// Check that the object is not null, and that it is a EMFComponent
		// Check that these objects have the same ICEObject data
		if (otherEMFComponent == null
				|| !(otherEMFComponent instanceof EMFComponent)
				|| !super.equals(otherEMFComponent)) {
			return false;
		}

		// At this point, other object must be a EMFComponent, so cast it
		EMFComponent castedComponent = (EMFComponent) otherEMFComponent;

		// For now assume that if the TreeComposites are equal,
		// the two EMFComponents are equal
		if (!castedComponent.iceEMFTree.equals(iceEMFTree)) {
			System.out.println("Trees were not equal!");
			return false;
		}

		// If made it here, these EMFComponents are Equal
		// Return true
		return true;
		// end-user-code
	}

	/**
	 * This operation returns the hashcode value of the EMFComponent.
	 * 
	 */
	public int hashCode() {
		// begin-user-code

		// Local Declaration
		int hash = 9;

		// Compute hash code from EMFComponent data
		hash = 31 * hash + super.hashCode();
		hash = 31 * hash + iceEMFTree.hashCode();

		return hash;
		// end-user-code
	}

	/**
	 * This operation performs a deep copy of the attributes of another
	 * EMFComponent into the current EMFComponent.
	 * 
	 * @param otherEMFComponent
	 */
	public void copy(EMFComponent otherEMFComponent) {
		// begin-user-code

		// Return if otherEMFComponenet is null
		if (otherEMFComponent != null) {

			// Copy contents into super and current object
			super.copy((ICEObject) otherEMFComponent);

			// TODO Do rest of copy...
			// FIXME ECOREUTILS
			iceEMFTree.copy(otherEMFComponent.iceEMFTree);
			// documentRoot = EcoreUtil.copy(otherEMFComponent.documentRoot);

			notifyListeners();
		}
		return;
		// end-user-code
	}

	/**
	 * This operation provides a deep copy of the EMFComponent.
	 * 
	 */
	public Object clone() {
		// begin-user-code

		// Create a new instance, copy contents and return it
		EMFComponent emfComponent = new EMFComponent();
		emfComponent.copy(this);

		return emfComponent;
		// end-user-code
	}

	@Override
	public void accept(IComponentVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * Save the XMLResource to System.out. This is mainly for debugging.
	 * 
	 * @return
	 */
	public boolean save() {

		// Create a new XMLResource and add the Ecore model to it
		// xmlResource.getContents().clear();
		if (iceEMFTree.getEcoreNode() != null) {
			xmlResource.getContents().add(iceEMFTree.getEcoreNode());

			// Write to standard out
			try {
				xmlProcessor.save(System.out, xmlResource, null);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * Save the XMLResource to a java.lang.String
	 * 
	 * @return
	 */
	public String saveToString() {
		String retString = null;
		try {
			retString = xmlProcessor.saveToString(xmlResource, null);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return retString;
	}

}
