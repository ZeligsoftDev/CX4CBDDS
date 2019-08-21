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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

public class OnlyCORBAParametersConstraint extends AbstractModelConstraint {

	public OnlyCORBAParametersConstraint() {
		super();
	}
	
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();
		
		if( ZDLUtil.isZDLConcept(objToVerify, CORBADomainNames.CORBAOPERATION)) {
			Operation op = (Operation)objToVerify;
			
			for( Parameter p : op.getOwnedParameters()) {
				if( p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
					if( ! ZDLUtil.isZDLConcept(p, CORBADomainNames.CORBAPARAMETER)) {
						return ctx.createFailureStatus(ctx);
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}
}
