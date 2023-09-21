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

public interface VetoStrategy {

	/**
	 * Called before the file will be written 
	 * and <b>after</b> beforeWriteAndClose() has been invoked on all post processors.
	 * @param impl A handle to the file that will be written
	 * @return if hasVeto returns true the file will not be written
	 */
	boolean hasVeto(FileHandle handle);

}
