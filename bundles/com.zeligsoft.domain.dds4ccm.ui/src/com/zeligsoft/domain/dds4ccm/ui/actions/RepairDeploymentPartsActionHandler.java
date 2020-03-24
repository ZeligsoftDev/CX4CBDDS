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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.ui.utils.BaseUIUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.cx.deployment.ui.commands.AddModelElementCommand;
import com.zeligsoft.cx.deployment.ui.commands.DeleteDeploymentPartCommand;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.ui.l10n.Messages;
import com.zeligsoft.domain.idl3plus.ui.commands.IDL3PlusAddModelElementCommand;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;;

/**
 * Synchronize deployment parts with their definitions
 * 
 * @author ysroh
 * 
 */
public class RepairDeploymentPartsActionHandler extends AbstractHandler {

	private EObject selectedEObject;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		selectedEObject = BaseUIUtil.getEObjectFromSelection(BaseUIUtil.getSelection());

		if (selectedEObject == null) {
			return null;
		}
		final Set<EObject> deploymentsToRepair = new HashSet<EObject>();
		if (ZDLUtil.isZDLConcept(selectedEObject, DDS4CCMNames.DDS4_CCMMODEL)) {
			TreeIterator<EObject> itor = selectedEObject.eAllContents();
			while (itor.hasNext()) {
				EObject next = itor.next();
				if (ZDLUtil.isZDLConcept(next, CCMNames.DEPLOYMENT_PLAN)) {
					deploymentsToRepair.add(next);
				}
				if (!(next instanceof Package)) {
					itor.prune();
				}
			}
		} else {
			deploymentsToRepair.add(selectedEObject);
		}

		for (EObject plan : deploymentsToRepair) {
			repairDeployment(plan);
		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				Messages.RepairDeploymentParts_DialogTitle,
				Messages.RepairDeploymentParts_DialogMessage);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	private void repairDeployment(EObject deployment) {
		if (deployment == null
				|| !ZDLUtil.isZDLConcept(deployment, CCMNames.DEPLOYMENT_PLAN)) {
			return;
		}

		List<EObject> parts = (List<EObject>) ZDLUtil.getValue(deployment,
				CCMNames.DEPLOYMENT_PLAN, ZMLMMNames.DEPLOYMENT__PART);
		List<EObject> rootParts = new ArrayList<EObject>();
		for (EObject part : parts) {
			if (ZDLUtil.isZDLConcept(part, ZMLMMNames.DEPLOYMENT_PART)) {
				EObject model = ZDLUtil.getEValue(part,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
				if (ZDLUtil.isZDLConcept(model, CCMNames.CCMCOMPONENT)) {
					rootParts.add(part);
				}
			}
		}

		for (EObject part : rootParts) {
			repair(deployment, part);
		}
	}

	@SuppressWarnings("unchecked")
	private void repair(EObject deployment, EObject deploymentPart) {
		EObject part = ZDLUtil.getEValue(deploymentPart,
				ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		List<EObject> nestedParts = (List<EObject>) ZDLUtil.getValue(
				deploymentPart, ZMLMMNames.DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
		EObject definition = part;
		if (ZDLUtil.isZDLConcept(part, CCMNames.CCMPART)) {
			definition = ZDLUtil.getEValue(part, CCMNames.CCMPART,
					ZMLMMNames.PART__DEFINITION);
		}

		if (definition == null) {
			return;
		}
		EObject assembly = CCMUtil.getAssemblyFromComponent(definition);
		if (assembly == null && nestedParts.isEmpty()) {
			return;
		}
		List<EObject> assemblyParts = new ArrayList<EObject>();
		List<EObject> ownedPorts = new ArrayList<EObject>();
		if (assembly != null) {
			assemblyParts = (List<EObject>) ZDLUtil.getValue(assembly,
					CCMNames.ASSEMBLY_IMPLEMENTATION,
					ZMLMMNames.STRUCTURAL_REALIZATION__PART);
		}
		if (ZDLUtil.isZDLConcept(definition, CCMNames.CCMCOMPONENT)) {
			ownedPorts = (List<EObject>) ZDLUtil.getValue(definition,
					ZMLMMNames.COMPONENT_INTERFACE,
					ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
		}
		List<EObject> partsToCreate = new ArrayList<EObject>();
		partsToCreate.addAll(assemblyParts);
		partsToCreate.addAll(ownedPorts);
		List<Property> partsToDelete = new ArrayList<Property>();
		Map<EObject, EObject> foundPartsMap = new HashMap<EObject, EObject>();
		for (EObject nestedPart : nestedParts) {
			EObject modelPart = ZDLUtil.getEValue(nestedPart,
					ZMLMMNames.DEPLOYMENT_PART,
					ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if (!assemblyParts.contains(modelPart) && !ownedPorts.contains(modelPart)) {
				partsToDelete.add((Property) nestedPart);
			} else {
				foundPartsMap.put(modelPart, nestedPart);
			}
		}
		partsToCreate.removeAll(foundPartsMap.keySet());
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(deployment);

		if (!partsToDelete.isEmpty()) {
			ICommand command = new DeleteDeploymentPartCommand(
					(Component) deployment, partsToDelete,
					"Delete Deployment Parts"); //$NON-NLS-1$
			
			Command emfCommand = GMFtoEMFCommandWrapper.wrap(command);
			if(emfCommand.canExecute()) {
				domain.getCommandStack().execute(emfCommand);
			}
		}

		for (EObject partToCreate : partsToCreate) {
			ICommand createCommand = null;
			if (ZDLUtil.isZDLConcept(partToCreate, ZMLMMNames.PORT)){
				createCommand = new IDL3PlusAddModelElementCommand(
						(Component) deployment, (Property) partToCreate,
						(NamedElement) deploymentPart, null, "Create Deployment Part"); //$NON-NLS-1$
			} else {
				createCommand = new AddModelElementCommand(
					(Component) deployment, (Property) partToCreate,
					(Component) assembly, null, "Create Deployment Part"); //$NON-NLS-1$
			}
			Command emfCommand = GMFtoEMFCommandWrapper.wrap(createCommand);
			if(emfCommand.canExecute()) {
				domain.getCommandStack().execute(emfCommand);
			}
		}

		for (EObject aPart : foundPartsMap.values()) {
			repair(deployment, aPart);
		}

	}
}
