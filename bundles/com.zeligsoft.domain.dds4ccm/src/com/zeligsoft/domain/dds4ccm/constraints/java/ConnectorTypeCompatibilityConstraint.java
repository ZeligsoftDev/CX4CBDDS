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
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;

/**
 * Check compatibility of selected connector-type associated with an interface port
 * 
 * @author das
 * 
 */
public class ConnectorTypeCompatibilityConstraint extends AbstractModelConstraint {
	
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
		
		// for axcioma generation, we only care about synchronous or asynchronous property of a client port 
		if(!ip.getIsConjugated() || !(ip.getPorttype() instanceof CXInterface)){
			return ctx.createSuccessStatus();
		}
		
		CXInterface portType = (CXInterface) ip.getPorttype();
		
		boolean isLocalPortType = portType.getIsLocal();

		if(isLocalPortType) {
			return ctx.createSuccessStatus();
		}
		
		Object objConnType = ip.getConnectorType();
		 
		if(!(objConnType instanceof ConnectorDef)){
			return ctx.createSuccessStatus(); 
		}	
		
		ConnectorDef connectorType = (ConnectorDef)objConnType;
		
		boolean isAsync = ip.getIsAsynchronous();

		if(isAsync && !isAsyncCapableConnector(connectorType)) {
			return ctx.createFailureStatus(ip.getName(), "asynchronous"); //$NON-NLS-1$
		} else if (!isAsync && !isSyncCapableConnector(connectorType)){
			return ctx.createFailureStatus(ip.getName(), "synchronous"); //$NON-NLS-1$
		} else {
			return ctx.createSuccessStatus();
		}		
	}
	
	/**
	 *   return true if: AMI4CCM_Connector, and perhaps other values in the future 
	 */
		private boolean isAsyncCapableConnector(ConnectorDef connectorType) {
			return DDS4CCMUtil.isAsyncCapableConnector(connectorType.getName());			
		}
		
	/**
	 *   return true if: AMI4CCM_Connector, CORBA4CCM_Connector. Other types to be added in the future 
	 */
		private boolean isSyncCapableConnector(ConnectorDef connectorType) {	
			return DDS4CCMUtil.isSyncCapableConnector(connectorType.getName());
		}
}
