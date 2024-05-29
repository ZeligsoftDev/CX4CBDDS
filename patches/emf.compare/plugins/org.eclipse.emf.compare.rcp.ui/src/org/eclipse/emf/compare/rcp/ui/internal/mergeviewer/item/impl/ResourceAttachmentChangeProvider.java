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
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl;

import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemContentProvider;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.provider.IMergeViewerItemProviderConfiguration;

/**
 * Legacy Provider to keep backward compatibility with {@link ResourceAttachmentChangeMergeViewerItem}.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class ResourceAttachmentChangeProvider implements IMergeViewerItemContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object object, IMergeViewerItemProviderConfiguration configuration) {
		return ((ResourceAttachmentChangeMergeViewerItem)object).getParent();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object object, IMergeViewerItemProviderConfiguration configuration) {
		return ((ResourceAttachmentChangeMergeViewerItem)object).getChildren(
				configuration.getDifferenceGroupProvider(), configuration.getDifferenceFilterPredicate());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object object, IMergeViewerItemProviderConfiguration configuration) {
		return ((ResourceAttachmentChangeMergeViewerItem)object).hasChildren(
				configuration.getDifferenceGroupProvider(), configuration.getDifferenceFilterPredicate());
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canHandle(Object object) {
		return object instanceof ResourceAttachmentChangeMergeViewerItem;
	}

}
