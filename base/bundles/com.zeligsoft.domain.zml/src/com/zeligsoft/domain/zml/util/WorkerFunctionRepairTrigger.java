/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.zml.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Component;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Abstract class to share functionality that is common to all
 * worker function repair triggers, that are resource set listeners.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class WorkerFunctionRepairTrigger extends ResourceSetListenerImpl {

	/**
	 * Collection of elements that require updating based on the event.
	 */
	protected Set<Component> componentsToRepair = new HashSet<Component>();
	/**
	 * Filter to remove notation events.
	 */
	protected static NotificationFilter triggerFilter = NotificationFilter.NOT_TOUCH
			.and(NotificationFilter.createNotifierTypeFilter(View.class).negated()
				.and(
					NotificationFilter.createNotifierTypeFilter(Style.class)
						.negated()));

	/**
	 * Create me.
	 */
	protected WorkerFunctionRepairTrigger() {
		super(triggerFilter);
	}

	/**
	 * Return true since we need all the events to prepare our commands.
	 */
	@Override
	public boolean isAggregatePrecommitListener() {
		return true;
	}

	/**
	 * Safely determines if the given object is a structural realization.
	 * 
	 * @param component
	 * @return
	 */
	protected boolean safeIsStructuralRealization(Object component) {
		return component instanceof EObject
			&& ZDLUtil.isZDLConcept((EObject) component,
				ZMLMMNames.STRUCTURAL_REALIZATION);
	}

	/**
	 * Safely determines if the given object is a component interface.
	 * 
	 * @param component
	 * @return
	 */
	protected boolean safeIsComponentInterface(Object component) {
		return component instanceof EObject
			&& ZDLUtil.isZDLConcept((EObject) component,
				ZMLMMNames.COMPONENT_INTERFACE);
	}

	/**
	 * Safely determines if the given object is a component interface that has
	 * exactly one structural realization.
	 * 
	 * @param component
	 * @return
	 */
	protected boolean safeIsComponentInterfaceWithSingleSR(Object component) {
		return safeIsComponentInterface(component)
			&& (ZMLUtil.getStructuralRealizations((Component) component).size() == 1);
	}

	protected Set<EObject> getRenamedObject(ResourceSetChangeEvent event, Class<?>[] types) {
		Set<EObject> renamedObjects = new HashSet<EObject>();
		
		for (Notification thisNotification : event.getNotifications()) {
			int eventType = thisNotification.getEventType();
			if (eventType == Notification.SET) {
				final Object notifier = thisNotification.getNotifier();
				final Object newValue = thisNotification.getNewValue();
				final Object oldValue = thisNotification.getOldValue();
				
				for(Class<?> type : types) {
					if(type.isInstance(notifier)) {
						if(newValue instanceof String && oldValue != null) {
							renamedObjects.add((EObject) notifier);
							break;
						}
					}
				}
			}
		}
		return renamedObjects;
	}
	
	/**
	 * Queries the renamed ports.
	 * 
	 * @param event
	 * @return
	 */
	protected Set<EObject> getRenamedObject(ResourceSetChangeEvent event, Class<?> type) {
		Class<?>[] types = {type};
		return getRenamedObject(event, types);
	}

	/**
	 * Returns a Set of EObjects that are in the process of being deleted from
	 * the resource set.
	 * 
	 * @param event
	 * @return
	 */
	protected Set<EObject> getDeletedObjects(ResourceSetChangeEvent event) {
		Set<EObject> removedEObjects = new HashSet<EObject>();
	
		for (Notification thisNotification : event.getNotifications()) {
			int eventType = thisNotification.getEventType();
			if (eventType == Notification.REMOVE
				|| eventType == Notification.REMOVE_MANY) {
				Object feature = thisNotification.getFeature();
				if (feature instanceof EReference
					&& ((EReference) feature).isContainment()) {
	
					if (eventType == Notification.REMOVE
						&& thisNotification.getOldValue() instanceof EObject) {
						removedEObjects.add((EObject) thisNotification
							.getOldValue());
	
					} else if (eventType == Notification.REMOVE_MANY) {
						@SuppressWarnings("unchecked")
						Collection<EObject> eObjects = (Collection<EObject>) thisNotification
							.getOldValue();
						for (EObject thisEObject : eObjects) {
							if (thisEObject.eResource() == null) {
								removedEObjects.add(thisEObject);
							}
						}
					}
				}
	
			}
		}
	
		return removedEObjects;
	}

	/**
	 * Returns a Set of EObjects that are in the process of being added to the
	 * resource set.
	 * 
	 * @param event
	 * @return
	 */
	protected Set<EObject> getAddedObjects(ResourceSetChangeEvent event) {
		Set<EObject> addedEObjects = new HashSet<EObject>();
	
		for (Notification thisNotification : event.getNotifications()) {
			int eventType = thisNotification.getEventType();
			if (eventType == Notification.ADD
				|| eventType == Notification.ADD_MANY) {
				Object feature = thisNotification.getFeature();
				if (feature instanceof EReference
					&& ((EReference) feature).isContainment()) {
	
					if (eventType == Notification.ADD
						&& thisNotification.getNewValue() instanceof EObject) {
						addedEObjects.add((EObject) thisNotification
							.getNewValue());
	
					} else if (eventType == Notification.ADD_MANY) {
						@SuppressWarnings("unchecked")
						Collection<EObject> eObjects = (Collection<EObject>) thisNotification
							.getNewValue();
						for (EObject thisEObject : eObjects) {
							if (thisEObject.eResource() == null) {
								addedEObjects.add(thisEObject);
							}
						}
					}
				}
	
			}
		}
	
		return addedEObjects;
	}

}