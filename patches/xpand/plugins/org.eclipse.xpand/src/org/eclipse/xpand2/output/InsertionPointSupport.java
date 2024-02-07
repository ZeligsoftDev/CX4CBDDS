/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpand2.output;

import org.eclipse.internal.xpand2.ast.Statement;


/**
 * @author Karsten Thoms - Initial contribution and API
 * @since 1.0.0 M5
 */
public interface InsertionPointSupport {
	void registerInsertionPoint (Statement stmt);
	void activateInsertionPoint (Statement stmt);
	void deactivateInsertionPoint (Statement stmt);
}
