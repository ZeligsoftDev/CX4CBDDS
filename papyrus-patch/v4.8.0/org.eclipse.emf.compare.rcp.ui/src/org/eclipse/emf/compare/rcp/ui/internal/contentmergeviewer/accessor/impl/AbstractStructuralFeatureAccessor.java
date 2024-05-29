/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - compute differences lazily
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import static com.google.common.collect.Iterables.filter;
import static org.eclipse.emf.compare.utils.EMFComparePredicates.onFeature;

import com.google.common.collect.ImmutableList;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * An abstract implementation of {@link IStructuralFeatureAccessor}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractStructuralFeatureAccessor extends AbstractTypedElementAdapter implements IStructuralFeatureAccessor {

	/** The diff associated with this accessor. */
	private final Diff fDiff;

	/** The side of the accessor. */
	private final MergeViewerSide fSide;

	/** The match that owns the diff associated with this accessor. */
	private final Match fOwnerMatch;

	/** The structural feature associated with his accessor. */
	private final EStructuralFeature fStructuralFeature;

	/** The list of diff that apply on the structural feature. */
	private ImmutableList<Diff> fDifferences;

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
	public AbstractStructuralFeatureAccessor(AdapterFactory adapterFactory, Diff diff, MergeViewerSide side) {
		super(adapterFactory);
		fDiff = diff;
		fSide = side;
		fOwnerMatch = diff.getMatch();
		fStructuralFeature = getAffectedFeature(diff);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor#getComparison()
	 */
	public Comparison getComparison() {
		return fOwnerMatch.getComparison();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor#getInitialItem()
	 */
	public IMergeViewerItem getInitialItem() {
		IMergeViewerItem ret = null;
		ImmutableList<? extends IMergeViewerItem> items = getItems();
		for (IMergeViewerItem item : items) {
			Diff diff = item.getDiff();
			if (diff == fDiff) {
				ret = item;
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor#getInitialItem()
	 */
	public EObject getEObject(MergeViewerSide side) {
		return MergeViewerUtil.getEObject(fOwnerMatch, side);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IStructuralFeatureAccessor#getStructuralFeature()
	 */
	public EStructuralFeature getStructuralFeature() {
		return fStructuralFeature;
	}

	/**
	 * Returns the side of the accessor.
	 * 
	 * @return the side of the accessor.
	 */
	protected final MergeViewerSide getSide() {
		return fSide;
	}

	/**
	 * Returns the list of diff that apply on the structural feature.
	 * 
	 * @return the list of diff that apply on the structural feature.
	 */
	protected final ImmutableList<Diff> getDifferences() {
		if (fDifferences == null) {
			fDifferences = computeDifferences();
		}
		return fDifferences;
	}

	/**
	 * Compute the differences that apply on the structural feature.
	 * 
	 * @return the list of diff that apply on the structural feature.
	 */
	protected ImmutableList<Diff> computeDifferences() {
		List<Diff> siblingDifferences = fOwnerMatch.getDifferences();
		// We'll display all diffs on the same reference, excluding the pseudo conflicts.
		return ImmutableList.copyOf(filter(siblingDifferences, onFeature(fStructuralFeature.getName())));
	}

	/**
	 * Returns the structural feature affected by the given diff, if any.
	 * 
	 * @param diff
	 *            The diff from which we need to retrieve a feature.
	 * @return The feature affected by this {@code diff}, if any. <code>null</code> if none.
	 */
	protected EStructuralFeature getAffectedFeature(Diff diff) {
		return MergeViewerUtil.getAffectedFeature(diff);
	}

	/**
	 * Returns the initial diff associated with this accessor.
	 * 
	 * @return the initial diff.
	 */
	protected final Diff getInitialDiff() {
		return fDiff;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getName()
	 */
	public String getName() {
		return this.getClass().getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getImage()
	 */
	public Image getImage() {
		return ExtendedImageRegistry.INSTANCE.getImage(getItemDelegator().getImage(fStructuralFeature));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		return TypeConstants.TYPE_ELIST_DIFF;
	}
}
