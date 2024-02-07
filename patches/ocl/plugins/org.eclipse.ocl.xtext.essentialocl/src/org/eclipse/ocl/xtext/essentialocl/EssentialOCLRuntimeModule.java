/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.xtext.base.services.RetokenizingTokenSource;
import org.eclipse.ocl.xtext.essentialocl.parser.antlr.EssentialOCLParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLRuntimeModule extends org.eclipse.ocl.xtext.essentialocl.AbstractEssentialOCLRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingEssentialOCLParser.class;
	}

	public static long enterRuleCounter = 0;

	public static class RetokenizingEssentialOCLParser extends EssentialOCLParser
	{
		@Override
		protected org.eclipse.ocl.xtext.essentialocl.parser.antlr.internal.InternalEssentialOCLParser createParser(XtextTokenStream stream) {
			return new org.eclipse.ocl.xtext.essentialocl.parser.antlr.internal.InternalEssentialOCLParser(stream, getGrammarAccess())
			{
				@Override
				protected void enterRule() {
					enterRuleCounter++;
					super.enterRule();
				}

			};
		}

		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}
}
