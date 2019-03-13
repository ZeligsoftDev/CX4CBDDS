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
package com.zeligsoft.domain.omg.corba.util;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;

/**
 * @author ysroh
 * 
 */
public class CORBADomainSwitch<T> {
	/**
	 * Create an instance of the switch
	 */
	public CORBADomainSwitch() {
		// Nothing to do
	}

	public T doSwitch(EObject theEObject) {
		
		if (ZDLUtil.isZDLConcept(theEObject, CORBADomainNames.IDLFILE)) {
			T result = caseIDLFile(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CORBADomainNames.CORBAARRAY)) {
			T result = caseCORBAArray(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBATemplate(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAATTRIBUTE)) {
			T result = caseCORBAAttribute(theEObject);
			if (result == null)
				result = caseCORBATyped(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CORBADomainNames.CORBACASE)) {
			T result = caseCORBACase(theEObject);
			if (result == null)
				result = caseCORBAUnionField(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBACONSTANT)) {
			T result = caseCORBAConstant(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBACONSTANTS)) {
			T result = caseCORBAConstants(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBADEFAULT)) {
			T result = caseCORBADefault(theEObject);
			if (result == null)
				result = caseCORBAUnionField(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CORBADomainNames.CORBAENUM)) {
			T result = caseCORBAEnum(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAEXCEPTION)) {
			T result = caseCORBAException(theEObject);
			if (result == null)
				result = caseCORBAConstructed(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil
				.isZDLConcept(theEObject, CORBADomainNames.CORBAFIELD)) {
			T result = caseCORBAField(theEObject);
			if (result == null)
				result = caseCORBATyped(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAINTERFACE)) {
			T result = caseCORBAInterface(theEObject);
			if (result == null)
				result = caseCORBAClassifier(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAMODULE)) {
			T result = caseCORBAModule(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAOPERATION)) {
			T result = caseCORBAOperation(theEObject);
			if (result == null)
				result = caseCORBATyped(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAPARAMETER)) {
			T result = caseCORBAParameter(theEObject);
			if (result == null)
				result = caseCORBATyped(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAPRIMITIVE)) {
			T result = caseCORBAPrimitive(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBASEQUENCE)) {
			T result = caseCORBASequence(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBATemplate(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBASTRING)) {
			T result = caseCORBAString(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBABounded(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBASTRUCT)) {
			T result = caseCORBAStruct(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBATYPE_DEF)) {
			T result = caseCORBATypeDef(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBAWrapper(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil
				.isZDLConcept(theEObject, CORBADomainNames.CORBAUNION)) {
			T result = caseCORBAUnion(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBAConstructed(theEObject);
			if (result == null)
				result = caseCORBAClassifierContained(theEObject);
			if (result == null)
				result = caseCORBAModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAUNION_FIELD)) {
			T result = caseCORBAUnionField(theEObject);
			if (result == null)
				result = caseCORBATyped(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CORBADomainNames.CORBAWSTRING)) {
			T result = caseCORBAWString(theEObject);
			if (result == null)
				result = caseCORBAType(theEObject);
			if (result == null)
				result = caseCORBABounded(theEObject);
			if (result == null)
				result = caseCORBANamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}

		return defaultCase(theEObject);
	}

	protected T caseIDLFile(EObject theEObject) {
		// TODO Auto-generated method stub
		return null;
	}

	protected T caseCORBAModuleContained(EObject corbaModuleContained) {
		return null;
	}

	protected T caseCORBANamedElement(EObject namedElement) {
		return null;
	}

	protected T caseCORBAArray(EObject object) {
		return null;
	}

	protected T caseCORBAAttribute(EObject object) {
		return null;
	}

	protected T caseCORBABounded(EObject object) {
		return null;
	}

	protected T caseCORBABoxedValue(EObject object) {
		return null;
	}

	protected T caseCORBACase(EObject object) {
		return null;
	}

	protected T caseCORBAClassifier(EObject object) {
		return null;
	}

	protected T caseCORBAClassifierContained(EObject object) {
		return null;
	}

	protected T caseCORBAConstant(EObject object) {
		return null;
	}

	protected T caseCORBAConstants(EObject object) {
		return null;
	}

	protected T caseCORBAConstructed(EObject object) {
		return null;
	}

	protected T caseCORBADefault(EObject object) {
		return null;
	}

	protected T caseCORBAException(EObject object) {
		return null;
	}

	protected T caseCORBAField(EObject object) {
		return null;
	}

	protected T caseCORBAInterface(EObject object) {
		return null;
	}

	protected T caseCORBAModule(EObject object) {
		return null;
	}

	protected T caseCORBAOperation(EObject object) {
		return null;
	}

	protected T caseCORBAParameter(EObject object) {
		return null;
	}

	protected T caseCORBAPrimitive(EObject object) {
		return null;
	}

	protected T caseCORBASequence(EObject object) {
		return null;
	}

	protected T caseCORBAString(EObject object) {
		return null;
	}

	protected T caseCORBAStruct(EObject object) {
		return null;
	}

	protected T caseCORBASupports(EObject object) {
		return null;
	}

	protected T caseCORBATemplate(EObject object) {
		return null;
	}

	protected T caseCORBAType(EObject object) {
		return null;
	}

	protected T caseCORBATyped(EObject object) {
		return null;
	}

	protected T caseCORBATypeDef(EObject object) {
		return null;
	}

	protected T caseCORBAUnion(EObject object) {
		return null;
	}

	protected T caseCORBAUnionField(EObject object) {
		return null;
	}

	protected T caseCORBAValue(EObject object) {
		return null;
	}

	protected T caseCORBAValueFactory(EObject object) {
		return null;
	}

	protected T caseCORBAWrapper(EObject object) {
		return null;
	}

	protected T caseCORBAWString(EObject object) {
		return null;
	}

	protected T caseCORBAEnum(EObject object) {
		return null;
	}

	protected T defaultCase(EObject object) {
		return null;
	}
}
