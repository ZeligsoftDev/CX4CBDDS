/*****************************************************************************
 * Copyright (c) 2021 Christian W. Damus, CEA LIST, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.internal.architecture.merger

import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import javax.inject.Inject
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import javax.inject.Singleton
import java.util.Set

/**
 * Merge rule for {@link Architecture Domain}s.
 */
@Singleton
class ArchitectureDomainRule {
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureContextRule
	@Inject extension ArchitectureContextInheritanceRule
	
	def hasExtensions(ArchitectureDomain domain) {
		domain.contexts.exists[hasExtensions]
	}
	
	def isExtension(ArchitectureDomain domain) {
		domain.contexts.exists[extension]
	}
	
	def hasInheritance(ArchitectureDomain domain) {
		domain.contexts.exists[hasGeneral || hasSpecializations]
	}
	
	def hasContexts(ArchitectureDomain domain) {
		!domain.contexts.empty
	}
	
	def allContexts(ArchitectureDomain domain) {
		domain.contexts + domain.allExtensions.flatMap[contexts]
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def extensions(ArchitectureDomain extended) {
		if (inExtensionsPhase) extended.contexts.flatMap[extensions].mapUnique[domain] else emptyList
	}
	
	/** A domain's extensions are implied by the domains defining extensions of its contexts. */
	def allExtensions(ArchitectureDomain extended) {
		if (inExtensionsPhase) extended.contexts.flatMap[allExtensions].mapUnique[domain] else emptyList
	}
	
	def generals(ArchitectureDomain specific) {
		if (inInheritancePhase) specific.contexts.map[general].filterNull.map[domain].unique.excluding(specific) else emptyList
	}
	
	/** Process inheritance for the contexts in a domain, if not already done previously for this domain. */
	// Create returning self is a "once function"
	def create domain inherit(ArchitectureDomain domain) {
		domain.generals.map[inherit].withScope[
			// Contexts that are to be inherited have dependencies on these, so inherit them
			domain.concerns += currentScope.flatMap[concerns].mapUnique[name].map[mergedConcern]
			domain.stakeholders += currentScope.flatMap[stakeholders].mapUnique[name].map[mergedStakeholder]
		]
				
		if (inInheritancePhase) domain.contexts.forEach[it.inherit]
	}
	
	/**
	 * Finalize inheritance processing for all contexts in a domain.
	 * 
	 * @see ArchitectureContextInheritanceRule#finalizeInheritance(ArchitectureContext)
	 */
	def finalizeInheritance(ArchitectureDomain domain) {
		domain.contexts.forEach[it.finalizeInheritance]
	}
	
	/**
	 * Merging of domains is implied by merging of its contexts: merge the given
	 * domain with all domains that define contexts that are extended by some
	 * context in this domain.
	 */
	def create createArchitectureDomain merged(ArchitectureDomain domain) {
		(Set.of(domain) + domain.allExtensions).withScope[
			copy(domain) => [ result |
				// Gather up stakeholders and concerns from merged domains
				concerns += currentScope.flatMap[concerns].mapUnique[name].map[mergedConcern]
				stakeholders += currentScope.flatMap[stakeholders].mapUnique[name].map[mergedStakeholder]
				
				// Extension contexts exist only to contribute to others
				contexts += domain.allContexts.reject[extension].map[merged]
				
				// Trace to the merged domains
				domain.allExtensions.forEach[result.traceTo(it)]
			]
		]
	}
	
	/**
	 * For all of the contexts in the given {@code domain} that do not have explicit inheritance
	 * or extension relationships, infer extension relationships to the most appropriate other context.
	 */
	def inferExtensions(ArchitectureDomain domain) {
		domain.contexts.filter[legacyContext].forEach[it.inferExtensions]
	}
	
}
