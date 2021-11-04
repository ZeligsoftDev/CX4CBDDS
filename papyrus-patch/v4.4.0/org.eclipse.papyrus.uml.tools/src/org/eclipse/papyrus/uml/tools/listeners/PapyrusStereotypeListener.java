/*****************************************************************************
 * Copyright (c) 2009, 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.service.StereotypeElementService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Listener for stereotypes application/deapplication.
 *
 * @deprecated Please use {@link StereotypeElementListener} and the service {@link StereotypeElementService}.
 * @author remi.schnekenburger@cea.fr
 */
@Deprecated
public class PapyrusStereotypeListener implements IPapyrusListener {

	/**
	 * An {@link Notification#getEventType event type} indicating that a
	 * stereotype has been applied to the notifier
	 *
	 * @see Notification#getEventType
	 */
	public static final int APPLIED_STEREOTYPE = 20;

	/**
	 * An {@link Notification#getEventType event type} indicating that a
	 * stereotype has been unapplied to the notifier
	 *
	 * @see Notification#getEventType
	 */
	public static final int UNAPPLIED_STEREOTYPE = 21;

	/**
	 * An {@link Notification#getEventType event type} indicating that a
	 * stereotype has been unapplied to the notifier
	 *
	 * @see Notification#getEventType
	 */
	public static final int MODIFIED_STEREOTYPE = 22;

	/**
	 * Creates a new PapyrusStereotypeListener.
	 */
	public PapyrusStereotypeListener() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		// feature should be the base_class feature
		// check this is a EStructuralFeature that is changed. Could be
		// something else ?!
		final EStructuralFeature feature;

		if (!(notification.getFeature() instanceof EStructuralFeature)) {
			return;
		}

		feature = (EStructuralFeature) notification.getFeature();

		if (!isBaseElementChanged(feature)) {
			// stereotype itself has changed.
			EObject notifier = EMFHelper.asEMFModelElement(notification.getNotifier());
			// notifier may be the stereotype application
			if (notifier != null) {
				EObject baseElement = UMLUtil.getBaseElement(notifier);
				if (baseElement instanceof Element) {
					// notifier listeners for the base element
					StereotypeCustomNotification newNotification = new StereotypeCustomNotification((InternalEObject) baseElement, MODIFIED_STEREOTYPE, feature.getFeatureID(), null, notification.getNotifier());
					baseElement.eNotify(newNotification);
				}
			}
			return;
		}

		// check the SET base Element for stereotype elements.... if this is
		// this kind of element
		if (Notification.SET != notification.getEventType()) {
			return;
		}

		// should retrieve the element on which modification is done. This
		// should be the new value
		// of the notification
		int notificationValue;
		Object value = notification.getNewValue(); // this should be the
													// stereotyped element
		if (value instanceof Element) {
			// check the notifier (stereotype application) is in the list of
			// stereotypes for the
			// element
			boolean isStereoApplication = ((Element) value).getStereotypeApplications().contains(notification.getNotifier());
			if (!isStereoApplication) {
				return;
			}
			// we are sure this is a new stereotype application
			notificationValue = APPLIED_STEREOTYPE;
		}
		else {
			value = notification.getOldValue();
			if (!(value instanceof Element)) {
				return;
			}
			// check that the notifier (stereotype application) is NOT in the
			// list of stereotypes for the
			// element
			boolean isStereoApplication = ((Element) value).getStereotypeApplications().contains(notification.getNotifier());
			if (isStereoApplication) {
				return;
			}
			// element is no longer applied.
			notificationValue = UNAPPLIED_STEREOTYPE;
		}

		// emit notification, so its edit parts can react
		StereotypeCustomNotification newNotification = new StereotypeCustomNotification((InternalEObject) value, notificationValue, feature.getFeatureID(), null, notification.getNotifier());
		((Element) value).eNotify(newNotification);
	}

	/**
	 * checks if the notifier modified feature is the feature modified by
	 * stereotype applications
	 *
	 * @return <code>true</code> if the feature of the notification is the
	 *         "base_XXX" feature, else return <code>false</code>.
	 */
	private boolean isBaseElementChanged(EStructuralFeature feature) {
		return feature.getName().startsWith(Extension.METACLASS_ROLE_PREFIX);
		// && (element == null ||
		// eStructuralFeature.getEType().isInstance(element))) {
	}

	/**
	 * Specific notification handled by this listener.
	 * <p>
	 * It implements the {@link ENotificationImpl} notification, as it is filtered bye GMF. It should be possible to further inspect how notification are filtered, and so, do not use hidden APIs.
	 * </p>
	 */
	public class StereotypeCustomNotification extends ENotificationImpl {

		/**
		 * Creates a new StereotypeCustomeNotification
		 *
		 * @param notifier
		 *            the notifier that sends this notification
		 * @param eventType
		 *            the type of event
		 * @param featureID
		 *            the kind of feature modified that caused this modification
		 * @param oldValue
		 *            the old value of the modified feature
		 * @param newValue
		 *            the new value of the modified feature
		 */
		public StereotypeCustomNotification(InternalEObject notifier, int eventType, int featureID, Object oldValue, Object newValue) {
			super(notifier, eventType, featureID, oldValue, newValue);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isTouch() {
			return false;
		}

	}
}
