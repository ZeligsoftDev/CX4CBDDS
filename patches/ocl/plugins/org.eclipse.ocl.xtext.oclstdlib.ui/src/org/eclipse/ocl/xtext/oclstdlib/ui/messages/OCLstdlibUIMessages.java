/*******************************************************************************
 * Copyright (c) 2012, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.xtext.oclstdlib.ui.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class OCLstdlibUIMessages
{
	static {
		NLS.initializeMessages(OCLstdlibUIMessages.class.getName(), OCLstdlibUIMessages.class);
	}

	public static String NewWizardPage_defaultFileName;
	public static String NewWizardPage_fileNameLabel;
	public static String NewWizardPage_pageDescription;
	public static String NewWizardPage_pageSummary;
	public static String NewWizardPage_pageTitle;
}
