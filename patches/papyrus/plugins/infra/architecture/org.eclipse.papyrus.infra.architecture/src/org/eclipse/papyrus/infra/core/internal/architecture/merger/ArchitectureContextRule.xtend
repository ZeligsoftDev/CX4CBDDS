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

import java.util.Set
import java.util.function.Consumer
import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.core.architecture.ArchitectureContext
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFramework

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.*

import static extension org.eclipse.papyrus.infra.core.internal.architecture.merger.ArchitectureExtensions.logf

/**
 * Extension merge rule for {@link ArchitectureContext}s.
 */
@Singleton
class ArchitectureContextRule {
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject extension ArchitectureExtensions
	@Inject extension ArchitectureViewpointRule
	@Inject extension RepresentationKindRule
	
	def hasExtensions(ArchitectureContext context) {
		context.isReferenced(ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS)
	}
	
	def canExtend(ArchitectureContext extending, ArchitectureContext extended) {
		extending.eClass === extended.eClass
	}
	
	/** Query the set of contexts that have extension relationships targeting this context (not recursive). */
	def <T extends ArchitectureContext> extensions(T context) {
		if (inExtensionsPhase) context.<T> invert(ARCHITECTURE_CONTEXT__EXTENDED_CONTEXTS).filter[context.canExtend(it)] else emptyList
	}
	
	/** Query the set of all contexts that extend this context directly or indirectly (recursively). */
	def <T extends ArchitectureContext> allExtensions(T context) {
		if (inExtensionsPhase) allExtensionsHelper(context, newLinkedHashSet).toList else emptyList
	}
	
	private def <T extends ArchitectureContext> Iterable<T> allExtensionsHelper(T context, Set<T> result) {
		context.extensions.reject[result.contains(it)].forEach[
			result += it
			allExtensionsHelper(it, result)
		]
		result
	}
	
	/**
	 * Obtain the product of merging extension content (if any) into this context, if not previously merged.
	 * if previously merged, the previous merge result is returned.
	 */
	def dispatch merged(ArchitectureDescriptionLanguage context) {
//		context.merged(currentScope) // Unique merge per domain scope
		context.mergedADL // Unique merge per domain scope
	}
	
//	private def create createArchitectureDescriptionLanguage merged(ArchitectureDescriptionLanguage context, Object scope) {
	private def create createArchitectureDescriptionLanguage mergedADL(ArchitectureDescriptionLanguage context) {
		merge(context)
	}
	
	/** Merge the source context and all of its extensions into the newly created target context. */
	package def <T extends ArchitectureContext> merge(T target, T source) {
		(Set.of(source) + source.allExtensions).toSet => [
			forEach[target.copyContext(it)]
			// Here the ADL should have the correct RepresentationKinds
			target.mergeViewpoints(it)
			// But when merging viewpoints that refer to RepresentationKinds of a different ADL,
			// these RepresentationKinds are copied resulting in their eContainer being null.
			// So when merging viewpoints we shoult not copy representation kinds but add references
			// to the ones already merged. See org.eclipse.papyrus.infra.core.internal.architecture.merger.ArchitectureViewpointRule.mergedViewpoint(String, Set<? extends ArchitectureContext>, Object)
			
			"Merged %s into %s".logf(source, target)
		]
	}
	
	private def dispatch mergeViewpoints(ArchitectureDescriptionLanguage target, Set<? extends ArchitectureContext> sources) {
		target.mergeContextViewPoints(sources)
//		sources.filter(ArchitectureDescriptionLanguage).forEach [ source |
//			target.representationKinds += source.representationKinds.map[source.merged]
//		]
	}
	
	private def dispatch mergeViewpoints(ArchitectureContext target, Set<? extends ArchitectureContext> sources) {
		target.mergeContextViewPoints(sources)
	}
	
	private def mergeContextViewPoints(ArchitectureContext target, Set<? extends ArchitectureContext> sources) {
		target => [
			val allViewpoints = sources.flatMap[viewpoints]
			viewpoints += allViewpoints.mapUnique[name].map[mergedViewpoint(sources)]
			
			val allDefaults = sources.flatMap[defaultViewpoints]
			if (!allDefaults.empty) {
				// Now we have all the viewpoints, so find the defaults by name
				val viewpointsByName = viewpoints.toMap([name], [it]);
				
				defaultViewpoints += allDefaults.mapUnique[name].map[viewpointsByName.get(it)].filterNull
			}
		]
		
	}
	
	/**
	 * Obtain the product of merging extension content (if any) into this context, if not previously merged.
	 * if previously merged, the previous merge result is returned.
	 */
	def dispatch merged(ArchitectureFramework context) {
		context.merged(currentScope) // Unique merge per domain scope
	}
	private def create createArchitectureFramework merged(ArchitectureFramework context, Object scope) {
		merge(context)
	}
	
	private def copyContext(ArchitectureContext target, ArchitectureContext source) {
		target.copyContext(source, target.contextCopier)
	}
	
	/**
	 * Copy definitions from a source context into the target, with optional additional processing of extension
	 * content as applicable to the context type (ADLs have more to merge than AFs).
	 */
	private def <T extends ArchitectureContext> copyContext(T target, T source, Consumer<? super T> extensionMerger) {
		target => [
			copy(source)
			
			creationCommandClass = creationCommandClass ?: source.creationCommandClass
			conversionCommandClass = conversionCommandClass ?: source.conversionCommandClass
			extensionPrefix = extensionPrefix ?: source.extensionPrefix
			elementTypes += source.elementTypes
		
			// Further processing specific to the context type
			if (extensionMerger !== null) {
				extensionMerger.accept(source)
			}
		]
	}
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureDescriptionLanguage adl) {
		[ source |
			switch source {
				ArchitectureDescriptionLanguage case source:
					adl => [
						representationKinds += source.representationKinds.map[merged]
						treeViewerConfigurations += source.treeViewerConfigurations.map[merged]
						
						metamodel = it.metamodel ?: source.metamodel
						profiles += source.profiles
					]
			}
		]
	}
	
	private def dispatch Consumer<? super ArchitectureContext> contextCopier(ArchitectureContext context) {
		[ source |
			context => [
				// pass
			]
		]
	}
	
	/**
	 * Infer an extension relationship to the most appropriate other context
	 * of the same qualified name (if any). The most appropriate other context is the one that
	 * {@linkplain ArchitectureContext#isCompatibleWith(ArchitectureContext) is compatible with it} and
	 * that has the most other contexts extending it (either explicitly or implicitly).
	 */
	def inferExtensions(ArchitectureContext context) {
		context.class.sortedInstances(context.qualifiedName).filter[context.canExtend(it)]
			.excluding(context)
			.take(1).forEach[context.extendedContexts += it]			
	}
	
	/**
	 * Get contexts of the given {@code type} and qualified {@code name}
	 * sorted by decreasing number of extensions contributing to it.
	 */
	private def sortedInstances(Class<? extends ArchitectureContext> type, String name) {
		currentScope.flatMap[contexts].filter(type).filter[qualifiedName == name]
			.sortBy[allExtensions.size].reverseView
	}
	
}
