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
package com.zeligsoft.domain.idl3plus.ui.edithelpers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.cx.ui.filters.ElementSelectionFilter;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.omg.ccm.Activator;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.preferences.CCMPreferenceConstants;

/**
 * Edit helper advice for components in the IDL3Plus domain.
 * 
 * @author ysroh
 * 
 */
public class IDL3PlusConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice
	 * #getAfterCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.
	 * CreateElementRequest)
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		final CreateElementRequest editRequest = request;

		return new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(request.getContainer()),
				Messages.IDL3PlusConnectorEditHelperAdvice_CommandLabel, null) {

			@SuppressWarnings("deprecation")
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {

				EObject newEObject = editRequest.getNewElement();
				if (newEObject == null) {
					return null;
				}
				EObject container = editRequest.getContainer();
				if (!ZDLUtil.isZDLConcept(container, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
					return null;
				}

				if (newEObject instanceof Property) {
					Property newProperty = (Property) newEObject;
					if (newProperty instanceof Port) {
						return null;
					}
					Type propertyType = newProperty.getType();
					if (propertyType == null) {
						if (ZDLUtil.isZDLConcept(newProperty, IDL3PlusNames.DATA_SPACE)) {
							if (Activator.getDefault().getPluginPreferences().getBoolean(
									CCMPreferenceConstants.AUTO_TYPE_SELECTION_DIALOG)) {
								List<String> concepts = new ArrayList<String>();

								ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(
										Display.getCurrent().getActiveShell(), container,
										concepts, true, true);
								dialog.setElementFilter(new ElementSelectionFilter(
										IDL3PlusNames.DATA_SPACE,
										IDL3PlusNames.DATA_SPACE__CONNECTOR_TYPE));
								if (dialog.open() == Window.OK) {
									if (!dialog.getSelectedElements().isEmpty()
											&& dialog.getSelectedElements()
													.getFirstElement() != null) {
										newProperty.setType((Type) dialog
												.getSelectedElements().getFirstElement());
									}
								}
							}
						}
					} else if (ZDLUtil.isZDLConcept(propertyType,
							IDL3PlusNames.CONNECTOR_DEF)) {
						if (!ZDLUtil.isZDLConcept(newProperty, IDL3PlusNames.DATA_SPACE)) {
							ZDLUtil.addZDLConcept(newProperty, IDL3PlusNames.DATA_SPACE);
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
