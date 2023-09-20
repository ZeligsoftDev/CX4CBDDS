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
package org.eclipse.internal.xtend.xtend.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;

public final class ParseFacade {
	private ParseFacade() {
	}

	public static Expression expression(final String r) {
		return expression(new StringReader(r), null);
	}

	public static Expression expression(final Reader r, final ErrorHandler handler) {
		ANTLRReaderStream readerStream;
		try {
			readerStream = new ANTLRReaderStream(r);
		} catch (IOException e2) {
			throw new RuntimeException(e2);
		}
		final ErrorHandler h = getErrorHandler(handler);
		try {
			return getParser(new ExtensionFactory("nofile"), readerStream, h).expression();
		} catch (final RecognitionException e) {
			h.handleError(createError(e, ""));
		}
		return null;
	}

	public static ExtensionFile file(final Reader r, final String fileName) {
		return file(r, fileName, null);
	}

	public static ExtensionFile file(final Reader r, final String fileName, final ErrorHandler handler) {
		return file(r, fileName, handler, null);
	}

	public static ExtensionFile file(final Reader r, final String fileName, final ErrorHandler handler, final ExtensionFactory factory) {
		ExtensionFactory _factory = factory != null ? factory : new ExtensionFactory(fileName);
		ANTLRReaderStream readerStream;
		try {
			readerStream = new ANTLRReaderStream(r);
		} catch (IOException e2) {
			throw new RuntimeException(e2);
		}
		final ErrorHandler h = getErrorHandler(handler);
		try {
			return getParser(_factory, readerStream, h).file();
		} catch (final RecognitionException e) {
			h.handleError(createError(e, ""));
		}
		return null;
	}

	private static XtendParser getParser(final ExtensionFactory factory, final ANTLRReaderStream readerStream, final ErrorHandler h) {
		XtendLexer lex = new XtendLexer(readerStream) {
			@Override
			public void reportError(final RecognitionException e) {
				h.handleError(createError(e, getErrorMessage(e, getTokenNames())));
			}
		};

		CommonTokenStream str = new CommonTokenStream();
		str.setTokenSource(lex);
		XtendParser parser = new XtendParser(str, factory) {
			@Override
			public void reportError(final RecognitionException e) {
				h.handleError(createError(e, getErrorMessage(e, getTokenNames())));
			}
		};
		return parser;
	}

	private static ErrorHandler getErrorHandler(final ErrorHandler handler) {
		final ErrorHandler h = handler != null ? handler : new ErrorHandler() {

			public void handleError(final XtendError e) {
				throw new ParseException(e);
			}
		};

		return h;
	}

	protected static XtendError createError(final RecognitionException e, final String string) {
		if (e.token == null) {
			return new SyntaxError(e.index, e.line, e.index + 1, string);
		}
		CommonToken t = (CommonToken) e.token;
		return new SyntaxError(t.getStartIndex(), t.getStopIndex() + 1, t.getLine(), string);
	}
}
