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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.utilities.IllegalMetamodelException;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

public class CompleteURIs
{
	protected final @NonNull CompleteModelInternal completeModel;
	/**
	 * Map of Complete URI to Package URIs
	 */
	private final @NonNull Map<String, Set<String>> completeURI2packageURIs = new HashMap<String, Set<String>>();

	/**
	 * Map of Package URI to Complete URI.
	 */
	private final @NonNull Map<String, String> packageURI2completeURI = new HashMap<String, String>();

	/**
	 * Map from Complete URI to Complete Package.
	 */
	private final @NonNull Map<String, @NonNull CompletePackageInternal> completeURI2completePackage = new HashMap<String, @NonNull CompletePackageInternal>();

	public CompleteURIs(@NonNull CompleteModelInternal completeModel) {
		this.completeModel = completeModel;
	}

	public void didAddCompletePackage(@NonNull CompletePackageInternal completePackage) {
		//		if ((completePackage != completeModel.getOrphanCompletePackage()) && (completePackage != completeModel.getPrimitiveCompletePackage())) {
		String completeURI = completePackage.getURI();
		if (completeURI != null) {
			CompletePackage oldCompletePackage = completeURI2completePackage.put(completeURI, completePackage);
			assert oldCompletePackage == null;
		}
		//		}
	}

	public void didAddPartialModel(@NonNull Model partialModel) {
		for (org.eclipse.ocl.pivot.Package asPackage : partialModel.getOwnedPackages()) {
			String packageURI = asPackage.getURI();
			String completeURI = getCompleteURI(packageURI);
			if (completeURI == packageURI) {
				PackageId packageId = asPackage.getPackageId();
				if (packageId == IdManager.METAMODEL) {
					if (packageURI != null) {
						addPackageURI2completeURI(packageURI, PivotConstants.METAMODEL_NAME);
					}
				}
			}
		}
	}

	public void didRemoveCompletePackage(@NonNull CompletePackageInternal completePackage) {
		//		if ((completePackage != completeModel.getOrphanCompletePackage()) && (completePackage != completeModel.getPrimitiveCompletePackage())) {
		String completeURI = completePackage.getURI();
		if (completeURI != null) {
			completeURI2completePackage.remove(completeURI);
			Set<String> packageURIs = completeURI2packageURIs.remove(completeURI);
			if (packageURIs != null) {
				for (String packageURI : packageURIs) {
					packageURI2completeURI.remove(packageURI);
				}
			}
		}
		//		}
	}

	public void didRemovePartialModel(@NonNull Model partialModel) {
		for (org.eclipse.ocl.pivot.Package asPackage : partialModel.getOwnedPackages()) {
			String packageURI = asPackage.getURI();
			String completeURI = getCompleteURI(packageURI);
			if (completeURI == packageURI) {
				PackageId packageId = asPackage.getPackageId();
				if (packageId == IdManager.METAMODEL) {
					if (packageURI != null) {
						//FIXME						removePackageURI2completeURI(packageURI, DomainConstants.METAMODEL_NAME);
					}
				}
			}
		}
	}

	public synchronized void dispose() {
		completeURI2completePackage.clear();
	}

	public @NonNull Iterable<@NonNull CompletePackageInternal> getAllCompletePackages() {
		return completeURI2completePackage.values();
	}

	public @NonNull Iterable<@NonNull ? extends CompletePackageInternal> getAllCompletePackagesWithUris() {
		return completeURI2completePackage.values();
	}

	/**
	 * Partial models such as the OCL Standard Library have their own distinct package URI. These partial
	 * models are merged by mapping the package URI to a complete URI. DomainConstants.METAMODEL_NAME is the
	 * complete URI for all contributions merged as the overall OCL metamodel.
	 */
	public void addPackageURI2completeURI(@NonNull String packageURI, @NonNull String newCompleteURI) {
		String oldCompleteURI = packageURI2completeURI.get(packageURI);
		if (newCompleteURI.equals(oldCompleteURI)) {
			return;
		}
		if (oldCompleteURI != null) {
			throw new IllegalMetamodelException(newCompleteURI, oldCompleteURI);	// FIXME Better name
		}
		if (completeURI2packageURIs.containsKey(packageURI)) {
			throw new IllegalMetamodelException(packageURI, oldCompleteURI);	// FIXME Better name
		}
		packageURI2completeURI.put(packageURI, newCompleteURI);
		Set<String> packageURIs = completeURI2packageURIs.get(newCompleteURI);
		if (packageURIs == null) {
			packageURIs = new HashSet<String>();
			completeURI2packageURIs.put(newCompleteURI, packageURIs);
		}
		packageURIs.add(packageURI);
	}

	public @Nullable CompletePackageInternal getCompletePackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		String packageURI = pivotPackage.getURI();
		if (packageURI == null) {
			return null;
		}
		String completeURI = getCompleteURI(packageURI);
		return completeURI != null ? completeURI2completePackage.get(completeURI) : null;
	}

	public @Nullable CompletePackageInternal getCompletePackage(@Nullable String completeURI) {
		return completeURI != null ? completeURI2completePackage.get(completeURI) : null;
	}

	public @Nullable CompletePackageInternal getCompletePackageByURI(@NonNull String packageURI) {
		int lastIndex = packageURI.lastIndexOf("#/");
		if (lastIndex > 0) {
			@NonNull String substring = packageURI.substring(0, lastIndex);
			packageURI = substring;
		}
		String completeURI = getCompleteURI(packageURI);
		return completeURI2completePackage.get(completeURI);
	}

	public @Nullable String getCompleteURI(@Nullable String packageURI) {
		String completeURI = packageURI2completeURI.get(packageURI);
		if (completeURI != null) {
			return completeURI;
		}
		else {
			return packageURI;
		}
	}

	public void removeCompletePackage(String completeURI) {
		completeURI2completePackage.remove(completeURI);
	}
}