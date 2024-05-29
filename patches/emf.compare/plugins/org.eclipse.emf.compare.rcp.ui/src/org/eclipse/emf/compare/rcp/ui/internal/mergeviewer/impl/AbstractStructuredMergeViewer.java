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

import java.util.EnumSet;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IEMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

/**
 * A specific {@link AbstractMergeViewer} for the EMF Compare Editor.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractStructuredMergeViewer extends AbstractMergeViewer {

	/** The primary control associated with this viewer. */
	private final Control fControl;

	/** A listener which is notified when a viewer's selection changes. */
	private final ISelectionChangedListener fForwardingSelectionListener;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent widget.
	 * @param side
	 *            the side of the viewer.
	 * @param compareConfiguration
	 *            the compare configuration object used by this viewer.
	 */
	public AbstractStructuredMergeViewer(Composite parent, MergeViewerSide side,
			IEMFCompareConfiguration compareConfiguration) {
		super(side, compareConfiguration);

		fControl = createControl(parent);
		hookControl(fControl);

		fForwardingSelectionListener = new ForwardingViewerSelectionListener();
		getStructuredViewer().addSelectionChangedListener(fForwardingSelectionListener);
		createContextMenu();
	}

	/**
	 * Creates the primary control associated with this viewer.
	 * 
	 * @param parent
	 *            the parent widget of this viewer.
	 * @return the created primary control associated with this viewer.
	 */
	protected abstract Control createControl(Composite parent);

	/**
	 * Returns the wrapped {@link StructuredViewer}.
	 * 
	 * @return the wrapped {@link StructuredViewer}.
	 */
	protected abstract StructuredViewer getStructuredViewer();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#getControl()
	 */
	@Override
	public Control getControl() {
		return fControl;
	}

	/**
	 * Creates the context menu for the {@link #getStructuredViewer() structured viewer} adding a
	 * {@link IMenuListener menu listener} that calls {@link #fillContextMenu(IMenuManager)}.
	 */
	protected void createContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Control control = getStructuredViewer().getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);
	}

	/**
	 * Fills the context menu for the {@link #getStructuredViewer() structured viewer. By default, this
	 * determines the merge mode from the {@link #getCompareConfiguration() compare configuration}, and uses
	 * the {@link #getDiff() diff} of the {@link #getSelection() selection} to
	 * {@link #createAction(MergeMode, Diff) create actions}. The default implementation of
	 * {@code createAction} returns {@code null}, in which case no action is {@link IMenuManager#add(IAction)
	 * added} to the menu manager.
	 * 
	 * @param manager
	 *            the menu manager of the {@link #createContextMenu() context menu}.
	 * @see #getDiff()
	 * @see #createAction(MergeMode, Diff)
	 */
	protected void fillContextMenu(IMenuManager manager) {
		IEMFCompareConfiguration configuration = getCompareConfiguration();
		boolean leftEditable = configuration.isLeftEditable();
		boolean rightEditable = configuration.isRightEditable();
		if (rightEditable || leftEditable) {
			Diff diff = getDiff();
			if (diff != null) {
				final EnumSet<MergeMode> modes;
				if (rightEditable && leftEditable) {
					modes = EnumSet.of(MergeMode.RIGHT_TO_LEFT, MergeMode.LEFT_TO_RIGHT);
				} else {
					modes = EnumSet.of(MergeMode.ACCEPT, MergeMode.REJECT);
				}
				for (MergeMode mode : modes) {
					IAction action = createAction(mode, diff);
					if (action != null) {
						manager.add(action);
					}
				}
			}
		}
	}

	/**
	 * Returns the {@link IMergeViewerItem#getDiff() diff} associated with the one {@link IMergeViewerItem} in
	 * the viewer's {@link #getSelection() selection}.
	 * 
	 * @return the diff associated with the one {@code IMergeViewerItem} in the viewer's selection.
	 */
	protected Diff getDiff() {
		ISelection selection = getSelection();
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			if (structuredSelection.size() == 1) {
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IMergeViewerItem) {
					IMergeViewerItem mergeViewerItem = (IMergeViewerItem)firstElement;
					return mergeViewerItem.getDiff();
				}
			}
		}
		return null;
	}

	/**
	 * Creates the action for merging the given diff via the specified mode. By default this returns
	 * {@code null}.
	 * 
	 * @param mode
	 *            the merge mode.
	 * @param diff
	 *            the diff to be merged.
	 * @return a new action for merging the given diff via the specified mode.
	 */
	protected IAction createAction(MergeMode mode, Diff diff) {
		return null;
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		getStructuredViewer().removeSelectionChangedListener(fForwardingSelectionListener);
		hookDispose();
		super.handleDispose(event);
	}

	protected abstract void hookDispose();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		return getStructuredViewer().getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
	 */
	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		getStructuredViewer().setSelection(selection, reveal);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		super.setContentProvider(contentProvider);
		getStructuredViewer().setContentProvider(contentProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		super.setLabelProvider(labelProvider);
		getStructuredViewer().setLabelProvider(labelProvider);
	}

	/**
	 * A specific implementation of {@link ISelectionChangedListener} for the AbstractStructuredMergeViewer.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	private class ForwardingViewerSelectionListener implements ISelectionChangedListener {
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			fireSelectionChanged(
					new SelectionChangedEvent(AbstractStructuredMergeViewer.this, event.getSelection()));
		}

	}
}
