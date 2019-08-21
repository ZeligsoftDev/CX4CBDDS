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

import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.cx.deployment.treeeditor.DeploymentView;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.cx.deployment.treeeditor.providers.LeftTreeContentProvider;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;
import com.zeligsoft.cx.deployment.ui.commands.DeleteDeploymentPartCommand;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * This class implements the action to delete a part in the deployment tree
 * editor.
 * 
 * @author sduchesneau
 */
public class DeleteDeploymentPartAction
		extends Action
		implements ISelectionChangedListener {

	private DeploymentView view;

	private List<Property> selectedParts = new ArrayList<Property>();

	/**
	 * Constructor
	 * 
	 * @param viewer
	 * @param view	
	 */
	public DeleteDeploymentPartAction(List<TreeViewer> viewers, DeploymentView view) {
		super();
		ImageDescriptor image = PlatformUI.getWorkbench().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
		setImageDescriptor(image);
		setText(DeploymentEditorMessages.DeploymentFormPage_DeleteDlg);
		this.view = view;
		for (TreeViewer viewer : viewers) {
			viewer.addSelectionChangedListener(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		AbstractTransactionalCommand command = null;

		if (!selectedParts.isEmpty()) {
				command = new DeleteDeploymentPartCommand(
						view.getDeployment(),
						selectedParts,
						DeploymentEditorMessages.DeleteDeploymentPartActionHandler_DeletePartCmd);
		}

		if (command == null)
			return;

		view.remove(selectedParts);

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		} catch (Exception e) {
			Activator
					.getDefault()
					.error(
							DeploymentEditorMessages.DeleteDeploymentPartActionHandler_DeletePartErrorMsg,
							e);

			if (ZDeploymentUtil.getDeploymentParts(view.getDeployment()).contains(
					selectedParts))
				for (Property part : selectedParts) {
					view.add(part);
				}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selectedParts.clear();
		setEnabled(false);
		if(!(((TreeViewer)event.getSource()).getContentProvider() instanceof LeftTreeContentProvider)){
			return;
		}
		if (event.getSelection() instanceof IStructuredSelection) {

			Iterator itor = ((IStructuredSelection) event.getSelection()).iterator();
			while (itor.hasNext()) {
				Object selObject = itor.next();

				if (selObject instanceof Property) {
					selectedParts.add((Property) selObject);
					if (ZDeploymentUtil.getParentPart((Property) selObject) != null) {
						return;
					}
				}
			}
			setEnabled(true);
		}
	}
}
