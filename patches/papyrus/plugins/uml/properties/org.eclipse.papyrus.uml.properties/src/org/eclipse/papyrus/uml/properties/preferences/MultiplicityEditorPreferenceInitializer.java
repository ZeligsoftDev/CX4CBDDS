/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.widgets.util.MultiplicityConstants;

/**
 * This class allow to define the multiplicity preference initialization.
 */
public class MultiplicityEditorPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Constructor.
	 */
	public MultiplicityEditorPreferenceInitializer() {
		// Nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = MultiplicityEditorPreferences.instance.getPreferenceStore();
		store.setDefault(MultiplicityConstants.MULTIPLICITY_EDITOR_MODE, MultiplicityConstants.SIMPLE_MODE);
	}

}
