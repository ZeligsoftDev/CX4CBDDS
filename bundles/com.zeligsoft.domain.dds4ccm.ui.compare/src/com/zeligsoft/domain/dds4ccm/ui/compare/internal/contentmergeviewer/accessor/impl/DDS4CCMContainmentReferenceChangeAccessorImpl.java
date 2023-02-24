/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.compare.internal.contentmergeviewer.accessor.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.ContainmentReferenceChangeAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.internal.mergeviewer.item.impl.MergeViewerItem;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.item.IMergeViewerItem;

import com.google.common.collect.ImmutableList;

/**
 * @author eposse
 *
 */
public class DDS4CCMContainmentReferenceChangeAccessorImpl extends ContainmentReferenceChangeAccessorImpl {

	public DDS4CCMContainmentReferenceChangeAccessorImpl(AdapterFactory adapterFactory, Diff diff,
			MergeViewerSide side) {
		super(adapterFactory, diff, side);
	}

	@Override
	public ImmutableList<? extends IMergeViewerItem> getItems() {
		final ImmutableList<? extends IMergeViewerItem> ret;
		Diff diff = getInitialDiff();
		Match match = diff != null ? diff.getMatch() : null;
		ret = ImmutableList.of(new MergeViewerItem.Container(getComparison(), diff, match,
				getSide(), getAdapterFactory()));

		return ret;
	}

}
