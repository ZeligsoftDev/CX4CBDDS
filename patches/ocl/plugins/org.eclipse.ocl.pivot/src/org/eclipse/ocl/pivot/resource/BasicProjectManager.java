/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.ocl.pivot.resource;

import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;

/**
 * BasicProjectManager provides a default implementation of the ProjectManager API that should be used by
 * all clients. The default provides very lightweight functionality that contributes no external projects
 * to a user application and incurs no classpath analysis costs to do so.
 */
public class BasicProjectManager extends AdapterImpl implements ProjectManager
{
	public static @NonNull ProjectManager createDefaultProjectManager() {
		return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(false) : new StandaloneProjectMap(false);
	}

	public static @NonNull ProjectManager createGlobalProjectManager() {
		return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : new StandaloneProjectMap(true);
	}

	/**
	 * Return any {@link ProjectManager} already installed as an adapter on a
	 * <tt>resourceSet</tt>. Returns null if there is no such adapter.
	 */
	public static @Nullable ProjectManager findAdapter(@NonNull ResourceSet resourceSet) {
		for (Adapter adapter : resourceSet.eAdapters()) {
			if (adapter instanceof ProjectManager) {
				return (ProjectManager)adapter;
			}
		}
		return null;
	}

	public BasicProjectManager() {
		super();
	}

	@Override
	public void addResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor) {
	}

	@Override
	public void configure(@NonNull ResourceSet resourceSet, @NonNull IResourceLoadStrategy instance, @Nullable IConflictHandler instance2) {
	}

	@Override
	public void configureLoadFirst(@NonNull ResourceSet resourceSet, /*@NonNull*/ String nsURI) {
		URI ecoreURI = URI.createURI(nsURI);
		IPackageDescriptor packageDescriptor = getPackageDescriptor(ecoreURI);
		if (packageDescriptor != null) {
			packageDescriptor.configure(resourceSet, StandaloneProjectMap.LoadFirstStrategy.INSTANCE, null);
		}
	}

	@Override
	public IPackageDescriptor getPackageDescriptor(@NonNull URI ecoreURI) {
		return null;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public @Nullable IResourceDescriptor getResourceDescriptor(@NonNull URI uri) {
		return null;
	}

	@Override
	public void initializeResourceSet(@Nullable ResourceSet resourceSet) {
		if (resourceSet != null) {
			List<Adapter> eAdapters = resourceSet.eAdapters();
			if (!eAdapters.contains(this)) {
				eAdapters.add(this);
			}
		}
	}

	@Override
	public boolean isGlobal() {
		return false;
	}

	/**
	 * @since 1.3
	 */
	@Override
	public void removeResourceDescriptor(@NonNull IResourceDescriptor resourceDescriptor) {
	}

	@Override
	public void unload(@NonNull ResourceSet resourceSet) {
	}

	@Override
	public void useGeneratedResource(@NonNull Resource resource, @NonNull ResourceSet resourceSet) {
	}
}