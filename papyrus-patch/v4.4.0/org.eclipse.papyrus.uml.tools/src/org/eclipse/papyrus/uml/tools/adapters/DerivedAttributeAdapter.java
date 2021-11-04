/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;


/**
 * Adapter for derived attribute.</br>
 *
 * Based on article : <a href="http://wiki.eclipse.org/EMF/Recipes#Recipe:_Derived_Attribute_Notifier">Derived Attribute Notifier</a>
 *
 * @author Gabriel Pascual
 */
public class DerivedAttributeAdapter extends AdapterImpl {

	/** The source. */
	private InternalEObject source;

	/** The derived feature. */
	private EStructuralFeature derivedFeature;

	/** The local features. */
	private List<EStructuralFeature> localFeatures = new ArrayList<EStructuralFeature>();

	/** The navigation feature. */
	private EStructuralFeature navigationFeature = null;

	/** The dependant adapter. */
	private Adapter dependantAdapter = null;


	/**
	 * Instantiates a new derived attribute adapter.
	 *
	 * @param source
	 *            the source
	 * @param derivedFeature
	 *            the derived feature
	 * @param navigationFeature
	 *            the navigation feature
	 * @param dependantFeature
	 *            the dependant feature
	 * @param eventType
	 *            the event type
	 */
	public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature navigationFeature, EStructuralFeature dependantFeature, int eventType) {
		this(source, derivedFeature);
		addNavigatedDependency(navigationFeature, dependantFeature, eventType);
	}

	/**
	 * Instantiates a new derived attribute adapter.
	 *
	 * @param source
	 *            the source
	 * @param derivedFeature
	 *            the derived feature
	 * @param navigationFeature
	 *            the navigation feature
	 * @param dependentFeaturesMap
	 *            the dependent features map
	 */
	public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature navigationFeature, Map<EStructuralFeature, Integer> dependentFeaturesMap) {
		this(source, derivedFeature);

		addNavigatedDependency(navigationFeature, dependentFeaturesMap);

	}


	/**
	 * Instantiates a new derived attribute adapter.
	 *
	 * @param source
	 *            the source
	 * @param derivedFeature
	 *            the derived feature
	 * @param localFeature
	 *            the local feature
	 */
	public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature, EStructuralFeature localFeature) {
		this(source, derivedFeature);
		addLocalDependency(localFeature);
	}

	/**
	 * Instantiates a new derived attribute adapter.
	 *
	 * @param source
	 *            the source
	 * @param derivedFeature
	 *            the derived feature
	 */
	public DerivedAttributeAdapter(EObject source, EStructuralFeature derivedFeature) {
		super();
		this.source = (InternalEObject) source;
		this.derivedFeature = derivedFeature;
		source.eAdapters().add(this);
	}

	/**
	 * Adds the navigated dependency.
	 *
	 * @param navigationFeature
	 *            the navigation feature
	 * @param dependentFeaturesMap
	 *            the dependent features map
	 */
	public void addNavigatedDependency(EStructuralFeature navigationFeature, Map<EStructuralFeature, Integer> dependentFeaturesMap) {
		this.navigationFeature = navigationFeature;
		this.dependantAdapter = new DependentFeatureAdapter(dependentFeaturesMap);
	}

	/**
	 * Adds the navigated dependency.
	 *
	 * @param navigationFeature
	 *            the navigation feature
	 * @param dependantFeature
	 *            the dependant feature
	 * @param eventType
	 *            the event type
	 */
	public void addNavigatedDependency(EStructuralFeature navigationFeature, EStructuralFeature dependantFeature, int eventType) {
		this.navigationFeature = navigationFeature;
		this.dependantAdapter = new DependentFeatureAdapter(eventType, dependantFeature);
	}

	/**
	 * Adds the local dependency.
	 *
	 * @param localFeature
	 *            the local feature
	 */
	public void addLocalDependency(EStructuralFeature localFeature) {
		localFeatures.add(localFeature);
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void notifyChanged(Notification notification) {
		Object notificationFeature = notification.getFeature();
		if (notificationFeature != null && notificationFeature.equals(navigationFeature)) {
			switch (notification.getEventType()) {
			case Notification.ADD:
				EObject added = (EObject) notification.getNewValue();
				added.eAdapters().add(dependantAdapter);
				break;
			case Notification.SET:
				EObject newValue = (EObject) notification.getNewValue();
				EObject oldValue = (EObject) notification.getOldValue();
				if (oldValue != null) {
					oldValue.eAdapters().remove(dependantAdapter);
				}
				if (newValue != null) {
					newValue.eAdapters().add(dependantAdapter);
				}
				break;
			case Notification.REMOVE:
				EObject removed = (EObject) notification.getOldValue();
				removed.eAdapters().remove(dependantAdapter);
				break;
			default:
				return; // No notification
			}
			notifyDerivedAttributeChange(notification);
		} else if (localFeatures.contains(notificationFeature)) {
			notifyDerivedAttributeChange(notification);
		}
	}

	/**
	 * Notify derived attribute change.
	 * <p>
	 * The default implementation notifies the source element with notification.
	 * </p>
	 *
	 * @param msg
	 *            the msg
	 */
	protected void notifyDerivedAttributeChange(Notification msg) {
		if (source.eNotificationRequired()) {
			source.eNotify(getNotification());
		}
	}

	/**
	 * Gets the notification.
	 * <p>
	 * Default implementation build a notification of type SET with the source and associated derived attribute as new value.
	 * </p>
	 *
	 * @return the notification
	 */
	protected Notification getNotification() {
		return new ENotificationImpl(source, Notification.SET, derivedFeature, null, source.eGet(derivedFeature, true, true));
	}

	/**
	 * Adapter to observe modification of dependent feature.
	 */
	private class DependentFeatureAdapter extends AdapterImpl {

		/** The dependent features map. */
		private Map<EStructuralFeature, Integer> dependentFeaturesMap = new HashMap<EStructuralFeature, Integer>();

		/**
		 * Instantiates a new dependent feature adapter.
		 *
		 * @param eventType
		 *            the event type
		 * @param feature
		 *            the feature
		 */
		public DependentFeatureAdapter(int eventType, EStructuralFeature feature) {
			super();
			dependentFeaturesMap.put(feature, Integer.valueOf(eventType));

		}

		/**
		 * Instantiates a new dependent feature adapter.
		 *
		 * @param dependentFeaturesMap
		 *            the dependent features map
		 */
		public DependentFeatureAdapter(Map<EStructuralFeature, Integer> dependentFeaturesMap) {
			super();
			this.dependentFeaturesMap.putAll(dependentFeaturesMap);
		}

		/**
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 *
		 * @param notification
		 */

		@Override
		public void notifyChanged(Notification notification) {
			if (dependentFeaturesMap.containsKey(notification.getFeature()) && dependentFeaturesMap.get(notification.getFeature()).equals(notification.getEventType())) {
				notifyDerivedAttributeChange(notification);
			}
		}
	}


}
