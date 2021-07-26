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
package com.zeligsoft.domain.dds4ccm.ui.listeners;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Handle double click event to open Deployment
 * 
 * @author Young-Soo Roh
 *
 */
public class EditorPartListener implements IPartListener2 {

	private static IDoubleClickListener listener = new IDoubleClickListener() {

		@Override
		public void doubleClick(DoubleClickEvent event) {
			ISelection selection = event.getSelection();
			EObject eObject = BaseUIUtil.getEObjectFromSelection(selection);

			if (eObject == null || !ZDLUtil.isZDLConcept(eObject, ZMLMMNames.DEPLOYMENT)) {
				return;
			}

			IEditorPart editor = BaseUIUtil.getActivepage().getActiveEditor();

			if(editor == null) {
				return;
			}
			ServicesRegistry serviceRegistry = null;
			if (editor instanceof IMultiDiagramEditor) {
				IMultiDiagramEditor multiEditor = (IMultiDiagramEditor) editor;
				serviceRegistry = multiEditor.getServicesRegistry();
			} else {
				return;
			}

			if(serviceRegistry == null) {
				return;
			}
			try {
				IPageManager pageManager = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
				if (pageManager.isOpen(eObject)) {
					pageManager.selectPage(eObject);
				} else {
					pageManager.openPage(eObject);
				}
			} catch (ServiceException e1) {
				// do nothing
			}
		}
	};

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		// Add double click listener to model explorer tree
		// when new Papyrus model editor is open
		ModelExplorerView view = (ModelExplorerView) BaseUIUtil.getModelExplorerViewPart();
		if (view == null) {
			return;
		}
		view.getCommonViewer().addDoubleClickListener(listener);

	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {

	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {

	}

}
