/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
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
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.MatchAccessor;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.compare.utils.MatchUtil;
import org.eclipse.emf.ecore.EObject;

/**
 * A specific {@link org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory} for
 * {@link Match} objects.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class MatchAccessorFactory extends AbstractAccessorFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#isFactoryFor(java.lang.Object)
	 */
	public boolean isFactoryFor(Object target) {
		return target instanceof Match;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createLeft(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		return new MatchAccessor(adapterFactory, (Match)target, getContainmentReferenceChange((Match)target),
				MergeViewerSide.LEFT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createRight(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		return new MatchAccessor(adapterFactory, (Match)target, getContainmentReferenceChange((Match)target),
				MergeViewerSide.RIGHT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createAncestor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		return new MatchAccessor(adapterFactory, (Match)target, getContainmentReferenceChange((Match)target),
				MergeViewerSide.ANCESTOR);
	}

	/**
	 * Some Matches are related to an object that has been either added or deleted. In these cases, this
	 * method returns the Diff representing this addition or deletion. In other cases, this method returns
	 * <code>null</code>.
	 * 
	 * @param match
	 *            the given Match.
	 * @return the Diff on the object related to the given Match if it exists, <code>null</code> otherwise.
	 */
	private Diff getContainmentReferenceChange(Match match) {
		final Iterable<Diff> addOrDeleteContainmentDiffs = MatchUtil.findAddOrDeleteContainmentDiffs(match);
		if (addOrDeleteContainmentDiffs != null) {
			final EObject left = match.getLeft();
			final EObject right = match.getRight();
			final EObject origin = match.getOrigin();
			for (Diff diff : addOrDeleteContainmentDiffs) {
				final Object diffValue = MatchUtil.getValue(diff);
				if (diffValue != null
						&& (diffValue.equals(left) || diffValue.equals(right) || diffValue.equals(origin))) {
					return diff;
				}
			}
		}
		return null;
	}
}
