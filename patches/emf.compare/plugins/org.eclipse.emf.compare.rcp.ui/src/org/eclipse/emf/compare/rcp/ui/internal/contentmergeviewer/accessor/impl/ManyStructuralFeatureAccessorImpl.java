/*******************************************************************************
 * Copyright (c) 2012, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - add caching
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newArrayListWithCapacity;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.internal.utils.DiffUtil;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareConstants;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;

/**
 * A specific {@link AbstractStructuralFeatureAccessor} for multi-valued structural feature objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class ManyStructuralFeatureAccessorImpl extends AbstractStructuralFeatureAccessor {

	/**
	 * A cache used by {@link #getDiffWithValue(Object)}.
	 */
	Map<Object, Diff> valueDiffs;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapater factory used to create the accessor.
	 * @param diff
	 *            the diff associated with this accessor.
	 * @param side
	 *            the side of the accessor.
	 */
	public ManyStructuralFeatureAccessorImpl(AdapterFactory adapterFactory, Diff diff, MergeViewerSide side) {
		super(adapterFactory, diff, side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getItems()
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		List<? extends IMergeViewerItem> ret;
		List<?> list = getFeatureValues(getSide());
		ret = createMergeViewerItemFrom(list);

		if (getSide() != MergeViewerSide.ANCESTOR
				&& list.size() < EMFCompareConstants.LIST_SIZE_INSERTION_POINT_THRESHOLD) {
			ret = createInsertionPoints(ret);
		}

		return ImmutableList.copyOf(ret);
	}

	/**
	 * Create IMergeViewerItems for the given values.
	 * 
	 * @param values
	 *            the given values.
	 * @return the list of newly created IMergeViewerItems.
	 */
	private List<? extends IMergeViewerItem> createMergeViewerItemFrom(List<?> values) {
		List<IMergeViewerItem> ret = newArrayListWithCapacity(values.size());
		for (Object value : values) {
			IMergeViewerItem valueToAdd = createMergeViewerItemFrom(value);
			ret.add(valueToAdd);
		}
		return ret;
	}

	/**
	 * Create a IMergeViewerItem for the given object.
	 * 
	 * @param object
	 *            the given object.
	 * @return an IMergeViewerItem.
	 */
	private IMergeViewerItem createMergeViewerItemFrom(Object object) {
		Diff diff = getDiffWithValue(object);
		Object left = matchingValue(object, MergeViewerSide.LEFT);
		Object right = matchingValue(object, MergeViewerSide.RIGHT);
		Object ancestor = matchingValue(object, MergeViewerSide.ANCESTOR);
		final boolean leftEmptyBox = !getFeatureValues(MergeViewerSide.LEFT).contains(left);
		final boolean rightEmptyBox = !getFeatureValues(MergeViewerSide.RIGHT).contains(right);
		if (leftEmptyBox || rightEmptyBox) {
			if (leftEmptyBox) {
				left = null;
			}
			if (rightEmptyBox) {
				right = null;
			}
		}
		return new MergeViewerItem(getComparison(), diff, left, right, ancestor, getSide(),
				getRootAdapterFactory());
	}

	/**
	 * Create insertion points for the given values.
	 * 
	 * @param values
	 *            the given values.
	 * @return a list of newly created insertion points that implement {@link IMergeViewerItem}.
	 */
	private List<? extends IMergeViewerItem> createInsertionPoints(
			final List<? extends IMergeViewerItem> values) {
		List<IMergeViewerItem> ret = newArrayList(values);
		for (Diff diff : getDifferences().reverse()) {
			boolean isLeft = getSide() == MergeViewerSide.LEFT;
			Object left = getValueFromDiff(diff, MergeViewerSide.LEFT);
			Object right = getValueFromDiff(diff, MergeViewerSide.RIGHT);

			final boolean leftEmptyBox = isLeft
					&& (left == null || !getFeatureValues(getSide()).contains(left));
			final boolean rightEmptyBox = !isLeft
					&& (right == null || !getFeatureValues(getSide()).contains(right));
			if (leftEmptyBox || rightEmptyBox) {
				// Bug 458818: Don't display a delete+moved element twice
				// If the diff is part of a conflict,
				// we don't want to display both the MOVE and the DELETE on the same side
				if (diff.getKind() == DifferenceKind.MOVE && isPartOfConflictWithDelete(diff)) {
					continue;
				}
				Object ancestor = getValueFromDiff(diff, MergeViewerSide.ANCESTOR);
				if (leftEmptyBox) {
					left = null;
				}
				if (rightEmptyBox) {
					right = null;
				}
				IMergeViewerItem insertionPoint = new MergeViewerItem(getComparison(), diff, left, right,
						ancestor, getSide(), getRootAdapterFactory());

				final int insertionIndex = Math.min(findInsertionIndex(diff, isLeft), ret.size());
				List<IMergeViewerItem> subList = ret.subList(0, insertionIndex);
				final int nbInsertionPointBefore = size(filter(subList, IMergeViewerItem.IS_INSERTION_POINT));

				int index = Math.min(insertionIndex + nbInsertionPointBefore, ret.size());
				ret.add(index, insertionPoint);
			}
		}
		return ret;
	}

	private boolean isPartOfConflictWithDelete(final Diff diff) {
		if (diff.getConflict() == null) {
			return false;
		}
		return Iterables.any(diff.getConflict().getDifferences(), new Predicate<Diff>() {
			public boolean apply(Diff aDiff) {
				return diff != aDiff && aDiff.getKind() == DifferenceKind.DELETE;
			}
		});
	}

	/**
	 * Find the insertion index for the given diff.
	 * 
	 * @param diff
	 *            the given diff.
	 * @param rightToLeft
	 *            the way of merge.
	 * @return the insertion index.
	 */
	protected int findInsertionIndex(Diff diff, boolean rightToLeft) {
		return DiffUtil.findInsertionIndex(getComparison(), diff, rightToLeft);
	}

	/**
	 * Get the Diff corresponding to the given object.
	 * 
	 * @param value
	 *            the given object.
	 * @return the Diff corresponding to the given object.
	 */
	private Diff getDiffWithValue(Object value) {
		if (valueDiffs == null) {
			valueDiffs = Maps.newIdentityHashMap();
			for (Diff diff : getDifferences()) {
				Object valueOfDiff = getValueFromDiff(diff, getSide());
				valueDiffs.put(valueOfDiff, diff);
			}
		}

		return valueDiffs.get(value);
	}

	/**
	 * Get the value of the given side associated to the given Diff.
	 * 
	 * @param diff
	 *            the given Diff.
	 * @param side
	 *            the side of the Diff.
	 * @return the value associated to the given Diff.
	 */
	protected Object getValueFromDiff(final Diff diff, MergeViewerSide side) {
		Object diffValue = getDiffValue(diff);
		Object ret = matchingValue(diffValue, side);
		return ret;
	}

	/**
	 * Get the value of the given side of the Match corresponding to the given object.
	 * 
	 * @param object
	 *            the given object.
	 * @param side
	 *            the given side.
	 * @return the value of the given side of the Match corresponding to the given object.
	 */
	private Object matchingValue(Object object, MergeViewerSide side) {
		final Object ret;
		if (object instanceof EObject) {
			final Match matchOfValue = getComparison().getMatch((EObject)object);
			if (matchOfValue != null) {
				switch (side) {
					case ANCESTOR:
						ret = matchOfValue.getOrigin();
						break;
					case LEFT:
						ret = matchOfValue.getLeft();
						break;
					case RIGHT:
						ret = matchOfValue.getRight();
						break;
					default:
						throw new IllegalStateException();
				}
			} else {
				ret = matchingValue(object, getFeatureValues(side));
			}
		} else {
			ret = matchingValue(object, getFeatureValues(side));
		}
		return ret;
	}

	/**
	 * Get the value in the given list that match to the given value.
	 * 
	 * @param value
	 *            the given value.
	 * @param in
	 *            the list of values.
	 * @return the value in the given list that match to the given value.
	 */
	private Object matchingValue(Object value, List<?> in) {
		Object ret = null;
		IEqualityHelper equalityHelper = getComparison().getEqualityHelper();
		Iterator<?> valuesIterator = in.iterator();
		while (valuesIterator.hasNext() && ret == null) {
			Object object = valuesIterator.next();
			if (equalityHelper.matchingValues(object, value)) {
				ret = object;
			}
		}
		return ret;
	}

	/**
	 * Returns the values of the current feature on the given side.
	 * 
	 * @param side
	 *            the given side.
	 * @return the values of the current feature on the given side.
	 */
	protected List<?> getFeatureValues(MergeViewerSide side) {
		final EObject eObject = getEObject(side);
		return ReferenceUtil.getAsListResolving(eObject, getStructuralFeature());
	}

	/**
	 * Returns either {@link ReferenceChange#getValue()}, {@link AttributeChange#getValue()} or a
	 * {@link FeatureMapChange#getValue()} depending on the runtime type of the give, {@code diff} or null
	 * otherwise.
	 * 
	 * @param diff
	 *            the given Diff.
	 * @return the value of the given Diff.
	 */
	protected Object getDiffValue(Diff diff) {
		final Object ret;
		if (diff instanceof ReferenceChange) {
			ret = ((ReferenceChange)diff).getValue();
		} else if (diff instanceof AttributeChange) {
			ret = ((AttributeChange)diff).getValue();
		} else if (diff instanceof FeatureMapChange) {
			ret = ((FeatureMapChange)diff).getValue();
		} else if (diff.getPrimeRefining() instanceof ReferenceChange) {
			ret = ((ReferenceChange)diff.getPrimeRefining()).getValue();
		} else {
			ret = null;
		}
		return ret;
	}
}
