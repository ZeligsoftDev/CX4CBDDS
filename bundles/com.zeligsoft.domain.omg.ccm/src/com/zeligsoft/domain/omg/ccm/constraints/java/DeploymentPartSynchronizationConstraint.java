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

package com.zeligsoft.domain.omg.ccm.constraints.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZDeploymentUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * Validate the component deployment part is up-to-date with definition model
 * 
 * @author ysroh
 * 
 */
public class DeploymentPartSynchronizationConstraint extends
		AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public DeploymentPartSynchronizationConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		// validate CORBA primitive type value integrity for deployment part
		// properties
		if (ZDLUtil.isZDLConcept(objToVerify,
				ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {

			boolean result = validate(objToVerify);
			if (!result) {
				return ctx.createFailureStatus();
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private boolean validate(EObject deploymentPart) {
		EObject part = ZDLUtil.getEValue(deploymentPart,
				ZMLMMNames.COMPONENT_DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
		List<EObject> nestedParts = (List<EObject>) ZDLUtil.getValue(
				deploymentPart, ZMLMMNames.COMPONENT_DEPLOYMENT_PART,
				ZMLMMNames.DEPLOYMENT_PART__NESTED_PART);
		EObject definition = part;
		if (ZDLUtil.isZDLConcept(part, CCMNames.CCMPART)) {
			definition = ZDLUtil.getEValue(part, CCMNames.CCMPART,
					ZMLMMNames.PART__DEFINITION);
		}

		if (definition == null || nestedParts.isEmpty()) {
			return true;
		}
		EObject assembly = CCMUtil.getAssemblyFromComponent(definition);
		
		if (assembly != null && ZDLUtil.isZDLConcept(assembly, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
			List<EObject> allAssemblyParts = new ArrayList<EObject>();
			List<EObject> assemblyParts = (List<EObject>) ZDLUtil.getValue(
					assembly, CCMNames.ASSEMBLY_IMPLEMENTATION,
					ZMLMMNames.STRUCTURAL_REALIZATION__PART);
			List<EObject> ownedPorts = (List<EObject>) ZDLUtil.getValue(
					definition, ZMLMMNames.COMPONENT_INTERFACE,
					ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
			allAssemblyParts.addAll(assemblyParts);
			allAssemblyParts.addAll(ownedPorts);
			if (nestedParts.size() != allAssemblyParts.size()) {
				return false;
			}
			for (EObject nestedPart : nestedParts) {
				EObject aPart = ZDLUtil.getEValue(nestedPart,
						ZMLMMNames.DEPLOYMENT_PART,
						ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
				if (!allAssemblyParts.contains(aPart)) {
					return false;
				}
			}
		} else if (definition != null && ZDLUtil.isZDLConcept(definition, CCMNames.CCMCOMPONENT)) {
			List<EObject> ownedPorts = (List<EObject>) ZDLUtil.getValue(
					definition, ZMLMMNames.COMPONENT_INTERFACE,
					ZMLMMNames.COMPONENT_INTERFACE__OWNED_PORT);
			if (nestedParts.size() != ownedPorts.size()) {
				return false;
			}
			for (EObject nestedPart : nestedParts) {
				EObject port = ZDeploymentUtil
						.getModelElement((Property) nestedPart);
				if (!ownedPorts.contains(port)) {
					return false;
				}
			}
		}
		return true;
	}
}
