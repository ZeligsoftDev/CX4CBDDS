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

import com.google.common.base.Predicate;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.ecore.EObject;

/**
 * The configuration used by {@link IMergeViewerItemContentProvider}s.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 4.4
 */
public interface IMergeViewerItemProviderConfiguration {

	/**
	 * Get the {@link AdapterFactory}.
	 * 
	 * @return the {@link AdapterFactory},
	 */
	public AdapterFactory getAdapterFactory();

	/**
	 * Get the {@link IDifferenceGroupProvider}.
	 * 
	 * @return the {@link IDifferenceGroupProvider}.
	 */
	public IDifferenceGroupProvider getDifferenceGroupProvider();

	/**
	 * Get the difference filter {@link Predicate}.
	 * 
	 * @return the difference filter {@link Predicate}.
	 */
	public Predicate<? super EObject> getDifferenceFilterPredicate();

	/**
	 * Get the {@link Comparison}.
	 * 
	 * @return the {@link Comparison}.
	 */
	public Comparison getComparison();

	/**
	 * Get the {@link MergeViewerSide}.
	 * 
	 * @return the {@link MergeViewerSide}.
	 */
	public MergeViewerSide getSide();
}
