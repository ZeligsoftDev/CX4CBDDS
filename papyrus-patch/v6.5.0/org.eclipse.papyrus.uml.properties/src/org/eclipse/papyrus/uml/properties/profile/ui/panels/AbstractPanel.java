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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * Abstract panel for the Accord/UML view.<br>
 *
 */
public abstract class AbstractPanel extends Composite {

	/**
	 * The Constant WARNING_IMAGE.
	 */
	protected static final String WARNING_IMAGE = "resources/icons/warning.gif";

	/**
	 * Default constructor.
	 *
	 * @param style
	 *            the style of this composite
	 * @param parent
	 *            the parent of this composite
	 */
	public AbstractPanel(Composite parent, int style) {
		super(parent, style);

	}

	/**
	 * Creates the content for this panel, and returns its Control.
	 *
	 * @return the Control for this panel
	 */
	public abstract Control createContent();

	/**
	 * Action executed just after the panel is created for the specific element.
	 */
	public void entryAction() {
		// do nothing
	}

	/**
	 * Action executed just before moving to the new element.
	 */
	public void exitAction() {
		// do nothing
	}

	/**
	 * Refresh panel.
	 */
	public void refresh() {

	}
}
