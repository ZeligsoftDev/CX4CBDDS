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

package org.eclipse.ocl.xtext.oclstdlib;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.xtext.base.services.RetokenizingTokenSource;
import org.eclipse.ocl.xtext.oclstdlib.parser.antlr.OCLstdlibParser;
import org.eclipse.ocl.xtext.oclstdlib.scoping.OCLstdlibScopeProvider;
import org.eclipse.ocl.xtext.oclstdlib.services.OCLstdlibValueConverterService;
import org.eclipse.ocl.xtext.oclstdlib.utilities.OCLstdlibCSResource;
import org.eclipse.ocl.xtext.oclstdlib.validation.OCLstdlibCompositeEValidator;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.CompositeEValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLstdlibRuntimeModule extends org.eclipse.ocl.xtext.oclstdlib.AbstractOCLstdlibRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	public Class<? extends CompositeEValidator> bindCompositeEValidator() {
		return OCLstdlibCompositeEValidator.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingOCLstdlibParser.class;
	}

	public static class RetokenizingOCLstdlibParser extends OCLstdlibParser
	{
		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return OCLstdlibValueConverterService.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return OCLstdlibScopeProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return OCLstdlibCSResource.class;
	}
}
