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
package org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider;

import java.util.List;

import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;

/**
 * The contract for providers responsible for determining root elements in merge viewers. Typically these are
 * {@link IMergeViewerItem}s but they not necessarily have to be.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 4.4
 */
public interface IMergeViewerItemProvider extends IOptionalProvider {

	/**
	 * Determine the root merge viewer items for the given {@code object}.
	 * 
	 * @param object
	 *            the {@link Object} for which the root merge viewer items are to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return a list of the root elements.
	 */
	public List<Object> getMergeViewerItems(Object object,
			IMergeViewerItemProviderConfiguration configuration);

	/**
	 * Determine the merge viewer item which shall be selected.
	 * 
	 * @param object
	 *            the {@link Object} for which the selected merge viewer item is to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return the merge viewer item to select.
	 */
	public Object getItemToSelect(Object object, IMergeViewerItemProviderConfiguration configuration);
}
