/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Interface allows adapting of a compiled Module to its source information.
 */
public interface IModuleSourceInfo {
	/**
	 * Gets the name of the module source file.
	 * @return the name string
	 */
	@Nullable URI getSourceURI();
		
	/**
	 * Gets the line number provider operating on the module source contents.
	 * @return the provider instance
	 */
	@NonNull LineNumberProvider getLineNumberProvider();
}