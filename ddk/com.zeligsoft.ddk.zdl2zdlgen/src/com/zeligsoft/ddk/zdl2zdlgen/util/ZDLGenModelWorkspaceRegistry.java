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

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;

/**
 * @author Toby McClean (tmcclean)
 *
 */
public final class ZDLGenModelWorkspaceRegistry {
	
	/**
	 * The shared instance of the registry.
	 */
	public static final ZDLGenModelWorkspaceRegistry INSTANCE =
		new ZDLGenModelWorkspaceRegistry();
	
	private ZDLGenModelWorkspaceReader reader;
	
	/**
	 * Construct me
	 */
	private ZDLGenModelWorkspaceRegistry() {
		reader =
			new ZDLGenModelWorkspaceReader();
	}
	
	/**
	 * Fetches the ZDLGen model identified by the specified namespace URI, in the
	 * given resource set context.
	 * 
	 * @param nsURI the registered namespace URI of a ZDLGen model
	 * @param rset a resource set in which to load the ZDLGen model
	 * 
	 * @return the ZDL model
	 */
	public GenModel getGenModel(URI nsURI, ResourceSet rset) {
		GenModel result = null;
		
		String genModel = reader.getGenModel(nsURI.toString());
		
		if(genModel != null && !genModel.isEmpty()) {
			URI genModelURI = URI.createURI(genModel);
			if(genModelURI != null) {
				Resource res =rset.getResource(genModelURI, true);
				EObject firstElement = res.getContents().get(0);
				
				if(firstElement instanceof GenModel) {
					result = (GenModel) firstElement;
				}
			}
		}
		
		return result;
	}
}
