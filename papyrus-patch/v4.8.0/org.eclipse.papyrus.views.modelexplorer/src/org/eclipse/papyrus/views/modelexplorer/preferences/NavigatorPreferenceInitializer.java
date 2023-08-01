/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.views.modelexplorer.Activator;

/**
 * This preference initializer initializes diagram preferences specific to the
 * activity diagram.
 */
public class NavigatorPreferenceInitializer extends
		AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences specific to the activity diagram
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		// preference for showing popup dialog when transform element command is
		// performed
		store.setDefault(
				INavigatorPreferenceConstants.PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP,
				false);

		// By default the model explorer expand node on double click
		store.setDefault(
				INavigatorPreferenceConstants.PREF_EXPAND_NODE_ON_DOUBLE_CLICK,
				true);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
