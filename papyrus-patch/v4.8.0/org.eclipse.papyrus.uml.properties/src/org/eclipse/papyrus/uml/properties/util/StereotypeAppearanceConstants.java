/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.util;

/**
 * A list of constants for Stereotype appearance
 *
 * @author Camille Letavernier
 *
 */
// TODO : Move this interface to UML Tools or UML Utils
public interface StereotypeAppearanceConstants {

	/** constant for stereotype text alignement */
	public static final String VERTICAL = "Vertical"; //$NON-NLS-1$

	/** constant for stereotype text alignement */
	public static final String HORIZONTAL = "Horizontal"; //$NON-NLS-1$

	/** constant for stereotype appearance section. Style: text and icon */
	public static final String TEXT_AND_ICON = "Text and Icon"; //$NON-NLS-1$

	/** constant for stereotype appearance section. Style: shape */
	public static final String SHAPE = "Shape"; //$NON-NLS-1$

	/** constant for stereotype appearance section. Style: icon */
	public static final String ICON = "Icon"; //$NON-NLS-1$

	/** constant for stereotype appearance section. Style: text */
	public static final String TEXT = "Text"; //$NON-NLS-1$

	/** the id of the stereotypeDisplay property */
	public static final String STEREOTYPE_DISPLAY = "stereotypeDisplay"; //$NON-NLS-1$

	/** the id of the textAlignment property */
	public static final String TEXT_ALIGNMENT = "textAlignment"; //$NON-NLS-1$

	/** the id of the displayPlace property */
	public static final String DISPLAY_PLACE = "displayPlace"; //$NON-NLS-1$
}
