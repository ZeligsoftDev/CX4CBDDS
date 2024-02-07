/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 *  An annotation validator for http://www.eclipse.org/Ecore/OCL annotations.
 *
 * @since 1.4
 */
public class Ecore_OCL_AnnotationValidator extends BasicEAnnotationValidator2
{
	public static final @NonNull String ANNOTATION_NAME = "Ecore_OCL";
	public static final @NonNull String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot.annotation";

	public static class Blank extends Ecore_OCL_AnnotationValidator
	{
		public static final @NonNull Blank INSTANCE = new Blank();

		public Blank() {
			super(OCLConstants.OCL_DELEGATE_URI);
		}
	}

	public static class Debug extends Ecore_OCL_AnnotationValidator
	{
		public static final @NonNull Debug INSTANCE = new Debug();

		public Debug() {
			super(PivotConstants.OCL_DELEGATE_URI_DEBUG);
		}
	}

	public static class Pivot extends Ecore_OCL_AnnotationValidator
	{
		public static final @NonNull Pivot INSTANCE = new Pivot();

		public Pivot() {
			super(PivotConstants.OCL_DELEGATE_URI_PIVOT);
		}
	}

	public Ecore_OCL_AnnotationValidator(String annotationSource) {
		super(annotationSource, ANNOTATION_NAME, DIAGNOSTIC_SOURCE,
			PivotAnnotationsPackage.Literals.ECORE_OCL_ECLASSIFIER,
			PivotAnnotationsPackage.Literals.ECORE_OCL_EOPERATION,
			PivotAnnotationsPackage.Literals.ECORE_OCL_ESTRUCTURAL_FEATURE);
	}

	/**
	 * Creates an assistant that creates a map of properties corresponding to the details.
	 */
	@Override
	protected Assistant createAssistant()
	{
		return new MapAssistant(this, PivotAnnotationsPackage.Literals.ECORE_OCL_ECLASSIFIER.getName())
		{
			@Override
			protected @NonNull EStructuralFeature createEStructuralFeature(String key) {
				EStructuralFeature eStructuralFeature = EcoreFactory.eINSTANCE.createEAttribute();
				eStructuralFeature.setName(String.valueOf(key));
				eStructuralFeature.setEType(EcorePackage.Literals.ESTRING);
				return eStructuralFeature;
			}
		};
	}

	/**
	 * Refresh a no-feature map of the prevailing detail keys.
	 */
	@Override
	protected Map<String, EStructuralFeature> getProperties(EModelElement eModelElement) {
		return getNoFeatureProperties(eModelElement);
	}

	@Override
	protected boolean validateDetails(EAnnotation eAnnotation, EModelElement eModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		assert context != null;
		assert eAnnotation != null;
		if (eModelElement instanceof EOperation) {
			return EcoreOCLEValidator.NO_NEW_LINES.validateEOperation((EOperation) eModelElement, diagnostics, context);
		}
		else if (eModelElement instanceof EStructuralFeature) {
			return EcoreOCLEValidator.NO_NEW_LINES.validateEStructuralFeature((EStructuralFeature) eModelElement, diagnostics, context);
		}
		else if (eModelElement instanceof EClassifier) {
			return EcoreOCLEValidator.NO_NEW_LINES.validateEClassifier((EClassifier) eModelElement, diagnostics, context);
		}
		else {
			return super.validateDetails(eAnnotation, eModelElement, diagnostics, context);
		}
	}
}
