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
 *   Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.internal.uml.properties.profile.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;


/**
 * The preference initializer for the preferences concerning the Profile Tab of the property view
 * 
 * @noextend
 */
public class ProfileTabPreferencesInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences
	 */
	@Override
	public void initializeDefaultPreferences() {
		ProfileTabPreferences.initializeDefaultValue();
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return ProfileTabPreferences.getPreferenceStore();
	}
}
