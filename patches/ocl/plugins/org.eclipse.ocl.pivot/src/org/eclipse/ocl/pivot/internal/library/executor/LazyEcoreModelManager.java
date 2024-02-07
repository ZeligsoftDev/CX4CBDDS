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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * LazyEcoreModelManager provides a Lazy implementation of the EcoreModelManager API.
 * <p>
 * It maintains caches to support the OCL allInstances() library operation and implicit
 * opposite navigation. These caches are lazy in so far as they are not created until
 * an allInstances() or opposite navigation executes. However once required, the necessary
 * total model search eagerly populates the caches for all configured allInstances()
 * and implicitOpposites.
 * </p>
 * <p>
 * If an unconfigured allInstances() or implicitOpposites
 * is invoked, the caches are cleared and rebuilt after adding the unconfigured
 * requirement to the configuration.
 * </p>
 * <p>
 * Clearly performance will be much improved if all
 * necessary allInstances() and implicit opposites are configured on construction.
 * </p>
 * <p>
 * The OCL code generator for GenModel provides this information which may be obtained from
 * AbstractTables.basicGet(nsURI).basicGetAllIstancesClasses/basicGetImplicitOpposites.
 * </p>
 * @since 1.14
 */
public class LazyEcoreModelManager extends LazyModelManager implements ModelManager.EcoreModelManager
{
	/**
	 * EClassAnalysis caches the results of EClas instances foynd during a model search.
	 * <p>
	 * The minimal EClassAnalysisWithoutInstances directs the instances to a super-EClassAnalysis
	 * if the instances are not used in their own right unless cahing of the derived allInstances()
	 * is necessary to avoid double cahing of a multiple inheritance.
	 * </p>
	 * <p>
	 * The full EClassAnalysisWithInstances keeps track of all instances of its EClass. Instances
	 * of non-allInstances() derived ECLasses aree cached locally. Instances of allInstances() derived
	 * ECLasses aree cached indirectly and aggregated as the instances of this EClass.
	 * </p>
	 * <p>
	 * Both forms of EClassAnalysis maintain a list of EReferenceAnalysis for each implicit opposite
	 * targeting this EClass.
	 * </p>
	 */
	private static abstract class EClassAnalysis implements Nameable
	{
		protected final @NonNull LazyEcoreModelManager modelManager;
		protected final @NonNull EClass eClass;
		protected @NonNull EReferenceAnalysis @Nullable [] eOppositeAnalyses;

		protected EClassAnalysis(@NonNull LazyEcoreModelManager modelManager, @NonNull EClass eClass) {
			this.modelManager = modelManager;
			this.eClass = eClass;
			this.eOppositeAnalyses = analyzeEClass();
		}

		/**
		 * Return an array of EReferenceAnalysis for each interesting implicit opposite.
		 */
		private @NonNull EReferenceAnalysis @Nullable [] analyzeEClass() {
			List<@NonNull EReferenceAnalysis> eOppositeAnalyses = null;
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if (eStructuralFeature instanceof EReference) {
					EReference eReference = (EReference)eStructuralFeature;
					if (eReference.getEOpposite() == null) {
						EReferenceAnalysis eOppositeAnalysis = modelManager.getEReferenceAnalysis(eReference);
						if (eOppositeAnalysis != null) {
							assert !eReference.isTransient() && !eReference.isVolatile();
							if (eOppositeAnalyses == null) {
								eOppositeAnalyses = new ArrayList<>();
							}
							assert !eOppositeAnalyses.contains(eOppositeAnalysis);
							eOppositeAnalyses.add(eOppositeAnalysis);
						}
					}
				}
			}
			return eOppositeAnalyses != null ? eOppositeAnalyses.toArray(new @NonNull EReferenceAnalysis[eOppositeAnalyses.size()]) : null;
		}

		/**
		 * Accumulate this eObject instance.
		 */
		public abstract void analyzeEObject(@NonNull EObject eObject);

		/**
		 * Accumulate the implicit opposites of this eObject instance.
		 */
		public void analyzeEOpposites(@NonNull EObject eObject) {
			assert eObject.eClass() == eClass;
			@NonNull EReferenceAnalysis[] eOppositeAnalyses2 = eOppositeAnalyses;
			if (eOppositeAnalyses2 != null) {
				for (@NonNull EReferenceAnalysis eOppositeAnalysis : eOppositeAnalyses2) {
					eOppositeAnalysis.analyzeEObject(eObject);
				}
			}
		}

		/**
		 * Return the EClassAnalysisWithInstances that caches instances of this EClass.
		 */
		public abstract @Nullable EClassAnalysisWithInstances basicGetEClassAnalysisWithInstances();

	//	public @NonNull EClass getEClass() {
	//		return eClass;
	//	}

		/**
		 * Return all the instances of this EClass and its derived EClasses.
		 */
		public abstract @NonNull Iterable<@NonNull EObject> getInstances();

		@Override
		public @NonNull String getName() {
			return eClass.getEPackage().getName() + "::" + eClass.getName();
		}
	}

	/**
	 * EClassAnalysisWithInstances directly caches instances of this EClass and indirectly re-uses instances#cached by a derived
	 * EClassAnalysisWithInstances.
	 */
	private static class EClassAnalysisWithInstances extends EClassAnalysis
	{
		/**
		 * The instances of this EClass or its subclasses that are not accumulated in one of the indirectInstances.
		 */
		protected final @NonNull List<@NonNull EObject> localInstances;

		/**
		 * The subclasses instance accumulators that are logically also instances of the EClass.
		 * Includes localInstances when non-null.
		 */
		private @Nullable List<@NonNull List<@NonNull EObject>> indirectInstances;

		public EClassAnalysisWithInstances(@NonNull LazyEcoreModelManager modelManager, @NonNull EClass eClass) {
			super(modelManager, eClass);
			this.localInstances = new ArrayList<>();
			this.indirectInstances = null;;
		}

		protected void addLocalInstance(@NonNull EObject eObject) {
			assert !localInstances.contains(eObject);
			localInstances.add(eObject);
		}

		@Override
		public void analyzeEObject(@NonNull EObject eObject) {
			addLocalInstance(eObject);
			analyzeEOpposites(eObject);
		}

		/**
		 * Analyze all the superclasses to determine whether a superclass needs to use our localInstances as its instances too.
		 */
		public void analyzeInheritance() {
			for (EClass eSuperClass : eClass.getEAllSuperTypes()) {
				assert eSuperClass != null;
				EClassAnalysis eClassAnalysis = modelManager.basicGetEClassAnalysis(eSuperClass);
				if (eClassAnalysis instanceof EClassAnalysisWithInstances) {
					List<@NonNull List<@NonNull EObject>> indirectInstances2 = indirectInstances;
					if (indirectInstances2 == null) {
						indirectInstances2 = indirectInstances = new ArrayList<>();
						indirectInstances2.add(localInstances);
					}
					List<@NonNull EObject> localInstances2 = ((EClassAnalysisWithInstances)eClassAnalysis).localInstances;
					if (!indirectInstances2.contains(localInstances2)) {
						indirectInstances2.add(localInstances2);
					}
				}
			}
		}

		@Override
		public @NonNull EClassAnalysisWithInstances basicGetEClassAnalysisWithInstances() {
			return this;
		}

		@Override
		public @NonNull Iterable<@NonNull EObject> getInstances() {
			if (indirectInstances == null) {
				return localInstances;
			}
			else {
				return Iterables.concat(indirectInstances);
			}
		}

		@Override
		public @NonNull String toString() {
			return getName() + "[" + localInstances.size() + "]";
		}
	}

	/**
	 * EClassAnalysisWithoutInstances redirects instance caching to a super-EClassAnalysis or discards
	 * the instance completely if not required.
	 */
	private static class EClassAnalysisWithoutInstances extends EClassAnalysis
	{
		protected final @Nullable EClassAnalysisWithInstances eClassAnalysisWithInstances;

		public EClassAnalysisWithoutInstances(@NonNull LazyEcoreModelManager modelManager, @NonNull EClass eClass,
				@Nullable EClassAnalysisWithInstances eClassAnalysisWithInstances) {
			super(modelManager, eClass);
			this.eClassAnalysisWithInstances = eClassAnalysisWithInstances;
		}

		@Override
		public void analyzeEObject(@NonNull EObject eObject) {
			if (eClassAnalysisWithInstances != null) {
				eClassAnalysisWithInstances.addLocalInstance(eObject);
			}
			analyzeEOpposites(eObject);
		}

		@Override
		public @Nullable EClassAnalysisWithInstances basicGetEClassAnalysisWithInstances() {
			return eClassAnalysisWithInstances;
		}

		@Override
		public @NonNull Iterable<@NonNull EObject> getInstances() {
			throw new IllegalStateException("No allInstances() support for a " + eClass.getName());
		}

		@Override
		public @NonNull String toString() {
			return getName() + " -> " + eClassAnalysisWithInstances;
		}
	}

	/**
	 * EReferenceAnalysis caches the inverse of the source to target navigation of an EReference so that
	 * its inverse can be looked up without a further model search.
	 */
	private static class EReferenceAnalysis implements Nameable
	{
		protected final @NonNull EReference eReference;
		protected final @NonNull Map<@NonNull EObject, @NonNull Object> eTarget2eSourceOrSources = new HashMap<>();

		public EReferenceAnalysis(@NonNull EReference eReference) {
			this.eReference = eReference;
			assert eReference.getEOpposite() == null;
		}

		private void addOpposite(@NonNull EObject eObject, @NonNull EObject oppositeEObject) {
			Object sourceOrSources = eTarget2eSourceOrSources.get(oppositeEObject);
			if (sourceOrSources == null) {
				eTarget2eSourceOrSources.put(oppositeEObject, eObject);
			}
			else if (sourceOrSources instanceof EObject) {
				if (!eReference.isUnique() || (sourceOrSources != eObject)) {
					List<@NonNull EObject> objects = new ArrayList<>();
					eTarget2eSourceOrSources.put(oppositeEObject, objects);
					objects.add((EObject)sourceOrSources);
					objects.add(eObject);
				}
			}
			else {
				@SuppressWarnings("unchecked")
				List<@NonNull EObject> objects = (List<@NonNull EObject>)sourceOrSources;
				if (!eReference.isUnique() || !objects.contains(eObject)) {
					objects.add(eObject);
				}
			}
		}

		/**
		 * Cache the opposite(s) of the EReference navigation from eObject.
		 */
		public void analyzeEObject(@NonNull EObject eObject) {
			Object objectOrObjects = eObject.eGet(eReference);
			if (eReference.isMany()) {
				@SuppressWarnings("unchecked")
				Iterable<@NonNull EObject> oppositeEObjects = (Iterable<@NonNull EObject>)objectOrObjects;
				for (EObject oppositeEObject : oppositeEObjects) {
					addOpposite(eObject, oppositeEObject);
				}
			}
			else if (objectOrObjects != null) {
				addOpposite(eObject, (EObject)objectOrObjects);
			}
		}

	/*	public @Nullable EObject basicGetOpposite(@NonNull EObject oppositeEObject) {
			Object objectOrObjects = eTarget2eSourceOrSources.get(oppositeEObject);
			if (objectOrObjects == null) {
				return null;
			}
			else if (objectOrObjects instanceof EObject) {
				return (EObject)objectOrObjects;
			}
			else {
				throw new IllegalStateException("Too many " + eReference.getName() + " opposites");
			}
		} */

		public @Nullable List<@NonNull EObject> basicGetOpposites(@NonNull EObject oppositeEObject) {
			Object objectOrObjects = eTarget2eSourceOrSources.get(oppositeEObject);
			if (objectOrObjects == null) {
				return null;
			}
			else if (objectOrObjects instanceof EObject) {
				return Collections.singletonList((EObject)objectOrObjects);
			}
			else {
				@SuppressWarnings("unchecked")
				List<@NonNull EObject> objects = (List<@NonNull EObject>)objectOrObjects;
				return objects;
			}
		}

		@Override
		public @NonNull String getName() {
			EClass eContainingClass = eReference.getEContainingClass();
			EPackage ePackage = eContainingClass.getEPackage();
			return ePackage.getName() + "::" + eContainingClass.getName() + "::" + eReference.getName();
		}

		@Override
		public @NonNull String toString() {
			return getName() + "[" + eTarget2eSourceOrSources.size() + "]";
		}
	}

	private static final @NonNull List<@NonNull Object> NO_OBJECTS = Collections.emptyList();

	/**
	 * Return all the root EObjects in the ResourceSet else Resource containing contextEObject
	 * else the root container.
	 */
	public static @NonNull List<@NonNull EObject> computeRoots(@NonNull EObject contextEObject) {
		List<@NonNull EObject> allRootContents = new ArrayList<>();
		Resource contextResource = contextEObject.eResource();
		if (contextResource != null) {
			ResourceSet resourceSet = contextResource.getResourceSet();
			if (resourceSet != null) {
				for (Resource resource : resourceSet.getResources()) {
					allRootContents.addAll(resource.getContents());
				}
			}
			else {
				allRootContents.addAll(contextResource.getContents());
			}
		}
		else {
			EObject rootContainer = EcoreUtil.getRootContainer(contextEObject);
			assert rootContainer != null;
			allRootContents.add(rootContainer);
		}
		return allRootContents;
	}


	/**
	 * The root EObjects that together with their transitive containment descendants comprise the extent for allInstances() and implicit opposites.
	 */
	private final @NonNull List<@NonNull EObject> extentRoots;

	/**
	 * The EClasses for which allInstances caches are to be maintained.
	 */
	private final @NonNull List<@NonNull EClass> allInstancesEClasses;

	/**
	 * The EReferences for which implicit opposites caches are to be maintained.
	 */
	private final @NonNull List<@NonNull EReference> implicitOppositeEReferences;

	/**
	 * Map from an EClass to its allInstances/implicitOpposites metadata.
	 */
	private @Nullable Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis = null;

	/**
	 * Map from an EReference to its implicitOpposites cache.
	 */
	private @Nullable Map<@NonNull EReference, @NonNull EReferenceAnalysis> eReference2eReferenceAnalysis = null;

	/**
	 * Map from a neutral ClassId to its EClass.
	 */
	private @Nullable Map<@NonNull ClassId, @NonNull EClass> classId2eClass = null;

	public LazyEcoreModelManager(@NonNull EObject contextObject) {
		this(computeRoots(contextObject), null, null);
	}

	public LazyEcoreModelManager(@NonNull List<@NonNull EObject> extentRoots, @Nullable Iterable<@NonNull EClass> allInstancesClasses, @Nullable Iterable<@NonNull EReference> implicitOpposites) {
		this.extentRoots = extentRoots;
		for (@NonNull EObject eObject : extentRoots) {
			assert eObject.eContainer() == null;
		}
		this.allInstancesEClasses = allInstancesClasses != null ? Lists.newArrayList(allInstancesClasses) : new ArrayList<>();
		this.implicitOppositeEReferences = implicitOpposites != null ? Lists.newArrayList(implicitOpposites) : new ArrayList<>();
		assert new HashSet<>(this.allInstancesEClasses).size() == this.allInstancesEClasses.size();
		assert new HashSet<>(this.implicitOppositeEReferences).size() == this.implicitOppositeEReferences.size();
	}

	@Override
	public void addAllInstancesEClass(@NonNull EClass allInstancesEClass) {
		if (!allInstancesEClasses.contains(allInstancesEClass)) {
			allInstancesEClasses.add(allInstancesEClass);
			eClass2eClassAnalysis = null;
			eReference2eReferenceAnalysis = null;
		}
	}

	@Override
	public void addImplicitOppositeEReference(@NonNull EReference implicitOppositeEReference) {
		if (!implicitOppositeEReferences.contains(implicitOppositeEReference)) {
			implicitOppositeEReferences.add(implicitOppositeEReference);
			eClass2eClassAnalysis = null;
			eReference2eReferenceAnalysis = null;
		}
	}

	/**
	 * Perform the analyzis of the entire model to discover and cache all allInstances() and
	 * all implicit opposites.
	 */
	@Override
	public synchronized void analyze() {
		Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis2 = eClass2eClassAnalysis;
		if (eClass2eClassAnalysis2 == null) {
			//
			//	Create the map eagerly seeded by the known allInstances() classes.
			//
			eClass2eClassAnalysis2 = eClass2eClassAnalysis = new HashMap<>();
			for (@NonNull EClass allInstancesEClass : allInstancesEClasses) {
				eClass2eClassAnalysis2.put(allInstancesEClass, new EClassAnalysisWithInstances(this, allInstancesEClass));
			}
			for (@NonNull EClassAnalysis eClassAnalysis : eClass2eClassAnalysis2.values()) {
				((EClassAnalysisWithInstances)eClassAnalysis).analyzeInheritance();
			}
		}
		if (((allInstancesEClasses.size() + implicitOppositeEReferences.size()) > 0) || (classId2eClass != null)) {
			//
			//	Analyze the extent.
			//
			for (TreeIterator<EObject> tit = EcoreUtil.getAllContents(extentRoots); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				EClass eClass = eObject.eClass();
				assert eClass != null;
				EClassAnalysis eClassAnalysis = getEClassAnalysis(eClass);
				eClassAnalysis.analyzeEObject(eObject);
			}
		}
	//	if (eClass2eClassAnalysis == null) {
	//		eClass2eClassAnalysis = new HashMap<>();
	//	}
		if (eReference2eReferenceAnalysis == null) {
			eReference2eReferenceAnalysis = new HashMap<>();
		}
		for (@NonNull EClass eClass : allInstancesEClasses) {
			assert (eClass2eClassAnalysis != null) && eClass2eClassAnalysis.containsKey(eClass) : "No eClass2eClassAnalysis for " + eClass;

		}
	}

	/**
	 * Return the cache support for eClass.
	 */
	protected @Nullable EClassAnalysis basicGetEClassAnalysis(@NonNull EClass eClass) {
		return eClass2eClassAnalysis != null ? eClass2eClassAnalysis.get(eClass) : null;
	}

	/**
	 * Return the allInstances() cache for eClass.
	 */
	protected @NonNull EClassAnalysis getEClassAnalysis(@NonNull EClass eClass) {
		Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis2 = eClass2eClassAnalysis;
		assert eClass2eClassAnalysis2 != null;
		EClassAnalysis eClassAnalysis = eClass2eClassAnalysis2.get(eClass);
		if (eClassAnalysis == null) {
			//
			//	Lazily add the required EClassAnalysis and all its super EClassAnalysis so that diamond
			//	inheritances avoid duplicates by caching allInstances at the join.
			//
			EClassAnalysisWithInstances theEClassAnalysisWithInstances = null;
			for (EClass eSuperClass : eClass.getESuperTypes()) {
				assert eSuperClass != null;
				EClassAnalysis eSuperClassAnalysis = getEClassAnalysis(eSuperClass);
				EClassAnalysisWithInstances eClassAnalysisWithInstances = eSuperClassAnalysis.basicGetEClassAnalysisWithInstances();
				if (eClassAnalysisWithInstances != null) {
					if (theEClassAnalysisWithInstances == null) { // First allInstances() inheritance
						theEClassAnalysisWithInstances = eClassAnalysisWithInstances;
					}
					else {										// Multiple allInstances() inheritance
						assert theEClassAnalysisWithInstances != eClassAnalysisWithInstances;
						eClassAnalysis = new EClassAnalysisWithInstances(this, eClass);
						break;
					}
				}
			}
			if (eClassAnalysis == null) {
				eClassAnalysis = new EClassAnalysisWithoutInstances(this, eClass, theEClassAnalysisWithInstances);
			}
			eClass2eClassAnalysis2.put(eClass, eClassAnalysis);
		}
		return eClassAnalysis;
	}

	/**
	 * Return the implicit opposite cache for eReference or null if no cache is required.
	 *
	 */
	protected @Nullable EReferenceAnalysis getEReferenceAnalysis(@NonNull EReference eReference) {
		Map<@NonNull EReference, @NonNull EReferenceAnalysis> eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis;
		if (eReference2eReferenceAnalysis2 == null) {
			eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis = new HashMap<>();
			for (@NonNull EReference implicitOppositeEReference : implicitOppositeEReferences) {
				eReference2eReferenceAnalysis2.put(implicitOppositeEReference, new EReferenceAnalysis(implicitOppositeEReference));
			}
		}
		return eReference2eReferenceAnalysis2.get(eReference);
	}

	/**
	 * @since 1.18
	 */
	@Override
	public @Nullable Iterable<@NonNull ? extends Object> getInstances(@NonNull Class type) {
		EObject esObject = type.getESObject();
		if (esObject instanceof EClass) {
			return getInstances((EClass)esObject);
		}
		else {
			return getInstances(type.getTypeId());
		}
	}

	/**
	 * Return the instances of eClass and its subtypes, returning null for none.
	 */
	@Override
	public @Nullable Iterable<@NonNull EObject> getInstances(@NonNull EClass eClass) {
		addAllInstancesEClass(eClass);							// (Re-)insertion in case not yet configured.
		EClassAnalysis eClassAnalysis;
		Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis2 = eClass2eClassAnalysis;
		if ((eClass2eClassAnalysis2 == null) || ((eClassAnalysis = eClass2eClassAnalysis2.get(eClass)) == null)) {
			analyze();
			eClass2eClassAnalysis2 = eClass2eClassAnalysis;
			assert eClass2eClassAnalysis2 != null;
			eClassAnalysis = eClass2eClassAnalysis2.get(eClass);
			assert allInstancesEClasses.contains(eClass) : "No allInstancesEClasses for " + eClass;
			assert eClassAnalysis != null : "No EClassAnalysis for " + eClass;
		}
		return eClassAnalysis.getInstances();
	}

	@Override
	public @Nullable Iterable<@NonNull EObject> getInstances(@NonNull TypeId typeId) {
		Map<@NonNull ClassId, @NonNull EClass> classId2eClass2 = classId2eClass;
		if (classId2eClass2 == null) {
			classId2eClass2 = classId2eClass = new HashMap<>();
			Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis2 = eClass2eClassAnalysis;
			if (eClass2eClassAnalysis2 == null) {
				analyze();
				eClass2eClassAnalysis2 = eClass2eClassAnalysis;
				assert eClass2eClassAnalysis2 != null;
			}
			for (Map.@NonNull Entry<@NonNull EClass, @NonNull EClassAnalysis> entry : eClass2eClassAnalysis2.entrySet()) {
				EClass eClass = entry.getKey();
				ClassId classId = IdManager.getClassId(eClass);
				EClass old = classId2eClass2.put(classId, eClass);
				assert old == null;
			}
		}
		EClass eClass = classId2eClass2.get(typeId);
		if (eClass == null) {
			return null;
		}
		return getInstances(eClass);
	}

	/**
	 * Return the source EObjects for which the opposite of eReference navigates to eTarget, returning null if none.
	 */
	@Override
	public @Nullable Iterable<@NonNull EObject> getOpposites(@NonNull EReference eReference, @NonNull EObject eTarget) {
		Map<@NonNull EReference, @NonNull EReferenceAnalysis> eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis;
		if (eReference2eReferenceAnalysis2 == null) {
			addImplicitOppositeEReference(eReference);
			analyze();
			eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis;
			assert eReference2eReferenceAnalysis2 != null;
		}
		EReferenceAnalysis eReferenceAnalysis = eReference2eReferenceAnalysis2.get(eReference);
		if (eReferenceAnalysis == null) {
			addImplicitOppositeEReference(eReference);
			analyze();
			eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis;
			assert eReference2eReferenceAnalysis2 != null;
			eReferenceAnalysis = eReference2eReferenceAnalysis2.get(eReference);
			assert eReferenceAnalysis != null;
		}
		return eReferenceAnalysis.basicGetOpposites(eTarget);
	}


	@Override
	public @NonNull Iterable<@NonNull Object> getOpposite(@NonNull Property target2sourceProperty, @NonNull Object sourceObject) {
		EReference eReference = (EReference)target2sourceProperty.getESObject();
		assert eReference != null;
		Iterable<@NonNull ?> objects = getOpposites(eReference, (EObject)sourceObject);
		if (objects != null) {
			@SuppressWarnings("unchecked")
			Iterable<@NonNull Object> castObjects = (Iterable<@NonNull Object>)objects;
			return castObjects;
		}
		else {
			return NO_OBJECTS;
		}
	}

	@Deprecated
	@Override
	protected boolean isInstance(@NonNull Type type, @NonNull EObject element) {
		throw new UnsupportedOperationException("Not used for Ecore conformance");
	}

	@Override
	public void resetAnalysis() {
		classId2eClass = null;
		eClass2eClassAnalysis = null;
		eReference2eReferenceAnalysis = null;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;
		Map<@NonNull EClass, @NonNull EClassAnalysis> eClass2eClassAnalysis2 = eClass2eClassAnalysis;
		if (eClass2eClassAnalysis2 != null) {
			List<@NonNull EClassAnalysis> eClassAnalyses = new ArrayList<>(eClass2eClassAnalysis2.values());
			Collections.sort(eClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull EClassAnalysis eClassAnalysis : eClassAnalyses) {
				if (!(eClassAnalysis instanceof EClassAnalysisWithoutInstances) || (((EClassAnalysisWithoutInstances)eClassAnalysis).eClassAnalysisWithInstances != null)) {
					if (!isFirst) {
						s.append("\n");
					};
					s.append(eClassAnalysis.toString());
					isFirst = false;
				}
			}
		}
		Map<@NonNull EReference, @NonNull EReferenceAnalysis> eReference2eReferenceAnalysis2 = eReference2eReferenceAnalysis;
		if (eReference2eReferenceAnalysis2 != null) {
			List<@NonNull EReferenceAnalysis> eReferenceAnalyses = new ArrayList<>(eReference2eReferenceAnalysis2.values());
			Collections.sort(eReferenceAnalyses, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull EReferenceAnalysis eReferenceAnalysis : eReferenceAnalyses) {
				if (!isFirst) {
					s.append("\n");
				};
				s.append(eReferenceAnalysis.toString());
				isFirst = false;
			}
		}
		return s.toString();
	}
}
