/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.model;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IDocument;

public interface ConsoleContext extends IDocument
{
//	ModelingLevel getModelingLevel();
	@Nullable EObject getOCLContext();
//	IOCLFactory<Object> getOCLFactory();
	@Nullable Map<String, EClassifier> getOCLParameters();
//	void setModelingLevel(ModelingLevel level);
	void setContext(@NonNull EClassifier context, @Nullable Map<String, EClassifier> parameters);
}