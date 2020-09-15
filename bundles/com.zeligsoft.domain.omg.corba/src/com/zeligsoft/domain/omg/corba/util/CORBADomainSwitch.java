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
import com.zeligsoft.domain.omg.corba.CXDomainNames;

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
		
		if (ZDLUtil.isZDLConcept(theEObject, CXDomainNames.IDLFILE)) {
			T result = caseIDLFile(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CXDomainNames.CXARRAY)) {
			T result = caseCXArray(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXTemplate(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXATTRIBUTE)) {
			T result = caseCXAttribute(theEObject);
			if (result == null)
				result = caseCXTyped(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CXDomainNames.CXCASE)) {
			T result = caseCXCase(theEObject);
			if (result == null)
				result = caseCXUnionField(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXCONSTANT)) {
			T result = caseCXConstant(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXCONSTANTS)) {
			T result = caseCXConstants(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXDEFAULT)) {
			T result = caseCXDefault(theEObject);
			if (result == null)
				result = caseCXUnionField(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject, CXDomainNames.CXENUM)) {
			T result = caseCXEnum(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXEXCEPTION)) {
			T result = caseCXException(theEObject);
			if (result == null)
				result = caseCXConstructed(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil
				.isZDLConcept(theEObject, CXDomainNames.CXFIELD)) {
			T result = caseCXField(theEObject);
			if (result == null)
				result = caseCXTyped(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXINTERFACE)) {
			T result = caseCXInterface(theEObject);
			if (result == null)
				result = caseCXClassifier(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXMODULE)) {
			T result = caseCXModule(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXOPERATION)) {
			T result = caseCXOperation(theEObject);
			if (result == null)
				result = caseCXTyped(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXPARAMETER)) {
			T result = caseCXParameter(theEObject);
			if (result == null)
				result = caseCXTyped(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXPRIMITIVE)) {
			T result = caseCXPrimitive(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXSEQUENCE)) {
			T result = caseCXSequence(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXTemplate(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXSTRING)) {
			T result = caseCXString(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXBounded(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXSTRUCT)) {
			T result = caseCXStruct(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXTYPE_DEF)) {
			T result = caseCXTypeDef(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXWrapper(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil
				.isZDLConcept(theEObject, CXDomainNames.CXUNION)) {
			T result = caseCXUnion(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXConstructed(theEObject);
			if (result == null)
				result = caseCXClassifierContained(theEObject);
			if (result == null)
				result = caseCXModuleContained(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXUNION_FIELD)) {
			T result = caseCXUnionField(theEObject);
			if (result == null)
				result = caseCXTyped(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		} else if (ZDLUtil.isZDLConcept(theEObject,
				CXDomainNames.CXWSTRING)) {
			T result = caseCXWString(theEObject);
			if (result == null)
				result = caseCXType(theEObject);
			if (result == null)
				result = caseCXBounded(theEObject);
			if (result == null)
				result = caseCXNamedElement(theEObject);
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

	protected T caseCXModuleContained(EObject corbaModuleContained) {
		return null;
	}

	protected T caseCXNamedElement(EObject namedElement) {
		return null;
	}

	protected T caseCXArray(EObject object) {
		return null;
	}

	protected T caseCXAttribute(EObject object) {
		return null;
	}

	protected T caseCXBounded(EObject object) {
		return null;
	}

	protected T caseCXBoxedValue(EObject object) {
		return null;
	}

	protected T caseCXCase(EObject object) {
		return null;
	}

	protected T caseCXClassifier(EObject object) {
		return null;
	}

	protected T caseCXClassifierContained(EObject object) {
		return null;
	}

	protected T caseCXConstant(EObject object) {
		return null;
	}

	protected T caseCXConstants(EObject object) {
		return null;
	}

	protected T caseCXConstructed(EObject object) {
		return null;
	}

	protected T caseCXDefault(EObject object) {
		return null;
	}

	protected T caseCXException(EObject object) {
		return null;
	}

	protected T caseCXField(EObject object) {
		return null;
	}

	protected T caseCXInterface(EObject object) {
		return null;
	}

	protected T caseCXModule(EObject object) {
		return null;
	}

	protected T caseCXOperation(EObject object) {
		return null;
	}

	protected T caseCXParameter(EObject object) {
		return null;
	}

	protected T caseCXPrimitive(EObject object) {
		return null;
	}

	protected T caseCXSequence(EObject object) {
		return null;
	}

	protected T caseCXString(EObject object) {
		return null;
	}

	protected T caseCXStruct(EObject object) {
		return null;
	}

	protected T caseCXSupports(EObject object) {
		return null;
	}

	protected T caseCXTemplate(EObject object) {
		return null;
	}

	protected T caseCXType(EObject object) {
		return null;
	}

	protected T caseCXTyped(EObject object) {
		return null;
	}

	protected T caseCXTypeDef(EObject object) {
		return null;
	}

	protected T caseCXUnion(EObject object) {
		return null;
	}

	protected T caseCXUnionField(EObject object) {
		return null;
	}

	protected T caseCXValue(EObject object) {
		return null;
	}

	protected T caseCXValueFactory(EObject object) {
		return null;
	}

	protected T caseCXWrapper(EObject object) {
		return null;
	}

	protected T caseCXWString(EObject object) {
		return null;
	}

	protected T caseCXEnum(EObject object) {
		return null;
	}

	protected T defaultCase(EObject object) {
		return null;
	}
}
