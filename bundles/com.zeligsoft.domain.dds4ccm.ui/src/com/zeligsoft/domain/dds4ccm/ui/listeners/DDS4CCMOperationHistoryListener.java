/**
 * Copyright 2022 Northrop Grumman Systems Corporation.
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

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.common.util.UML2Util;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;

/**
 * A pop-up dialog warning for editing read only model
 * 
 * @author Young-Soo Roh
 *
 */
public class DDS4CCMOperationHistoryListener implements IOperationHistoryListener {

	@Override
	public void historyNotification(OperationHistoryEvent event) {
		IWorkbenchPage page = BaseUIUtil.getActivepage();
		if (page == null)
			return;

		Display display = page.getWorkbenchWindow().getWorkbench().getDisplay();
		if (display == null)
			return;

		if (event.getEventType() == OperationHistoryEvent.OPERATION_NOT_OK) {
			IStatus status = event.getStatus();
			if (!UML2Util.isEmpty(status.getMessage()) && status.getMessage().startsWith("Impossible to create")) { //$NON-NLS-1$
				MessageDialog.openWarning(display.getActiveShell(),
						Messages.DDS4CCMOperationHistoryListener_DialogTitle,
						Messages.DDS4CCMOperationHistoryListener_DialogMessage);
				Activator.getDefault().warning(Messages.DDS4CCMOperationHistoryListener_DialogMessage);
			}
		}
	}

}
