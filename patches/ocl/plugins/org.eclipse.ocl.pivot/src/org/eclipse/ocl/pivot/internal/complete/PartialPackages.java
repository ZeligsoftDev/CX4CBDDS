/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.CompletePackageImpl;
import org.eclipse.ocl.pivot.internal.PackageImpl;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.TracingOption;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public final class PartialPackages extends EObjectResolvingEList<org.eclipse.ocl.pivot.Package> implements PackageListeners.IPackageListener
{
	private static class Package2PackageOwnedPackages implements Function<org.eclipse.ocl.pivot.Package, Iterable<org.eclipse.ocl.pivot.Package>>
	{
		@Override
		public Iterable<org.eclipse.ocl.pivot.Package> apply(org.eclipse.ocl.pivot.Package partialPackage) {
			return partialPackage.getOwnedPackages();
		}
	}

	private static final @NonNull Package2PackageOwnedPackages package2PackageOwnedPackages = new Package2PackageOwnedPackages();
	public static final @NonNull TracingOption PARTIAL_PACKAGES = new TracingOption(PivotPlugin.PLUGIN_ID, "partialPackages");
	//	static { PARTIAL_PACKAGES.setState(true); }
	private static final long serialVersionUID = 1L;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private Map<String, CompletePackage> name2nestedCompletePackage = null;

	/**
	 * Lazily created map of nested class-name to its inheritance.
	 */
	protected final @NonNull Map<String, CompleteInheritanceImpl> name2inheritance = new HashMap<String, CompleteInheritanceImpl>();

	public PartialPackages(@NonNull CompletePackageImpl owner) {
		super(org.eclipse.ocl.pivot.Package.class, owner, PivotPackage.Literals.COMPLETE_PACKAGE__PARTIAL_PACKAGES.getFeatureID());
	}

	@Override
	public void addUnique(org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		didAdd(partialPackage);
		super.addUnique(partialPackage);
	}

	@Override
	public void addUnique(int index, org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		didAdd(partialPackage);
		super.addUnique(index, partialPackage);
	}

	protected void didAdd(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		if (PARTIAL_PACKAGES.isActive()) {
			PARTIAL_PACKAGES.println("Do-didAdd " + this + " " + partialPackage);
		}
		((PackageImpl)partialPackage).addPackageListener(this);
		getCompletePackage().didAddPartialPackage(partialPackage);
		for (org.eclipse.ocl.pivot.Package nestedPackage : partialPackage.getOwnedPackages()) {
			if (nestedPackage != null) {
				getCompletePackage().didAddNestedPackage(nestedPackage);
			}
		}
	}

	@Override
	public void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package nestedPackage) {
		getCompletePackage().didAddNestedPackage(nestedPackage);
	}

	/*	public void didAddClass(@NonNull CompleteClass completeClass, @NonNull DomainClass partialClass) {
		if (getCompleteModel().didAddClass(partialClass, completeClass)) {
			((CompleteClassImpl)completeClass).getPartialClasses().initMemberFeaturesFrom((org.eclipse.ocl.pivot.Class)partialClass);
		}
	} */

	/*	protected void didAddCompleteClass(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.put(name, completeClass);
				assert oldCompleteClass == null;
			}
		}
	} */

	void didAddNestedCompletePackage(@NonNull CompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			CompletePackage oldCompletePackage = name2nestedCompletePackage.put(name, nestedCompletePackage);
			assert oldCompletePackage == null;
		}
	}

	/*	protected void didRemoveCompleteClass(@NonNull CompleteClass completeClass) {
		Map<String, CompleteClass> name2completeClass2 = name2completeClass;
		if (name2completeClass2 != null) {
			String name = completeClass.getName();
			if (name != null) {
				CompleteClass oldCompleteClass = name2completeClass2.remove(name);
				assert oldCompleteClass == completeClass;
			}
		}
	} */

	void didRemoveNestedCompletePackage(@NonNull CompletePackage nestedCompletePackage) {
		assert name2nestedCompletePackage != null;
		String name = nestedCompletePackage.getName();
		if (name != null) {
			name2nestedCompletePackage.remove(name);
		}
	}

	@Override
	protected void didRemove(int index, org.eclipse.ocl.pivot.Package partialPackage) {
		assert partialPackage != null;
		if (PARTIAL_PACKAGES.isActive()) {
			PARTIAL_PACKAGES.println("Do-didRemove " + this + " " + partialPackage);
		}
		super.didRemove(index, partialPackage);
		((PackageImpl)partialPackage).removePackageListener(this);
		getCompletePackage().didRemovePartialPackage(partialPackage);
	}

	@Override
	public void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package nestedPackage) {
		getCompletePackage().didRemoveNestedPackage(nestedPackage);
	}

	@Override
	public void didAddClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		getCompletePackage().didAddClass(partialClass);
	}

	@Override
	public void didRemoveClass(org.eclipse.ocl.pivot.@NonNull Class partialClass) {
		CompleteInheritanceImpl completeInheritance = name2inheritance.remove(partialClass.getName());
		//		System.out.println("PartialPackage.didRemoveClass " + partialClass);
		getCompletePackage().didRemoveClass(partialClass);
		if (completeInheritance != null) {
			completeInheritance.uninstall();
		}
	}

	public @NonNull CompleteInheritanceImpl getCompleteInheritance(@NonNull CompleteClassInternal completeClass) {
		String name = completeClass.getName();
		CompleteInheritanceImpl completeInheritance = name2inheritance.get(name);
		if (completeInheritance == null) {
			completeInheritance = new CompleteInheritanceImpl(completeClass);
			//			System.out.println("PartialPackage.add " + completeClass);
			name2inheritance.put(name, completeInheritance);
		}
		return completeInheritance;
	}

	public @NonNull CompleteModelInternal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageImpl getCompletePackage() {
		return (CompletePackageImpl) owner;
	}

	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getNestedPartialPackages() {
		PartialPackages partialPackages = getCompletePackage().getPartialPackages();
		Iterable<Iterable<org.eclipse.ocl.pivot.Package>> roots_packages = Iterables.transform(partialPackages, package2PackageOwnedPackages);
		@NonNull Iterable<Package> allPackages = Iterables.concat(roots_packages);
		return allPackages;
	}

	public void uninstalled(@NonNull CompleteClassInternal completeClass) {
		//		System.out.println("PartialPackages.uninstalled " + completeClass + " " + NameUtil.debugFullName(completeClass));
		CompleteInheritanceImpl inheritance = name2inheritance.remove(completeClass.getName());
		if (inheritance != null) {
			inheritance.uninstall();
		}
	}
}