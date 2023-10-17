/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
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
import java.util.Map.Entry;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

/**
 *  An annotation validator for http://www.eclipse.org/OCL/Import annotations.
 *
 * @since 1.4
 */
public final class OCL_MetaAnnotation_AnnotationValidator extends BasicEAnnotationValidator2
{

	public static final @NonNull OCL_MetaAnnotation_AnnotationValidator INSTANCE = new OCL_MetaAnnotation_AnnotationValidator();
	public static final @NonNull String ANNOTATION_NAME = "OCL_MetaAnnotation";
	public static final @NonNull String ANNOTATION_SOURCE = PivotConstants.META_ANNOTATION_ANNOTATION_SOURCE;
	public static final @NonNull String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot.annotation";

	public OCL_MetaAnnotation_AnnotationValidator() {
		super(ANNOTATION_SOURCE, ANNOTATION_NAME, DIAGNOSTIC_SOURCE, PivotAnnotationsPackage.Literals.META_ANNOTATION_EANNOTATION);
	}

	/**
	 * Creates an assistant that creates a map of properties corresponding to the details.
	 */
	@Override
	protected Assistant createAssistant()
	{
		return new MapAssistant(this, PivotAnnotationsPackage.Literals.IMPORT_EPACKAGE.getName())
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
	 * Refresh and return the dynamic properties to match the prevailing details
	 */
	@Override
	protected Map<String, EStructuralFeature> getProperties(EModelElement eModelElement) {
		return getNoFeatureProperties(eModelElement);
	}

	@Override
	protected boolean validateDetail(EAnnotation eAnnotation, EModelElement eModelElement, Entry<String, String> entry,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EObject eReference : eAnnotation.getReferences()) {
			if (!(eReference instanceof EModelElement)) {
				allOk = false;
				if (diagnostics != null) {
					diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
							//					DIAGNOSTIC_SOURCE,
							0,
								"MetaAnnotation reference must be an EModelElement"));//,
					//					new Object[] { "ResolveableURI"  /*, EObjectValidator.getValueLabel(PivotAnnotationsPackage.Literals.IMPORT_URI, importURI, context)*/ },
					//					new Object[] { importURI },
					//					context));
				}
			}
		}
		return allOk;
	}

	@Override
	protected boolean validateReferences(EAnnotation eAnnotation, EModelElement eModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EObject eReference : eAnnotation.getReferences()) {
			if (!(eReference instanceof EModelElement)) {
				allOk = false;
				if (diagnostics != null) {
					diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
							//					DIAGNOSTIC_SOURCE,
							0,
								"MetaAnnotation reference must be an EModelElement"));//,
					//					new Object[] { "ResolveableURI"  /*, EObjectValidator.getValueLabel(PivotAnnotationsPackage.Literals.IMPORT_URI, importURI, context)*/ },
					//					new Object[] { importURI },
					//					context));
				}
			}
		}
		return allOk;
	}

	/**
	 * Wrap the inherited behavior in an assignment of the eModelElement to the context.
	 *
	@Override
	protected boolean validateDetails(EAnnotation eAnnotation, EModelElement eModelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		context.put(AbstractPivotAnnotationValidator.class, eModelElement);							// Make the eModelElement available ImportURI validation
		try {
			return super.validateDetails(eAnnotation, eModelElement, diagnostics, context);		// FIXME re-implement and avoid Property synthesis
		}
		finally {
			context.remove(AbstractPivotAnnotationValidator.class);
		}
	} */
}
