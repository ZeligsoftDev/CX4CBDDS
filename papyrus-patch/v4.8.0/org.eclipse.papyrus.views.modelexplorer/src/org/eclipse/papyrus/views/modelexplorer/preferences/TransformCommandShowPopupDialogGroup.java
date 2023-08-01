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
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - use of AbstractPreferenceGroup
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.infra.ui.preferences.AbstractPreferenceGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class TransformCommandShowPopupDialogGroup extends AbstractPreferenceGroup {

	private static final String SHOW_POPUP_DIALOG_GROUP_TITLE = "Transform into Action";

	private static final String SHOW_POPUP_DIALOG_GROUP_MESSAGE = "Do not show popup dialog when transform command is performed";

	/** Editor for deciding to show the warning popup */
	private BooleanFieldEditor showPopupDialogBooleanFieldEditor;

	/**
	 * Creation of an ActivityEdgeLabelVisibilityGroup Composite.
	 *
	 * @param parent
	 *            the parent of the composite
	 * @param dialogPage
	 *            to set the page in field editor
	 * @param title
	 *            the title
	 */
	public TransformCommandShowPopupDialogGroup(Composite parent, String title,
			DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 *
	 * @param parent
	 *            the parent
	 */
	public void createContent(Composite parent) {
		Group visibilityGroup = new Group(parent, SWT.SCROLL_PAGE);
		visibilityGroup.setLayout(new GridLayout());
		visibilityGroup.setText(SHOW_POPUP_DIALOG_GROUP_TITLE);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(visibilityGroup);

		// field for name label visibility
		showPopupDialogBooleanFieldEditor = new BooleanFieldEditor(
				INavigatorPreferenceConstants.PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP,
				SHOW_POPUP_DIALOG_GROUP_MESSAGE, visibilityGroup);
		showPopupDialogBooleanFieldEditor.setPage(dialogPage);

		addFieldEditor(showPopupDialogBooleanFieldEditor);

	}
}
