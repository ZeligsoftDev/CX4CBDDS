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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.type.baseimpl.BuiltinMetaModel;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;
import org.eclipse.xtend.typesystem.emf.EmfListType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The oAW type implementation for a ZDL Concept.  This is used for any concept,
 * including those that are abstract mappings and those that map to UML Profile
 * classes.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLConceptType
		extends AbstractTypeImpl {

	private ZDLMetamodel metamodel;

	private Class domainConcept;

	/**
	 * Initializes me with my source metamodel and my domain concept.
	 * 
	 * @param metamodel
	 *            the metamodel that created me
	 * @param domainConcept
	 *            the domain concept that I encapsulate
	 */
	public ZDLConceptType(ZDLMetamodel metamodel, Class domainConcept) {
		super(metamodel.getTypeSystem(), domainConcept.getQualifiedName());

		this.metamodel = metamodel;
		this.domainConcept = domainConcept;
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
		return domainConcept.isAbstract();
	}

	@Override
	public Feature[] getContributedFeatures() {
		List<Feature> result = new java.util.ArrayList<Feature>();

		// create oAW properties for DomainAttributes and the source ends of
		// DomainReferences
		for (org.eclipse.uml2.uml.Property next : domainConcept.getAttributes()) {
			boolean create = ZDLMetamodel.isStereotypedAs(next,
				ZDLMetamodel.DOMAIN_ATTRIBUTE);

			if (!create) {
				Association assoc = next.getAssociation();
				create = ((assoc != null) && ZDLMetamodel.isStereotypedAs(assoc,
					ZDLMetamodel.DOMAIN_REFERENCE));
			}

			if (create) {
				Type propertyType = null;
				
				if (next.getType() != null) {
					// get the ZDLConcept type or UML type (or, even, oAW
					// type in the case of primitives)
					propertyType = getTypeSystem().getTypeForName(
						next.getType().getQualifiedName());
				}
				
				if (propertyType == null) {
					// shouldn't be!  Substitute Object for this degenerate case
					propertyType = getTypeSystem().getObjectType();
				}
				
				// we apply special translations to enum-valued attributes
				boolean isEnumAttribute = propertyType instanceof ZDLEnumType;
				
				if (next.isMultivalued()) {
					// this is a list type
					propertyType = new EmfListType(propertyType,
						getTypeSystem(), listTypeName(propertyType));
				}

				ZDLProperty zdlProperty;
				if (isEnumAttribute) {
					zdlProperty = new ZDLEnumProperty(this, next, propertyType);
				} else {
					zdlProperty = new ZDLProperty(this, next, propertyType);
				}
				
				result.add(zdlProperty);

				if (!(next.isReadOnly() || next.isMultivalued())) {
					// add the mutator operation, but not if multi-valued
					// because in that case we require modification of the list
					// contents
					result.add(new ZDLMutator(zdlProperty));
				}
			}
		}

		// operations not implemented in ZDL, yet

		return result.toArray(new Feature[result.size()]);
	}

	/**
	 * Computes a user-friendly name for a list type.
	 * 
	 * @param type the list type's element type
	 * @return the corresponding list type name
	 */
	private static String listTypeName(Type type) {
		return new StringBuilder(BuiltinMetaModel.LIST).append('[').append(
			type.getName()).append(']').toString();
	}

	@Override
	protected Set<? extends Type> internalGetSuperTypes() {
		Set<Type> result = new java.util.HashSet<Type>();

		for (Class next : domainConcept.getSuperClasses()) {
			// all of these will provide the ZDLObject supertype
			result.add(getTypeSystem().getTypeForName(next.getQualifiedName()));
		}

		if (result.isEmpty()) {
			// ensure that, at least, ZDLObject is a supertype
			result.add(metamodel.getZDLObjectType());
		}

		return result;
	}

	public boolean isInstance(Object o) {
		// use the qualified name because we have to use the object's local
		// copy of our concept, which is profile- and resourceset-specific
		return (o instanceof EObject)
			&& ZDLUtil.isZDLConcept((EObject) o, domainConcept.getQualifiedName());
	}

	public Object newInstance() {
		return metamodel.create(domainConcept.getQualifiedName());
	}
	
	private String metaclass = "";
	
	public void setMetaclass(String mc) {
		this.metaclass = mc;
	}
	
	public String getMetaclass() {
		return this.metaclass;
	}
	
	public Class getDomainConcept() {
		return this.domainConcept;
	}

}
