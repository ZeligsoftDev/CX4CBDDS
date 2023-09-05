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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.properties.Activator;

/**
 * These preferences have been created to try to avoid the bug 522652
 * 
 * @noextend
 */
public final class ProfileTabPreferences {

	/**
	 * Preference key to store the activation of the label truncation in the Stereotype Tree Viewer
	 * This preference is set to <code>false</code> by default
	 *
	 */
	public static final String TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE = "TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE"; //$NON-NLS-1$

	/**
	 * this preference allows to store the max length (in char) of the label before truncating it.
	 */
	public static final String TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_NB_CHAR_PREFERRENCE = "TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_NB_CHAR_PREFERRENCE"; //$NON-NLS-1$


	/**
	 * Preference key to activate the view of the stereotype property values as children in the tree viewer
	 * This preference is set to false by default
	 */
	public static final String SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE = "SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE"; //$NON-NLS-1$

	/**
	 * 
	 * @return
	 * 		the preference store to use for these preferences
	 */
	public static final IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}


	/**
	 * 
	 * @return
	 * 		the min number of char before truncating the label
	 * 
	 *         this method is not API
	 */
	static final int getMinLabelWidth() {
		return 10;
	}

	/**
	 * 
	 * @return
	 * 		the max number of char before truncating the label
	 * 
	 *         this method is not API
	 */
	static final int getMaxLabelWidth() {
		return 1000;
	}

	/**
	 * intialization of the defaut value
	 */
	static final void initializeDefaultValue() {
		final IPreferenceStore store = getPreferenceStore();
		store.setDefault(TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE, false);
		store.setDefault(TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_NB_CHAR_PREFERRENCE, 50);
		store.setDefault(SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE, false);
	}


}
