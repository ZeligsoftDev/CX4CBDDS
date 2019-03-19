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
package com.zeligsoft.domain.dds4ccm.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;

@SuppressWarnings("nls")
public final class DDS4CCMMigrationModelTypeUtil {
	
	/**
	 * This method serves two purposes: 
	 * a. Check if the migration is required
	 * b. If (a) is true and dryrun is false, do the migration
	 * 
	 * @param model
	 *          Model instance to be migrated
	 * @param dryrun
	 * 			A flag for determining if migration will be performed           
	 * @return true, if migration is required; false otherwise
	 *         
	 */

	private static boolean migrateAll(Model model, boolean dryrun) {
		boolean result = false;
		
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				model, "DDS4CCM::DDS4CCM::DDS4CCMModel", "modelType");
		if(!(rawValue instanceof EnumerationLiteral)){
			return result;
		}
		EnumerationLiteral modelType = (EnumerationLiteral) rawValue;
		
		if(modelType.getName().equals("ATCD")){
			result = true;
			if(!dryrun){
				migrateToAxciomaProperty(model);
				com.zeligsoft.base.zdl.util.ZDLUtil.setValue(
						model, "DDS4CCM::DDS4CCM::DDS4CCMModel", "modelType", ((Enumeration)modelType.eContainer()).getOwnedLiteral("AXCIOMA"));
			}			
		}
		
		return result;
	}
	
	/**
	 * Scan elements of an ATCD model and perform the migration to AXCIOMA  
	 * 
	 * @param model
	 *          Model instance to be scanned
	 *          
	 */

	private static void migrateToAxciomaProperty(Model model){
		
		if(!isDDS4CCMModel(model)){
			return;
		}
		
		for(Element e: model.allOwnedElements()){

			if(ZDLUtil.isZDLConcept(e, CCMNames.RESOURCE)){
				Resource resource = ZDLFactoryRegistry.INSTANCE.create(e, Resource.class);
				List<String> oldStrings = new ArrayList<String>(resource.getResourceType());
				// ZDLUtil is used for setting value due to the limitation of the api code
				ZDLUtil.setValue(e, CCMNames.REQUIREMENT_SATISFIER, CCMNames.REQUIREMENT_SATISFIER__RESOURCE_TYPE, null);				
				
				for(String s : oldStrings) {
					resource.addResourceType(getAxciomaStr(s));
				}
			}else if(ZDLUtil.isZDLConcept(e, CCMNames.PROPERTY)){
				com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property oldProperty =  ZDLFactoryRegistry.INSTANCE.create(e, com.zeligsoft.domain.omg.ccm.api.CCM_Target.Property.class);
				oldProperty.setName(getAxciomaStr(oldProperty.getName()));
			}else if(ZDLUtil.isZDLConcept(e, CCMNames.SATISFIER_PROPERTY)){
				SatisfierProperty oldSatisfierProperty =  ZDLFactoryRegistry.INSTANCE.create(e, SatisfierProperty.class);
				ZDLUtil.setValue(e, CCMNames.SATISFIER_PROPERTY, CCMNames.SATISFIER_PROPERTY__VALUE, getAxciomaStr((String)ZDLUtil.getValue(e, CCMNames.SATISFIER_PROPERTY, CCMNames.SATISFIER_PROPERTY__VALUE)));
				oldSatisfierProperty.setName(getAxciomaStr(oldSatisfierProperty.getName()));
			}
		}
	}
	
	/**
	 * Given an ATCD property name, return the corresponding property name in AXCIOMA 
	 * 
	 * @param atcdStr 
	 * 			String representing a property name in ATCD
	 * 
	 * @return String representing the corresponding property name in AXCIOMA
	 */
	
	private static String getAxciomaStr(String atcdStr){
		if(atcdStr == null){
			return atcdStr;
		}
		
		String axciomaStr = "";		
		PropertyVariable[] pr = PropertyVariable.values();		
		for(int i=0; i<pr.length; i++){
			if(pr[i].matches(atcdStr, ModelTypeDDS4CCM.ATCD.name())){
				axciomaStr = pr[i].getMigratedName();
				break;
			}
		}
		return axciomaStr.equals("")? atcdStr : axciomaStr;
	}
	
	/**
	 * Perform the model migration   
	 * 
	 * @param model
	 * 			model instance to be checked
	 * 
	 * @return true, if current modelType is ATCD; false, otherwise
	 *                    
	 */
	public static boolean migrateAll(Model model) {
		return migrateAll(model, false/*dryrun*/);
	}

	/**
	 * Check if migration is required for the given model. It is not required if the modelType is already AXCIOMA   
	 * 
	 * @param model
	 * 			model instance to be checked
	 * 
	 * @return true, if current modelType is ATCD; false, otherwise
	 *                    
	 */
	public static boolean isMigrationRequired(Model model) {
		return migrateAll(model, true/*dryrun*/);
	}	
	/**
	 * Check if the given model is a DDS4CCM model    
	 * 
	 * @param model
	 * 			model instance to be checked
	 * 
	 * @return true, if a DDS4CCM model; false, otherwise
	 *                    
	 */
	private static boolean isDDS4CCMModel(Model model){		
		if(!ZDLUtil.isZDLConcept(model, DDS4CCMNames.DDS4_CCMMODEL)){
			return false;
		}
		return true;
	}
}
