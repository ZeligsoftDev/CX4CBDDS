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
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl;

import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProviderChange;

/**
 * The default implementation of {@link IDifferenceGroupProviderChange}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class DifferenceGroupProviderChange implements IDifferenceGroupProviderChange {

	/** The selected IDifferenceGroupProvider. */
	private final IDifferenceGroupProvider differenceGroupProvider;

	/**
	 * Default constructor.
	 * 
	 * @param differenceGroupProvider
	 *            an IDifferenceGroupProvider.
	 */
	public DifferenceGroupProviderChange(IDifferenceGroupProvider differenceGroupProvider) {
		this.differenceGroupProvider = differenceGroupProvider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProviderChange#getDifferenceGroupProvider()
	 */
	public IDifferenceGroupProvider getDifferenceGroupProvider() {
		return differenceGroupProvider;
	}

}
