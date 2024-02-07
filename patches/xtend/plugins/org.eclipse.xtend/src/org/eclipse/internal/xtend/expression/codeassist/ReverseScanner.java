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

package org.eclipse.internal.xtend.expression.codeassist;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.internal.xtend.xtend.parser.XtendLexer;

public class ReverseScanner {

	private int index;

	private List<CommonToken> tokens = new ArrayList<CommonToken>();

	public ReverseScanner(final String s) {
		CommonTokenStream stream = new CommonTokenStream(new XtendLexer(
				new ANTLRStringStream(s)));
		CommonToken ct = null;
		tokens.add(null);
		while ((ct = (CommonToken) stream.LT(1)).getType() != XtendLexer.EOF) {
			tokens.add(ct);
			stream.consume();
		}
		tokens.add(null);
		index = lastIndex();
	}

	private int lastIndex() {
		return tokens.size()-1;
	}

	public CommonToken previousToken() {
		return tokens.get(decrement());
	}

	private int decrement() {
		return index==0?0:--index;
	}

	public CommonToken nextToken() {
		return tokens.get(increment());
	}

	private int increment() {
		return index==lastIndex()?lastIndex():++index;
	}

	public int getOffset() {
		if (index == 0)
			return 0;
		if (index == lastIndex())
			return tokens.get(lastIndex()-1).getStopIndex()+1;
		return tokens.get(index).getStartIndex();
	}

}
