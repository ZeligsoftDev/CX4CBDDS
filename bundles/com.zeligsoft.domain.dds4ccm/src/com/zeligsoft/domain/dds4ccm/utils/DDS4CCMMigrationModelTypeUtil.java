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
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.dds4ccm.Activator;
import com.zeligsoft.domain.dds4ccm.ConnectorType;
import com.zeligsoft.domain.dds4ccm.DDS4CCMNames;
import com.zeligsoft.domain.dds4ccm.DDS4CCMPreferenceConstants;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;
import com.zeligsoft.domain.idl3plus.IDL3PlusNames;
import com.zeligsoft.domain.idl3plus.api.Connectors.ConnectorDef;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.omg.ccm.CCMNames;
import com.zeligsoft.domain.omg.ccm.api.CCM_Component.InterfacePort;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.Resource;
import com.zeligsoft.domain.omg.ccm.api.CCM_Target.SatisfierProperty;
import com.zeligsoft.domain.omg.corba.CORBADomainNames;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAInterface;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

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
		
		DDS4CCMModel contextModel =  ZDLFactoryRegistry.INSTANCE.create(model, DDS4CCMModel.class);
		ModelTypeEnum modelType = contextModel.getModelType();
		
		if(modelType.equals(ModelTypeEnum.ATCD)){
			result = true;
			if(!dryrun){
				migrateToAxcioma(model);
				contextModel.setModelType(ModelTypeEnum.AXCIOMA);
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
	private static void migrateToAxcioma(Model model){
		
		if(!isDDS4CCMModel(model)){
			return;
		}
		IEclipsePreferences store =	InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		
		String defaultConnectorTypeAsyncUses = store.get(DDS4CCMPreferenceConstants.ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, DDS4CCMPreferenceConstants.DEFAULT_ASYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION);
		String defaultConnectorTypeSyncUses = store.get(DDS4CCMPreferenceConstants.SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION, DDS4CCMPreferenceConstants.DEFAULT_SYNC_CONNECTOR_TYPE_AXCIOMA_MIGRATION);
		
		String defaultConnectorTypeAsyncProvides = getDefaultConnectorTypeProvides(defaultConnectorTypeAsyncUses);
		String defaultConnectorTypeSyncProvides = getDefaultConnectorTypeProvides(defaultConnectorTypeSyncUses);
		
		ConnectorDef connectorDefAsyncUses = getDefaultConnectorDef(defaultConnectorTypeAsyncUses, model);
		ConnectorDef connectorDefSyncUses = getDefaultConnectorDef(defaultConnectorTypeSyncUses, model);
		
		ConnectorDef connectorDefAsyncProvides = getDefaultConnectorDef(defaultConnectorTypeAsyncProvides, model);
		ConnectorDef connectorDefSyncProvides = getDefaultConnectorDef(defaultConnectorTypeSyncProvides, model);
		
		for(Element e: model.allOwnedElements()){

			migrateToAxciomaProperty(e);
			
			// load default port connectorTypes
			if(ZDLUtil.isZDLConcept(e, CCMNames.INTERFACE_PORT)){
				InterfacePort ip = ZDLFactoryRegistry.INSTANCE.create(e, InterfacePort.class);
				
				if(!ZDLUtil.isZDLConcept(ip.getPorttype().eObject(), CORBADomainNames.CORBAINTERFACE)){
					continue;
				}
				
				CORBAInterface portType = ZDLFactoryRegistry.INSTANCE.create(ip.getPorttype().eObject(), CORBAInterface.class);
				
				boolean isPortTypeLocal = portType.getIsLocal();
				
				boolean isNonLocalAsyncUsesPort = (!isPortTypeLocal && ip.getIsAsynchronous()) && ip.getIsConjugated();
				boolean isNonLocalAsyncProvidesPort = (!isPortTypeLocal && ip.getIsAsynchronous()) && !ip.getIsConjugated();
				
				boolean isNonLocalSyncUsesPort = (!isPortTypeLocal && !ip.getIsAsynchronous()) && ip.getIsConjugated();
				boolean isNonLocalSyncProvidesPort = (!isPortTypeLocal && !ip.getIsAsynchronous()) && !ip.getIsConjugated();
				
				if(isNonLocalAsyncUsesPort){
					ip.setConnectorType(connectorDefAsyncUses);
				}else if(isNonLocalAsyncProvidesPort){
					ip.setConnectorType(connectorDefAsyncProvides);
				}else if(isNonLocalSyncUsesPort){
					ip.setConnectorType(connectorDefSyncUses);
				}else if(isNonLocalSyncProvidesPort){
					ip.setConnectorType(connectorDefSyncProvides);
				}
			}
		}
	}
	
	/**
	 * Given a connectorType for 'uses' port, returns corresponding connectorType for 'provides' port    
	 * 
	 * @param defaultConnectorTypeUses
	 *         	default connectorType set in preferences. To be used in the 'uses' port during migration  
	 *          
	 */
	private static String getDefaultConnectorTypeProvides(String defaultConnectorTypeUses){
		if(defaultConnectorTypeUses.equals(ConnectorType.AMI4CCM_Connector.name())){
			return ConnectorType.CORBA4CCM_Connector.name();
		}else if(defaultConnectorTypeUses.equals(ConnectorType.CORBA4CCM_Connector.name())){
			return ConnectorType.CORBA4CCM_Connector.name();
		}else{
			return "";
		}
	}
	
	/**
	 * Migrate property of a model element from ATCD to AXCIOMA  
	 * 
	 * @param e
	 *         Element instance to be migrated 
	 *          
	 */	
	private static void migrateToAxciomaProperty(Element e){
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
	private static ConnectorDef getDefaultConnectorDef(String defaultConnectorType, Model model){
		
		String pathmapConnectorLib = getPathmapConnectorLib(defaultConnectorType);
		URI uriConnectorLib = URI.createURI(pathmapConnectorLib);
		Package packageConnectorLib = getImportedConnectorPackage(model, uriConnectorLib);
		ConnectorDef connectorDef = getConnectorDef(packageConnectorLib);
		
		return connectorDef;
	}
	
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
	 * Import a package represented by the input 'packageUri' in the input 'model' and return it. 
	 * If the package is already imported, return the imported package.  
	 * 
	 * @param model
	 *          model object where the package should be imported
	 * @param packageUri
	 * 			URI of the package object that is being imported          
	 *            
	 * @return the imported package object  
	 *         
	 */
	private static Package getImportedConnectorPackage(Model model, URI packageUri){
		
		Package importedConnectorPackage = null;
		boolean isAlreadyImported = false;
	
		List<PackageImport> listPackageImport = model.getPackageImports();
		
		for(PackageImport pi: listPackageImport){
			
			if(pi.getImportedPackage().eResource().getURI().equals(packageUri)){
				isAlreadyImported = true;
				importedConnectorPackage = pi.getImportedPackage();
				break;
			}
		}
		
		if(!isAlreadyImported){
			org.eclipse.emf.ecore.resource.Resource connectorPackageResource = model.eResource().getResourceSet().createResource(packageUri);			
			
			try {
				connectorPackageResource.load(null);
				importedConnectorPackage = (Package) connectorPackageResource.getContents().get(0);
				importPackage(model, importedConnectorPackage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}		
		return importedConnectorPackage;		
	}
	
	private static void importPackage(final Model model, final Package packageObj){
		
		org.eclipse.emf.ecore.resource.Resource modelResource = model.eResource();
		final Package root = (Package) modelResource.getContents().get(0);
				
		TransactionalEditingDomain domain =	TransactionUtil.getEditingDomain(model);	
		
		Command importCommand = new RecordingCommand(domain, "import connector library"){
			@Override
			protected void doExecute(){
				
				root.createPackageImport(packageObj);
			}
		};
		
		try {
			((TransactionalCommandStack)domain.getCommandStack()).execute(importCommand, null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
		
		CORBAModule cm = null;
		
		for(Package nestedPackage: connectorLibPackage.getNestedPackages()){
			if(ZDLUtil.isZDLConcept(nestedPackage, CORBADomainNames.CORBAMODULE)){
				cm = ZDLFactoryRegistry.INSTANCE.create(nestedPackage, CORBAModule.class);
				break;
			}
		}
		
		if(cm == null){
			return cd;			
		}	
		
		TemplateModule tm = null;
		
		for(CORBAModuleContained cmContained: cm.getContents()){
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
				
		for(PropertyVariable pr: PropertyVariable.values()){			
			if(pr.matches(atcdStr, ModelTypeDDS4CCM.ATCD.name())){
				axciomaStr = pr.getMigratedName();
				break;
			}
		}
		return axciomaStr.isEmpty()? atcdStr : axciomaStr;
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
