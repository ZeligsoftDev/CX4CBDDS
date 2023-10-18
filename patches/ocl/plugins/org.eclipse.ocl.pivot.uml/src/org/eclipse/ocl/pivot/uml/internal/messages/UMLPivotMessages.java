/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.uml.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * @since 1.3
 */
public class UMLPivotMessages
{	
	static {
		NLS.initializeMessages(UMLPivotMessages.class.getName(), UMLPivotMessages.class);
	}
	
	public static String TooManyValuesForRedefinedProperty;
}
