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

package com.zeligsoft.cx.deployment.treeeditor.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * Action to show the selected item from the configure pane in the deploy pane.
 * 
 * @author ysroh
 * 
 */
public class ShowInDeployPaneAction extends Action implements
		ISelectionChangedListener {

	private TreeViewer leftTreeViewer;

	private TreeViewer rightTreeViewer;

	/**
	 * constructor
	 * 
	 * @param leftTreeViewer
	 * @param rightTreeViewer
	 */
	public ShowInDeployPaneAction(TreeViewer leftTreeViewer,
			TreeViewer rightTreeViewer) {
		super();
		setText(DeploymentEditorMessages.ShowInDeployPaneAction_ShowInDeployPaneActionLabel);
		this.leftTreeViewer = leftTreeViewer;
		this.rightTreeViewer = rightTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		rightTreeViewer.expandAll();
		rightTreeViewer.setSelection(leftTreeViewer.getSelection());
		rightTreeViewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		setEnabled(false);
		TreeSelection selection = (TreeSelection)event.getSelection();
		if(selection != null && !selection.isEmpty()){
			Property part = (Property) selection.iterator().next();
			if(ZDeploymentUtil.getDeploymentTargetPart(part) != null){
				// enable action if deployed
				setEnabled(true);
			}
		}
	}
}
