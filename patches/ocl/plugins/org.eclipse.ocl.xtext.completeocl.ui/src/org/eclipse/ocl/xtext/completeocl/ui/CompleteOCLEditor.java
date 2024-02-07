/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.ocl.xtext.completeocl.ui.internal.CompleteOCLActivator;

public class CompleteOCLEditor extends BaseEditor
{
	public static final String EDITOR_ID = CompleteOCLActivator.ORG_ECLIPSE_OCL_XTEXT_COMPLETEOCL_COMPLETEOCL;

	public CompleteOCLEditor() {
		super();
	}

	@Override
	public @NonNull String getMarkerId() {
		return CompleteOCLUiModule.MARKER_ID;
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId("#CompleteOCLEditorContext"); //$NON-NLS-1$
		setRulerContextMenuId("#CompleteOCLRulerContext"); //$NON-NLS-1$
		//		setHelpContextId(ITextEditorHelpContextIds.TEXT_EDITOR);
	}
}