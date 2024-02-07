/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.attributes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.internal.compatibility.EMF_2_9;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS.UnresolvedProxyMessageProvider;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.osgi.util.NLS;

public class ImportCSAttribution extends AbstractAttribution implements UnresolvedProxyMessageProvider
{
	public static final ImportCSAttribution INSTANCE = new ImportCSAttribution();

	private static class ImportAdapter extends AdapterImpl
	{
		private URI uri = null;
		private Element importedElement = null;
		private Throwable throwable = null;

		public ScopeView computeLookup(ImportCS targetElement, EnvironmentView environmentView, ScopeView scopeView) {
			String name = environmentView.getName();
			if (name != null) {				// Looking for a specific name
				importModel(targetElement, environmentView);
				Element importedElement2 = importedElement;
				if (importedElement2 != null) {
					Resource importedResource = importedElement2.eResource();
					if (importedResource != null) {
						List<Resource.Diagnostic> errors = importedResource.getErrors();
						if (errors.size() == 0) {
							environmentView.addElement(name, importedElement2);		// The name we imported must be a good name for the element
						}
					}
				}
			}
			else {							// looking for all possible names
				Map<String, URI> ePackageNsURIToGenModelLocationMap = EMF_2_9.EcorePlugin.getEPackageNsURIToGenModelLocationMap(true);
				for (String key : ePackageNsURIToGenModelLocationMap.keySet()) {
					environmentView.addElement(key, environmentView.getStandardLibrary().getOclVoidType());
				}
				// FIXME platform:/resource/... and local file names
			}
			return null;
		}

		public String getMessage() {
			return throwable != null ? throwable.toString() : null;
		}

		protected void importModel(ImportCS target, EnvironmentView environmentView) {
			String name = environmentView.getName();
			if (name == null) {
				return;
			}
			EnvironmentFactoryInternal environmentFactory = environmentView.getEnvironmentFactory();
			CompletePackage completePackage = environmentFactory.getCompleteModel().getCompletePackageByURI(name);
			if (completePackage != null) {
				Package pivotPackage = completePackage.getPrimaryPackage();
				if (pivotPackage != importedElement) {
					importedElement = pivotPackage;
					throwable = null;
				}
				return;
			}
			BaseCSResource csResource = (BaseCSResource) target.eResource();
			@NonNull URI uri2;
			try {
				@NonNull URI newURI = URI.createURI(name);
				newURI = csResource.resolve(newURI);
				if (newURI.equals(uri)) {
					return;
				}
				uri2 = uri = newURI;					// Lock out recursive attempt from EcoreUtil.resolveProxy
				importedElement = null;
				throwable = null;
			} catch (WrappedException e) {
				throwable = e.exception();
				return;
			} catch (Exception e) {
				throwable = e;
				return;
			}
			try {
				importedElement = environmentFactory.getMetamodelManager().loadResource(uri2, null, null);
				if (importedElement != null) {
					Resource importedResource = importedElement.eResource();
					if (importedResource != null) {
						if (importedResource instanceof ASResource) {
							((ASResource)importedResource).setSaveable(false);
						}
						List<Resource.Diagnostic> errors = importedResource.getErrors();
						if (errors.size() > 0) {
							//						INode node = NodeModelUtils.getNode(target);
							String errorMessage = PivotUtil.formatResourceDiagnostics(errors, StringUtil.bind(PivotMessagesInternal.ErrorsInURI, uri), "\n\t");
							throw new IOException(errorMessage);
							//						Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
							//						csResource.getErrors().add(resourceDiagnostic);
						}
						List<Resource.Diagnostic> warnings = importedResource.getWarnings();
						if (warnings.size() > 0) {
							//						INode node = NodeModelUtils.getNode(target);
							String warningMessage = PivotUtil.formatResourceDiagnostics(warnings, StringUtil.bind(PivotMessagesInternal.WarningsInURI, uri2), "\n\t");
							throw new IOException(warningMessage);
							//						Resource.Diagnostic resourceDiagnostic = new ValidationDiagnostic(node, errorMessage);
							//						csResource.getWarnings().add(resourceDiagnostic);
						}
					}
				}
			} catch (WrappedException e) {
				e.fillInStackTrace();
				throwable = e.exception();
			} catch (Throwable e) {
				e.fillInStackTrace();
				throwable = e;
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == ImportAdapter.class;
		}
	}

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ImportCS targetElement = (ImportCS)target;
		ImportAdapter adapter = ClassUtil.getAdapter(ImportAdapter.class, targetElement);
		if (adapter == null) {
			adapter = new ImportAdapter();
			targetElement.eAdapters().add(adapter);
		}
		return adapter.computeLookup(targetElement, environmentView, scopeView);
	}

	@Override
	public @NonNull EReference getEReference() {
		@SuppressWarnings("null") @NonNull EReference importCsNamespace = BaseCSPackage.Literals.IMPORT_CS__REFERRED_NAMESPACE;
		return importCsNamespace;
	}

	@Override
	public @Nullable String getMessage(@NonNull EObject context, @NonNull String linkText) {
		ImportAdapter adapter = ClassUtil.getAdapter(ImportAdapter.class, context);
		if (adapter != null) {
			String message = adapter.getMessage();
			return NLS.bind(PivotMessagesInternal.UnresolvedImport_ERROR_, linkText, message);
		}
		return null;
	}
}
