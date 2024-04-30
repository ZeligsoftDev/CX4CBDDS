/*******************************************************************************
 * Copyright (c) 2012, 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public final class EMFCompareConstants {

	private EMFCompareConstants() {
		// prevents instantiation
	}

	// ITypedElement#getType()

	public static final String NODE_TYPE__EMF_RESOURCESET = "NODE_TYPE__EMF_RESOURCESET"; //$NON-NLS-1$

	public static final String NODE_TYPE__EMF_RESOURCE = "NODE_TYPE__EMF_RESOURCE"; //$NON-NLS-1$

	public static final String NODE_TYPE__EMF_EOBJECT = "NODE_TYPE__EMF_EOBJECT"; //$NON-NLS-1$

	/**
	 * If the list on any one of the sides we're trying to display in the UI contains more elements than the
	 * given threshold, don't try and compute the insertion index for differences merging. On the one hand,
	 * showing insertion points in lists with so many elements wouldn't really be human readable, on the other
	 * hand, trying to compute insertion indices for too large lists will easily result in OutOfMemoryErrors.
	 * For example, if the left and right sides contain 60000 elements, we'll end up trying to instantiate an
	 * array with the following signature: "int[60000][60000]" to compute the LCS (see DiffUtils). Such an
	 * array would cost 13GB of memory as a conservative estimate.
	 */
	public static final short LIST_SIZE_INSERTION_POINT_THRESHOLD = 10000;

}
