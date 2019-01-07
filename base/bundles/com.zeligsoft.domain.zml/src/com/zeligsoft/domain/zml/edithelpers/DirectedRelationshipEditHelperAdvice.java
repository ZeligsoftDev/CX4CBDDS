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
package com.zeligsoft.domain.zml.edithelpers;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.type.ZDLElementType;
import com.zeligsoft.base.zdl.type.ZDLElementTypeUtil;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.l10n.Messages;

/**
 * Advice on the creation of directed relationships that are ZDL element types,
 * to disallow the creation on invalid source or target elements.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class DirectedRelationshipEditHelperAdvice
		extends AbstractEditHelperAdvice {

	private Set<EReference> sources;

	private Set<EReference> targets;

	/**
	 * Initializes me.
	 */
	public DirectedRelationshipEditHelperAdvice() {
		super();
	}

	@Override
	protected ICommand getBeforeEditContextCommand(
			GetEditContextRequest orgRequest) {

		if (orgRequest.getEditCommandRequest() == null
				|| !(orgRequest.getEditCommandRequest() instanceof CreateRelationshipRequest)) {
			return super.getBeforeEditContextCommand(orgRequest);
		}
		
		if (!isValidRelationship((CreateRelationshipRequest) orgRequest
				.getEditCommandRequest())) {
			return UnexecutableCommand.INSTANCE;
		}
		
		return super.getBeforeEditContextCommand(orgRequest);
	}

	private boolean isValidRelationship(CreateRelationshipRequest request) {
		IElementType type = request.getElementType();
		ZDLElementType zdlType = ZDLElementTypeUtil.getZDLElementType(type);
		EObject source = request.getSource();
		Class concept = null;
		if (zdlType == null && request.getNewElement() != null) {
			concept = ZDLUtil.getZDLConcept(request.getNewElement());
		}

		if (source != null) {
			if (zdlType != null) {
				concept = ZDLUtil.getZDLConcept(source,
						zdlType.getDomainConcept());
			}

			if (concept != null) {
				Class sourceConcept = getSourceConcept(concept, source);
				if ((sourceConcept != null)
						&& !ZDLUtil.isZDLConcept(source, sourceConcept)) {
					return false;
				}
			}
		}

		EObject target = request.getTarget();
		if (target != null) {
			if (zdlType != null) {
				concept = ZDLUtil.getZDLConcept(target,
						zdlType.getDomainConcept());
			}
			if (concept != null) {
				Class targetConcept = getTargetConcept(concept, target);
				if ((targetConcept != null)
						&& !ZDLUtil.isZDLConcept(target, targetConcept)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected ICommand getBeforeCreateRelationshipCommand(
			CreateRelationshipRequest request) {

		if (!isValidRelationship(request)) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getBeforeCreateRelationshipCommand(request);
	}

	@Override
	protected ICommand getAfterCreateRelationshipCommand(
			final CreateRelationshipRequest request) {
		return new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(request.getContainer()),
				Messages.CommandLabel_ZMLConnectorEditHelperAdvice_getAfterCreateCommand,
				null) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info) {

				if (!isValidRelationship(request)) {
					return CommandResult.newCancelledCommandResult();
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}
	
	/**
	 * Computes the concept that is the source of the specified relationship
	 * concept.
	 * 
	 * @param relationship
	 *            a directed-relationship kind of domain concept
	 * @param context
	 *            some context element from which we find the specific profile
	 *            mappings of the domain metamodel
	 * @return the source concept, or <code>null</code> if it cannot be
	 *         determined for some reason
	 */
	private Class getSourceConcept(Class relationship, EObject context) {
		Class result = null;
		Property source = getSourceAttribute(relationship, context);

		if (source == null) {
			// maybe it was mapped to a stereotype property? If the target
			// is mapped to UML and there are only two domain references, then
			// we'll take the other as the source
			Property target = getTargetAttribute(relationship, context);
			List<Property> refs = ZDLUtil.getDomainReferenceEnds(relationship);

			if ((target != null) && (refs.size() == 2)) {
				source = refs.get(1 - refs.indexOf(target));
			}
		}

		if (source != null) {
			result = (Class) source.getType();
		}

		return result;
	}

	/**
	 * Finds which attribute of the specified directed-relationship concept is
	 * the source attribute. This is either a domain-reference attribute that is
	 * mapped to <tt>uml::DirectedRelationship::source</tt> or one of its
	 * subsets (e.g., <tt>uml::Dependency::client</tt>) or, in the absence of
	 * such mapping, the reference attribute that is not the target in the case
	 * that the target is mapped and there are only two reference attributes
	 * defined for the concept.
	 * 
	 * @param relationship
	 *            a directed-relationship kind of domain concept
	 * @param context
	 *            some context element from which we find the specific profile
	 *            mappings of the domain metamodel
	 * @return the source attribute, or <code>null</code> if it cannot be
	 *         determined by the algorithm described above
	 */
	private Property getSourceAttribute(Class relationship, EObject context) {
		Property result = null;

		for (Property next : ZDLUtil.getDomainReferenceEnds(relationship)) {
			if(ZDLUtil.getZDLProfile(context, next.getClass_()) == null){
				continue;
			}
			if (getRelationshipSources().contains(
					ZDLUtil.getPropertyMapping(next, context))) {

				// that's the source
				result = next;
				break;
			}
		}

		return result;
	}

	/**
	 * Computes the concept that is the target of the specified relationship
	 * concept.
	 * 
	 * @param relationship
	 *            a directed-relationship kind of domain concept
	 * @param context
	 *            some context element from which we find the specific profile
	 *            mappings of the domain metamodel
	 * @return the target concept, or <code>null</code> if it cannot be
	 *         determined for some reason
	 */
	private Class getTargetConcept(Class relationship, EObject context) {
		Class result = null;
		Property target = getTargetAttribute(relationship, context);

		if (target == null) {
			// maybe it was mapped to a stereotype property? If the source
			// is mapped to UML and there are only two domain references, then
			// we'll take the other as the target
			Property source = getSourceAttribute(relationship, context);
			List<Property> refs = ZDLUtil.getDomainReferenceEnds(relationship);

			if ((source != null) && (refs.size() == 2)) {
				target = refs.get(1 - refs.indexOf(source));
			}
		}

		if (target != null) {
			result = (Class) target.getType();
		}

		return result;
	}

	/**
	 * Finds which attribute of the specified directed-relationship concept is
	 * the target attribute. This is either a domain-reference attribute that is
	 * mapped to <tt>uml::DirectedRelationship::target</tt> or one of its
	 * subsets (e.g., <tt>uml::Dependency::supplier</tt>) or, in the absence of
	 * such mapping, the reference attribute that is not the source in the case
	 * that the source is mapped and there are only two reference attributes
	 * defined for the concept.
	 * 
	 * @param relationship
	 *            a directed-relationship kind of domain concept
	 * @param context
	 *            some context element from which we find the specific profile
	 *            mappings of the domain metamodel
	 * @return the target attribute, or <code>null</code> if it cannot be
	 *         determined by the algorithm described above
	 */
	private Property getTargetAttribute(Class relationship, EObject context) {
		Property result = null;

		for (Property next : ZDLUtil.getDomainReferenceEnds(relationship)) {
			if(ZDLUtil.getZDLProfile(context, next.getClass_()) == null){
				continue;
			}
			if (getRelationshipTargets().contains(
					ZDLUtil.getPropertyMapping(next, context))) {

				// that's the target
				result = next;
				break;
			}
		}

		return result;
	}

	/**
	 * Obtains the set of UML references that are known to be sources of
	 * directed relationships.
	 * 
	 * @return the directed-relationship source references
	 */
	private Set<EReference> getRelationshipSources() {
		if (sources == null) {
			sources = new java.util.HashSet<EReference>();

			sources.add(UMLPackage.Literals.DIRECTED_RELATIONSHIP__SOURCE);
			sources.add(UMLPackage.Literals.DEPENDENCY__CLIENT);
			sources.add(UMLPackage.Literals.GENERALIZATION__SPECIFIC);
			// Manifestation has no subset of the Dependency::client end
			sources
				.add(UMLPackage.Literals.INTERFACE_REALIZATION__IMPLEMENTING_CLASSIFIER);
			sources.add(UMLPackage.Literals.COMPONENT_REALIZATION__ABSTRACTION);
			sources
				.add(UMLPackage.Literals.SUBSTITUTION__SUBSTITUTING_CLASSIFIER);
			sources.add(UMLPackage.Literals.DEPLOYMENT__LOCATION);
			sources
				.add(UMLPackage.Literals.PROTOCOL_CONFORMANCE__SPECIFIC_MACHINE);
			sources
				.add(UMLPackage.Literals.PROFILE_APPLICATION__APPLYING_PACKAGE);
			sources.add(UMLPackage.Literals.TEMPLATE_BINDING__BOUND_ELEMENT);
			sources
				.add(UMLPackage.Literals.PACKAGE_IMPORT__IMPORTING_NAMESPACE);
			sources
				.add(UMLPackage.Literals.ELEMENT_IMPORT__IMPORTING_NAMESPACE);
			sources.add(UMLPackage.Literals.PACKAGE_MERGE__RECEIVING_PACKAGE);
			sources
				.add(UMLPackage.Literals.INFORMATION_FLOW__INFORMATION_SOURCE);
			sources.add(UMLPackage.Literals.INCLUDE__INCLUDING_CASE);
			sources.add(UMLPackage.Literals.EXTEND__EXTENSION);
		}

		return sources;
	}

	/**
	 * Obtains the set of UML references that are known to be targets of
	 * directed relationships.
	 * 
	 * @return the directed-relationship target references
	 */
	private Set<EReference> getRelationshipTargets() {
		if (targets == null) {
			targets = new java.util.HashSet<EReference>();

			targets.add(UMLPackage.Literals.DIRECTED_RELATIONSHIP__TARGET);
			targets.add(UMLPackage.Literals.DEPENDENCY__SUPPLIER);
			targets.add(UMLPackage.Literals.GENERALIZATION__GENERAL);
			targets.add(UMLPackage.Literals.MANIFESTATION__UTILIZED_ELEMENT);
			targets.add(UMLPackage.Literals.INTERFACE_REALIZATION__CONTRACT);
			targets
				.add(UMLPackage.Literals.COMPONENT_REALIZATION__REALIZING_CLASSIFIER);
			targets.add(UMLPackage.Literals.SUBSTITUTION__CONTRACT);
			targets.add(UMLPackage.Literals.DEPLOYMENT__DEPLOYED_ARTIFACT);
			targets
				.add(UMLPackage.Literals.PROTOCOL_CONFORMANCE__GENERAL_MACHINE);
			targets
				.add(UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE);
			targets.add(UMLPackage.Literals.TEMPLATE_BINDING__SIGNATURE);
			targets.add(UMLPackage.Literals.PACKAGE_IMPORT__IMPORTED_PACKAGE);
			targets.add(UMLPackage.Literals.ELEMENT_IMPORT__IMPORTED_ELEMENT);
			targets.add(UMLPackage.Literals.PACKAGE_MERGE__MERGED_PACKAGE);
			targets
				.add(UMLPackage.Literals.INFORMATION_FLOW__INFORMATION_TARGET);
			targets.add(UMLPackage.Literals.INCLUDE__ADDITION);
			targets.add(UMLPackage.Literals.EXTEND__EXTENDED_CASE);
		}

		return targets;
	}
}
