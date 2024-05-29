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
package org.eclipse.emf.compare.rcp.ui.mergeviewer;

import org.eclipse.emf.compare.Diff;
import org.eclipse.swt.graphics.Color;

/**
 * Implementation of this interface will return color of decorator of {@link Diff difference}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public interface ICompareColor {

	/**
	 * Return the color of the background of the decorator of the given {@code diff}.
	 * 
	 * @param diff
	 *            the diff to be decorated.
	 * @param isThreeWay
	 *            are we comparing three models.
	 * @param isIgnoreAncestor
	 *            if the ancestor has to be ignored (i.e. ignore the isThreeWay parameter).
	 * @param selected
	 *            if the given {@code diff} is selected in the viewer.
	 * @return the background color.
	 */
	Color getFillColor(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected);

	/**
	 * Return the color of the stroke of the decorator of the given {@code diff}.
	 * 
	 * @param diff
	 *            the diff to be decorated.
	 * @param isThreeWay
	 *            are we comparing three models.
	 * @param isIgnoreAncestor
	 *            if the ancestor has to be ignored (i.e. ignore the isThreeWay parameter).
	 * @param selected
	 *            if the given {@code diff} is selected in the viewer.
	 * @return the background color.
	 */
	Color getStrokeColor(Diff diff, boolean isThreeWay, boolean isIgnoreAncestor, boolean selected);

	/**
	 * Get the color for Required change.
	 * 
	 * @return
	 */
	Color getRequiredFillColor();

	/**
	 * Get the color for Required change border items. This color is computed from
	 * {@link ICompareColor#getRequiredFillColor()}
	 * 
	 * @return
	 */
	Color getRequiredStrokeColor();

	/**
	 * Get the color for Unmergeable difference.
	 * 
	 * @return
	 */
	Color getUnmergeableFillColor();

	/**
	 * Get the color for Unmergeable difference border items. This color is computed from
	 * {@link ICompareColor#getUnmergeableFillColor()}
	 * 
	 * @return
	 */
	Color getUnmergeableStrokeColor();

	/**
	 * Dispose all {@link Color} resources.
	 */
	void dispose();

	/**
	 * A provider of ICompareColor.
	 * 
	 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
	 * @since 4.0
	 */
	public interface Provider {

		/**
		 * Returns the ICompareColor.
		 * 
		 * @return the ICompareColor.
		 */
		ICompareColor getCompareColor();
	}
}
