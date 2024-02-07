/*******************************************************************************
 * Copyright (c) 2010, 2018 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.utilities;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * A mix-in interface indicating that implementations can provide problem
 * diagnostics.
 * 
 * @author dvorak
 */
public interface ProblemAware {

	/**
	 * Retrieves the problems available on this problem aware object
	 * 
	 * @return the diagnostic object representing the problems or
	 *         <code>null</code> in case that no problems are available.
	 */
	Diagnostic getProblems();
}
