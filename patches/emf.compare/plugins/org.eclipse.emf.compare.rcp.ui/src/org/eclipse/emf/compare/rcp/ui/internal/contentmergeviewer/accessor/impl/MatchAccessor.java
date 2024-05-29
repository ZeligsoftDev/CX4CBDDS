/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getFirst;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.internal.util.ResourceUIUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * A specific {@link ICompareAccessor} for {@link Match} objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class MatchAccessor extends AbstractTypedElementAdapter implements ICompareAccessor {

	/** The match associated with this accessor. */
	private final Match fMatch;

	/** The diff associated with this accessor. */
	private Diff fDiff;

	/** The side of this accessor. */
	private final MergeViewerSide fSide;

	/**
	 * Creates a new object wrapping the given <code>eObject</code>.
	 * 
	 * @param adapterFactory
	 *            the adapter factory used to create the accessor.
	 * @param match
	 *            the match to associate with this accessor.
	 * @param side
	 *            the side of this accessor.
	 */
	public MatchAccessor(AdapterFactory adapterFactory, Match match, MergeViewerSide side) {
		this(adapterFactory, match, null, side);
	}

	/**
	 * Creates a new object wrapping the given <code>eObject</code>.
	 * 
	 * @param adapterFactory
	 *            the adapter factory used to create the accessor.
	 * @param match
	 *            the match to associate with this accessor.
	 * @param diff
	 *            the diff associated with this accessor.
	 * @param side
	 *            the side of this accessor.
	 */
	public MatchAccessor(AdapterFactory adapterFactory, Match match, Diff diff, MergeViewerSide side) {
		super(adapterFactory);
		fMatch = match;
		fDiff = diff;
		fSide = side;
	}

	/**
	 * Returns the side of this accessor.
	 * 
	 * @return the side of this accessor.
	 */
	protected final MergeViewerSide getSide() {
		return fSide;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getName()
	 */
	public String getName() {
		final EObject eObject = MergeViewerUtil.getBestSideEObject(fMatch, fSide);
		if (eObject != null) {
			return getItemDelegator().getText(eObject);
		} else {
			return getItemDelegator().getText(fMatch);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getImage()
	 */
	public Image getImage() {
		final EObject eObject = MergeViewerUtil.getBestSideEObject(fMatch, fSide);
		final Object image;
		if (eObject != null) {
			image = getItemDelegator().getImage(eObject);
		} else {
			image = getItemDelegator().getImage(fMatch);
		}
		return ExtendedImageRegistry.getInstance().getImage(image);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		return TypeConstants.TYPE_EMATCH;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getComparison()
	 */
	public Comparison getComparison() {
		return fMatch.getComparison();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getInitialItem()
	 */
	public IMergeViewerItem getInitialItem() {
		final MergeViewerItem.Container container;
		if (fMatch instanceof NotLoadedFragmentMatch) {
			container = new MergeViewerItem.Container(fMatch.getComparison(), fDiff, fMatch, fMatch, fMatch,
					fSide, getRootAdapterFactory());
		} else {
			container = new MergeViewerItem.Container(fMatch.getComparison(), fDiff, fMatch, fSide,
					getRootAdapterFactory());
		}
		return container;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getItems()
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		final ImmutableList.Builder<IMergeViewerItem> ret = ImmutableList.builder();
		final Collection<IMergeViewerItem> items = Lists.newArrayList();
		final Collection<Match> matches = getComparison().getMatches();

		for (Match match : matches) {
			MergeViewerItem.Container container = null;
			if (ResourceUIUtil.isFragment(match, getSide())) {
				IMergeViewerItem item = ResourceUIUtil.createItemForNotLoadedFragmentMatch(match, getSide(),
						getComparison(), getRootAdapterFactory());
				if (item != null) {
					items.add(item);
				}
			} else if (getSide() != MergeViewerSide.ANCESTOR
					|| (getSide() == MergeViewerSide.ANCESTOR && match.getOrigin() != null)) {
				ResourceAttachmentChange diff = getFirst(
						filter(match.getDifferences(), ResourceAttachmentChange.class), null);
				container = new MergeViewerItem.Container(getComparison(), diff, match.getLeft(),
						match.getRight(), match.getOrigin(), getSide(), getRootAdapterFactory());
				items.add(container);
			}
		}

		final IMergeViewerItem newContainer = ResourceUIUtil.addNewContainerForNotLoadedFragmentMatches(items,
				getSide(), getComparison(), getRootAdapterFactory());
		if (newContainer != null) {
			ret.add(newContainer);
		} else {
			ret.addAll(items);
		}
		return ret.build();
	}
}
