/*******************************************************************************
 * Copyright (c) 2022 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/

package com.zeligsoft.domain.idl3plus.constraints.java;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;


/**
 * 
 * @author Young-Soo Roh
 * 
 * Constraint verifying that an CCMConnector's endpoints are valid
 *
 */

public class ConnectorValidEndsConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public ConnectorValidEndsConstraint() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject objToVerify = ctx.getTarget();
		
		if( ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			
			Collection<EObject> ends = (Collection<EObject>) ZDLUtil.getValue(objToVerify, ZMLMMNames.ASSEMBLY_CONNECTOR, ZMLMMNames.ASSEMBLY_CONNECTOR__END);
			
			if( ends.size() != 2 ) {
				return ctx.createFailureStatus();
			}
			
			for( EObject end : ends ) {

				EObject port = (EObject) ZDLUtil.getValue(end, ZMLMMNames.CONNECTOR_END, ZMLMMNames.CONNECTOR_END__PORT);
				EObject part = (EObject) ZDLUtil.getValue(end, ZMLMMNames.CONNECTOR_END, ZMLMMNames.CONNECTOR_END__PART);
				if(port == null && part == null) {
					return ctx.createFailureStatus();
				}
				if(part != null && ZDLUtil.isZDLConcept(part, CCMNames.CCMPART)) {
					return ctx.createFailureStatus();
				}
			}
			return ctx.createSuccessStatus();
		}
		
		return null;
		
	}

}
