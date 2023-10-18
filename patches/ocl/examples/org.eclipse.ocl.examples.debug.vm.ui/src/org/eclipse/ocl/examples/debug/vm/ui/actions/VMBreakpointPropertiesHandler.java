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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.handlers.HandlerUtil;

public class VMBreakpointPropertiesHandler extends AbstractVMBreakpointPropertiesHandler
{
	protected static class BreakpointSelectionProvider implements ISelectionProvider
	{
		private final @NonNull VMLineBreakpoint breakpoint;

		protected BreakpointSelectionProvider(@NonNull VMLineBreakpoint breakpoint) {
			this.breakpoint = breakpoint;
		}

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {}

		@Override
		public ISelection getSelection() {
			return new StructuredSelection(breakpoint);
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {}

		@Override
		public void setSelection(ISelection selection) {}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		assert event != null;
		VMLineBreakpoint breakpoint = getBreakpoint(event);
		if (breakpoint == null) {
			return null;
		}
		IShellProvider shellProvider = HandlerUtil.getActiveSite(event);
		if (shellProvider == null) {
			return popUpError(event, "No IShellProvider", null);
		}
		BreakpointSelectionProvider breakpointSelectionProvider = new BreakpointSelectionProvider(breakpoint);
		PropertyDialogAction propertyAction = new PropertyDialogAction(shellProvider, breakpointSelectionProvider);
		propertyAction.run();
		return null;
	}
}