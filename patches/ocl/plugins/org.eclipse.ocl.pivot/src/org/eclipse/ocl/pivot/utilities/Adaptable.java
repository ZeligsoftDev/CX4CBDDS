/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;

/**
 * Interface implemented by {@link EnvironmentFactory}s and {@link EvaluationEnvironment}s that are adaptable to
 * optional interfaces that can be considered as extensions to the environment API.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface Adaptable {
	/**
	 * Obtains an adapter for the specified interface type.
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this environment does not adapt to it
	 */
	<T> @Nullable T getAdapter(Class<T> adapterType);
}
