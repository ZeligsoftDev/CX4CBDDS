/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ResourceAttachmentChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IResourceContentsAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.ResourceAttachmentChangeMergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.internal.util.MergeViewerUtil;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * A specific {@link IResourceContentsAccessor} for {@link ResourceAttachmentChange} objects.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class ResourceContentsAccessorImpl extends AbstractTypedElementAdapter implements IResourceContentsAccessor {

	/** The difference performed. */
	private final Diff fDiff;

	/** The side on which the difference is located. */
	private final MergeViewerSide fSide;

	/** The match associated to the performed difference. */
	private final Match fOwnerMatch;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapter factory used to create the accessor.
	 * @param diff
	 *            The difference performed.
	 * @param side
	 *            The side on which the difference is located.
	 */
	public ResourceContentsAccessorImpl(AdapterFactory adapterFactory, Diff diff, MergeViewerSide side) {
		super(adapterFactory);
		fDiff = diff;
		fSide = side;
		fOwnerMatch = diff.getMatch();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IResourceContentsAccessor#getComparison()
	 */
	public Comparison getComparison() {
		return fOwnerMatch.getComparison();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IResourceContentsAccessor#getInitialItem()
	 */
	public IMergeViewerItem getInitialItem() {
		Diff initialDiff = fDiff;
		EObject diffValue = (EObject)MergeViewerUtil
				.getResourceAttachmentChangeValue((ResourceAttachmentChange)initialDiff, getSide());
		if (isInTerminalState(initialDiff)) {
			Object left = MergeViewerUtil.getValueFromResourceAttachmentChange(
					(ResourceAttachmentChange)initialDiff, getComparison(), MergeViewerSide.LEFT);
			Object right = MergeViewerUtil.getValueFromResourceAttachmentChange(
					(ResourceAttachmentChange)initialDiff, getComparison(), MergeViewerSide.RIGHT);
			DifferenceSource source = initialDiff.getSource();
			DifferenceKind kind = initialDiff.getKind();
			boolean b5 = source == DifferenceSource.LEFT && kind == DifferenceKind.ADD && right == null;
			boolean b6 = source == DifferenceSource.LEFT && kind == DifferenceKind.DELETE && left == null;
			boolean b7 = source == DifferenceSource.RIGHT && kind == DifferenceKind.ADD && left == null;
			boolean b8 = source == DifferenceSource.RIGHT && kind == DifferenceKind.DELETE && right == null;
			if (b5 || b8) {
				left = null;
			}
			if (b6 || b7) {
				right = null;
			}
			if (b5 || b8 || b6 || b7) {
				Object ancestor = MergeViewerUtil.getValueFromResourceAttachmentChange(
						(ResourceAttachmentChange)initialDiff, getComparison(), MergeViewerSide.ANCESTOR);
				return new MergeViewerItem.Container(getComparison(), initialDiff, left, right, ancestor,
						getSide(), getRootAdapterFactory());
			}

		}
		if (diffValue == null && MergeViewerSide.ANCESTOR != getSide()) {
			if (MergeViewerSide.LEFT == getSide()) {
				diffValue = (EObject)MergeViewerUtil.getResourceAttachmentChangeValue(
						(ResourceAttachmentChange)initialDiff, MergeViewerSide.RIGHT);
			} else {
				diffValue = (EObject)MergeViewerUtil.getResourceAttachmentChangeValue(
						(ResourceAttachmentChange)initialDiff, MergeViewerSide.LEFT);
			}
			if (diffValue == null) {
				diffValue = (EObject)MergeViewerUtil.getResourceAttachmentChangeValue(
						(ResourceAttachmentChange)initialDiff, MergeViewerSide.ANCESTOR);
			}
		}
		Match match = getComparison().getMatch(diffValue);

		if (match != null) {
			Object left = match.getLeft();
			Object right = match.getRight();
			Object ancestor = match.getOrigin();
			// Manage case where the resource attachment change is between an existing resource and an unknown
			// resource
			if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.LEFT, initialDiff) == null) {
				left = null;
			}
			if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.RIGHT, initialDiff) == null) {
				right = null;
			}
			if (MergeViewerUtil.getResource(getComparison(), MergeViewerSide.ANCESTOR, initialDiff) == null) {
				ancestor = null;
			}

			return new MergeViewerItem.Container(getComparison(), initialDiff, left, right, ancestor,
					getSide(), getRootAdapterFactory());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IResourceContentsAccessor#getItems()
	 */
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		final ImmutableList<? extends IMergeViewerItem> ret = ImmutableList
				.of(new ResourceAttachmentChangeMergeViewerItem(getComparison(), null,
						getResource(MergeViewerSide.LEFT), getResource(MergeViewerSide.RIGHT),
						getResource(MergeViewerSide.ANCESTOR), getSide(), getRootAdapterFactory()));
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.IResourceContentsAccessor#getResource(org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide)
	 */
	public Resource getResource(MergeViewerSide side) {
		return MergeViewerUtil.getResource(fOwnerMatch.getComparison(), side, fDiff);
	}

	/**
	 * Returns the side of the content merge viewer on which the difference is performed.
	 * 
	 * @return The side of the content merge viewer on which the difference is performed.
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
		return ResourceContentsAccessorImpl.class.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getImage()
	 */
	public Image getImage() {
		return ExtendedImageRegistry.getInstance()
				.getImage(EcoreEditPlugin.getPlugin().getImage("full/obj16/EObject")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		return TypeConstants.TYPE_ERESOURCE_DIFF;
	}
}
