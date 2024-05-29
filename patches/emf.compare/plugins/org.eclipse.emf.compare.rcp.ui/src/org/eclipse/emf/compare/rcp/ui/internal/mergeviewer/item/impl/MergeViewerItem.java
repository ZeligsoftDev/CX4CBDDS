/*******************************************************************************
 * Copyright (c) 2012, 2015 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.isEmpty;
import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newArrayListWithCapacity;
import static org.eclipse.emf.compare.merge.AbstractMerger.isInTerminalState;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.CONTAINMENT_REFERENCE_CHANGE;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.fromSide;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.onFeature;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.ConflictKind;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.graph.IGraphView;
import org.eclipse.emf.compare.internal.spec.EObjectUtil;
import org.eclipse.emf.compare.internal.utils.DiffUtil;
import org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.internal.util.ResourceUIUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.utils.Objects;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class MergeViewerItem extends AdapterImpl implements IMergeViewerItem {

	private final Object fLeft;

	private final Object fRight;

	private final Object fAncestor;

	private final Diff fDiff;

	private final Comparison fComparison;

	private final MergeViewerSide fSide;

	private final AdapterFactory fAdapterFactory;

	public MergeViewerItem(Comparison comparison, Diff diff, Object left, Object right, Object ancestor,
			MergeViewerSide side, AdapterFactory adapterFactory) {
		fLeft = left;
		fRight = right;
		fAncestor = ancestor;
		fDiff = diff;
		fSide = side;
		fAdapterFactory = adapterFactory;
		fComparison = comparison;
	}

	/**
	 * @param comparison
	 * @param diff
	 * @param match
	 * @param side
	 * @param adapterFactory
	 */
	public MergeViewerItem(Comparison comparison, Diff diff, Match match, MergeViewerSide side,
			AdapterFactory adapterFactory) {
		this(comparison, diff, match.getLeft(), match.getRight(), match.getOrigin(), side, adapterFactory);
	}

	/**
	 * @return
	 */
	public final Diff getDiff() {
		return fDiff;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.ide.ui.internal.contentmergeviewer.IMergeViewerItem#getAncestor()
	 */
	public final Object getAncestor() {
		return fAncestor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.ide.ui.internal.contentmergeviewer.IMergeViewerItem#getLeft()
	 */
	public final Object getLeft() {
		return fLeft;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.ide.ui.internal.contentmergeviewer.IMergeViewerItem#getRight()
	 */
	public final Object getRight() {
		return fRight;
	}

	/**
	 * @return the fSide
	 */
	public final MergeViewerSide getSide() {
		return fSide;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.ide.ui.internal.contentmergeviewer.IMergeViewerItem#getSideValue(org.eclipse.emf.compare.rcp.ui.mergeviewer.ide.ui.internal.contentmergeviewer.IMergeViewer.MergeViewerSide)
	 */
	public final Object getSideValue(MergeViewerSide side) {
		switch (side) {
			case LEFT:
				return fLeft;
			case RIGHT:
				return fRight;
			case ANCESTOR:
				return fAncestor;
			default:
				throw new IllegalStateException(); // happy compiler :)
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem#getParent()
	 */
	public IMergeViewerItem.Container getParent() {
		IMergeViewerItem.Container ret = null;

		if (getDiff() instanceof ResourceAttachmentChange) {
			ret = createBasicContainer((ResourceAttachmentChange)getDiff());
		} else {
			Object sideValue = getBestSideValue();
			ITreeItemContentProvider treeItemContentProvider = (ITreeItemContentProvider)fAdapterFactory
					.adapt(sideValue, ITreeItemContentProvider.class);

			Object parent = treeItemContentProvider != null ? treeItemContentProvider.getParent(sideValue)
					: null;
			if (parent instanceof EObject) {
				ret = createBasicContainer((EObject)parent);
			}
		}
		return ret;
	}

	public IMergeViewerItem cloneAsOpposite() {
		return new MergeViewerItem(getComparison(), getDiff(), getLeft(), getRight(), getAncestor(),
				getSide(), getAdapterFactory());
	}

	protected final Object getBestSideValue() {
		Object sideValue;
		if (fSide != MergeViewerSide.ANCESTOR) {
			sideValue = getSideValue(fSide);
			if (sideValue == null) {
				sideValue = getSideValue(fSide.opposite());
				if (sideValue == null) {
					sideValue = getSideValue(MergeViewerSide.ANCESTOR);
				}
			}
		} else {
			sideValue = getSideValue(MergeViewerSide.ANCESTOR);
			if (sideValue == null) {
				sideValue = getSideValue(MergeViewerSide.LEFT);
				if (sideValue == null) {
					sideValue = getSideValue(MergeViewerSide.RIGHT);
				}
			}
		}
		return sideValue;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem#isInsertionPoint()
	 */
	public boolean isInsertionPoint() {
		return getSideValue(getSide()) == null && getDiff() != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String className = this.getClass().getName();
		int start = className.lastIndexOf('.');
		// @formatter:off
		return Objects.toStringHelper(className.substring(start + 1))
				.add("ancestor", EObjectUtil.getLabel((EObject)getAncestor())) //$NON-NLS-1$
				.add("left", EObjectUtil.getLabel((EObject)getLeft())) //$NON-NLS-1$
				.add("right", EObjectUtil.getLabel((EObject)getRight())) //$NON-NLS-1$
				.add("side", getSide()) //$NON-NLS-1$
				.add("diff", getDiff()).toString(); //$NON-NLS-1$
		// @formatter:on
	}

	/**
	 * @return the fComparison
	 */
	public final Comparison getComparison() {
		return fComparison;
	}

	/**
	 * @return the fAdapterFactory
	 */
	protected final AdapterFactory getAdapterFactory() {
		return fAdapterFactory;
	}

	@Deprecated
	protected final IMergeViewerItem.Container createBasicContainer(EObject eObject) {
		IMergeViewerItem.Container ret = null;
		Match parentMatch = fComparison.getMatch(eObject);
		if (parentMatch == null) {
			return null;
		}
		EObject expectedValue = MergeViewerUtil.getEObject(parentMatch, fSide);
		if (expectedValue != null) {
			Iterable<? extends Diff> diffs = getDiffsWithValue(expectedValue, parentMatch);
			Diff diff = getFirst(diffs, null);
			ret = new MergeViewerItem.Container(fComparison, diff, parentMatch, fSide, fAdapterFactory);

		} else {
			expectedValue = MergeViewerUtil.getEObject(parentMatch, fSide.opposite());
			Iterable<? extends Diff> diffs = Lists.newArrayList();
			if (expectedValue != null) {
				diffs = getDiffsWithValue(expectedValue, parentMatch);
			}
			if (isEmpty(diffs)) {
				expectedValue = MergeViewerUtil.getEObject(parentMatch, MergeViewerSide.ANCESTOR);
				if (expectedValue != null) {
					diffs = getDiffsWithValue(expectedValue, parentMatch);
				}
			}

			if (!isEmpty(diffs)) {
				Diff diff = diffs.iterator().next();
				if (diff instanceof ResourceAttachmentChange) {
					ret = new MergeViewerItem.Container(fComparison, diff, parentMatch, fSide,
							fAdapterFactory);
				} else {
					ret = createInsertionPoint(diff, fSide, fAdapterFactory);
				}
			}
		}
		return ret;
	}

	/**
	 * Return an Iterable of {@link Diff} which are linked to the given expectedValue. Try to get containment
	 * reference changes first, then if empty, try to get resource attachment changes.
	 * 
	 * @param expectedValue
	 * @return
	 */
	private Iterable<? extends Diff> getDiffsWithValue(EObject expectedValue, Match parentMatch) {
		Iterable<? extends Diff> diffs = filter(fComparison.getDifferences(expectedValue),
				CONTAINMENT_REFERENCE_CHANGE);
		if (size(diffs) > 1 && fSide != MergeViewerSide.ANCESTOR) {
			diffs = filter(diffs, fromSide(fSide.convertToDifferenceSource()));
			if (size(diffs) > 1) {
				throw new IllegalStateException(
						"Should not have more than one ReferenceChange on each Match for a side"); //$NON-NLS-1$
			}
		}

		Diff referenceChange = getFirst(diffs, null);
		if (referenceChange == null) {
			diffs = filter(parentMatch.getDifferences(), instanceOf(ResourceAttachmentChange.class));
		}

		return diffs;
	}

	/**
	 * Create an IMergeViewerItem for the parent of the given {@link ResourceAttachmentChange}.
	 * 
	 * @param diff
	 *            the given {@link ResourceAttachmentChange}.
	 * @return an IMergeViewerItem.
	 */
	@Deprecated
	protected final IMergeViewerItem.Container createBasicContainer(ResourceAttachmentChange diff) {
		final Comparison comparison = getComparison();
		Resource left = MergeViewerUtil.getResource(comparison, MergeViewerSide.LEFT, diff);
		Resource right = MergeViewerUtil.getResource(comparison, MergeViewerSide.RIGHT, diff);
		Resource ancestor = MergeViewerUtil.getResource(comparison, MergeViewerSide.ANCESTOR, diff);
		IMergeViewerItem.Container ret = new ResourceAttachmentChangeMergeViewerItem(comparison, null, left,
				right, ancestor, getSide(), getAdapterFactory());
		return ret;
	}

	@Deprecated
	protected final List<IMergeViewerItem> createInsertionPoints(Comparison comparison,
			EStructuralFeature eStructuralFeature, final List<? extends IMergeViewerItem> values,
			List<? extends Diff> differences) {
		final List<IMergeViewerItem> ret = newArrayList(values);
		if (differences.isEmpty()) {
			return ret;
		}

		final List<Object> sideContent = ReferenceUtil.getAsList((EObject)getSideValue(getSide()),
				eStructuralFeature);
		final List<Object> oppositeContent = ReferenceUtil
				.getAsList((EObject)getSideValue(getSide().opposite()), eStructuralFeature);

		for (Diff diff : Lists.reverse(differences)) {
			EObject value = (EObject)MergeViewerUtil.getDiffValue(diff);
			Match match = getComparison().getMatch(value);
			if (!isPseudoAddConflict(diff) && (isAddOnOppositeSide(diff) || isDeleteOnSameSide(diff)
					|| isInsertOnBothSides(diff, match))) {
				if (match == null && isInTerminalState(diff)) {
					EObject bestSideValue = (EObject)getBestSideValue();
					match = getComparison().getMatch(bestSideValue);
					match = getMatchWithNullValues(match);
				}

				if (match != null && !isRealAddConflict(diff, match)) {
					IMergeViewerItem.Container insertionPoint = new MergeViewerItem.Container(getComparison(),
							diff, match.getLeft(), match.getRight(), match.getOrigin(), getSide(),
							getAdapterFactory());

					final int insertionIndex;
					if (match.getLeft() == null && match.getRight() == null && diff.getConflict() != null
							&& diff.getConflict().getKind() == ConflictKind.PSEUDO) {
						// pseudo conflict delete...
						insertionIndex = ReferenceUtil
								.getAsList((EObject)getSideValue(MergeViewerSide.ANCESTOR),
										eStructuralFeature)
								.indexOf(value);
					} else {
						insertionIndex = Math.min(
								DiffUtil.findInsertionIndex(comparison, oppositeContent, sideContent, value),
								ret.size());
					}

					// offset the insertion by the number of previous insertion points in the list
					// Cannot be improved by keeping the number of created insertion points because the given
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
		}
		return ret;
	}

	private boolean isAddOnOppositeSide(Diff diff) {
		if (!isInTerminalState(diff) && diff.getKind() == DifferenceKind.ADD) {
			DifferenceSource source = diff.getSource();
			MergeViewerSide side = getSide();
			return (source == DifferenceSource.LEFT && side == MergeViewerSide.RIGHT)
					|| (source == DifferenceSource.RIGHT && side == MergeViewerSide.LEFT);
		}

		return false;
	}

	private boolean isDeleteOnSameSide(Diff diff) {
		if (!isInTerminalState(diff) && diff.getKind() == DifferenceKind.DELETE) {
			DifferenceSource source = diff.getSource();
			MergeViewerSide side = getSide();
			return (source == DifferenceSource.LEFT && side == MergeViewerSide.LEFT)
					|| (source == DifferenceSource.RIGHT && side == MergeViewerSide.RIGHT);
		}

		return false;
	}

	private boolean isInsertOnBothSides(Diff diff, Match match) {
		return isInTerminalState(diff)
				&& (match == null || (match.getLeft() == null && match.getRight() == null));
	}

	private boolean isPseudoAddConflict(Diff diff) {
		Conflict conflict = diff.getConflict();
		return conflict != null && conflict.getKind() == ConflictKind.PSEUDO
				&& diff.getKind() == DifferenceKind.ADD;
	}

	private boolean isRealAddConflict(Diff diff, Match match) {
		// Real add conflict (see https://bugs.eclipse.org/bugs/show_bug.cgi?id=442898)
		return match.getRight() != null && match.getLeft() != null && isAddOnOppositeSide(diff);
	}

	/**
	 * After merging a diff which will lead to have an insertion point on both sides, the match associated
	 * with this diff will be unreacheable because its left and right sides will be null. This method will
	 * find this match.
	 * 
	 * @param match
	 *            the given match.
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

	private IMergeViewerItem.Container createInsertionPoint(Diff diff, MergeViewerSide side,
			AdapterFactory adapterFactory) {
		Object left = MergeViewerUtil.getValueFromDiff(diff, MergeViewerSide.LEFT);
		Object right = MergeViewerUtil.getValueFromDiff(diff, MergeViewerSide.RIGHT);

		IMergeViewerItem.Container insertionPoint = null;
		if (left == null && right == null) {
			// Do not display anything
		} else {
			final boolean leftEmptyBox = side == MergeViewerSide.LEFT
					&& (left == null || !MergeViewerUtil.getValues(diff, side).contains(left));
			final boolean rightEmptyBox = side == MergeViewerSide.RIGHT
					&& (right == null || !MergeViewerUtil.getValues(diff, side).contains(right));
			if (leftEmptyBox || rightEmptyBox) {
				Object ancestor = MergeViewerUtil.getValueFromDiff(diff, MergeViewerSide.ANCESTOR);

				insertionPoint = new MergeViewerItem.Container(getComparison(), diff, left, right, ancestor,
						side, adapterFactory);
			}
		}

		return insertionPoint;
	}

	@Deprecated
	protected final List<IMergeViewerItem> createMergeViewerItemFrom(Collection<?> values) {
		List<IMergeViewerItem> ret = newArrayListWithCapacity(values.size());
		for (EObject value : filter(values, EObject.class)) {
			Match match = getComparison().getMatch(value);
			if (this.fDiff != null || (match != null && !isMatchWithAllProxyData(match))) {
				IMergeViewerItem valueToAdd = createMergeViewerItemFrom(value);
				if (valueToAdd != null) {
					ret.add(valueToAdd);
				}
			}
		}
		return ret;
	}

	@Deprecated
	protected boolean yieldsMergeViewerItem(Collection<?> values) {
		Iterable<EObject> elements = filter(values, EObject.class);
		if (fDiff != null && !Iterables.isEmpty(elements)) {
			return true;
		}

		for (EObject element : elements) {
			Match match = getComparison().getMatch(element);
			if (match != null && !isMatchWithAllProxyData(match)) {
				return true;
			}
		}

		return false;
	}

	@Deprecated
	protected boolean yieldsInsertionPoint(Iterable<Diff> diffs) {
		return Iterables.any(diffs, new Predicate<Diff>() {
			public boolean apply(Diff diff) {
				if (isPseudoAddConflict(diff)) {
					return false;
				}

				EObject value = (EObject)MergeViewerUtil.getDiffValue(diff);
				Match match = getComparison().getMatch(value);
				if (isAddOnOppositeSide(diff) || isDeleteOnSameSide(diff)
						|| isInsertOnBothSides(diff, match)) {
					if (match == null && isInTerminalState(diff)) {
						EObject bestSideValue = (EObject)getBestSideValue();
						match = getComparison().getMatch(bestSideValue);
						match = getMatchWithNullValues(match);
					}

					return match != null && !isRealAddConflict(diff, match);
				}

				return false;
			}
		});
	}

	/**
	 * Check if the given match holds a proxy on each side.
	 * 
	 * @param match
	 *            the given match.
	 * @return true if the given match holds a proxy on each side, false otherwise.
	 */
	private boolean isMatchWithAllProxyData(Match match) {
		boolean proxy = false;
		EObject left = match.getLeft();
		EObject right = match.getRight();
		EObject origin = match.getOrigin();
		if (left != null && right != null) {
			if (left.eIsProxy() && right.eIsProxy()) {
				proxy = true;
			}
		}
		if (proxy == true && fComparison.isThreeWay() && (origin == null || !origin.eIsProxy())) {
			proxy = false;
		}
		return proxy;
	}

	/**
	 * Creates an IMergeViewerItem from an EObject.
	 * 
	 * @param eObject
	 *            the given eObject.
	 * @return an IMergeViewerItem.
	 */
	@Deprecated
	protected IMergeViewerItem createMergeViewerItemFrom(EObject eObject) {

		Match match = getComparison().getMatch(eObject);

		ReferenceChange referenceChange = (ReferenceChange)getFirst(
				filter(getComparison().getDifferences(eObject), CONTAINMENT_REFERENCE_CHANGE), null);
		if (match != null) {
			return new MergeViewerItem.Container(getComparison(), referenceChange, match, getSide(),
					getAdapterFactory());
		} else {
			switch (getSide()) {
				case LEFT:
					return new MergeViewerItem.Container(getComparison(), referenceChange, eObject, null,
							null, getSide(), getAdapterFactory());
				case RIGHT:
					return new MergeViewerItem.Container(getComparison(), referenceChange, null, eObject,
							null, getSide(), getAdapterFactory());
				case ANCESTOR:
					return new MergeViewerItem.Container(getComparison(), referenceChange, null, null,
							eObject, getSide(), getAdapterFactory());
				default:
					throw new IllegalStateException();
			}
		}
	}

	/**
	 * Returns a list of those of the given diffs that are displayed in a group as provided by the given group
	 * provider and satisfy the given predicate.
	 * 
	 * @param unfilteredDiffs
	 *            the unfiltered diffs
	 * @param predicate
	 *            a filter predicate; a {@code null} predicate will be satisfied by any diff
	 * @param groupProvider
	 *            the active group provider
	 * @return a list of the filtered diffs
	 */
	@Deprecated
	protected List<? extends Diff> filteredDiffs(Iterable<? extends Diff> unfilteredDiffs,
			Predicate<? super EObject> predicate, IDifferenceGroupProvider groupProvider) {
		return Lists.newArrayList(filter(unfilteredDiffs, visibleInMergeViewer(predicate, groupProvider)));
	}

	@Deprecated
	protected Predicate<Diff> visibleInMergeViewer(final Predicate<? super EObject> predicate,
			final IDifferenceGroupProvider groupProvider) {
		if (predicate == null) {
			return Predicates.alwaysTrue();
		}

		return new Predicate<Diff>() {
			public boolean apply(Diff diff) {
				return MergeViewerUtil.isVisibleInMergeViewer(diff, groupProvider, predicate);
			}
		};
	}

	@Deprecated
	public static class Container extends MergeViewerItem implements IMergeViewerItem.Container {

		/**
		 * 
		 */
		private static final IMergeViewerItem[] NO_ITEMS_ARR = new IMergeViewerItem[0];

		/**
		 * @param comparison
		 * @param diff
		 * @param left
		 * @param right
		 * @param ancestor
		 */
		public Container(Comparison comparison, Diff diff, Object left, Object right, Object ancestor,
				MergeViewerSide side, AdapterFactory adapterFactory) {
			super(comparison, diff, left, right, ancestor, side, adapterFactory);
		}

		/**
		 * @param fComparison
		 * @param referenceChange
		 * @param parentMatch
		 * @param fSide
		 * @param fAdapterFactory
		 */
		public Container(Comparison comparison, Diff diff, Match match, MergeViewerSide side,
				AdapterFactory adapterFactory) {
			super(comparison, diff, match, side, adapterFactory);
		}

		/**
		 * @return the noItemsArr
		 */
		public static IMergeViewerItem[] getNoItemsArr() {
			return NO_ITEMS_ARR;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.MergeViewerItem.item.impl.AbstractMergeViewerItem#getParent()
		 */
		@Override
		public IMergeViewerItem.Container getParent() {
			IMergeViewerItem.Container ret = null;

			if (getDiff() instanceof ResourceAttachmentChange) {
				ret = createBasicContainer((ResourceAttachmentChange)getDiff());
			} else {
				Object sideValue = getBestSideValue();
				ITreeItemContentProvider treeItemContentProvider = (ITreeItemContentProvider)getAdapterFactory()
						.adapt(sideValue, ITreeItemContentProvider.class);

				Object parent = treeItemContentProvider != null ? treeItemContentProvider.getParent(sideValue)
						: null;
				if (parent instanceof EObject) {
					ret = createBasicContainer((EObject)parent);
				} else if (parent instanceof Resource) {
					ret = getParent((Resource)parent);
				} else if (sideValue instanceof NotLoadedFragmentMatch) {
					ret = getParent((NotLoadedFragmentMatch)sideValue);
				}
			}
			return ret;
		}

		/**
		 * Get the parent (as MergeViewerItem) of the MergeViewerItem in case the MergeViewerItem is a
		 * {@link org.eclipse.emf.ecore.resource.Resource}.
		 * 
		 * @param resource
		 *            the Resource for which we want the parent (as MergeViewerItem)
		 * @return the parent (a MergeViewerItem) of the given element.
		 */
		private IMergeViewerItem.Container getParent(Resource resource) {
			final IMergeViewerItem.Container parent;
			URI uri = resource.getURI();
			if (ResourceUIUtil.isFragment(uri)) {
				final Object object = getBestSideValue();
				final Match matchOfValue = getComparison().getMatch((EObject)object);
				final NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(
						matchOfValue);
				parent = new MergeViewerItem.Container(getComparison(), getDiff(), notLoadedFragmentMatch,
						notLoadedFragmentMatch, notLoadedFragmentMatch, getSide(), getAdapterFactory());
			} else {
				parent = null;
			}
			return parent;

		}

		/**
		 * Get the parent of the MergeViewerItem in case the MergeViewerItem is a
		 * {@link org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch}.
		 * 
		 * @param nlfm
		 *            the NotLoadedFragmentMatch for which we want the parent (as MergeViewerItem)
		 * @return the parent (a MergeViewerItem) of the given element.
		 */
		private IMergeViewerItem.Container getParent(NotLoadedFragmentMatch nlfm) {
			IMergeViewerItem.Container parent = null;
			final Collection<? extends Match> children = nlfm.getChildren();
			for (Match match : children) {
				URI uri = ResourceUIUtil.getDataURI(match, getSide());
				if (uri != null) {
					IGraphView<URI> graph = ResourceUIUtil.getResourcesURIGraph();
					URI parentData = graph.getParentData(uri);
					ResourceSet rs = ResourceUIUtil.getDataResourceSet(match, getSide());
					Resource resourceParent = ResourceUIUtil.getParent(rs, uri);
					while (resourceParent == null && parentData != null) {
						resourceParent = ResourceUIUtil.getParent(rs, parentData.trimFragment());
						parentData = graph.getParentData(parentData.trimFragment());
					}
					if (resourceParent != null && parentData != null) {
						EObject eObjectParent = resourceParent.getEObject(parentData.fragment());
						if (eObjectParent != null) {
							parent = createBasicContainer(eObjectParent);
							break;
						}
					} else {
						parent = createNotLoadedFragmentContainer(rs, uri);
						if (parent != null) {
							break;
						}
					}
				}
			}
			return parent;
		}

		/**
		 * Create an IMergeViewerItem.Container that holds NotLoadedFragmentMatches.
		 * 
		 * @param uri
		 *            the URI of the Match element for which we want to create a container.
		 * @return an IMergeViewerItem.Container.
		 */
		private IMergeViewerItem.Container createNotLoadedFragmentContainer(ResourceSet rs, URI uri) {
			final IMergeViewerItem.Container parent;
			URI parentURI = ResourceUIUtil.getParentResourceURI(rs, uri);
			URI rootResourceURI = ResourceUIUtil.getRootResourceURI(uri);
			if (parentURI == null) {
				parentURI = rootResourceURI;
			}
			Collection<Match> notLoadedFragmentMatches = Lists.newArrayList();
			Collection<Match> rootMatches = getComparison().getMatches();
			Collection<URI> uris = ResourceUIUtil.getDataURIs(rootMatches, getSide());
			for (Match rootMatch : rootMatches) {
				URI rootMatchDataURI = ResourceUIUtil.getDataURI(rootMatch, getSide());
				if (!rootResourceURI.equals(rootMatchDataURI) && !parentURI.equals(rootMatchDataURI)
						&& ResourceUIUtil.isChildOf(rootMatchDataURI, ImmutableSet.of(parentURI))
						&& !ResourceUIUtil.isChildOf(rootMatchDataURI, uris)) {
					notLoadedFragmentMatches.add(new NotLoadedFragmentMatch(rootMatch));
				}
			}
			if (notLoadedFragmentMatches.size() > 1) {
				final NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(
						notLoadedFragmentMatches);
				parent = new MergeViewerItem.Container(getComparison(), getDiff(), notLoadedFragmentMatch,
						notLoadedFragmentMatch, notLoadedFragmentMatch, getSide(), getAdapterFactory());
			} else {
				parent = null;
			}
			return parent;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem.Container#hasChildren(IDifferenceGroupProvider,
		 *      Predicate)
		 */
		public boolean hasChildren(IDifferenceGroupProvider groupProvider,
				Predicate<? super EObject> predicate) {
			if (getLeft() instanceof NotLoadedFragmentMatch) {
				NotLoadedFragmentMatch notLoadedFragmentMatch = (NotLoadedFragmentMatch)getLeft();
				return !notLoadedFragmentMatch.getChildren().isEmpty();
			}

			Object sideValue = getSideValue(getSide());
			EObject bestSideValue = (EObject)getBestSideValue();
			Match match = getComparison().getMatch(bestSideValue);

			Iterable<Diff> differences = match == null ? Collections.<Diff> emptyList()
					: ImmutableList.copyOf(filter(match.getDifferences(), CONTAINMENT_REFERENCE_CHANGE));

			Collection<? extends EStructuralFeature> childrenFeatures = getChildrenFeatures(bestSideValue);
			for (EStructuralFeature eStructuralFeature : childrenFeatures) {
				if (eStructuralFeature instanceof EReference) {
					if (hasChildrenOfReference(groupProvider, predicate, sideValue, differences,
							(EReference)eStructuralFeature)) {
						return true;
					}
				} else if (FeatureMapUtil.isFeatureMap(eStructuralFeature)) {
					if (hasChildrenOfFeatureMap(groupProvider, predicate, sideValue, differences,
							eStructuralFeature)) {
						return true;
					}
				}
			}

			return hasNotLoadedFragmentsItems(match);
		}

		private boolean hasChildrenOfReference(IDifferenceGroupProvider groupProvider,
				Predicate<? super EObject> predicate, Object container, Iterable<Diff> differences,
				EReference reference) {
			List<Object> featureContent = ReferenceUtil.getAsList((EObject)container, reference);
			if (yieldsMergeViewerItem(featureContent)) {
				return true;
			}

			if (getSide() != MergeViewerSide.ANCESTOR) {
				Iterable<Diff> differencesOnFeature = filter(differences, onFeature(reference.getName()));
				Iterable<Diff> filteredDiffs = filter(differencesOnFeature,
						visibleInMergeViewer(predicate, groupProvider));
				return yieldsInsertionPoint(filteredDiffs);
			}

			return true;
		}

		private boolean hasChildrenOfFeatureMap(IDifferenceGroupProvider groupProvider,
				Predicate<? super EObject> predicate, Object container, Iterable<Diff> differences,
				EStructuralFeature featureMap) {
			List<Object> mapContent = ReferenceUtil.getAsList((EObject)container, featureMap);
			List<Object> featureContent = Lists.newArrayList();
			Set<EStructuralFeature> derivedFeatures = Sets.newLinkedHashSet();
			for (Object object : mapContent) {
				if (object instanceof FeatureMap.Entry) {
					featureContent.add(((FeatureMap.Entry)object).getValue());
					derivedFeatures.add(((FeatureMap.Entry)object).getEStructuralFeature());
				}
			}

			if (yieldsMergeViewerItem(featureContent)) {
				return true;
			}

			if (getSide() != MergeViewerSide.ANCESTOR) {
				Iterable<Diff> differencesOnFeature = filter(differences, onFeatures(derivedFeatures));
				Iterable<Diff> filteredDiffs = filter(differencesOnFeature,
						visibleInMergeViewer(predicate, groupProvider));
				return yieldsInsertionPoint(filteredDiffs);
			}

			return false;
		}

		private boolean hasNotLoadedFragmentsItems(Match match) {
			Collection<Match> childrenMatches = ResourceUIUtil
					.getChildrenMatchWithNotLoadedParent(getComparison(), match, getSide());
			return !childrenMatches.isEmpty();
		}

		@Override
		public IMergeViewerItem.Container cloneAsOpposite() {
			return new MergeViewerItem.Container(getComparison(), getDiff(), getLeft(), getRight(),
					getAncestor(), getSide(), getAdapterFactory());
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem.Container#getChildren(IDifferenceGroupProvider,
		 *      Predicate)
		 */
		public IMergeViewerItem[] getChildren(IDifferenceGroupProvider group,
				Predicate<? super EObject> predicate) {

			List<IMergeViewerItem> ret = newArrayList();

			if (this.getLeft() instanceof NotLoadedFragmentMatch) {
				ret.addAll(getChildren((NotLoadedFragmentMatch)this.getLeft()));
			} else {
				Object sideValue = getSideValue(getSide());
				EObject bestSideValue = (EObject)getBestSideValue();

				final Collection<? extends EStructuralFeature> childrenFeatures = getChildrenFeatures(
						bestSideValue);

				Match match = getComparison().getMatch(bestSideValue);
				final ImmutableList<Diff> differences;
				if (match != null) {
					differences = ImmutableList
							.copyOf(filter(match.getDifferences(), CONTAINMENT_REFERENCE_CHANGE));
				} else {
					differences = ImmutableList.of();
				}

				for (EStructuralFeature eStructuralFeature : childrenFeatures) {
					if (eStructuralFeature instanceof EReference) {
						ret.addAll(getChildrenOfReference(group, predicate, sideValue, differences,
								(EReference)eStructuralFeature));
					} else if (FeatureMapUtil.isFeatureMap(eStructuralFeature)) {
						ret.addAll(getChildrenOfFeatureMap(group, predicate, sideValue, differences,
								eStructuralFeature));
					}
				}

				// Add not loaded fragment match if needed
				ret.addAll(getNotLoadedFragmentsItems(match));
			}
			return ret.toArray(NO_ITEMS_ARR);
		}

		/**
		 * Get the children of the MergeViewerItem in case the MergeViewerItem is a
		 * {@link org.eclipse.emf.compare.match.impl.NotLoadedFragmentMatch}.
		 * 
		 * @param nlfm
		 *            the NotLoadedFragmentMatch for which we want the children (as MergeViewerItems)
		 * @return the children (a list of MergeViewerItems) of the given element.
		 */
		private List<IMergeViewerItem> getChildren(NotLoadedFragmentMatch nlfm) {
			final List<IMergeViewerItem> ret = newArrayList();
			final Collection<Match> matches = nlfm.getChildren();
			for (Match match : matches) {
				final MergeViewerItem.Container container;
				if (match instanceof NotLoadedFragmentMatch) {
					container = new MergeViewerItem.Container(getComparison(), getDiff(), match, match, match,
							getSide(), getAdapterFactory());
				} else {
					container = new MergeViewerItem.Container(getComparison(), getDiff(), match.getLeft(),
							match.getRight(), match.getOrigin(), getSide(), getAdapterFactory());
				}
				ret.add(container);
			}
			return ret;
		}

		/**
		 * Return potential NotLoadedFragment children items (as MergeViewerItem) of the MergeViewerItem in
		 * case the MergeViewerItem is a {@link org.eclipse.emf.compare.match.Match}.
		 * 
		 * @param match
		 *            the Match for which we want the potential NotLoadedFragment children items (as
		 *            MergeViewerItems)
		 * @return the NotLoadedFragment children items (a list of MergeViewerItems) of the given element.
		 */
		private List<IMergeViewerItem> getNotLoadedFragmentsItems(Match match) {
			final List<IMergeViewerItem> ret = newArrayList();
			final Collection<Match> childrenMatches = ResourceUIUtil
					.getChildrenMatchWithNotLoadedParent(getComparison(), match, getSide());
			if (childrenMatches.size() > 0) {
				boolean setNames = childrenMatches.size() > 1;
				for (Match child : childrenMatches) {
					NotLoadedFragmentMatch notLoadedFragmentMatch = new NotLoadedFragmentMatch(child);
					if (setNames) {
						notLoadedFragmentMatch
								.setName(ResourceUIUtil.getResourceName(notLoadedFragmentMatch));
					}
					MergeViewerItem.Container notLoadedFragmentItem = new MergeViewerItem.Container(
							getComparison(), null, notLoadedFragmentMatch, notLoadedFragmentMatch,
							notLoadedFragmentMatch, getSide(), getAdapterFactory());
					ret.add(notLoadedFragmentItem);
				}
			}
			return ret;
		}

		/**
		 * Returns the children of the container that apply on the given reference.
		 * 
		 * @param group
		 *            The active group provider.
		 * @param predicate
		 *            The active predicate.
		 * @param container
		 *            The container object.
		 * @param differences
		 *            The differences that apply on the container.
		 * @param reference
		 *            The reference for which we want the children.
		 */
		private List<IMergeViewerItem> getChildrenOfReference(final IDifferenceGroupProvider group,
				final Predicate<? super EObject> predicate, final Object container,
				final ImmutableList<Diff> differences, final EReference reference) {
			List<IMergeViewerItem> ret = Lists.newArrayList();
			List<Object> featureContent = ReferenceUtil.getAsList((EObject)container, reference);
			List<IMergeViewerItem> mergeViewerItem = createMergeViewerItemFrom(featureContent);
			if (getSide() != MergeViewerSide.ANCESTOR) {
				Iterable<? extends Diff> differencesOnFeature = filter(differences,
						onFeature(reference.getName()));
				List<? extends Diff> filteredDiffs = filteredDiffs(differencesOnFeature, predicate, group);
				ret.addAll(createInsertionPoints(getComparison(), reference, mergeViewerItem, filteredDiffs));
			} else {
				ret.addAll(mergeViewerItem);
			}
			return ret;
		}

		/**
		 * Returns the children of the container that apply on the given reference.
		 * 
		 * @param group
		 *            The active group provider.
		 * @param predicate
		 *            The active predicate.
		 * @param container
		 *            The container object.
		 * @param differences
		 *            The differences that apply on the container.
		 * @param reference
		 *            The feature map for which we want the children.
		 */
		private List<IMergeViewerItem> getChildrenOfFeatureMap(final IDifferenceGroupProvider group,
				final Predicate<? super EObject> predicate, final Object container,
				final ImmutableList<Diff> differences, final EStructuralFeature featureMap) {
			List<IMergeViewerItem> ret = Lists.newArrayList();
			List<Object> mapContent = ReferenceUtil.getAsList((EObject)container, featureMap);
			List<Object> featureContent = Lists.newArrayList();
			Set<EStructuralFeature> derivedFeatures = Sets.newLinkedHashSet();
			for (Object object : mapContent) {
				if (object instanceof FeatureMap.Entry) {
					featureContent.add(((FeatureMap.Entry)object).getValue());
					derivedFeatures.add(((FeatureMap.Entry)object).getEStructuralFeature());
				}
			}
			List<IMergeViewerItem> mergeViewerItem = createMergeViewerItemFrom(featureContent);
			if (getSide() != MergeViewerSide.ANCESTOR) {
				Iterable<Diff> differencesOnFeature = filter(differences, onFeatures(derivedFeatures));
				List<? extends Diff> filteredDiffs = filteredDiffs(differencesOnFeature, predicate, group);
				ret.addAll(
						createInsertionPoints(getComparison(), featureMap, mergeViewerItem, filteredDiffs));
			} else {
				ret.addAll(mergeViewerItem);
			}
			return ret;
		}

		private Predicate<Diff> onFeatures(Iterable<EStructuralFeature> features) {
			return Predicates.or(Iterables.transform(features,
					new Function<EStructuralFeature, Predicate<? super Diff>>() {
						public Predicate<? super Diff> apply(EStructuralFeature feature) {
							return onFeature(feature.getName());
						}
					}));
		}

		/**
		 * Returns the list of children features to display within the UI.
		 * 
		 * @param object
		 * @return
		 */
		protected Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
			Collection<? extends EStructuralFeature> ret = Lists.newArrayList();
			Collection<? extends EStructuralFeature> childrenFeaturesFromItemProviderAdapter = getChildrenFeaturesFromItemProviderAdapter(
					object);
			if (childrenFeaturesFromItemProviderAdapter == null) {
				ret = getChildrenFeaturesFromEClass(object);
			} else {
				ret = childrenFeaturesFromItemProviderAdapter;
			}

			return ret;
		}

		protected Collection<EStructuralFeature> getChildrenFeaturesFromEClass(Object object) {
			ImmutableSet.Builder<EStructuralFeature> features = ImmutableSet.builder();
			if (object instanceof EObject) {
				for (EReference feature : ((EObject)object).eClass().getEAllContainments()) {
					features.add(feature);
				}
			}
			return features.build();
		}

		@SuppressWarnings("unchecked")
		protected Collection<? extends EStructuralFeature> getChildrenFeaturesFromItemProviderAdapter(
				Object object) {
			Collection<? extends EStructuralFeature> ret = null;

			Object treeItemContentProvider = getAdapterFactory().adapt(object,
					ITreeItemContentProvider.class);

			if (treeItemContentProvider instanceof ItemProviderAdapter) {
				ItemProviderAdapter itemProviderAdapter = (ItemProviderAdapter)treeItemContentProvider;
				Method method;
				try {
					method = itemProviderAdapter.getClass().getMethod("getChildrenFeatures", Object.class); //$NON-NLS-1$
					method.setAccessible(true);
					ret = (Collection<? extends EStructuralFeature>)method.invoke(itemProviderAdapter,
							object);
				} catch (SecurityException | NoSuchMethodException | IllegalArgumentException
						| IllegalAccessException | InvocationTargetException e) {
					// ignore
				}
			}

			return ret;
		}
	}
}
