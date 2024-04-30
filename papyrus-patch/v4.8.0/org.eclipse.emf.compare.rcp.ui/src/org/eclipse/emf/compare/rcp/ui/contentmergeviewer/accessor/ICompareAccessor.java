/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor;

import com.google.common.collect.ImmutableList;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;

/**
 * An ICompareAccessor is an {@link ITypedElement} used to present an input object in the EMF Compare UI.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public interface ICompareAccessor extends ITypedElement {

	/**
	 * Returns the comparison object used by this accessor.
	 * 
	 * @return the comparison object used by this accessor.
	 */
	Comparison getComparison();

	/**
	 * Returns the initial item of this accessor.
	 * 
	 * @return the initial item of this accessor.
	 */
	IMergeViewerItem getInitialItem();

	/**
	 * Returns the list of items known by this accessor.
	 * 
	 * @return the list of items known by this accessor.
	 */
	ImmutableList<? extends IMergeViewerItem> getItems();
}
