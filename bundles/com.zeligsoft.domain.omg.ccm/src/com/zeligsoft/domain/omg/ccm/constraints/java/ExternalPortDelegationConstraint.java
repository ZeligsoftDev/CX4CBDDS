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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

import com.zeligsoft.base.util.FilteringList;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

public class ExternalPortDelegationConstraint extends AbstractModelConstraint {

	/**
	 * Public constructor.
	 */
	public ExternalPortDelegationConstraint() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus validate(IValidationContext ctx) {
		
		EObject objToVerify = ctx.getTarget();
		
		if( ZDLUtil.isZDLConcept(objToVerify, CCMNames.ASSEMBLY_IMPLEMENTATION)) {
			if(((Component)objToVerify).getGeneralizations().isEmpty()){
				return ctx.createSuccessStatus();
			}
			
			Component comp = (Component) ((Component) objToVerify)
					.getGeneralizations().get(0).getGeneral();
			
			FilteringList <EObject> ownedPorts = (FilteringList <EObject>)ZDLUtil.getValue(comp, CCMNames.CCMCOMPONENT, ZMLMMNames.STRUCTURAL_REALIZATION__OWNED_PORT);
			
			for (EObject port : ownedPorts) {
				if ((Boolean)ZDLUtil.getValue(port, ZMLMMNames.PORT, ZMLMMNames.PORT__IS_EXTERNAL)) {
					// If we are an external port, it is implied that there exists a connection in the Assembly Implementation,
					// where one of the ends is this port
					// From OCL (which does not work due to other reasons -- bug #15765)
					//self.ownedPort->forAll( op | op.isExternal implies 
					//	self.connector->exists(c | c.oclAsType(uml::Connector).end->exists(e | e.role = op)))
					FilteringList <EObject> connections = (FilteringList <EObject>)ZDLUtil.getValue(objToVerify, CCMNames.ASSEMBLY_IMPLEMENTATION, ZMLMMNames.STRUCTURAL_REALIZATION__CONNECTOR);
					
					boolean result = false;
					for (Object conn : connections) {
						if (conn instanceof Connector) {
							Connector connector = (Connector)conn;
							for (ConnectorEnd end : connector.getEnds()){
								if (end.getRole().equals(port)){
									result = true;
								}
							}
						}
					}
					if (result == false) {
						ctx.addResult(port);
						return ctx.createFailureStatus();
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}
}
