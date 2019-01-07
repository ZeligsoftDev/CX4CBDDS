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
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;

public class ExpandAllAction
		extends Action
		implements ISelectionChangedListener{

	private TreeViewer viewer;

	/**
	 * Constructor
	 * 
	 * @param viewer
	 * @param view	
	 */
	public ExpandAllAction(TreeViewer viewer) {
		super();
		setText(DeploymentEditorMessages.DeploymentFormPage_ExpandAllDlg);
		this.viewer = viewer;
		viewer.addSelectionChangedListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		Property selectedElement = null;

		if (viewer.getSelection() instanceof IStructuredSelection) {
			Object selObject = ((IStructuredSelection) viewer.getSelection())
				.getFirstElement();

			if (selObject instanceof Property) {
				selectedElement = (Property) selObject;
				viewer.expandToLevel(selectedElement,
					AbstractTreeViewer.ALL_LEVELS);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {

		if (event.getSelection() instanceof TreeItem) {
			TreeItem selectedTreeItem = (TreeItem) event.getSelection();

			boolean enabled = false;
			if (selectedTreeItem.getItemCount() > 0)
				enabled = true;

			setEnabled(enabled);
		}
	}	
}
