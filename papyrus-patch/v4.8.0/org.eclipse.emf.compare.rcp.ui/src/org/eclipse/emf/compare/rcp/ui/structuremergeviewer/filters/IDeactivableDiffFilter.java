/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters;

/**
 * A {@link IDifferenceFilter} that can be fully deactivated in the preferences.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 * @since 4.3
 */
public interface IDeactivableDiffFilter extends IDifferenceFilter {

	/**
	 * Whether the filter is enabled, i.e. will be taken into account in computations and displayed in the UI.
	 * 
	 * @return The enablement of the filter.
	 */
	boolean isActive();

	/**
	 * Set the activation of the filter.
	 * 
	 * @param active
	 *            Whether the filter should be active
	 */
	void setActive(boolean active);
}
