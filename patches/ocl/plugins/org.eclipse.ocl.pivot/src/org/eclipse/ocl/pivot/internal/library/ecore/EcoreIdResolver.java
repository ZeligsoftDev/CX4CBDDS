/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.elements.AbstractExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractIdResolver;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutableStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * EcoreIdResolver provides a package discovery capability so that package identifiers can be resolved.
 * <p>
 * Given an initial seed of a standard library and one or more root EObjects, packages are discovered
 * by locating all packages and nested packages directly contained by the seed roots or by the roots of
 * any object referenced by any contained by the seed roots.
 */
public class EcoreIdResolver extends AbstractIdResolver implements Adapter
{
	//	protected @NonNull Map<ElementId, DomainElement> id2element = new HashMap<>();
	private @NonNull Map<EClassifier, WeakReference<CompleteInheritance>> typeMap = new WeakHashMap<>();

	public EcoreIdResolver(@NonNull Iterable<? extends EObject> roots, @NonNull ExecutorStandardLibrary standardLibrary) {
		super(standardLibrary);
		for (@SuppressWarnings("null")@NonNull EObject root : roots) {
			addRoot(root);
		}
	}

	@Override
	protected org.eclipse.ocl.pivot.@NonNull Package addEPackage(@NonNull EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		org.eclipse.ocl.pivot.Package asPackage = nsURI2package.get(nsURI);
		if (asPackage == null) {
			PackageId packageId = IdManager.getPackageId(ePackage);
			asPackage = new EcoreReflectivePackage(ePackage, this, packageId);
			nsURI2package.put(nsURI, asPackage);
			if (packageId instanceof RootPackageId) {
				roots2package.put(((RootPackageId)packageId).getName(), asPackage);
			}
		}
		return asPackage;
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public synchronized @NonNull CompleteInheritance getInheritance(@NonNull EClassifier eClassifier) {
		CompleteInheritance type = weakGet(typeMap, eClassifier);
		if (type == null) {
			EPackage ePackage = eClassifier.getEPackage();
			assert ePackage != null;
			ExecutorPackage execPackage = ((ExecutorStandardLibrary)standardLibrary).getPackage(ePackage);
			if (execPackage == null) {
				PackageId packageId = IdManager.getPackageId(ePackage);
				Element domainPackage = packageId.accept(this);
				if (domainPackage instanceof ExecutorPackage) {
					execPackage = (ExecutorPackage) domainPackage;
				}
			}
			if (execPackage != null) {
				org.eclipse.ocl.pivot.Class domainType = execPackage.getOwnedClass(eClassifier.getName());
				if (domainType != null) {
					type = standardLibrary.getInheritance(domainType);
					typeMap.put(eClassifier, new WeakReference<>(type));
				}
			}
		}
		return ClassUtil.nonNullState(type);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getStaticTypeOfValue(@Nullable Type staticType,  @Nullable Object value) {
		if (value instanceof AbstractExecutorType) {	// FIXME Bug 577889 The direct CGed Executor has no eClass() so use getMetaclass()
			Type type = key2type.get(value);
			if (type == null) {
				type = standardLibrary.getMetaclass((AbstractExecutorType)value);
				assert type != null;
				key2type.put(value, type);
			}
			return PivotUtil.getClass(type, standardLibrary);
		}
		else {
			return super.getStaticTypeOfValue(staticType, value);
		}
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public synchronized @NonNull TupleType getTupleType(@NonNull TupleTypeId typeId) {
		return ((ExecutableStandardLibrary)standardLibrary).getTupleType(typeId);
	}

	public @NonNull TupleType getTupleType(@NonNull TypedElement @NonNull ... parts) {
		int iSize = parts.length;
		List<@NonNull TuplePartId> partsList = new ArrayList<>(iSize);
		for (int i = 0; i < iSize; i++) {
			TypedElement part = parts[i];
			String partName = NameUtil.getSafeName(part);
			partsList.add(IdManager.getTuplePartId(i, partName, part.getTypeId()));
		}
		return getTupleType(IdManager.getTupleTypeId(TypeId.TUPLE_NAME, partsList));
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getType(@NonNull EClassifier eClassifier) {
		return getInheritance(eClassifier).getPivotClass();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {}			// FIXME ?? invalidate

	@Override
	public void setTarget(Notifier newTarget) {
		//			assert newTarget == resource;
	}
}
