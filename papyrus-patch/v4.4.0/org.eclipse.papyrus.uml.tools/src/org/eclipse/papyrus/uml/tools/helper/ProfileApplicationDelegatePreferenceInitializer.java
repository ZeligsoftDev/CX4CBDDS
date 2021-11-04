/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.helper;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.tools.Activator;

/**
 * @since 4.0
 *
 */
public class ProfileApplicationDelegatePreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String PROFILE_APPLICATION_DELEGATE_PREFERENCE = "profile_application_delegate"; //$NON-NLS-1$

	public static final String PREFERENCE_CONSTANT_FOR_DEFAULT = "externalized_profile_application_delegate"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 *
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(PROFILE_APPLICATION_DELEGATE_PREFERENCE, PREFERENCE_CONSTANT_FOR_DEFAULT);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

}
