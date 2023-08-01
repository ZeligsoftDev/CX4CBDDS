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

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.papyrus.infra.ui.preferences.AbstractPreferenceGroup;
import org.eclipse.papyrus.views.modelexplorer.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Preference group for model explorer expand action.
 */
public class ExpandPreferencesGroup extends AbstractPreferenceGroup {

	/** The group. */
	private Group group;

	/** The field editor for expand action preference. */
	private FieldEditor expandLevelfieldEditor;

	/**
	 * 
	 * Constructor.
	 *
	 * @param parent
	 *            The parent.
	 * @param title
	 *            The group title.
	 * @param dialogPage
	 *            The dialog page.
	 */
	public ExpandPreferencesGroup(final Composite parent, final String title, final DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 *
	 * @param parent
	 *            the parent
	 */
	public void createContent(final Composite parent) {
		group = new Group(parent, SWT.SCROLL_PAGE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		group.setText(Messages.ExpandPreferencesGroup_ExpandGroupLabel);
		group.setToolTipText(Messages.ExpandPreferencesGroup_ExpandGroupTooltip);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(group);
		expandLevelfieldEditor = new IntegerFieldEditor(IExpandPreferenceConstants.PREF_MAX_LEVEL_TO_EXPAND, Messages.ExpandPreferencesGroup_MaxLevelLabel, group);
		expandLevelfieldEditor.setPage(dialogPage);
		addFieldEditor(expandLevelfieldEditor);
	}
}