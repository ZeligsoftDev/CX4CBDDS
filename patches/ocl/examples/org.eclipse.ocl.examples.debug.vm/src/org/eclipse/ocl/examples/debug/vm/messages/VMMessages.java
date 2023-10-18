/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class VMMessages
{
	static {
		NLS.initializeMessages(VMMessages.class.getName(), VMMessages.class);
	}
	
	public static String MiscUtil_ErrorMessage;
	public static String ShallowProcess_InvalidState;
	public static String ShallowProcess_Label;
	public static String TerminatingExecution;
}
