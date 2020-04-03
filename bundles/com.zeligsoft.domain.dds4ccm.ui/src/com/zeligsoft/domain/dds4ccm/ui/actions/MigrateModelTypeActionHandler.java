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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMMigrationModelTypeUtil;

/**
 * Refactoring model type.
 * 
 * @author smcfee
 *
 */
public class MigrateModelTypeActionHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final EObject selObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());
		if (DDS4CCMMigrationModelTypeUtil.isMigrationRequired((Model) selObject)) {

			ModelSet modelSet = (ModelSet) selObject.eResource().getResourceSet();
			final ArchitectureDescriptionUtils helper = new ArchitectureDescriptionUtils(modelSet);
			Command cmd = helper.switchArchitectureContextId("com.zeligsoft.domain.cbdds.axcioma.architecture");
			TransactionUtil.getEditingDomain(selObject).getCommandStack().execute(cmd);
			BaseUIUtil.revealTarget(selObject);
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.MigrateModelAction_DialogTitle, Messages.Migrate_OK);
		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
					Messages.MigrateModelAction_DialogTitle, Messages.Migrate_Noop);
		}
		return null;
	}
}
