/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.completeocl.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.serializer.BaseHiddenTokenSequencer;

public class CompleteOCLHiddenTokenSequencer extends BaseHiddenTokenSequencer
{
	@Override
	protected String getCommentIndent(EObject semanticChild) {
		return "\t";
	}
}
