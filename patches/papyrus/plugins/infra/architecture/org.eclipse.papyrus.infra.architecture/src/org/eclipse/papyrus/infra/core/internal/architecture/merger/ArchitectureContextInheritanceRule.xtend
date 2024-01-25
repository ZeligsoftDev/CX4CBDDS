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

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.*

/**
 * Inheritance rule for {@link ArchitectureContext}s.
 */
@Singleton
class ArchitectureContextInheritanceRule {
        // see https://www.eclipse.org/xtend/documentation/202_xtend_classes_members.html#extension-methods
        // about extension mechanism
	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureContextRule
	
	/**
	 * Query whether a context looks like a "legacy" context that does not participate in any
	 * explicit inheritance or extension relationships, and so would be assuming the legacy
	 * implicit name-based merge semantics.
	 */
	def legacyContext(ArchitectureContext context) {
		!(context.hasGeneral || context.extension || context.hasSpecializations || context.hasExtensions)
	}

	def hasGeneral(ArchitectureContext context) {
		context.generalContext !== null
	}
	
	def general(ArchitectureContext context) {
		if (context.hasGeneral && context.canInherit(context.generalContext)) context.generalContext
	}
	
	/** Query whether a context is the target of any generalization relationships from other contexts. */
	def hasSpecializations(ArchitectureContext context) {
		context.isReferenced(ARCHITECTURE_CONTEXT__GENERAL_CONTEXT)
	}

	def canInherit(ArchitectureContext specific, ArchitectureContext general) {
		specific.eClass === general.eClass
	}
	
	/** Query the set of contexts that have generalization relationships to a context (not recursive). */
	def <T extends ArchitectureContext> specializations(T context) {
		context.<T> invert(ARCHITECTURE_CONTEXT__GENERAL_CONTEXT).filter[canInherit(context)]
	}
	
	/** Update the given context (if not already thus updated) with inheritable context from its general context, if any. */
	// Create returning self is a "once function"
	def create context inherit(ArchitectureContext context) {
		if (context.hasGeneral && context.canInherit(context.generalContext)) {
			context.inherit(context.generalContext.inherit) // Recursive inheritance
		}
	}
	
	private def inherit(ArchitectureContext specific, ArchitectureContext general) {
		// During the inheritance phase, merge does not "see" any extensions
		newLinkedHashSet(specific.domain, general.domain).withScope[specific.merge(general)]
	}
	
	/**
	 * Complete the processing of inheritance for the context by clearing the reference to its general.
	 * The merged model does not retain inheritance and extension relationships as they would be redundant.
	 */
	def finalizeInheritance(ArchitectureContext context) {
		context.generalContext = null
	}
	
}
