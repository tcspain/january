/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.geometry.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.january.geometry.util.GeometryAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GeometryItemProviderAdapterFactory extends GeometryAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Shape} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeItemProvider shapeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Shape}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShapeAdapter() {
		if (shapeItemProvider == null) {
			shapeItemProvider = new ShapeItemProvider(this);
		}

		return shapeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Triangle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriangleItemProvider triangleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Triangle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTriangleAdapter() {
		if (triangleItemProvider == null) {
			triangleItemProvider = new TriangleItemProvider(this);
		}

		return triangleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Vertex} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexItemProvider vertexItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Vertex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVertexAdapter() {
		if (vertexItemProvider == null) {
			vertexItemProvider = new VertexItemProvider(this);
		}

		return vertexItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Sphere} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SphereItemProvider sphereItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Sphere}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSphereAdapter() {
		if (sphereItemProvider == null) {
			sphereItemProvider = new SphereItemProvider(this);
		}

		return sphereItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Cube} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CubeItemProvider cubeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Cube}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCubeAdapter() {
		if (cubeItemProvider == null) {
			cubeItemProvider = new CubeItemProvider(this);
		}

		return cubeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Cylinder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CylinderItemProvider cylinderItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Cylinder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCylinderAdapter() {
		if (cylinderItemProvider == null) {
			cylinderItemProvider = new CylinderItemProvider(this);
		}

		return cylinderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Geometry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryItemProvider geometryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Geometry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGeometryAdapter() {
		if (geometryItemProvider == null) {
			geometryItemProvider = new GeometryItemProvider(this);
		}

		return geometryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Tube} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TubeItemProvider tubeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Tube}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTubeAdapter() {
		if (tubeItemProvider == null) {
			tubeItemProvider = new TubeItemProvider(this);
		}

		return tubeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Operator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorItemProvider operatorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperatorAdapter() {
		if (operatorItemProvider == null) {
			operatorItemProvider = new OperatorItemProvider(this);
		}

		return operatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Union} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnionItemProvider unionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Union}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnionAdapter() {
		if (unionItemProvider == null) {
			unionItemProvider = new UnionItemProvider(this);
		}

		return unionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Intersection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntersectionItemProvider intersectionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Intersection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntersectionAdapter() {
		if (intersectionItemProvider == null) {
			intersectionItemProvider = new IntersectionItemProvider(this);
		}

		return intersectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Complement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplementItemProvider complementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Complement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplementAdapter() {
		if (complementItemProvider == null) {
			complementItemProvider = new ComplementItemProvider(this);
		}

		return complementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Material} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaterialItemProvider materialItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Material}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaterialAdapter() {
		if (materialItemProvider == null) {
			materialItemProvider = new MaterialItemProvider(this);
		}

		return materialItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.STLGeometryImporter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STLGeometryImporterItemProvider stlGeometryImporterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.STLGeometryImporter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSTLGeometryImporterAdapter() {
		if (stlGeometryImporterItemProvider == null) {
			stlGeometryImporterItemProvider = new STLGeometryImporterItemProvider(this);
		}

		return stlGeometryImporterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Pipe} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeItemProvider pipeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Pipe}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPipeAdapter() {
		if (pipeItemProvider == null) {
			pipeItemProvider = new PipeItemProvider(this);
		}

		return pipeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.BoundingBox} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundingBoxItemProvider boundingBoxItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.BoundingBox}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBoundingBoxAdapter() {
		if (boundingBoxItemProvider == null) {
			boundingBoxItemProvider = new BoundingBoxItemProvider(this);
		}

		return boundingBoxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Junction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JunctionItemProvider junctionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Junction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJunctionAdapter() {
		if (junctionItemProvider == null) {
			junctionItemProvider = new JunctionItemProvider(this);
		}

		return junctionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.HeatExchanger} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HeatExchangerItemProvider heatExchangerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.HeatExchanger}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHeatExchangerAdapter() {
		if (heatExchangerItemProvider == null) {
			heatExchangerItemProvider = new HeatExchangerItemProvider(this);
		}

		return heatExchangerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Reactor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReactorItemProvider reactorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Reactor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReactorAdapter() {
		if (reactorItemProvider == null) {
			reactorItemProvider = new ReactorItemProvider(this);
		}

		return reactorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.PolyShape} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolyShapeItemProvider polyShapeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.PolyShape}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPolyShapeAdapter() {
		if (polyShapeItemProvider == null) {
			polyShapeItemProvider = new PolyShapeItemProvider(this);
		}

		return polyShapeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.Face} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FaceItemProvider faceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.Face}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFaceAdapter() {
		if (faceItemProvider == null) {
			faceItemProvider = new FaceItemProvider(this);
		}

		return faceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.january.geometry.VertexSource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexSourceItemProvider vertexSourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.january.geometry.VertexSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVertexSourceAdapter() {
		if (vertexSourceItemProvider == null) {
			vertexSourceItemProvider = new VertexSourceItemProvider(this);
		}

		return vertexSourceItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (shapeItemProvider != null) shapeItemProvider.dispose();
		if (triangleItemProvider != null) triangleItemProvider.dispose();
		if (vertexItemProvider != null) vertexItemProvider.dispose();
		if (sphereItemProvider != null) sphereItemProvider.dispose();
		if (cubeItemProvider != null) cubeItemProvider.dispose();
		if (cylinderItemProvider != null) cylinderItemProvider.dispose();
		if (geometryItemProvider != null) geometryItemProvider.dispose();
		if (tubeItemProvider != null) tubeItemProvider.dispose();
		if (operatorItemProvider != null) operatorItemProvider.dispose();
		if (unionItemProvider != null) unionItemProvider.dispose();
		if (intersectionItemProvider != null) intersectionItemProvider.dispose();
		if (complementItemProvider != null) complementItemProvider.dispose();
		if (materialItemProvider != null) materialItemProvider.dispose();
		if (stlGeometryImporterItemProvider != null) stlGeometryImporterItemProvider.dispose();
		if (pipeItemProvider != null) pipeItemProvider.dispose();
		if (boundingBoxItemProvider != null) boundingBoxItemProvider.dispose();
		if (junctionItemProvider != null) junctionItemProvider.dispose();
		if (heatExchangerItemProvider != null) heatExchangerItemProvider.dispose();
		if (reactorItemProvider != null) reactorItemProvider.dispose();
		if (polyShapeItemProvider != null) polyShapeItemProvider.dispose();
		if (faceItemProvider != null) faceItemProvider.dispose();
		if (vertexSourceItemProvider != null) vertexSourceItemProvider.dispose();
	}

}
