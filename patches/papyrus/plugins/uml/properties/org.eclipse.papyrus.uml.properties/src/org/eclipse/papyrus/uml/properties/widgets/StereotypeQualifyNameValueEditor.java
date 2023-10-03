/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.uml.properties.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The value editor for stereotype qualify name.
 */
public class StereotypeQualifyNameValueEditor extends StringEditor {

	/** Browse icon */
	private static final String BROWSE_ICON = "/icons/browse_12x12.gif"; //$NON-NLS-1$

	/** Unique button. */
	private Button button = null;

	/** Source uml element. */
	private Element sourceUMLElement;

	/**
	 * Default constructor.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public StereotypeQualifyNameValueEditor(final Composite parent, final int style) {
		super(parent, style);
		((GridLayout) getLayout()).numColumns++;

		button = factory.createButton(this, null, SWT.PUSH);
		button.setImage(Activator.getDefault().getImage(BROWSE_ICON));
		button.setToolTipText(Messages.StereotypeQualifyNameValueEditor_browseStereotypeButtonLabel);

		// Display menu when user select button
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleManageBrowseButtonPressed();
			}
		});
	}

	/**
	 * Handles action when user press the Manage bundle button in the combo area
	 */
	protected void handleManageBrowseButtonPressed() {
		StereotypeExplorerDialog dialog = new StereotypeExplorerDialog(getParent().getShell(), getText().getText());
		dialog.setElementToApplyStereotype(sourceUMLElement);
		if (Window.OK == dialog.open()) {
			Object[] values = dialog.getResult();
			if (1 != values.length) {
				String message = Messages.StereotypeQualifyNameValueEditor_ReturnErrorMessage + values.length;
				Activator.getDefault().log.error(message, null);
				Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
				updateStatus(status);
			} else if (values[0] instanceof Stereotype) {
				Stereotype stereotype = (Stereotype) values[0];
				setValue(stereotype.getQualifiedName());
				notifyChange();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setReadOnly(final boolean readOnly) {
		super.setReadOnly(readOnly);
		button.setEnabled(!readOnly);
	}

	/**
	 * Set the source uml element to apply this stereotype to filter stereotype list.
	 */
	public void setElementToApplyStereotype(final Element sourceUMLElement) {
		this.sourceUMLElement = sourceUMLElement;
	}
}
