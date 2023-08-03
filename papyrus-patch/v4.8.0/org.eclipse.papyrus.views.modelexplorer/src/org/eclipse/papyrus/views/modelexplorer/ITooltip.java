/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * Interface containing operations from {@Link org.eclipse.jface.viewers.CellLabelProvider} It's a design fault that no interface has been defined by jface in the first place.
 *
 * @author ansgar
 *
 */
public interface ITooltip {
	/**
	 * @see CellLabelProvider
	 *
	 * @param object
	 *            the element for which the tool tip is shown
	 * @return {@link Image} or <code>null</code> if there is not image.
	 */

	public Image getToolTipImage(Object object);

	/**
	 * @see CellLabelProvider
	 *
	 *
	 * @param element
	 *            the element for which the tool tip is shown
	 * @return the {@link String} or <code>null</code> if there is not text to
	 *         display
	 */
	public String getToolTipText(Object element);

	/**
	 * Return the amount of pixels in x and y direction you want the tool tip to
	 * pop up from the mouse pointer. The default shift is 10px right and 0px
	 * below your mouse cursor. Be aware of the fact that you should at least
	 * position the tool tip 1px right to your mouse cursor else click events
	 * may not get propagated properly.
	 *
	 * @param object
	 *            the element for which the tool tip is shown
	 * @return {@link Point} to shift of the tool tip or <code>null</code> if the
	 *         default shift should be used.
	 */
	public Point getToolTipShift(Object object);

	/**
	 * The time in milliseconds the tool tip is shown for.
	 *
	 * @param object
	 *            the {@link Object} for which the tool tip is shown
	 * @return time in milliseconds the tool tip is shown for
	 */
	public int getToolTipTimeDisplayed(Object object);

	/**
	 * The time in milliseconds until the tool tip is displayed.
	 *
	 * @param object
	 *            the {@link Object} for which the tool tip is shown
	 * @return time in milliseconds until the tool tip is displayed
	 */
	public int getToolTipDisplayDelayTime(Object object);
}
