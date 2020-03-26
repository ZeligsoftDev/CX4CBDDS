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
package com.zeligsoft.cx.ui.actions;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.SynchronizableGmfDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.zeligsoft.base.ui.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Locate element on existing diagrams. The action will also open the diagram
 * and focus the corresponding edit part for the selected element.
 * 
 * @author ysroh
 * 
 */
public class LocateElementOnDiagram extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selectedEObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (selectedEObject == null) {
			return null;
		}
		Resource diagramResource = NotationUtils.getNotationResourceForDiagram(selectedEObject,
				TransactionUtil.getEditingDomain(selectedEObject));
		List<Diagram> diagrams = diagramResource.getContents().stream().filter(Diagram.class::isInstance)
				.map(Diagram.class::cast).collect(Collectors.toList());

		Diagram theDiagram = null;

		for (Diagram d : diagrams) {
			View v = (View) BaseDiagramUtil.findElementFromDiagram(d, selectedEObject);
			if (v != null) {
				theDiagram = d;
				break;
			}
		}

		if (theDiagram == null) {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.LocateElementInDiagram_DiagramTitle, Messages.LocateElementInDiagram_NotFoundMsg);
			return null;
		}

		if (!(HandlerUtil.getActiveEditor(event) instanceof IMultiDiagramEditor)) {
			return null;
		}

		IMultiDiagramEditor multiEditor = (IMultiDiagramEditor) HandlerUtil.getActiveEditor(event);
		ServicesRegistry serviceRegistry = multiEditor.getServicesRegistry();

		try {
			IPageManager pageManager = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
			if (pageManager.isOpen(theDiagram)) {
				pageManager.selectPage(theDiagram);
			} else {
				pageManager.openPage(theDiagram);
			}
		} catch (ServiceException e1) {
			ZeligsoftCXUIPlugin.getDefault().error(e1.getMessage(), e1);
			return null;
		}

		IEditorPart editor = multiEditor.getActiveEditor();
		if (editor instanceof SynchronizableGmfDiagramEditor) {
			SynchronizableGmfDiagramEditor syncEditor = (SynchronizableGmfDiagramEditor) multiEditor.getActiveEditor();
			syncEditor.revealElement(selectedEObject);
		}
		return null;

	}
}
