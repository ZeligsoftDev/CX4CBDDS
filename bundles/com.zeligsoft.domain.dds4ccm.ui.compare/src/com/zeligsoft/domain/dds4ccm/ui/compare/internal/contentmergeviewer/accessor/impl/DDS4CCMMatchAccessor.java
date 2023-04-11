package com.zeligsoft.domain.dds4ccm.ui.compare.internal.contentmergeviewer.accessor.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.MatchAccessor;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;

import com.google.common.collect.ImmutableList;

public class DDS4CCMMatchAccessor extends MatchAccessor implements ITypedElement {

	/** The match associated with this accessor. */
	private final Match fMatch;

	/** The diff associated with this accessor. */
	private Diff fDiff;

	/** The side of this accessor. */
	private final MergeViewerSide fSide;

	public DDS4CCMMatchAccessor(AdapterFactory adapterFactory, Match match, MergeViewerSide side) {
		super(adapterFactory, match, side);
		fMatch = match;
		fDiff = null;
		fSide = side;
	}

	public DDS4CCMMatchAccessor(AdapterFactory adapterFactory, Match match, Diff diff, MergeViewerSide side) {
		super(adapterFactory, match, diff, side);
		fMatch = match;
		fDiff = diff;
		fSide = side;
	}

	@Override
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		final ImmutableList<? extends IMergeViewerItem> ret;
		ret = ImmutableList.of(new MergeViewerItem.Container(getComparison(), fDiff, fMatch,
				fSide, getAdapterFactory()));
		return ret;
	}


}
