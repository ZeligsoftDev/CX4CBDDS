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
package com.zeligsoft.base.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.uml2.common.util.UML2Util;

/**
 * A mini-framework for merging models.
 * 
 * @param <T>
 *            the kind of model elements that the merger merges
 * @param <K>
 *            the type of a key that uniquely identifies elements to be merged
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class ModelMerger<T extends EObject, K> {

	private List<T> sources;
	
	protected List<T> getSources() {
		return sources;
	}

	private List<T> targets;

	protected List<T> getTargets() {
		return targets;
	}
	
	protected Map<K, T> sourceMap = new java.util.HashMap<K, T>();

	protected Map<K, T> targetMap = new java.util.HashMap<K, T>();

	protected Map<T, T> sourceTargetCache = new java.util.HashMap<T, T>();

	protected Map<T, T> targetSourceCache = new java.util.HashMap<T, T>();

	final IKeyExtractor<T, K> keyExtractor;

	final CorrespondenceChecker correspondence;

	/**
	 * Initializes me.
	 * 
	 */
	public ModelMerger() {
		keyExtractor = createKeyExtractor();
		correspondence = createCorrespondenceChecker();
	}

	/**
	 * Implemented by subclasses to create the key extractor.
	 * 
	 * @return a key extractor
	 */
	protected abstract IKeyExtractor<T, K> createKeyExtractor();

	/**
	 * Creates the correspondence checker. Subclasses may override to create a
	 * customized checker.
	 * 
	 * @return a correspondence checker
	 */
	protected CorrespondenceChecker createCorrespondenceChecker() {
		return new CorrespondenceChecker();
	}

	/**
	 * Creates the target-model pruner. Subclasses may override to create a
	 * customized pruner.
	 * 
	 * @return a target-model pruner
	 */
	protected TargetPruner createTargetPruner() {
		return new TargetPruner();
	}

	/**
	 * Creates the target-model updater. Subclasses may override to create a
	 * customized updater.
	 * 
	 * @return a target-model updater
	 */
	protected TargetUpdater createTargetUpdater() {
		return new TargetUpdater();
	}

	/**
	 * Creates the target-model cross-reference fixer. Subclasses may override
	 * to create a customized cross-reference fixer.
	 * 
	 * @return a target-model cross-reference fixer
	 */
	protected ReferenceFixer createReferenceFixer() {
		return new ReferenceFixer();
	}

	/**
	 * Merges a source model into a target model.
	 * 
	 * @param source
	 *            my source model
	 * @param target
	 *            the target model into which I merge the source
	 */
	public void merge(T source, T target) {
		merge(Collections.singletonList(source), Collections
			.singletonList(target));
	}

	/**
	 * Merges one or more source models into the same number of target models.
	 * 
	 * @param sources
	 *            my source models
	 * @param targets
	 *            the target models into which I merge the sources
	 */
	public void merge(List<T> sources, List<T> targets) {
		if (targets.isEmpty()) {
			throw new IllegalArgumentException("no targets to merge into"); //$NON-NLS-1$
		}
		if (targets.size() != sources.size()) {
			throw new IllegalArgumentException(
				"different number of sources and targets for merge"); //$NON-NLS-1$
		}

		this.sources = sources;
		this.targets = targets;

		// in all cases, correspondence of relationships implies correspondence
		// of the related elements
		for (int i = 0; i < targets.size(); i++) {
			T source = sources.get(i);
			T target = targets.get(i);

			map(source, sourceMap, Phase.UPDATE);
			map(target, targetMap, Phase.PRUNE);
			sourceTargetCache.put(source, target);
			targetSourceCache.put(target, source);
		}

		// remove target elements for which there is no correspondent in the
		// source
		createTargetPruner().prune();

		// add source elements for which there is no correspondent in the target
		createTargetUpdater().update();

		// finally, fix references from the target model into the source model
		// by redirecting them to the corresponding target model elements
		createReferenceFixer().fixReferences();

		dispose();
	}

	/**
	 * Disposes me after completion of the merge.
	 */
	protected void dispose() {
		sources = null;
		targets = null;
		sourceMap.clear();
		targetMap.clear();
		sourceTargetCache.clear();
		targetSourceCache.clear();
	}

	/**
	 * Iterates over the contents of the specified model, mapping the keys of
	 * its elements elements to the elements, themselves.
	 * 
	 * @param element
	 *            an element to map
	 * @param map
	 *            the map to populate
	 * @param phase
	 *            a phase indicating whether it is the target or the source map
	 *            that we are constructing
	 */
	private void map(T element, Map<K, T> map, Phase phase) {
		K key = getKey(element);

		if (key != null) {
			map.put(key, element);
		}

		for (T next : getContentsToMerge(element, phase)) {
			map(next, map, phase);
		}
	}

	/**
	 * Finds the element in my source model that corresponds to the specified
	 * element in my target model. The correspondence criteria may vary by
	 * metaclass.
	 * 
	 * @param <U>
	 *            the kind of object being sought
	 * @param target
	 *            the target model element
	 * 
	 * @return the corresponding source model element, or <code>null</code> if
	 *         the source model no longer has this element
	 */
	protected <U extends T> U findSource(U target) {
		return findCorrespondent(target, sourceMap, targetSourceCache);
	}

	/**
	 * Finds the element in my target model that corresponds to the specified
	 * element in my source model. The correspondence criteria may vary by
	 * metaclass.
	 * 
	 * @param <U>
	 *            the kind of object being sought
	 * @param source
	 *            the source model element
	 * 
	 * @return the corresponding target model element, or <code>null</code> if
	 *         the target model does not have this element (it is new in the
	 *         source)
	 */
	protected <U extends T> U findTarget(U source) {
		return findCorrespondent(source, targetMap, sourceTargetCache);
	}

	/**
	 * Helper method for the {@link #findSource(EObject)} and
	 * {@link #findTarget(EObject)} methods, that searches for the correspondent
	 * in the given map.
	 * 
	 * @param <U>
	 *            the kind of object to find
	 * @param object
	 *            the source or target object to look up the correspondent
	 * @param map
	 *            the target or source map, respectively, in which to look up
	 *            the correspondent
	 * @param cache
	 *            the cache of source-to-target or target-to-source
	 *            correspondences, as appropriate to the object and map used
	 * @return the corresponding object, or <code>null</code> if not found
	 */
	private <U extends T> U findCorrespondent(U object, Map<K, T> map,
			Map<T, T> cache) {

		@SuppressWarnings("unchecked")
		U result = (U) cache.get(object);

		if ((result == null) && (object != null)) {
			K key = getKey(object);

			if (key != null) {
				@SuppressWarnings("unchecked")
				U correspondent = (U) map.get(key);

				if ((correspondent != null)
					&& correspond(object, correspondent)) {
					result = correspondent;
					cache.put(object, result);
				}
			}
		}

		return result;
	}

	/**
	 * Queries whether the specified structural feature is one that can be
	 * merged. By default, any feature that isn't a containment or container
	 * reference, that isn't derived, that isn't read-only, and that isn't an
	 * {@linkplain #getMergeableExternalCrossReferences() unmergeable external cross-reference}
	 * is mergeable.
	 * 
	 * @param owner
	 *            an object that has a feature
	 * @param feature
	 *            the feature
	 * 
	 * @return whether it is a mergeable feature
	 */
	protected boolean isMergeableFeature(EObject owner,
			EStructuralFeature feature) {
		boolean result = !feature.isDerived() && feature.isChangeable();

		if (result && (feature instanceof EReference)) {
			EReference ref = (EReference) feature;
			result = !ref.isContainment()
				&& !ref.isContainer()
				&& (!isExternalCrossReference(owner, ref) || isMergeableExternalCrossReference(
					owner, ref));
		}

		return result;
	}

	/**
	 * Queries whether the specified reference is a fixable cross-reference,
	 * that is to say, one that is non-derived, changeable, and not a container
	 * or containment reference. This is used in the
	 * {@linkplain Phase#FIX reference-fixing} phase after moving objects from
	 * the source model to the target.
	 * 
	 * @param owner
	 *            the object that owns a reference to be fixed
	 * @param reference
	 *            a reference to be fixed
	 * 
	 * @return whether this particular occurrence of this reference is fixable
	 */
	protected boolean isFixableCrossReference(EObject owner,
			EReference reference) {
		return !reference.isDerived() && reference.isChangeable()
			&& !reference.isContainment() && !reference.isContainer()
			&& !isExternalCrossReference(owner, reference);
	}

	/**
	 * Queries whether the specified reference is an external cross-reference
	 * that should be merged. By default, just checks whether the
	 * {@link #getMergeableExternalCrossReferences()} includes this reference.
	 * 
	 * @param owner
	 *            an object that has a reference
	 * @param reference
	 *            the reference
	 * 
	 * @return whether it is a mergeable external cross-reference
	 * 
	 * @see #getExternalCrossReferences()
	 * @see #getMergeableExternalCrossReferences()
	 * @see #isExternalCrossReference(EObject, EReference)
	 */
	protected boolean isMergeableExternalCrossReference(EObject owner,
			EReference reference) {
		return getMergeableExternalCrossReferences().contains(reference);
	}

	/**
	 * <p>
	 * Queries whether the specified cross-reference feature is an external
	 * cross-reference, which references objects outside the merged model. Such
	 * references do not need to be included in the reference fix-up phase but
	 * do need to be copied from the source to the target (where they have
	 * values).
	 * </p>
	 * <p>
	 * The default implementation simply checks whether the reference is in the
	 * set of known
	 * {@linkplain #getExternalCrossReferences() external references}.
	 * </p>
	 * 
	 * @param owner
	 *            an object that has a cross-reference feature
	 * @param ref
	 *            the cross-reference feature
	 * 
	 * @return whether this reference should be considered as a candidate for
	 *         fixing references within the model
	 */
	protected boolean isExternalCrossReference(EObject owner, EReference ref) {
		return getExternalCrossReferences().contains(ref);
	}

	/**
	 * <p>
	 * Queries the set of external cross-references, without consideration of
	 * the particular owner. For many merges, the owner object is not
	 * significant in determining whether a cross reference is external. Only
	 * changeable, non-derived references should be indicated in this set.
	 * </p>
	 * <p>
	 * The default implementation returns an empty set.
	 * </p>
	 * 
	 * @return the cross-references known to reference external objects
	 */
	protected Set<EReference> getExternalCrossReferences() {
		return Collections.emptySet();
	}

	/**
	 * <p>
	 * Queries the set of external cross-references that should be merged. Must
	 * be a subset of the {@link #getExternalCrossReferences() external
	 * cross-references}. External cross-references not in this set will not be
	 * pruned nor updated from the source.
	 * </p>
	 * <p>
	 * The default implementation returns all of the external cross-references.
	 * </p>
	 * 
	 * @return the external cross-references to merge
	 */
	protected Set<EReference> getMergeableExternalCrossReferences() {
		return getExternalCrossReferences();
	}

	/**
	 * Obtains the key that identifies a model element.
	 * 
	 * @param object
	 *            a model element
	 * @return its key, or <code>null</code> if it is not identifiable
	 */
	protected K getKey(T object) {
		return keyExtractor.getKey(object);
	}

	/**
	 * Queries whether two objects logically correspond.
	 * 
	 * @param a
	 *            an element in the source or target model
	 * @param b
	 *            another element, in the target or source model
	 * @return whether they logically correspond, usually at least by their key
	 *         and by position in the model structure
	 */
	private boolean correspond(T a, T b) {
		return correspondence.correspond(a, b);
	}

	/**
	 * <p>
	 * Queries the list of objects contained by some object, that should be
	 * merged. Any contents excluded from this list will be completely ignored
	 * (recursively) by the merge algorithm. This default implementation simply
	 * returns all of the object's contents.
	 * </p>
	 * <p>
	 * <b>Note</b> that in the case that <tt>phase</tt> is
	 * {@link Phase#PRUNE}, the objects in the resulting list may be removed
	 * from the target model while I iterate the list. So, care must be taken to
	 * avoid concurrent modifications. Otherwise, the list values of
	 * multi-valued references can be returned as is.
	 * </p>
	 * 
	 * @param object
	 *            an object in the target or source model
	 * @param phase
	 *            the current merge phase
	 * @return those of its contents that should be considered in merging
	 */
	protected List<T> getContentsToMerge(T object, Phase phase) {
		return basicGetContentsToMerge(object, phase);
	}

	/**
	 * The default implementation of the
	 * {@link #getContentsToMerge(EObject, Phase)} method, which is aliased for
	 * accessibility from subclasses with overrides of the other method.
	 * </p>
	 * 
	 * @param object
	 *            an object in the target model
	 * @param phase
	 *            the current merge phase
	 * @return those of its contents that should be considered in pruning
	 */
	@SuppressWarnings("unchecked")
	protected final List<T> basicGetContentsToMerge(T object, Phase phase) {
		List<T> result;

		switch (phase) {
			case PRUNE :
				// make a copy so that we can remove child elements while
				// iterating
				result = new java.util.ArrayList<T>((List<T>) object.eContents());
				break;
			default:
				result = (List<T>) object.eContents();
				break;
		}

		return result;
	}

	/**
	 * Creates a list that can safely be modified without affecting the model
	 * from which its contents were obtained. This method accounts for the
	 * current merge phase, to optimize the algorithm. In the case of the
	 * {@linkplain Phase#PRUNE prune phase}, the assumption is that the list
	 * has already been copied by the {@link #basicGetContentsToMerge} method.
	 * 
	 * @param list
	 *            a list of elements from the model
	 * @return a list that it is safe to modify
	 */
	protected final <U extends T> List<U> safeList(List<U> list, Phase phase) {
		List<U> result;

		switch (phase) {
			case PRUNE :
				// already made a copy
				result = list;
				break;
			default :
				// need to make a copy
				result = new java.util.ArrayList<U>(list);
				break;
		}

		return result;
	}
	
	/**
	 * Ensures that the elements in the specified target list appear in the same
	 * positions as the corresponding elements in the source list.
	 * 
	 * @param targetList the list of objects to reorder
	 * @param sourceList the source objects that define the order
	 * @param useEquals whether to check list membership by equality (<code>true</code>)
	 * or by correspondence (<code>false</code>)
	 */
	@SuppressWarnings("unchecked")
	protected void align(EList<?> targetList, List<?> sourceList, boolean useEquals) {
		// offset positions in target list to account for elements in the
		// source list that are not in the target
		int missing = 0;
		int count = sourceList.size();
		Set<Object> sources = new HashSet<Object>();
		
		for (int i = 0; i < count; i++) {
			Object nextSource = sourceList.get(i);
			Object lookFor = useEquals? nextSource : findTarget((T) nextSource);
			
			int index = targetList.indexOf(lookFor);
			if( sources.add(lookFor) == false ) {
				// rarely, the source list can be larger than the target list and include multiple objects
				// that have the same target; these appear to get removed later in the merge. In such a case
				// we have to offset the source list or else we will get an ArrayIndexOutOfBoundsException.
				missing++;
			} else if (index < 0) {
				missing++;  // offset future positions by one more to the left
			} else if ((i - missing) != index) {
				targetList.move(i - missing, index);
			}
		}
	}
	
	/**
	 * Queries whether the ordering of the specified feature is signifacant to
	 * the model, so that it should be aligned by the merge process. This can be
	 * overridden by sub-classes to make exceptions to the general rule that
	 * order is significant if and only if the feature is marked as
	 * <tt>isOrdered</tt>. For example, Ecore has several features that are
	 * ordered by default, but for which ordering doesn't make sense.
	 * 
	 * @param feature
	 *            a structural feature
	 * @return whether the ordering of its values should be aligned by the merge
	 */
	protected boolean isOrderSignificant(EStructuralFeature feature) {
		return feature.isOrdered();
	}

	//
	// Nested utility classes
	//

	/**
	 * An enumeration of the phases of the merge algorithm.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected static enum Phase {
		/** The first phase, in which the target model is pruned. */
		PRUNE,

		/** The second phase, in which the target is updated from the source. */
		UPDATE,

		/**
		 * The final phase, in which cross-references in the merge result are
		 * fixed.
		 */
		FIX;
	}

	/**
	 * An object that removes, from the target model, all generator elements
	 * that do not correspond to elements in the source model. Thus, it strips
	 * out all elements that are no longer applicable.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected class TargetPruner {

		/**
		 * Prunes my enclosing merger's target model, removing any elements that
		 * do not correspond to elements in the source model.
		 */
		public void prune() {
			for (T target : targets) {
				prune(target);
			}
		}

		/**
		 * The basic implementation of the target pruning algorithm.
		 * 
		 * @param object
		 *            an element in the target model
		 */
		protected void prune(T object) {
			basicPrune(object);
		}

		/**
		 * Recursively prunes children of the specified target element.
		 * 
		 * @param object
		 *            an element in the target model
		 */
		protected final void pruneContents(T object) {
			for (T next : getContentsToMerge(object, Phase.PRUNE)) {
				prune(next);
			}
		}

		/**
		 * The basic implementation of the target pruning algorithm, which is
		 * aliased thusly in order that it be available as is to subclasses,
		 * regardless of overrides of the {@link #prune(EObject)} method.
		 * 
		 * @param object
		 *            an element in the target model
		 */
		protected final void basicPrune(T object) {
			T source = findSource(object);

			if (source == null) {
				// remove this object which no longer is needed in the target
				EcoreUtil.remove(object);
				object.eAdapters().clear();
				targetMap.remove(getKey(object));
				targetSourceCache.remove(object); // shouldn't be there, but
				// ...

				for (Iterator<EObject> iter = object.eAllContents(); iter
					.hasNext();) {
					EObject next = iter.next();

					@SuppressWarnings("unchecked")
					T descendent = (T) next;
					descendent.eAdapters().clear();
					targetMap.remove(getKey(descendent));
					targetSourceCache.remove(descendent);
				}

				// and don't continue down the tree
			} else {
				// prune mergeable feature values that are not in the source
				// model. Don't propagate null values from the source model
				// because we consider them as "uninitialized"
				for (EStructuralFeature feature : object.eClass()
					.getEAllStructuralFeatures()) {
					if (isMergeableFeature(object, feature)) {
						if (FeatureMapUtil.isMany(object, feature)) {
							EList<?> targetValue = (EList<?>) object
								.eGet(feature);
							EList<?> sourceValue = (EList<?>) source
								.eGet(feature);

							targetValue.retainAll(sourceValue);
						} else if (source.eIsSet(feature)
							&& (source.eGet(feature) == null)) {
							object.eSet(feature, null);
						}
					}
				}

				// continue down the tree
				pruneContents(object);
			}
		}
	}

	/**
	 * A helper object that adds, to the target model, all source elements that
	 * do not correspond to elements in the target model. Thus, it inserts all
	 * new elements.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected class TargetUpdater {

		/**
		 * Updates my enclosing merger's target model with new elements from the
		 * source, which didn't previously exist in the target.
		 */
		public void update() {
			for (T source : sources) {
				updateFrom(source);
			}
		}

		/**
		 * Replaces the target element corresponding to the specified newTarget
		 * from the source model in the maps that my merger maintains to perform
		 * correspondence queries.
		 * 
		 * @param newTarget
		 *            the replacement, from the source model, of an obsolete
		 *            target element
		 * @return the same newTarget
		 */
		protected final T remap(T newTarget) {
			targetMap.put(getKey(newTarget), newTarget);
			sourceTargetCache.put(newTarget, newTarget);
			targetSourceCache.put(newTarget, newTarget);
			return newTarget;
		}

		/**
		 * The basic implementation of the target updating algorithm.
		 * 
		 * @param object
		 *            an element in the source model
		 */
		protected void updateFrom(T object) {
			basicUpdateFrom(object);
		}

		/**
		 * Recursively merges contents of the specified source element.
		 * 
		 * @param object
		 *            an element in the source model
		 */
		protected final void updateFromContents(T object) {
			// don't need a defensive copy to account for deletions of the
			// second level of nesting
			for (T next : getContentsToMerge(object, Phase.UPDATE)) {
				updateFrom(next);
			}
		}

		/**
		 * The basic implementation of the target updating algorithm, which is
		 * aliased thusly in order that it be available as is to subclasses,
		 * regardless of overrides of the {@link #updateFrom(EObject)} method.
		 * 
		 * @param object
		 *            an element in the source model
		 */
		protected final void basicUpdateFrom(T object) {
			T target = findTarget(object);

			if (target != null) {
				for (EReference containment : object.eClass()
						.getEAllContainments()) {
				if (FeatureMapUtil.isMany(object, containment)) {
					@SuppressWarnings("unchecked")
						List<T> sourceContents = (List<T>) object
								.eGet(containment);
						sourceContents = new java.util.ArrayList<T>(
								sourceContents);

					@SuppressWarnings("unchecked")
						EList<T> targetContents = (EList<T>) target
								.eGet(containment);

					for (T next : sourceContents) {
						if (findTarget(next) == null) {
							// the target model does not have a correspondent
							// for this source element, so the source element is
							// 'new' and should be added to the target
							targetContents.add(remap(next));
						}
					}
					
					if (isOrderSignificant(containment)) {
						// position is significant
						align(targetContents, sourceContents, false);
					}
				} else {
					@SuppressWarnings("unchecked")
					T sourceContent = (T) object.eGet(containment);

					if ((sourceContent != null)
						&& (findTarget(sourceContent) == null)) {
						// the target model does not have a correspondent for
						// this source element, so the source element is 'new'
						// and should be added to the target
						target.eSet(containment, remap(sourceContent));
					}
				}
			}
			}
			// add values from mergeable features that are not in the target
			// model, except in the case of scalar properties that are null
			// because we do not propagate nulls. Also, only propagate scalar
			// references if the target value is null
			if (target != null) {
			for (EStructuralFeature feature : object.eClass()
				.getEAllStructuralFeatures()) {
				if (isMergeableFeature(object, feature)
							&& (object.eIsSet(feature) || target
									.eIsSet(feature))) {

					if (FeatureMapUtil.isMany(object, feature)) {
						@SuppressWarnings("unchecked")
						EList<Object> sourceValue = (EList<Object>) object
							.eGet(feature);
						@SuppressWarnings("unchecked")
						EList<Object> targetValue = (EList<Object>) target
							.eGet(feature);

						for (Object next : sourceValue) {
							if (!targetValue.contains(next)) {
								targetValue.add(next);
							}
						}
						
						if (isOrderSignificant(feature)) {
							// position is significant
							align(targetValue, sourceValue, true);
						}
					} else {
						Object sourceValue = object.eGet(feature);

						if (sourceValue != null) {
							target.eSet(feature, sourceValue);
						}
					}
				}
			}
			}
			updateFromContents(object);
		}
	}

	/**
	 * A helper that walks the target model, after the update/merge step, to
	 * redirect references into the source model to the target model.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected class ReferenceFixer {

		/**
		 * Walks the target model, after a merge, to update references that are
		 * pointing to elements in the source model to point them at the
		 * corresponding elements in the target model. This handles re-wiring
		 * new elements that were added from the source model, but which
		 * reference elements that previously existed and, thus, are already
		 * present in the target model.
		 */
		public void fixReferences() {
			fixReferences(targets);
		}

		/**
		 * Recursively fixes references in the specified <tt>objects</tt> and
		 * their children.
		 * 
		 * @param objects
		 *            a list of objects whose references are to be fixed
		 */
		protected void fixReferences(List<T> objects) {
			for (T next : objects) {
				if (fixReferences(next)) {
					fixReferences(getContentsToMerge(next, Phase.FIX));
				}
			}
		}

		/**
		 * Implements the cross-reference fixing behaviour for an object in the
		 * target model.
		 * 
		 * @param object
		 *            an object whose references should be fixed
		 * @return whether to continue into the descendants of the object
		 */
		protected boolean fixReferences(T object) {
			basicFixReferences(object);
			return true;
		}

		/**
		 * The basic implementation of the cross-reference fixing algorithm,
		 * which is aliased thusly in order that it be available as is to
		 * subclasses, regardless of overrides of the
		 * {@link #fixReferences(EObject)} method.
		 * 
		 * @param object
		 *            an object whose references should be fixed
		 */
		protected void basicFixReferences(EObject object) {
			for (EReference ref : object.eClass().getEAllReferences()) {
				if (isFixableCrossReference(object, ref)) {
					if (FeatureMapUtil.isMany(object, ref)) {
						@SuppressWarnings("unchecked")
						List<T> contents = (List<T>) object.eGet(ref);

						for (ListIterator<T> iter = contents.listIterator(); iter
							.hasNext();) {
							T source = iter.next();
							T target = findTarget(source);

							if ((target != null) && (target != source)) {
								// replace reference to source model with
								// reference to corresponding target model
								if (contents.contains(target)) {
									// simply remove the source object because
									// we already have the target. This handles
									// updates that were already done in UML
									// superset properties
									iter.remove();
								} else {
									iter.set(target);
								}
							}
						}
					} else {
						@SuppressWarnings("unchecked")
						T source = (T) object.eGet(ref);
						T target = findTarget(source);

						if ((target != null) && (target != source)) {
							// replace reference to source model with
							// reference to corresponding target model
							object.eSet(ref, target);
						}
					}
				}
			}
		}
	}

	/**
	 * A helper that determines whether two model elements are structurally
	 * equivalent (that they are substitutable for one another in the model).
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected class CorrespondenceChecker {

		private T compareTo;

		private List<T> stack = new java.util.ArrayList<T>();

		private K key;

		/**
		 * Queries whether two elements, one from the source model and one from
		 * the target, logically correspond. This usually includes at least
		 * equality of their keys and a similar position in the model tree. When
		 * elements correspond, they are merged by retaining the target element
		 * with its values.
		 * 
		 * @param a
		 *            an element in either the source or target model
		 * @param b
		 *            another element, in either the target or source model
		 * 
		 * @return whether these two elements logically correspond
		 */
		public boolean correspond(T a, T b) {
			boolean result;

			if ((a == null) && (b == null)) {
				result = true; // null references implicitly correspond
			} else if ((a == null) || (b == null)) {
				result = false;
			} else {
				push(a);
				result = corresponds(b);
				pop();
			}

			return result;
		}

		/**
		 * Queries the current top of the correspondence stack, in the case that
		 * I am checking correspondence recursively, following references.
		 * 
		 * @return the current element to which I compare an input element
		 */
		protected T objectToCompare() {
			return compareTo;
		}

		/**
		 * Pushes a new element onto my comparison stack, for recursive
		 * correspondence checking following references.
		 * 
		 * @param compareTo
		 *            an element to which I will compare an input element
		 */
		private void push(T compareTo) {
			this.compareTo = compareTo;
			stack.add(compareTo);
			key = getKey(compareTo);
		}

		/**
		 * Pops an element from my comparison stack, when unwinding the
		 * recursive correspondence checking following references.
		 * 
		 * @return the former top element from my stack, just popped
		 */
		private T pop() {
			T result = compareTo;
			stack.remove(stack.size() - 1);
			compareTo = stack.isEmpty()
				? null
				: stack.get(stack.size() - 1);
			key = (compareTo == null)
				? null
				: getKey(compareTo);
			return result;
		}

		/**
		 * The correspondence algorithm, by default implemented by delegation to
		 * the {@link #basicCorresponds(EObject)} method.
		 * 
		 * @param object
		 *            an object to compare against my current stack top
		 * @return whether they are in structural correspondence
		 */
		protected boolean corresponds(T object) {
			return basicCorresponds(object);
		}

		/**
		 * The basic implementation of the correspondence algorithm, which is
		 * aliased thusly in order that it be available as is to subclasses,
		 * regardless of overrides of the {@link #corresponds(EObject)} method.
		 * Checks that the object's key is the same as the current stack top's
		 * key, and that their containers (recursively) correspond.
		 * 
		 * @param object
		 *            an object to compare against my current stack top
		 * @return whether they are in structural correspondence
		 */
		@SuppressWarnings("unchecked")
		protected final boolean basicCorresponds(T object) {
			// check that the EClasses and keys are the same and the containment
			// structure is the same. An element that has moved will be assumed
			// to be new
			boolean result = UML2Util.safeEquals(key, getKey(object))
				&& (objectToCompare().eClass() == object.eClass());

			if (result) {
				EObject topContainer = objectToCompare().eContainer();
				EObject objectContainer = object.eContainer();

				// special cases for the roots of the merge tree
				if (sources.contains(topContainer)) {
					// the other container must be the target
					result = targets.contains(objectContainer);
				} else if (targets.contains(topContainer)) {
					// the other container must be the source
					result = sources.contains(objectContainer);
				} else if (sources.contains(objectContainer)) {
					// the other container must be the target
					result = targets.contains(topContainer);
				} else if (targets.contains(objectContainer)) {
					// the other container must be the source
					result = sources.contains(topContainer);
				} else {
					// neither object is the root, so they must be Ts
					result = correspond((T) topContainer, (T) objectContainer);
				}
			}

			return result;
		}
	}

	/**
	 * Encapsulation of an algorithm for computing the key of a model element.
	 * 
	 * @param <T>
	 *            the kind of model elements that the merger merges
	 * @param <K>
	 *            the type of a key that uniquely identifies elements to be
	 *            merged
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected static interface IKeyExtractor<T extends EObject, K> {

		/**
		 * Computes the key of the specified model element.
		 * 
		 * @param element
		 *            an element in the source or target model
		 * 
		 * @return the key, or <code>null</code> if this element is not
		 *         identifiable
		 */
		K getKey(T element);
	}

	/**
	 * Simple interface for a hierarchical, but otherwise opaque, merge key.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static interface IHierarchicalKey {

		/**
		 * Obtains the key of my parent element.
		 * 
		 * @return the parent element's key, or <code>null</code> if my
		 *         element is a root
		 */
		IHierarchicalKey parent();

		/**
		 * Sets my parent element's key.
		 * 
		 * @param parent
		 *            my parent key
		 */
		void setParent(IHierarchicalKey parent);

		/**
		 * I am equal to another key if our parents our equal and we are the
		 * same kind of key describing a similar structure.
		 */
		@Override
		boolean equals(Object o);
	}

	/**
	 * An abstract implementation of the {@link IKeyExtractor} interface.
	 * Implements the basic algorithm for hierarchical keys.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected static abstract class AbstractHierarchicalKeyExtractor<T extends EObject, K extends IHierarchicalKey>
			implements IKeyExtractor<T, K> {

		private final Map<T, K> keys = new java.util.HashMap<T, K>();

		/**
		 * Initializes me.
		 */
		public AbstractHierarchicalKeyExtractor() {
			super();
		}

		@Override
		public K getKey(T element) {
			K result = keys.get(element);

			if (result == null) {
				result = createKey(element);
				if (result == null) {
					return null;
				}

				@SuppressWarnings("unchecked")
				T container = (T) element.eContainer();
				if (container != null) {
					result.setParent(getKey(container));
				}

				keys.put(element, result);
			}

			return result;
		}

		/**
		 * Implemented by subclasses to create a key describing the structure of
		 * the specified element only, not including its contaiment.
		 * 
		 * @param element
		 *            an element
		 * @return its key
		 */
		protected abstract K createKey(T element);
	}

	/**
	 * A partial implementation of the hierarchical key protocol.
	 * 
	 * @param <E>
	 *            expected to be bound with the same subclass type
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	public static abstract class AbstractHierarchicalKey<E extends AbstractHierarchicalKey<E>>
			implements IHierarchicalKey {

		private IHierarchicalKey parent;

		private EClass metaclass;

		/**
		 * Initializes me with my element.
		 * 
		 * @param element
		 *            the element that I identify
		 */
		public AbstractHierarchicalKey(EObject element) {
			this.metaclass = element.eClass();
		}

		@Override
		public final IHierarchicalKey parent() {
			return parent;
		}

		@Override
		public final void setParent(IHierarchicalKey parent) {
			this.parent = parent;
		}

		@Override
		public final boolean equals(Object o) {
			if ((o == null) || (o.getClass() != getClass())) {
				return false;
			}

			@SuppressWarnings("unchecked")
			E other = (E) o;

			if (metaclass != other.metaclass) {
				return false;
			}

			if (!keyEquals(other)) {
				return false;
			}

			if (!UML2Util.safeEquals(parent, other.parent())) {
				return false;
			}

			return true;
		}

		protected abstract boolean keyEquals(E other);

		@Override
		public int hashCode() {
			int result = (parent == null)
				? 0
				: parent.hashCode() * 37;

			result += metaclass.hashCode() * 17;

			result += keyHash();

			return result;
		}

		protected abstract int keyHash();
	}

	/**
	 * <p>
	 * A hierarchical key extractor that delegates the creation of keys to a
	 * number of composed extractors. The composed extractors do not supply the
	 * hierarchy; the composed extractor does that.
	 * </p>
	 * <p>
	 * This class is useful for merging heterogeneous models, comprising objects
	 * from multiple metamodels.
	 * </p>
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected static class CompositeHierarchicalKeyExtractor<K extends IHierarchicalKey>
			extends AbstractHierarchicalKeyExtractor<EObject, K> {

		private ComposedHierarchicalKeyExtractor<K> mruChild;

		private ComposedHierarchicalKeyExtractor<K>[] otherChildren;

		/**
		 * Initializes me with a bunch of children.
		 * 
		 * @param children
		 *            my nested key extractors
		 * 
		 * @throws IllegalArgumentException
		 *             if no children are provided
		 */
		@SuppressWarnings("unchecked")
		public CompositeHierarchicalKeyExtractor(
				ComposedHierarchicalKeyExtractor<K>... children) {
			super();

			if (children.length == 0) {
				throw new IllegalArgumentException("no children provided"); //$NON-NLS-1$
			}

			this.otherChildren = new ComposedHierarchicalKeyExtractor[children.length - 1];
			System.arraycopy(children, 1, otherChildren, 0,
				otherChildren.length);

			this.mruChild = children[0]; // start with the first one

			// tell my children who I am
			for (ComposedHierarchicalKeyExtractor<K> next : children) {
				next.setComposite(this);
			}
		}

		@Override
		protected K createKey(EObject element) {
			K result = mruChild.createKey(element);

			if (result == null) {
				// search the others
				for (int i = 0; i < otherChildren.length; i++) {
					result = otherChildren[i].createKey(element);
					if (result != null) {
						// we have a new MRU
						ComposedHierarchicalKeyExtractor<K> swap = otherChildren[i];
						otherChildren[i] = mruChild;
						mruChild = swap;
						break;
					}
				}
			}

			return result;
		}

	}

	/**
	 * A key extractor that is intended to be composed into a
	 * {@link CompositeHierarchicalKeyExtractor}. The important distinction is
	 * that the composed extractor delegates the calculation of hierarchical
	 * keys to its composite. It is, itself, only responsible for computing the
	 * sipmle (non-hierarchical) key of an element.
	 * 
	 * @author Christian W. Damus (cdamus)
	 */
	protected static abstract class ComposedHierarchicalKeyExtractor<K extends IHierarchicalKey>
			extends AbstractHierarchicalKeyExtractor<EObject, K> {

		private CompositeHierarchicalKeyExtractor<K> composite;

		/**
		 * Initializes me.
		 */
		protected ComposedHierarchicalKeyExtractor() {
			super();
		}

		/**
		 * Obtains my composite.
		 * 
		 * @return my composite
		 */
		public final CompositeHierarchicalKeyExtractor<K> getComposite() {
			return composite;
		}

		/**
		 * Assigns the key-extractor that composes me.
		 * 
		 * @param composite
		 *            my composite
		 */
		public final void setComposite(
				CompositeHierarchicalKeyExtractor<K> composite) {
			this.composite = composite;
		}

		/**
		 * Redefines the key access to delegate to my composite, to ensure an
		 * accurate and hierarchical key.
		 */
		@Override
		public final K getKey(EObject element) {
			return composite.getKey(element);
		}

	}
}
