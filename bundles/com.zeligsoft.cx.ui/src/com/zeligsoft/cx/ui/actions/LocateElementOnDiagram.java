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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.services.editor.EditorService;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

import com.zeligsoft.base.diagram.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.l10n.Messages;

/**
 * Locate element on existing diagrams. The action will also open the diagram
 * and focus the corresponding edit part for the selected element.
 * 
 * @author ysroh
 * 
 */
public class LocateElementOnDiagram implements IViewActionDelegate {

	private EObject selectedEObject;

	@Override
	public void run(IAction action) {
		if (selectedEObject == null) {
			return;
		}
		EditPart part = null;
		Diagram diagram = null;
		List<Diagram> diagrams = new ArrayList<Diagram>();
		TreeIterator<EObject> itor = selectedEObject.eResource()
				.getAllContents();
		while (itor.hasNext()) {
			EObject o = itor.next();
			if (o instanceof EAnnotation) {
				if ("uml2.diagrams" //$NON-NLS-1$
				.equals(((EAnnotation) o).getSource())) {
					for (Object e : ((EAnnotation) o).getContents()) {
						if (o.eContainer() == selectedEObject.eContainer()) {
							diagrams.add(0, (Diagram) e);
						} else {
							diagrams.add((Diagram) e);
						}
					}
				}
			}
			if (!(o instanceof Package || o instanceof Component)
					|| o instanceof PackageImport) {
				itor.prune();
				continue;
			}
		}
		for (Diagram d : diagrams) {
			View v = (View) BaseDiagramUtil.findElementFromDiagram(d,
					selectedEObject);
			if (v != null) {
				if (v.getType() != null
						&& (v.getType().contains("InterfaceProvided") //$NON-NLS-1$
						|| v.getType().contains("InterfaceRequired"))) { //$NON-NLS-1$
					// don't select antennas
					continue;
				}
				diagram = d;
				break;
			}
		}

		if (diagram != null) {
			IDiagramWorkbenchPart editor = (IDiagramWorkbenchPart) EditorService
					.getInstance().openEditor(new DiagramEditorInput(diagram));
			if (editor != null) {
				part = BaseDiagramUtil.findEditPartFromEditor(editor,
						selectedEObject);
			}
		}
		if (part != null) {
			part.getViewer().setSelection(new StructuredSelection(part));
			part.getViewer().setFocus(part);
			part.getViewer().reveal(part);
			return;
		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				Messages.LocateElementInDiagram_DiagramTitle,
				Messages.LocateElementInDiagram_NotFoundMsg);

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		selectedEObject = BaseUIUtil.getEObjectFromSelection(selection);
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}
}
