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
package org.eclipse.ocl.xtext.completeocl;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.xtext.base.services.RetokenizingTokenSource;
import org.eclipse.ocl.xtext.completeocl.parser.antlr.CompleteOCLParser;
import org.eclipse.ocl.xtext.completeocl.scoping.CompleteOCLScopeProvider;
import org.eclipse.ocl.xtext.completeocl.services.CompleteOCLHiddenTokenSequencer;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLCSResource;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLRuntimeModule extends org.eclipse.ocl.xtext.completeocl.AbstractCompleteOCLRuntimeModule
{
	public static final String LANGUAGE_ID = "org.eclipse.ocl.xtext.completeocl.CompleteOCL";


	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	@SuppressWarnings("restriction")
	@Override
	public Class<? extends org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer> bindIHiddenTokenSequencer() {
		return CompleteOCLHiddenTokenSequencer.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingCompleteOCLParser.class;
	}

	public static class RetokenizingCompleteOCLParser extends CompleteOCLParser
	{
		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return CompleteOCLScopeProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return CompleteOCLCSResource.class;
	}
}
