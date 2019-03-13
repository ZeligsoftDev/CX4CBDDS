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
package com.zeligsoft.domain.idl3plus.utils;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public class IDL3PlusSwitch<T>{
	
	public IDL3PlusSwitch() {
		// Nothing to do
	}

	public T doSwitch(EObject modelElement) {
		if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.CONNECTOR_DEF)) {
			T result = caseConnectorDef(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.CONNECTOR_FRAGMENT)) {
			T result = caseConnectorFragment(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.FRAGMENT_IMPLEMENTATION)) {
			T result = caseFragmentImplementation(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.FRAGMENT_ASSEMBLY)) {
			T result = caseFragmentAssembly(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.CONNECTOR_IMPLEMENTATION)) {
			T result = caseConnectorImplementation(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.CONNECTOR_ASSEMBLY)) {
			T result = caseConnectorAssembly(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.FRAGMENT_PART)) {
			T result = caseFragmentPart(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.TYPED_CONNECTOR)) {
			T result = caseTypedConnector(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.TYPE_PARAMETER)) {
			T result = caseTypeParameter(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.TEMPLATE_MODULE)) {
			T result = caseTemplateModule(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.MODULE_INSTANTIATION)) {
			T result = caseModuleInstantiation(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.PARAMETER_BINDING)) {
			T result = caseParameterBinding(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.TEMPLATE_MODULE_ALIAS)) {
			T result = caseTemplateModuleAlias(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.MODULE_BINDING)) {
			T result = caseModuleBinding(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} else if(ZDLUtil.isZDLConcept(modelElement, IDL3PlusNames.TEMPLATE_SIGNATURE)) {
			T result = caseTemplateSignature(modelElement);
			if(result == null) result = defaultCase(modelElement);
			return result;
		} 
		
		return defaultCase(modelElement);
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseTemplateModule(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseTemplateSignature(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseModuleBinding(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseTemplateModuleAlias(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseParameterBinding(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseModuleInstantiation(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseTypeParameter(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseTypedConnector(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseFragmentPart(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseConnectorAssembly(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseConnectorImplementation(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseFragmentAssembly(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseFragmentImplementation(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseConnectorFragment(EObject modelElement) {
		return null;
	}

	/**
	 * @param modelElement
	 * @return
	 */
	protected T caseConnectorDef(EObject modelElement) {
		return null;
	}
	
	protected T defaultCase(EObject object) {
		return null;
	}
}
