/*****************************************************************************
 * Copyright (c) 2014, 2018 Christian W. Damus and others.
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
 *   Pauline DEVILLE - Bug 529707
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.helper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * Protocol for a delegate that assists any UI elements dealing with profile applications in the manipulation of those profile applications.
 * Many UI components may just want to use the {@linkplain Default default implementation}.
 * 
 * @see Default
 */
public interface IProfileApplicationDelegate {
	/**
	 * Queries whether I am applicable to (support introspection/manipulation of) profile applications of the given package.
	 * 
	 * @param package_
	 *            a package
	 * @return whether I am the delegate that should be used to introspect/manipulate profile applications of the given package
	 */
	boolean appliesTo(Package package_);

	/**
	 * Queries the profile applications of a package to manage in the UI.
	 * 
	 * @param package_
	 *            a package presented in the UI
	 * @return its profile applications
	 */
	Iterable<ProfileApplication> getProfileApplications(Package package_);

	/**
	 * Queries the existing application, if any, of the given {@code profile} directly to a package (not an inherited profile application).
	 * 
	 * @param package_
	 *            a package
	 * @param profile
	 *            a profile that may or may not be directly applied
	 * 
	 * @return the application of the {@code profile} specifically to the given package, or {@code null} if either the package does not have the profile applied or the profile application is inherited
	 */
	ProfileApplication getProfileApplication(Package package_, Profile profile);

	/**
	 * Applies the specified {@code profile} to a package in a given {@link context}.
	 * 
	 * @param package_
	 *            the package to which to apply the {@code profile}. The profile must not already be applied
	 * @param profile
	 *            the profile to apply
	 * @param context
	 *            a context in which to apply the profile, which may be the same as or a nesting package of the applying package, or some distinct other package
	 *            altogether (such as a profile-application model)
	 * @param monitor
	 *            an optional monitor for reporting profile re-application progress (may be {@code null})
	 * 
	 * @return any new stereotype applications created as a consequence of required metaclass extensions
	 */
	EList<EObject> applyProfile(Package package_, Profile profile, Package context, IProgressMonitor monitor);

	/**
	 * Queries whether I am applicable to (support introspection/manipulation of) a given profile application.
	 * 
	 * @param profileApplication
	 *            a profile application
	 * @return whether I am the delegate that should be used to introspect/manipulate the profile application
	 */
	boolean appliesTo(ProfileApplication profileApplication);

	/**
	 * Queries the package that applies a profile via the specific application.
	 * 
	 * @param profileApplication
	 *            a profile application
	 * @return that package to which it applies a profile
	 */
	Package getApplyingPackage(ProfileApplication profileApplication);

	/**
	 * Queries the profile applied by the specified application.
	 * 
	 * @param profileApplication
	 *            a profile application
	 * @return the profile that it applies
	 */
	Profile getAppliedProfile(ProfileApplication profileApplication);

	/**
	 * Re-applies the specified {@code profile} to a package.
	 * 
	 * @param package_
	 *            the package to which to re-apply the {@code profile}. The profile must already be applied
	 * @param profile
	 *            the profile to re-apply
	 * @param monitor
	 *            an optional monitor for reporting profile re-application progress (may be {@code null})
	 * 
	 * @return any new stereotype applications created as a consequence of required metaclass extensions
	 */
	EList<EObject> reapplyProfile(Package package_, Profile profile, IProgressMonitor monitor);

	/**
	 * Get the preference constant
	 * @since 4.0
	 */
	String getPreferenceConstant();

	/**
	 * Get the preference label
	 * @since 4.0
	 */
	String getPreferenceLabel();


	//
	// Nested types
	//

	/**
	 * A simple implementation of the profile-application delegate protocol that just provides the UML standard
	 * properties of a profile application.
	 */
	class Default implements IProfileApplicationDelegate {
		public boolean appliesTo(Package package_) {
			return true;
		}

		public Iterable<ProfileApplication> getProfileApplications(Package package_) {
			return package_.getProfileApplications();
		}

		public ProfileApplication getProfileApplication(Package package_, Profile profile) {
			return package_.getProfileApplication(profile);
		}

		public EList<EObject> applyProfile(Package package_, Profile profile, Package context, IProgressMonitor monitor) {
			// I just simply apply the profile (I don't handle weird context scenarios)
			return package_.applyProfile(profile);
		}

		public boolean appliesTo(ProfileApplication profileApplication) {
			return true;
		}

		public Package getApplyingPackage(ProfileApplication profileApplication) {
			return profileApplication.getApplyingPackage();
		}

		public Profile getAppliedProfile(ProfileApplication profileApplication) {
			return profileApplication.getAppliedProfile();
		}

		public EList<EObject> reapplyProfile(Package package_, Profile profile, IProgressMonitor monitor) {
			return package_.applyProfile(profile);
		}

		public String getPreferenceConstant() {
			return getPrefCons();
		}

		public String getPreferenceLabel() {
			return "Default reapply tool"; //$NON-NLS-1$
		}

		private static String getPrefCons() {
			return "default_delegate"; //$NON-NLS-1$
		}
	}
}
