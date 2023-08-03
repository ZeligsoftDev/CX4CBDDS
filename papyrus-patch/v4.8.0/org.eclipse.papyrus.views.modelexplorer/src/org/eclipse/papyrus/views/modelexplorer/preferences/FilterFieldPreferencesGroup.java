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
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.ui.preferences.AbstractPreferenceGroup;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Preference group for model explorer Search Field.
 */
public class FilterFieldPreferencesGroup extends AbstractPreferenceGroup {

	/** The property change listener on validation delay field. */
	private IPropertyChangeListener listener = event -> refreshDelayField(event);

	/** The field editor for the delay value. */
	private IntegerFieldEditor delayFieldEditor;

	/** The group. */
	private Group fieldGroup;

	/** The field editor for the live validation preference. */
	private FieldEditor liveValidationfieldEditor;

	/** The field editor for the stereotype delimiter preference. */
	private BooleanFieldEditor stereotypeDelimiterfieldEditor;

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
	public FilterFieldPreferencesGroup(final Composite parent, final String title, final DialogPage dialogPage) {
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
		fieldGroup = new Group(parent, SWT.SCROLL_PAGE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		fieldGroup.setLayout(layout);
		fieldGroup.setText(Messages.FilterFieldPreferencesGroup_groupTitle);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(fieldGroup);

		// live validation preferences
		liveValidationfieldEditor = new BooleanFieldEditor(IFilterPreferenceConstants.PREF_FILTER_LIVE_VALIDATION, Messages.FilterFieldPreferencesGroup_UseValidationPreferenceLabel, fieldGroup);
		liveValidationfieldEditor.setPage(dialogPage);
		addFieldEditor(liveValidationfieldEditor);

		// Composite use to manage layout
		Composite composite = new Composite(fieldGroup, SWT.NONE);
		GridDataFactory.fillDefaults().hint(5, 5).applyTo(composite);

		liveValidationfieldEditor.setPropertyChangeListener(listener);

		// delay preferences
		delayFieldEditor = new IntegerFieldEditor(IFilterPreferenceConstants.PREF_FILTER_VALIDATION_DELAY, Messages.FilterFieldPreferencesGroup_ValidationDelayPreferenceLabel, fieldGroup);
		delayFieldEditor.setPage(dialogPage);
		addFieldEditor(delayFieldEditor);

		delayFieldEditor.setEnabled(Activator.getDefault().getPreferenceStore().getBoolean(IFilterPreferenceConstants.PREF_FILTER_LIVE_VALIDATION), fieldGroup);

		// stereotype delimiters replacement preferences
		stereotypeDelimiterfieldEditor = new BooleanFieldEditor(IFilterPreferenceConstants.PREF_FILTER_STEREOTYPE_REPLACED, Messages.FilterFieldPreferencesGroup_replaceDelimiterLabel, fieldGroup);
		stereotypeDelimiterfieldEditor.setPage(dialogPage);
		addFieldEditor(stereotypeDelimiterfieldEditor);
	}

	/**
	 * Enable of delay field editor when the live validation is set to true.
	 */
	private void refreshDelayField(final PropertyChangeEvent event) {
		if (null != delayFieldEditor && null != liveValidationfieldEditor && event.getSource().equals(liveValidationfieldEditor)) {
			delayFieldEditor.setEnabled((boolean) event.getNewValue(), fieldGroup);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		// dispose listener
		liveValidationfieldEditor.setPropertyChangeListener(null);
		super.dispose();
	}
}
