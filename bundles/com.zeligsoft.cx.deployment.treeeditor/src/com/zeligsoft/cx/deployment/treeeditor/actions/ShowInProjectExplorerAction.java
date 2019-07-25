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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.deployment.treeeditor.l10n.DeploymentEditorMessages;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;

/**
 * Action to show the selected Deployment Tree Editor item in the Project Explorer.
 * 
 * @author schafe
 *
 */
public class ShowInProjectExplorerAction
		extends Action {

	private TreeViewer treeViewer;

	private IWorkbenchWindow window;

	/**
	 * Constructor
	 * 
	 * @param IWorkbenchWindow window
	 * @param TreeViewer viewer
	 */
	public ShowInProjectExplorerAction(IWorkbenchWindow window,
			TreeViewer viewer) {
		super();
		setText(DeploymentEditorMessages.ShowInProjectExplorerAction_text);
		this.window = window;
		this.treeViewer = viewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return;
		}
		IWorkbenchPart sourcePart = page.getActivePart();
		if (sourcePart == null) {
			return;
		}

		if (sourcePart instanceof IEditorPart) {

			IStructuredSelection selection = (IStructuredSelection) treeViewer
				.getSelection();
			List<EObject> elements = new ArrayList<EObject>();
			for (Object selectedItem : selection.toList()) {
				// The selectedItems are expected to be of type Property
				if (selectedItem instanceof Property) {
					NamedElement modelElement = ZDeploymentUtil
							.getModelElement((Property) selectedItem);
					if (modelElement == null) {
						continue;
					}					
					elements.add(modelElement);
				}
			}
			BaseUIUtil.showInProjectExplorer(elements);
		}
	}
}
