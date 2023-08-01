/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.views.modelexplorer.Activator;

/**
 * This preference initializer for expand preferences.
 * @since 3.0
 */
public class ExpandPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences for expand preferences.
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(IExpandPreferenceConstants.PREF_MAX_LEVEL_TO_EXPAND, IExpandPreferenceConstants.DEFAULT_MAX_LEVEL_TO_EXPAND_VALUE);
	}

	/**
	 * Get the preference store.
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
