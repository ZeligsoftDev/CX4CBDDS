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
package com.zeligsoft.domain.omg.ccm.ui.edithelpers;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;
import com.zeligsoft.domain.omg.ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * CCM Implementation edit helper adivce
 * 
 * @author ysroh
 * 
 */
public class AssemblyImplementationEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		if ("com.zeligsoft.domain.dds4ccm.ui.diagram.InterfacePort_Shape"
				.contentEquals(request.getElementType().getId())) {
			EObject obj = ZDLUtil.getEValue(request.getContainer(), CCMNames.ASSEMBLY_IMPLEMENTATION,
					ZMLMMNames.STRUCTURAL_REALIZATION__INTERFACE);
			if (obj != null) {
				request.setContainer(obj);
			}
		}
		return super.getBeforeCreateCommand(request);
	}
	
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				Messages.CommandLabel_SCAComponentPartEditHelperAdvice_getAfterCreateCommand,
				null) {

			@SuppressWarnings("unchecked")
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}
				EObject container = editRequest.getContainer();
				if (ZDLUtil.isZDLConcept(newEObject, CCMNames.CCMCONNECTOR)
						|| ZDLUtil.isZDLConcept(newEObject,
								CCMNames.TARGET_ASSEMBLY_CONNECTOR)) {
					((Connector) newEObject).setName(UML2Util.EMPTY_STRING);
					return CommandResult.newOKCommandResult(newEObject);
				}
				if (!(newEObject instanceof Property)) {
					return CommandResult.newOKCommandResult(newEObject);
				}

				Property newProperty = (Property) newEObject;

				Type propertyType = newProperty.getType();
				if (propertyType == null) {
					if (InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID)
							.getBoolean(CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG, true)) {
						ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(
								Display.getCurrent().getActiveShell(), container, Collections.EMPTY_LIST, true, true);

						if (ZDLUtil.isZDLConcept(newProperty, CCMNames.CCMPART)) {
							dialog.setElementFilter(
									new ElementSelectionFilter(CCMNames.CCMPART, ZMLMMNames.PART__DEFINITION));
						} else {
							return CommandResult.newOKCommandResult(newProperty);
						}
						if (dialog.open() == Window.OK) {
							if (!dialog.getSelectedElements().isEmpty()
									&& dialog.getSelectedElements().getFirstElement() != null) {
								newProperty.setType((Type) dialog.getSelectedElements().getFirstElement());
							}
						}
					}
					return CommandResult.newOKCommandResult(newProperty);
				}

				return CommandResult.newOKCommandResult();
			}

		};
	}
}
