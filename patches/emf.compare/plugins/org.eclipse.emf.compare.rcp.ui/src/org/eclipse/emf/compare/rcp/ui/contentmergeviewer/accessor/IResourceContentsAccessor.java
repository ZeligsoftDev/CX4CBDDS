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

import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A specific {@link ICompareAccessor} for resource contents. This compare accessor known the resource where
 * it comes from.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public interface IResourceContentsAccessor extends ICompareAccessor {

	/**
	 * Returns the resource of the model involved with the accessor given the side of the content merge viewer
	 * for which we want to know the resource.
	 * 
	 * @param side
	 *            the side of the content merge viewer for which we want the resource.
	 * @return the resource of the model involved with the accessor.
	 */
	Resource getResource(MergeViewerSide side);
}
