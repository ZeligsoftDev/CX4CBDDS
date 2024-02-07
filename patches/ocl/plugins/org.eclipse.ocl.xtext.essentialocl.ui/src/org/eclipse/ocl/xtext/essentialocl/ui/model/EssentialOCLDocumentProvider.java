/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialocl.ui.model;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.model.BaseDocumentProvider;

/**
 * @deprecated no longer used - retained for API compatibility
 */
@Deprecated
public class EssentialOCLDocumentProvider extends BaseDocumentProvider
{
	@Override
	protected @NonNull String getPleaseWaitText() {
		return "0" + super.getPleaseWaitText();
	}
}
