/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class ValidityMessages
{	
	static {
		NLS.initializeMessages(ValidityMessages.class.getName(), ValidityMessages.class);
	}
	
	public static String ValidityView_Constraints_LabelProvider_NonExistentResource;
	public static String ValidityView_Constraints_LabelProvider_ExpressionNotAvailable;
}
