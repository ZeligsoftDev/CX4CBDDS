/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.expression;

/**
 * Implementors of this interface can retrieve an ExecutionContext.
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @since 1.0.0-M4
 */
public interface IExecutionContextAware {
	
	void setExecutionContext (ExecutionContext ctx);
}
