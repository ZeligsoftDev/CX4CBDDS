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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.ui.ElementTypeImageDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.zeligsoft.base.ui.menus.actions.ICXAction;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.util.NamingUtil;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.dialogs.ZDLElementSelectionDialog;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.ui.Activator;
import com.zeligsoft.domain.idl3plus.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;


/**
 * Create a Connector Default Value Binding
 * 
 * @author ysroh
 * 
 */
public class ConnectorDefaultValueBinding extends Action implements ICXAction {

	protected EObject context;

	private Package result = null;

	@Override
	public ImageDescriptor getImageDescriptor() {
		IElementType type = ZDLElementTypeUtil.getElementType(context,
				IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING);
		return new ElementTypeImageDescriptor(type);
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		if (context == null) {
			return;
		}

		final ZDLElementSelectionDialog dialog = new ZDLElementSelectionDialog(
				getShell(), context, Collections.EMPTY_LIST, true, true);
		dialog.setElementFilter(new IFilter() {

			@Override
			public boolean select(Object toTest) {
				if (toTest instanceof EObject) {
					EObject eo = (EObject) toTest;
					if (ZDLUtil.isZDLConcept(eo, IDL3PlusNames.CONNECTOR_DEF)
							&& IDL3PlusUtil.getTemplateModule(eo) != null) {
						return true;
					}
				}
				return false;
			}
		});
		int dialogResult = dialog.open();

		if (dialogResult == Window.OK) {
			IStructuredSelection selectedElements = dialog
					.getSelectedElements();

			if (selectedElements.isEmpty()) {
				return;
			}
			final Component connectorDef = (Component) selectedElements
					.getFirstElement();
			
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(context);

			AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
					editingDomain,
					Messages.ConnectorDefaultValueBinding_CreateCommandLabel,
					Collections.EMPTY_MAP, null) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					Command command = BaseUIUtil.getCreatePackageCommand(context);
					editingDomain.getCommandStack().execute(command);
					result = (Package) command.getResult().iterator().next();
					if (result != null) {
						String containerName = NamingUtil.generateUniqueName(
								"_" + connectorDef.getName(), //$NON-NLS-1$
								context.eContents());
						result.setName(containerName);
						ZDLUtil.addZDLConcept((Element) result,
								IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING);
						ZDLUtil.setValue(
								result,
								IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING,
								IDL3PlusNames.CONNECTOR_DEFAULT_VALUE_BINDING__DEFINITION,
								connectorDef);
					}
					return CommandResult.newOKCommandResult();
				}
			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(
						editCommand, null, null);
			} catch (ExecutionException e) {
				Activator.getDefault().error(
						Messages.ConnectorDefaultValueBinding_ErrorMessage, e);
			}
			if (result != null) {
				// ToDo:BaseUIUtil.startInLineEdit(result);
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

