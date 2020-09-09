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
package com.zeligsoft.domain.omg.corba.validation;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CXDomainNames;

/**
 * Verify that a oneway operation only has in parameters.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class OneWayOperationValidation extends AbstractModelConstraint {

	/**
	 * Public constructor
	 */
	public OneWayOperationValidation() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();
		
		if(ZDLUtil.isZDLConcept(objToVerify, CXDomainNames.CXOPERATION)) {
			Boolean isOneWay = 
				(Boolean) ZDLUtil.getValue(objToVerify, CXDomainNames.CXOPERATION, CXDomainNames.CXOPERATION__IS_ONE_WAY);
			
			if(isOneWay != null && isOneWay.booleanValue()) {
				
				@SuppressWarnings("unchecked")
				List<EObject> parametersList =
					(List<EObject>) ZDLUtil.getValue(objToVerify, CXDomainNames.CXOPERATION, CXDomainNames.CXOPERATION__OWNED_PARAMETER);
				boolean foundOutParam = false;
				if(parametersList != null) {
					for(EObject param : parametersList) {
						Object direction = 
							ZDLUtil.getValue(param, CXDomainNames.CXPARAMETER, CXDomainNames.CXPARAMETER__DIRECTION);
						if(ParameterDirectionKind.INOUT_LITERAL.equals(direction) ||
								ParameterDirectionKind.OUT_LITERAL.equals(direction)) {
							foundOutParam = true;
							break;
						}
					}
				}
				if(foundOutParam) {
					return ctx.createFailureStatus(objToVerify);
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
