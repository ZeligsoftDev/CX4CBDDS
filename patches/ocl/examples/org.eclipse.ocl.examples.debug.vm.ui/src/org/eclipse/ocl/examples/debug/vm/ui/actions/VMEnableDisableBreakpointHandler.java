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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class VMEnableDisableBreakpointHandler extends AbstractVMBreakpointPropertiesHandler
{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		assert event != null;
		VMLineBreakpoint breakpoint = getBreakpoint(event);
		if (breakpoint == null) {
			return null;
		}
		try {
			breakpoint.setEnabled(!breakpoint.isEnabled());
		} catch (CoreException e) {
			Shell shell = HandlerUtil.getActiveShell(event);
			if (shell != null) {
				return popUpError(event, "Failed to enable/disable breakpoint", e.getStatus());
			}
		}
		return null;
	}
}