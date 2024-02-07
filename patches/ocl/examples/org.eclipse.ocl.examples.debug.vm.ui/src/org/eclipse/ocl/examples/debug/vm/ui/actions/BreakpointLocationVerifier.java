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

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.LineNumberProvider;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IEditorStatusLine;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public abstract class BreakpointLocationVerifier {

	private static @NonNull LineNumberProvider getLineNumberProvider(final @NonNull IDocument doc) {

		return new LineNumberProvider() {

			@Override
			public int getLineNumber(int offset) {
				try {
					return doc.getLineOfOffset(offset) + 1;
				} catch (BadLocationException e) {
					return -1;
				}
			}

			@Override
			public int getLineEnd(int lineNumber) {
				try {
					IRegion lineInfo = doc.getLineInformation(lineNumber);
					return lineInfo.getOffset() + lineInfo.getLength();
				} catch (BadLocationException e) {
					return -1;
				}
			}

			@Override
			public int getLineCount() {
				return doc.getNumberOfLines();
			}
		};
	}

	//	private static final int GET_AST_TIMEOUT = 10 * 1000;

	private final @NonNull ILineBreakpoint fBreakpoint;
	private final @NonNull ITextEditor fEditor;
	private final @NonNull String fInvalidLocationMessage;

	protected BreakpointLocationVerifier(@NonNull ITextEditor editor, @NonNull ILineBreakpoint breakpoint, @NonNull String invalidLocationMessage) {
		fEditor = editor;
		fBreakpoint = breakpoint;
		fInvalidLocationMessage = invalidLocationMessage;
	}

	@NonNull IStatus run()  {
		@NonNull IStatus status = checkBreakpointableElements();
		if(!status.isOK()) {
			if (fBreakpoint != null) {
				try {
					DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(fBreakpoint, true);
				} catch (CoreException e) {
					DebugVMUIPlugin.log(e.getStatus());
				}
			}
		}
		return status;
	}

	private @NonNull IStatus checkBreakpointableElements()  {
		int lineNumber;
		try {
			lineNumber = fBreakpoint.getLineNumber();
		} catch (CoreException e) {
			return e.getStatus();
		}

		IDocumentProvider docProvider = fEditor.getDocumentProvider();
		if(docProvider == null) {
			return canceled();
		}

		IDocument doc = docProvider.getDocument(fEditor.getEditorInput());
		if(doc == null) {
			return canceled();
		}
		Model root = ((XtextDocument)doc).readOnly(new IUnitOfWork<Model, XtextResource>()
		{
			@Override
			public Model exec(@Nullable XtextResource state) throws Exception {
				if (state instanceof BaseCSResource) {
					BaseCSResource csResource = (BaseCSResource)state;
					CS2AS cs2as = csResource.findCS2AS();
					if (cs2as != null) {
						ASResource asResource = cs2as.getASResource();
						if ((asResource != null) && (asResource.getContents().size() > 0)) {
							EObject eObject = asResource.getContents().get(0);
							if (eObject instanceof Model) {
								return (Model)eObject;
							}
						}
					}
				}
				return null;
			}
		});
		CompiledUnit compilationUnit = root != null ? new CompiledUnit(root) : null;
		if(compilationUnit == null) {
			return DebugVMUIPlugin.createErrorStatus("Failed to obtain AST"); //$NON-NLS-1$
		}

		List<Element> elements = getValidBreakpointLocator()
				.getBreakpointableElementsForLine(compilationUnit, getLineNumberProvider(doc), lineNumber);
		if (elements.isEmpty()) {
			report(NLS.bind(fInvalidLocationMessage, Integer.valueOf(lineNumber)));
			return canceled();
		}

		return Status.OK_STATUS;
	}

	protected abstract @NonNull ValidBreakpointLocator getValidBreakpointLocator();

	/**
	 * Reports any status to the current active workbench shell
	 * @param message the message to display
	 */
	protected void report(final String message) {
		DebugVMUIPlugin.getStandardDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				@Nullable IEditorStatusLine statusLine = fEditor.getAdapter(IEditorStatusLine.class);
				if (statusLine != null) {
					statusLine.setMessage(true, message, null);
				}
				if (message != null && DebugVMUIPlugin.getActiveWorkbenchShell() != null) {
					Display.getCurrent().beep();
				}
			}
		});
	}

	private @NonNull IStatus canceled() {
		return DebugVMUIPlugin.createStatus(IStatus.CANCEL, fInvalidLocationMessage);
	}
}