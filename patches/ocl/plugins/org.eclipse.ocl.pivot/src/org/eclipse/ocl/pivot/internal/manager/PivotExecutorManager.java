/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.manager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorManager;
import org.eclipse.ocl.pivot.internal.library.executor.LazyEcoreModelManager;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;

/**
 * A PivotExecutorManager instance provides the bridge between a conventional EMF execution context
 * and the richer OCL Pivot concepts. Since the OCL concepts are not needed for simple expressions
 * that make no use of types, the default construction is lightweight deferring construction costs
 * until actually needed.
 *
 * A PivotExecutorManager and its associated caches may be attacjed to a ResourceSet for re-use by other OCL evaluations using the same ResojrceSet.
 */
public class PivotExecutorManager extends ExecutorManager
{
	/**
	 * @since 1.7
	 */
	public static @Nullable Adapter createAdapter(@NonNull EnvironmentFactory environmentFactory, @NonNull EObject ecoreObject) {
		Resource eResource = ecoreObject.eResource();
		if (eResource == null) {
			return null;
		}
		ResourceSet resourceSet = eResource.getResourceSet();
		if (resourceSet == null) {
			return null;
		}
		return new Adapter(environmentFactory, resourceSet, ecoreObject);
	}

	/**
	 * @since 1.7
	 */
	public static @Nullable Adapter findAdapter(@NonNull ResourceSet resourceSet) {
		for (org.eclipse.emf.common.notify.Adapter adapter : resourceSet.eAdapters()) {
			if (adapter instanceof Adapter) {
				return (Adapter)adapter;
			}
		}
		return null;
	}

	/**
	 * Remove any OCL Executor from the ResourceSet containing an eObject. This may be necessary to prevent
	 * re-use of the cached context of an earlier executor after a change to the models.
	 *
	 * @since 1.7
	 */
	public static void removeAdapter(@NonNull ResourceSet resourceSet) {
		EList<org.eclipse.emf.common.notify.Adapter> eAdapters = resourceSet.eAdapters();
		synchronized (eAdapters) {
			for (int i = eAdapters.size(); --i >= 0; ) {		// Should be at most one, but code to handle more
				org.eclipse.emf.common.notify.Adapter adapter = eAdapters.get(i);
				if (adapter instanceof PivotExecutorManager) {
					eAdapters.remove(i);
				}
			}
		}
	}

	private static class Adapter extends PivotExecutorManager implements org.eclipse.emf.common.notify.Adapter
	{
		private @NonNull ResourceSet resourceSet;

		private Adapter(@NonNull EnvironmentFactory environmentFactory, @NonNull ResourceSet resourceSet, @NonNull EObject contextObject) {
			super(environmentFactory, contextObject);
			this.resourceSet = resourceSet;
			resourceSet.eAdapters().add(this);
		}

		@Override
		public ResourceSet getTarget() {
			return resourceSet;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == Adapter.class;
		}

		@Override
		public void notifyChanged(Notification notification) {}

		@Override
		public void setTarget(Notifier newTarget) {}
	}

	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull IdResolver idResolver;
	protected final @NonNull EObject contextObject;
	private @Nullable ModelManager modelManager = null;

	public PivotExecutorManager(@NonNull EnvironmentFactory environmentFactory, @NonNull EObject contextObject) {
		super(environmentFactory.getCompleteEnvironment());
		this.environmentFactory = environmentFactory;
		this.idResolver = environmentFactory.getIdResolver();
		this.contextObject = contextObject;
		idResolver.addRoot(ClassUtil.nonNullEMF(EcoreUtil.getRootContainer(contextObject)));
	}

	protected @NonNull IdResolver createIdResolver() {
		return environmentFactory.getIdResolver();
	}

	@Override
	public @NonNull Type getDynamicTypeOf(@Nullable Object value) {
		return idResolver.getDynamicTypeOf(value);
	}

	/**
	 * @since 1.1
	 */
	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return idResolver;
	}

	@Override
	public @NonNull MetamodelManager getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	@Override
	public @NonNull ModelManager getModelManager() {
		ModelManager modelManager2 = modelManager;
		if (modelManager2 == null) {
			synchronized (this) {
				modelManager2 = modelManager;
				if (modelManager2 == null) {
					modelManager2 = modelManager = new LazyEcoreModelManager(contextObject);
				}
			}
		}
		return modelManager2;
	}

	@Override
	public int getSeverity(@Nullable Object validationKey) {
		StatusCodes.Severity severity = environmentFactory.getSeverity(validationKey);
		return severity != null ? severity.getStatusCode() : StatusCodes.WARNING;
	}

	@Override
	@Deprecated /* @deprecated getStaticTypeOfValue to enable TemplateParameters to be resolved */
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value) {
		return idResolver.getStaticTypeOf(value);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value,@Nullable Object @NonNull ... values) {
		return idResolver.getStaticTypeOf(value, values);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return idResolver.getStaticTypeOf(value, values);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOfValue(@Nullable Type staticType, @Nullable Object value) {
		return idResolver.getStaticTypeOfValue(staticType, value);
	}
}