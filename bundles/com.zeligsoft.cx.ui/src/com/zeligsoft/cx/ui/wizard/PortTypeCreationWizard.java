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
package com.zeligsoft.cx.ui.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Usage;

import com.zeligsoft.base.util.BaseUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.ui.PortTypeRegistryReader.PortTypeRegistry;
import com.zeligsoft.cx.ui.ZeligsoftCXUIPlugin;
import com.zeligsoft.cx.ui.l10n.Messages;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Wizard which supports the creation of PortType. Refer to portTypeWizard
 * extension point for customizing the port type wizard
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class PortTypeCreationWizard
		extends Wizard {

	private Element context;

	private PortTypeCreationWizardPage page;

	private PortTypeRegistry registry;
	
	public PortTypeCreationWizard(Element context) {
		this.context = context;
		init();
	}

	/**
	 * Initialize this wizard page
	 */
	private void init() {

		page = new PortTypeCreationWizardPage(
			Messages.PortTypeCreationWizard_PageTitle, context);

		if (ZDLUtil.isZDLConcept(context, ZMLMMNames.PORT_TYPE)) {
			// modifying the existing port type
			page.setDescription(Messages.PortTypeCreationWizard_EditPageDescription);
		} else {
			// adding new port type
			page.setDescription(Messages.PortTypeCreationWizard_PageDescription);
		}
		page.setWizard(this);
		addPage(page);

	}

	@Override
	public boolean performFinish() {
		final String name = page.getPortTypeName();
		final String invName = page.getInversePortTypeName();

		registry = page.getRegistry();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(context);
		Command command = new RecordingCommand(domain, Messages.PortTypeCreationWizard_CreatePortTypeCommandLabel) {

			@Override
			protected void doExecute() {

				createPortType(name, invName, page.getProvidesMap(), page.getUsesMap());

			}

		};

		if (command.canExecute()) {
			domain.getCommandStack().execute(command);
		} else {
			ZeligsoftCXUIPlugin.getDefault().warning(Messages.PortTypeCreationWizard_CreationFailedMessage);
		}
		return true;
	}

	/**
	 * Creates an PortType Class using given information
	 * 
	 * @return Returns true if successful, false otherwise
	 */
	private void createPortType(String name, String invName,
			Map<Interface, String> providesMap, Map<Interface, String> usesMap) {

		Class newPortType;
		Class newPortTypeInv = null;
		
		if (page.getSelectedPortType() != null) {
			newPortType = page.getSelectedPortType();
			newPortType.setName(name);
			List<EObject> toDelete = new ArrayList<EObject>();
			for(EObject eo: newPortType.getRelationships()){
				toDelete.add(eo);
			}
			Object value = ZDLUtil.getValue(newPortType, ZMLMMNames.PORT_TYPE,
					ZMLMMNames.PORT_TYPE__INVERSE);
			if (value != null) {
				newPortTypeInv = (Class) value;
				newPortTypeInv.setName(invName);
				for(EObject eo: newPortTypeInv.getRelationships()){
					toDelete.add(eo);
				}
			}
			
			Command cmd = BaseUtil.getDeleteCommand(toDelete);
			TransactionUtil.getEditingDomain(newPortType).getCommandStack().execute(cmd);
		}else{
			if (context instanceof Package) {
				// Create PortType
				newPortType = ((org.eclipse.uml2.uml.Package) context)
					.createOwnedClass(name, false);
	
				if (registry.isCreateInversePortType()) {
					// Create Inverse PortType
					newPortTypeInv = ((org.eclipse.uml2.uml.Package) context)
							.createOwnedClass(invName, false);
				}
			} else if (context instanceof Component) {
				// Create PortType
				newPortType = ((Component) context).createOwnedClass(name, false);
	
				// Create Inverse PortType
				if (registry.isCreateInversePortType()) {
					newPortTypeInv = ((Component) context).createOwnedClass(invName, false);
				}
			} else {
				Assert.isTrue(false);
				return;
			}

			// Add PortType stereotype to the class created
			ZDLUtil.addZDLConcept(newPortType, registry.getPortTypeConcept());
			if (registry.isCreateInversePortType()) {
				ZDLUtil.addZDLConcept(newPortTypeInv, registry.getPortTypeConcept());
				// Setting inverse property
				ZDLUtil.setValue(newPortType, registry.getPortTypeConcept(),
						ZMLMMNames.PORT_TYPE__INVERSE, newPortTypeInv);
				ZDLUtil.setValue(newPortTypeInv, registry.getPortTypeConcept(),
						ZMLMMNames.PORT_TYPE__INVERSE, newPortType);
			}
		}
		
		for (Interface intf: providesMap.keySet()) {
			String relationshipName = providesMap.get(intf);
			newPortType.createInterfaceRealization(relationshipName,
					intf);
			if (registry.isCreateInversePortType()) {
				Usage usage = newPortTypeInv.createUsage(intf);
				usage.setName(relationshipName);
			}
		}

		if (usesMap.keySet().size() > 0) {

			for (Interface intf : usesMap.keySet()) {
				String relationshipName = usesMap.get(intf);
				relationshipName = usesMap.get(intf);
				if (registry.isCreateInversePortType()) {
					newPortTypeInv.createInterfaceRealization(relationshipName, intf);
				}
				Usage usage = newPortType.createUsage(intf);
				usage.setName(relationshipName);
			}
		}
	}

}
