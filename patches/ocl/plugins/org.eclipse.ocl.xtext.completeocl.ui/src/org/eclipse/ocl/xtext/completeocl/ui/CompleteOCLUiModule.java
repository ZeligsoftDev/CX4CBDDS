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
package org.eclipse.ocl.xtext.completeocl.ui;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.completeocl.ui.internal.CompleteOCLActivator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLUiModule extends AbstractCompleteOCLUiModule
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.ocl.xtext.completeocl.ui";
	public static final @NonNull String EDITOR_ID = CompleteOCLActivator.ORG_ECLIPSE_OCL_XTEXT_COMPLETEOCL_COMPLETEOCL;
	public static final @NonNull String MARKER_ID = "org.eclipse.ocl.xtext.completeocl.ui.Marker";

	public CompleteOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return CompleteOCLDocumentProvider.class;
	}
}
