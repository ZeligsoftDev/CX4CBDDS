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

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter
import org.eclipse.papyrus.infra.core.architecture.ADElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.papyrus.infra.core.architecture.TreeViewerConfiguration
import javax.inject.Singleton
import java.util.Set
import com.google.common.collect.AbstractIterator
import javax.inject.Inject
import javax.inject.Named
import java.util.function.BiConsumer
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter
import org.eclipse.papyrus.infra.core.architecture.ArchitectureFactory
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.xbase.lib.Functions.Function0
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0
import org.eclipse.papyrus.infra.architecture.Activator
import org.eclipse.papyrus.infra.core.architecture.util.FormattableADElement

/**
 * Utility extensions for the <em>Architecture Description</em> model.
 */
@Singleton
class ArchitectureExtensions {
	
	static extension ArchitectureFactory factory = ArchitectureFactory.eINSTANCE
	
	@Inject @Named(ArchitectureMergerModule.MERGE_TRACE) BiConsumer<? super ADElement, ? super ADElement> mergeTrace
	
	@Inject extension MergeState
	
	/** A custom cross-reference adapter that propagates itself up the content tree as well as down. */
	val ECrossReferenceAdapter xrefAdapter = new ECrossReferenceAdapter {
		// Also propagate up the content tree
		
		override protected setTarget(Resource target) {
			super.setTarget(target)
			
			target.resourceSet?.addAdapter
		}
		
		override protected setTarget(EObject target) {
			super.setTarget(target)

			// If iterating, then we came down the tree, so no need to go up			
			if (!iterating) {
				target as InternalEObject => [
					eDirectResource?.addAdapter
					eInternalContainer?.addAdapter
				]
			}
		}
		
	}
	
	private def xrefs(EObject object) {
		ECrossReferenceAdapter.getCrossReferenceAdapter(object) ?: (xrefAdapter => [
			object.eAdapters += it
		])
	}
	
	/** Query referencers to an object via the given reference. */
	def <T extends EObject> Iterable<T> invert(EObject target, EReference reference) {
		target.xrefs.getInverseReferences(target, reference, true).map[EObject as T]
	}
	
	/** Query whether any other object references the given object via some reference. */
	def isReferenced(EObject target, EReference reference) {
		!target.xrefs.getInverseReferences(target, reference, true).empty
	}
	
	/** Get the first source element that was merged into the given output. */
	def <T extends ADElement> trace(T mergedElement) {
		MergeTraceAdapter.getMergeTraces(mergedElement)?.trace(mergedElement).head as T
	}
	
	/** Get a feature of an object as a list, even if it isn't a list. */
	def <T> EList<T> eGetAsList(EObject owner, EStructuralFeature feature, Class<T> type) {
		if (feature.many) {
			owner.eGet(feature) as EList<T>
		} else {
			new BasicEList<T>(owner.eGet(feature) === null ? 0 : 1, #[owner.eGet(feature)]) {
				
				override protected didAdd(int index, Object newObject) {
					if (index == 0) owner.eSet(feature, newObject)
				}
				
				override protected didSet(int index, Object newObject, Object oldObject) {
					if (index == 0) owner.eSet(feature, newObject)
				}
				
				override protected didRemove(int index, Object oldObject) {
					if (index == 0) {
						if (empty) owner.eSet(feature, null) else owner.eSet(feature, get(0))
					}
				}
				
				override protected didClear(int size, Object[] oldObjects) {
					owner.eSet(feature, null)
				}
				
				override protected didMove(int index, Object movedObject, int oldIndex) {
					if (index == 0) owner.eSet(feature, movedObject)
				}
				
			}
		}
	} 
	
	/**
	 * Create a trace relationship from a target model element to the source model element
	 * that it derives from, which usually is some merge, for inheritance or for extension.
	 */
	def <T extends ADElement> traceTo(T target, T source) {
		mergeTrace.accept(target, source)
	}
	
	/** Log a merge tracing message. */
	def static package logf(String pattern, Object... arg) {
		if (Activator.log.isTraceEnabled(Activator.DEBUG_MERGE)) {
			Activator.log.trace(Activator.DEBUG_MERGE, String.format(pattern, FormattableADElement.wrapAll(arg)));
		}
	}
	
	/** A model element formatted suitably for printing. */
	def formatted(ADElement element) {
		FormattableADElement.wrap(element)
	}
	
	/**
	 * Copy the basic attributes of a target object, for which it does not already have a vakye, from some source.
	 * As a side-effect a trace relationship is recorded.
	 * 
	 * @see #traceTo(ADElement, ADElement)
	 */
	def <T extends ADElement> copy(T target, T source) {
		target.name = target.name ?: source.name
		target.id = target.id ?: source.id
		target.description = target.description ?: source.description
		target.icon = target.icon ?: source.icon
		
		// Establish trace from the output element to the input
		target.traceTo(source)
		
		target
	}
	
	/**
	 * Obtain the merge result for a stakeholder owned by merged domains. Stakeholders are merged by name.
	 * If merged previously, that previous merge result is returned.
	 */
	def mergedStakeholder(String name) {		
		name.mergedStakeholder(currentScope) // Unique merge per domain scope
	}
	private def create result: factory.createStakeholder mergedStakeholder(String name, Object scope) {
		currentScope.flatMap[stakeholders].filter[it.name == name].forEach[
			result.copy(it)
			result.concerns += it.concerns.mapUnique[it.name].map[mergedConcern]
			
			"Merged %s into %s".logf(it, result)
		]
	} 
	
	/**
	 * Obtain the merge result for a concern owned by merged domains and possibly referenced by merged
	 * viewpoints and representation kinds. Concerns are merged by name. If merged previously, that
	 * previous merge result is returned.
	 */
	def mergedConcern(String name) {
		name.mergedConcern(currentScope) // Unique merge per domain scope
	}
	private def create result: factory.createConcern mergedConcern(String name, Object scope) {
		currentScope.flatMap[concerns].filter[it.name == name].forEach[
			result.copy(it)
			
			"Merged %s into %s".logf(it, result)
		]
	} 
	
	/**
	 * Obtain the merge result for a tree viewer configuration in a merged context.
	 * If merged previously, that previous merge result is returned.
	 */
	def create EcoreUtil.copy(treeViewerConfig) merged(TreeViewerConfiguration treeViewerConfig) {} 
	
	/**
	 * Query whether the merge algorithm is currently in the inheritance processing phase.
	 * Only in the inheritance phase will queries about inheritance relationships return results.
	 */
	def inInheritancePhase() { phase === MergePhase.INHERITANCE }
	/**
	 * Query whether the merge algorithm is currently in the extensions processing phase,
	 * either explicitly modelled or inferred by name.
	 * Only in the extensions phase will queries about extension relationships return results.
	 */
	def inExtensionsPhase() { phase === MergePhase.EXTENSIONS || phase === MergePhase.LEGACY }
	
	/** Query the set of architecture domains currently being merged, as implied by the contexts that they define. */
	def currentScope() { currentDomains }
	
	/**
	 * Execute a block of code in the scope of a set of domains being merged. For the duration of the
	 * block, these domains will be the current scope.
	 * 
	 * @return the result of the block
	 * @see #currentScope()
	 */
	def <T> T withScope(Iterable<? extends ArchitectureDomain> domains, Function0<T> block) {
		domains.withDomains(block)
	}
	/**
	 * Execute a block of code in the scope of a set of domains being merged. For the duration of the
	 * block, these domains will be the current scope.
	 * 
	 * @see #currentScope()
	 */
	def void withScope(Iterable<? extends ArchitectureDomain> domains, Procedure0 block) {
		domains.withScope[
			block.apply
			null
		]
	}
	
	/** Compute a subset of objects in an iterable that are uniquely identified by some key function. */
	@Pure
	def <T, K> Iterable<T> uniqueBy(Iterable<T> iterable, Function1<? super T, K> keyer) {
		[
			new AbstractIterator<T> {
				val delegate = iterable.iterator
				val Set<K> uniquifier = newHashSet
				
				override protected computeNext() {
					while (delegate.hasNext) {
						val next = delegate.next
						if (uniquifier += keyer.apply(next)) return next
					}
					
					endOfData
				}
			}
		]
	}
	
	/** Compute an unique subset of objects in a transformed iterable. */
	@Pure
	def <T, R> mapUnique(Iterable<T> iterable, Function1<? super T, R> mapper) {
		iterable.map(mapper).unique
	}
	
	/** Obtain the unique elements in an {@code iterable}. */
	@Pure
	def <T> Iterable<T> unique(Iterable<T> iterable) {
		[
			new AbstractIterator<T> {
				val delegate = iterable.iterator
				val Set<T> uniquifier = newHashSet
				
				override protected computeNext() {
					while (delegate.hasNext) {
						val next = delegate.next
						if (uniquifier += next) return next
					}
					
					endOfData
				}
			}
		]
	}
	
	/** Filter architecture elements by name. */
	@Pure
	def <T extends ADElement> named(Iterable<T> iterable, String selectedName) {
		iterable.filter[name == selectedName]
	}
	
	/** Obtain the difference between an {@code iterable} and a set of exclusions. */
	@Pure
	def <T> excluding(Iterable<T> iterable, Object... excluded) {
		val unwanted = newHashSet(excluded)
		iterable.reject[unwanted.contains(it)]
	}
	
}
