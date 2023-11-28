/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.contentmergeviewer.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;

/**
 * Special implementation which mimics the behavior of the Papyrus Facet Parent mechanism.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
@SuppressWarnings("restriction")
public class PapyrusMergeViewerItem extends MergeViewerItem {

	/**
	 * The saved parent.
	 */
	private IMergeViewerItem papyrusParent;

	/**
	 * Constructor.
	 * 
	 * @param comparison
	 *            the {@link Comparison}.
	 * @param diff
	 *            the {@link Diff}.
	 * @param left
	 *            the left object.
	 * @param right
	 *            the right object.
	 * @param ancestor
	 *            the ancestor object.
	 * @param side
	 *            the {@link MergeViewerSide}.
	 * @param adapterFactory
	 *            the {@link AdapterFactory}.
	 */
	public PapyrusMergeViewerItem(Comparison comparison, Diff diff, Object left, Object right,
			Object ancestor, MergeViewerSide side, AdapterFactory adapterFactory) {
		super(comparison, diff, left, right, ancestor, side, adapterFactory);
	}

	/**
	 * Sets the parent of this MergeViewerItem.
	 * 
	 * @param papyrusParent
	 *            the {@link IMergeViewerItem} parent.
	 */
	public void setPapyrusParent(IMergeViewerItem papyrusParent) {
		this.papyrusParent = papyrusParent;
	}

	/**
	 * Gets the parent of this MergeViewerItem.
	 * 
	 * @return the {@link IMergeViewerItem} parent if it was set, {@code null} otherwise.
	 */
	public IMergeViewerItem getPapyrusParent() {
		return papyrusParent;
	}

}
