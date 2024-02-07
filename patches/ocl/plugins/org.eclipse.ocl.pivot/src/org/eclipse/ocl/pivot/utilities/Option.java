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


/**
 * Interface implemented by the options that can be applied to {@link Customizable}
 * entities such as OCL environments.
 * 
 * @param <T> the type of the option's value
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see Customizable
 */
public interface Option<T> {
	/**
	 * Obtains my string key, which may be used for persistence in a
	 * preference store.
	 * 
	 * @return my key.  Is never <code>null</code>
	 */
	String getKey();
	
	/**
	 * Obtains the option's default value.
	 * 
	 * @return my default value, which default-default is <code>null</code>
	 */
	T getDefaultValue();
}
