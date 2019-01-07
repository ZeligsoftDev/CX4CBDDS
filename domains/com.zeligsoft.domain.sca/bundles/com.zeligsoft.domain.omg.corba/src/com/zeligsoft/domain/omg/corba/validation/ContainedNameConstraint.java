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

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class ContainedNameConstraint extends AbstractModelConstraint {

	/**
	 * 
	 */
	public ContainedNameConstraint() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {	
		EObject objToVerify = ctx.getTarget();
		
		if(ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.CORBANAMED_ELEMENT)) {
			EObject container = objToVerify.eContainer();
			
			if(ZDLUtil.isZDLConcept(container, CORBADomainNames.CORBANAMED_ELEMENT)) {
				String objName = (String) ZDLUtil.getValue(objToVerify, 
						CORBADomainNames.CORBANAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME);
				String containerName = (String) ZDLUtil.getValue(container, 
						CORBADomainNames.CORBANAMED_ELEMENT, 
						ZMLMMNames.NAMED_ELEMENT__NAME);
				
				if( objName == null || containerName == null ) {
					return ctx.createSuccessStatus();
				}
				if(objName.equals(containerName)) {
					return ctx.createFailureStatus(objToVerify);
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
