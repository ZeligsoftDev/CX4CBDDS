/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
//import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
//import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * ASSaver ensures that all references to synthesized types are terminated
 * by local copies of the synthesized types.
 */
@Deprecated /* @deprecated Replaced by safer EcoreUtil.Copier/CrossReferencer functionality */
public class ASSaver extends AbstractASSaver
{
	public ASSaver(@NonNull Resource resource) {
		super(resource);
	}

	/**
	 * The moniker to operation map for operations defined with the saved resource.
	 */
	private Map<@NonNull String, @NonNull Operation> operations = new HashMap<>();

	/**
	 * TypedElements that refer to specializations that have yet to be resolved..
	 */
	private @NonNull LinkedHashSet<@NonNull Element> unresolvedSpecializingElements = new LinkedHashSet<>();	// LinkedHashSet stabilises regeneration xmi:ids

	/**
	 * TypedElements that refer to specializations that have been resolved..
	 */
	private @NonNull Set<@NonNull Element> resolvedSpecializingElements = new HashSet<>();

	/**
	 * The extra package for copies of specializations.
	 */
	private /*@LazyNonNull*/ org.eclipse.ocl.pivot.Package localOrphanage = null;

	/**
	 * Map of original specialization to local specialization
	 */
	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, org.eclipse.ocl.pivot.@NonNull Class> specializations = new HashMap<>();

	/**
	 * The extra package for copies of specializations.
	 */
	private /*@LazyNonNull*/ org.eclipse.ocl.pivot.Class orphanageClass = null;

	public void addSpecializingElement(@NonNull Element object) {
		if (!resolvedSpecializingElements.contains(object)) {
			unresolvedSpecializingElements.add(object);
		}
	}

	public boolean addSpecializingElement(@NonNull Element object, org.eclipse.ocl.pivot.@NonNull Class referredType) {
		if (!PivotUtilInternal.isOrphanType(referredType)) {
			return false;
		}
		else {
			addSpecializingElement(object);
			return true;
		}
	}

	public boolean addSpecializingElement(@NonNull Element object, @NonNull Operation referredOperation) {
		if (!isOrphanOperation(referredOperation)) {
			return false;
		}
		else {
			addSpecializingElement(object);
			return true;
		}
	}

	/**
	 * @since 1.3
	 */
	public boolean addSpecializingElement(@NonNull Element object, @NonNull Property referredProperty) {
		if (!PivotUtilInternal.isOrphanProperty(referredProperty)) {
			return false;
		}
		else {
			addSpecializingElement(object);
			return true;
		}
	}

	protected @NonNull ASSaverLocateVisitor getLocateVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createASSaverLocateVisitor(this);
		}
		else if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverLocateVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	protected org.eclipse.ocl.pivot.@NonNull Class getOrphanClass(org.eclipse.ocl.pivot.@NonNull Package orphanagePackage) {
		org.eclipse.ocl.pivot.Class orphanageClass2 = orphanageClass;
		if (orphanageClass2 == null) {
			orphanageClass = orphanageClass2 = PivotFactory.eINSTANCE.createAnyType();		// No superclasses
			orphanageClass2.setName(PivotConstants.ORPHANAGE_NAME);
			orphanagePackage.getOwnedClasses().add(orphanageClass2);
		}
		return orphanageClass2;
	}

	protected org.eclipse.ocl.pivot.@NonNull Package getOrphanPackage(@NonNull Resource resource) {
		org.eclipse.ocl.pivot.Package localOrphanage2 = localOrphanage;
		if (localOrphanage2 == null) {
			localOrphanage = localOrphanage2 = Orphanage.createLocalOrphanPackage(PivotUtil.getModel(resource));
		}
		return localOrphanage2;
	}

	protected @NonNull ASSaverResolveVisitor getResolveVisitor(@NonNull EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof ASResource) {
			return ((ASResource)resource).getASResourceFactory().createASSaverResolveVisitor(this);
		}
		else if (resource == null) {
			throw new IllegalStateException("Cannot locate " + ASSaverResolveVisitor.class.getName() + " for resource-less " + eObject.eClass().getName());
		}
		else {
			throw new IllegalStateException("Cannot locate " + ASSaverResolveVisitor.class.getName() + " for non-OCL " + resource.getClass().getName());
		}
	}

	protected boolean isOrphanOperation(@NonNull Operation operation) {		// FIXME Non-static PivotUtils
		// FIXME surely an orphan is one for which eResource() is null,
		//  or one that is in the orphanage.
		if (operation.getOwnedBindings().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	public void localizeSpecializations() {
		locateSpecializations(resource.getContents());
		if (unresolvedSpecializingElements.size() > 0) {
			loadOrphanage(resource);
			while (unresolvedSpecializingElements.size() > 0) {
				List<@NonNull Element> elements = new ArrayList<>(unresolvedSpecializingElements);
				for (@NonNull Element element : elements) {
					ASSaverResolveVisitor resolveVisitor = getResolveVisitor(element);
					resolveVisitor.safeVisit(element);
					resolvedSpecializingElements.add(element);
					unresolvedSpecializingElements.remove(element);
				}
			}
			if (resource instanceof ASResource){
				((ASResource)resource).resetLUSSIDs();			// Force regeneration for localized packages
			}
		}
	}

	protected void loadOrphanage(@NonNull Resource resource) {
		Model root = null;
		org.eclipse.ocl.pivot.Package localOrphanage2 = localOrphanage;
		if (localOrphanage2 == null) {
			for (EObject eRoot : resource.getContents()) {
				if (eRoot instanceof Model) {
					if (root == null) {
						root = (Model) eRoot;
					}
					if (localOrphanage2 == null) {
						for (org.eclipse.ocl.pivot.Package asPackage : ((Model)eRoot).getOwnedPackages()) {
							if (Orphanage.isTypeOrphanage(asPackage)) {
								localOrphanage = localOrphanage2 = asPackage;
								for (org.eclipse.ocl.pivot.Class asType : localOrphanage2.getOwnedClasses()) {
									if (PivotConstants.ORPHANAGE_NAME.equals(asType.getName())) {
										orphanageClass = asType;
									}
									else {
										specializations.put(asType, asType);
									}
								}
								break;
							}
						}
					}
				}
				if ((eRoot instanceof org.eclipse.ocl.pivot.Package) && Orphanage.isTypeOrphanage((org.eclipse.ocl.pivot.Package)eRoot)) {	// FIXME Obsolete
					localOrphanage = localOrphanage2 = (org.eclipse.ocl.pivot.Package)eRoot;
					for (org.eclipse.ocl.pivot.Class asType : localOrphanage2.getOwnedClasses()) {
						if (PivotConstants.ORPHANAGE_NAME.equals(asType.getName())) {
							orphanageClass = asType;
						}
						else {
							specializations.put(asType, asType);
						}
					}
					break;
				}
			}
		}
	}

	protected void locateSpecializations(/*@NonNull*/ List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			if (eObject instanceof Visitable) {
				ASSaverLocateVisitor locateVisitor = getLocateVisitor(eObject);
				locateVisitor.safeVisit((Visitable) eObject);
			}
			if (eObject != null) {
				locateSpecializations(eObject.eContents());
			}
		}
	}

	/**
	 * Return the resolved variant of referredType, which may require creation
	 * of a local copy of a specialization.
	 */
	public @NonNull <T extends Operation> T resolveOperation(@NonNull T referredOperation) {
		if (!isOrphanOperation(referredOperation)) {
			return referredOperation;
		}
		String moniker = AS2Moniker.toString(referredOperation);
		Operation operation = operations.get(moniker);
		if (operation != null) {
			@SuppressWarnings("unchecked")
			T castOperation = (T) operation;
			return castOperation;
		}
		T resolvedOperation = ClassUtil.nonNullEMF(EcoreUtil.copy(referredOperation));
		if (orphanageClass == null) {
			org.eclipse.ocl.pivot.Package localOrphanage2 = localOrphanage;
			if (localOrphanage2 == null) {
				localOrphanage2 = getOrphanPackage(resource);
			}
			orphanageClass = getOrphanClass(localOrphanage2);
		}
		orphanageClass.getOwnedOperations().add(resolvedOperation);
		operations.put(moniker, resolvedOperation);
		String newMoniker = AS2Moniker.toString(resolvedOperation);
		assert moniker.equals(newMoniker);
		locateSpecializations(Collections.singletonList(resolvedOperation));
		return resolvedOperation;
	}

	/**
	 * @since 1.3
	 */
	public @NonNull Property resolveProperty(@NonNull Property referredProperty) {
		if (!PivotUtilInternal.isOrphanProperty(referredProperty)) {
			return referredProperty;
		}
		org.eclipse.ocl.pivot.Class referredClass = PivotUtil.getOwningClass(referredProperty);
		org.eclipse.ocl.pivot.Class resolvedClass = resolveType(referredClass);
		Property resolvedProperty = NameUtil.getNameable(resolvedClass.getOwnedProperties(), PivotUtil.getName(referredProperty));
		return ClassUtil.nonNullState(resolvedProperty);
	}

	/**
	 * Return the resolved variant of referredType, which may require creation
	 * of a local copy of a specialization.
	 */
	public @NonNull <T extends org.eclipse.ocl.pivot.Class> T resolveType(@NonNull T referredType) {
		if (!PivotUtilInternal.isOrphanType(referredType)) {
			return referredType;
		}
		org.eclipse.ocl.pivot.Class resolvedType = specializations.get(referredType);
		if (resolvedType == null) {
			resolvedType = ClassUtil.nonNullEMF(EcoreUtil.copy(referredType));	// FIXME cast
			specializations.put(referredType, resolvedType);	// FIXME cast
			specializations.put(resolvedType, resolvedType);
			EObject eContainer = resolvedType.eContainer();
			if (eContainer == null) {
				org.eclipse.ocl.pivot.Package localOrphanage2 = localOrphanage;
				if (localOrphanage2 == null) {
					localOrphanage2 = getOrphanPackage(resource);
				}
				localOrphanage.getOwnedClasses().add(resolvedType);
			}
		}
		locateSpecializations(Collections.singletonList(resolvedType));
		@SuppressWarnings("unchecked")
		T castType = (T)resolvedType;
		return castType;
	}
}