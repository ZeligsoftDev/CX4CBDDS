/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Ed Seidewitz (MDS) - Initial implementation
 *  Jérémie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import org.eclipse.xtext.parser.IParser;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.service.SingletonBinding;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class AlfRuntimeModule extends org.eclipse.papyrus.uml.alf.AbstractAlfRuntimeModule {

	/**
	 * Returns a parser which takes advantage of entry rules changes
	 */
	@Override
	public Class<? extends IParser> bindIParser() {
		return org.eclipse.papyrus.uml.alf.parser.antlr.MutableAlfParser.class;
	}

	@SingletonBinding
	@Override
	public Class<? extends Diagnostician> bindDiagnostician() {
		return CachingDiagnostician.class;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(
				org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).
				to(false);
	}
}
