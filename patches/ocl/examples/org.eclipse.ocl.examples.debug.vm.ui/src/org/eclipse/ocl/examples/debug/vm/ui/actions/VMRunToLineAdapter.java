/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.ui.actions.IRunToLineTarget;
import org.eclipse.debug.ui.actions.RunToLineHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugElement;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.examples.debug.vm.ui.messages.DebugVMUIMessages;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;


public abstract class VMRunToLineAdapter implements IRunToLineTarget
{
	@Override
	public void runToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) throws CoreException {
		IEditorPart editorPart = (IEditorPart)part;
		IEditorInput input = editorPart.getEditorInput();
		if(input == null) {
			throw new CoreException(DebugVMUIPlugin.createErrorStatus(DebugVMUIMessages.RunToLineAdapter_NoInput));
		}

		ITextEditor textEditor = (ITextEditor)editorPart;
		IDocumentProvider provider = textEditor.getDocumentProvider();
		IDocument document = provider.getDocument(input);
		if(document == null) {
			throw new CoreException(DebugVMUIPlugin.createErrorStatus(DebugVMUIMessages.RunToLineAdapter_NoDocument));
		}

		@Nullable IFile file = input.getAdapter(IFile.class);
		boolean isNull = file == null;			// FIXME BUG 485093
		if (isNull) {
			throw new CoreException(DebugVMUIPlugin.createErrorStatus(DebugVMUIMessages.RunToLineAdapter_NoFile));
		}

		ITextSelection textSelection = (ITextSelection) selection;
		int lineNumber = textSelection.getStartLine() + 1;

		URI resourceURI = VMDebugCore.getResourceURI(file);
		VMLineBreakpoint vmBreakpoint = createRunToLineBreakpoint(resourceURI, lineNumber);

		String invalidLocationMessage = DebugVMUIMessages.RunToLineAdapter_invalidLocation;
		assert invalidLocationMessage != null;
		IStatus verifyStatus = createBreakpointLocationVerifier(textEditor, vmBreakpoint, invalidLocationMessage).run();
		if(!verifyStatus.isOK()) {
			new ErrorDialog(part.getSite().getShell(), null,
					DebugVMUIMessages.RunToLineAdapter_runFailed, verifyStatus, IStatus.CANCEL).open();
			return;
		}


		IAdaptable adaptableTarget = (IAdaptable)target;
		@Nullable IDebugTarget debugTarget = adaptableTarget.getAdapter(IDebugTarget.class);
		if (debugTarget != null) {
			RunToLineHandler handler = new RunToLineHandler(debugTarget, target, vmBreakpoint);
			handler.run(new NullProgressMonitor());
			return;
		}
	}

	@Override
	public boolean canRunToLine(IWorkbenchPart part, ISelection selection, ISuspendResume target) {
		return (target instanceof VMDebugElement);
	}

	protected abstract @NonNull BreakpointLocationVerifier createBreakpointLocationVerifier(@NonNull ITextEditor textEditor,
			@NonNull VMLineBreakpoint vmBreakpoint, @NonNull String invalidLocationMessage);

	protected abstract @NonNull VMLineBreakpoint createRunToLineBreakpoint(@NonNull URI resourceURI, int lineNumber) throws CoreException;
}
