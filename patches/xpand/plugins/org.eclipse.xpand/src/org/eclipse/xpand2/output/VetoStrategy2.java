/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xpand2.output;

/**
 * 
 * @author thoms
 * @since 4.3.1
 */
public interface VetoStrategy2 extends VetoStrategy {

	/**
	 * Called before the file will be opened and generated.
	 * @param impl A handle to the file that will be generated
	 * @return if hasVetoBeforeOpen returns true the file will not be opened nor generated
	 */
	boolean hasVetoBeforeOpen (FileHandle handle);

}
