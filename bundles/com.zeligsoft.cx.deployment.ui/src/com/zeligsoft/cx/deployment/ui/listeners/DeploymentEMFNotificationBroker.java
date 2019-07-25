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

package com.zeligsoft.cx.deployment.ui.listeners;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * A notification broker that manages the zdl deployment component listeners.
 * 
 * For each deployment component, a DeploymentListener is added to the
 * component's domain.
 * 
 * @author schafe
 * 
 */
public class DeploymentEMFNotificationBroker
		extends ResourceSetListenerImpl {

	private static DeploymentEMFNotificationBroker instance;

	private Map<Model, Map<Component, DeploymentListener>> modelMap = new WeakHashMap<Model, Map<Component, DeploymentListener>>();

	private NotificationFilter resourceLoadedFilter = NotificationFilter.RESOURCE_LOADED;

	public DeploymentEMFNotificationBroker() {
		super();
		instance = this;
	}

	public static DeploymentEMFNotificationBroker getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		for (Iterator iter = event.getNotifications().iterator(); iter
			.hasNext();) {
			Notification notification = (Notification) iter.next();
			Object notifier = notification.getNotifier();
			int eventType = notification.getEventType();

			// Handle loading and unloading of models
			if (notifier instanceof Resource) {

				// handle load of model
				boolean isResourceLoad = resourceLoadedFilter
					.matches(notification);

				if (isResourceLoad) {
					Resource r = (Resource) notifier;
					EList<EObject> contents = r.getContents();
					if (contents.size() < 1) {
						continue;
					}
					EObject firstObject = contents.get(0);
					boolean isModel = (firstObject instanceof Model);

					if (isResourceLoad && isModel) {
						addDeploymentListeners((Model) firstObject);
					}
				}

				// handle unload of model
				else if (eventType == Notification.REMOVE_MANY) {
					Object oldValue = notification.getOldValue();

					if (oldValue instanceof BasicEList.UnmodifiableEList) {
						BasicEList.UnmodifiableEList list = (BasicEList.UnmodifiableEList) oldValue;
						if (list.size() > 0) {
							Object firstObject = list.get(0);
							if (firstObject instanceof Model) {
								removeDeploymentListeners((Model) firstObject);
							}
						}
					}
				}
			}

			// handle add and remove of deployment objects
			else {
				// Only interested in ADD and REMOVE events
				if (eventType == Notification.ADD) {
					Object newValue = notification.getNewValue();
					if (isDeploymentComponent(newValue)) {
						addDeploymentListener((Component) newValue);
					}
				} else if (eventType == Notification.REMOVE) {
					Object oldValue = notification.getOldValue();
					if (oldValue instanceof Component) {
						removeDeploymentListener((Component) oldValue);
					}
				}
			}
		}
	}

	/**
	 * Add a deployment listener for each deployment in a model.
	 * 
	 * @param Model model
	 */
	public void addDeploymentListeners(Model model) {
		Collection<Object> deployments = ZDeploymentUtil
			.getDeploymentsForModel(model);
		for (Iterator<Object> i = deployments.iterator(); i.hasNext();) {
			addDeploymentListener((Component) i.next());
		}
	}

	/**
	 * Remove all deployment listeners for a model.
	 * 
	 * @param Model model
	 */
	public void removeDeploymentListeners(Model model) {

		Map<Component, DeploymentListener> deploymentListenerMap = modelMap
			.get(model);
		if ((deploymentListenerMap == null)
			|| (deploymentListenerMap.size() == 0)) {
			return;
		}

		Collection<DeploymentListener> listeners = deploymentListenerMap
			.values();
		for (Iterator<DeploymentListener> i = listeners.iterator(); i.hasNext();) {
			DeploymentListener listener = i.next();
			listener.getInitialDomain().removeResourceSetListener(listener);
		}

		modelMap.remove(model);

	}

	/**
	 * Add a deployment listener for a component.
	 * @param Component component
	 */
	private void addDeploymentListener(Component component) {

		DeploymentListener newListener = new DeploymentListener(component);
		TransactionalEditingDomain domain = TransactionUtil
			.getEditingDomain(component);
		Model model = component.getModel();

		Map<Component, DeploymentListener> deploymentListenerMap = modelMap
			.get(model);

		if (deploymentListenerMap == null) {
			deploymentListenerMap = new WeakHashMap<Component, DeploymentListener>();
			modelMap.put(model, deploymentListenerMap);
		} else {
			DeploymentListener existingListener = deploymentListenerMap
				.get(component);
			if (existingListener != null) {
				existingListener.getInitialDomain().removeResourceSetListener(
					existingListener);
			}
		}
		deploymentListenerMap.put(component, newListener);
		domain.addResourceSetListener(newListener);
	}

	/**
	 * Remove the deployment listener for a component.
	 * 
	 * @param Component component
	 */
	private void removeDeploymentListener(Component component) {

		Model model = component.getModel();
		if (model == null) {
			removeDetachedDeploymentListener(component);
			return;
		}

		Map<Component, DeploymentListener> deploymentListenerMap = modelMap
			.get(model);
		if (deploymentListenerMap == null) {
			return;
		}

		DeploymentListener listener = deploymentListenerMap.remove(component);
		if (listener == null) {
			return;
		}

		listener.getInitialDomain().removeResourceSetListener(listener);

		if (deploymentListenerMap.size() == 0) {
			modelMap.remove(model);
		}
	}

	/**
	 * Remove the deployment listener for a component that no longer has
	 * an owner.
	 * This is called on a REMOVE event for a deployment component.
	 * 
	 * @param Component detachedComponent
	 */
	@SuppressWarnings("rawtypes")
	private void removeDetachedDeploymentListener(Component detachedComponent) {

		Set maps = modelMap.entrySet();

		Iterator mapIterator = maps.iterator();
		while (mapIterator.hasNext()) {
			Map.Entry entry = (Map.Entry) mapIterator.next();
			Map deploymentListenerMap = (Map) entry.getValue();

			boolean containsComponent = deploymentListenerMap
				.containsKey(detachedComponent);
			if (!containsComponent) {
				continue;
			}

			DeploymentListener listener = (DeploymentListener) deploymentListenerMap
				.remove(detachedComponent);
			listener.getInitialDomain().removeResourceSetListener(listener);
			if (deploymentListenerMap.size() == 0) {
				Model model = (Model) entry.getKey();
				modelMap.remove(model);
			}
			break;

		}
	}

	/**
	 * Return true if object is a zdl deployment component. False otherwise.
	 * 
	 * @param Object value
	 * @return boolean isDeploymentComponent
	 */
	private boolean isDeploymentComponent(Object object) {
		return ((object instanceof Component) && (ZDLUtil.isZDLConcept(
			(EObject) object, ZMLMMNames.DEPLOYMENT)));
	}
	
}
