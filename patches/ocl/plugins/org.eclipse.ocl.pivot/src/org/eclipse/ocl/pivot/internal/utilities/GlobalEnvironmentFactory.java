/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

import com.google.common.collect.MapMaker;

/**
 * The sole instance of GlobalEnvironmentFactory provides the OCL in global contexts such as the
 * execution of OCL delegates for which there is no OCL application to provide a customized OCL
 * with additional Complete OCL documents or optimized project lists. The global OCL uses a
 * global ProjectManager providing access to all models on the standalone classpath or in the
 * Eclipse workspace.
 */
@Deprecated /* @deprecated obsoleted by ThreadLocalExecutor's EnvironmentFactory */
public class GlobalEnvironmentFactory extends AbstractEnvironmentFactory
{
	/**
	 * An GlobalEnvironmentFactory.Listener reports GlobalEnvironmentFactory disposal to
	 * consumers such as OCLDelegateDomains that need to clean up when their OCL support vanishes.
	 */
	public interface Listener
	{
		/**
		 * Respond to disposal of the EnvironmentFactory by eliminating all further usage.
		 */
		void environmentFactoryDisposed(@NonNull EnvironmentFactory environmentFactory);
	}

	protected class UnloadResourceAdapter extends AdapterImpl implements Listener
	{
		@Override
		public void environmentFactoryDisposed(@NonNull EnvironmentFactory environmentFactory) {
			Notifier target2 = getTarget();
			if (target2 != null) {
				target2.eAdapters().remove(this);
			}
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			assert oldTarget instanceof Resource;
			PivotMetamodelManager metamodelManager = basicGetMetamodelManager();
			if (metamodelManager != null) {
				metamodelManager.removeExternalResource((Resource)oldTarget);
			}
			ResourceSet externalResourceSet2 = getResourceSet();
			if (externalResourceSet2 instanceof ResourceSetImpl) {
				List<URI> deadKeys = new ArrayList<URI>();
				Map<URI, Resource> uriResourceMap = ((ResourceSetImpl)externalResourceSet2).getURIResourceMap();
				for (Map.Entry<URI, Resource> entry : uriResourceMap.entrySet()) {
					if (entry.getValue() == oldTarget) {
						deadKeys.add(entry.getKey());
					}
				}
				for (URI deadKey : deadKeys) {
					uriResourceMap.remove(deadKey);
				}
			}
			super.unsetTarget(oldTarget);
		}
	}

	private static @Nullable GlobalEnvironmentFactory INSTANCE = null;

	/**
	 * Return the global EnvironmentFactory that may be shared amongst OCL consumers or
	 * null if none has been created.
	 */
	public static @Nullable GlobalEnvironmentFactory basicGetInstance() {
		return INSTANCE;
	}

	private static @NonNull ResourceSet createGlobalResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		ConcurrentMap<URI, Resource> weakMap = new MapMaker().weakValues().makeMap();
		resourceSet.setURIResourceMap(weakMap);	// Must use weak values to allow garbage collection of stale models
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl()); //$NON-NLS-1$
		ASResourceFactoryRegistry.INSTANCE.configureResourceSets(null, resourceSet);
		return resourceSet;
	}

    /**
     * Dispose of the global instance; this is intended for leakage detection in tests.
     */
	public static void disposeInstance() {
		GlobalEnvironmentFactory instance = INSTANCE;
		if (instance != null) {
//			PivotUtilInternal.debugPrintln("Dispose Global " + NameUtil.debugSimpleName(INSTANCE));
			instance.dispose();
		}
	}

	/**
	 * Return the global EnvironmentFactory that may be shared amongst OCL consumers for which Complete OCL
	 * complements are not possible. Typically this is the OCLDelegateDomains that supported interpreted
	 * execution of OCL embedded in Ecore.
	 */
	public static @NonNull GlobalEnvironmentFactory getInstance() {
		GlobalEnvironmentFactory instance = INSTANCE;
		if (instance == null) {
			INSTANCE = instance = new GlobalEnvironmentFactory();
//			PivotUtilInternal.debugPrintln("Create Global " + NameUtil.debugSimpleName(INSTANCE));
		}
//		else {
//			PivotUtilInternal.debugPrintln("Re-use Global " + NameUtil.debugSimpleName(INSTANCE));
//		}
		return instance;
	}

	/**
	 * Re-enable safe navigation validations.
	 */
	public static void resetSafeNavigationValidations() {
		if (INSTANCE != null) {
			INSTANCE.resetSeverities();
		}
	}

	/**
	 * EnvironmentFactoryListener instances to be notified of significant state changes; most notably disposal.
	 */
	private @Nullable List<Listener> listeners = null;

    private GlobalEnvironmentFactory() {
		super(ProjectManager.CLASS_PATH, createGlobalResourceSet(), null);
//		System.out.println("GlobalEnvironmentFactory()");
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			getProjectManager().initializeResourceSet(null);
		}
	}

	@Override
	public void addExternal2AS(@NonNull External2AS external2as) {
		super.addExternal2AS(external2as);
		Resource esResource = external2as.getResource();
		if (esResource != null) {
			UnloadResourceAdapter adapter = new UnloadResourceAdapter();
			esResource.eAdapters().add(adapter);
			addListener(adapter);
		}
	}

	public void addListener(@NonNull Listener listener) {
		List<Listener> listeners2 = listeners;
		if (listeners2 == null) {
			listeners = listeners2 = new ArrayList<Listener>();
		}
		if (!listeners2.contains(listener)) {
			listeners2.add(listener);
		}
	}

	@Override
	protected void disposeInternal() {
		assert this == INSTANCE;
		INSTANCE = null;
		if (listeners != null) {
			List<Listener> savedListeners = listeners;
			listeners = null;
			for (Listener listener : savedListeners) {
				listener.environmentFactoryDisposed(this);
			}
		}
		super.disposeInternal();
	}

	public void removeListener(@NonNull Listener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}
}
