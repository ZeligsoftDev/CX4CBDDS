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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;

/**
 *  An annotation validator for http://www.eclipse.org/OCL/Import annotations.
 *
 * @since 1.4
 */
public final class OCL_Import_AnnotationValidator extends BasicEAnnotationValidator2
{

	public static final @NonNull OCL_Import_AnnotationValidator INSTANCE = new OCL_Import_AnnotationValidator();
	public static final @NonNull String ANNOTATION_NAME = "OCL_Import";
	public static final @NonNull String ANNOTATION_SOURCE = PivotConstants.IMPORT_ANNOTATION_SOURCE;
	public static final @NonNull String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.pivot.annotation";

	public OCL_Import_AnnotationValidator() {
		super(ANNOTATION_SOURCE, ANNOTATION_NAME, DIAGNOSTIC_SOURCE, PivotAnnotationsPackage.Literals.IMPORT_EPACKAGE);
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
		String importURI = entry.getValue();
		if (importURI != null) {
			ResourceSet resourceSet = null;
			EnvironmentFactory environmentFactory = ThreadLocalExecutor.basicGetEnvironmentFactory();
			if (environmentFactory != null) {
				resourceSet = environmentFactory.getResourceSet();
			}
			EPackage.Registry packageRegistry = resourceSet != null ? resourceSet.getPackageRegistry() : EPackage.Registry.INSTANCE;
			Object registeredPackage = packageRegistry.getEPackage(importURI);
			if (registeredPackage != null) {
				return true;
			}
			URIConverter uriConverter = resourceSet != null ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
			URI uri = URI.createURI(importURI);
			if (eModelElement != null) {
				Resource eResource = ((EObject)eModelElement).eResource();
				if (eResource != null) {
					URI uri2 = eResource.getURI();
					if ((uri2 != null) && !uri2.isRelative()) {
						uri = uri.resolve(uri2);
					}
				}
			}
			if (uriConverter.exists(uri.trimFragment(), null)) {
				return true;
			}
		}
		if (diagnostics != null) {
			diagnostics.add
			(createDiagnostic
				(Diagnostic.ERROR,
					//					DIAGNOSTIC_SOURCE,
					0,
					getEcoreResourceLocator().getString("_UI_GenericConstraint_diagnostic", new Object[] {"ResolveableURI", importURI})));//,
			//					new Object[] { "ResolveableURI"  /*, EObjectValidator.getValueLabel(PivotAnnotationsPackage.Literals.IMPORT_URI, importURI, context)*/ },
			//					new Object[] { importURI },
			//					context));
		}
		return false;
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
