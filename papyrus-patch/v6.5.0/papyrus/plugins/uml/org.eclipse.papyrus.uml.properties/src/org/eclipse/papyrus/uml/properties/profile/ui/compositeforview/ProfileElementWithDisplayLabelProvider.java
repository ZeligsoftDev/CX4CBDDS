/*****************************************************************************
 * Copyright (c) 2008, 2017 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - bug 522652
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.compositeforview;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.internal.uml.properties.profile.preferences.ProfileTabPreferences;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.uml.profile.tree.objects.TreeObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * The Class ProfileElementWithDisplayLabelProvider.
 */
public class ProfileElementWithDisplayLabelProvider extends ProfileElementLabelProvider {

	/**
	 * the preference store to use to calculate the label length
	 */
	final IPreferenceStore store = ProfileTabPreferences.getPreferenceStore();

	/**
	 * Gets the image.
	 *
	 * @param object
	 *            the object
	 *
	 * @return the image
	 */
	@Override
	public Image getImage(Object object) {

		if (object instanceof TreeObject) {

			TreeObject to = (TreeObject) object;
			if (to.isDisplay()) {
				return ImageManager.IMG_STEREOTYPEDISPLAYED;
			}
		}

		// else, Default case : no display
		return super.getImage(object);
	}

	/**
	 * @see org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider#getText(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public String getText(Object object) {
		String label = super.getText(object);
		if (this.store.getBoolean(ProfileTabPreferences.TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_ENABLEMENT_PREFERENCE)) {
			// the truncation is activated
			int maxChar = this.store.getInt(ProfileTabPreferences.TRUNCATE_LABELS_IN_STREOTYPE_APPLICATION_TREE_VIEWER_NB_CHAR_PREFERRENCE);
			if (label.length() > maxChar) {
				// we don't take account of the depth in the tree, it seems us useless
				final StringBuilder builder = new StringBuilder(label.substring(0, maxChar));
				builder.append("..."); //$NON-NLS-1$
				label = builder.toString();
			}
		}
		return label;
	}



	/**
	 * @see org.eclipse.papyrus.uml.profile.tree.ProfileElementLabelProvider#getPropLabel(org.eclipse.uml2.uml.Property, org.eclipse.uml2.uml.Type, java.lang.Object)
	 *
	 * @param currentProp
	 * @param currentPropType
	 * @param currentPropValue
	 * @return
	 */
	@Override
	protected String getPropLabel(Property currentProp, Type currentPropType, Object currentPropValue) {
		if (this.store.getBoolean(ProfileTabPreferences.SHOW_STEREOTYPE_PROPERTY_VALUES_AS_CHILDREN_PREFERENCE) && currentPropValue != null) {
			// when the preference is activated, we don't display the value of the current property, excepted for null value
			return getPropertyShortLabel(currentProp);
		}
		return super.getPropLabel(currentProp, currentPropType, currentPropValue);
	}

}
