/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.resource.EnvironmentFactoryAdapter;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;

public class OCLInternal extends OCL
{
	public static @NonNull EnvironmentFactoryAdapter adapt(@NonNull Notifier notifier) {
		List<Adapter> eAdapters = ClassUtil.nonNullEMF(notifier.eAdapters());
		EnvironmentFactoryAdapter adapter = ClassUtil.getAdapter(EnvironmentFactoryAdapter.class, eAdapters);
		if (adapter == null) {
			ProjectManager projectMap = null;
			ResourceSet resourceSet = null;
			if (notifier instanceof ResourceSet) {
				resourceSet = (ResourceSet) notifier;
				projectMap = BasicProjectManager.findAdapter(resourceSet);
			}
			if (projectMap == null) {
				projectMap = BasicProjectManager.createDefaultProjectManager();
			}
			EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectMap, resourceSet);
			adapter = EnvironmentFactoryAdapter.find(notifier);
			if (adapter == null) {
				adapter = new EnvironmentFactoryAdapter(environmentFactory, notifier);
				eAdapters.add(adapter);
			}
			assert adapter != null;
			assert adapter.getEnvironmentFactory() == environmentFactory;
		}
		return adapter;
	}

	public static @NonNull OCLInternal newInstance() {
		return newInstance((ResourceSet)null);
	}

	/**
	 * @since 1.3
	 */
	public static @NonNull OCLInternal newInstance(@Nullable ResourceSet resourceSet) {
		return newInstance(BasicProjectManager.createDefaultProjectManager(), resourceSet);
	}

	public static @NonNull OCLInternal newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {
		EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE.createEnvironmentFactory(projectManager, externalResourceSet);
		OCLInternal ocl = newInstance(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return ocl;
	}

	public static @NonNull OCLInternal newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new OCLInternal(environmentFactory);
	}

	public OCLInternal(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		assert environmentFactory != null;
		return environmentFactory;
	}

	@Override
	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		assert environmentFactory != null;
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull StandardLibraryInternal getStandardLibrary() {
		assert environmentFactory != null;
		return environmentFactory.getStandardLibrary();
	}
}
