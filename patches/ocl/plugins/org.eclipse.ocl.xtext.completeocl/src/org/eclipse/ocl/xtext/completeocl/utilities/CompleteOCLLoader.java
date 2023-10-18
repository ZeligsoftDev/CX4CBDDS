/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (Obeo) - Add complete ocl registry to enable export and re-use CompleteOCL files
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.External2AS;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;

public abstract class CompleteOCLLoader
{  // FIXME This is a pragmatic re-use. Redesign as part of a coherent API.
	protected final @NonNull OCLInternal ocl;
	protected final @NonNull List<Model> oclModels = new ArrayList<Model>();
	protected final @NonNull Set<EPackage> mmPackages;

	public CompleteOCLLoader(@NonNull EnvironmentFactory environmentFactory) {
		this.ocl = OCLInternal.newInstance((EnvironmentFactoryInternal)environmentFactory);
		this.mmPackages = new HashSet<EPackage>();
	}

	public void dispose() {
		ocl.dispose();
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return ocl.getEnvironmentFactory();
	}

	public @NonNull MetamodelManager getMetamodelManager() {
		return ocl.getMetamodelManager();
	}

	public boolean loadMetamodels() {
		for (Resource resource : ocl.getResourceSet().getResources()) {
			assert resource != null;
			External2AS ecore2as = Ecore2AS.findAdapter(resource, ocl.getEnvironmentFactory());
			if (ecore2as == null) {			// Pivot has its own validation
				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
					EObject eObject = tit.next();
					EClass eClass = eObject.eClass();
					if (eClass != null) {
						EPackage mmPackage = eClass.getEPackage();
						if (mmPackage != null) {
							mmPackages.add(mmPackage);
						}
					}
				}
 			}
		}
		Set<Resource> mmResources = new HashSet<Resource>();
		for (@SuppressWarnings("null")@NonNull EPackage mmPackage : mmPackages) {
			Resource mmResource = EcoreUtil.getRootContainer(mmPackage).eResource();
			if (mmResource != null) {
				mmResources.add(mmResource);
			}
		}
		for (Resource mmResource : mmResources) {
			assert mmResource != null;
			try {
				Element pivotModel = ocl.getEnvironmentFactory().loadResource(mmResource, null);
				if (pivotModel != null) {
					List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = pivotModel.eResource().getErrors();
					assert errors != null;
					String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
					if (message != null) {
						return error("Failed to load Pivot from '" + mmResource.getURI(), message);
					}
				}
				else {
					return error("Failed to load Pivot from '" + mmResource.getURI(), "");
				}
			} catch (ParserException e) {
				return error("Failed to load Pivot from '" + mmResource.getURI(), e.getMessage());
			}
		}
		return true;
	}

	protected abstract boolean error(@NonNull String primaryMessage, @Nullable String detailMessage);

	public void installPackages() {
		//
		//	Install validation for all the complemented packages
		//
		PivotEObjectValidator.install(ocl.getResourceSet(), ocl.getEnvironmentFactory());
		for (EPackage mmPackage : mmPackages) {
			assert mmPackage != null;
			PivotEObjectValidator.install(mmPackage, oclModels);
		}
	}

	public boolean loadDocument(@NonNull URI oclURI) {
		Resource resource = loadResource(oclURI);
		if (resource == null) {
			return false;
		}
		//
		//	Identify the packages which the Complete OCL document complements.
		//
		MetamodelManagerInternal metamodelManager = ocl.getMetamodelManager();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				org.eclipse.ocl.pivot.Package aPackage = metamodelManager.getPrimaryPackage((org.eclipse.ocl.pivot.Package)eObject);
				if (aPackage instanceof PivotObjectImpl) {
					EObject mmPackage = ((PivotObjectImpl)aPackage).getESObject();
					if (mmPackage instanceof EPackage) {
						mmPackages.add((EPackage)mmPackage);
					}
				}
			}
			else if (eObject instanceof Type) {
				tit.prune();
			}
			else if (eObject instanceof Model) {
				oclModels .add((Model)eObject);
			}
		}
		return true;
	}

	/**
	 * Load the Xtext resource from oclURI, then convert it to a pivot representation and return it.
	 * Return null after invoking error() to display any errors in a pop-up.
	 */
	public Resource loadResource(@NonNull URI oclURI) {
		CSResource xtextResource = null;
		CompleteOCLStandaloneSetup.init();
		ResourceSet resourceSet = ocl.getResourceSet();
		try {
			xtextResource = (CSResource) resourceSet.getResource(oclURI, true);
		}
		catch (WrappedException e) {
			URI retryURI = null;
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				IStatus status = ((CoreException)cause).getStatus();
				if ((status.getCode() == IResourceStatus.RESOURCE_NOT_FOUND) && status.getPlugin().equals(ResourcesPlugin.PI_RESOURCES)) {
					if (oclURI.isPlatformResource()) {
						retryURI = URI.createPlatformPluginURI(oclURI.toPlatformString(false), false);
					}
				}
			}
			if (retryURI != null) {
				xtextResource = (CSResource) resourceSet.getResource(retryURI, true);
			}
			else {
				throw e;
			}
		}
		List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> errors = xtextResource.getErrors();
		assert errors != null;
		String message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			error("Failed to load '" + oclURI, message);
			return null;
		}
		Resource asResource = xtextResource.getASResource();
		errors = asResource.getErrors();
		assert errors != null;
		message = PivotUtil.formatResourceDiagnostics(errors, "", "\n");
		if (message != null) {
			error("Failed to load Pivot from '" + oclURI, message);
			return null;
		}
		return asResource;
	}
}
