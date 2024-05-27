/*******************************************************************************
 * Copyright (c) 2014, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Stefan Dirix - bug 473985
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.actions.ui;

import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;

/**
 * Dialog used to ask user synchronization behavior.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class SynchronizerDialog extends MessageDialogWithToggle {

	/** Indentation of the preference page hyper link. */
	private static final int HYPERLINK_INDENT = 35;

	/** Index of the "No" button. Used to define a default selection. */
	private static final int NO_BUTTON_INDEX = 1;

	/** Labels used for simple preference synchronization. */
	private static String[] defaultButtonLabels = new String[] {IDialogConstants.YES_LABEL,
			IDialogConstants.NO_LABEL, };

	/** Id of the preference page. */
	private final String preferencePageID;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 *            Parent shell
	 * @param title
	 *            Title of the dialog
	 * @param message
	 *            MEssage of the dialog
	 * @param preferencePageID
	 *            Preference page id if the dialog should have a hyperlink to a preference page or
	 *            <code>null</code> otherwise
	 */
	public SynchronizerDialog(Shell parentShell, String title, String message, String preferencePageID) {
		super(parentShell, title, null, message, MessageDialog.CONFIRM, defaultButtonLabels, NO_BUTTON_INDEX,
				EMFCompareRCPUIMessages.getString("SynchronizerDialog.notAskAgain.label"), false); //$NON-NLS-1$
		this.preferencePageID = preferencePageID;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createCustomArea(Composite parent) {
		// only add hyperlink if workbench is running since the preference dialog depends on it
		if (preferencePageID != null && PlatformUI.isWorkbenchRunning()) {
			Composite container = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(1, true);
			container.setLayout(layout);
			// Create hyperlink to preferences.
			Link pageLink = new Link(container, SWT.NONE);
			GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
			layoutData.horizontalIndent = HYPERLINK_INDENT;
			pageLink.setLayoutData(layoutData);
			pageLink.setText(EMFCompareRCPUIMessages.getString("SynchronizerDialog.hyperlink.message")); //$NON-NLS-1$
			// Open preference page on click
			pageLink.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					buttonPressed(IDialogConstants.CANCEL_ID);
					PreferencesUtil.createPreferenceDialogOn(getParentShell(), preferencePageID, null, null)
							.open();
				}
			});
			return container;
		}
		return super.createCustomArea(parent);
	}
}
