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
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - add search fiel preference page. Rename class name.
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.preferences;

import org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.swt.widgets.Composite;

/**
 * Preference page for model explorer.
 * @since 3.0
 */
public class ModelExplorerPreferencePage extends AbstractPapyrusPreferencePage {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage#getBundleId()
	 */
	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createPageContents(final Composite parent) {
		// Add filter field preferences
		FilterFieldPreferencesGroup searchGroup = new FilterFieldPreferencesGroup(parent, getTitle(), this);
		addPreferenceGroup(searchGroup);

		// show popup dialog
		TransformCommandShowPopupDialogGroup groupComposite = new TransformCommandShowPopupDialogGroup(parent, getTitle(), this);
		addPreferenceGroup(groupComposite);

		ExpandPreferencesGroup groupExpand = new ExpandPreferencesGroup(parent, getTitle(), this);
		addPreferenceGroup(groupExpand);
	}

}
