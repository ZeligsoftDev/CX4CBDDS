/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 295166
 *   Borland - Bug 242880
 *******************************************************************************/

package org.eclipse.ocl.pivot.options;

import org.eclipse.ocl.pivot.utilities.Customizable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * Options applicable to {@link EnvironmentFactory}s to
 * {@linkplain Customizable customize} their parsing behaviour.
 */
public class ParsingOptions
{
   /**
     * Not instantiable by clients.
     */
    private ParsingOptions() {
        super();
    }
}
