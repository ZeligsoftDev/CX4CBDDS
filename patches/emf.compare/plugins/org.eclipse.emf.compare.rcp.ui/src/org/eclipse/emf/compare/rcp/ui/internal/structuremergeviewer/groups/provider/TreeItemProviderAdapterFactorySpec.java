/*******************************************************************************
 * Copyright (c) 2013, 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.provider.IItemDescriptionProvider;
import org.eclipse.emf.compare.provider.IItemStyledLabelProvider;
import org.eclipse.emf.compare.provider.ISemanticObjectLabelProvider;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.StructureMergeViewerFilter;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.tree.provider.TreeItemProviderAdapterFactory;

/**
 * A specific implementation of {@link org.eclipse.emf.edit.tree.provider.TreeItemProviderAdapterFactory}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class TreeItemProviderAdapterFactorySpec extends TreeItemProviderAdapterFactory {

	/** An instance of {@code StructureMergeViewerFilter}. */
	private final StructureMergeViewerFilter filter;

	/**
	 * Constructor.
	 * 
	 * @param filter
	 *            The given StructureMergeViewerFilter
	 */
	public TreeItemProviderAdapterFactorySpec(StructureMergeViewerFilter filter) {
		super();
		this.filter = filter;
		supportedTypes.add(IItemFontProvider.class);
		supportedTypes.add(IItemColorProvider.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
		supportedTypes.add(IItemDescriptionProvider.class);
		supportedTypes.add(ISemanticObjectLabelProvider.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.tree.provider.TreeItemProviderAdapterFactory#createTreeNodeAdapter()
	 */
	@Override
	public Adapter createTreeNodeAdapter() {
		return new TreeNodeItemProviderSpec(this, filter);
	}
}
