/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.ids;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An NsURIPackageId provides a unique hierarchical identifier for a package which has an nsURI.
 */
public interface NsURIPackageId extends PackageId
{
	@Nullable EPackage getEPackage();
	@Nullable String getNsPrefix();
	@NonNull String getNsURI();
	void setEPackage(@NonNull EPackage ePackage);
}