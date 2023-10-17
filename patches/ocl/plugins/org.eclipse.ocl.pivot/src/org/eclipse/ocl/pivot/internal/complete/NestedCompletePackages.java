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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.CompletePackageImpl;

public class NestedCompletePackages extends AbstractCompletePackages
{
	private static final long serialVersionUID = 1L;

	public NestedCompletePackages(@NonNull CompletePackageImpl owner) {
		super(CompletePackage.class, owner, PivotPackage.Literals.COMPLETE_PACKAGE__OWNED_COMPLETE_PACKAGES.getFeatureID(),
			PivotPackage.Literals.COMPLETE_PACKAGE__OWNING_COMPLETE_PACKAGE.getFeatureID());
		doRefreshNestedPackages();
	}

	@Override
	public @NonNull CompletePackageInternal createCompletePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		CompletePackageInternal completePackage = (CompletePackageInternal) PivotFactory.eINSTANCE.createCompletePackage();
		completePackage.init(partialPackage.getName(), partialPackage.getNsPrefix(), partialPackage.getURI());
		return completePackage;
	}

	protected void doRefreshNestedPackages() {
		for (org.eclipse.ocl.pivot.Package partialPackage : getPartialPackages()) {
//			for (org.eclipse.ocl.pivot.Package partialChildPackage : partialParentPackage.getOwnedPackages()) {
				if (partialPackage != null) {
					getOwnedCompletePackage(partialPackage);
				}
//			}
		}
	}

	@Override
	public @NonNull CompleteModelInternal getCompleteModel() {
		return getCompletePackage().getCompleteModel();
	}

	@SuppressWarnings("null")
	public @NonNull CompletePackageInternal getCompletePackage() {
		return (CompletePackageInternal)owner;
	}

	@Override
	public @NonNull CompletePackageInternal getOwnedCompletePackage(org.eclipse.ocl.pivot.@NonNull Package partialPackage) {
		CompletePackageInternal completePackage = null;
		String uri = partialPackage.getURI();
		if (uri != null) {
			completePackage = getCompleteModel().getCompletePackageByURI(uri);
		}
		if (completePackage == null) {
			String name = partialPackage.getName();
			completePackage = super.getOwnedCompletePackage(name);
		}
		if (completePackage == null) {
			completePackage = createCompletePackage(partialPackage);
			add(completePackage);
		}
		completePackage.getPartialPackages().add(partialPackage);
		return completePackage;
	}

	@Override
	protected @NonNull Iterable<org.eclipse.ocl.pivot.Package> getPartialPackages() {
		return getCompletePackage().getPartialPackages().getNestedPartialPackages();
	}
}