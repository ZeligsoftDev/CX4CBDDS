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
package com.zeligsoft.base.validation.links;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.LinkConstraintContext;

/**
 * A lazily-populated cache of link constraint implementations.
 * 
 * @author Christian W. Damus (cdamus)
 */
class LinkConstraintCache {

	private final LinkConstraintManager mgr;

	/**
	 * Initializes me with the link constraint manager that I use to create
	 * constraints.
	 * 
	 * @param mgr
	 *            my link constraint manager
	 */
	LinkConstraintCache(LinkConstraintManager mgr) {
		this.mgr = mgr;
	}

	/**
	 * Queries the binary link constraints applicable to the specified source
	 * and target concepts, in the given application context.
	 * 
	 * @param ctx
	 *            the application context in which to check link constraints
	 * @param sourceConcept
	 *            the source concept to filter on
	 * @param targetConcept
	 *            the target concept to filter on
	 * @param profile
	 *            the domain profile that defines the scope of applicable link
	 *            constraints (by the domain-blocks that its source
	 *            domain-specialization references)
	 * @return the link constraints in the specified context, constraining the
	 *         given source and target concepts
	 */
	List<IBinaryLinkConstraint> getBinaryLinkConstraints(
			LinkConstraintContext ctx, Class sourceConcept,
			Class targetConcept, Profile profile) {

		List<IBinaryLinkConstraint> sourceConstraints = getSourceLinkConstraints(
			sourceConcept, profile);
		List<IBinaryLinkConstraint> result;

		if (sourceConstraints.isEmpty()) {
			result = Collections.emptyList();
		} else {
			result = new java.util.ArrayList<IBinaryLinkConstraint>(
				sourceConstraints.size());

			for (IBinaryLinkConstraint next : sourceConstraints) {
				if ((next.getContext() == ctx) && next.targets(targetConcept)) {
					result.add(next);
				}
			}
		}

		return result;
	}

	/**
	 * Obtains all of the binary link constraints in the context of the
	 * specified source concept.
	 * 
	 * @param concept
	 *            the binary link constraint source
	 * @param context
	 *            the domain profile that defines the scope of applicable link
	 *            constraints (by the domain-blocks that its source
	 *            domain-specialization references)
	 * @return the constraints
	 */
	List<IBinaryLinkConstraint> getSourceLinkConstraints(Class concept,
			Profile context) {
		
		return getCache(context).getSourceLinkConstraints(concept);
	}

	/**
	 * Ensures that the specified profile is adapted and returns its
	 * lazily-created cache.
	 * 
	 * @param profile
	 *            a domain profile
	 * @return its cache (never <code>null</code>)
	 */
	ProfileCache getCache(Profile profile) {
		ProfileCache result = (ProfileCache) EcoreUtil.getExistingAdapter(
			profile, ProfileCache.class);

		if (result == null) {
			result = new ProfileCache();
			profile.eAdapters().add(result);
		}

		return result;
	}

	/**
	 * A cache of link constraints applicable in the context of a particular
	 * domain profile. This cache must be maintained on a per-concept
	 * per-profile basis because constraints cannot be maintained globally per
	 * concept. The constraints applicable to a concept are not all known at the
	 * time of the first validation, because some other domain that constrains
	 * it may not even be loaded, yet. Caching constraints per profile ensures
	 * that all of the constraints applicable to a given profile are know at the
	 * right time, because it references all of the domain blocks in which the
	 * constraints are defined.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	private class ProfileCache
			extends AdapterImpl {

		private Map<String, List<IBinaryLinkConstraint>> binaryLinkConstraints = new java.util.HashMap<String, List<IBinaryLinkConstraint>>();

		/**
		 * Initializes me.
		 */
		private ProfileCache() {
			super();
		}

		/**
		 * Obtains all of the binary link constraints in the context of the
		 * specified source concept.
		 * 
		 * @param concept
		 *            the binary link constraint source
		 * @param context
		 *            the domain profile that defines the scope of applicable
		 *            link constraints (by the domain-blocks that its source
		 *            domain-specialization references)
		 * @return the constraints
		 */
		List<IBinaryLinkConstraint> getSourceLinkConstraints(Class concept) {
			String qname = concept.getQualifiedName();
			List<IBinaryLinkConstraint> result = binaryLinkConstraints
				.get(qname);

			if (result == null) {
				result = mgr.createSourceLinkConstraints(concept, getProfile());
				binaryLinkConstraints.put(qname, result);
			}

			return result;
		}

		/**
		 * Obtains the profile that I adapt.
		 * 
		 * @return my profile
		 */
		Profile getProfile() {
			return (Profile) getTarget();
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == ProfileCache.class;
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			super.unsetTarget(oldTarget);

			binaryLinkConstraints = null;
		}
	}
}
