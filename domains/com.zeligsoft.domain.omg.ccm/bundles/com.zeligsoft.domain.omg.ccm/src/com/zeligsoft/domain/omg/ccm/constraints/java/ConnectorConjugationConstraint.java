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
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interface;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * 
 * @author tmcguire
 * 
 * Constraint verifying that an SCAConnector's endpoints, when not external ports, have opposing
 * conjugations.
 *
 */
public class ConnectorConjugationConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public ConnectorConjugationConstraint() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		
		EObject objToVerify = ctx.getTarget();
		
		if( ZDLUtil.isZDLConcept(objToVerify, CCMNames.CCMCONNECTOR)) {
			
			List<EObject> ends = (List<EObject>) ZDLUtil.getValue(objToVerify, ZMLMMNames.ASSEMBLY_CONNECTOR, ZMLMMNames.ASSEMBLY_CONNECTOR__END);
			
			if( ends.size() != 2 ) {
				return ctx.createFailureStatus();
			}
			
			List<Interface> prov = new ArrayList<Interface>();
			List<Interface> uses = new ArrayList<Interface>();
			int interfacePortCount = 0; 
			int eventPortCount = 0;
			
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
						interfacePortCount++;
						if( (Boolean) ZDLUtil.getValue(port, ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT , ZMLMMNames.MESSAGE_PORT__REQUIRED_INTERFACE)) {
								prov.add(i);					
							}
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT, ZMLMMNames.MESSAGE_PORT__PROVIDED_INTERFACE)) {
								uses.add(i);					
							}
						} else {
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT , ZMLMMNames.MESSAGE_PORT__REQUIRED_INTERFACE)) {
								uses.add(i);					
							}
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.INTERFACE_PORT, ZMLMMNames.MESSAGE_PORT__PROVIDED_INTERFACE)) {
								prov.add(i);					
							}
						}
					} else if( ZDLUtil.isZDLConcept(port, CCMNames.EVENT_PORT)) {
						eventPortCount++;
						if( (Boolean) ZDLUtil.getValue(port, ZMLMMNames.CONJUGATED_PORT, ZMLMMNames.CONJUGATED_PORT__IS_CONJUGATED)) {
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.EVENT_PORT, CCMNames.EVENT_PORT__PUBLISHES_EVENT)) {
								prov.add(i);			
							}
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.EVENT_PORT, CCMNames.EVENT_PORT__CONSUMES_EVENT )) {
								uses.add(i);
							}
						} else {
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.EVENT_PORT, CCMNames.EVENT_PORT__PUBLISHES_EVENT)) {
								uses.add(i);				
							}
							for( Interface i : (List<Interface>)ZDLUtil.getValue(port, CCMNames.EVENT_PORT, CCMNames.EVENT_PORT__CONSUMES_EVENT )) {
								prov.add(i);
							}
						}
					}
				} 
			}
			
			if( !(interfacePortCount == 2 || eventPortCount == 2)) {
				return ctx.createFailureStatus();
			}
			
			if( prov.size() > 0 && uses.size() > 0 ) {
				return ctx.createSuccessStatus();
				}
			}
				
		return ctx.createFailureStatus();
	
	}
	
}
