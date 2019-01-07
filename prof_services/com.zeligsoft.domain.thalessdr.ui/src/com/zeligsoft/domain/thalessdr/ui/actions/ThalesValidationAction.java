/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.domain.thalessdr.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.zeligsoft.base.ui.utils.BaseUtil;
import com.zeligsoft.domain.thalessdr.ui.ThalesUIPlugin;
import com.zeligsoft.domain.thalessdr.ui.li0n.ThalesMessages;
import com.zeligsoft.domain.thalessdr.validation.ThalesValidationController;

/**
 * 
 * @author smcfee
 *
 */
public class ThalesValidationAction implements IObjectActionDelegate {

	protected IWorkbenchPart myPart;
	
	private ISelection selection;
	
	
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {		
				
		try {
			
			final IBatchValidator validator = ThalesValidationController.getValidator();
			IRunnableWithProgress op = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					
					validator.validate(BaseUtil.getEObjectsFromSelection(selection), monitor);
				}
				
			};
			new ProgressMonitorDialog(myPart.getSite().getShell()).run(true, true, op);
			} catch (InvocationTargetException e) {
				ThalesUIPlugin.getDefault().error(
					ThalesMessages.ValidateAction_ValidateFailed, e);
				return;
			} catch (InterruptedException e) {
				// The user canceled.
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
