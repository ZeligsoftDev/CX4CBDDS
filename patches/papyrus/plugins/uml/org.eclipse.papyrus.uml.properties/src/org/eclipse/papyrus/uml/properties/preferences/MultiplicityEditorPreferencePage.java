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

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.papyrus.infra.widgets.util.MultiplicityConstants;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class define the multiplicity editor preference page.
 */
public class MultiplicityEditorPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Initialize the preference page.
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 *            The current workbench.
	 */
	public void init(final IWorkbench workbench) {
		setPreferenceStore(MultiplicityEditorPreferences.instance.getPreferenceStore());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(final Composite parent) {

		// Create the group for the multiplicity editor
		final Group multiplicityEditorGroup = new Group(parent, SWT.NONE);
		multiplicityEditorGroup.setText(Messages.MultiplicityPreference_MultiplicityEditor);
		multiplicityEditorGroup.setLayout(new GridLayout(1, true));
		multiplicityEditorGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		// Create the parent contents
		super.createContents(multiplicityEditorGroup);

		// Create the label description
		final Label descriptionLabel = new Label(multiplicityEditorGroup, SWT.NONE);
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		StringBuilder description = new StringBuilder();
		description.append("- \""); //$NON-NLS-1$
		description.append(MultiplicityConstants.SIMPLE_MODE_TEXT_VALUE);
		description.append("\" ");
		description.append(Messages.MultiplicityPreference_SimpleModeDescription);
		description.append("\n- \""); //$NON-NLS-1$
		description.append(MultiplicityConstants.ADVANCED_MODE_TEXT_VALUE);
		description.append("\" ");
		description.append(Messages.MultiplicityPreference_AdvancedModeDescription);
		descriptionLabel.setText(description.toString());

		return multiplicityEditorGroup;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {

		final String[][] values = { { MultiplicityConstants.SIMPLE_MODE_TEXT_VALUE, MultiplicityConstants.SIMPLE_MODE }, { MultiplicityConstants.ADVANCED_MODE_TEXT_VALUE, MultiplicityConstants.ADVANCED_MODE } };
		final ComboFieldEditor fieldEditor = new ComboFieldEditor(MultiplicityConstants.MULTIPLICITY_EDITOR_MODE, Messages.MultiplicityPreference_fieldEditorMode, values, getFieldEditorParent());
		addField(fieldEditor);
	}

}