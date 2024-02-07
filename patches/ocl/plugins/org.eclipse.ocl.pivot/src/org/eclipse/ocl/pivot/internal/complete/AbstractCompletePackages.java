/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.TracingOption;

public abstract class AbstractCompletePackages extends EObjectContainmentWithInverseEList<CompletePackage>
{
	public static final @NonNull TracingOption COMPLETE_PACKAGES = new TracingOption(PivotPlugin.PLUGIN_ID, "completePackages");
//	static { COMPLETE_PACKAGES.setState(true); }
	private static final long serialVersionUID = 1L;

	/**
	 * Map of (nested) package-name to package server.
	 */
	private final @NonNull Map<@NonNull String, @Nullable CompletePackageInternal> name2completePackage = new HashMap<@NonNull String, @Nullable CompletePackageInternal>();

	public AbstractCompletePackages(Class<?> dataClass, @NonNull NamedElementImpl owner, int featureID, int inverseFeatureID) {
		super(dataClass, owner, featureID, inverseFeatureID);
		if (COMPLETE_PACKAGES.isActive()) {
			COMPLETE_PACKAGES.println("Create " + this);
		}
	}

	@Override
	public void addUnique(CompletePackage completePackage) {
		assert completePackage != null;
		super.addUnique(completePackage);
		didAdd(completePackage);
	}

	@Override
	public void addUnique(int index, CompletePackage completePackage) {
		assert completePackage != null;
		super.addUnique(index, completePackage);
		didAdd(completePackage);
	}

	public abstract @NonNull CompletePackageInternal createCompletePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage);

	protected void didAdd(@NonNull CompletePackage completePackage) {
		CompletePackageInternal completePackageInternal = (CompletePackageInternal)completePackage;
		String name = completePackageInternal.getName();
		if (name != null) {
			if (!name2completePackage.containsKey(name)) {
				CompletePackage oldCompletePackage = name2completePackage.put(name, completePackageInternal);		// New name
				assert oldCompletePackage == null;
			}
			else {
				name2completePackage.put(name, null);														// Ambiguous name
			}
		}
		getCompleteModel().didAddCompletePackage(completePackageInternal);
	}

	public void didAddPackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		CompletePackage completePackage = null;
		String name = pivotPackage.getName();
		String packageURI = pivotPackage.getURI();
		if (packageURI != null) {										// Explicit packageURI for explicit package (merge)
			completePackage = getCompleteModel().getCompleteURIs().getCompletePackage(packageURI);
		}
		else if (name != null) {										// Null packageURI can merge into same named package
			completePackage = getOwnedCompletePackage(name);
		}
		if (completePackage == null) {
			completePackage = getOwnedCompletePackage(pivotPackage);
			completePackage.assertSamePackage(pivotPackage);
		}
		completePackage.getPartialPackages().add(pivotPackage);
//		completePackage.addTrackedPackage(pivotPackage);
//		for (org.eclipse.ocl.pivot.Package nestedPackage : pivotPackage.getOwnedPackages()) {
//			if (nestedPackage != null) {
//				addPackage(completePackage, nestedPackage);
//			}
//		}
	}

	@Override
	protected void didRemove(int index, CompletePackage completePackage) {
		assert completePackage != null;
		CompletePackageInternal completePackageInternal = (CompletePackageInternal)completePackage;
		super.didRemove(index, completePackageInternal);
		name2completePackage.remove(completePackageInternal.getName());
		getCompleteModel().didRemoveCompletePackage(completePackageInternal);
	}

	public void didRemovePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		CompletePackage completePackage = getCompletePackage(partialPackage);
		List<Package> partialPackages = completePackage.getPartialPackages();
		partialPackages.remove(partialPackage);
		if (partialPackages.size() <= 0) {
			getCompleteModel().getCompleteURIs().removeCompletePackage(completePackage.getURI());
//			name2completePackage.remove(completePackage.getName());
			remove(completePackage);
		}
	}

	public synchronized void dispose() {
		Collection<CompletePackageInternal> savedCompletePackages = name2completePackage.values();
		name2completePackage.clear();
		for (CompletePackageInternal completePackage : savedCompletePackages) {
			completePackage.dispose();
		}
	}

	protected abstract CompleteModelInternal getCompleteModel();

	public @NonNull CompletePackageInternal getCompletePackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		CompletePackageInternal completePackage = null;
		if (pivotPackage instanceof CompletePackageInternal) {
			((CompletePackageInternal)pivotPackage).assertSamePackage(pivotPackage);
			completePackage = (CompletePackageInternal)pivotPackage;
		}
		else {
			CompleteURIs completeURIs = getCompleteModel().getCompleteURIs();
			completePackage = completeURIs.getCompletePackage(pivotPackage);
			if (completePackage == null) {
				org.eclipse.ocl.pivot.Package pivotPackageParent = pivotPackage.getOwningPackage();
				if (pivotPackageParent == null) {
					completePackage = getOwnedCompletePackage(pivotPackage);
					completePackage.getPartialPackages().add(pivotPackage);
//					completePackage.addTrackedPackage(pivotPackage);
					completePackage.assertSamePackage(pivotPackage);
				}
				else {
					CompletePackageInternal completeParentPackage = getCompletePackage(pivotPackageParent);
					CompletePackageInternal completeChildPackage = completeParentPackage.getOwnedCompletePackage(pivotPackage.getName());
					assert completeChildPackage != null;
					return completeChildPackage;
//					CompletePackageParent completePackageParent;
/*					PackageTracker parentTracker = getPackageTracker(pivotPackageParent);
					completePackageParent = parentTracker.getPackageServer();
					((PackageServer)completePackageParent).assertSamePackage(pivotPackageParent); */
//					completePackage = completePackageParent.getMemberPackageServer(pivotPackage);
//					completePackage.addTrackedPackage(pivotPackage);
//					completePackage.assertSamePackage(pivotPackage);
				}
			}
		}
		completePackage.assertSamePackage(pivotPackage);
		return completePackage;
	}

	public @Nullable CompletePackageInternal getOwnedCompletePackage(@Nullable String name) {
		return name2completePackage.get(name);
	}

	protected abstract @NonNull CompletePackageInternal getOwnedCompletePackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage);

	protected abstract @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages();

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + owner.toString();
	}
}