/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
package com.zeligsoft.ddk.zdl.zdlgen.presentation.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionDelegate;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainConcept;
import com.zeligsoft.ddk.zdl.zdlgen.presentation.ZDLGenEditor;

public abstract class AbstractGenDomainConceptActionDelegate extends
		ActionDelegate implements IEditorActionDelegate {

	protected IWorkbenchPart myPart;
	protected List<GenDomainConcept> concepts = null;

	public AbstractGenDomainConceptActionDelegate() {
		super();
	}
	
	protected abstract Command getCommandToRun();
	
	@Override
	public void run(IAction action) {
		
		EditingDomain editingDomain = getEditingDomain();
		Command cc = getCommandToRun();
		
		editingDomain.getCommandStack().execute(cc);
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		myPart = targetEditor;
	}

	protected Shell getShell() {
		return (myPart == null)
			? Display.getDefault().getActiveShell()
			: myPart.getSite().getShell();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection =
				(IStructuredSelection) selection;
			concepts = new ArrayList<GenDomainConcept>();
			for(Object element : structuredSelection.toList()) {
				if(element instanceof GenDomainConcept) {
					concepts.add((GenDomainConcept) element);
				}
			}
		}
	}
	
	protected ZDLGenEditor getEditor() {
		return (ZDLGenEditor) myPart;
	}
	
	protected EditingDomain getEditingDomain() {
		return getEditor().getEditingDomain();
	}

}