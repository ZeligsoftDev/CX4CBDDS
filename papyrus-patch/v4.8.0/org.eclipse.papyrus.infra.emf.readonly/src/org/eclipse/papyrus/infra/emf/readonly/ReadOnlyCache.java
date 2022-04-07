/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.readonly;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler.ResourceReadOnlyCache;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

/**
 * A transaction-scoped cache of read-only states of resources and objects.
 */
class ReadOnlyCache {

	private static final ThreadLocal<ReadOnlyCache> context = new ThreadLocal<ReadOnlyCache>();

	private final ReadOnlyManager manager;
	private final Executor executor;

	private Map<Set<URI>, ReadOnlyState> resourceReadOnlyStates;
	private Map<EObject, ReadOnlyState> objectReadOnlyStates;
	private ConcurrentMap<AbstractReadOnlyHandler, ConcurrentMap<URI, ReadOnlyState>> handlerResourceReadOnlyCache;

	static {
		// Install the resource read-only cache provider
		AbstractReadOnlyHandler.setResourceReadOnlyCacheProvider(new ResourceReadOnlyCacheProvider());
	}

	ReadOnlyCache(ReadOnlyManager manager, Executor executor) {
		super();

		this.manager = manager;
		this.executor = executor;
	}

	/**
	 * Creates a read-only cache for the specified read-only {@code manager}.
	 * 
	 * @param manager
	 *            a read-only manager
	 * @param executor
	 *            an asynchronous executor on which the cache may post tasks that it needs to defer, in particular
	 *            its own expiry
	 * 
	 * @return an appropriate cache, which may be one that doesn't actually cache anything (if necessary), but never {@code null}
	 */
	static ReadOnlyCache create(ReadOnlyManager manager, Executor executor) {
		ReadOnlyCache result = new ReadOnlyCache(manager, executor);
		if (Platform.inDebugMode()) {
			Activator.log.info("Read-only cache activated for manager: " + manager); //$NON-NLS-1$
		}

		return result;
	}

	/**
	 * Disposes me.
	 */
	public void dispose() {
		clear();

		if (Platform.inDebugMode()) {
			Activator.log.info("Read-only cache deactivated for manager: " + manager); //$NON-NLS-1$
		}
	}

	/**
	 * Queries the cached read-only state of some resources for a specific set of axes.
	 * 
	 * @param axes
	 *            the read-only axes to query
	 * @param uris
	 *            the resource URIs to query
	 * 
	 * @return the previously cached read-only state, or {@code null} if it has not previously been cached
	 */
	public Optional<Boolean> getResources(Set<ReadOnlyAxis> axes, Set<URI> uris) {
		final Map<Set<URI>, ReadOnlyState> resourceReadOnlyStates = getResourceReadOnlyStates();
		ReadOnlyState state = (resourceReadOnlyStates == null) ? null : resourceReadOnlyStates.get(uris);
		return (state == null) ? null : state.get(axes);
	}

	/**
	 * Queries the cached read-only state of an object for a specific set of axes.
	 * 
	 * @param axes
	 *            the read-only axes to query
	 * @param object
	 *            the object to query
	 * 
	 * @return the previously cached read-only state, or {@code null} if it has not previously been cached
	 */
	public Optional<Boolean> getObject(Set<ReadOnlyAxis> axes, EObject object) {
		final Map<EObject, ReadOnlyState> objectReadOnlyStates = getObjectReadOnlyStates();
		ReadOnlyState state = (objectReadOnlyStates == null) ? null : objectReadOnlyStates.get(object);
		return (state == null) ? null : state.get(axes);
	}

	/**
	 * Caches the read-only state of some resources for a specific set of axes.
	 * 
	 * @param axes
	 *            the read-only axes to cache
	 * @param uris
	 *            the resource URIS to cache
	 * @param readOnly
	 *            the read-only state to cache
	 */
	public void putResources(Set<ReadOnlyAxis> axes, Set<URI> uris, Optional<Boolean> readonly) {
		final Map<Set<URI>, ReadOnlyState> resourceReadOnlyStates = getResourceReadOnlyStates();
		if (resourceReadOnlyStates != null) {
			ReadOnlyState state = resourceReadOnlyStates.get(uris);
			if (state == null) {
				state = new ReadOnlyState();
				resourceReadOnlyStates.put(uris, state);
			}
			state.put(axes, readonly);
		}
	}

	/**
	 * Caches the read-only state of an object for a specific set of axes.
	 * 
	 * @param axes
	 *            the read-only axes to cache
	 * @param object
	 *            the object to cache
	 * @param readOnly
	 *            the read-only state to cache
	 */
	public void putObject(Set<ReadOnlyAxis> axes, EObject object, Optional<Boolean> readonly) {
		final Map<EObject, ReadOnlyState> objectReadOnlyStates = getObjectReadOnlyStates();
		if (objectReadOnlyStates != null) {
			ReadOnlyState state = objectReadOnlyStates.get(object);
			if (state == null) {
				state = new ReadOnlyState();
				objectReadOnlyStates.put(object, state);
			}
			state.put(axes, readonly);
		}
	}

	/**
	 * Clears the current cached read-only states so that they will be recomputed if needed again during the transaction.
	 * This is necessary, for example, after resources and/or objects have been made writable that were previously read-only.
	 */
	public synchronized void clear() {
		resourceReadOnlyStates = null;
		objectReadOnlyStates = null;
		handlerResourceReadOnlyCache = null;
	}

	private Map<Set<URI>, ReadOnlyState> getResourceReadOnlyStates() {
		if (resourceReadOnlyStates == null) {
			initCache();
		}
		return resourceReadOnlyStates;
	}

	private Map<EObject, ReadOnlyState> getObjectReadOnlyStates() {
		if (objectReadOnlyStates == null) {
			initCache();
		}
		return objectReadOnlyStates;
	}

	private ConcurrentMap<AbstractReadOnlyHandler, ConcurrentMap<URI, ReadOnlyState>> getHandlerResourceReadOnlyCache() {
		if (handlerResourceReadOnlyCache == null) {
			initCache();
		}
		return handlerResourceReadOnlyCache;
	}

	private synchronized void initCache() {
		if (resourceReadOnlyStates == null) {
			resourceReadOnlyStates = Maps.newHashMap();
		}
		if (objectReadOnlyStates == null) {
			objectReadOnlyStates = Maps.newHashMap();
		}
		if (handlerResourceReadOnlyCache == null) {
			handlerResourceReadOnlyCache = Maps.newConcurrentMap();
		}

		// Schedule my expiry
		executor.execute(new Runnable() {
			public void run() {
				clear();
			}
		});
	}

	/**
	 * Runs an operation in the context of my owning {@link ReadOnlyManager}. The construction of {@link IReadOnlyHandler}s
	 * should be performed in an operation via this method.
	 * 
	 * @param operation
	 *            a read-only manager operation
	 */
	void run(Runnable operation) {
		final ReadOnlyCache previous = context.get();
		context.set(this);
		try {
			operation.run();
		} finally {
			if (previous == null) {
				context.remove();
			} else {
				context.set(previous);
			}
		}
	}

	ResourceReadOnlyCache getResourceReadOnlyCache(final AbstractReadOnlyHandler handler) {
		return new ResourceReadOnlyCache() {
			public Optional<Boolean> get(Set<ReadOnlyAxis> axes, URI resourceURI) {
				Optional<Boolean> result;
				// Only read it once in case of concurrent access by non-transactions
				final Map<AbstractReadOnlyHandler, ? extends Map<URI, ReadOnlyState>> handlerResourceReadOnlyCache = getHandlerResourceReadOnlyCache();

				if (handlerResourceReadOnlyCache == null) {
					result = null;
				} else {
					Map<URI, ReadOnlyState> forHandler = handlerResourceReadOnlyCache.get(handler);
					if (forHandler == null) {
						result = null;
					} else {
						ReadOnlyState state = forHandler.get(resourceURI);
						result = (state == null) ? null : state.get(axes);
					}
				}

				return result;
			}

			public void put(Set<ReadOnlyAxis> axes, URI resourceURI, Optional<Boolean> readOnlyState) {
				// Only read it once in case of concurrent access by non-transactions
				final ConcurrentMap<AbstractReadOnlyHandler, ConcurrentMap<URI, ReadOnlyState>> handlerResourceReadOnlyCache = getHandlerResourceReadOnlyCache();

				if (handlerResourceReadOnlyCache != null) {
					ConcurrentMap<URI, ReadOnlyState> forHandler = handlerResourceReadOnlyCache.get(handler);
					if (forHandler == null) {
						handlerResourceReadOnlyCache.putIfAbsent(handler, Maps.<URI, ReadOnlyState> newConcurrentMap());
						forHandler = handlerResourceReadOnlyCache.get(handler);
					}

					ReadOnlyState state = forHandler.get(resourceURI);
					if (state == null) {
						forHandler.putIfAbsent(resourceURI, new ReadOnlyState());
						state = forHandler.get(resourceURI);
					}

					state.put(axes, readOnlyState);
				}
			}

			public void clear() {
				ReadOnlyCache.this.clear();
			}
		};
	}

	//
	// Nested types
	//

	private static class ReadOnlyState extends HashMap<Set<ReadOnlyAxis>, Optional<Boolean>> {
		private static final long serialVersionUID = 1L;

	}

	private static class ResourceReadOnlyCacheProvider implements AbstractReadOnlyHandler.ResourceReadOnlyCache.Provider {
		private ResourceReadOnlyCacheProvider() {
			super();
		}

		public ResourceReadOnlyCache get(AbstractReadOnlyHandler handler) {
			ResourceReadOnlyCache result = null;

			// Can only cache resource read-only states if we have the context for it
			ReadOnlyCache cache = context.get();
			if (cache != null) {
				result = cache.getResourceReadOnlyCache(handler);
			}

			return result;
		}
	}
}
