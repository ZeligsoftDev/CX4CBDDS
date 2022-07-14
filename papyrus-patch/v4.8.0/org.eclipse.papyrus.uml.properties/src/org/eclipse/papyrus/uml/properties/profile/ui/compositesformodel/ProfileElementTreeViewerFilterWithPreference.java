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
 *  Vincent LORENZO (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.profile.ui.compositesformodel;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.internal.uml.properties.profile.preferences.ProfileTabPreferences;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter;
import org.eclipse.papyrus.uml.profile.tree.objects.ValueTreeObject;

/**
 * 
 * the filter used to show the property values as children when the preference is activated
 * @noextend
 */
class ProfileElementTreeViewerFilterWithPreference extends ProfileElementTreeViewerFilter {

	/**
	 * the preference store to use to get the preference
	 */
	private final IPreferenceStore store = ProfileTabPreferences.getPreferenceStore();

	/**
	 * @see org.eclipse.papyrus.uml.profile.tree.ProfileElementTreeViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 *
	 * @param viewer
	 * @param parentElement
	 * @param element
	 * @return
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = super.select(viewer, parentElement, element);
		if (false == result && element instanceof ValueTreeObject) {
			return this.store.getBoolean(ProfileTabPreferences.SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE);
		}
		return result;
	}

}

