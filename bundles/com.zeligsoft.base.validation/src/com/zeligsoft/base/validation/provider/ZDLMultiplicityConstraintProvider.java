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
package com.zeligsoft.base.validation.provider;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IModelConstraintProvider;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.constraints.ZDLMultiplicityConstraint;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A constraint provider that generates, on-the-fly, constraints to check the
 * cardinalities of ZDL properties. These constraints are not individually
 * registered. Rather, a proxy constraint is registered that is visible in the
 * preference page.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLMultiplicityConstraintProvider
		implements IModelConstraintProvider {

	/**
	 * Initializes me.
	 */
	public ZDLMultiplicityConstraintProvider() {
		super();
	}

	@Override
	public Collection<IModelConstraint> getBatchConstraints(EObject object,
			Collection<IModelConstraint> constraints) {
		if (!(object instanceof Element)) {
			throw new IllegalArgumentException("object is not a UML Element"); //$NON-NLS-1$
		}

		Collection<IModelConstraint> result = notNull(constraints);

		for (Class concept : ZDLUtil.getZDLConcepts(object)) {
			result.addAll(getConstraints(concept));
		}

		return result;
	}

	@Override
	public Collection<IModelConstraint> getLiveConstraints(
			Notification notification, Collection<IModelConstraint> constraints) {

		// don't check cardinalities in live mode
		return notNull(constraints);
	}

	private static Collection<IModelConstraint> notNull(
			Collection<IModelConstraint> constraints) {
		return (constraints == null)
			? new java.util.ArrayList<IModelConstraint>()
			: constraints;
	}

	/**
	 * Obtains the lazily-created multiplicity constraints for the specified ZDL
	 * concept. These constraints are cached in the UML CacheAdapter at the
	 * resource scope, because we only need to purge them if and when the ZDL
	 * model that defines the censtraint is unloaded.
	 * 
	 * @param concept
	 *            a ZDL concept for which to get its multiplicity constraints
	 * @return its multiplicity constraints, which may be an empty collection in
	 *         the case that the concept defines no attributes
	 */
	Collection<? extends IModelConstraint> getConstraints(Class concept) {
		CacheAdapter cache = CacheAdapter.getCacheAdapter(concept);
		if (cache == null) {
			cache = CacheAdapter.INSTANCE;
			cache.adapt(concept);
		}

		Resource context = concept.eResource();

		@SuppressWarnings("unchecked")
		Collection<IModelConstraint> result = (Collection<IModelConstraint>) cache
			.get(context, concept, ZDLMultiplicityConstraintProvider.class);

		if (result == null) {
			result = createConstraints(concept);
			cache.put(context, concept,
				ZDLMultiplicityConstraintProvider.class, result);
		}

		return result;
	}

	/**
	 * Creates the constraints that check the cardinalities of the particular
	 * attributes owned (defined by) the specified domain concept. Specifically,
	 * this does not include constraints for inherited attributes. Note, also,
	 * that not all attributes require constraints. For example, the <tt>*</tt>
	 * multiplicity cannot ever be violated.
	 * 
	 * @param concept
	 *            a domain concept
	 * @return the collection of constraints (possibly empty) for the attributes
	 *         that it defines.
	 */
	private Collection<IModelConstraint> createConstraints(Class concept) {
		// use a set because we may multiply inherit constraints through
		// an inheritance diamond
		Set<IModelConstraint> result = new java.util.HashSet<IModelConstraint>();
		Set<Property> redefined = new java.util.HashSet<Property>();

		for (Property attribute : concept.getOwnedAttributes()) {
			// don't need to check [0..1] properties or [0..*] because the
			// UML2 implementation can't violate these multiplicities
			if ((attribute.getLower() > 0) || (attribute.getUpper() > 1)) {
				result.add(new ZDLMultiplicityConstraint(attribute));
			}

			redefined.addAll(attribute.getRedefinedProperties());
		}

		// inherit constraints, except for properties that we have redefined
		for (Class superConcept : concept.getSuperClasses()) {
			for (IModelConstraint next : getConstraints(superConcept)) {
				if (!redefined.contains(((ZDLMultiplicityConstraint) next)
					.getDomainAttribute())) {

					result.add(next);
				}
			}
		}

		return new java.util.ArrayList<IModelConstraint>(result);
	}
}
