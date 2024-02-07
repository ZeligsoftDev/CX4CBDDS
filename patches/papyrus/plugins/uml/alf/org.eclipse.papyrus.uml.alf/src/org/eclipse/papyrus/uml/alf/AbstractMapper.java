/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	- Jérémie Tatibouet
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public abstract class AbstractMapper {

	/**
	 * Execution context of a transformation
	 */
	protected ExecutionContextImpl context;

	/**
	 * Executor for the given transformation
	 */
	protected TransformationExecutor executor;

	public AbstractMapper() {
		this.context = new ExecutionContextImpl();
		this.context.setConfigProperty("keepModeling", true);
	}
}