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
package org.eclipse.papyrus.uml.properties.profile.ui.panels;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;


/**
 * Default panel for the Accord/UML view.<BR>
 * If the element selected in the model explorer or in the diagrams, or if
 * the element selected is not a UML element, it is displayed in the view.
 *
 * @author Remi SCHNEKENBURGER
 */
public class DefaultPanel extends AbstractPanel {

	// the label used to display text
	/**
	 * The label.
	 */
	private Label label;

	/**
	 * Constructs a new instance of this class given its parent and a style
	 * value describing its behavior and appearance.
	 *
	 * @param style
	 *            the style for this style
	 * @param parent
	 *            the composite parent of this element
	 */
	public DefaultPanel(Composite parent, int style) {
		super(parent, style);
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.actionlanguage.texteditor.ui.panels.AccordUMLAbstractPanel#createContent()
	 */
	/**
	 * Creates the content.
	 *
	 * @return the control
	 */
	@Override
	public Control createContent() {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		this.setLayout(layout);

		label = new Label(this, SWT.NONE);
		label.setText("No selection.");
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridData.horizontalSpan = 2;
		label.setLayoutData(gridData);

		return null;
	}
}
