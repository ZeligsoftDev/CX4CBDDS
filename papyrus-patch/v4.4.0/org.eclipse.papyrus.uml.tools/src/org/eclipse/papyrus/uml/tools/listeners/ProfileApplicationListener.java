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

package org.eclipse.papyrus.uml.tools.listeners;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.papyrus.uml.tools.helper.ProfileApplicationDelegateRegistry;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * A listener that detects various kinds of complex profile application changes and sends more abstract notifications to listeners.
 */
public class ProfileApplicationListener extends ResourceSetListenerImpl {

	public ProfileApplicationListener() {
		super(NotificationFilter.NOT_TOUCH.and(
				NotificationFilter.createFeatureFilter(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE).or(
						NotificationFilter.createFeatureFilter(UMLPackage.Literals.PACKAGE__PROFILE_APPLICATION))));
	}

	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		Multimap<Package, ProfileApplication> applications = HashMultimap.create();
		Multimap<Package, ProfileApplication> unapplications = HashMultimap.create();
		Map<ProfileApplication, Profile> applied = Maps.newHashMap();
		Map<ProfileApplication, Profile> unapplied = Maps.newHashMap();

		for (Notification next : event.getNotifications()) {
			if (next.getFeature() == UMLPackage.Literals.PACKAGE__PROFILE_APPLICATION) {
				Package package_ = (Package) next.getNotifier();

				// Gather profile applications added and removed
				switch (next.getEventType()) {
				case Notification.ADD:
				case Notification.ADD_MANY: {
					for (Object newValue : asIterable(next.getNewValue())) {
						ProfileApplication application = (ProfileApplication) newValue;

						// If it was added somewhere else previously in this transaction, forget about that because it's here, now
						applications.values().remove(application);
						applications.put(package_, application);
					}
				}
					break;
				case Notification.REMOVE:
				case Notification.REMOVE_MANY: {
					for (Object oldValue : asIterable(next.getOldValue())) {
						ProfileApplication application = (ProfileApplication) oldValue;

						// The first removal is the only one that actually matters, but then also only if it wasn't previously added
						if (!unapplications.values().contains(application)) {
							if (!applications.remove(package_, application)) {
								unapplications.put(package_, application);
							}
						}
					}
				}
					break;
				case Notification.SET: {
					ProfileApplication application = (ProfileApplication) next.getNewValue();

					if (application != null) {
						// If it was added somewhere else previously in this transaction, forget about that because it's here, now
						applications.values().remove(application);
						applications.put(package_, application);
					}

					application = (ProfileApplication) next.getOldValue();

					if (application != null) {

						// The first removal is the only one that actually matters
						if (!unapplications.values().contains(application)) {
							unapplications.put(package_, application);
						}
					}
				}
					break;
				}
			} else if (next.getFeature() == UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE) {
				ProfileApplication application = (ProfileApplication) next.getNotifier();

				// Gather profiles applied and unapplied
				switch (next.getEventType()) {
				case Notification.SET:
					Profile newValue = (Profile) next.getNewValue();
					Profile oldValue = (Profile) next.getOldValue();

					if (newValue != null) {
						applied.put(application, newValue);
					} else {
						// It doesn't matter what was previously applied within this transaction
						applied.remove(application);
					}

					if (oldValue != null) {
						if (!unapplied.containsKey(application) && !applications.containsEntry(application.getApplyingPackage(), application)) {
							// Only the first removal actually matters, and then only if this isn't in an application that was only added
							// in this transaction to begin with
							unapplied.put(application, oldValue);
						}
					}
				}
			}
		}

		// Now, synthesize the changes we've gathered
		for (Map.Entry<Package, ProfileApplication> next : unapplications.entries()) {
			Package package_ = next.getKey();
			ProfileApplication application = next.getValue();
			Profile profile = application.getAppliedProfile();

			if (profile != null) {
				// Still references the applied profile, so that is the profile that was unapplied
				unapplied.remove(application);
			} else {
				profile = unapplied.remove(application);
			}

			if (profile != null) {
				ProfileApplicationNotification.notify(package_, ProfileApplicationNotification.PROFILE_UNAPPLIED, profile, false);
			}
		}
		for (Map.Entry<ProfileApplication, Profile> next : unapplied.entrySet()) {
			// Handle left-overs
			ProfileApplication application = next.getKey();
			Profile profile = next.getValue();
			Package package_ = getApplyingPackage(application);

			if (package_ != null) {
				// If the package is not the one that owns the application, then it was not actually modified, so this is a touch on it
				boolean touch = package_ != application.getApplyingPackage();
				ProfileApplicationNotification.notify(package_, ProfileApplicationNotification.PROFILE_UNAPPLIED, profile, touch);
			}
		}
		for (Map.Entry<Package, ProfileApplication> next : applications.entries()) {
			ProfileApplication application = next.getValue();
			Package package_ = getApplyingPackage(application);
			Profile profile = application.getAppliedProfile(); // At transaction's end, this is the truth

			applied.remove(application);

			if (profile != null) {
				// If the package is not the one that owns the application, then it was not actually modified, so this is a touch on it
				boolean touch = package_ != application.getApplyingPackage();
				ProfileApplicationNotification.notify(package_, ProfileApplicationNotification.PROFILE_APPLIED, profile, touch);
			}
		}
		for (Map.Entry<ProfileApplication, Profile> next : applied.entrySet()) {
			// Handle left-overs
			ProfileApplication application = next.getKey();
			Profile profile = next.getValue();
			Package package_ = getApplyingPackage(application);

			if (package_ != null) {
				// If the package is not the one that owns the application, then it was not actually modified, so this is a touch on it
				boolean touch = package_ != application.getApplyingPackage();
				ProfileApplicationNotification.notify(package_, ProfileApplicationNotification.PROFILE_APPLIED, profile, touch);
			}
		}
	}

	private Package getApplyingPackage(ProfileApplication application) {
		// Hook to support externalized profile applications
		return ProfileApplicationDelegateRegistry.INSTANCE.getDelegate(application).getApplyingPackage(application);
	}

	static Iterable<?> asIterable(Object value) {
		return (value instanceof Iterable<?>) ? (Iterable<?>) value : ECollections.singletonEList(value);
	}

	public static boolean isProfileApplicationNotification(Notification notification) {
		return (notification != null) && (notification.getNotifier() instanceof Package) && (notification instanceof ProfileApplicationNotification);
	}

	//
	// Nested types
	//

	/**
	 * <p>
	 * A specialized notification indicating that a profile was added to or removed from a {@link Package}'s {@linkplain Package#getAppliedProfiles() applied profiles}. As this is an operation, the notification has no source {@link Notification#getFeature()
	 * feature}.
	 * </p>
	 * <p>
	 * The {@link Notification#getEventType() event type} will always be one of
	 * </p>
	 * <ul>
	 * <li>{@link #PROFILE_APPLIED}</li>
	 * <li>{@link #PROFILE_UNAPPLIED}</li>
	 * </ul>
	 */
	public static class ProfileApplicationNotification extends ENotificationImpl {

		/**
		 * Indicates that a profile was added to the {@link Package#getAppliedProfiles()} list.
		 */
		public static final int PROFILE_APPLIED = Notification.EVENT_TYPE_COUNT + 30;

		/**
		 * Indicates that a profile was removed from the {@link Package#getAppliedProfiles()} list.
		 */
		public static final int PROFILE_UNAPPLIED = Notification.EVENT_TYPE_COUNT + 31;

		private final boolean touch;

		private ProfileApplicationNotification(Package package_, int eventType, Profile profile, boolean touch) {
			super((InternalEObject) package_, eventType, NO_FEATURE_ID, (eventType == PROFILE_APPLIED) ? null : profile, (eventType == PROFILE_APPLIED) ? profile : null, NO_INDEX);

			this.touch = touch;
		}

		/**
		 * Injects a profile-applied notification on the notifying {@link package_}'s behalf. Such notifications are, by definition, {@linkplain Notification#isTouch() touches} because otherwise the listener would have detected the change
		 * and synthesized the notification for itself.
		 * 
		 * @param package_
		 *            a package
		 * @param profile
		 *            a profile that is to be considered to have been applied to the {@link package_}
		 */
		public static void notifyProfileApplied(Package package_, Profile profile) {
			notify(package_, PROFILE_APPLIED, profile, true);
		}

		/**
		 * Injects a profile-unapplied notification on the notifying {@link package_}'s behalf. Such notifications are, by definition, {@linkplain Notification#isTouch() touches} because otherwise the listener would have detected the change
		 * and synthesized the notification for itself.
		 * 
		 * @param package_
		 *            a package
		 * @param profile
		 *            a profile that is to be considered to have been unapplied from the {@link package_}
		 */
		public static void notifyProfileUnapplied(Package package_, Profile profile) {
			notify(package_, PROFILE_UNAPPLIED, profile, true);
		}

		static void notify(Package package_, int eventType, Profile profile, boolean touch) {
			if (((BasicNotifierImpl) package_).eNotificationRequired()) {
				ProfileApplicationNotification notification = new ProfileApplicationNotification(package_, eventType, profile, touch);
				notification.dispatch();
			}
		}

		@Override
		public boolean isTouch() {
			return touch;
		}

		public Package getNotifyingPackage() {
			return (Package) getNotifier();
		}

		public Profile getAppliedProfile() {
			return (Profile) getNewValue();
		}

		public Profile getUnappliedProfile() {
			return (Profile) getOldValue();
		}
	}
}
