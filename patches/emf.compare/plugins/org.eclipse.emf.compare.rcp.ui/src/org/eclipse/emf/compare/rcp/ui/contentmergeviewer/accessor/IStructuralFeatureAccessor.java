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
package org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor;

import org.eclipse.emf.compare.rcp.ui.mergeviewer.IMergeViewer.MergeViewerSide;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A specific {@link ICompareAccessor} for structural features.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public interface IStructuralFeatureAccessor extends ICompareAccessor {

	/**
	 * Returns the structural feature for which an accessor is needed.
	 * 
	 * @return the structural feature for which an accessor is needed.
	 */
	EStructuralFeature getStructuralFeature();

	/**
	 * Returns the EObject associated with the structural feature.
	 * 
	 * @param side
	 *            the side of the content merge viewer for which we want the EObject associated with the
	 *            structural feature.
	 * @return the EObject associated with the structural feature.
	 */
	EObject getEObject(MergeViewerSide side);

}
