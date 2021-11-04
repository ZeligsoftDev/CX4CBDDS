/*****************************************************************************
 * Copyright (c) 2014 Christian W. Damus and others.
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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * A registry of {@link IProfileApplicationDelegate} plugged in on my extension point.
 */
public class ProfileApplicationDelegateRegistry {

	private static final String EXT_POINT = "profileApplicationDelegates"; //$NON-NLS-1$

	private static final IProfileApplicationDelegate NULL_DELEGATE = new IProfileApplicationDelegate.Default() {
		@Override
		public boolean appliesTo(ProfileApplication profileApplication) {
			return false;
		}
	};

	public static final ProfileApplicationDelegateRegistry INSTANCE = new ProfileApplicationDelegateRegistry();

	/**
	 * @since 4.0
	 */
	public final List<IProfileApplicationDelegate> delegates = new java.util.ArrayList<IProfileApplicationDelegate>(3);

	private boolean needPrune;

	private ProfileApplicationDelegateRegistry() {
		super();

		new MyRegistryReader().readRegistry();

		// And the default delegate to backstop the plug-ins
		delegates.add(new IProfileApplicationDelegate.Default());
	}

	/**
	 * Prune out any null providers (failed to initialize) and replace
	 * descriptors that have been instantiated by their instances, to avoid
	 * delegation.
	 */
	private void prune() {
		if (needPrune) {
			needPrune = false;
			for (ListIterator<IProfileApplicationDelegate> iter = delegates.listIterator(); iter.hasNext();) {

				IProfileApplicationDelegate next = iter.next();
				if (next == NULL_DELEGATE) {
					iter.remove();
				} else if (next instanceof MyRegistryReader.Descriptor) {
					MyRegistryReader.Descriptor desc = (MyRegistryReader.Descriptor) next;
					if (desc.instance != null) {
						iter.set(desc.instance);
					}
				}
			}
		}
	}

	public IProfileApplicationDelegate getDelegate(Package package_) {
		IProfileApplicationDelegate result = NULL_DELEGATE;

		synchronized (delegates) {
			prune();

			for (IProfileApplicationDelegate next : delegates) {
				if (next.appliesTo(package_)) {
					final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
					String preference = prefStore.getString(ProfileApplicationDelegatePreferenceInitializer.PROFILE_APPLICATION_DELEGATE_PREFERENCE);
					if (preference.equals(next.getPreferenceConstant())) {
						result = next;
						break;
					}
				}
			}
		}

		return result;
	}

	public IProfileApplicationDelegate getDelegate(ProfileApplication profileApplication) {
		IProfileApplicationDelegate result = NULL_DELEGATE;

		synchronized (delegates) {
			prune();

			for (IProfileApplicationDelegate next : delegates) {
				if (next.appliesTo(profileApplication)) {
					final IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
					String preference = prefStore.getString(ProfileApplicationDelegatePreferenceInitializer.PROFILE_APPLICATION_DELEGATE_PREFERENCE);
					if (preference.equals(next.getPreferenceConstant())) {
						result = next;
						break;
					}
				}
			}
		}

		return result;
	}

	private void removeProvider(String className) {
		synchronized (delegates) {
			for (Iterator<IProfileApplicationDelegate> iter = delegates.iterator(); iter.hasNext();) {

				IProfileApplicationDelegate next = iter.next();
				if (next instanceof MyRegistryReader.Descriptor) {
					MyRegistryReader.Descriptor desc = (MyRegistryReader.Descriptor) next;
					if (className.equals(desc.getClassName())) {
						iter.remove();
						break;
					}
				} else if (className.equals(next.getClass().getName())) {
					iter.remove();
					break;
				}
			}
		}
	}

	//
	// Nested types
	//

	private class MyRegistryReader extends RegistryReader {

		private static final String A_CLASS = "class"; //$NON-NLS-1$

		private static final String E_DELEGATE = "delegate"; //$NON-NLS-1$

		private Descriptor currentDescriptor;

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_POINT);
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			return add ? handleAdd(element) : handleRemove(element);
		}

		private boolean handleAdd(IConfigurationElement element) {
			boolean result = false;

			if (E_DELEGATE.equals(element.getName())) {
				if (element.getAttribute(A_CLASS) == null) {
					logMissingAttribute(element, A_CLASS);
				} else {
					currentDescriptor = new Descriptor(element, A_CLASS);
					delegates.add(currentDescriptor);
				}

				result = true;
			}

			return result;
		}

		private boolean handleRemove(IConfigurationElement element) {
			boolean result = true;

			if (E_DELEGATE.equals(element.getName())) {
				String className = element.getAttribute(A_CLASS);
				if (className == null) {
					logMissingAttribute(element, A_CLASS);
					result = false;
				} else {
					removeProvider(className);
				}
			}

			return result;
		}

		private class Descriptor extends PluginClassDescriptor implements IProfileApplicationDelegate {

			private IProfileApplicationDelegate instance;

			Descriptor(IConfigurationElement element, String attributeName) {
				super(element, attributeName);
			}

			String getClassName() {
				return element.getAttribute(attributeName);
			}

			IProfileApplicationDelegate getInstance() {
				if (instance == null) {
					try {
						instance = (IProfileApplicationDelegate) createInstance();
					} catch (Exception e) {
						Activator.log.error("Failed to instantiate profile-application delegate extension.", e);
						instance = NULL_DELEGATE;
					}

					needPrune = true;
				}

				return instance;
			}

			public boolean appliesTo(Package package_) {
				return getInstance().appliesTo(package_);
			}

			public boolean appliesTo(ProfileApplication profileApplication) {
				return getInstance().appliesTo(profileApplication);
			}

			public Iterable<ProfileApplication> getProfileApplications(Package package_) {
				return getInstance().getProfileApplications(package_);
			}

			public ProfileApplication getProfileApplication(Package package_, Profile profile) {
				return getInstance().getProfileApplication(package_, profile);
			}

			public EList<EObject> applyProfile(Package package_, Profile profile, Package context, IProgressMonitor monitor) {
				return getInstance().applyProfile(package_, profile, context, monitor);
			}

			public Package getApplyingPackage(ProfileApplication profileApplication) {
				return getInstance().getApplyingPackage(profileApplication);
			}

			public Profile getAppliedProfile(ProfileApplication profileApplication) {
				return getInstance().getAppliedProfile(profileApplication);
			}

			public EList<EObject> reapplyProfile(Package package_, Profile profile, IProgressMonitor monitor) {
				return getInstance().reapplyProfile(package_, profile, monitor);
			}

			public String getPreferenceConstant() {
				return getInstance().getPreferenceConstant();
			}

			public String getPreferenceLabel() {
				return getInstance().getPreferenceLabel();
			}
		}
	}
}
