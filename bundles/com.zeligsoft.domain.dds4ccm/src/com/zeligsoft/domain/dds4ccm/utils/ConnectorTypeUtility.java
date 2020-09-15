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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.ConnectorType;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.omg.corba.CXDomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModule;
import com.zeligsoft.domain.omg.corba.api.IDL.CXModuleContained;

public class ConnectorTypeUtility {	
	
	/**
	 * Retrieves pathmap of a connector library
	 * 
	 * @param preferredConnectorType
	 *          Preferred value of 'ConnectorType' to be used during migration 
	 *            
	 * @return pathmap of a connector library which corresponds to the input connectorType value  
	 *         
	 */
	
	private static String getPathmapConnectorLib(String preferredConnectorType){
		
		String pathmapConnectorLib = "";
		
		String pathmapAMIConnector = "pathmap://DDS4CCM_AMI_LIBRARIES/CCM_AMI.uml";
		String pathmapCORBAConnector = "pathmap://DDS4CCM_CORBA_LIBRARIES/CCM_CORBA.uml";
		
		if(preferredConnectorType.equals(ConnectorType.AMI4CCM_Connector.name())){
			pathmapConnectorLib = pathmapAMIConnector; 
		}else if(preferredConnectorType.equals(ConnectorType.CORBA4CCM_Connector.name())){
			pathmapConnectorLib = pathmapCORBAConnector;
		}
		
		return pathmapConnectorLib;
	}

	/**
	 * Given a connector library package, retrieve the contained 'ConnectorDef' object  
	 * 
	 * @param connectorLibPackage
	 *          a package object representing a connector library
	 *            
	 * @return the associated 'ConnectorDef' object  
	 *         
	 */	
	private static ConnectorDef getConnectorDef(Package connectorLibPackage){
		// Argument to this method should be an imported connector library package
		
		ConnectorDef cd = null;
		
		CXModule cm = null;
		
		for(Package nestedPackage: connectorLibPackage.getNestedPackages()){
			if(ZDLUtil.isZDLConcept(nestedPackage, CXDomainNames.CXMODULE)){
				cm = ZDLFactoryRegistry.INSTANCE.create(nestedPackage, CXModule.class);
				break;
			}
		}
		
		if(cm == null){
			return cd;			
		}	
		
		TemplateModule tm = null;
		
		for(CXModuleContained cmContained: cm.getContents()){
			if(ZDLUtil.isZDLConcept(cmContained.eObject(), IDL3PlusNames.TEMPLATE_MODULE)){
				tm = ZDLFactoryRegistry.INSTANCE.create(cmContained.eObject(), TemplateModule.class);
				break;
			}
		}
		if(tm == null){
			return cd;
		}
		
		for(Element e: tm.asPackage().getOwnedElements()){
			if(ZDLUtil.isZDLConcept(e, IDL3PlusNames.CONNECTOR_DEF)){
				cd = ZDLFactoryRegistry.INSTANCE.create(e, ConnectorDef.class);
				break;
			}
		}
		return cd;
	}

	/**
	 * Given a connectorType for 'uses' port, returns corresponding connectorType for 'provides' port.     
	 * 
	 * @param defaultConnectorTypeUses
	 *         	default connectorType set in preferences. To be used in the 'uses' port during migration  
	 *          
	 */
	public static String getDefaultConnectorTypeProvides(String defaultConnectorTypeUses){
		if(defaultConnectorTypeUses.equals(ConnectorType.AMI4CCM_Connector.name())){
			return ConnectorType.CORBA4CCM_Connector.name();
		}else if(defaultConnectorTypeUses.equals(ConnectorType.CORBA4CCM_Connector.name())){
			return ConnectorType.CORBA4CCM_Connector.name();
		}else{
			return "";
		}
	}

	/**
	 * Import a package represented by the input 'packageUri' in the input 'model' and return it. 
	 * If the package is already imported, return the imported package.  
	 * 
	 * @param model
	 *          model object where the package should be imported
	 * @param packageUri
	 * 			URI of the package object that is being imported          
	 *            
	 * @return the imported package object  
	 * @throws IOException 
	 *         
	 */
	public static Package getImportedPackage(Model model, URI packageUri) throws IOException {

		Package importedPackage = null;
		boolean isAlreadyImported = false;

		ResourceSet rset = model.eResource().getResourceSet();
		for (Resource r : rset.getResources()) {
			if (rset.getURIConverter().normalize(packageUri).equals(rset.getURIConverter().normalize(r.getURI()))) {
				isAlreadyImported = true;
				importedPackage = (Package) r.getContents().get(0);
				break;
			}
		}

		if (!isAlreadyImported) {
			importedPackage = UML2Util.load(rset, packageUri, UMLPackage.Literals.PACKAGE);
		}

		return importedPackage;
	}

	/**
	 * Retrieves 'ConnectorDef' object for the default value of connectorType set in the preference page
	 * 
	 * @param defaultConnectorType
	 *          Preferred value of 'ConnectorType' for a sync/async port for being used during migration 
	 * @param model
	 * 			an atcd model that is being migrated           
	 * @return a 'ConnectorDef' object that corresponds to the default value of the 'ConnectorType' 
	 *         
	 */  
	public static ConnectorDef getDefaultConnectorDef(String defaultConnectorType, Model model){
		
		String pathmapConnectorLib = getPathmapConnectorLib(defaultConnectorType);
		URI uriConnectorLib = URI.createURI(pathmapConnectorLib);
		
		Package packageConnectorLib = null;
		try {
			packageConnectorLib = getImportedPackage(model, uriConnectorLib);
		} catch (IOException e) {
			Activator.getDefault().error("Importing connector library failed for pathmap: "+pathmapConnectorLib, e);
		}
		ConnectorDef connectorDef = getConnectorDef(packageConnectorLib);
		
		return connectorDef;
	}

}
