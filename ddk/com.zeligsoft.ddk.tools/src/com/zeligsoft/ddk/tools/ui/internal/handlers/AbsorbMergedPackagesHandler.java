/*******************************************************************************
 * Copyright (c) 2021 Northrop Grumman Systems Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zeligsoft.ddk.tools.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

/**
 * Default command handler to Absorb PackageMerge elements directly into the referencing model.
 * For an input xxx.uml, produces an output xxx.merged.uml.
 *
 */
public class AbsorbMergedPackagesHandler extends AbstractHandler implements IHandler {

	private void logError(CoreException e) {
	    Bundle bundle = Platform.getBundle(com.zeligsoft.ddk.tools.Activator.PLUGIN_ID);
	    ILog log = Platform.getLog(bundle);
	    log.log(e.getStatus());
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		
		try {
			return new AbsorbMergedPackagesWorker(selection).doWork();
		} catch(CoreException e) {
			final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			if(e.getStatus().getSeverity() == IStatus.ERROR) {
				MessageDialog.openError(
						window.getShell(),
						Messages.AbsorbMergedPackagesHandler_DialogTitle,
						e.getStatus().getMessage());
				logError(e);
			} else if(e.getStatus().getSeverity() == IStatus.WARNING) {
				MessageDialog.openWarning(
						window.getShell(),
						Messages.AbsorbMergedPackagesHandler_DialogTitle,
						e.getStatus().getMessage());
			}
			return null;
		}
	}

}
