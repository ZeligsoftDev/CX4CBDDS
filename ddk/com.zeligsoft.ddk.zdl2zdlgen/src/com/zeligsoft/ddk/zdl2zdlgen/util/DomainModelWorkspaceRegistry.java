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
package com.zeligsoft.ddk.zdl2zdlgen.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Model;

import com.zeligsoft.base.zdl.DomainModelRegistry;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public final class DomainModelWorkspaceRegistry {
	
	/**
	 * The shared instance of the registry.
	 */
	public static final DomainModelWorkspaceRegistry INSTANCE =
		new DomainModelWorkspaceRegistry();
	
	private ZDLGenModelWorkspaceReader reader;
	
	/**
	 * Construct me.
	 */
	private DomainModelWorkspaceRegistry() {
		reader = new ZDLGenModelWorkspaceReader();
	}
	
	/**
	 * Fetches the ZDL model identified by the specified namespace URI, in the
	 * given resource set context.
	 * 
	 * @param nsURI the registered namespace URI of a ZDL model
	 * @param rset a resource set in which to load the ZDL model
	 * @return the ZDL model
	 */
	public Model getModel(URI nsURI, ResourceSet rset) {
		Model result = null;
		
		result = DomainModelRegistry.INSTANCE.getModel(nsURI, rset);
		
		if (null == result) {
			String model = reader.getDomainModel(nsURI.toString());
			if (model != null && !model.isEmpty()) {
				URI modelURI = URI.createURI(model);
				if (modelURI != null) {
					Resource res = rset.getResource(modelURI, true);
					EObject firstElement = res.getContents().get(0);

					if (firstElement instanceof Model) {
						result = (Model) firstElement;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Obtains the namespace URI, if any, of a domain model.
	 * 
	 * @param zdlModel a domain model
	 * @return its namespace URI, or <code>null</code> if it is not registered
	 */
	public URI getNamespaceURI(Model zdlModel) {
		URI result = null;
		
		result = DomainModelRegistry.INSTANCE.getNamespaceURI(zdlModel);
		
		if(null == result) {
			URI domainModelURI = getModelURI(zdlModel);
			
			String nsURI = reader.getNsURIFromDomainModel(domainModelURI);
			if(!UML2Util.isEmpty(nsURI)) {
				result = URI.createURI(nsURI);
			}
		}
		return result;
	}
	
	private static URI getModelURI(Model zdlModel) {
		URI result = null;
		
		Resource resource = zdlModel.eResource();
		if (resource != null) {
			URI locationURI = EcoreUtil.getURI(zdlModel).trimFragment();

			URIConverter converter;
			if (resource.getResourceSet() != null) {
				converter = resource.getResourceSet().getURIConverter();
			} else {
				converter = new ExtensibleURIConverterImpl();
			}

			// use normalize URIs to ensure a canonical comparison
			locationURI = converter.normalize(locationURI);

			result = locationURI;
		}
		return result;
	}
}
