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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.type.baseimpl.OperationImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtend.typesystem.AbstractTypeImpl;
import org.eclipse.xtend.typesystem.Feature;
import org.eclipse.xtend.typesystem.Type;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * <p>
 * A special type that all ZDL concepts specialize, directly or indirectly. It
 * provides some common services to aid in the formulation of oAW
 * transformations.
 * </p>
 * <p>
 * Foremost among the features defined by the <tt>ZDLObject</tt> type is the
 * conversion of ZDL Concepts to UML elements, in anticipation of probable (or
 * required) ZDL-to-UML mappings in the particular domain. This is manifest in
 * <tt>zdlAsXyz()</tt> operations defined for every UML metaclass, which
 * return the ZDL concept as an instance of that metaclass. The result is
 * coccooned in a protective {@linkplain UMLBubble bubble} of UML-ness that is
 * not recognized by the ZDL metamodel as an instance of its ZDL concept, to
 * provide reliable access to its UML-defined features.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
class ZDLObjectType
		extends AbstractTypeImpl {

	private ZDLMetamodel metamodel;

	/**
	 * Initializes me with my metamodel.
	 * 
	 * @param metamodel
	 *            my owning metamodel
	 */
	public ZDLObjectType(ZDLMetamodel metamodel) {
		super(metamodel.getTypeSystem(), "ZDLObject"); //$NON-NLS-1$

		this.metamodel = metamodel;
	}

	@Override
	public Feature[] getContributedFeatures() {
		List<Feature> result = new java.util.ArrayList<Feature>(
			UMLPackage.eINSTANCE.getEClassifiers().size());

		// generate the 'zdlAsXyz()' conversion operations
		// TODO: Filter for relevance to components
		for (EClassifier next : UMLPackage.eINSTANCE.getEClassifiers()) {
			if (next instanceof EClass) {
				result.add(new OperationImpl(this, "zdlAs" + next.getName(), //$NON-NLS-1$
					metamodel.getTypeForName("uml::" + next.getName())) { //$NON-NLS-1$

						@Override
						protected Object evaluateInternal(Object target,
								Object[] params) {
							if (target instanceof Element) {
								Element element = (Element) target;
								return new UMLBubble(getReturnType(), element);
							}

							// not an element (e.g., instance of profile class)
							return null;
						}

					});
			}
		}

		return result.toArray(new Feature[result.size()]);
	}

	@Override
	public boolean isAbstract() {
		return true;
	}
	
	@Override
	protected Set<? extends Type> internalGetSuperTypes() {
		return Collections.singleton(metamodel.getBasicEObjectType());
	}

	public boolean isInstance(Object o) {
		return (o instanceof EObject)
			&& (ZDLUtil.getZDLConcept((EObject) o) != null);
	}

	public Object newInstance() {
		throw new UnsupportedOperationException("ZDLObject is an abstract type"); //$NON-NLS-1$
	}

}
