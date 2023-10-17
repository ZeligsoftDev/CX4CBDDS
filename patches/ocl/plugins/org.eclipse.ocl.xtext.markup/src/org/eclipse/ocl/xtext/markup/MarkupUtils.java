/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.markup;

import java.io.Reader;
import java.io.StringReader;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.xtext.markup.parser.antlr.MarkupParser;
import org.eclipse.ocl.xtext.markupcs.Markup;
import org.eclipse.ocl.xtext.markupcs.NewLineElement;
import org.eclipse.ocl.xtext.markupcs.util.MarkupSwitch;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;

public class MarkupUtils extends MarkupSwitch<@Nullable StringBuilder>
{
/*	public static Markup decode(String text) {
//		System.out.println("decode: " + text);
		Injector injector = MarkupStandaloneSetup.getInjector();
		MarkupParser parser = injector.getInstance(MarkupParser.class);
		Reader reader = new StringReader(text);
		IParseResult parseResult = parser.parse(reader);
		Iterable<INode> parseErrors = parseResult.getSyntaxErrors();
//		List<SyntaxError> parseErrors = parseResult.getParseErrors();
		EObject rootASTElement = parseResult.getRootASTElement();
//		System.out.println("decoded: " + reader.debug);
		for (INode parseError : parseErrors) {
			System.out.println("error : " + parseError.getSyntaxErrorMessage());
		}
		return (Markup)rootASTElement;
	} */

	public static @Nullable IParseResult decode(@NonNull String text) {
//		System.out.println("decode: " + text);
		Injector injector = MarkupStandaloneSetup.getInjector();
		MarkupParser parser = injector.getInstance(MarkupParser.class);
		Reader reader = new StringReader(text);
		return parser.parse(reader);
	}

	public static int getNewlineCount(@NonNull NewLineElement element) {
		int lineCount = 0;
		String s = element.getText();
		int iMax = s.length();
		for (int i = 0; i < iMax; ) {
			int c = s.charAt(i++);
			if (c == '\n') {
				lineCount++;
				if (i < iMax) {
					c = s.charAt(i);
					if (c == '\r') {
						i++;
					}
				}
			}
			else if (c == '\r') {
				lineCount++;
				if (i < iMax) {
					c = s.charAt(i);
					if (c == '\n') {
						i++;
					}
				}
			}
		}
		return lineCount;
	}

	public static String toHTML(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Object context, @NonNull Markup markup) throws Exception {
		return MarkupToHTML.toString(environmentFactory, context, markup);
	}
}

