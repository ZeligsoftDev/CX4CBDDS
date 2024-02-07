/*******************************************************************************
 * Copyright (c) 2016, 2018 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *     Christian W. Damus - bugs 526932, 512529, 529897
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;

/**
 * This class wraps a resource set into a ModelSet with minimal changes to be compliant to the expected
 * Profile Migration mechanism of Eclipse Luna.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class ModelSetWrapper extends ModelSet {

	/**
	 * Mapping of resources to their read-only setting. Needed when a new editing domain is created.
	 */
	private Map<Resource, Boolean> resourceToReadOnlyMap = new HashMap<Resource, Boolean>();

	/**
	 * The resource set being wrapped.
	 */
	private ResourceSet resourceSet;

	/**
	 * Constructor.
	 * 
	 * @param resourceSet
	 *            resource set to be wrapped.
	 */
	public ModelSetWrapper(ResourceSet resourceSet) {
		super();

		this.resourceSet = resourceSet;

		// We need to ensure that UML profiles are shared by myself and the
		// resource set that I wrap, because a profile must be loaded exactly once
		// to avoid confusing the identity of stereotypes. Otherwise, stereotype
		// applications repaired in this model-set context would be deemed invalid
		// in the wrapped resource-set context because there the UML API
		// is seeing the wrong copy of the Stereotype as their definition
		// cf. http://eclip.se/526932
		this.resources = new ProxyingResourceList();
	}

	@Override
	protected Resource demandCreateResource(URI uri) {
		if (shouldProxy(uri)) {
			// Create the real resource in the wrapped resource set and proxy it here
			Resource delegate = resourceSet.createResource(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
			if (delegate != null) {
				// Get the proxy
				return getResource(uri, false);
			}
		}

		return super.demandCreateResource(uri);
	}

	/**
	 * Ensure that the given resource has the specified readOnly setting in the
	 * {@link #getTransactionalEditingDomain() editing domain} of this model set.
	 * 
	 * @param resource
	 *            resource within this resource set
	 * @param readOnly
	 *            true if resource should be readOnly, false otherwise
	 */
	public void setReadOnly(Resource resource, Boolean readOnly) {
		resourceToReadOnlyMap.put(resource, readOnly);
	}

	@Override
	public synchronized TransactionalEditingDomain getTransactionalEditingDomain() {
		final TransactionalEditingDomainImpl domain = new TransactionalEditingDomainImpl(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		domain.setResourceToReadOnlyMap(resourceToReadOnlyMap);
		return domain;
	}

	@Override
	public Registry getPackageRegistry() {
		return resourceSet.getPackageRegistry(); // delegate to wrapped resourceSet
	}

	/**
	 * Queries whether a code resource should be proxied in the model set. This is usually required for UML
	 * library resources (profiles, metamodels, and such deployed in plug-ins) and not for other resources.
	 * 
	 * @param resourceURI
	 *            a resource URI
	 * @return whether it should be proxied
	 */
	protected boolean shouldProxy(URI resourceURI) {
		return resourceSet.getURIConverter().normalize(resourceURI).isPlatformPlugin()
				&& UmlModel.UML_FILE_EXTENSION.equals(resourceURI.fileExtension());
	}

	/**
	 * Detaches me from the resource-set that I wrap.
	 */
	public void detach() {
		((ProxyingResourceList)resources).detach();
	}

	/**
	 * Directly set the model-set's URI without initializing the entire pluggable models and snippets
	 * infrastructure.
	 * 
	 * @param uriWithoutExtension
	 *            the URI without the file extension
	 */
	@Override
	public void setURIWithoutExtension(URI uriWithoutExtension) {
		super.setURIWithoutExtension(uriWithoutExtension);
	}

	//
	// Nested types
	//

	/**
	 * A specialized resource list that shares the underlying resources (and hence their contents) of UML
	 * Profiles with the wrapped resource, to ensure a single in-memory copy of each profile definition for
	 * consistent identification of stereotype applications. Nonetheless, each resource set has to see these
	 * shared resources as "owned by" it, so in the {@code ModelSetWrapper} context this is achieved by
	 * dynamic proxies that pass through to the real resources for everything but the relationship to the
	 * owning resource-set.
	 *
	 * @author Christian W. Damus
	 */
	protected class ProxyingResourceList extends ResourcesEList<Resource> implements Adapter {

		private static final long serialVersionUID = 1L;

		private final Map<Resource, Resource> proxies = new HashMap<>();

		/**
		 * Initializes me.
		 */
		protected ProxyingResourceList() {
			super();

			for (Resource next : resourceSet.getResources()) {
				addProxy(next);
			}

			resourceSet.eAdapters().add(this);
		}

		/**
		 * Detaches me from my delegate list, removes all of my proxy resources, and forgets all of my proxy
		 * mappings.
		 */
		void detach() {
			// Stop listening to my delegate for changes in its resources
			resourceSet.eAdapters().remove(this);

			// Remove all of my proxy resources that I don't own
			removeAll(proxies.values());
			proxies.clear();
		}

		//
		// Proxy management
		//

		/**
		 * Queries whether a {@code resource} should be proxied in the model set. This is usually required for
		 * UML library resources (profiles, metamodels, and such deployed in plug-ins) and not for other
		 * resources.
		 * 
		 * @param resource
		 *            a resource
		 * @return whether it should be proxied
		 */
		protected boolean shouldProxy(Resource resource) {
			return ModelSetWrapper.this.shouldProxy(resource.getURI());
		}

		/**
		 * Obtains the existing proxy, if any, that represents my share of a {@code resource}.
		 * 
		 * @param resource
		 *            a resource
		 * @return the existing proxy, or {@code null} if it has not been proxied
		 */
		Resource getProxy(Resource resource) {
			return proxies.get(resource);
		}

		/**
		 * Creates the canonical proxy wrapper for a {@code resource} that represents my share of it.
		 * 
		 * @param resource
		 *            a resource to proxy
		 * @return the proxied resource
		 */
		Resource createProxy(Resource resource) {
			Collection<Class<?>> interfaces = getResourceInterfaces(resource.getClass());
			Resource result = (Resource)Proxy.newProxyInstance(getClass().getClassLoader(),
					Iterables.toArray(interfaces, Class.class), new ResourceProxy(resource));
			proxies.put(resource, result);
			return result;
		}

		/**
		 * Computes the {@link Resource} interfaces that a proxy needs to implement to expose the full API of
		 * an instance of the given resource implementation class.
		 * 
		 * @param resourceImpl
		 *            the implementation class of a resource
		 * @return its interfaces
		 */
		private Collection<Class<?>> getResourceInterfaces(Class<?> resourceImpl) {
			Collection<Class<?>> result = new LinkedHashSet<>();

			for (Class<?> class_ = resourceImpl; class_ != null; class_ = class_.getSuperclass()) {
				interfaces: for (Class<?> next : class_.getInterfaces()) {
					if (Resource.class.isAssignableFrom(next)) {
						for (Class<?> found : result) {
							if (next.isAssignableFrom(found)) {
								// Don't bother if it's a redundant superinterface
								continue interfaces;
							}
						}
						result.add(next);
					}
				}
			}

			// Remove redundant superinterfaces

			return result;
		}

		/**
		 * Queries whether a {@code resource} is a proxy that represents my co-ownership of it.
		 * 
		 * @param resource
		 *            a resource
		 * @return whether it is a proxy of mine
		 */
		boolean isProxy(Resource resource) {
			return resource != null && Proxy.isProxyClass(resource.getClass())
					&& Proxy.getInvocationHandler(resource) instanceof ResourceProxy;
		}

		/**
		 * Obtains a proxy for the given {@code resource}, creating that proxy if necessary, to represent my
		 * share of it.
		 * 
		 * @param resource
		 *            a resource
		 * @return the {@code resource} itself if it already {@linkplain #isProxy(Resource) is a proxy} or a
		 *         proxy wrapping it
		 */
		Resource proxy(Resource resource) {
			if (isProxy(resource)) {
				return resource;
			}

			Resource result = getProxy(resource);
			if (result == null) {
				result = createProxy(resource);
			}
			return result;
		}

		/**
		 * Obtains the real resource represented by the given {@code resource}, in case it
		 * {@linkplain #isProxy(Resource) is a proxy}.
		 * 
		 * @param resource
		 *            a resource
		 * @return the real resource if a proxy, otherwise just the {@code resource}, itself
		 */
		Resource unproxy(Resource resource) {
			if (isProxy(resource)) {
				return ((ResourceProxy)Proxy.getInvocationHandler(resource)).resource;
			}
			return resource;
		}

		/**
		 * Adds a proxy for me to share ownership of the given {@code resource} if I
		 * {@linkplain #shouldProxy(Resource) should have a proxy} for it.
		 * 
		 * @param resource
		 *            a resource to conditionally add to me as a proxy
		 */
		void addProxy(Resource resource) {
			if (shouldProxy(resource)) {
				add(proxy(resource));
			}
		}

		@Override
		public boolean contains(Object object) {
			// XXX The super implementation only works up to the 5th element.
			// Because we're cheating with proxies, the super impl will consider
			// that we already contain this resource.
			// Basically, we can't trust the bidirectionnal reference between Resource
			// and ResourceSet because of the proxy; but EMF does trust it.
			boolean result = super.contains(object);

			if (result && object instanceof Resource && isProxy((Resource)object)) {
				// Let's double-check... Copy the super-super implementation
				if (useEquals()) {
					for (int i = 0; i < size; ++i) {
						if (object.equals(data[i])) {
							return true;
						}
					}
				} else {
					for (int i = 0; i < size; ++i) {
						if (data[i] == object) {
							return true;
						}
					}
				}

				return false;
			}

			return result;
		}

		/**
		 * Removes my proxy for the given {@code resource} if I have one
		 * 
		 * @param resource
		 *            a resource that I must no longer share
		 */
		void removeProxy(Resource resource) {
			// Don't implicitly create a proxy just to remove it
			remove(getProxy(resource));
		}

		/**
		 * Adds a proxy for me to share ownership of the given {@code newResource} in place of the old if I
		 * {@linkplain #shouldProxy(Resource) should have a proxy} for it. Otherwise, just ensures that I do
		 * not have a proxy for the {@code oldResource}.
		 * 
		 * @param oldResource
		 *            a resource for which I should not have a proxy
		 * @param newResource
		 *            a resource to conditionally replace the old one with
		 */
		void replaceProxy(Resource oldResource, Resource newResource) {
			// Don't implicitly create a proxy just to remove it
			int index = indexOf(getProxy(oldResource));
			if (index >= 0) {
				if (shouldProxy(newResource)) {
					set(index, proxy(newResource));
				} else {
					removeProxy(oldResource);
				}
			} else if (shouldProxy(newResource)) {
				add(proxy(newResource));
			}
		}

		//
		// Adapter protocol to pick up changes in the delegate list
		//

		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) {
				return;
			}

			if (msg.getNotifier() == resourceSet
					&& msg.getFeatureID(ResourceSet.class) == RESOURCE_SET__RESOURCES) {
				switch (msg.getEventType()) {
					case Notification.ADD:
						addProxy((Resource)msg.getNewValue());
						break;
					case Notification.ADD_MANY:
						for (Object next : (Collection<?>)msg.getNewValue()) {
							addProxy((Resource)next);
						}
						break;
					case Notification.REMOVE:
						removeProxy((Resource)msg.getOldValue());
						break;
					case Notification.REMOVE_MANY:
						for (Object next : (Collection<?>)msg.getOldValue()) {
							removeProxy((Resource)next);
						}
						break;
					case Notification.SET:
						replaceProxy((Resource)msg.getOldValue(), (Resource)msg.getNewValue());
						break;
					default:
						// Pass. Not even move is interesting
						break;
				}
			}
		}

		public Notifier getTarget() {
			return null;
		}

		public void setTarget(Notifier newTarget) {
			// Pass
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

	}

	/**
	 * Invocation handler for my proxy resources. It passes through all API to the wrapped resource, properly
	 * owned by my wrapped resource set, except for the API dealing with the relationship to the resource set,
	 * which in that case is myself.
	 *
	 * @author Christian W. Damus
	 */
	private class ResourceProxy implements InvocationHandler {
		private final Resource resource;

		private EList<Adapter> adapterList;

		ResourceProxy(Resource resource) {
			super();

			this.resource = resource;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			switch (method.getName()) {
				case "getResourceSet": //$NON-NLS-1$
					if (method.getDeclaringClass() == Resource.class) {
						return ModelSetWrapper.this;
					}
					break;
				case "basicSetResourceSet": //$NON-NLS-1$
					if (method.getDeclaringClass() == Resource.Internal.class) {
						// Don't try to tell the real resource that the wrapper
						// model-set is its owner
						return null;
					}
					break;
				case "eAdapters": //$NON-NLS-1$
					return getAdapters(proxy);
			}

			return method.invoke(resource, args);
		}

		EList<Adapter> getAdapters(Object proxy) {
			if (adapterList == null) {
				adapterList = new ProxyAdapterList(resource, (Resource)proxy);
			}
			return adapterList;
		}
	}

	/**
	 * An adapter list implementation for {@link ResourceProxy} instances to ensure that {@link Adapter}
	 * call-backs are invoked with the resource proxy that the adapters are added to, not the underlying real
	 * resource.
	 *
	 * @author Christian W. Damus
	 */
	@SuppressWarnings("serial")
	private class ProxyAdapterList extends DelegatingEList<Adapter> implements EObservableAdapterList {

		// Map of "real adapter" <--> wrapper
		private final BiMap<Adapter, Adapter> adapters = HashBiMap.create();

		private final Notifier owner;

		private final Notifier proxy;

		private final EList<Adapter> delegate;

		private List<Listener> listeners;

		/**
		 * Initializes me with the real resource {@link notifier} and its {@code proxy} that I present to
		 * adapters in their call-backs.
		 * 
		 * @param notifier
		 *            the real notifier
		 * @param proxy
		 *            its proxy wrapper
		 */
		ProxyAdapterList(Notifier notifier, Notifier proxy) {
			super();

			owner = notifier;
			this.proxy = proxy;
			delegate = notifier.eAdapters();
		}

		@Override
		protected List<Adapter> delegateList() {
			return delegate;
		}

		@Override
		protected boolean delegateContains(Object object) {
			// The delegate list contains wrappers, not the real adapters
			Object search = adapters.get(object);
			return super.delegateContains(search == null ? object : search);
		}

		@Override
		protected int delegateIndexOf(Object object) {
			// The delegate list contains wrappers, not the real adapters.
			// This is needed to support removal
			Object search = adapters.get(object);
			return super.delegateIndexOf(search == null ? object : search);
		}

		@Override
		protected int delegateLastIndexOf(Object object) {
			// The delegate list contains wrappers, not the real adapters.
			// This is needed as counterpart to indexOf
			Object search = adapters.get(object);
			return super.delegateLastIndexOf(search == null ? object : search);
		}

		@Override
		protected Adapter validate(int index, Adapter object) {
			Adapter result = adapters.get(object);
			if (result == null) {
				result = new ProxyAdapter(object, owner, proxy);
				adapters.put(object, result);
			}

			return result;
		}

		@Override
		protected void didAdd(int index, Adapter newObject) {
			if (listeners != null) {
				for (Listener next : listeners) {
					next.added(proxy, newObject);
				}
			}
		}

		@Override
		protected void didRemove(int index, Adapter oldObject) {
			if (listeners != null) {
				for (Listener next : listeners) {
					next.removed(proxy, oldObject);
				}
			}
			adapters.inverse().remove(oldObject);
		}

		@Override
		protected void didSet(int index, Adapter newObject, Adapter oldObject) {
			didRemove(index, oldObject);
			didAdd(index, newObject);
		}

		//
		// EObservableAdapterList protocol
		//

		public void addListener(Listener listener) {
			if (listeners == null) {
				listeners = Lists.newArrayListWithExpectedSize(1);
			}
			listeners.add(listener);
		}

		public void removeListener(Listener listener) {
			if (listeners != null) {
				listeners.remove(listener);
			}
		}
	}

	//
	// Nested types
	//

	/**
	 * An wrapper for adapters to ensure that the {@link Adapter} call-backs are invoked with the notifier
	 * proxy that the adapters are added to, not the underlying real notifier.
	 *
	 * @author Christian W. Damus
	 */
	private class ProxyAdapter extends AdapterImpl {
		private final Adapter delegate;

		private final Notifier notifier;

		private final Notifier proxy;

		/** Cache of notification wrappers for presentation of the notifier as the proxy. */
		private final Map<Notification, Notification> notificationWrappers = new MapMaker().weakKeys()
				.weakValues().makeMap();

		/**
		 * Initializes me with the real resource {@link notifier} and its {@code proxy} that I present to my
		 * wrapper {@link adapter} in its call-backs.
		 * 
		 * @param adapter
		 *            my real adapter delegate
		 * @param notifier
		 *            the real notifier
		 * @param proxy
		 *            its proxy wrapper
		 */
		ProxyAdapter(Adapter adapter, Notifier notifier, Notifier proxy) {
			super();

			delegate = adapter;
			this.notifier = notifier;
			this.proxy = proxy;
		}

		@Override
		public void notifyChanged(Notification msg) {
			delegate.notifyChanged(wrap(msg));
		}

		Notification wrap(Notification msg) {
			Notification result = msg;

			if (msg.getNotifier() == notifier) {
				// Wrap it
				result = notificationWrappers.get(msg);
				if (result == null) {
					result = new NotificationWrapper(proxy, msg);
					notificationWrappers.put(msg, result);
				}
			}

			return result;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return delegate.isAdapterForType(type);
		}

		@Override
		public void setTarget(Notifier newTarget) {
			if (newTarget == notifier) {
				delegate.setTarget(proxy);
			} else {
				delegate.setTarget(newTarget);
			}
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if (delegate instanceof Adapter.Internal) {
				if (oldTarget == notifier) {
					((Adapter.Internal)delegate).unsetTarget(proxy);
				} else {
					((Adapter.Internal)delegate).unsetTarget(oldTarget);
				}
			}
		}

		@Override
		public String toString() {
			return delegate.toString();
		}
	}

}
