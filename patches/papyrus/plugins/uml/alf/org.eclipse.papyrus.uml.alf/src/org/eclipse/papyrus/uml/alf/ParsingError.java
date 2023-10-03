/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  IJI - Initial implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import org.eclipse.xtext.nodemodel.INode;

public class ParsingError extends Exception {

	private static final long serialVersionUID = 1L;
	Iterable<INode> syntaxErrors;

	public ParsingError(Iterable<INode> syntaxErrors) {
		this.syntaxErrors = syntaxErrors;
	}

	public Iterable<INode> getSyntaxErrors() {
		return this.syntaxErrors;
	}

}
