/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend;

import java.io.Reader;

import org.eclipse.internal.xtend.xtend.parser.ParseFacade;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceParser;

public class XtendResourceParser implements ResourceParser {

	public Resource parse(final Reader in, final String fileName) {
		return ParseFacade.file(in, fileName);
	}

}
