/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.AbstractModelManager;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * A self-populating map that lazily creates the extent of a class when asked
 * for it.
 * <p>
 * <b>Note</b> that this implementation violates the contract of the
 * {@link Map} API as follows:
 * <ul>
 *   <li>the {@link Map#entrySet()} method does not return entries
 *       for any keys that have not already been queried via the
 *       {@link Map#get(java.lang.Object)} method</li>
 *   <li>concomitant to the above item, the {@link Map#keySet()}
 *       and {@link Map#values()} methods also are not complete</li>
 * </ul>
 * In practice, this does not matter because this map is only used for providing
 * class extents to the OCL engine, and it only does look-up by key.
 * Moreover, this isn't strictly a violation of any contract because there is
 * no way to distinguish this behaviour from concurrent updates.
 * </p>
 * @deprecated Use LazyEcoreModelManager to enable configuration of what needscaching
 */
@Deprecated
public abstract class LazyModelManager extends AbstractModelManager implements ModelManager.ModelManagerExtension2
{
	/**
	 * Map from a Type to allInstances() of exactly that type and its subtypes.
	 */
	@Deprecated
	private final @NonNull Map<@NonNull Type, @NonNull Set<@NonNull EObject>> type2instances = new HashMap<>();

	/**
	 * Map from an (opposite) Property to a Map from an object to the targets of that unnavigable (opposite) Property.
	 */
	@Deprecated
	private final @NonNull Map<@NonNull Property, @NonNull Map<@NonNull Object, @NonNull Set<@NonNull Object>>> oppositeProperty2opposite2objects = new HashMap<>();

	/**
	 * The EObjects that together with their transitive containment descendants comprise allInstances() of all non-DataType types.
	 */
	@Deprecated
	private final @NonNull Collection<@NonNull EObject> roots;

	/**
	 * Initializes me with the context element of an OCL
	 * expression evaluation.  I discover the scope of the model from this
	 * element.
	 *
	 * @param context my context element
	 */
	public LazyModelManager(EObject context) {
		context = EcoreUtil.getRootContainer(context);
		Resource eResource = context.eResource();
		if (eResource != null) {
			roots = eResource.getContents(); // the extent is the resource
		} else {
			roots = Collections.singleton(context); // can only search this object tree
		}
	}

	/**
	 * Dummy constructor to allow LazyEcoreModelManager to override while totally ignoring this abstract level.
	 *
	 * @since 1.14
	 */
	protected LazyModelManager() {
		roots = Collections.emptyList();
	}

	/**
	 * Lazily computes the extent of the specified class <code>key</code>.
	 *
	 * @param type a class in the model
	 */
	@Deprecated
	@Override
	public @NonNull Set<@NonNull ? extends Object> get(org.eclipse.ocl.pivot.@NonNull Class type) {
		// TODO: Optimize by parsing ahead of time to find all EClasses that we will query
		Set<@NonNull EObject> result = type2instances.get(type);
		if (result == null) {
			synchronized (type2instances) {
				result = type2instances.get(type);
				if (result == null) {
					result = new HashSet<@NonNull EObject>();
					type2instances.put(type, result);
					for (Iterator<EObject> iter = EcoreUtil.getAllContents(roots); iter.hasNext();) {
						EObject next = iter.next();
						if ((next != null) && isInstance(type, next)) {
							result.add(next);
						}
					}
				}
			}
		}
		// FIXME subclasses
		return result;
	}

	/**
	 * @since 1.7
	 */
	@Deprecated
	@Override
	public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
		Map<@NonNull Object, @NonNull Set<@NonNull Object>> opposite2objects = oppositeProperty2opposite2objects.get(target2sourceProperty);
		if (opposite2objects == null) {
			synchronized (oppositeProperty2opposite2objects) {
				opposite2objects = oppositeProperty2opposite2objects.get(target2sourceProperty);
				if (opposite2objects == null) {
					opposite2objects = new HashMap<>();
					oppositeProperty2opposite2objects.put(target2sourceProperty, opposite2objects);
					Property source2targetProperty = target2sourceProperty.getOpposite();
					if (source2targetProperty != null) {					// Never null
						org.eclipse.ocl.pivot.Class targetClass = PivotUtil.getOwningClass(source2targetProperty);
						EObject esProperty = source2targetProperty.getESObject();
						EStructuralFeature eStructuralFeature = esProperty instanceof EStructuralFeature ? (EStructuralFeature)esProperty : null;
						for (@NonNull Object eTargetObject : get(targetClass)) {
							EClass eClass = eClass(eTargetObject);
							EStructuralFeature eFeature = eStructuralFeature != null ? eStructuralFeature :  eClass.getEStructuralFeature(source2targetProperty.getName());
							assert eFeature != null;
							Object sourceCandidateOrCandidates = eGet(eTargetObject, eFeature);
							if (eFeature.isMany()) {
								assert sourceCandidateOrCandidates != null;
								for (Object sourceCandidate : (List<?>)sourceCandidateOrCandidates) {
									if (sourceCandidate != null) {						// ?? Never null
										Set<@NonNull Object> objects = opposite2objects.get(sourceCandidate);
										if (objects == null) {
											objects = new HashSet<>();
											opposite2objects.put(sourceCandidate, objects);
										}
										objects.add(eTargetObject);
									}
								}
							}
							else if (sourceCandidateOrCandidates != null) {
								Set<@NonNull Object> objects = opposite2objects.get(sourceCandidateOrCandidates);
								if (objects == null) {
									objects = new HashSet<>();
									opposite2objects.put(sourceCandidateOrCandidates, objects);
								}
								objects.add(eTargetObject);
							}
						}
					}
				}
			}
		}
		Set<@NonNull Object> objects = opposite2objects.get(sourceObject);
		if (objects == null) {
			objects = Collections.emptySet();
		}
		return objects;
	}

	/**
	 * Implemented by subclasses to determine whether the specified element
	 * is an instance of the specified class, according to the metamodel
	 * semantics implemented by the environment that created this extent map.
	 *
	 * @param type a class in the model
	 * @param element a potential run-time (M0) instance of that class
	 * @return <code>true</code> if this element is an instance of the given
	 *    class; <code>false</code> otherwise
	 */
	@Deprecated
	protected abstract boolean isInstance(@NonNull Type type, @NonNull EObject element);

	@Override
	public String toString() {
		return type2instances.toString();
	}
}
