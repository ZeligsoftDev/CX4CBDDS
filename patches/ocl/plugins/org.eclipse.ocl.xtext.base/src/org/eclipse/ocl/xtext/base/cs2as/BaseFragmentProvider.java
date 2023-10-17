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
package org.eclipse.ocl.xtext.base.cs2as;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.xtext.resource.DefaultFragmentProvider;

public class BaseFragmentProvider extends DefaultFragmentProvider
{
	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		// fragment should be a CS fragment
		if (resource == null) {
			return null;
		}
		if (fragment.startsWith("/")) {
			return super.getEObject(resource, fragment, fallback);
		}
		EObject eObject = super.getEObject(resource, fragment, fallback);
		if (eObject != null) {
			return eObject;
		}
		BaseCSResource csResource = (BaseCSResource)resource;
		CS2AS cs2as = csResource.findCS2AS();
		if (cs2as != null) {
			Resource asResource = cs2as.getASResource();
			eObject = asResource.getEObject(fragment);
			if (eObject != null) {
				return eObject;
			}
		}
		return null;
	}
}
