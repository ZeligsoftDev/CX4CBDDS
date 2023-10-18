/*******************************************************************************
 * Copyright (c) 2011, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.validation;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * A CompleteOCLEObjectValidator validates CompleteOCL invariants during an EMF validation, provided
 * an CompleteOCLEObjectValidator instance has been registered as a validator in the EValidator.Registry.
 *
 * Loading of the Complete OCL occurs during @link{initialize()} which may be called explicitly
 * or lazily during validation.
 */
public class CompleteOCLEObjectValidator extends PivotEObjectValidator
{
	private static final Logger logger = LogManager.getLogger(CompleteOCLEObjectValidator.class);

	protected final @NonNull EPackage ePackage;
	protected final @NonNull URI oclURI;

	/**
	 * Construct a validator to apply the CompleteOCL invariants from oclURI to ePackage
	 * for the meta-models managed by a newly created environmentFactory.
	 */
	@SuppressWarnings("deprecation")
	public CompleteOCLEObjectValidator(@NonNull EPackage ePackage, @NonNull URI oclURI) {
		this.ePackage = ePackage;
		this.oclURI = oclURI;
	}

	/**
	 * Construct a validator to apply the CompleteOCL invariants from oclURI to ePackage
	 * for the meta-models managed by environmentFactory.
	 *
	 * @deprecated environmentFactory is not used. Use ThreadLocalExecutor.getEnvironmentFactory()
	 */
	@Deprecated
	public CompleteOCLEObjectValidator(@NonNull EPackage ePackage, @NonNull URI oclURI, @NonNull EnvironmentFactory environmentFactory) {
		this(ePackage, oclURI);
	}

	//	@Override
	protected EPackage getEPackage() {
		return ePackage;
	}

	@Deprecated
	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return PivotUtilInternal.getEnvironmentFactory(null).getMetamodelManager();	// Better than nothing compatibility
	}

	/**
	 * Perform the loading and installation of the Complete OCL, returning true if successful.
	 */
	public boolean initialize(@NonNull EnvironmentFactoryInternal environmentFactory) {
		Resource ecoreResource = ePackage.eResource();
		if (ecoreResource == null) {
			return false;
		}
		Ecore2AS ecore2as = Ecore2AS.basicGetAdapter(ecoreResource, environmentFactory);
		if (ecore2as != null) {
			return true;
		}
		ecore2as = Ecore2AS.getAdapter(ecoreResource, environmentFactory);
		ResourceSet resourceSet = environmentFactory.getResourceSet(); // new ResourceSetImpl();
		List<Diagnostic> errors = ecoreResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load Ecore '" + ecoreResource.getURI() + message);
			return false;
		}
		Model pivotModel = ecore2as.getASModel();
		errors = pivotModel.eResource().getErrors();
		assert errors != null;
		message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load Pivot from '" + ecoreResource.getURI() + message);
			return false;
		}
		CSResource xtextResource = (CSResource) resourceSet.getResource(oclURI, true);
		errors = xtextResource.getErrors();
		assert errors != null;
		message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load '" + oclURI + message);
			return false;
		}
		Resource asResource = xtextResource.getASResource();
		errors = asResource.getErrors();
		assert errors != null;
		message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			logger.error("Failed to load Pivot from '" + oclURI + message);
			return false;
		}
		return true;
	}

	@Override
	protected boolean validatePivot(@NonNull EClassifier eClassifier, @Nullable Object object,
			@Nullable DiagnosticChain diagnostics, Map<Object, Object> validationContext) {
		EnvironmentFactoryInternal environmentFactory = PivotUtilInternal.getEnvironmentFactory(object);
		initialize(environmentFactory);
		ResourceSet resourceSet = getResourceSet(eClassifier, object, diagnostics);
		if (resourceSet != null) {
			boolean allOk = validate(environmentFactory, eClassifier, object, complementingModels, diagnostics, validationContext);
			return allOk || (diagnostics != null);
		}
		return true;
	}
}
