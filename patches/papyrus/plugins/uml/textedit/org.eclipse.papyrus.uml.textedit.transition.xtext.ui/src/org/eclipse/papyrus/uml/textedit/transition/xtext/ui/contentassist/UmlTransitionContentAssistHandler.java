/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contentassist;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.papyrus.uml.textedit.transition.xtext.ui.editor.ContextEditorUtil;
import org.eclipse.ui.ISources;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.handler.ContentAssistHandler;

public class UmlTransitionContentAssistHandler extends ContentAssistHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		new ContentAssistAction(XtextUIMessages.getResourceBundle(), "ContentAssistProposal.",
				ContextEditorUtil.currentEditor).run();
		return this;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		boolean contentAssistAvailable = false;
		if (evaluationContext instanceof IEvaluationContext) {
			Object var = ((IEvaluationContext) evaluationContext).getVariable(ISources.ACTIVE_EDITOR_NAME);
			// TODO: this is just for testing....
			var = ContextEditorUtil.currentEditor;
			// ////////////////////////////////////
			if (var instanceof XtextEditor) {
				contentAssistAvailable = ((XtextEditor) var).isContentAssistAvailable();
			}
		}
		super.setBaseEnabled(contentAssistAvailable);
		// super.setBaseEnabled(isEnabled() & contentAssistAvailable);
	}

}
