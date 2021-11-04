/*****************************************************************************
 * Copyright (c) 2018 CEA LIST.
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
 *  Vincent LORENZO - bug 541313 - [UML][CDO] UML calls to the method getCacheAdapter(EObject) must be replaced
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.adapters;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Adapter to manage interaction between volatile attributes (provided or required interfaces) of a port.
 */
public class PortTypeAdapter extends AdapterImpl {

	/** The adapter. */
	private Adapter adapter = null;

	/** The port. */
	private Port port = null;

	/** The feature. */
	private EStructuralFeature derivedFeature = null;

	/** The navigation feature to adapt. */
	private EStructuralFeature navigationFeature = null;


	/**
	 * Instantiates a new port type adapter.
	 *
	 * @param port
	 *            the port
	 * @param volatileFeature
	 *            the volatile feature
	 * @param navigationFeature
	 */
	public PortTypeAdapter(Port port, EStructuralFeature volatileFeature, EStructuralFeature navigationFeature) {

		this.port = port;
		this.derivedFeature = volatileFeature;
		this.navigationFeature = navigationFeature;

		if (port.getType() != null) {
			attachAdapter(null, port.getType());
		}
	}

	/**
	 * Notify changed.
	 *
	 * @param msg
	 *            the msg
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */

	@Override
	public void notifyChanged(Notification msg) {

		Object notificationFeature = msg.getFeature();

		// Listen only type setting on Port element
		if (notificationFeature != null && notificationFeature.equals(UMLPackage.Literals.TYPED_ELEMENT__TYPE)) {
			switch (msg.getEventType()) {

			case Notification.SET:
				Type newType = (Type) msg.getNewValue();
				if (newType != null) {

					// Set a type to Port
					attachAdapter((Type) msg.getOldValue(), newType);
					updateObservableList();
				} else {

					// Unset type to port
					detachAdapter((Type) msg.getOldValue());
					updateObservableList();
				}
				break;
			default:
				// Nothing to do
				break;
			}
		}
	}

	/**
	 * Detach adapter of old type.
	 *
	 * @param type
	 *            Type where adapter will be removed
	 *
	 */
	private void detachAdapter(Type type) {
		if (type == null) {
			return;
		}
		EObject source = determineSource(type);
		source.eAdapters().remove(adapter);
	}

	/**
	 * Attach adapter to setted type.
	 *
	 * @param newType
	 *            Type where adapter will be added
	 */
	private void attachAdapter(Type oldType, Type newType) {

		EObject newSource = determineSource(newType);
		if (newSource != null) {

			// Dispose adapter on old type
			if (oldType != null && adapter != null) {
				EObject oldSource = determineSource(oldType);

				if (!oldSource.equals(newSource)) {
					oldSource.eAdapters().remove(adapter);
				}
			}

			// Attach adapter for new type
			if (adapter == null || !newSource.eAdapters().contains(adapter)) {

				// Create a new one only if source don't have already one because last type can have same source to observe
				adapter = new DerivedAttributeAdapter(newSource, derivedFeature, navigationFeature, UMLPackage.Literals.DEPENDENCY__SUPPLIER, Notification.ADD) {

					@Override
					protected void notifyDerivedAttributeChange(Notification notification) {
						if (UMLPackage.Literals.DEPENDENCY__SUPPLIER.equals(notification.getFeature())) {
							port.eNotify(new ENotificationImpl((InternalEObject) port, notification.getEventType(), derivedFeature, notification.getOldValue(), notification.getNewValue()));
						} else if (Notification.REMOVE == notification.getEventType()) {
							port.eNotify(new ENotificationImpl((InternalEObject) port, notification.getEventType(), derivedFeature, notification.getOldValue(), notification.getNewValue()));
						}
					};
				};
			}
		}
	}

	/**
	 * Determine on which element the adapter will be attached/detached according derived feature.
	 * <p>
	 * <b>Warning</b>: Result can be <code>null</code> for case of Required interfaces when Type was not yet affected to container.
	 * </p>
	 *
	 * @param type
	 *            Type is origin of evaluation
	 * @return
	 * 		Source according of derived feature
	 */
	private EObject determineSource(Type type) {
		EObject source = type;

		if (UMLPackage.Literals.PORT__REQUIRED.equals(derivedFeature)) {
			source = type.eContainer();
		}

		return source;
	}

	/**
	 * Fire observable list.
	 *
	 * @param type
	 *            the type
	 */
	private void updateObservableList() {

		// Clear cache for derived feature
		CacheAdapter cache = CacheAdapter.getInstance();
		if (cache != null) {
			cache.put(port, derivedFeature, null);
		}

		// Notify observers
		port.eNotify(new ENotificationImpl((InternalEObject) port, Notification.SET, derivedFeature, null, port.eGet(derivedFeature), true));
	}
}
