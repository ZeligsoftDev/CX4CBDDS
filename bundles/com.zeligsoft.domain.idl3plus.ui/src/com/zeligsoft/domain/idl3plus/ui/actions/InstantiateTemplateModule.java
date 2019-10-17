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
package com.zeligsoft.domain.idl3plus.ui.actions;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.dialogs.InstantiateTemplateModuleDialog;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;

/**
 * Select a TemplateModule and instantiate it.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class InstantiateTemplateModule extends Action implements ICXAction {

	protected EObject context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zeligsoft.base.ui.menus.actions.ICXAction#setSelection(org.eclipse
	 * .emf.ecore.EObject)
	 */
	@Override
	public void setSelection(EObject context) {
		this.context = context;
	}

	protected List<String> getConcepts() {
		return Collections.singletonList(IDL3PlusNames.TEMPLATE_MODULE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if(context == null){
			return;
		}
		final InstantiateTemplateModuleDialog dialog = new InstantiateTemplateModuleDialog(
				getShell(),	context);

		int dialogResult = dialog.open();

		if (dialogResult == Window.OK) {
			IStructuredSelection selectedElements = dialog
					.getSelectedElements();

			if(selectedElements.isEmpty()){
				return;
			}
			final EObject templateModule = (EObject) selectedElements
					.getFirstElement();

			AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
					TransactionUtil.getEditingDomain(context),
					Messages.InstantiateTemplateModule_CommandLabel,
					Collections.EMPTY_MAP, null) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					EObject instantiatedModule = IDL3PlusUtil.INSTANCE.instantiateTemplateModule(context,
							templateModule, dialog.getInstantiationMap());
					if (instantiatedModule != null) {
						//ToDo:BaseUIUtil.startInLineEdit(instantiatedModule);
					}
					return CommandResult.newOKCommandResult();
				}

			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(
						editCommand, null, null);
			} catch (ExecutionException e) {
				Activator.getDefault().error("Error instantiating module", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Queries current shell
	 * 
	 * @return
	 */
	private Shell getShell() {
		return Display.getCurrent().getActiveShell();
	}
}
