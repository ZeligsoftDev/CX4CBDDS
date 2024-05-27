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
package org.eclipse.emf.compare.rcp.ui.internal.mergeviewer;

import org.eclipse.emf.compare.rcp.ui.configuration.ICompareEvent;

/**
 * A event notifying the bus that some color have change their value.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public interface IColorChangeEvent extends ICompareEvent {

	/**
	 * Get the color ID that has been modified.
	 * 
	 * @return The color ID
	 */
	String getColorID();

}
