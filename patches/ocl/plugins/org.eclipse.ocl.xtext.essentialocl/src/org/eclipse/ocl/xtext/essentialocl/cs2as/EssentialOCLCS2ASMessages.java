/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.essentialocl.cs2as;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class EssentialOCLCS2ASMessages
{
	static {
		NLS.initializeMessages(EssentialOCLCS2ASMessages.class.getName(), EssentialOCLCS2ASMessages.class);
	}

	public static String IterateExp_BadAccumulatorSeparator;
	public static String IterateExp_MissingInitializer;
	public static String IterateExp_TooManyAccumulators;
	public static String IterateExp_TooFewAccumulators;
	public static String IteratorExp_TooManyAccumulators;
	public static String LoopExp_UnexpectedInitializer;
	public static String LoopExp_UnexpectedType;
	public static String PropertyCallExp_IncompatibleProperty;
}
