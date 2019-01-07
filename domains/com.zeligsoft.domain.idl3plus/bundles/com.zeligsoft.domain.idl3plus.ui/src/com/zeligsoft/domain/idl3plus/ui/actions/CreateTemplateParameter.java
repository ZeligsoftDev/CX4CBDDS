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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.dialogs.CreateTemplateParameterDialog;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;

/**
 * An action to create a new template parameter. It will open a dialog so that
 * the user can set the name and select the desired type constraint for the
 * template parameter.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class CreateTemplateParameter extends Action implements ICXAction {

	protected EObject context;
	protected org.eclipse.uml2.uml.TemplateParameter newParameter = null;
	protected String concept = IDL3PlusNames.TYPE_PARAMETER;

	/**
	 * Create me.
	 */
	public CreateTemplateParameter() {
		super();
	}

	
	public void setSelection(EObject context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		CreateTemplateParameterDialog dialog = new CreateTemplateParameterDialog(
				getShell());

		int dialogResult = dialog.open();

		if (dialogResult == Window.OK) {
			final String parameterName = dialog.getName();
			final String parameterTypeConstraint = dialog.getTypeConstraint();
			AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
					UMLModeler.getEditingDomain(),
					Messages.CreateTemplateParameter_CommandLabel,
					Collections.EMPTY_MAP, null) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					IDL3PlusUtil.INSTANCE.createTemplateParameter(context,
							parameterName, parameterTypeConstraint);
					return CommandResult.newOKCommandResult();
				}
			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(
						editCommand, null, null);
			} catch (ExecutionException e) {
				Activator
						.getDefault()
						.error(
								Messages.CreateTemplateParameter__Error_CreatingTypeParameter,
								e);
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
