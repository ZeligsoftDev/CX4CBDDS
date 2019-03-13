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
package com.zeligsoft.domain.omg.ccm.util;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.ccm.CCMNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class CCMDomainSwitch<T> {
	/**
	 * Create an instance of the switch
	 */
	public CCMDomainSwitch() {
		// Nothing to do
	}
	
	public T doSwitch(EObject theEObject) {
		if(ZDLUtil.isZDLConcept(theEObject, CCMNames.CCMCOMPONENT)) {
			T result = caseCCMComponent(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.EVENT)){
			T result = caseEvent(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.EVENT_PORT)){
			T result = caseEventPort(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.INTERFACE_PORT)){
			T result = caseInterfacePort(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.HOME)){
			T result = caseHome(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.MANAGES)){
			T result = caseManages(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.ASSEMBLY_IMPLEMENTATION)){
			T result = caseAssemblyImplementation(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.CCMPART)){
			T result = caseCCMPart(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.CCMCONNECTOR)){
			T result = caseCCMConnector(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.HOME_IMPLEMENTATION)){
			T result = caseHomeImplementation(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.MONOLITHIC_IMPLEMENTATION)){
			T result = caseMonolithicImplementation(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.MONOLITHIC_IMPLEMENTATION)){
			T result = caseMonolithicImplementation(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.CCMMODEL)){
			T result = caseCCMModel(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		}  else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.DOMAIN)){
			T result = caseCCMDomain(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		}  else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.BRIDGE)){
			T result = caseCCMBridge(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		}  else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.INTERCONNECT)){
			T result = caseCCMInterconnect(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		}  else if(ZDLUtil.isZDLConcept(theEObject, CCMNames.NODE)){
			T result = caseCCMNode(theEObject);
			if(result == null) result = defaultCase(theEObject);
			return result;
		} 
		
		return defaultCase(theEObject);
	}
	
	protected T caseCCMNode(EObject theEObject) {
		return null;
	}

	protected T caseCCMInterconnect(EObject theEObject) {
		return null;
	}

	protected T caseCCMBridge(EObject theEObject) {
		return null;
	}

	protected T caseCCMDomain(EObject theEObject) {
		return null;
	}

	protected T caseEventPort(EObject eventPort) {
		return null;
	}

	protected T caseInterfacePort(EObject interfacePort) {
		return null;
	}
	
	protected T caseCCMComponent(EObject ccmComponent) {
		return null;
	}
	
	protected T caseHome(EObject home) {
		return null;
	}
	
	protected T caseEvent(EObject event) {
		return null;
	}
	
	protected T caseManages(EObject object) {
		return null;
	}
	
	protected T caseManagesEnd(EObject object) {
		return null;
	}
	
	protected T caseCCMModel(EObject object) {
		return null;
	}
	
	protected T caseAssemblyImplementation(EObject object) {
		return null;
	}
	
	protected T caseCCMConnector(EObject object) {
		return null;
	}
	
	protected T caseCCMPart(EObject object) {
		return null;
	}
	
	protected T caseHomeImplementation(EObject object) {
		return null;
	}
	
	protected T caseManagesImpl(EObject object) {
		return null;
	}
	
	protected T caseMonolithicImplementation(EObject object) {
		return null;
	}
	
	protected T defaultCase(EObject object) {
		return null;
	}
}
