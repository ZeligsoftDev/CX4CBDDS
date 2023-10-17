/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * An OCLAdapter extends an EnvironmentFactoryAdapter so that the lifetime
 * of the OCL for a ResourceSet terminates with the ResourceSet adapter. If the
 * ResourceSet is the AdapterFactoryEditingDomainResourceSet of an Ecore Editor,
 * an AdapterFactory is registered to ensure that the OCLAdapter disposes with
 * the editor rather than locking it into memory.
 */
public class OCLAdapter extends EnvironmentFactoryAdapter implements AdapterFactory, IDisposable
{
	public static @NonNull EnvironmentFactoryInternal createEnvironmentFactory(@NonNull ProjectManager projectManager, @NonNull Notifier notifier) {
		OCLInternal ocl = OCLInternal.newInstance(projectManager, null);		// FIXME Two StandaloneProjectMap intances
		OCLAdapter adapter = new OCLAdapter(ocl, notifier);
		notifier.eAdapters().add(adapter);
		return adapter.getEnvironmentFactory();
	}

	public static @NonNull EnvironmentFactoryInternal createEnvironmentFactory( @NonNull Notifier notifier) {
		return createEnvironmentFactory(BasicProjectManager.createDefaultProjectManager(), notifier);
	}

	public static @NonNull OCLAdapter getAdapter(@NonNull ResourceSet resourceSet) {
		@SuppressWarnings("null")@NonNull List<Adapter> eAdapters = resourceSet.eAdapters();
		OCLAdapter oclAdapter = ClassUtil.getAdapter(OCLAdapter.class, eAdapters);
		if (oclAdapter == null) {
			EnvironmentFactoryAdapter environmentFactoryAdapter = ClassUtil.getAdapter(EnvironmentFactoryAdapter.class, resourceSet);
			if (environmentFactoryAdapter != null) {
				oclAdapter = new OCLAdapter(OCLInternal.newInstance(environmentFactoryAdapter.getEnvironmentFactory()), resourceSet);
			}
			else {
				OCLInternal ocl = OCLInternal.newInstance(BasicProjectManager.createDefaultProjectManager(), resourceSet);
				oclAdapter = new OCLAdapter(ocl, resourceSet);
			}
			eAdapters.add(oclAdapter);
		}
		return oclAdapter;
	}

	protected OCL ocl;				// Set null once disposed

	protected OCLAdapter(@NonNull OCLInternal ocl, @NonNull Notifier notifier) {
		super(ocl.getEnvironmentFactory(), notifier);
		this.ocl = ocl;
		//
		//	Ecore Editors do not unload their ResourceSet, so try to install this as an AdapterFactory to detect Ecore Editor dispose().
		//
		if (notifier instanceof IEditingDomainProvider) {
			EditingDomain editingDomain = ((IEditingDomainProvider)notifier).getEditingDomain();
			if (editingDomain instanceof AdapterFactoryEditingDomain) {
				AdapterFactory adapterFactory = ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();
				if (adapterFactory instanceof ComposedAdapterFactory) {
					ComposedAdapterFactory composedAdapterFactory = (ComposedAdapterFactory)adapterFactory;
					composedAdapterFactory.addAdapterFactory(this);
				}
			}
		}
	}

	@Override
	public Adapter adapt(Notifier target, Object type) {
		return null;
	}

	@Override
	public Object adapt(Object object, Object type) {
		return null;
	}

	@Override
	public void adaptAllNew(Notifier notifier) {
	}

	@Override
	public Adapter adaptNew(Notifier target, Object type) {
		return null;
	}

	@Override
	public void dispose() {
		notifier.eAdapters().remove(this);
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return super.isAdapterForType(type) || (type == OCLAdapter.class);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		super.unsetTarget(oldTarget);
		OCL ocl2 = ocl;
		if (ocl2 != null) {
			ocl = null;
			if (notifier instanceof IEditingDomainProvider) {
				for (Adapter eAdapter : notifier.eAdapters()) {
					if (eAdapter instanceof EContentAdapter) {
						for (Library asLibrary : ((PivotMetamodelManager)ocl2.getMetamodelManager()).getLibraries()) {
							Resource resource = asLibrary.eResource();
							if ((resource != null) && (resource.getResourceSet() == null)){
								resource.eAdapters().remove(eAdapter);
							}
						}
					}
				}
			}
			ocl2.dispose();
		}
	}
}