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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;
import com.zeligsoft.domain.zml.util.ZMLUtil;

/**
 * Warn user if worker function user code is about to be deleted.
 * 
 * @author ysroh
 * 
 */
public class WorkerFunctionImplListener extends ResourceSetListenerImpl {

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		if (!ZMLUtil.isMigrationInProgress) {
			List<NamedElement> modifyList = new ArrayList<NamedElement>();
			boolean result;
			for (Notification notification : event.getNotifications()) {
				if (modifyList.size() > 1) {
					break;
				}
				if (notification.getEventType() == Notification.SET
						&& notification.getNotifier() instanceof EObject
						&& ZDLUtil.isZDLConcept(
								(EObject) notification.getNotifier(),
								ZMLMMNames.WORKER_FUNCTION_IMPL)) {

					if (!(notification.getOldValue() instanceof OpaqueBehavior)
							|| notification.getNewValue() != null) {
						continue;
					}
					List<String> bodies = ((OpaqueBehavior) (notification
							.getOldValue())).getBodies();
					for (String body : bodies) {
						if (!UML2Util.isEmpty(body)) {
							modifyList.add((OpaqueBehavior) notification
									.getOldValue());
							break;
						}
					}
				}
			}
			if (!modifyList.isEmpty()) {
				String workerName;
				if (modifyList.size() == 1) {
					workerName = modifyList.get(0).getQualifiedName();
					workerName = "\"" //$NON-NLS-1$
							+ workerName.replaceAll(
									"Impl$", UML2Util.EMPTY_STRING) //$NON-NLS-1$
							+ "\""; //$NON-NLS-1$
				} else {
					workerName = Messages.WorkerFunctionImplListener_DialogSubMessage;
				}
				if (Display.getCurrent() != null) {
					result = MessageDialog
							.openConfirm(
									Display.getCurrent().getActiveShell(),
									Messages.WorkerFunctionListener_DialogTitle,
									NLS.bind(
											Messages.WorkerFunctionListener_DialogMessage,
											workerName));
				} else {
					Display display = new Display();
					result = MessageDialog
							.openConfirm(
									display.getActiveShell(),
									Messages.WorkerFunctionListener_DialogTitle,
									NLS.bind(
											Messages.WorkerFunctionListener_DialogMessage,
											workerName));
					display.dispose();
				}
				if (!result) {
					throw new RollbackException(Status.CANCEL_STATUS);
				}
			}
		}
		return super.transactionAboutToCommit(event);
	}
}
