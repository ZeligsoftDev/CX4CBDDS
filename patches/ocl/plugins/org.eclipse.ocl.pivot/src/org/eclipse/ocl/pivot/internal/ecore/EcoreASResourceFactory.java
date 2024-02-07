/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.validation.EcoreOCLEValidator;
import org.eclipse.ocl.pivot.internal.validation.PivotEAnnotationValidator;
import org.eclipse.ocl.pivot.resource.ASResource;

public final class EcoreASResourceFactory extends AbstractASResourceFactory
{
	private static @Nullable EcoreASResourceFactory INSTANCE = null;

	public static synchronized @NonNull EcoreASResourceFactory getInstance() {
		if (INSTANCE == null) {
			//			ASResourceFactoryContribution asResourceRegistry = ASResourceFactoryRegistry.INSTANCE.get(ASResource.ECORE_CONTENT_TYPE);
			//			if (asResourceRegistry != null) {
			//				INSTANCE = (EcoreASResourceFactory) asResourceRegistry.getASResourceFactory();	// Create the registered singleton
			//			}
			//			else {
			INSTANCE = new EcoreASResourceFactory();										// Create our own singleton
			//			}
			assert INSTANCE != null;
			INSTANCE.install("ecore", null);
		}
		assert INSTANCE != null;
		return INSTANCE;
	}

	public EcoreASResourceFactory() {
		super(ASResource.ECORE_CONTENT_TYPE, null);
	}

	@Override
	public @NonNull Resource createResource(URI uri) {
		assert uri != null;
		StandardLibraryContribution standardLibraryContribution = OCLASResourceFactory.REGISTRY.get(uri);
		if (standardLibraryContribution != null) {
			return standardLibraryContribution.getResource();
		}
		ASResource asResource = new EcoreASResourceImpl(uri, this);
		configureResource(asResource);
		return asResource;
	}

	@Override
	public @Nullable <T extends Element> T getASElement(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Class<T> pivotClass, @NonNull EObject eObject) {
		return environmentFactory.getMetamodelManager().getASOfEcore(pivotClass, eObject);
	}

	@Override
	public @NonNull ASResourceFactory getASResourceFactory() {
		return getInstance();
	}

	@Override
	public @Nullable URI getPackageURI(@NonNull EObject eObject) {
		if (eObject instanceof EPackage) {
			String uri = ((EPackage)eObject).getNsURI();
			if (uri != null) {
				return URI.createURI(uri);
			}
		}
		return null;
	}

	@Override
	public @Nullable Integer getPriority() {
		return 100;
	}

	@Override
	public @Nullable Element importFromResource(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Resource ecoreResource, @Nullable URI uri) {
		Ecore2AS conversion = Ecore2AS.getAdapter(ecoreResource, environmentFactory);
		conversion.setEcoreURI(uri != null ? uri.trimFragment() : null);
		Model pivotModel = conversion.getASModel();
		String uriFragment = uri != null ? uri.fragment() : null;
		if (uriFragment == null) {
			return pivotModel;
		}
		else {
			EObject eObject = ecoreResource.getEObject(uriFragment);
			if (eObject == null) {
				return null;
			}
			return conversion.getCreated(eObject);
		}
	}

	@Override
	public void initializeEValidatorRegistry(org.eclipse.emf.ecore.EValidator.@NonNull Registry eValidatorRegistry) {
		// as of Photon M4 OCL embedded in Ecore is validated by EAnnotationValidators
		if (PivotEAnnotationValidator.getEAnnotationValidatorRegistry() == null) {
			eValidatorRegistry.put(EcorePackage.eINSTANCE, EcoreOCLEValidator.NO_NEW_LINES);
		}
	}
}
