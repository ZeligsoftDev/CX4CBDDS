/*****************************************************************************
 * Copyright (c) 2011, 2016 Atos Origin, CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - support non-IFile resources and object-level permissions (CDO)
 *  Christian W. Damus (CEA) - bugs 323802, 429826, 422257, 437217
 *  Christian W. Damus - bugs 457560, 463564, 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import static org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis.permissionAxes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyListener;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyEvent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;


public class ReadOnlyManager implements IReadOnlyHandler2 {

	// Use weak values because the values otherwise retain the keys (indirectly)
	protected static final ConcurrentMap<EditingDomain, IReadOnlyHandler2> roHandlers = new MapMaker().weakKeys().weakValues().makeMap();

	private final CopyOnWriteArrayList<IReadOnlyListener> listeners = new CopyOnWriteArrayList<IReadOnlyListener>();

	private final ReadOnlyCache cache;

	private IReadOnlyListener forwardingListener;

	public static IReadOnlyHandler2 getReadOnlyHandler(EditingDomain editingDomain) {
		IReadOnlyHandler2 roHandler = IReadOnlyHandler2.NULL;

		if (editingDomain != null) {
			roHandler = roHandlers.get(editingDomain);
			if (roHandler == null) {
				roHandler = new ReadOnlyManager(editingDomain);
				process((ReadOnlyManager) roHandler, editingDomain);
				IReadOnlyHandler2 existing = roHandlers.putIfAbsent(editingDomain, roHandler);
				if (existing != null) {
					// Another thread beat us to it since we checked for an existing instance
					((ReadOnlyManager) roHandler).cache.dispose();
					roHandler = existing;
				}
			}
		}

		return roHandler;
	}

	private static void process(ReadOnlyManager manager, EditingDomain domain) {
		Activator.getDefault().getReadOnlyManagerProcessors().forEach(p -> p.processReadOnlyManager(manager, domain));
	}

	protected static class HandlerPriorityPair implements Comparable<HandlerPriorityPair> {

		public Class<?> handlerClass;

		public int priority;

		public Set<ReadOnlyAxis> axes;

		@Override
		public int compareTo(HandlerPriorityPair o) {
			if (o.priority > priority) {
				return 1;
			} else if (o.priority < priority) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	protected static final Map<Class<?>, Set<ReadOnlyAxis>> orderedHandlerClasses;

	static {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.emf.readonly", "readOnlyHandler");

		List<HandlerPriorityPair> handlerPriorityPairs = new LinkedList<HandlerPriorityPair>();
		Map<String, HandlerPriorityPair> idMap = new HashMap<String, HandlerPriorityPair>();

		for (IConfigurationElement elem : configElements) {
			if ("readOnlyHandler".equals(elem.getName())) {
				try {
					HandlerPriorityPair handlerPriorityPair = new HandlerPriorityPair();
					String className = elem.getAttribute("class");
					handlerPriorityPair.handlerClass = Platform.getBundle(elem.getContributor().getName()).loadClass(className);

					handlerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));

					IConfigurationElement[] affinities = elem.getChildren("affinity");
					if ((affinities == null) || (affinities.length == 0)) {
						// implicit affinity is with any axis
						handlerPriorityPair.axes = ReadOnlyAxis.anyAxis();
					} else {
						handlerPriorityPair.axes = EnumSet.noneOf(ReadOnlyAxis.class);
						for (IConfigurationElement next : affinities) {
							handlerPriorityPair.axes.add(ReadOnlyAxis.valueOf(next.getAttribute("axis").toUpperCase()));
						}
					}

					String id = elem.getAttribute("id");
					if (id != null) {
						// if any then the handler could be overrided by another registration
						HandlerPriorityPair oldHandler = idMap.get(id);
						if (oldHandler == null) {
							idMap.put(id, handlerPriorityPair);
							handlerPriorityPairs.add(handlerPriorityPair);
						} else {
							if (oldHandler.priority < handlerPriorityPair.priority) {
								handlerPriorityPairs.remove(oldHandler);
								handlerPriorityPairs.add(handlerPriorityPair);
							}
						}
					} else {
						// If none the handler can not be overrided
						handlerPriorityPairs.add(handlerPriorityPair);
					}
				} catch (Throwable t) {
					// FIXME: We need to catch Throwables because we rely on external contributions. It is required to also catch Errors (such as compilation errors).
					// Move this code to an initialization method, because if a throwable is not caught, this will prevent the whole class initialization
					Activator.log.error(t);
				}
			}
		}

		Collections.sort(handlerPriorityPairs);

		orderedHandlerClasses = new LinkedHashMap<Class<?>, Set<ReadOnlyAxis>>();

		for (HandlerPriorityPair next : handlerPriorityPairs) {
			orderedHandlerClasses.put(next.handlerClass, next.axes);
		}
	}


	@SuppressWarnings("deprecation")
	protected static IReadOnlyHandler2 create(final Class<?> handlerClass, EditingDomain editingDomain) {
		boolean isEditingDomainConstructor = true;
		Constructor<?> constructor = null;
		try {
			constructor = handlerClass.getConstructor(EditingDomain.class);
			if (constructor == null) {
				isEditingDomainConstructor = false;
				constructor = handlerClass.getConstructor();
			}

			if (IReadOnlyHandler2.class.isAssignableFrom(constructor.getDeclaringClass())) {
				if (isEditingDomainConstructor) {
					return (IReadOnlyHandler2) constructor.newInstance(editingDomain);
				} else {
					return (IReadOnlyHandler2) constructor.newInstance();
				}
			} else if (IReadOnlyHandler.class.isAssignableFrom(constructor.getDeclaringClass())) {
				if (isEditingDomainConstructor) {
					return AbstractReadOnlyHandler.adapt((IReadOnlyHandler) constructor.newInstance(editingDomain), editingDomain);
				} else {
					return AbstractReadOnlyHandler.adapt((IReadOnlyHandler) constructor.newInstance(), editingDomain);
				}
			} else if (org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler.class.isAssignableFrom(constructor.getDeclaringClass())) {
				return new OldStyleHandlerAdapter((org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler) constructor.newInstance(), editingDomain);
			}
		} catch (Exception e) {
		}

		return null;
	}

	protected Map<ReadOnlyAxis, IReadOnlyHandler2[]> orderedHandlersByAxis;

	public ReadOnlyManager(final EditingDomain editingDomain) {
		// Create our transaction cache
		cache = ReadOnlyCache.create(this, Activator.getDefault().getReadOnlyCacheExecutor());

		final Map<ReadOnlyAxis, List<IReadOnlyHandler2>> handlers = new EnumMap<ReadOnlyAxis, List<IReadOnlyHandler2>>(ReadOnlyAxis.class);
		cache.run(new Runnable() {

			@Override
			public void run() {
				for (Map.Entry<Class<?>, Set<ReadOnlyAxis>> roClass : orderedHandlerClasses.entrySet()) {
					IReadOnlyHandler2 h = create(roClass.getKey(), editingDomain);
					if (h != null) {
						h.addReadOnlyListener(getForwardingListener());

						for (ReadOnlyAxis axis : roClass.getValue()) {
							List<IReadOnlyHandler2> list = handlers.get(axis);
							if (list == null) {
								list = new ArrayList<IReadOnlyHandler2>();
								handlers.put(axis, list);
							}
							list.add(h);
						}
					}
				}
			}
		});

		// Iterate the enumeration to make sure all axes are represented (even if only by an empty array)
		orderedHandlersByAxis = new EnumMap<ReadOnlyAxis, IReadOnlyHandler2[]>(ReadOnlyAxis.class);
		for (ReadOnlyAxis axis : ReadOnlyAxis.values()) {
			List<IReadOnlyHandler2> list = handlers.get(axis);
			if (list == null) {
				orderedHandlersByAxis.put(axis, new IReadOnlyHandler2[0]);
			} else {
				orderedHandlersByAxis.put(axis, list.toArray(new IReadOnlyHandler2[list.size()]));
			}
		}
	}

	@Override
	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		final Set<URI> uriSet = ImmutableSet.copyOf(uris);
		Optional<Boolean> result = cache.getResources(axes, uriSet);
		if (result == null) {
			result = Optional.absent();

			ReadOnlyAxis[] all = ReadOnlyAxis.values();
			for (int i = 0; (i < all.length) && !result.or(Boolean.FALSE); i++) {
				if (axes.contains(all[i])) {
					result = anyReadOnly(all[i], uris);
				}
			}

			cache.putResources(axes, uriSet, result);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	private Optional<Boolean> anyReadOnly(ReadOnlyAxis axis, URI[] uris) {
		final Set<URI> uriSet = ImmutableSet.copyOf(uris);
		Set<ReadOnlyAxis> axes = axis.singleton();
		Optional<Boolean> result = cache.getResources(axes, uriSet);
		if (result == null) {
			result = Optional.absent();

			IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
			for (int i = 0; (i < orderedHandlers.length) && !result.isPresent(); i++) {
				result = orderedHandlers[i].anyReadOnly(axes, uris);
			}

			cache.putResources(axes, uriSet, result);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	@Override
	public Optional<Boolean> isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject) {
		Optional<Boolean> result = cache.getObject(axes, eObject);
		if (result == null) {
			result = Optional.absent();

			ReadOnlyAxis[] all = ReadOnlyAxis.values();
			for (int i = 0; (i < all.length) && !result.or(Boolean.FALSE); i++) {
				if (axes.contains(all[i])) {
					result = isReadOnly(all[i], eObject);
				}
			}

			cache.putObject(axes, eObject, result);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	private Optional<Boolean> isReadOnly(ReadOnlyAxis axis, EObject eObject) {
		Set<ReadOnlyAxis> axes = axis.singleton();
		Optional<Boolean> result = cache.getObject(axes, eObject);
		if (result == null) {
			result = Optional.absent();

			IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
			for (int i = 0; (i < orderedHandlers.length) && !result.isPresent(); i++) {
				result = orderedHandlers[i].isReadOnly(axes, eObject);
			}

			cache.putObject(axes, eObject, result);
		}

		return result.isPresent() ? result : Optional.of(Boolean.FALSE);
	}

	@Override
	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		Boolean finalResult = true;

		ReadOnlyAxis[] all = ReadOnlyAxis.values();
		for (int i = 0; (i < all.length) && finalResult; i++) {
			if (axes.contains(all[i])) {
				finalResult = makeWritable(all[i], uris);
			}
		}

		return Optional.of(finalResult);
	}

	private Boolean makeWritable(ReadOnlyAxis axis, URI[] uris) {
		Set<ReadOnlyAxis> axes = axis.singleton();
		Boolean finalResult = true;

		try {
			IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
			for (int i = 0; (i < orderedHandlers.length); i++) {
				Optional<Boolean> isRO = orderedHandlers[i].anyReadOnly(axes, uris);
				if (isRO.or(Boolean.FALSE)) {
					Optional<Boolean> result = orderedHandlers[i].makeWritable(axes, uris);
					// makeWritable should provide an answer since anyReadOnly returned a positive value.
					// If no answer consider it a failure
					if (!result.or(Boolean.FALSE)) {
						finalResult = false;
						break;
					}
				}
			}
		} finally {
			cache.clear();
		}

		return finalResult;
	}

	@Override
	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, EObject eObject) {
		Boolean finalResult = true;

		ReadOnlyAxis[] all = ReadOnlyAxis.values();
		for (int i = 0; (i < all.length) && finalResult; i++) {
			if (axes.contains(all[i])) {
				finalResult = makeWritable(all[i], eObject);
			}
		}

		return Optional.of(finalResult);
	}

	private Boolean makeWritable(ReadOnlyAxis axis, EObject eObject) {
		Set<ReadOnlyAxis> axes = axis.singleton();
		Boolean finalResult = true;

		try {
			IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
			for (int i = 0; (i < orderedHandlers.length); i++) {
				Optional<Boolean> isRO = orderedHandlers[i].isReadOnly(axes, eObject);
				if (isRO.or(Boolean.FALSE)) {
					Optional<Boolean> result = orderedHandlers[i].makeWritable(axes, eObject);
					// makeWritable should provide an answer since anyReadOnly returned a positive value
					// if no answer consider it a failure
					if (!result.or(Boolean.FALSE)) {
						finalResult = false;
						break;
					}
				}
			}
		} finally {
			cache.clear();
		}

		return finalResult;
	}

	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		Boolean result = false;

		ReadOnlyAxis[] all = ReadOnlyAxis.values();
		for (int i = 0; (i < all.length) && !result; i++) {
			if (axes.contains(all[i])) {
				result = canMakeWritable(all[i], uris);
			}
		}

		return Optional.of(result);
	}

	private Boolean canMakeWritable(ReadOnlyAxis axis, URI[] uris) {
		Set<ReadOnlyAxis> axes = axis.singleton();
		Boolean result = false;

		IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
		for (int i = 0; (i < orderedHandlers.length); i++) {
			if (orderedHandlers[i].anyReadOnly(axes, uris).or(false)) {
				// Only ask a handler about making writable what it considers to be read-only
				Optional<Boolean> canMakeWritable = orderedHandlers[i].canMakeWritable(axes, uris);
				if (canMakeWritable.isPresent()) {
					result = canMakeWritable.get();
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, EObject object) {
		Boolean result = false;

		ReadOnlyAxis[] all = ReadOnlyAxis.values();
		for (int i = 0; (i < all.length) && !result; i++) {
			if (axes.contains(all[i])) {
				result = canMakeWritable(all[i], object);
			}
		}

		return Optional.of(result);
	}

	private Boolean canMakeWritable(ReadOnlyAxis axis, EObject object) {
		Set<ReadOnlyAxis> axes = axis.singleton();
		Boolean result = false;

		IReadOnlyHandler2[] orderedHandlers = orderedHandlersByAxis.get(axis);
		for (int i = 0; (i < orderedHandlers.length); i++) {
			if (orderedHandlers[i].isReadOnly(axes, object).or(false)) {
				// Only ask a handler about making writable what it considers to be read-only
				Optional<Boolean> canMakeWritable = orderedHandlers[i].canMakeWritable(axes, object);
				if (canMakeWritable.isPresent()) {
					result = canMakeWritable.get();
					break;
				}
			}
		}

		return result;
	}

	@Override
	public void addReadOnlyListener(IReadOnlyListener listener) {
		listeners.addIfAbsent(listener);
	}

	@Override
	public void removeReadOnlyListener(IReadOnlyListener listener) {
		listeners.remove(listener);
	}

	private IReadOnlyListener getForwardingListener() {
		if (forwardingListener == null) {
			forwardingListener = new IReadOnlyListener() {

				@Override
				public void readOnlyStateChanged(ReadOnlyEvent event) {
					ReadOnlyEvent myEvent;

					switch (event.getEventType()) {
					case ReadOnlyEvent.OBJECT_READ_ONLY_STATE_CHANGED:
						myEvent = new ReadOnlyEvent(ReadOnlyManager.this, event.getAxis(), event.getObject(), event.isReadOnly());
						break;
					default:
						myEvent = new ReadOnlyEvent(ReadOnlyManager.this, event.getAxis(), event.getResourceURI(), event.isReadOnly());
						break;
					}

					notifyReadOnlyStateChanged(myEvent);
				}
			};
		}

		return forwardingListener;
	}

	protected void notifyReadOnlyStateChanged(ReadOnlyEvent event) {
		if (!listeners.isEmpty()) {
			for (IReadOnlyListener next : listeners) {
				try {
					next.readOnlyStateChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in read-only state change listener.", e); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * Obtains a snapshot of the read-only handlers currently registered with me.
	 * 
	 * @return my read-only handlers, by axis of affiliation. Changes to this collection
	 *         do not affect my registered handlers
	 * @since 2.0
	 */
	public final Map<ReadOnlyAxis, Collection<IReadOnlyHandler2>> getReadOnlyHandlers() {
		Map<ReadOnlyAxis, Collection<IReadOnlyHandler2>> result = new HashMap<>();

		// Be sure not to provide lists that are actually backed by the arrays!
		orderedHandlersByAxis.forEach((axis, handlers) -> result.put(axis, Lists.newArrayList(handlers)));

		return result;
	}

	//
	// Deprecated API
	//

	@Override
	@Deprecated
	public Optional<Boolean> anyReadOnly(URI[] uris) {
		return anyReadOnly(permissionAxes(), uris);
	}

	@Override
	@Deprecated
	public Optional<Boolean> isReadOnly(EObject eObject) {
		return isReadOnly(permissionAxes(), eObject);
	}

	@Override
	@Deprecated
	public Optional<Boolean> makeWritable(URI[] uris) {
		return makeWritable(permissionAxes(), uris);
	}

	@Override
	@Deprecated
	public Optional<Boolean> makeWritable(EObject eObject) {
		return makeWritable(permissionAxes(), eObject);
	}

	//
	// Legacy adapters
	//

	@SuppressWarnings("deprecation")
	private static final class OldStyleHandlerAdapter extends AbstractReadOnlyHandler {

		private final org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler delegate;

		OldStyleHandlerAdapter(org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler handler, EditingDomain editingDomain) {
			super(editingDomain);

			this.delegate = handler;
		}

		@Override
		public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {

			// the old API contract is that handlers only return true if they
			// know it to be true, because the manager takes the first positive
			// answer. Moreover, they only dealt with permission-based read-only-ness
			boolean delegateResult = axes.contains(ReadOnlyAxis.PERMISSION) && delegate.isReadOnly(uris, getEditingDomain());
			return delegateResult ? Optional.of(Boolean.TRUE) : Optional.<Boolean> absent();
		}

		@Override
		public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {

			// the old API contract is that handlers only return false if they
			// tried to but could not make the resources writable, because the
			// manager takes the first negative answer (this is opposite to the
			// isReadOnly logic). Moreover, they only dealt with permission-based
			// read-only-ness
			boolean delegateResult = axes.contains(ReadOnlyAxis.PERMISSION) && delegate.enableWrite(uris, getEditingDomain());
			return delegateResult ? Optional.<Boolean> absent() : Optional.of(Boolean.FALSE);
		}
	}
}
