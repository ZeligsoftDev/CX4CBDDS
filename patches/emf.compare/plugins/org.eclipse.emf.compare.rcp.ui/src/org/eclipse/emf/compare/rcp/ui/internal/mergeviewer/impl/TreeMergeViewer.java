/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 527567
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl;

import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IEMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.ICompareColor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A concrete implementation of {@link AbstractTableOrTreeMergeViewer} for TreeViewer.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class TreeMergeViewer extends AbstractTableOrTreeMergeViewer {

	/**
	 * The Input of the viewer.
	 */
	private Object fInput;

	/**
	 * The TreeViewer.
	 */
	private TreeViewer fTreeViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent widget of this viewer.
	 * @param side
	 *            the side of this viewer.
	 * @param colorProvider
	 *            the color provider to use with this viewer.
	 * @param compareConfiguration
	 *            the compare configuration object to use with this viewer.
	 */
	public TreeMergeViewer(Composite parent, MergeViewerSide side, ICompareColor.Provider colorProvider,
			IEMFCompareConfiguration compareConfiguration) {
		super(parent, side, colorProvider, compareConfiguration);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.AbstractMergeViewer#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginLeft = -1;
		layout.marginRight = -1;
		layout.marginTop = -1;
		layout.marginBottom = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);

		fTreeViewer = createTreeViewer(composite);
		fTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		return composite;
	}

	/**
	 * Creates a new tree viewer.
	 * 
	 * @param parent
	 *            the parent of the new tree viewer.
	 * @return a new tree viewer.
	 */
	protected TreeViewer createTreeViewer(Composite parent) {
		return new TreeViewer(parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl.ide.ui.internal.contentmergeviewer.AbstractMergeViewer#getStructuredViewer()
	 */
	@Override
	public TreeViewer getStructuredViewer() {
		return fTreeViewer;
	}

	/**
	 * Set the expanded state of the given element or tree path.
	 * 
	 * @param elementOrTreePath
	 *            the given element or tree path.
	 * @param expanded
	 *            the expanded state .
	 */
	public void setExpandedState(Object elementOrTreePath, boolean expanded) {
		getStructuredViewer().setExpandedState(elementOrTreePath, expanded);
	}

	@Override
	protected void hookDispose() {
		fInput = null;
		fTreeViewer = null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		if (input instanceof ICompareAccessor) {
			fInput = input;
			/*
			 * Sets the selection to null to prevent memory in the tree viewer. See
			 * StructuredViewer#preservingSelection(Runnable updateCode, boolean reveal)
			 */
			getStructuredViewer().setSelection(null);
			getStructuredViewer().setInput(input);
		} else {
			fInput = null;
			getStructuredViewer().setInput(null);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IInputProvider#getInput()
	 */
	@Override
	public Object getInput() {
		return fInput;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#refresh()
	 */
	@Override
	public void refresh() {
		fTreeViewer.refresh();
	}
}
