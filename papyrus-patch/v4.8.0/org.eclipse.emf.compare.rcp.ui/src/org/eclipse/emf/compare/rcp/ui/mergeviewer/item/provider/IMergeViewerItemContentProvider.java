/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Alexandra Buzila - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider;

import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * Interface for specialized {@link ITreeContentProvider tree content providers} for the comparison content
 * merge viewer.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 4.4
 */
public interface IMergeViewerItemContentProvider extends IOptionalProvider {

	/**
	 * Determine the parent of the given {@code object}.
	 * 
	 * @param object
	 *            the {@link Object} for which the parent is to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return the determined parent object, {@code null} if there is none.
	 */
	public Object getParent(Object object, IMergeViewerItemProviderConfiguration configuration);

	/**
	 * Determine the children of the given {@code object}
	 * 
	 * @param object
	 *            the {@link Object} for which the children are to be determined.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return an array with the determined children, an empty array if there are none.
	 */
	public Object[] getChildren(Object object, IMergeViewerItemProviderConfiguration configuration);

	/**
	 * Indicates whether the given {@code object} has children.
	 * 
	 * @param object
	 *            the {@link Object} for which it is indicated whether it has children.
	 * @param configuration
	 *            the {@link IMergeViewerItemProviderConfiguration}.
	 * @return {@code true} if the given object has children, {@code false} otherwise.
	 */
	public boolean hasChildren(Object object, IMergeViewerItemProviderConfiguration configuration);
}
