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

import org.eclipse.ocl.xtext.markup.services.MarkupValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MarkupRuntimeModule extends AbstractMarkupRuntimeModule
{
	// DataType text to value parsing.
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return MarkupValueConverterService.class;
	}
}
