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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.type.baseimpl.types.CollectionTypeImpl;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtend.typesystem.Type;

import com.zeligsoft.base.util.TransformingList;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A specialization of the ZDL property implementation that translates the
 * literal values of enumerations to/from our internal representation.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLEnumProperty
		extends ZDLProperty {

	private ZDLEnumType enumType;

	/**
	 * Initializes me with my owner concept, domain property, and oAW type.
	 * 
	 * @param owner
	 *            my owner concept type
	 * @param domainProperty
	 *            the domain property that I represent
	 * @param type
	 *            my type
	 */
	public ZDLEnumProperty(ZDLConceptType owner, Property domainProperty,
			Type type) {
		super(owner, domainProperty, type);

		this.enumType = (type instanceof CollectionTypeImpl)
			? (ZDLEnumType) ((CollectionTypeImpl) type).getInnerType()
			: (ZDLEnumType) type;
	}

	@Override
	@SuppressWarnings("serial")
	public Object get(final Object target) {
		// convert from the enumeration literal to our ZDLEnumType.Instance
		Object result = super.get(target);

		if (result instanceof EList) {
			// a transforming-list to automatically convert multiple values
			@SuppressWarnings("unchecked")
			EList<EnumerationLiteral> resultList = (EList<EnumerationLiteral>) result;
			result = new TransformingList<ZDLEnumType.Instance, EnumerationLiteral>(
				resultList) {

				@Override
				protected ZDLEnumType.Instance transform(
						EnumerationLiteral sourceElement) {
					return enumType.getInstance(sourceElement);
				}

				@Override
				protected EnumerationLiteral inverse(
						ZDLEnumType.Instance targetElement) {
					return ZDLUtil.getZDLEnumLiteral((EObject) target, enumType
						.getName(), targetElement.toString());
				}
			};
		} else {
			// a single value to convert
			result = enumType.getInstance((EnumerationLiteral) result);
		}

		return result;
	}

	@Override
	public void set(Object target, Object newValue) {
		// convert from our Instance object to the enumeration literal in the
		// object's resource set context.
		// Note that list values aren't an issue because we don't provide
		// mutators for multi-valued attributes
		ZDLEnumType.Instance instance = (ZDLEnumType.Instance) newValue;

		EnumerationLiteral literal = null;
		if (instance != null) {
			literal = ZDLUtil.getZDLEnumLiteral((EObject) target, enumType
				.getName(), instance.toString());
		}

		super.set(target, literal);
	}

}
