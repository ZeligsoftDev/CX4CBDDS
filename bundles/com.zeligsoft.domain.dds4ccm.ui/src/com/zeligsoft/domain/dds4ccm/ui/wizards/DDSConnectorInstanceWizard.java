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
package com.zeligsoft.domain.dds4ccm.ui.wizards;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.Activator;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.utils.IDL3PlusUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * DDS Connector Instance wizard
 * 
 * @author ysroh
 * 
 */
public class DDSConnectorInstanceWizard extends Wizard {

	private EObject context;

	private DDSConnectorInstanceWizardPage page;

	public DDSConnectorInstanceWizard(EObject context) {
		super();
		this.context = context;
		setWindowTitle(Messages.DDSConnectorInstanceWizard_WindowTitle);

		page = new DDSConnectorInstanceWizardPage(this.context);
		addPage(page);
	}

	@Override
	public boolean performFinish() {

		AbstractTransactionalCommand editCommand = new AbstractTransactionalCommand(
				UMLModeler.getEditingDomain(), Messages.DDSConnectorInstanceWizard_CommandLabel,
				Collections.EMPTY_MAP, null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
					IAdaptable arg1) throws ExecutionException {

				DataType message = (DataType) BaseUIUtil.createZDLModelElement(context,
						DDS4CCMNames.DDSMESSAGE);
				DataType sequence = (DataType) BaseUIUtil.createZDLModelElement(context,
						CORBADomainNames.CORBASEQUENCE);

				if (message == null || sequence == null) {
					CommandResult.newCancelledCommandResult();
				}

				message.setName(page.getMessageName());
				sequence.setName(page.getSequenceName());

				Property members = sequence.getAttribute("members", null); //$NON-NLS-1$
				if (members != null) {
					members.setType(message);
				}

				if (page.isAutoInstantiateTemplateModule()) {
					Package instantiation = instantiateConnectorTemplateParameter(
							message, sequence);
					if (instantiation != null) {
						instantiation.setName(page.getInstantiatedTemplateModuleName());
					}
				}

				return CommandResult.newOKCommandResult();
			}

		};

		try {
			OperationHistoryFactory.getOperationHistory()
					.execute(editCommand, null, null);
		} catch (ExecutionException e) {
			Activator.getDefault().error(Messages.DDSConnectorInstanceWizard_ErrorMessage, e);
		}
		return true;
	}

	private Package instantiateConnectorTemplateParameter(DataType message,
			DataType sequence) {
		Package module = page.getSelectedTemplateModule();
		if(module == null){
			return null;
		}
		List<EObject> parameters = IDL3PlusUtil.INSTANCE.getTemplateParameters(module);
		Map<ClassifierTemplateParameter, EObject> map = new HashMap<ClassifierTemplateParameter, EObject>();
		for (EObject eo : parameters) {
			ClassifierTemplateParameter param = (ClassifierTemplateParameter) eo;
			if (param.getOwnedParameteredElement() instanceof Class) {
				map.put(param, message);
			} else if (param.getOwnedParameteredElement() instanceof DataType) {
				map.put(param, sequence);
			}
		}
		return (Package) IDL3PlusUtil.INSTANCE.instantiateTemplateModule(context, module,
				map);
	}

}
