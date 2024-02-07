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
 * PostProcessors can be added to the Xpand Generator component to implement manipulations
 * on the generated file content. This is usually helpful for auto-format the generated code.
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Karsten Thoms (doc)
 * @since 4.0
 */
public interface PostProcessor {
	/**
	 * Called before the file will be written.
	 * @param impl A handle to the file that will be written
	 */
    public void beforeWriteAndClose(FileHandle impl);

	/**
	 * Called after the file has been written.
	 * @param impl A handle to the file that has been written
	 */
    public void afterClose(FileHandle impl);
}
