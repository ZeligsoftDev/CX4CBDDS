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

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import java.util.Collection
import java.util.Objects
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.papyrus.infra.core.architecture.ADElement
import org.eclipse.papyrus.infra.core.architecture.util.MergeTraceAdapter

import static org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage.Literals.AD_ELEMENT

/**
 * Encapsulation of merge traces from merged architecture model elements to
 * the original source models.
 */
package final class MergeTraces extends AdapterImpl implements MergeTraceAdapter {

	val Multimap<ADElement, ADElement> traces = ArrayListMultimap.create()
	
	def trace(ADElement mergedElement, ADElement sourceElement) {
		// Always trace to the ultimate source, not intermediate objects such as from the context inheritance phase
		if (sourceElement.hasTraces) {
			ArchitectureExtensions.logf("Tracing %s -> %s.", mergedElement, sourceElement.internalTrace)
			traces.putAll(mergedElement, sourceElement.internalTrace)
		} else {
			ArchitectureExtensions.logf("Tracing %s -> %s.", mergedElement, sourceElement)
			traces.put(mergedElement, sourceElement)
		}
		
		mergedElement.addAdapter
		
		this
	}
	
	private def internalTrace(ADElement mergedElement) {
		traces.get(mergedElement)
	}
	
	def hasTraces(ADElement element) {
		!element.internalTrace.empty
	}
	
	override Collection<? extends ADElement> trace(ADElement mergedElement) {
		mergedElement.internalTrace.unmodifiableView
	}
	
	override tracesTo(ADElement mergedElement, ADElement sourceElement) {
		mergedElement == sourceElement || mergedElement.internalTrace.contains(sourceElement)
	}
	
	/**
	 * Trace a merged element to the source element that contributed its value of the given
	 * {@code feature}. In case of a multi-valued feature, this will be any source element
	 * that contributed any values in that feature. <strong>Note</strong> that an empty
	 * result is possible because it could be that no source elements contributed any
	 * values to this {@code feature} (in which case that feature probably is unset).
	 *  
	 * @param <T> the element type to trace
	 * @param mergedElement the element to trace to a contributing source
	 * @param feature the feature to trace
	 * @return the source element for that feature
	 */
	override <T extends ADElement> trace(T mergedElement, EStructuralFeature feature) {
		mergedElement.internalTrace.findFirst[feature.intersects(mergedElement, it)] as T
	}
	
	private def intersects(EStructuralFeature feature, EObject object1, EObject object2) {
		switch feature {
			EAttribute case !feature.many:
				Objects.equals(object1.eGet(feature), object2.eGet(feature))
			EAttribute :
				(object1.eGet(feature) as Collection<?>).intersects (object2.eGet(feature) as Collection<?>)
			EReference case AD_ELEMENT.isSuperTypeOf(feature.EReferenceType) && !feature.many:
				tracesTo(object1.eGet(feature) as ADElement, object2.eGet(feature) as ADElement)
			EReference case AD_ELEMENT.isSuperTypeOf(feature.EReferenceType):
				tracesAny(object1.eGet(feature) as Collection<? extends ADElement>, object2.eGet(feature) as Collection<? extends ADElement>)
			EReference case !feature.many:
				object1.eGet(feature) === object2.eGet(feature)
			default:
				(object1.eGet(feature) as Collection<?>).intersects (object2.eGet(feature) as Collection<?>)
		}
	}
	
	private def intersects(Collection<?> a, Collection<?> b) {
		a.exists[b.contains(it)]
	}
	
	private def tracesAny(Collection<? extends ADElement> a, Collection<? extends ADElement> b) {
		a.exists[fromA | b.exists[fromB | fromA.tracesTo(fromB)]]
	}

	//
	// Adapter API
	//
	
	override isAdapterForType(Object type) {
		type == MergeTraceAdapter || type == MergeTraces
	}

	def addAdapter(Notifier notifier) {
		if (!notifier.eAdapters.contains(this)) notifier.eAdapters += this
	}

	def removeAdapter(Notifier notifier) {
		notifier.eAdapters.remove(this)
	}
	
	override setTarget(Notifier newTarget) {
		switch newTarget {
			ADElement case newTarget: newTarget.eContents.filter(ADElement).forEach[addAdapter]
		}
	}
	
	override unsetTarget(Notifier oldTarget) {
		traces.removeAll(oldTarget)
		
		switch oldTarget {
			ADElement case oldTarget: oldTarget.eContents.filter(ADElement).forEach[removeAdapter]
		}
	}
	
	override notifyChanged(Notification msg) {
		val feature = msg.feature
		
		switch feature {
			EReference case AD_ELEMENT.isSuperTypeOf(feature.EReferenceType) && feature.containment: 
				switch msg.eventType {
					case Notification.ADD: (msg.newValue as ADElement).addAdapter
					case Notification.ADD_MANY: (msg.newValue as Iterable<? extends ADElement>).forEach[addAdapter]
					case Notification.REMOVE: (msg.oldValue as ADElement).removeAdapter
					case Notification.REMOVE_MANY: (msg.oldValue as Iterable<? extends ADElement>).forEach[removeAdapter]
					case Notification.SET: {
						addAdapter(msg.newValue as ADElement)
						removeAdapter(msg.oldValue as ADElement)
					}
				} 
		}
	}
	
}
