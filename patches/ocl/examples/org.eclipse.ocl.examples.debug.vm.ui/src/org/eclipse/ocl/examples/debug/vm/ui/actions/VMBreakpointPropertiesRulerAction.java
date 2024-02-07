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

import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.actions.RulerBreakpointAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ocl.examples.debug.vm.ui.messages.DebugVMUIMessages;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;

@Deprecated /* @deprecated Use VMBreakpointPropertiesHandler */
public class VMBreakpointPropertiesRulerAction extends RulerBreakpointAction implements IUpdate {

	private IBreakpoint fBreakpoint;

	public VMBreakpointPropertiesRulerAction(ITextEditor editor, IVerticalRulerInfo info) {
		super(editor, info);
		setText(DebugVMUIMessages.BreakpointProperties_RulerActionLabel);
	}

	@Override
	public void run() {
		if (getBreakpoint() != null) {
			PropertyDialogAction action=
					new PropertyDialogAction(getEditor().getEditorSite(), new ISelectionProvider() {
						@Override
						public void addSelectionChangedListener(ISelectionChangedListener listener) {
						}
						@Override
						public ISelection getSelection() {
							return new StructuredSelection(getBreakpoint());
						}
						@Override
						public void removeSelectionChangedListener(ISelectionChangedListener listener) {
						}
						@Override
						public void setSelection(ISelection selection) {
						}
					});
			action.run();
		}
	}

	/**
	 * @see IUpdate#update()
	 */
	@Override
	public void update() {
		fBreakpoint = null;
		IBreakpoint breakpoint = getBreakpoint();
		if (breakpoint != null && (breakpoint instanceof VMLineBreakpoint)) {
			fBreakpoint = breakpoint;
		}
		setEnabled(fBreakpoint != null);
	}
}