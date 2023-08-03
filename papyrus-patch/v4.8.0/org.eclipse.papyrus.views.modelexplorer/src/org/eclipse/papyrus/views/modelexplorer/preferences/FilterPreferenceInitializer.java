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
 * This preference initializer for filter preferences.
 * @since 3.0
 */
public class FilterPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences specific filter field preferences.
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(IFilterPreferenceConstants.PREF_FILTER_LIVE_VALIDATION, IFilterPreferenceConstants.DEFAULT_FILTER_LIVE_VALIDATION_VALUE);
		store.setDefault(IFilterPreferenceConstants.PREF_FILTER_VALIDATION_DELAY, IFilterPreferenceConstants.DEFAULT_VALIDATION_DELAY_VALUE);
		store.setDefault(IFilterPreferenceConstants.PREF_FILTER_STEREOTYPE_REPLACED, IFilterPreferenceConstants.DEFAULT_FILTER_STEREOTYPE_REPLACED_VALUE);
	}

	/**
	 * Get the preference store.
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
