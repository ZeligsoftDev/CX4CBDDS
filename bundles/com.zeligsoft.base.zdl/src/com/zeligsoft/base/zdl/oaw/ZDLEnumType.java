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

import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;

/**
 * The oAW representation of a ZDL enumeration.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLEnumType
		extends AbstractTypeImpl {

	private ZDLMetamodel metamodel;

	private Enumeration domainEnum;

	private Map<String, Instance> instances = new java.util.HashMap<String, Instance>();

	/**
	 * Initializes me with my source metamodel and my domain enumeration.
	 * 
	 * @param metamodel
	 *            the metamodel that created me
	 * @param domainEnum
	 *            the domain enumeration that I encapsulate
	 */
	public ZDLEnumType(ZDLMetamodel metamodel, Enumeration domainEnum) {
		super(metamodel.getTypeSystem(), domainEnum.getQualifiedName());

		this.metamodel = metamodel;
		this.domainEnum = domainEnum;
	}

	/**
	 * Obtains the metamodel that owns me.
	 * 
	 * @return my metamodel
	 */
	protected ZDLMetamodel getMetamodel() {
		return metamodel;
	}

	@Override
	public boolean isAbstract() {
		return false; // enumerations are, by construction, never abstract
	}

	@Override
	public Feature[] getContributedFeatures() {
		List<Feature> result = new java.util.ArrayList<Feature>();

		for (EnumerationLiteral next : domainEnum.getOwnedLiterals()) {
			// oAW represents enumeration literals as "static properties"
			result.add(new ZDLEnumLiteral(this, next));
		}

		// operations not implemented in ZDL, yet

		return result.toArray(new Feature[result.size()]);
	}

	public boolean isInstance(Object o) {
		// use the qualified name because we have to use the object's local
		// copy of our concept
		return (o instanceof Instance) && (this == ((Instance) o).getType());
	}

	public Object newInstance() {
		throw new UnsupportedOperationException(
			"Enumerations have fixed extent"); //$NON-NLS-1$
	}

	/**
	 * Obtains the internal representation of an enumeration literal (the
	 * canonical "instance") for the specified domain enumeration literal.
	 * 
	 * @param domainEnumLiteral
	 *            a ZDL enumeration literal
	 * @return the internal representation of the literal, to support oAW's type
	 *         conversion and other requirements
	 */
	Instance getInstance(EnumerationLiteral domainEnumLiteral) {
		if (domainEnumLiteral == null) {
			return null;
		}

		String literal = domainEnumLiteral.getName();
		Instance result = instances.get(literal);
		if (result == null) {
			result = new Instance(domainEnumLiteral);
			instances.put(literal, result);
		}

		return result;
	}

	/**
	 * An internal representation of the literal values of a ZDL enumeration.
	 * This provides oAW-friendly services such as a useful toString() for text
	 * generation using Xpand, that would be difficult or impossible to
	 * implement using the MDT UML {@link EnumerationLiteral}.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	final class Instance {

		private String literal;

		/**
		 * Initializes me with my ZDL enumeration literal.
		 * 
		 * @param domainEnumLiteral
		 *            my ZDL literal
		 */
		private Instance(EnumerationLiteral domainEnumLiteral) {
			this.literal = domainEnumLiteral.getName();
		}

		/**
		 * Obtains my defining type.
		 * 
		 * @return my type
		 */
		ZDLEnumType getType() {
			return ZDLEnumType.this;
		}

		@Override
		public String toString() {
			return literal;
		}
	}
}
