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
package com.zeligsoft.base.zdl.oaw;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EClassType;

/**
 * The ZDL implementation of the UML metamodel, which supports interoperability
 * of ZDL Concepts, UML metaclasses, and UML "bubbles."
 * 
 * @author Christian W. Damus (cdamus)
 */
class UMLMetamodel
		extends ZUML2MetaModelBase {

	private ZDLMetamodel zdl;

	private Map<Type, Type> umlMetaclasses = new java.util.HashMap<Type, Type>();

	private Type eobjectType;

	/**
	 * Initializes me.
	 * 
	 * @param zdl
	 *            my owning ZDL metamodel
	 */
	public UMLMetamodel(ZDLMetamodel zdl) {
		super(UMLPackage.eINSTANCE);
		this.zdl = zdl;
	}

	@Override
	public Type getTypeForEClassifier(EClassifier element) {
		return toUMLType(super.getTypeForEClassifier(element));
	}

	@Override
	public Type getTypeForName(String typeName) {
		return toUMLType(super.getTypeForName(typeName));
	}

	private Type toUMLType(Type type) {
		Type result = umlMetaclasses.get(type);

		if (result == null) {
			if (type instanceof EClassType) {
				result = new UMLMetaclassType(zdl, type);
			} else {
				result = type;
			}

			umlMetaclasses.put(type, result);
		}

		return result;
	}

	/**
	 * Obtains the ZDL-compatible metaclass represnting <tt>EObject</tt>.
	 * 
	 * @return the UML representation of <tt>EObject</tt>
	 */
	Type getUMLEObjectType() {
		if (eobjectType == null) {
			eobjectType = new UMLMetaclassType(zdl, getEobjectType());
			umlMetaclasses.put(getEobjectType(), eobjectType);
		}

		return eobjectType;
	}
}
