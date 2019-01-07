/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.rsm.tooling.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Miscellaneous utilities for working with RSM resources.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class RSMUtil {

	/**
	 * The file extension convenionally used for RSM profile resources ({@value}).
	 */
	public static final String PROFILE_RESOURCE_FILE_EXTENSION = "epx"; //$NON-NLS-1$

	/**
	 * Not instantiable by clients.
	 */
	private RSMUtil() {
		super();
	}

	/**
	 * Loads a package in the current resource set.
	 * 
	 * @param <T>
	 *            the expected kind of UML package to load from the resource
	 * 
	 * @param rset
	 *            the contextual resource set
	 * @param uri
	 *            the package's location URI
	 * 
	 * @return the package at the specified location URI, or <code>null</code>
	 *         if the specified resource does not contain a package
	 * 
	 * @throws org.eclipse.emf.common.util.WrappedException
	 *             if the resource could not be loaded
	 */
	public static <T extends Package> T loadPackage(ResourceSet rset, URI uri) {
		Resource res = rset.getResource(uri, true);

		@SuppressWarnings("unchecked")
		T base = (T) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PACKAGE);

		return base;
	}
}
