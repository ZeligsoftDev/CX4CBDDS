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
package org.eclipse.ocl.xtext.oclinecore;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.xtext.base.services.RetokenizingTokenSource;
import org.eclipse.ocl.xtext.base.utilities.AbstractGrammarResource;
import org.eclipse.ocl.xtext.oclinecore.parser.antlr.OCLinEcoreParser;
import org.eclipse.ocl.xtext.oclinecore.services.OCLinEcoreValueConverterService;
import org.eclipse.ocl.xtext.oclinecore.utilities.OCLinEcoreCSResource;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.GrammarProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreRuntimeModule extends AbstractOCLinEcoreRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingOCLinEcoreParser.class;
	}

	public static class RetokenizingOCLinEcoreParser extends OCLinEcoreParser
	{
		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return OCLinEcoreValueConverterService.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return OCLinEcoreCSResource.class;
	}

	@Override
	public Class<? extends GrammarProvider> bindGrammarProvider() {
		return OCLinEcoreGrammarResource.GrammarProvider.class;
	}

	public Class<? extends AbstractGrammarResource> bindAbstractGrammarResource() {
		return OCLinEcoreGrammarResource.class;
	}
}
