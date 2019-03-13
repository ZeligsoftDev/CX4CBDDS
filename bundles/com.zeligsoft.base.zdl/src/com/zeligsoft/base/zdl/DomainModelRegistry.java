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
package com.zeligsoft.base.zdl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;


/**
 * <p>
 * A registry of ZDL models, mapping namespace URIs to ZDL instances and their
 * associated generator models (where available).
 * </p><p>
 * <b>Note</b> that this interface is not intended to be implemented by clients.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public interface DomainModelRegistry {
	/**
	 * The shared instance of the registry.
	 */
	DomainModelRegistry INSTANCE = new DomainModelRegistryImpl();
	
	/**
	 * Fetches the ZDL model identified by the specified namespace URI, in the
	 * given resource set context.
	 * 
	 * @param nsURI the registered namespace URI of a ZDL model
	 * @param rset a resource set in which to load the ZDL model
	 * 
	 * @return the ZDL model
	 */
	Model getModel(URI nsURI, ResourceSet rset);
	
	/**
	 * Registers a ZDL model under a specified namespace URI.
	 * 
	 * @param zdlModel the ZDL model to register
	 * @param nsURI its namespace URI
	 * 
	 * @throws IllegalArgumentException if the model is not in a resource or
	 *     if the namespace URI is <code>null</code>
	 */
	void registerModel(Model zdlModel, URI nsURI);
	
	/**
	 * Removes the mapping of the specified namespace URI.
	 * 
	 * @param nsURI the namespace URI to remove
	 */
	void unregisterModel(URI nsURI);
	
	/**
	 * Obtains the namespace URI, if any, of a domain model.
	 * 
	 * @param zdlModel a domain model
	 * @return its namespace URI, or <code>null</code> if it is not registered
	 */
	URI getNamespaceURI(Model zdlModel);
}
