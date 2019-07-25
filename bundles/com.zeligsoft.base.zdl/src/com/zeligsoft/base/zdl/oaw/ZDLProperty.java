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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtend.typesystem.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The oAW representation of a ZDL domain attribute or source of a domain
 * reference.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLProperty
		extends PropertyImpl {

	private Property domainProperty;

	/**
	 * Initializes me with my owner type, domain property, and type.
	 * 
	 * @param owner
	 *            the type that owns me
	 * @param domainProperty
	 *            the domain-property that I represent
	 * @param type
	 *            my oAW type
	 */
	public ZDLProperty(ZDLConceptType owner, Property domainProperty, Type type) {
		super(owner, domainProperty.getName(), type);

		this.domainProperty = domainProperty;
	}

	public Object get(Object target) {
		// use the qualified name because we have to use the object's local
		// copy of our concept
		return ZDLUtil.getValue((EObject) target, domainProperty.getClass_()
			.getQualifiedName(), domainProperty.getName());
	}

	@Override
	public void set(Object target, Object newValue) {
		ZDLUtil.setValue((EObject) target, domainProperty.getClass_()
			.getQualifiedName(), domainProperty.getName(), newValue);
	}

}
