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

import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory;

/**
 * An abstract implementation of {@link IAccessorFactory}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 * @since 4.0
 */
public abstract class AbstractAccessorFactory implements IAccessorFactory {

	/** The ranking of this factory. */
	private int ranking;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#getRanking()
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory#setRanking(int)
	 */
	public void setRanking(int r) {
		ranking = r;
	}

}
