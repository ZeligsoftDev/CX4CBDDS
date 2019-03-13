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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;

/**
 * 
 * @author parmvirs
 *
 */
public class DDS4CCMListener extends ResourceSetListenerImpl {

	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		CompoundCommand returnCommand = new CompoundCommand(
				"DDS4CCMListenerCommand"); //$NON-NLS-1$

		for (Notification notification : event.getNotifications()) {
			final Object notifier = notification.getNotifier();

			if (notifier instanceof EObject) {
				EStructuralFeature feature = (EStructuralFeature) notification
						.getFeature();
				TransactionalEditingDomain domain = TransactionUtil
						.getEditingDomain((EObject) notifier);
				if (ZDLUtil.isZDLConcept((EObject) notifier,
						DDS4CCMNames.MESSAGE_FIELD)) {
					EObject messageField = ((EObject) notifier);
					Object newValue = notification.getNewValue();
					if (feature.equals(UMLPackage.Literals.TYPED_ELEMENT__TYPE)
							&& newValue instanceof EObject
							&& notification.getEventType() == Notification.SET
							&& ZDLUtil.isZDLConcept((EObject) newValue,
									DDS4CCMNames.DDSMESSAGE)) {
						@SuppressWarnings("unchecked")
						List<EObject> typeFields = (List<EObject>) ZDLUtil
								.getValue((EObject) newValue,
										DDS4CCMNames.DDSMESSAGE,
										DDS4CCMNames.DDSMESSAGE__FIELDS);
						for (EObject field : typeFields) {
							if (ZDLUtil.isZDLConcept(field,
									DDS4CCMNames.MESSAGE_FIELD)) {
								Boolean isKey = (Boolean) ZDLUtil.getValue(
										field, DDS4CCMNames.MESSAGE_FIELD,
										DDS4CCMNames.MESSAGE_FIELD__IS_KEY);
								if (isKey) {
									EMFOperationCommand command = new EMFOperationCommand(
											domain, setIsKeyCommand(domain,
													messageField, isKey));
									returnCommand.append(command);
									break;
								}
							}
						}
					} else if (DDS4CCMNames.MESSAGE_FIELD__IS_KEY
							.equals(feature.getName())
							&& newValue instanceof Boolean
							&& notification.getEventType() == Notification.SET
							&& (Boolean) newValue) {
						EObject originalField = UMLUtil
								.getBaseElement(messageField);
						if (originalField != null) {
							EObject container = originalField.eContainer();
							if (container != null
									&& ZDLUtil.isZDLConcept(container,
											DDS4CCMNames.DDSMESSAGE)) {
								for (Setting s : UML2Util
										.getInverseReferences(container)) {
									EObject eobj = s.getEObject();
									if (eobj != null
											&& ZDLUtil.isZDLConcept(eobj,
													DDS4CCMNames.MESSAGE_FIELD)) {
										EObject idlType = (EObject) ZDLUtil
												.getValue(
														eobj,
														DDS4CCMNames.MESSAGE_FIELD,
														DDS4CCMNames.MESSAGE_FIELD__IDL_TYPE);
										if (idlType == container) {
											EMFOperationCommand command = new EMFOperationCommand(
													domain, setIsKeyCommand(
															domain, eobj,
															(Boolean) newValue));
											returnCommand.append(command);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return returnCommand;
	}

	private ICommand setIsKeyCommand(TransactionalEditingDomain domain,
			final EObject messageField, final Boolean isKeyValue) {
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				domain, "Set is Key", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				ZDLUtil.setValue(messageField, DDS4CCMNames.MESSAGE_FIELD,
						DDS4CCMNames.MESSAGE_FIELD__IS_KEY, isKeyValue);
				return CommandResult.newOKCommandResult();
			}
		};
		return command;
	}
}
