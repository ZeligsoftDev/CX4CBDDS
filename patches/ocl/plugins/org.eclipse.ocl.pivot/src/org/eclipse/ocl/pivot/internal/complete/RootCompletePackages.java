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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.CompleteModelImpl;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;

public class RootCompletePackages extends AbstractCompletePackages
{
	private static final Logger logger = LogManager.getLogger(RootCompletePackages.class);

	private static final long serialVersionUID = 1L;

	public RootCompletePackages(@NonNull CompleteModelImpl owner) {
		super(CompletePackage.class, owner, PivotPackage.Literals.COMPLETE_MODEL__OWNED_COMPLETE_PACKAGES.getFeatureID(), PivotPackage.Literals.COMPLETE_PACKAGE__OWNING_COMPLETE_MODEL.getFeatureID());
	}

	@Override
	public @NonNull CompletePackageInternal createCompletePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		CompletePackageInternal completePackage = (CompletePackageInternal) PivotFactory.eINSTANCE.createCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI());
		return completePackage;
	}

	protected @NonNull CompletePackageInternal createRootCompletePackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		if (Orphanage.isTypeOrphanage(pivotPackage)) {
			return getCompleteModel().getOrphanCompletePackage();
		}
		else {
			String name = pivotPackage.getName();
			String nonNullName = name;
			if (nonNullName == null) {
				nonNullName = "$anon_" + Integer.toHexString(System.identityHashCode(pivotPackage));
			}
			String nsPrefix = pivotPackage.getNsPrefix();
			String completeURI = getCompleteModel().getCompleteURIs().getCompleteURI(pivotPackage.getURI());
			CompletePackageInternal rootCompletePackage = (CompletePackageInternal) PivotFactory.eINSTANCE.createCompletePackage();
			rootCompletePackage.init(nonNullName, nsPrefix, completeURI);
			add(rootCompletePackage);
			return rootCompletePackage;
		}
	}

	@Override
	protected void didAdd(@NonNull CompletePackage rootCompletePackage) {
		super.didAdd(rootCompletePackage);
//		String nsURI = rootCompletePackage.getURI();			// FIXME complete/package/URI/name
//		String sharedNsURI = getCompleteURI(nsURI);
//		if ((sharedNsURI != null) && (sharedNsURI == nsURI)) {
//			name2completePackage.put(nsURI, rootCompletePackage);
//		}
	}

	@Override
	protected void didRemove(int index, CompletePackage rootCompletePackage) {
		assert rootCompletePackage != null;
		super.didRemove(index, rootCompletePackage);
//		getCompleteModel().didRemoveCompletePackage(rootCompletePackage);
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull CompleteModelInternal getCompleteModel() {
		return (CompleteModelInternal)owner;
	}

	@Override
	public @NonNull CompletePackageInternal getOwnedCompletePackage(org.eclipse.ocl.pivot.@NonNull Package pivotPackage) {
		//
		//	Try to find package by packageURI
		//
		CompletePackageInternal completePackage = getCompleteModel().getCompleteURIs().getCompletePackage(pivotPackage);
		if (completePackage != null) {
			return completePackage;
		}
		//
		//	Else generate an error for a name-less Package, fatally if also packageURI-less.
		//
		String packageURI = pivotPackage.getURI();
		String name = pivotPackage.getName();
		if (name == null) {
			String message = null;
			for (EObject eObject = pivotPackage; eObject != null; eObject = eObject.eContainer()) {
				if (eObject instanceof Model) {
					message = "Unnamed package for '" + packageURI + "' in '" + ((Model)eObject).getExternalURI() + "'";
					break;
				}
			}
			if (message == null) {
				message = "Unnamed package for '" + packageURI + "'";
			}
			logger.error(message);
			name = packageURI;
			if (name == null) {
				throw new IllegalStateException(message);
			}
		}
		//
		//	Try to find package by name, provided there is no packageURI conflict
		//
		CompletePackageInternal rootCompletePackage = getOwnedCompletePackage(name);
		if (rootCompletePackage != null) {
			String completeURI2 = rootCompletePackage.getURI();
			if ((packageURI == null) || (completeURI2 == null) || packageURI.equals(completeURI2)) {
				return rootCompletePackage;
			}
		}
		rootCompletePackage = createRootCompletePackage(pivotPackage);
		return rootCompletePackage;
	}

	@Override
	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages() {
		return getCompleteModel().getPartialModels().getNestedPartialPackages();
	}
}