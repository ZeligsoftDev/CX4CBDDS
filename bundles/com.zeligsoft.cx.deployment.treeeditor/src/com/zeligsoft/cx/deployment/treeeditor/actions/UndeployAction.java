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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

public class UndeployAction
		extends Action 
		implements ISelectionChangedListener{

	private DeploymentView view;

	private Viewer viewer;

	/**
	 * Constructor
	 * 
	 * @param viewer
	 * @param view	
	 */
	public UndeployAction(Viewer viewer, DeploymentView view) {
		super();
		setText(DeploymentEditorMessages.DeploymentFormPage_UndeployDlg);
		this.view = view;
		this.viewer = viewer;
		viewer.addSelectionChangedListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {

		if (viewer.getSelection() instanceof IStructuredSelection) {
			List<Property> partsToRemove = new ArrayList<Property>();
			Iterator itor = ((IStructuredSelection) viewer.getSelection()).iterator();
			while (itor.hasNext()) {
				Object selObject = itor.next();

				if (selObject instanceof Property) {
					partsToRemove.add((Property) selObject);
				}
			}

			try {
				view.remove(partsToRemove);
				view.undeploy(partsToRemove);
				viewer.setSelection(viewer.getSelection());
			} catch (Exception e) {
				Activator.getDefault().error(
						DeploymentEditorMessages.UndeployActionHandler_UndeployErrorMsg,
						e);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public void selectionChanged(SelectionChangedEvent event) {
		setEnabled(false);

		if (event.getSelection() instanceof IStructuredSelection) {
			Iterator itor = ((IStructuredSelection) viewer.getSelection()).iterator();
			while (itor.hasNext()) {
				Object selObject = itor.next();

				if (selObject instanceof Property) {
					Property selectedElement = (Property) selObject;
					if (ZDeploymentUtil.getDeploymentTargetPart(selectedElement) == null)
						return;
				}
			}
			setEnabled(true);
		}
	}
}
