/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.idl3plus.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;

/**
 * A small dialog to create and configure a new template parameter.
 * 
 * It allows the user to set the name and also the type constraint.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class CreateTemplateParameterDialog extends TrayDialog {
	private static final String[] COMBO_ITEMS = {
		"typename", //$NON-NLS-1$
		"interface", //$NON-NLS-1$
		"eventtype", //$NON-NLS-1$
		"struct", //$NON-NLS-1$
		"union", //$NON-NLS-1$
		"sequence", //$NON-NLS-1$
		"array", //$NON-NLS-1$
		"enum" }; //$NON-NLS-1$
	
	// Controls
	
	private Text nameField;
	private Combo combo;
	
	// Data fields
	
	private String name;
	private String typeConstraint;

	/**
	 * Construct me.
	 */
	public CreateTemplateParameterDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		Shell shell = getShell();
		shell.setText(Messages.CreateTemplateParameterDialog_DialogTitle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createContents(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		GridData gridData = new GridData(GridData.FILL_BOTH);

		composite.setLayout(layout);
		composite.setLayoutData(gridData);

		createNameLabel(composite);
		createNameTextArea(composite);
		createTypeParameterConstraintLabel(composite);
		createTypeParameterConstraintCombo(composite);

		createButtonBar(composite);
		getButton(IDialogConstants.OK_ID).setEnabled(false);

		return composite;
	}

	protected void createNameLabel(Composite parent) {
		Label nameLabel = new Label(parent, 0);

		nameLabel
				.setText(Messages.CreateTemplateParameterDialog_Label_NameTextArea);

		GridData data = new GridData();
		nameLabel.setLayoutData(data);
	}

	protected void createTypeParameterConstraintLabel(Composite parent) {
		Label typeConstraintLabel = new Label(parent, 0);

		typeConstraintLabel
				.setText(Messages.CreateTemplateParameterDialog_Label_TypeConstraint);

		GridData data = new GridData();
		typeConstraintLabel.setLayoutData(data);
	}

	protected void createNameTextArea(Composite parent) {
		nameField = new Text(parent, SWT.BORDER);

		GridData data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = 250;

		nameField.setLayoutData(data);
		nameField.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event e) {
				updateName();
				validateName();
			}
		});
	}

	/**
	 * Handler for changes to the nameField.
	 */
	protected void updateName() {
		this.name = nameField.getText();

	}

	protected void createTypeParameterConstraintCombo(Composite parent) {
		combo = new Combo(parent, SWT.SINGLE | SWT.READ_ONLY);
		combo.setItems(COMBO_ITEMS);

		GridData data = new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL
				| GridData.HORIZONTAL_ALIGN_BEGINNING);

		combo.setLayoutData(data);
		combo.setEnabled(true);

		combo.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event e) {
				updateTypeParameterConstraint();
				validateName();
			}
		});
	}

	/**
	 * Handler for changes to the type constraint value.
	 */
	protected void updateTypeParameterConstraint() {
		typeConstraint = null;
		if (combo.getSelectionIndex() >= 0
				&& combo.getSelectionIndex() < COMBO_ITEMS.length) {
			typeConstraint = COMBO_ITEMS[combo.getSelectionIndex()];
		}
	}

	/**
	 * Function determines if the OK button can be enabled.
	 * 
	 * It requires a name and type constraint to be set to something
	 * other then null or the empty string.
	 */
	protected void validateName() {
		getButton(IDialogConstants.OK_ID).setEnabled(true);

		if (UML2Util.isEmpty(getName())
				|| UML2Util.isEmpty(getTypeConstraint())) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
	}

	public String getName() {
		return name;
	}

	public String getTypeConstraint() {
		return typeConstraint;
	}
}
