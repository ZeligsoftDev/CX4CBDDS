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
package com.zeligsoft.domain.dds4ccm.constraints.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Element;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;
import com.zeligsoft.domain.dds4ccm.utils.DDS4CCMUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.corba.api.IDL.CXInterface;

/**
 * Check if the connectorType associated with a port is non-empty given the interface which types the port is non-local 
 * 
 * @author das
 * 
 */
public class ConnectorTypeNotEmptyConstraint extends AbstractModelConstraint {
	
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject objToVerify = ctx.getTarget();

		if (objToVerify == null
				|| !ZDLUtil.isZDLConcept(objToVerify,
						CCMNames.INTERFACE_PORT)) {
			return ctx.createSuccessStatus();
		}
		
		if(DDS4CCMUtil.getModelType((Element)objToVerify).equals(ModelTypeEnum.ATCD.name())){
			return ctx.createSuccessStatus();
		}
		
		InterfacePort ip = ZDLFactoryRegistry.INSTANCE.create(objToVerify, InterfacePort.class);
		
		if(!(ip.getPorttype() instanceof CXInterface)){
			return ctx.createSuccessStatus();
		}
		
		CXInterface portType = (CXInterface) ip.getPorttype();
		
		boolean isLocalPortType = portType.getIsLocal();

		if(isLocalPortType) {
			return ctx.createSuccessStatus();
		}
		
		if(ip.getConnectorType() != null){
			return ctx.createSuccessStatus();			
		}		

		return ctx.createFailureStatus(ip.getName());
	}	
}
