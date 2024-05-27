/*******************************************************************************
 * Copyright (c) 2012, 2015 Obeo.
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
import static org.eclipse.emf.compare.merge.AbstractMerger.isInTerminalState;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.CONTAINMENT_REFERENCE_CHANGE;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.internal.util.ResourceUIUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;

/**
 * A specific {@link AbstractStructuralFeatureAccessor} for containment
 * {@link org.eclipse.emf.compare.ReferenceChange} objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class ContainmentReferenceChangeAccessorImpl extends AbstractStructuralFeatureAccessor {

	/**
	 * {@inheritDoc}.
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.AbstractStructuralFeatureAccessor#AbstractStructuralFeatureAccessor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      org.eclipse.emf.compare.Diff,
	 *      org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide)
	 */
	public ContainmentReferenceChangeAccessorImpl(AdapterFactory adapterFactory, Diff diff,
			MergeViewerSide side) {
		super(adapterFactory, diff, side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.AbstractStructuralFeatureAccessor#
	 *      computeDifferences()
	 */
	@Override
	protected ImmutableList<Diff> computeDifferences() {
		List<Diff> allDifferences = getComparison().getDifferences();
		return ImmutableList.<Diff> copyOf(filter(allDifferences, CONTAINMENT_REFERENCE_CHANGE));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getInitialItem()
	 */
	@Override
	public IMergeViewerItem getInitialItem() {
		Diff initialDiff = getInitialDiff();
		EObject diffValue = (EObject)MergeViewerUtil.getDiffValue(initialDiff);
		Match match = getComparison().getMatch(diffValue);

		if (match == null && isInTerminalState(initialDiff) && MergeViewerSide.ANCESTOR != getSide()) {
			match = getMatchWithNullValues(initialDiff.getMatch());
		}
		if (match != null) {
			return new MergeViewerItem.Container(getComparison(), getInitialDiff(), match, getSide(),
					getRootAdapterFactory());
		}
		return null;
	}

	/**
	 * After merging a diff which will lead to have an insertion point on both sides, the match associated
	 * with this diff will be unreacheable because its left and right sides will be null. This method will
	 * find this match.
	 * 
	 * @param match
	 *            the match of the merged diff.
	 * @return the match associated with the given merged diff.
	 */
	private Match getMatchWithNullValues(Match match) {
		for (Match subMatch : match.getSubmatches()) {
			if (subMatch.getLeft() == null && subMatch.getRight() == null) {
				return subMatch;
			}
		}
		return null;
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	@Override
	public String getType() {
		return TypeConstants.TYPE_ETREE_DIFF;
	}
}
