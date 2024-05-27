/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import static org.eclipse.emf.compare.merge.AbstractMerger.isInTerminalState;

import com.google.common.collect.ImmutableList;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.internal.merge.IMergeData;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.internal.utils.ComparisonUtil;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A specific {@link AbstractStructuralFeatureAccessor} for FeatureMapChanges of kind DifferenceKind.CHANGE
 * (represent a value that changed his key).
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class FeatureMapKeyChangeAccessorImpl extends AbstractStructuralFeatureAccessor {

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
	public FeatureMapKeyChangeAccessorImpl(AdapterFactory adapterFactory, FeatureMapChange diff,
			MergeViewerSide side) {
		super(adapterFactory, diff, side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor#getItems()
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		final EStructuralFeature leftKey = getKey(MergeViewerSide.LEFT);
		final EStructuralFeature rightKey = getKey(MergeViewerSide.RIGHT);
		final EStructuralFeature ancestorKey = getKey(MergeViewerSide.ANCESTOR);
		final MergeViewerItem item = new MergeViewerItem(getComparison(), getInitialDiff(), leftKey, rightKey,
				ancestorKey, getSide(), getRootAdapterFactory());

		return ImmutableList.of(item);
	}

	/**
	 * Returns the {@link FeatureMapChange} diff associated with this accessor.
	 * 
	 * @return the {@link FeatureMapChange} diff associated with this accessor.
	 */
	public FeatureMapChange getFeatureMapChange() {
		return (FeatureMapChange)getInitialDiff();
	}

	/**
	 * Returns the key of the FeatureMap.Entry for the given side.
	 * 
	 * @param side
	 *            the given side.
	 * @return the key of the FeatureMap.Entry for the given side, or null if not found.
	 */
	private EStructuralFeature getKey(MergeViewerSide side) {
		EStructuralFeature key = null;
		final FeatureMapChange diff = (FeatureMapChange)getInitialDiff();
		final FeatureMap.Entry entry = (FeatureMap.Entry)diff.getValue();
		if ((side != MergeViewerSide.ANCESTOR && side.convertToDifferenceSource().equals(diff.getSource()))
				&& !isInTerminalState(diff)) {
			key = entry.getEStructuralFeature();
		} else if (isInTerminalState(diff) && !isMergedTargetIsSource(diff)) {
			key = entry.getEStructuralFeature();
		} else {
			// The entry of the diff source side.
			final Object value = entry.getValue();
			// The feature map object of the opposite side of the diff source.
			final EObject eObject = getEObject(side);
			// The entries of the opposite side of the diff source.
			final List<Object> list = ReferenceUtil.getAsList(eObject, getStructuralFeature());

			final IEqualityHelper equalityHelper = getComparison().getEqualityHelper();

			for (Object object : list) {
				// We've found the same value on the opposite side, return the key associated
				if (object instanceof FeatureMap.Entry
						&& equalityHelper.matchingValues(value, ((FeatureMap.Entry)object).getValue())) {
					key = ((FeatureMap.Entry)object).getEStructuralFeature();
					break;
				}
			}
		}
		return key;
	}

	/**
	 * Returns true if the given diff is merged and the target side of the merge is the same as the diff
	 * source.
	 * 
	 * @param diff
	 *            the given {@link FeatureMapChange}.
	 * @return true if the given diff is merged and the target side of the merge is the same as the diff
	 *         source, false otherwise.
	 */
	private boolean isMergedTargetIsSource(FeatureMapChange diff) {
		IMergeData mergeData = (IMergeData)EcoreUtil.getExistingAdapter(ComparisonUtil.getComparison(diff),
				IMergeData.class);
		if (mergeData != null) {
			MergeMode mode = MergeMode.getMergeMode(diff, mergeData.isLeftEditable(),
					mergeData.isRightEditable());
			return diff.getSource() == mode.getMergeTarget(mergeData.isLeftEditable(),
					mergeData.isRightEditable());
		}
		return false;
	}
}
