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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.util.CCMUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class SelectedImplementationConstraint extends AbstractModelConstraint {
	
	/**
	 * Public constructor.
	 */
	public SelectedImplementationConstraint() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();

		// validate CORBA primitive type value integrity for deployment part
		// properties
		if (ZDLUtil.isZDLConcept(objToVerify, ZMLMMNames.COMPONENT_DEPLOYMENT_PART)) {
			EObject o = ZDLUtil.getEValue(objToVerify, ZMLMMNames.COMPONENT_DEPLOYMENT_PART, ZMLMMNames.COMPONENT_DEPLOYMENT_PART__SELECTED_IMPLEMENTATION);
			if( o != null ) {
				return ctx.createSuccessStatus();
			}
			// If the selected implementation is null, then make sure the component has at most 1 monolithic implementation.
			EObject modelElement = ZDLUtil.getEValue(objToVerify, ZMLMMNames.DEPLOYMENT_PART, ZMLMMNames.DEPLOYMENT_PART__MODEL_ELEMENT);
			if(modelElement == null){
				return null;
			}
			if( ZDLUtil.isZDLConcept(modelElement, ZMLMMNames.PART)) {
				EObject component = ZDLUtil.getEValue(modelElement, ZMLMMNames.PART, ZMLMMNames.PART__DEFINITION);
				if( component != null && ZDLUtil.isZDLConcept(component, CCMNames.CCMCOMPONENT)) {
					if( CCMUtil.getMonolithicImplementationsForComponent(component).size() > 1 ) {
						return ctx.createFailureStatus(ZDLUtil.getValue(objToVerify, ZMLMMNames.NAMED_ELEMENT, ZMLMMNames.NAMED_ELEMENT__NAME));
					}
				}
			}
		}
		
		return null;
	}

}
