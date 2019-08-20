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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.ui.action.AbstractModelActionDelegate;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.uml.type.UMLElementFactory;
import com.zeligsoft.base.diagram.utils.BaseDiagramUtil;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;

public class AddStructureDiagramActionDelegate extends AbstractModelActionDelegate
		implements IViewActionDelegate {

	@Override
	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getSelectedElement());
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		ICommand command = UMLElementFactory.getCreateElementCommand(
				getSelectedElement(), ElementTypeRegistry.getInstance().getType(
						"org.eclipse.gmf.runtime.notation.structureDiagram")); //$NON-NLS-1$
		try {
			command.execute(null, null);
		} catch (ExecutionException e) {
			ZeligsoftCXUIPlugin.getDefault().error(
					"Failed to create a structure diagram", e); //$NON-NLS-1$
		}
		CommandResult result = command.getCommandResult();

		if (result != null && result.getReturnValue() instanceof Diagram) {
			EObject model = EcoreUtil.getRootContainer(getSelectedElement());
			if (model instanceof Package) {
				String dpi = BaseDiagramUtil
						.getDPIFromAnnotation((Package) model);
				if (UMLUtil.isEmpty(dpi)) {
					BaseDiagramUtil.saveDPIAnnotation((Package) model);
				}
			}
			postElementCreation((Diagram) result.getReturnValue());
		}
	}

	protected void postElementCreation(final Diagram newDiagram) {
		try {

			getEditingDomain().runExclusive(new Runnable() {

				@Override
				public void run() {
					try {
						IDiagramEditorInput diagramInput = new DiagramEditorInput(
								newDiagram);

						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().openEditor(diagramInput,
										"ModelerDiagramEditor");//$NON-NLS-1$
					} catch (Exception e) {
						ZeligsoftCXUIPlugin
								.getDefault()
								.error(
										Messages.AbstractAddDiagramActionDelegate_DiagramOpenFailedLog,
										e);
					}
				}
			});
		} catch (Exception e) {
			ZeligsoftCXUIPlugin
					.getDefault()
					.error(
							Messages.AbstractAddDiagramActionDelegate_PostElementCreationFailedLog,
							e);
		}

		BaseUIUtil.startInLineEdit(newDiagram);
	}

	/**
	 * Returns the first element in the selection.
	 * 
	 * @return
	 */
	protected EObject getSelectedElement() {

		EObject selection = (EObject) ((IAdaptable) getStructuredSelection()
				.getFirstElement()).getAdapter(EObject.class);
		return selection;
	}
}
