/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.profile.ui.dialogs;

import org.eclipse.uml2.uml.Stereotype;

/**
 * Label provider for stereotypes that modifies {@link StereotypeLabelProvider#getText(Object)}.
 * It returns the qualified name of the Stereotype instead of the simple name.
 */
public class StereotypeQualifiedLabelProvider extends StereotypeLabelProvider {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetStereotypeDialog.StereotypeLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object stereotype) {
		if (!(stereotype instanceof Stereotype)) {
			return "not a stereotype";
		} else {
			return ((Stereotype) stereotype).getQualifiedName();
		}
	}
}
