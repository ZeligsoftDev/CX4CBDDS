/*******************************************************************************
 * Copyright (c) 2012, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 514079
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.impl;

import com.google.common.base.Predicate;
import com.google.common.eventbus.Subscribe;

import org.eclipse.emf.compare.rcp.ui.internal.configuration.IEMFCompareConfiguration;
import org.eclipse.emf.compare.rcp.ui.internal.util.SWTUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilterChange;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProviderChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.swt.events.DisposeEvent;

/**
 * An abstract implementation of {@link IMergeViewer}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractMergeViewer extends ContentViewer implements IMergeViewer {

	/** The side of the viewer. */
	private final MergeViewerSide fSide;

	/** The compare configuration object used by this viewer. */
	private final IEMFCompareConfiguration compareConfiguration;

	/** The filter to apply on this viewer. */
	private Predicate<? super EObject> differenceFilter;

	/** The difference group provider used by this viewer. */
	private IDifferenceGroupProvider differenceGroupProvider;

	/**
	 * Default constructor.
	 * 
	 * @param side
	 *            the side of the viewer.
	 * @param compareConfiguration
	 *            the compare configuration object used by this viewer.
	 */
	public AbstractMergeViewer(MergeViewerSide side, final IEMFCompareConfiguration compareConfiguration) {
		fSide = side;
		this.compareConfiguration = compareConfiguration;
		getCompareConfiguration().getEventBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer#getSide()
	 */
	public MergeViewerSide getSide() {
		return fSide;
	}

	/**
	 * Returns the effective side taking into account {@link CompareConfiguration#isMirrored()} to switch left
	 * and right.
	 * 
	 * @param side
	 * @return the effective side with respect to mirroring.
	 */
	protected MergeViewerSide getEffectiveSide() {
		if (getCompareConfiguration().isMirrored()) {
			return getSide().opposite();
		}
		return getSide();
	}

	/**
	 * Returns the compare configuration object used by this viewer.
	 * 
	 * @return the compare configuration object used by this viewer.
	 */
	protected IEMFCompareConfiguration getCompareConfiguration() {
		return compareConfiguration;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ContentViewer#handleDispose(org.eclipse.swt.events.DisposeEvent)
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		getCompareConfiguration().getEventBus().unregister(this);
		super.handleDispose(event);
	}

	/**
	 * Handle the change of difference group provider in the UI.
	 * 
	 * @param event
	 *            an IDifferenceGroupProviderChange that stores the new selected difference group provider.
	 */
	@Subscribe
	public void handleDifferenceGroupProviderChange(IDifferenceGroupProviderChange event) {
		differenceGroupProvider = event.getDifferenceGroupProvider();
		SWTUtil.safeRefresh(this, true, true);
	}

	/**
	 * Returns the difference group provider selected in the UI.
	 * 
	 * @return the difference group provider selected in the UI.
	 */
	public IDifferenceGroupProvider getDifferenceGroupProvider() {
		if (differenceGroupProvider == null) {
			return getCompareConfiguration().getStructureMergeViewerGrouper().getProvider();
		} else {
			return differenceGroupProvider;
		}
	}

	/**
	 * Handle the change of filters in the UI.
	 * 
	 * @param event
	 *            an IDifferenceFilterChange that stores the new state of filters.
	 */
	@Subscribe
	public void handleDifferenceFilterChange(IDifferenceFilterChange event) {
		differenceFilter = event.getPredicate();
		SWTUtil.safeRefresh(this, true, true);
	}

	/**
	 * Returns an aggregated predicate corresponding to the selected predicates of selected filters and
	 * unselected predicates of unselected filters in the UI.
	 * 
	 * @return an aggregated predicate corresponding to the selected predicates of selected filters and
	 *         unselected predicates of unselected filters in the UI.
	 */
	protected final Predicate<? super EObject> getDifferenceFilter() {
		if (differenceFilter == null) {
			return getCompareConfiguration().getStructureMergeViewerFilter().getAggregatedPredicate();
		} else {
			return differenceFilter;
		}
	}
}
