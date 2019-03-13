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

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Removes all connectors for a CCM part when it is moved.
 * 
 * @author parmvirs
 * 
 */
public class CCMPartMoveOperationListener extends ResourceSetListenerImpl {

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		for (Notification notification : event.getNotifications()) {
			if (notification.getEventType() == Notification.REMOVE && notification.getNewValue() == null) {
				Object oldValue = notification.getOldValue();
				Object notifier = notification.getNotifier();
				if (oldValue instanceof EObject && notifier instanceof EObject) {
					final EObject part = (EObject) oldValue;
					EObject assembly = (EObject) notifier;
					if (ZDLUtil.isZDLConcept(part, CCMNames.CCMPART)
							&& ZDLUtil.isZDLConcept(assembly,
									CCMNames.ASSEMBLY_IMPLEMENTATION)) {

						ICommand command = new AbstractTransactionalCommand(
								TransactionUtil
										.getEditingDomain((EObject) oldValue),
								"Remove Connectors", null) { //$NON-NLS-1$

							@Override
							protected CommandResult doExecuteWithResult(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								Iterator<Setting> itor = UML2Util.getInverseReferences(part).iterator();
								while (itor.hasNext()) {
									EObject eobj = itor.next().getEObject();
									if (ZDLUtil.isZDLConcept(eobj, ZMLMMNames.CONNECTOR_END)) {
										EObject connector = eobj.eContainer();
										if (ZDLUtil.isZDLConcept(connector, CCMNames.CCMCONNECTOR)) {
											EcoreUtil.remove(connector);
											EcoreUtil.delete(connector);
										}
									}
								}
								return CommandResult.newOKCommandResult();
							}
						};
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command, null, null);
						} catch (Exception e) {
							Activator.getDefault().error(e.getMessage(), e);
						}
					}
				}
			}
		}
	}

}
