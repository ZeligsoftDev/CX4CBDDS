/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Bug 497289
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.FocusCellHighlighter;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.papyrus.views.modelexplorer.matching.HashCodeCalculus;
import org.eclipse.papyrus.views.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.IReferencable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.navigator.dnd.NavigatorDnDService;
import org.eclipse.ui.navigator.CommonDragAdapter;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * this class was created in order to access to the drop adapter
 *
 */
@SuppressWarnings("restriction")
public class CustomCommonViewer extends CommonViewer {
	protected CommonDropAdapter dropAdapter;

	public CustomCommonViewer(String aViewerId, Composite aParent, int aStyle) {
		super(aViewerId, aParent, aStyle);
		
		setComparer(new IElementComparer() {

			@Override
			public int hashCode(Object element) {
				if (element instanceof EObjectTreeElement) {
					EObject eObject = ((EObjectTreeElement) element).getEObject();
					return HashCodeCalculus.getHashCode(eObject);
				}

				if (element instanceof EReferenceTreeElement) {
					EObject eParent = ((EReferenceTreeElement) element).getParent().getEObject();
					EReference eref = ((EReferenceTreeElement) element).getEReference();
					return HashCodeCalculus.getHashCode(eParent, eref);
				}
				if (element instanceof IReferencable) {
					IReferencable ref = (IReferencable) element;
					return ref.getElementBehind().hashCode();
				}
				if (element instanceof IMatchingItem) {
					IMatchingItem matchItem = (IMatchingItem) element;
					return matchItem.matchingItemHashcode();
				}
				return element.hashCode();
			}

			@Override
			public boolean equals(Object a, Object b) {
				if (a instanceof IMatchingItem) {
					return ((IMatchingItem) a).matchingItemEquals(b);
				}

				if (b != null) {
					return b.equals(a);
				}
				return false;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initDragAndDrop() {
		dropAdapter = null;
		int operations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;

		CommonDragAdapter dragAdapter = createDragAdapter();
		addDragSupport(operations, dragAdapter.getSupportedDragTransfers(), dragAdapter);
		dropAdapter = createDropAdapter();
		addDropSupport(operations, dropAdapter.getSupportedDropTransfers(), dropAdapter);

		NavigatorDnDService dnd = (NavigatorDnDService) getNavigatorContentService().getDnDService();
		dnd.setDropAdaptor(dropAdapter);
	}

	/**
	 * get the listener in order to parameterize during the runtime the drop
	 *
	 * @return the dropadapter
	 */
	public CommonDropAdapter getDropAdapter() {
		return dropAdapter;
	}

	/**
	 * Overridden to disable cell editor activation by single click, it can be activated by double click instead.
	 */
	@Override
	protected ColumnViewerEditor createViewerEditor() {
		// instantiate abstract focus cell high-lighter as dummy object for focus manager. The sub class
		// FocusCellOwnerDrawHighlighter would break multi-selections in Papyrus, see bug 419591.
		// (but we need to create a high-lighter, since the focus cell manager does not accept null pointer. The
		// TreeViewerEditor could work without focusCellManager, but would ignore keyboard events in this case.)
		FocusCellHighlighter fch = new FocusCellHighlighter(this) {
		};
		TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(
				this, fch);



		TreeViewerEditor.create(this, focusCellManager, new ColumnViewerEditorActivationStrategy(this) {
			@Override
			protected boolean isEditorActivationEvent(
					ColumnViewerEditorActivationEvent event) {
				// activation will uses F2 (also used by rename-popup, but not taken into account by the latter
				// for model elements for which a direct-editor exists)
				return (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED &&
						event.keyCode == SWT.F2) || (event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC);
			}
		}, ColumnViewerEditor.KEYBOARD_ACTIVATION);
		ColumnViewerEditor editor = this.getColumnViewerEditor();

		return editor;
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonViewer#dispose()
	 *
	 */
	@Override
	public void dispose() {
		// Remove the custom column viewer editor which causes NPE after dispose
		// ViewerEditor cannot be nulled or disposed, so we just recreate a default one
		setColumnViewerEditor(super.createViewerEditor());
		super.dispose();
	}

}