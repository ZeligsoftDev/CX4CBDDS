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

import com.google.common.collect.ImmutableList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EObject;

/**
 * A specific {@link AbstractStructuralFeatureAccessor} for mono-valued structural feature objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class SingleStructuralFeatureAccessorImpl extends AbstractStructuralFeatureAccessor {

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
	public SingleStructuralFeatureAccessorImpl(AdapterFactory adapterFactory, Diff diff,
			MergeViewerSide side) {
		super(adapterFactory, diff, side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.ICompareAccessor.#getItems()
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		Object thisSideValue = getValue(getSide());
		if (thisSideValue == null && getSide() == MergeViewerSide.ANCESTOR) {
			// No use retrieving all sides ...
			return ImmutableList.of();
		}

		Object leftValue = getValue(MergeViewerSide.LEFT);
		Object rightValue = getValue(MergeViewerSide.RIGHT);
		Object ancestorValue = getValue(MergeViewerSide.ANCESTOR);

		// there can be only one diff on !many structural feature.
		Diff diff = getInitialDiff();
		IMergeViewerItem insertionPoint = new MergeViewerItem(getComparison(), diff, leftValue, rightValue,
				ancestorValue, getSide(), getRootAdapterFactory());
		return ImmutableList.of(insertionPoint);
	}

	/**
	 * Get the value associated to the given side.
	 * 
	 * @param side
	 *            the given side.
	 * @return the value associated to the given side.
	 */
	private Object getValue(MergeViewerSide side) {
		Object value = null;
		EObject eObject = getEObject(side);
		if (eObject != null) {
			value = ReferenceUtil.safeResolvingEGet(eObject, getStructuralFeature());
		}
		return value;
	}
}
