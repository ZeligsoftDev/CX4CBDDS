/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.options;

import org.eclipse.ocl.common.delegate.VirtualDelegateMapping;
import org.eclipse.ocl.common.internal.preferences.StringPreference;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

public class OCLinEcoreOptions
{
	/**
	 * The value of the OCL Delegate URI written to *.ecore files when no default was
	 * available when the file was read.
	 * <p>
	 * The default value of "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot" uses the
	 * Pivot-based evaluator when the embedded OCL is invoked, typically be model validation. 
	 * <p>
	 * The alternate value of "http://www.eclipse.org/emf/2002/Ecore/OCL/LPG" uses the
	 * classic Ecore-based evaluator. 
	 * <p>
	 * The virtual value of "http://www.eclipse.org/emf/2002/Ecore/OCL" uses the
	 * {@link VirtualDelegateMapping} to control which evaluator to use.
	 */
    public static final StringPreference EXPORT_DELEGATION_URI = new StringPreference(
    	PivotPlugin.PLUGIN_ID, "export.delegation.mode", PivotConstants.OCL_DELEGATE_URI_PIVOT); //$NON-NLS-1$

    /**
     * Not instantiable by clients.
     */
    private OCLinEcoreOptions() {
        super();
    }
}
