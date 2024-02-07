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
package org.eclipse.ocl.pivot.options;

import org.eclipse.ocl.common.internal.preferences.BooleanPreference;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * Options applicable to use of the OCL Xtext console.
 * @since 1.1
 */
public class PivotConsoleOptions
{
    public static final BooleanPreference ConsoleModeltypesInformation = new BooleanPreference(
    	PivotPlugin.PLUGIN_ID, "console.modeltypes.information", true); //$NON-NLS-1$

    private PivotConsoleOptions() {
        super();
    }
}
