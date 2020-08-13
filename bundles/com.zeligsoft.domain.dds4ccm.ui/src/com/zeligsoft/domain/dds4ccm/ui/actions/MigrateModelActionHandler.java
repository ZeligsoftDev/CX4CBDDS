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
package com.zeligsoft.domain.dds4ccm.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationUtil;

/**
 * Migrate DDS4CCM model
 * 
 * @author ysroh
 * 
 */
public class MigrateModelActionHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (selObject == null || !(selObject instanceof Model)) {
			return null;
		}

		if (DDS4CCMMigrationUtil.isMigrationRequired((Model) selObject)) {

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selObject);
			final AbstractTransactionalCommand migrationCommand = new AbstractTransactionalCommand(
					TransactionUtil.getEditingDomain(selObject), Messages.MigrateModelAction_CommandLabel, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {

					DDS4CCMMigrationUtil.migrateAll((Model) selObject);
					return CommandResult.newOKCommandResult();
				}
			};

			UIJob job = new UIJob("Model Migration") { //$NON-NLS-1$

				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					monitor.beginTask(Messages.MigrateModelAction_MonitorTask, IProgressMonitor.UNKNOWN);
					Command emfCommand = GMFtoEMFCommandWrapper.wrap(migrationCommand);
					editingDomain.getCommandStack().execute(emfCommand);
					monitor.done();
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
							Messages.MigrateModelAction_DialogTitle, Messages.Migrate_OK);
					return Status.OK_STATUS;
				}
			};
			job.setUser(true);
			job.schedule();

		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.MigrateModelAction_DialogTitle, Messages.Migrate_Noop);
		}
		return null;
	}
}
