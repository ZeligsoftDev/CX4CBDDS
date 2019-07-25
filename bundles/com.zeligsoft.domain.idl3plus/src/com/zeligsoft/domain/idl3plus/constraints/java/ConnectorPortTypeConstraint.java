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
package com.zeligsoft.domain.idl3plus.constraints.java;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.ConnectorEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;


/**
 * 
 * @author tmcguire
 * 
 * Constraint verifying that an CCMConnector's endpoints, when not external ports, have equal PortTypes
 *
 */

public class ConnectorPortTypeConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public ConnectorPortTypeConstraint() {
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
			Object type = null;
			Object conjugatedType = null;
			
			for( EObject end : ends ) {
				// if both ends are connected to ports on a part then it is not a delegation connector
				if( ((ConnectorEnd) end).getPartWithPort() == null) {
					// we don't need to check delegation connector end conjugations since there is a test for this
					return ctx.createSuccessStatus();
				}

				EObject port = (EObject) ZDLUtil.getValue(end, ZMLMMNames.CONNECTOR_END, ZMLMMNames.CONNECTOR_END__PORT);
				
				if( port != null ) {
					// Interface port
					if( ZDLUtil.isZDLConcept(port, CCMNames.INTERFACE_PORT)) {
						if( (Boolean) ZDLUtil.getValue(port, ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {	
							conjugatedType = ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT, ZMLMMNames.PORT__PORTTYPE);
						} else {
							type = ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT, ZMLMMNames.PORT__PORTTYPE);	
						}
					} else if( ZDLUtil.isZDLConcept(port, CCMNames.EVENT_PORT)) {
						// Event ports do not realize a PortType
						return ctx.createFailureStatus();
					}
				} 
			}
			
			if(type != null && conjugatedType != null) {
				// if both ends are not PortTypes, then this is a CCM Connector. There is a separate test for this
				if( ZDLUtil.isZDLConcept((EObject) type, ZMLMMNames.PORT_TYPE) == false && 
				    ZDLUtil.isZDLConcept((EObject) conjugatedType, ZMLMMNames.PORT_TYPE) == false) {
					return ctx.createSuccessStatus();
				}
				
				// if both PortTypes are not null and the same PortType return success
				if( ZDLUtil.isZDLConcept((EObject) type, ZMLMMNames.PORT_TYPE) == true && 
				    ZDLUtil.isZDLConcept((EObject) conjugatedType, ZMLMMNames.PORT_TYPE) == true && 
				     type == conjugatedType) {
					return ctx.createSuccessStatus();
				}
			}

			return ctx.createFailureStatus();
		}
		
		return null;
		
	}

}
