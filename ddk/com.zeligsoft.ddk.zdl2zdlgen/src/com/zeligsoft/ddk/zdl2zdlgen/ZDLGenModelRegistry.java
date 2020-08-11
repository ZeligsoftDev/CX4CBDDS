/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl2zdlgen;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;


/**
 * A registry of ZDLGen models, mapping namespace URIs to generator models
 * (where available).
 *
 * @author Christian W. Damus (cdamus)
 */
public interface ZDLGenModelRegistry {
	/**
	 * The shared instance of the registry.
	 */
	ZDLGenModelRegistry INSTANCE = new ZDLGenModelRegistryImpl();
	
	/**
	 * Fetches the ZDLGen model identified by the specified namespace URI, in the
	 * given resource set context.
	 * 
	 * @param nsURI the registered namespace URI of a ZDLGen model
	 * @param rset a resource set in which to load the ZDLGen model
	 * 
	 * @return the ZDL model
	 */
	GenModel getGenModel(URI nsURI, ResourceSet rset);
	
	/**
	 * Registers a ZDGenL model under a specified namespace URI.
	 * 
	 * @param zdlGenModel the ZDLGen model to register
	 * @param nsURI its namespace URI
	 * 
	 * @throws IllegalArgumentException if the model is not in a resource or
	 *     if the namespace URI is <code>null</code>
	 */
	void registerModel(GenModel zdlGenModel, URI nsURI);
	
	/**
	 * Removes the mapping of the specified namespace URI.
	 * 
	 * @param nsURI the namespace URI to remove
	 */
	void unregisterModel(URI nsURI);
}
