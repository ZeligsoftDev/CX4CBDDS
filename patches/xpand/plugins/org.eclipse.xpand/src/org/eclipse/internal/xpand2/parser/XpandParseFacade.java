/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html Contributors: committers of
 * openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.internal.xpand2.parser;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xtend.xtend.parser.ErrorHandler;
import org.eclipse.internal.xtend.xtend.parser.ParseException;
import org.eclipse.internal.xtend.xtend.parser.SyntaxError;
import org.eclipse.internal.xtend.xtend.parser.XtendError;

public final class XpandParseFacade {

  private XpandParseFacade() {}

  public static Template file(final Reader r, final String fileName) {
    return file(r, fileName, null);
  }

  public static Template file(final Reader r, final String fileName, final ErrorHandler handler) {
    ANTLRReaderStream readerStream;
    try {
      readerStream = new ANTLRReaderStream(r);
    }
    catch (final IOException e2) {
      throw new RuntimeException(e2);
    }
    final ErrorHandler h = getErrorHandler(handler);
    try {
      return getParser(fileName, readerStream, h).template();
    }
    catch (final RecognitionException e) {
      h.handleError(createError(e, ""));
    }
    return null;
  }

  private static XpandParser getParser(final String fileName, final ANTLRReaderStream readerStream, final ErrorHandler h) {
    final XpandLexer lex = new XpandLexer(readerStream) {

      @Override
      public void reportError(final RecognitionException e) {
        h.handleError(createError(e, getErrorMessage(e, getTokenNames())));
      }
    };

    final CommonTokenStream str = new CommonTokenStream();
    str.setTokenSource(lex);
    final XpandParser parser = new XpandParser(str, new XpandFactory(fileName)) {

      @Override
      public void reportError(final RecognitionException e) {
        h.handleError(createError(e, getErrorMessage(e, getTokenNames())));
      }
    };
    return parser;
  }

  private static ErrorHandler getErrorHandler(final ErrorHandler handler) {
    if (handler == null) {
      return new ErrorHandler() {

        public void handleError(final XtendError e) {
          throw new ParseException(e);
        }
      };
    }
    return handler;
  }

  protected static XtendError createError(final RecognitionException e, final String string) {
    if (e.token == null) {
      return new SyntaxError(e.index, e.line, e.index + 1, string);
    }
    final CommonToken t = (CommonToken) e.token;
    return new SyntaxError(t.getStartIndex(), t.getStopIndex(), t.getLine(), string);
  }
}
