/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.compare.internal.contentmergeviewer.accessor.factory.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl.ContainmentReferenceChangeAccessorFactory;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.ContainmentReferenceChangeAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;

import com.zeligsoft.domain.dds4ccm.ui.compare.internal.contentmergeviewer.accessor.impl.DDS4CCMContainmentReferenceChangeAccessorImpl;

/**
 * @author eposse
 *
 */
public class DDS4CCMContainementReferenceChangeAccessorFactory extends ContainmentReferenceChangeAccessorFactory {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createLeft(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	@Override
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new DDS4CCMContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
				MergeViewerSide.LEFT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createRight(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	@Override
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new DDS4CCMContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
				MergeViewerSide.RIGHT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createAncestor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	@Override
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new DDS4CCMContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
				MergeViewerSide.ANCESTOR);
	}

	/**
	 * Returns the appropriate reference change. If the given object has a prime refining that is a reference
	 * change, returns this reference change. If the given object is a reference change, returns it.
	 * Otherwise, returns null.
	 * 
	 * @param target
	 *            the given object.
	 * @return the appropriate reference change.
	 */
	private ReferenceChange getAppropriateReferenceChange(Object target) {
		final ReferenceChange referenceChange;
		if (target instanceof ReferenceChange) {
			referenceChange = (ReferenceChange)target;
		} else if (((Diff)target).getPrimeRefining() instanceof ReferenceChange) {
			referenceChange = (ReferenceChange)((Diff)target).getPrimeRefining();
		} else {
			referenceChange = null;
		}
		return referenceChange;
	}

}
