/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - revised from IActionDelegaye to IHandler
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.ui.actions;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.DebugVMUIPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

public abstract class AbstractVMBreakpointPropertiesHandler extends AbstractHandler
{
	/**
	 * Based on org.eclipse.debug.ui.actions.RulerBreakpointAction.getBreakpoint
	 */
	protected @Nullable VMLineBreakpoint getBreakpoint(@NonNull ExecutionEvent event) {
		IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		if (!(editorPart instanceof ITextEditor)) {
			return popUpError(event, "No ITextEditor", null);
		}
		ITextEditor textEditor = (ITextEditor)editorPart;
		IVerticalRulerInfo rulerInfo = editorPart.getAdapter(IVerticalRulerInfo.class);
		if (rulerInfo == null) {
			return popUpError(event, "No IVerticalRulerInfo", null);
		}
		IDocumentProvider documentProvider = textEditor.getDocumentProvider();
		IEditorInput editorInput = textEditor.getEditorInput();
		IAnnotationModel annotationModel = documentProvider.getAnnotationModel(editorInput);
		IDocument document = documentProvider.getDocument(editorInput);
		if (annotationModel != null) {
			Iterator<Annotation> iterator = annotationModel.getAnnotationIterator();
			while (iterator.hasNext()) {
				Annotation annot = iterator.next();
				if (annot instanceof SimpleMarkerAnnotation) {
					SimpleMarkerAnnotation markerAnnotation = (SimpleMarkerAnnotation) annot;
					IMarker marker = markerAnnotation.getMarker();
					try {
						if (marker.isSubtypeOf(IBreakpoint.BREAKPOINT_MARKER)) {
							Position position = annotationModel.getPosition(markerAnnotation);
							int line = document.getLineOfOffset(position.getOffset());
							if (line == rulerInfo.getLineOfLastMouseButtonActivity()) {
								IBreakpoint breakpoint = DebugPlugin.getDefault().getBreakpointManager().getBreakpoint(marker);
								if (breakpoint instanceof VMLineBreakpoint) {
									return (VMLineBreakpoint)breakpoint;
								}
							}
						}
					} catch (CoreException e) {
					} catch (BadLocationException e) {
					}
				}
			}
		}
		return popUpError(event, "No VMLineBreakpoint at selection", null);
	}

	protected <T> @Nullable T popUpError(@NonNull ExecutionEvent event, @NonNull String message, @Nullable IStatus s) {
		Shell shell = HandlerUtil.getActiveShell(event);
		if (shell != null) {
			DebugVMUIPlugin.errorDialog(shell, "Error", message, s);
		}
		return null;
	}
}