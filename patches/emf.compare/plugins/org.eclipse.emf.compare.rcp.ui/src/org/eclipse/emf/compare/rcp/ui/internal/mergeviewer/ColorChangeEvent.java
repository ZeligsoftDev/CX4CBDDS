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

/**
 * Event to notify a color change.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class ColorChangeEvent implements IColorChangeEvent {

	/** Id of the color that have changed. */
	private final String colorId;

	/**
	 * Constructor.
	 * 
	 * @param colorId
	 *            Id of the color that has been modified.
	 */
	public ColorChangeEvent(String colorId) {
		super();
		this.colorId = colorId;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getColorID() {
		return colorId;
	}

}
