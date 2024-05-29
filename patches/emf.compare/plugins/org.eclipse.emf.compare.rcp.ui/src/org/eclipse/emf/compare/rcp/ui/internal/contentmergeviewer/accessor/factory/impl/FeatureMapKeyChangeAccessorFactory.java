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
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.FeatureMapChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl.FeatureMapKeyChangeAccessorImpl;
import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;

/**
 * A specific {@link org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory} for
 * FeatureMapChanges of kind DifferenceKind.CHANGE (represent a value that changed his key).
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public class FeatureMapKeyChangeAccessorFactory extends AbstractAccessorFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#isFactoryFor(java.lang.Object)
	 */
	public boolean isFactoryFor(Object target) {
		if (target instanceof FeatureMapChange) {
			FeatureMapChange featureMapChange = (FeatureMapChange)target;
			return featureMapChange.getKind() == DifferenceKind.CHANGE;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createLeft(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createLeft(AdapterFactory adapterFactory, Object target) {
		return new FeatureMapKeyChangeAccessorImpl(adapterFactory, (FeatureMapChange)target,
				MergeViewerSide.LEFT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createRight(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createRight(AdapterFactory adapterFactory, Object target) {
		return new FeatureMapKeyChangeAccessorImpl(adapterFactory, (FeatureMapChange)target,
				MergeViewerSide.RIGHT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#createAncestor(org.eclipse.emf.common.notify.AdapterFactory,
	 *      java.lang.Object)
	 */
	public ITypedElement createAncestor(AdapterFactory adapterFactory, Object target) {
		return new FeatureMapKeyChangeAccessorImpl(adapterFactory, (FeatureMapChange)target,
				MergeViewerSide.ANCESTOR);
	}
}
