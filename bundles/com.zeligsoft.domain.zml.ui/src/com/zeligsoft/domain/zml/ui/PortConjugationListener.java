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
package com.zeligsoft.domain.zml.ui;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.ibm.xtools.uml.msl.services.conjugatedports.ChangePortConjugationCommand;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Synchronize port conjugation with RSA
 * 
 * @author ysroh
 * 
 */
public class PortConjugationListener extends ResourceSetListenerImpl {

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		CompoundCommand cmd = new CompoundCommand();
		for (Notification notification : event.getNotifications()) {
			if ((notification.getNotifier() instanceof EObject)
					&& ZDLUtil.isZDLConcept(
							(EObject) notification.getNotifier(),
							ZMLMMNames.CONJUGATED_PORT)) {
				EObject notifier = (EObject) notification.getNotifier();
				EObject baseElement = UMLUtil.getBaseElement(notifier);
				if (baseElement == null) {
					baseElement = notifier;
				}
				if (!(baseElement instanceof DynamicEObjectImpl)
						&& notification.getFeature() instanceof EAttribute
						&& ((EAttribute) notification.getFeature())
								.getName()
								.equals(ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)
						&& notification.getEventType() == Notification.SET) {
					boolean value = (Boolean) ZDLUtil.getValue(baseElement,
							ZMLMMNames.CONJUGATED_PORT,
							ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED);
					cmd.append(getPortConjugationChangeCommand(
							(Port) baseElement, value));
				}
			}
		}

		if (!cmd.isEmpty()) {
			return cmd.unwrap();
		}
		return null;
	}

	private RecordingCommand getPortConjugationChangeCommand(final Port port,
			final boolean conjugation) {

		return new RecordingCommand(TransactionUtil.getEditingDomain(port)) {

			@Override
			protected void doExecute() {
				ChangePortConjugationCommand command = new ChangePortConjugationCommand(
						TransactionUtil.getEditingDomain(port),
						"Set Conjugation", //$NON-NLS-1$
						Collections.singletonList(WorkspaceSynchronizer
								.getFile(port.eResource())), port, conjugation);
				try {
					command.execute(null, null);
				} catch (ExecutionException e) {
					// nothing we can do about this.
				}
			}
		};

	}
}
