/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.library;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.PivotPlugin;

public interface LibraryConstants
{
	static final @NonNull URI GEN_MODEL_URI = URI.createPlatformPluginURI("/" + PivotPlugin.PLUGIN_ID + "/model/oclstdlib.genmodel", true); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 *	The URI of this Standard Library.
	 */
	public static final @NonNull String STDLIB_URI = "http://www.eclipse.org/ocl/2015/Library"; //$NON-NLS-1$

	/**
	 *	The URI of the Ecore serialization of this Standard Library.
	 */
	//	@SuppressWarnings("null")
	//	public static final @NonNull URI ECORE_STDLIB_URI = URI.createPlatformPluginURI("/" + PLUGIN_ID + "/model-gen/OCL-2.5.ecore", true); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 *	The xmi:id prefix of library elements.
	 */
	//	public static final @NonNull String ECORE_STDLIB_PREFIX = "OCL_E"; //$NON-NLS-1$

	static final @NonNull String COMPARE_TO = "compareTo"; //$NON-NLS-1$
}
