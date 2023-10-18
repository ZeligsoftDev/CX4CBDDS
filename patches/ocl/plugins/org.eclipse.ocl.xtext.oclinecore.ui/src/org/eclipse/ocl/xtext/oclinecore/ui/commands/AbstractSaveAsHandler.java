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
package org.eclipse.ocl.xtext.oclinecore.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ocl.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class AbstractSaveAsHandler extends AbstractHandler
{
	protected final String persistAs;

	public AbstractSaveAsHandler(String persistAs) {
		this.persistAs = persistAs;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (!(editor instanceof XtextEditor)) {
			return null;
		}
		IDocumentProvider documentProvider = ((XtextEditor)editor).getDocumentProvider();
		if (!(documentProvider instanceof OCLinEcoreDocumentProvider)) {
			return null;
		}
		((OCLinEcoreDocumentProvider)documentProvider).setPersistAs(editor.getEditorInput(), persistAs);
		editor.doSaveAs();
		return null;
	}

}
