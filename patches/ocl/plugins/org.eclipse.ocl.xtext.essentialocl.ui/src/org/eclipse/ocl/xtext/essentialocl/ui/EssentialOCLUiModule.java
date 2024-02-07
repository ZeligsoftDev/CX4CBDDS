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
package org.eclipse.ocl.xtext.essentialocl.ui;

import org.eclipse.ocl.xtext.base.ui.model.BaseDocumentProvider;
import org.eclipse.ocl.xtext.essentialocl.ui.internal.EssentialOCLActivator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLUiModule extends org.eclipse.ocl.xtext.essentialocl.ui.AbstractEssentialOCLUiModule
{
	public static final String EDITOR_ID = EssentialOCLActivator.ORG_ECLIPSE_OCL_XTEXT_ESSENTIALOCL_ESSENTIALOCL;

	public EssentialOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return BaseDocumentProvider.class;
	}
}
