/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.ocl.pivot.util.PivotPlugin;


/**
 * @author Yasser Lulu  
 */
public final class OCLDebugOptions {

	/**
	 * 
	 */
	private OCLDebugOptions() {
		super();
	}
	
	public static final String DEBUG = PivotPlugin.PLUGIN_ID + "/debug"; //$NON-NLS-1$

	public static final String EXCEPTIONS_CATCHING = DEBUG + "/exceptions/catching"; //$NON-NLS-1$
	public static final String EXCEPTIONS_THROWING = DEBUG + "/exceptions/throwing"; //$NON-NLS-1$

	public static final String METHODS_ENTERING = DEBUG + "/methods/entering"; //$NON-NLS-1$
	public static final String METHODS_EXITING = DEBUG + "/methods/exiting"; //$NON-NLS-1$
    
    public static final String PARSING = DEBUG + "/parsing"; //$NON-NLS-1$
    public static final String EVALUATION = DEBUG + "/evaluation"; //$NON-NLS-1$

}
