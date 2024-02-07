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
package org.eclipse.ocl.xtext.base.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * PivotResourceServiceProvider extends the DefaultResourceServiceProvider to ensure that
 * pivot: scheme URIs are handled by the primary language support rather than delegated
 * to one determined by the file extension.
 *
 * This was originally provided to make hover text work for pivot references.
 */
public class PivotResourceServiceProvider extends DefaultResourceServiceProvider
{
	@Override
	public boolean canHandle(URI uri) {
		if (PivotUtilInternal.isASURI(uri)) {
			return true;
		}
		else if ("oclstdlib".equals(uri.fileExtension())) {		// FIXME Use rather than fight Xtext
			return true;
		}
		else {
			return super.canHandle(uri);
		}
	}
}
