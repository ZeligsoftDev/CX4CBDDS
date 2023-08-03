/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
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
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.Page;


/**
 * @author dumoulin
 *
 */
public class CorePage extends Page {

	/**
	 * The default ui
	 */
	private Text text;

	private IWorkbenchPart part;


	/**
	 * Constructor.
	 *
	 */
	public CorePage(IWorkbenchPart part) {
		this.part = part;
	}

	/**
	 * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		text = new Text(parent, SWT.CENTER);

		text.setMessage("page for " + part.getTitle());
	}

	/**
	 * @see org.eclipse.ui.part.Page#getControl()
	 *
	 * @return
	 */
	@Override
	public Control getControl() {
		return text;
	}

	/**
	 * @see org.eclipse.ui.part.Page#setFocus()
	 *
	 */
	@Override
	public void setFocus() {
		

	}

}
