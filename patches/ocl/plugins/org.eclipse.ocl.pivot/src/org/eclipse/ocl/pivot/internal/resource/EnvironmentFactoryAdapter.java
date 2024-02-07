/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;

/**
 * An EnvironmentFactoryAdapter associates an EnvironmentFactory with a Resource or ResourceSet so
 * that algorithms can navigate from a Resource to re-use a shared EnvironmentFactory.
 */
public class EnvironmentFactoryAdapter implements Adapter.Internal
{
	public static void disposeAll(@NonNull Resource resource) {
		/*		List<Adapter> eAdapters = resource.eAdapters();
		for (int i = eAdapters.size(); --i >= 0; ) {
			Adapter adapter = eAdapters.get(i);
			if (adapter instanceof MetamodelManagerResourceAdapter) {
				eAdapters.remove(i);
			}
		} */
	}

	/**
	 * Return any EnvironmentFactoryAdapter already adapting this notofier.
	 */
	public static @Nullable EnvironmentFactoryAdapter find(@NonNull Notifier notifier) {
		synchronized (notifier) {
			List<Adapter> eAdapters = notifier.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof EnvironmentFactoryAdapter) {
					EnvironmentFactoryAdapter environmentFactoryAdapter = (EnvironmentFactoryAdapter)adapter;
					EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension) environmentFactoryAdapter.getEnvironmentFactory();
					if (!environmentFactory.isDisposed()) {
						return environmentFactoryAdapter;
					}
				}
			}
			return null;
		}
	}

	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull Notifier notifier;

	public EnvironmentFactoryAdapter(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Notifier notifier) {
		this.environmentFactory = environmentFactory;
		this.notifier = notifier;
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull PivotMetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull Notifier getTarget() {
		return notifier;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == EnvironmentFactoryAdapter.class;
	}

	@Override
	public void notifyChanged(Notification notification) {
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == notifier) || (newTarget == null);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		// TODO Auto-generated method stub
	}
}