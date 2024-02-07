/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory for OCL delegate domains.
 */
public class OCLDelegateDomainFactory implements DelegateDomain.Factory
{	
	public OCLDelegateDomainFactory() {}

	@Override
	public @NonNull OCLDelegateDomain createDelegateDomain(@NonNull String delegateURI, @NonNull EPackage ePackage) {
		return new OCLDelegateDomain(delegateURI, ePackage);
	}
}
