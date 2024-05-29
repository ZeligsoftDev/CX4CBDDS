/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.ContainmentReferenceChangeAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;

/**
 * A specific {@link org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory} for
 * containment {@link ReferenceChange} objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class ContainmentReferenceChangeAccessorFactory extends AbstractAccessorFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#isFactoryFor(java.lang.Object)
	 */
	public boolean isFactoryFor(Object target) {
		final boolean isFactoryFor;
		if (target instanceof ReferenceChange) {
			isFactoryFor = ((ReferenceChange)target).getReference().isContainment();
		} else if (target instanceof Diff) {
			Diff primeRefining = ((Diff)target).getPrimeRefining();
			isFactoryFor = primeRefining instanceof ReferenceChange
					&& ((ReferenceChange)primeRefining).getReference().isContainment();
		} else {
			isFactoryFor = false;
		}
		return isFactoryFor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createLeft(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new ContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
				MergeViewerSide.LEFT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createRight(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new ContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
				MergeViewerSide.RIGHT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createAncestor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		ReferenceChange referenceChange = getAppropriateReferenceChange(target);
		return new ContainmentReferenceChangeAccessorImpl(adapterFactory, referenceChange,
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
