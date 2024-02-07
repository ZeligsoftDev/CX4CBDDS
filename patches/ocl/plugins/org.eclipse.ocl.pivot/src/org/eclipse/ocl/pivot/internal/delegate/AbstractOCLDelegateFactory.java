/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 353171
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Partial implementation of a factory of OCL delegates for Ecore features.
 */
public abstract class AbstractOCLDelegateFactory
{
	protected final @NonNull String delegateURI;

	/**
	 * Construct a factory for an unknown delegate domain; often the global factory.
	 */
	protected AbstractOCLDelegateFactory(@NonNull String delegateURI) {
		this.delegateURI = delegateURI;
	}

	protected @Nullable OCLDelegateDomain getDelegateDomain(@NonNull EPackage ePackage) {
		DelegateEPackageAdapter ePackageAdapter = DelegateEPackageAdapter.getAdapter(ePackage);
		OCLDelegateDomain delegateDomain = (OCLDelegateDomain) ePackageAdapter.getDelegateDomain(delegateURI);
		return delegateDomain;
	}

	/**
	 * @nooverride This is not intended to be overridden by clients.
	 */
	public @NonNull String getURI() {
		return delegateURI;
	}

	/**
	 * Return the DelegateDomain for this package, creating one if it does not already exist. 
	 */
	protected OCLDelegateDomain loadDelegateDomain(@NonNull EPackage ePackage) {
		DelegateEPackageAdapter ePackageAdapter = DelegateEPackageAdapter.getAdapter(ePackage);
		return (OCLDelegateDomain) ePackageAdapter.loadDelegateDomain(delegateURI);
	}
}
