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
package com.zeligsoft.base.validation.links.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import com.zeligsoft.base.validation.Activator;
import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.validation.links.AbstractBinaryLinkConstraint;
import com.zeligsoft.base.validation.links.LinkConstraintManager;
import com.zeligsoft.base.validation.util.IOCLProvider;
import com.zeligsoft.base.validation.util.InvalidConstraintException;
import com.zeligsoft.base.validation.util.OCLCache;
import com.zeligsoft.base.zdl.LinkConstraintContext;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * The OCL implementation of a deployment link constraint.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class OCLLinkConstraint
		extends AbstractBinaryLinkConstraint
		implements IOCLProvider {

	/**
	 * The qualified name of my source ZDL concept.
	 */
	private String sourceConcept;

	/**
	 * The qualified name of my target ZDL concept.
	 */
	private String targetConcept;

	/**
	 * My OCL expression text.
	 */
	private String ocl;

	/**
	 * Initializes me with my OCL specification and my context.
	 * 
	 * @param specification
	 *            the link constraint specification
	 * @param ctx
	 *            the link-constraint context in which I apply
	 * 
	 * @throws InvalidConstraintException
	 *             if any required constraint metadata be missing or malformed
	 */
	public OCLLinkConstraint(Constraint specification, LinkConstraintContext ctx)
			throws InvalidConstraintException {

		super(LinkConstraintManager.getID(specification), specification
			.getLabel(), ctx);

		sourceConcept = getSourceConcept(specification).getQualifiedName();
		targetConcept = getTargetConcept(specification).getQualifiedName();
		ocl = getOCL(specification);
	}

	private static Class getSourceConcept(Constraint linkConstraint)
			throws InvalidConstraintException {

		Class result = (Class) ZDLUtil.getValue(linkConstraint,
			ZDLNames.DOMAIN_LINK_CONSTRAINT,
			ZDLNames.DOMAIN_LINK_CONSTRAINT__SOURCE);

		if (result == null) {
			Namespace context = linkConstraint.getContext();
			if (context instanceof Class) {
				result = (Class) context;
			} else if (context instanceof Association) {
				result = (Class) ((Association) context).getOwnedEnds().get(0)
					.getType();
			}
		}

		if (result == null) {
			throw new InvalidConstraintException(
				Messages.OCLLinkConstraint_noSource);
		}

		return result;
	}

	private static Class getTargetConcept(Constraint linkConstraint)
			throws InvalidConstraintException {

		Class result = (Class) ZDLUtil.getValue(linkConstraint,
			ZDLNames.DOMAIN_LINK_CONSTRAINT,
			ZDLNames.DOMAIN_LINK_CONSTRAINT__TARGET);

		if (result == null) {
			Namespace context = linkConstraint.getContext();
			if (context instanceof Association) {
				result = (Class) ((Association) context).getOwnedEnds().get(0)
					.getOtherEnd().getType();
			}
		}

		if (result == null) {
			throw new InvalidConstraintException(
				Messages.OCLLinkConstraint_noTarget);
		}

		return result;
	}

	private static String getOCL(Constraint linkConstraint)
			throws InvalidConstraintException {
		String result = null;

		if (linkConstraint.getSpecification() instanceof OpaqueExpression) {
			OpaqueExpression specification = (OpaqueExpression) linkConstraint
				.getSpecification();
			List<String> languages = specification.getLanguages();

			for (int i = 0; i < languages.size(); i++) {
				if (OCL_LANGUAGE.equalsIgnoreCase(languages.get(i))) {
					result = specification.getBodies().get(i);
					break;
				}
			}
		}

		if (result == null) {
			throw new InvalidConstraintException(
				Messages.OCLLinkConstraint_noBody);
		}

		return result;
	}

	@Override
	public String getConcept() {
		return sourceConcept;
	}

	@Override
	public String getOCL() {
		return ocl;
	}

	@Override
	public boolean targets(Class concept) {
		String qname = concept.getQualifiedName();

		boolean result = targetConcept.equals(qname);

		if (!result) {
			for (Classifier next : concept.allParents()) {
				if (targetConcept.equals(next.getQualifiedName())) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public void configure(OCLHelper helper, UMLEnvironment env, Profile profile) {
		helper.setContext(ZDLUtil.getZDLConcept(profile, getConcept()));

		addVariable(env, getSourceRole(), ZDLUtil.getZDLConcept(profile,
			sourceConcept));
		addVariable(env, getTargetRole(), ZDLUtil.getZDLConcept(profile,
			targetConcept));
	}

	private void addVariable(UMLEnvironment env, String name, Classifier type) {
		Variable<Classifier, Parameter> var = env.getOCLFactory()
			.createVariable();
		var.setName(name);
		var.setType(type);
		env.addElement(name, var, true);
	}

	@Override
	public boolean test(EObject source, EObject target) {
		// this concept is known to exist, otherwise we would not have obtained
		// this constraint from the target element
		Class zdl = ZDLUtil.getZDLConcept(source, sourceConcept);
		Profile profile = ZDLUtil.getZDLProfile(target, zdl);

		// this profile is known to exist, otherwise we could not have
		// determined that this target object is an instance of my concept
		OCLCache cache = OCLCache.adapt(profile);

		try {
			Constraint constraint = cache.getConstraint(this);
			Query query = cache.getOCL().createQuery(constraint);

			bindVariable(query, getSourceRole(), source, profile, sourceConcept);
			bindVariable(query, getTargetRole(), target, profile, targetConcept);

			return query.check(source);
		} catch (ParserException e) {
			Activator.getDefault().error(
				Messages.OCLLinkConstraint_parseFailed, e);
			throw new WrappedException(e);
		}
	}
	
	@Override
	public String getLinkContext(EObject source, EObject target) {
		
		// this concept is known to exist, otherwise we would not have obtained
		// this constraint from the target element
		Class zdl = ZDLUtil.getZDLConcept(source, sourceConcept);
		Profile profile = ZDLUtil.getZDLProfile(target, zdl);

		// this profile is known to exist, otherwise we could not have
		// determined that this target object is an instance of my concept
		OCLCache cache = OCLCache.adapt(profile);

		try {
			Constraint constraint = cache.getConstraint(this);
			Query query = cache.getOCL().createQuery(constraint);

			bindVariable(query, getSourceRole(), source, profile, sourceConcept);
			bindVariable(query, getTargetRole(), target, profile, targetConcept);

			if( query.check(source)) {
				if( ZDLUtil.isZDLConcept(constraint, ZDLNames.DOMAIN_CREATE_LINK_CONSTRAINT)) {
					return ((NamedElement)ZDLUtil.getValue(constraint, 
							ZDLNames.DOMAIN_CREATE_LINK_CONSTRAINT, 
							ZDLNames.DOMAIN_CREATE_LINK_CONSTRAINT__CREATES_CONCEPT)).getName().toString();					
				}
			}
		} catch (ParserException e) {
			Activator.getDefault().error(
				Messages.OCLLinkConstraint_parseFailed, e);
			throw new WrappedException(e);
		}
		
		return null;
	}

	private static void bindVariable(Query query, String name,
			EObject value, Profile profile, String concept) {

		Class profileClass = ZDLUtil.getProfileClass(profile, ZDLUtil
			.getZDLConcept(profile, concept));
		if (profileClass instanceof Stereotype) {
			// must be a UML element if the concept maps to a stereotype
			Stereotype stereotype = (Stereotype) profileClass;
			Element element = (Element) value;

			// get the stereotype instance
			value = element.getStereotypeApplication(stereotype);

			if (value == null) {
				// must be a substereotype that is applied
				EList<Stereotype> subs = element
					.getAppliedSubstereotypes(stereotype);
				if (!subs.isEmpty()) {
					value = element.getStereotypeApplication(subs.get(0));
				}
			}
		}
		query.getEvaluationEnvironment().add(name, value);
	}
}
