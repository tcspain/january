/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.january.geometry.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.january.geometry.xtext.mTL.Color;
import org.eclipse.january.geometry.xtext.mTL.MTLPackage;
import org.eclipse.january.geometry.xtext.mTL.MaterialSource;
import org.eclipse.january.geometry.xtext.mTL.PhongMaterial;
import org.eclipse.january.geometry.xtext.mTL.TexturedMaterial;
import org.eclipse.january.geometry.xtext.services.MTLGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MTLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MTLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MTLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MTLPackage.COLOR:
				sequence_Color(context, (Color) semanticObject); 
				return; 
			case MTLPackage.MATERIAL_SOURCE:
				sequence_MaterialSource(context, (MaterialSource) semanticObject); 
				return; 
			case MTLPackage.PHONG_MATERIAL:
				sequence_PhongMaterial(context, (PhongMaterial) semanticObject); 
				return; 
			case MTLPackage.TEXTURED_MATERIAL:
				sequence_TexturedMaterial(context, (TexturedMaterial) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Color returns Color
	 *
	 * Constraint:
	 *     (red=EDouble green=EDouble blue=EDouble)
	 */
	protected void sequence_Color(ISerializationContext context, Color semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MTLPackage.Literals.COLOR__RED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MTLPackage.Literals.COLOR__RED));
			if (transientValues.isValueTransient(semanticObject, MTLPackage.Literals.COLOR__GREEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MTLPackage.Literals.COLOR__GREEN));
			if (transientValues.isValueTransient(semanticObject, MTLPackage.Literals.COLOR__BLUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MTLPackage.Literals.COLOR__BLUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getColorAccess().getRedEDoubleParserRuleCall_0_0(), semanticObject.getRed());
		feeder.accept(grammarAccess.getColorAccess().getGreenEDoubleParserRuleCall_1_0(), semanticObject.getGreen());
		feeder.accept(grammarAccess.getColorAccess().getBlueEDoubleParserRuleCall_2_0(), semanticObject.getBlue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MaterialSource returns MaterialSource
	 *
	 * Constraint:
	 *     materials+=Material+
	 */
	protected void sequence_MaterialSource(ISerializationContext context, MaterialSource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Material returns PhongMaterial
	 *     PhongMaterial returns PhongMaterial
	 *
	 * Constraint:
	 *     (
	 *         (name=EString ambient=Color) | 
	 *         diffuse=Color | 
	 *         (specular=Color specularExponent=EDouble?) | 
	 *         opaque=EDouble | 
	 *         transparent=EDouble | 
	 *         illumination=EInt
	 *     )+
	 */
	protected void sequence_PhongMaterial(ISerializationContext context, PhongMaterial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Material returns TexturedMaterial
	 *     TexturedMaterial returns TexturedMaterial
	 *
	 * Constraint:
	 *     (
	 *         (name=EString ambient=Color) | 
	 *         diffuse=Color | 
	 *         (specular=Color specularExponent=EDouble?) | 
	 *         opaque=EDouble | 
	 *         transparent=EDouble | 
	 *         illumination=EInt | 
	 *         ambientMap=EString | 
	 *         diffuseMap=EString | 
	 *         specularMap=EString | 
	 *         specularHighlightMap=EString | 
	 *         alphaMap=EString | 
	 *         bumpMap=EString
	 *     )+
	 */
	protected void sequence_TexturedMaterial(ISerializationContext context, TexturedMaterial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
