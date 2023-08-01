/*****************************************************************************
 * Copyright (c) 2010, 2014 LIFL, CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus (CEA) - bug 434635
 *  Christian W. Damus - bug 450536
 *  Christian W. Damus - bug 454536
 *  Mickaël ADAM (ALL4TEC) - mickael.adam@all4tec.net - Bug 500290: add composite to contain new filter
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Page handling the {@link ModelExplorerView} for the {@link ModelExplorerPageBookView}
 *
 * @author cedric dumoulin
 *
 */
public class ModelExplorerPage extends ViewPartPage {

	private SharedModelExplorerState state;
	private Composite composite;

	public ModelExplorerPage() {
		super();
	}

	/**
	 * Create the Viewer for the requested part
	 *
	 * @param part
	 *            The part to associate to the Viewer.
	 * @return
	 */
	@Override
	protected IViewPart createViewer(IWorkbenchPart part) {
		// Part is of the right type because of call to isImportant()
		ModelExplorerView result = new ModelExplorerView((IMultiDiagramEditor) part);
		result.setSharedState(state);
		return result;
	}

	/**
	 * Create control of the inner view
	 *
	 * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		getViewer().createPartControl(composite);
	}



	/**
	 * Return the control
	 *
	 * @see org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage#getControl()
	 *
	 * @return
	 */
	@Override
	public Control getControl() {
		return composite;
	}

	void setSharedState(SharedModelExplorerState state) {
		this.state = state;
	}
}
