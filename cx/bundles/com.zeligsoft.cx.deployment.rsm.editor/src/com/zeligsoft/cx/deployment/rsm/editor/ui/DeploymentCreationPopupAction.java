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

package com.zeligsoft.cx.deployment.rsm.editor.ui;


import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.uml2.uml.Component;

import com.ibm.xtools.uml.navigator.ModelServerElement;
import com.zeligsoft.cx.deployment.rsm.editor.DeploymentEditorInput;

/**
 *  This class implements the action to call the deployment table editor with the correct deployment input.  It is called from the 
 *  popup menu.
 *  
 *  @author sduchesneau
 */
public class DeploymentCreationPopupAction implements IObjectActionDelegate
{
	IWorkbenchPart workbenchPart;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{
		workbenchPart = targetPart;
	}

	public void run(IAction action)
	{
	
		IWorkbenchPartSite site = workbenchPart.getSite();

		// we need selection provider to find the name of the deployment
		ISelectionProvider selectionProvider = site.getSelectionProvider();
		
		if (!(selectionProvider.getSelection() instanceof TreeSelection))
			return;
		
		TreeSelection treeSelection = (TreeSelection) selectionProvider.getSelection();				
		
		if (!(treeSelection.getFirstElement() instanceof ModelServerElement))
			return;
		
		ModelServerElement serverElement = (ModelServerElement) treeSelection.getFirstElement();
			
		if (!(serverElement.getElement() instanceof Component))
			return;

		// here we have the deployment
		Component element = (Component) serverElement.getElement();
		
		// we set the input of the deployment table editor
		DeploymentEditorInput input = new DeploymentEditorInput();
		input.setName(element.getName());
		input.setToolTipText(element.getName());
		input.setDeployment(element);
		
		// we find the workbench window, then the right page, then we open the editor.
		IWorkbenchWindow window = site.getWorkbenchWindow();
		IWorkbenchPage workbenchPage = window.getActivePage();		
		
		try
		{
			workbenchPage.openEditor(input, "com.zeligsoft.cx.deployment.rsm.editor");
		}
		catch (Exception ex)
		{
			// I don't care			
		}	
	}

	public void selectionChanged(IAction action, ISelection selection)
	{
		// TODO Auto-generated method stub
		
	}

}
