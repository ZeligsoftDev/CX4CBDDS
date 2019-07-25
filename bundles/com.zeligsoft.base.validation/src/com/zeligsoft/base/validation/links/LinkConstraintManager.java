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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.validation.Activator;
import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.util.InvalidConstraintException;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A factory and cache for {@linkplain ILinkConstraint link constraints}.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class LinkConstraintManager {

	private static final LinkConstraintManager INSTANCE = new LinkConstraintManager();

	private final Map<String, Map<String, ILinkConstraintFactory<ILinkConstraint>>> generalLinkConstraintFactories = new java.util.HashMap<String, Map<String, ILinkConstraintFactory<ILinkConstraint>>>();

	private final Map<String, Map<String, ILinkConstraintFactory<IBinaryLinkConstraint>>> binaryLinkConstraintFactories = new java.util.HashMap<String, Map<String, ILinkConstraintFactory<IBinaryLinkConstraint>>>();

	private final LinkConstraintCache cache;

	/**
	 * Initializes me.
	 */
	private LinkConstraintManager() {
		cache = new LinkConstraintCache(this);
	}

	/**
	 * Obtains the link constraint manager.
	 * 
	 * @return the link constraint manager
	 */
	public static LinkConstraintManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Obtains the binary link constraints available in the specified context,
	 * to check linking the specified <tt>source</tt> element to the
	 * <tt>target</tt>.
	 * 
	 * @param ctx
	 *            an application context
	 * @param source
	 *            the proposed source element of the link
	 * @param target
	 *            the proposed target element of the link
	 * 
	 * @return the applicable link constraints, which may well be an empty
	 *         collection
	 */
	public Collection<IBinaryLinkConstraint> getConstraints(
			LinkConstraintContext ctx, EObject source, EObject target) {

		Collection<IBinaryLinkConstraint> result = new java.util.ArrayList<IBinaryLinkConstraint>(
			4);

		for (Class sourceConcept : ZDLUtil.getZDLConcepts(source)) {
			Profile profile = ZDLUtil.getZDLProfile(source, sourceConcept);
			
			for (Class targetConcept : ZDLUtil.getZDLConcepts(target)) {
				result.addAll(cache.getBinaryLinkConstraints(ctx,
					sourceConcept, targetConcept, profile));
			}
		}

		return result;
	}

	/**
	 * Obtains all of the binary link constraints defined in the context of the
	 * specified source domain concept.
	 * 
	 * @param concept
	 *            a domain concept
	 * @param context
	 *            the domain profile that defines the scope of applicable link
	 *            constraints (by the domain-blocks that its source
	 *            domain-specialization references)
	 * 
	 * @return the applicable binary link constraints
	 */
	List<IBinaryLinkConstraint> createSourceLinkConstraints(Class concept,
			Profile context) {
		
		// start with constraints owned by the source concept
		List<Constraint> domainConstraints = new java.util.ArrayList<Constraint>(
			ZDLUtil.<Constraint> getObjectsByConcept(concept.getOwnedRules(),
				ZDLNames.DOMAIN_LINK_CONSTRAINT));

		// then constraints owned by domain-references sourced in the concept
		for (Property end : concept.getOwnedAttributes()) {
			Association assoc = end.getAssociation();

			if ((assoc != null)
				&& ZDLUtil.isZDLConcept(assoc, ZDLNames.DOMAIN_REFERENCE)) {
				domainConstraints.addAll(assoc.getOwnedRules());
			}
		}

		// and, finally, constraints owned by others that reference the concept
		// as source, as long as they are in a domain-block that generated the
		// contextual profile
		Collection<Package> contextDomainBlocks = ZDLUtil
			.getSourceDomainBlocks(context);
		List<EObject> sourceRefs = ZDLUtil.getInverseReferences(concept,
			ZDLNames.DOMAIN_LINK_CONSTRAINT,
			ZDLNames.DOMAIN_LINK_CONSTRAINT__SOURCE);
		for (EObject next : sourceRefs) {
			if ((next instanceof Constraint)
				&& !domainConstraints.contains(next)) {

				Constraint constraint = (Constraint) next;

				// is this constraint applicable in this domain?
				if (contextDomainBlocks.contains(constraint.getContext())) {
					domainConstraints.add(constraint);
				}
			}
		}

		Set<IBinaryLinkConstraint> linkConstraints = createSourceLinkConstraints(
			concept, domainConstraints);

		// inherit constraints
		for (Classifier parent : concept.getGenerals()) {
			if (parent instanceof Class) {
				linkConstraints.addAll(cache
					.getSourceLinkConstraints((Class) parent, context));
			}
		}

		// disinherit redefined constraints
		for (Constraint next : domainConstraints) {
			for (Constraint redefined : getRedefinedConstraints(next)) {
				removeConstraint(linkConstraints, getID(redefined));
			}
		}

		return new java.util.ArrayList<IBinaryLinkConstraint>(linkConstraints);
	}

	/**
	 * Queries the constraints that are redefined by the specified
	 * domain-concept constraint.
	 * 
	 * @param domainConstraint
	 *            a domain-concept constraint
	 * @return the constraints that it re-defines, or an empty collection if
	 *         none
	 */
	@SuppressWarnings("unchecked")
	private Collection<Constraint> getRedefinedConstraints(
			Constraint domainConstraint) {

		return (Collection<Constraint>) ZDLUtil.getValue(domainConstraint,
			ZDLNames.DOMAIN_LINK_CONSTRAINT,
			ZDLNames.DOMAIN_LINK_CONSTRAINT__REDEFINED_CONSTRAINT);
	}

	/**
	 * Obtains the ID of the specified domain link constraint.
	 * 
	 * @param linkConstraint
	 *            a link constraint
	 * @return its ID
	 */
	public static String getID(Constraint linkConstraint) {
		if (linkConstraint.getContext() instanceof Association) {
			// the associations in ZDL models are usually unnamed. Base the ID
			// ton the navigable end
			Association assoc = ((Association) linkConstraint.getContext());

			Property sourceEnd = !assoc.getOwnedEnds().isEmpty()
				? assoc.getOwnedEnds().get(0).getOtherEnd()
				: assoc.getMemberEnds().get(0);
				
			StringBuilder result = new StringBuilder(sourceEnd
				.getQualifiedName());
			result.append(NamedElement.SEPARATOR);
			result.append(linkConstraint.getName());
			return result.toString();
		} else {
			return linkConstraint.getQualifiedName();
		}
	}

	/**
	 * Removes, from a bunch of link constraints, the one that is identified by
	 * a particular ID.
	 * 
	 * @param constraints
	 *            link constraints
	 * @param id
	 *            the ID of the constraint to remove
	 */
	private void removeConstraint(
			Collection<? extends ILinkConstraint> constraints, String id) {
		for (Iterator<? extends ILinkConstraint> iter = constraints.iterator(); iter
			.hasNext();) {

			if (id.equals(iter.next().getID())) {
				iter.remove();
				break;
			}
		}
	}

	/**
	 * Creates the binary link constraints defined exactly in the context of the
	 * specified concept, which is the source of the constraints.
	 * 
	 * @param concept
	 *            a domain concept
	 * @param domainConstraints
	 *            the domain-model link constraints that it owns
	 * @return the binary link constraints that it defines, of which it is the
	 *         source end. These do not include inherited constraints
	 */
	private Set<IBinaryLinkConstraint> createSourceLinkConstraints(
			Class concept, Collection<? extends Constraint> domainConstraints) {

		Set<IBinaryLinkConstraint> result = new java.util.HashSet<IBinaryLinkConstraint>();

		for (Constraint next : domainConstraints) {
			if (ZDLUtil.isZDLConcept(next, ZDLNames.DOMAIN_LINK_CONSTRAINT)) {
				if (next.getSpecification() instanceof OpaqueExpression) {
					OpaqueExpression specification = (OpaqueExpression) next
						.getSpecification();

					EnumerationLiteral kind = (EnumerationLiteral) ZDLUtil
						.getValue(next, ZDLNames.DOMAIN_LINK_CONSTRAINT,
							ZDLNames.DOMAIN_LINK_CONSTRAINT__KIND);
					String language = specification.getLanguages().isEmpty()
						? null
						: specification.getLanguages().get(0);

					ILinkConstraintFactory<IBinaryLinkConstraint> factory = getBinaryLinkConstraintFactory(
						kind.getName(), language);

					if (factory != null) {
						try {
							result.add(factory.createLinkConstraint(next));
						} catch (InvalidConstraintException e) {
							Activator.getDefault().error(
								Messages.LinkConstraintManager_create, e);
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Registers a factory for a particular <tt>type</tt> of link constraint.
	 * 
	 * @param <T>
	 *            the link constraint type that the factory creates
	 * 
	 * @param factory
	 *            the factory to register
	 */
	public <T extends ILinkConstraint> void registerFactory(
			ILinkConstraintFactory<T> factory) {

		if (IBinaryLinkConstraint.class.isAssignableFrom(factory.getType())) {
			Map<String, ILinkConstraintFactory<IBinaryLinkConstraint>> map = binaryLinkConstraintFactories
				.get(factory.getKind());
			if (map == null) {
				map = new java.util.HashMap<String, ILinkConstraintFactory<IBinaryLinkConstraint>>();
				binaryLinkConstraintFactories.put(factory.getKind(), map);
			}

			@SuppressWarnings("unchecked")
			ILinkConstraintFactory<IBinaryLinkConstraint> binaryFactory = (ILinkConstraintFactory<IBinaryLinkConstraint>) factory;
			map.put(factory.getLanguage(), binaryFactory);
		} else {
			Map<String, ILinkConstraintFactory<ILinkConstraint>> map = generalLinkConstraintFactories
				.get(factory.getKind());
			if (map == null) {
				map = new java.util.HashMap<String, ILinkConstraintFactory<ILinkConstraint>>();
				generalLinkConstraintFactories.put(factory.getKind(), map);
			}

			@SuppressWarnings("unchecked")
			ILinkConstraintFactory<ILinkConstraint> generalFactory = (ILinkConstraintFactory<ILinkConstraint>) factory;
			map.put(factory.getLanguage(), generalFactory);
		}
	}

	/**
	 * Obtains a binary link-constraint factory for the specified ZDL link
	 * constraint kind and language.
	 * 
	 * @param kind
	 *            the link constraint kind as specified in the ZDL model
	 * @param language
	 *            the link constraint specification language
	 * @return the binary link constraint factory, or <code>null</code> if none
	 *         is defined for this combination of kind and language
	 */
	ILinkConstraintFactory<IBinaryLinkConstraint> getBinaryLinkConstraintFactory(
			String kind, String language) {
		ILinkConstraintFactory<IBinaryLinkConstraint> result = null;

		Map<String, ILinkConstraintFactory<IBinaryLinkConstraint>> map = binaryLinkConstraintFactories
			.get(kind);
		if (map != null) {
			result = map.get(language);
		}

		return result;
	}
}
