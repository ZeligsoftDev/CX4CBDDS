/*******************************************************************************
 * Copyright (c) 2013, 2015 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.emf.compare.merge.AbstractMerger.isInTerminalState;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.ConflictKind;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.internal.utils.DiffUtil;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A specific {@link MergeViewerItem} for {@link ResourceAttachmentChange}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 */
public class ResourceAttachmentChangeMergeViewerItem extends MergeViewerItem.Container {

	/**
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem.Container#Container(Comparison
	 *      comparison, Diff diff, Object left, Object right, Object ancestor, MergeViewerSide side,
	 *      AdapterFactory adapterFactory)
	 */
	public ResourceAttachmentChangeMergeViewerItem(Comparison comparison, Diff diff, Resource left,
			Resource right, Resource ancestor, IMergeViewer.MergeViewerSide side,
			AdapterFactory adapterFactory) {
		super(comparison, diff, left, right, ancestor, side, adapterFactory);
	}

	/**
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem.Container#Container(Comparison,
	 *      Diff, Match, MergeViewerSide, AdapterFactory)
	 */
	public ResourceAttachmentChangeMergeViewerItem(Comparison comparison, Diff diff, Match match,
			IMergeViewer.MergeViewerSide side, AdapterFactory adapterFactory) {
		super(comparison, diff, match, side, adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem.Container#hasChildren(IDifferenceGroupProvider,
	 *      Predicate)
	 */
	@Override
	public boolean hasChildren(IDifferenceGroupProvider groupProvider, Predicate<? super EObject> predicate) {
		return getChildren(groupProvider, predicate).length > 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem.Container#getChildren(IDifferenceGroupProvider,
	 *      Predicate)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IMergeViewerItem[] getChildren(IDifferenceGroupProvider group,
			Predicate<? super EObject> filters) {
		Object sideValue = getSideValue(getSide());
		Object bestSideValue = getBestSideValue();

		List<IMergeViewerItem> ret = newArrayList();

		if (bestSideValue instanceof Resource) {
			List<IMergeViewerItem> mergeViewerItems = newArrayList();
			if (sideValue instanceof Resource) {
				mergeViewerItems = createMergeViewerItemFrom(((Resource)sideValue).getContents());
			}

			if (getSide() != IMergeViewer.MergeViewerSide.ANCESTOR) {
				EList<Diff> differences = getComparison().getDifferences();
				Iterable<ResourceAttachmentChange> racs = filter(differences, ResourceAttachmentChange.class);
				List<ResourceAttachmentChange> resourceAttachmentChanges = Lists.newArrayList(racs);
				Object left = getLeft();
				Object right = getRight();
				Object ancestor = getAncestor();
				for (ResourceAttachmentChange resourceAttachmentChange : racs) {
					// filter out merged reference changes
					if (isInTerminalState(resourceAttachmentChange)) {
						// Remove resource attachment changes that are not linked with the current resources.
						resourceAttachmentChanges.remove(resourceAttachmentChange);
					} else if (isUnrelated(resourceAttachmentChange, left)
							&& isUnrelated(resourceAttachmentChange, right)
							&& isUnrelated(resourceAttachmentChange, ancestor)) {
						resourceAttachmentChanges.remove(resourceAttachmentChange);
					}
				}
				ret.addAll(createInsertionPoints(mergeViewerItems,
						(List<ResourceAttachmentChange>)filteredDiffs(resourceAttachmentChanges, filters,
								group)));
			} else {
				ret.addAll(mergeViewerItems);
			}

		}

		return ret.toArray(getNoItemsArr());
	}

	private boolean isUnrelated(ResourceAttachmentChange change, Object resource) {
		final String resourceURI = change.getResourceURI();
		return resource == null || (resource instanceof Resource && resourceURI != null
				&& !resourceURI.equals(((Resource)resource).getURI().toString()));
	}

	/**
	 * Creates an IMergeViewerItem from an EObject.
	 * 
	 * @param eObject
	 *            the given eObject.
	 * @return an IMergeViewerItem.
	 */
	@Override
	protected IMergeViewerItem createMergeViewerItemFrom(EObject eObject) {

		Match match = getComparison().getMatch(eObject);

		if (match != null) {
			ResourceAttachmentChange rac = getFirst(
					filter(match.getDifferences(), ResourceAttachmentChange.class), null);
			if (rac != null) {
				Object left = match.getLeft();
				Object right = match.getRight();
				Object ancestor = match.getOrigin();
				// Manage case where the resource attachment change is between an existing resource and an
				// unknown resource
				if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.LEFT, rac) == null) {
					left = null;
				}
				if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.RIGHT, rac) == null) {
					right = null;
				}
				if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.ANCESTOR, rac) == null) {
					ancestor = null;
				}

				return new MergeViewerItem.Container(getComparison(), rac, left, right, ancestor, getSide(),
						getAdapterFactory());
			}
		}
		return null;

	}

	/**
	 * Creates insertion points for the given list of IMergeViewerItem corresponding to the given list of
	 * ResourceAttachmentChange.
	 * 
	 * @param values
	 *            the given list of IMergeViewerItem.
	 * @param racs
	 *            the givel list of ResourceAttachmentChange
	 * @return the given list of IMergeViewerItem with additional insertion points.
	 */
	private List<? extends IMergeViewerItem> createInsertionPoints(
			final List<? extends IMergeViewerItem> values, final List<ResourceAttachmentChange> racs) {
		List<IMergeViewerItem> ret = newArrayList(values);
		for (ResourceAttachmentChange diff : Lists.reverse(racs)) {
			boolean rightToLeft = (getSide() == IMergeViewer.MergeViewerSide.LEFT);
			Comparison comparison = getComparison();
			Object left = MergeViewerUtil.getValueFromResourceAttachmentChange(diff, comparison,
					IMergeViewer.MergeViewerSide.LEFT);
			Object right = MergeViewerUtil.getValueFromResourceAttachmentChange(diff, comparison,
					IMergeViewer.MergeViewerSide.RIGHT);

			DifferenceSource source = diff.getSource();
			DifferenceKind kind = diff.getKind();
			boolean b1 = source == DifferenceSource.LEFT && kind == DifferenceKind.DELETE
					&& getSide() == MergeViewerSide.LEFT && !isInTerminalState(diff);
			boolean b2 = source == DifferenceSource.LEFT && kind == DifferenceKind.ADD
					&& getSide() == MergeViewerSide.RIGHT && !isInTerminalState(diff);
			boolean b3 = source == DifferenceSource.RIGHT && kind == DifferenceKind.ADD
					&& getSide() == MergeViewerSide.LEFT && !isInTerminalState(diff);
			boolean b4 = source == DifferenceSource.RIGHT && kind == DifferenceKind.DELETE
					&& getSide() == MergeViewerSide.RIGHT && !isInTerminalState(diff);

			boolean b5 = isInTerminalState(diff) && source == DifferenceSource.LEFT
					&& kind == DifferenceKind.ADD && right == null;
			boolean b6 = isInTerminalState(diff) && source == DifferenceSource.LEFT
					&& kind == DifferenceKind.DELETE && left == null;
			boolean b7 = isInTerminalState(diff) && source == DifferenceSource.RIGHT
					&& kind == DifferenceKind.ADD && left == null;
			boolean b8 = isInTerminalState(diff) && source == DifferenceSource.RIGHT
					&& kind == DifferenceKind.DELETE && right == null;
			// do not duplicate insertion point for pseudo add conflict
			// so we must only create one for pseudo delete conflict
			boolean b9 = diff.getConflict() == null
					|| (diff.getConflict().getKind() != ConflictKind.PSEUDO || kind == DifferenceKind.DELETE);

			if ((b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8) && b9) {
				Object ancestor = MergeViewerUtil.getValueFromResourceAttachmentChange(diff, comparison,
						IMergeViewer.MergeViewerSide.ANCESTOR);
				if (left != null && MergeViewerUtil.getResource(comparison, IMergeViewer.MergeViewerSide.LEFT,
						diff) == null) {
					left = null;
				}
				if (right != null && MergeViewerUtil.getResource(comparison,
						IMergeViewer.MergeViewerSide.RIGHT, diff) == null) {
					right = null;
				}
				if (ancestor != null && MergeViewerUtil.getResource(comparison,
						IMergeViewer.MergeViewerSide.ANCESTOR, diff) == null) {
					ancestor = null;
				}
				if (b5 || b8) {
					left = null;
				}
				if (b6 || b7) {
					right = null;
				}
				IMergeViewerItem insertionPoint = new MergeViewerItem.Container(comparison, diff, left, right,
						ancestor, getSide(), getAdapterFactory());

				final int insertionIndex;
				if (left == null && right == null && ancestor != null) {
					Resource resource = MergeViewerUtil.getResource(comparison,
							IMergeViewer.MergeViewerSide.ANCESTOR, diff);
					List<EObject> contents = resource.getContents();
					insertionIndex = contents.indexOf(ancestor);
				} else {
					insertionIndex = Math.min(findInsertionIndex(diff, rightToLeft), ret.size());
				}

				// offset the insertion by the number of previous insertion points in the list
				// Can not b improved by keeping the number of created insertion points because the given
				// "values" parameter may already contains some insertion points.
				int realIndex = 0;
				for (int index = 0; index < insertionIndex && realIndex < ret.size(); realIndex++) {
					if (!ret.get(realIndex).isInsertionPoint()) {
						index++;
					}
				}
				ret.add(realIndex, insertionPoint);
			}
		}
		return ret;
	}

	/**
	 * Find an insertion index for the given diff.
	 * 
	 * @param diff
	 *            the given diff.
	 * @param rightToLeft
	 *            the way of merge.
	 * @return an insertion index for the given diff.
	 */
	private int findInsertionIndex(Diff diff, boolean rightToLeft) {
		final Match valueMatch = diff.getMatch();
		final Comparison comparison = getComparison();

		final EObject expectedValue;
		if (valueMatch.getLeft() != null) {
			expectedValue = valueMatch.getLeft();
		} else {
			expectedValue = valueMatch.getRight();
		}

		final Resource initialResource;
		final Resource expectedResource;
		if (rightToLeft) {
			initialResource = MergeViewerUtil.getResource(comparison, IMergeViewer.MergeViewerSide.RIGHT,
					diff);
			expectedResource = MergeViewerUtil.getResource(comparison, IMergeViewer.MergeViewerSide.LEFT,
					diff);
		} else {
			initialResource = MergeViewerUtil.getResource(comparison, IMergeViewer.MergeViewerSide.LEFT,
					diff);
			expectedResource = MergeViewerUtil.getResource(comparison, IMergeViewer.MergeViewerSide.RIGHT,
					diff);
		}
		if (expectedResource != null) {
			final List<EObject> sourceList = initialResource.getContents();
			final List<EObject> targetList = expectedResource.getContents();

			return DiffUtil.findInsertionIndex(comparison, sourceList, targetList, expectedValue);
		} else {
			return 0;
		}
	}

}
