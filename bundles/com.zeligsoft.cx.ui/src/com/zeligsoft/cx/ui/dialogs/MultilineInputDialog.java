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
package com.zeligsoft.cx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Simple multi-line string input dialog
 * 
 * @author ysroh
 * 
 */
public class MultilineInputDialog
		extends TrayDialog {

	private String defaultString;

	private String title;

	private Text text;

	private String input;

	@Override
	public void create() {

		super.create();
		Shell shell = getShell();
		shell.setText(title);

	}

	/**
	 * Constructor
	 * 
	 * @param shell
	 * @param title
	 * @param defaultString
	 */
	public MultilineInputDialog(Shell shell, String title, String defaultString) {
		super(shell);
		this.title = title;
		this.defaultString = defaultString;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	/**
	 * Constructor
	 * 
	 * @param shell
	 * @param input
	 */
	public MultilineInputDialog(Shell shell, String input) {
		this(shell, Messages.MultilineInputDialog_DialogTitle, input);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.marginWidth = 10;
		compositeLayout.marginHeight = 15;
		GridData compositeLData = new GridData(GridData.FILL_BOTH);
		compositeLData.grabExcessHorizontalSpace = true;
		compositeLData.grabExcessVerticalSpace = true;
		composite.setLayoutData(compositeLData);
		composite.setLayout(compositeLayout);

		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = 300;
		layoutData.heightHint = 200;
		layoutData.horizontalSpan = 2;
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		text = new Text(composite, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP
			| SWT.BORDER);
		text.setLayoutData(layoutData);
		text.setText(defaultString == null
			? "" //$NON-NLS-1$
			: defaultString);

		createButtonArea(composite);

		return composite;
	}

	/**
	 * Create button area
	 * 
	 * @param composite
	 */
	private void createButtonArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));

		Control helpControl = createHelpControl(composite);
		helpControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
			| GridData.GRAB_HORIZONTAL));
		createButtonsForButtonBar(composite);

		GridData buttonData = (GridData) getButton(IDialogConstants.OK_ID)
			.getLayoutData();
		buttonData.widthHint = 70;
		buttonData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		getButton(IDialogConstants.CANCEL_ID).setLayoutData(buttonData);
	}

	@Override
	protected void okPressed() {

		input = text.getText();
		text.setText(""); //$NON-NLS-1$
		close();
	}

	/**
	 * Returns user input text
	 * 
	 * @return
	 */
	public String getText() {
		return input;
	}
}
