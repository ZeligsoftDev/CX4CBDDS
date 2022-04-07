/*
 * Copyright (c) 2014, 2016 CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bugs 463631, 485220
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 */
package org.eclipse.papyrus.infra.emf.readonly.internal;

import java.util.Collection;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.internationalization.utils.PropertiesFilesUtils;
import org.eclipse.pde.internal.ui.util.LocaleUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A resource-set listener that tracks controlled resource connectivity structure. It adds controlled-resource links immediately that they occur
 * and removes them after a transaction has committed that removes them. This makes it reasonably efficient to determine that a referenced model
 * is logically a component of the referencing model and thus not to be treated as read-only. The transactional nature of updates to this mapping
 * is necessary to ensure that the ephemeral states during controlling and uncontrolling a sub-model don't fool the editing domain into thinking
 * we're making changes to a read-only resource, triggering roll-back.
 */
@SuppressWarnings("restriction")
public class ControlledResourceTracker extends AdapterImpl implements TransactionalEditingDomainListener {

	// A resource may be a sub-unit of multiple parent units (it can have multiple roots that are
	// cross-resource-contained by elements in multiple other resources, or all in the same resource,
	// or anything in-between). The mapping is to a list, not a set, because a resource may be a
	// repeated parent of a child.
	// This map contains URIs without extension
	private volatile ListMultimap<URI, URI> unitMap = ArrayListMultimap.create();

	// This map contains URIs without extension
	private volatile ListMultimap<URI, URI> pending;

	/**
	 * Obtains the single tracker instance associated with the specified editing {@code domain}.
	 *
	 * @param domain
	 *            an editing domain
	 *
	 * @return its tracker
	 */
	public static ControlledResourceTracker getInstance(EditingDomain domain) {
		ControlledResourceTracker result = null;

		for (Object next : domain.getResourceSet().eAdapters()) {
			if (next instanceof ControlledResourceTracker) {
				result = (ControlledResourceTracker) next;
				break;
			}
		}

		if (result == null) {
			result = new ControlledResourceTracker(domain);
		}

		return result;
	}

	private ControlledResourceTracker(EditingDomain domain) {
		domain.getResourceSet().eAdapters().add(this);

		if (domain instanceof TransactionalEditingDomain) {
			TransactionUtil.getAdapter((TransactionalEditingDomain) domain, TransactionalEditingDomain.Lifecycle.class).addTransactionalEditingDomainListener(this);
		}

		// commit the initial discovery
		commit();
	}

	/**
	 * Queries the URI of the resource in the root unit of the model of the same kind as the given potential sub-model unit.
	 *
	 * @param uri
	 *            the URI of a resource that potentially is in a sub-model unit
	 *
	 * @return the URI of the corresponding resource in the model's root unit, which could be the same {@code uri} if this is the root unit
	 */
	public Set<URI> getRootResourceURIs(URI uri) {
		Set<URI> result = Sets.newHashSet();
		Queue<URI> units = Lists.newLinkedList();
		units.add(uri.trimFileExtension());

		for (URI next = units.poll(); next != null; next = units.poll()) {
			if (isRoot(next)) {
				result.add(getFinalURI(uri, next));
			} else {
				Iterables.addAll(units, get(next));
			}
		}

		return result;
	}
	
	/**
	 * Get the URI modified if necessary (for example, the properties file can have a locale at the end of the file).
	 * 
	 * @param uri
	 *            The URI of a resource that potentially is in a sub-model unit.
	 * @param initialURI
	 *            The initial URI of the sub model unit.
	 * @return The modified URI (or not modified if don't needed).
	 */
	private URI getFinalURI(final URI uri, final URI initialURI) {
		URI result = initialURI;

		// If this is a properties file, check if a locale is available at the end of the URI
		if (null != uri && null != uri.fileExtension() && uri.fileExtension().equals(PropertiesFilesUtils.PROPERTIES_FILE_EXTENSION)) { //$NON-NLS-1$
			// Get the last segment
			final String lastSegment = initialURI.lastSegment();
			// Try to remove existing localization
			final String withoutLocalization = LocaleUtil.trimLocalization(lastSegment);

			// If the initial last segment and the segment without localization are not equals, localization exist
			if (!lastSegment.equals(withoutLocalization)) {
				// Remove the last segment
				result = initialURI.trimSegments(1);
				// Add the modified last segment
				result = result.appendSegment(withoutLocalization);
			}
		}

		return result;
	}

	/**
	 * Queries whether the given URI (without extension, thus representing the set of Papyrus resources comprising
	 * a model unit) is a root unit.
	 */
	private boolean isRoot(URI uriWithoutFileExtension) {
		return (!unitMap.containsKey(uriWithoutFileExtension) || unitMap.get(uriWithoutFileExtension).isEmpty())
				&& ((pending == null) || !pending.containsKey(uriWithoutFileExtension) || pending.get(uriWithoutFileExtension).isEmpty());
	}

	private Iterable<URI> get(URI potentialUnit) {
		Collection<URI> result = null;

		if (unitMap.containsKey(potentialUnit)) {
			result = unitMap.get(potentialUnit);
		} else if (pending != null) {
			// Look here, too, in case the current transaction is adding the relationship
			result = pending.get(potentialUnit);
		}

		return result;
	}

	private void ensurePending() {
		if (pending == null) {
			pending = ArrayListMultimap.create(unitMap);
		}
	}

	private void map(URI controlledUnit, URI parentUnit) {
		ensurePending();
		pending.put(controlledUnit.trimFileExtension(), parentUnit.trimFileExtension());
	}

	private void unmap(URI controlledUnit, URI parentUnit) {
		ensurePending();
		pending.remove(controlledUnit.trimFileExtension(), parentUnit.trimFileExtension());
	}

	private void commit() {
		if (pending != null) {
			unitMap = pending;
			pending = null;
		}
	}

	private void rollback() {
		pending = null;
	}

	//
	// Adapter protocol
	//

	@Override
	public void setTarget(Notifier newTarget) {
		if (newTarget instanceof ResourceSet) {
			// Discover existing resources
			for (Resource next : ((ResourceSet) newTarget).getResources()) {
				addAdapter(next);
			}
		} else if (newTarget instanceof Resource) {
			handleResource((Resource) newTarget);
		}
	}

	protected void addAdapter(Notifier notifier) {
		notifier.eAdapters().add(this);
	}

	protected void removeAdapter(Notifier notifier) {
		notifier.eAdapters().remove(this);
	}

	@Override
	public void unsetTarget(Notifier oldTarget) {
		if (oldTarget instanceof ResourceSet) {
			for (Resource next : ((ResourceSet) oldTarget).getResources()) {
				removeAdapter(next);
			}
		}
	}

	/**
	 * Discover existing parent-unit relationship in a resource.
	 */
	protected void handleResource(Resource resource) {
		if (!resource.getContents().isEmpty()) {
			for (EObject root : resource.getContents()) {
				handleAdd(resource, root);
			}
		}
	}

	protected void handleAdd(Resource resource, EObject newRoot) {
		InternalEObject container = ((InternalEObject) newRoot).eInternalContainer();
		if (container != null) {
			// Found cross-resource containment
			URI parentURI = container.eIsProxy() ? container.eProxyURI().trimFragment() : container.eResource().getURI();
			if (parentURI != null) {
				map(resource.getURI(), parentURI);
			}
		}
	}

	protected void handleRemove(Resource resource, EObject oldRoot) {
		InternalEObject container = ((InternalEObject) oldRoot).eInternalContainer();
		if (container != null) {
			// Found cross-resource containment
			URI parentURI = container.eIsProxy() ? container.eProxyURI().trimFragment() : container.eResource().getURI();
			if (parentURI != null) {
				unmap(resource.getURI(), parentURI);
			}
		}
	}

	/**
	 * Discover an existing parent-unit relationship from a cross-resource-contained object.
	 *
	 * @param crossResourceContained
	 *            an object that is in the contents list of a resource and also has a container
	 */
	public void handleCrossResourceContainment(InternalEObject crossResourceContained) {
		URI resourceURI = crossResourceContained.eIsProxy() ? crossResourceContained.eProxyURI().trimFragment() : crossResourceContained.eDirectResource().getURI();
		InternalEObject container = crossResourceContained.eInternalContainer();
		URI parentURI = container.eIsProxy() ? container.eProxyURI().trimFragment() : container.eResource().getURI();
		if (parentURI != null) {
			map(resourceURI, parentURI);
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		Object notifier = msg.getNotifier();

		if (notifier instanceof ResourceSet) {
			switch (msg.getFeatureID(ResourceSet.class)) {
			case ResourceSet.RESOURCE_SET__RESOURCES:
				switch (msg.getEventType()) {
				case Notification.ADD:
					addAdapter((Resource) msg.getNewValue());
					break;
				case Notification.ADD_MANY:
					for (Object next : (Collection<?>) msg.getNewValue()) {
						addAdapter((Resource) next);
					}
					break;
				case Notification.SET:
					removeAdapter((Resource) msg.getOldValue());
					addAdapter((Resource) msg.getNewValue());
					break;
				case Notification.REMOVE:
					removeAdapter((Resource) msg.getOldValue());
					break;
				case Notification.REMOVE_MANY:
					for (Object next : (Collection<?>) msg.getOldValue()) {
						removeAdapter((Resource) next);
					}
					break;
				}
				break;
			}
		} else if (notifier instanceof Resource) {
			final Resource resource = (Resource) notifier;

			switch (msg.getFeatureID(Resource.class)) {
			case Resource.RESOURCE__CONTENTS:
				switch (msg.getEventType()) {
				case Notification.ADD: {
					handleAdd(resource, (EObject) msg.getNewValue());
					break;
				}
				case Notification.ADD_MANY:
					for (Object next : (Iterable<?>) msg.getNewValue()) {
						handleAdd(resource, (EObject) next);
					}
					break;
				case Notification.SET: {
					handleRemove(resource, (EObject) msg.getOldValue());
					handleAdd(resource, (EObject) msg.getNewValue());
					break;
				}
					// case MOVE: moving within the list does not change sub-unit relationships
				case Notification.REMOVE: {
					handleRemove(resource, (EObject) msg.getOldValue());
					break;
				}
				case Notification.REMOVE_MANY:
					for (Object next : (Iterable<?>) msg.getOldValue()) {
						handleRemove(resource, (EObject) next);
					}
					break;
				}
			}
		}
	}

	//
	// TransactionalEditingDomainListener protocol
	//

	@Override
	public void transactionClosed(TransactionalEditingDomainEvent event) {
		if (event.getTransaction().getStatus().getSeverity() >= IStatus.ERROR) {
			// Transaction rolled back
			rollback();
		} else {
			// Transaction committed
			commit();
		}
	}

	@Override
	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		removeAdapter(event.getSource().getResourceSet());
	}

	@Override
	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// pass
	}

	@Override
	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		// pass
	}

	@Override
	public void transactionStarted(TransactionalEditingDomainEvent event) {
		// pass
	}

	@Override
	public void transactionClosing(TransactionalEditingDomainEvent event) {
		// pass
	}

}
