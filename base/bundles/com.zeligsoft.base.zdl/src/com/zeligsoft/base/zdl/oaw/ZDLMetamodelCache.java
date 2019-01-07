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
package com.zeligsoft.base.zdl.oaw;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.util.ZeligsoftURIConverter;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * A cache of the ZDLMetamodels that are used in transformations
 * this ensures that all transformations use the same metamodels.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public class ZDLMetamodelCache {
	public static final ZDLMetamodelCache INSTANCE = new ZDLMetamodelCache();
	
	private ResourceSet zdlResources = new ResourceSetImpl();
	
	private ZDLMetamodelCache() {
		super();
		
		ZeligsoftURIConverter.install(zdlResources);
		
		
	}

	public Model getZDLModel(URI uri) {
		Model result = null;
		
		Resource res = zdlResources.getResource(uri, true);
		
		if((res != null) && res.isLoaded()) {
			Model model = (Model) EcoreUtil.getObjectByType(res.getContents(),
					UMLPackage.Literals.MODEL);
			if(model != null &&
				ZDLUtil.isZDLConcept(model, ZDLNames.DOMAIN_MODEL)) {
					result = model;
			} else {
				res.unload();
				zdlResources.getResources().remove(res);
				result = null;
			}
		}
		
		return result;
	}
}
