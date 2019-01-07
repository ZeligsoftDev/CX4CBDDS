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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.EnumerationLiteral;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * Verify that a oneway operation only void return param
 * 
 * @author Tim McGuire
 *
 */
public class OneWayOperationReturnParameterValidation extends AbstractModelConstraint {

	/**
	 * Public constructor
	 */
	public OneWayOperationReturnParameterValidation() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();
		
		if(ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.CORBAOPERATION)) {
			Boolean isOneWay = 
				(Boolean) ZDLUtil.getValue(objToVerify, CORBADomainNames.CORBAOPERATION, CORBADomainNames.CORBAOPERATION__IS_ONE_WAY);
			
			if(isOneWay != null && isOneWay.booleanValue()) {
				
				EObject returnType = (EObject) ZDLUtil.getValue(objToVerify, CORBADomainNames.CORBATYPED, CORBADomainNames.CORBATYPED__IDL_TYPE);
				
				if(returnType == null) {
					return ctx.createSuccessStatus();
				}
					
				boolean foundNonVoidReturnType = false;
				if(ZDLUtil.isZDLConcept(returnType, CORBADomainNames.CORBAPRIMITIVE)) {
					EnumerationLiteral primitiveType = (EnumerationLiteral) ZDLUtil.getValue(returnType, CORBADomainNames.CORBAPRIMITIVE, CORBADomainNames.CORBAPRIMITIVE__TYPE);
					if ( !primitiveType.getName().equals(CORBADomainNames.CORBAPRIMITIVE_KIND___CORBAVOID)) {
						foundNonVoidReturnType = true;
					}
				}

				if(foundNonVoidReturnType) {
					return ctx.createFailureStatus(objToVerify);
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
