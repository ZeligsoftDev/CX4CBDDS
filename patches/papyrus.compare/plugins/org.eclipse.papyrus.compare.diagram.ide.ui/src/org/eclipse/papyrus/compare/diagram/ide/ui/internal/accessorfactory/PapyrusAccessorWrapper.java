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
package org.eclipse.papyrus.compare.diagram.ide.ui.internal.accessorfactory;

import com.google.common.collect.ImmutableList;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.swt.graphics.Image;

/**
 * A Papyrus Wrapper for an {@link ICompareAccessor}. All calls are delegated to the given ICompareAccesor,
 * except the {@link #getType()} method which adds a {@link #PAPYRUS_TYPE} in front of the type to indicate
 * the Papyrus context.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 */
public class PapyrusAccessorWrapper implements ICompareAccessor {

	/**
	 * The type-prefix which indicates the Papyrus context.
	 */
	private static final String PAPYRUS_TYPE = "papyrus-"; //$NON-NLS-1$

	/**
	 * The wrapped {@link ICompareAccessor}.
	 */
	private ICompareAccessor delegate;

	/**
	 * The Constructor.
	 * 
	 * @param delegate
	 *            The {@link ICompareAccessor} which is wrapped.
	 */
	public PapyrusAccessorWrapper(ICompareAccessor delegate) {
		this.delegate = delegate;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return delegate.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return delegate.getImage();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getType() {
		return PAPYRUS_TYPE + delegate.getType();
	}

	/**
	 * {@inheritDoc}
	 */
	public Comparison getComparison() {
		return delegate.getComparison();
	}

	/**
	 * {@inheritDoc}
	 */
	public IMergeViewerItem getInitialItem() {
		return delegate.getInitialItem();
	}

	/**
	 * {@inheritDoc}
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		return delegate.getItems();
	}

}
