/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

//TODO : To be refactored. Merge this class with UMLLabelProvider
//should be removed in Papyrus 5.0 (see bug 540821)
/**
 * @deprecated since 1.2.0
 *
 */
@Deprecated
public class ProfileLabelProvider extends EMFLabelProvider implements ILabelProvider {

	private Package umlPackage;

	public static final String TAG_PROFILE_CHANGED = "    (has changed, consider re-applying profile)"; //$NON-NLS-1$

	public static final String UNKNOWN_PROFILE = "<Unknown>"; //$NON-NLS-1$

	public ProfileLabelProvider(Package umlPackage) {
		this.umlPackage = umlPackage;
	}

	@Override
	public String getText(Object source) {
		if (source instanceof Profile) {
			Profile profile = (Profile) source;
			String name = profile.getQualifiedName();
			if (name == null) {
				name = UNKNOWN_PROFILE;
			}
			if (ProfileUtil.isDirty(umlPackage, profile)) {
				name += TAG_PROFILE_CHANGED;
			}
			return name;
		}
		return super.getText(source);
	}
}
