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

package com.zeligsoft.ce.domainregistration;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

import com.ibm.xtools.modeler.ui.UMLModeler;
import com.zeligsoft.ce.domainregistration.l10n.Messages;

/**
 * Class used to register domain specializations
 * 
 * @author sduchesneau
 *
 */
public class DomainRegistry
{

	private static HashMap<String, DomainSpecialization> domainMap = null;

	public static final String EXT_POINT_NAME = "DomainRegistration";	 //$NON-NLS-1$
	
	public static final String TAG_NAME = "name"; //$NON-NLS-1$
	public static final String TAG_DESCRIPTION = "description";	 //$NON-NLS-1$
	public static final String TAG_ID = "id"; //$NON-NLS-1$

	private static HashMap<String, DomainSpecialization> getDomainMap()
	{
		if (domainMap == null)
		{
			domainMap = new HashMap<String, DomainSpecialization>();
		}
		return domainMap;
	}
	
	/**
	 * Get an ArrayList of all the domain specializations
	 * 
	 * @return ArrayList<DomainSpecialization>	
	 * 				the list of domain specialization
	 */
	public static ArrayList<DomainSpecialization> getDomainList()
	{
		ArrayList<DomainSpecialization> list = new ArrayList<DomainSpecialization>();		
		for (String key: getDomainMap().keySet())
		{
			list.add(getDomainMap().get(key));			
		}		
		return list;		
	}
	
	/**
	 * Get an array of all the domain specializations
	 * 
	 * @return Object[]	
	 * 				the array of domain specialization
	 */
	public static DomainSpecialization[] getDomainArray()
	{
		getDomainMap().size();
		DomainSpecialization[] list = new DomainSpecialization[getDomainMap().size()]; 
				
		int count=0;
		for (String key: getDomainMap().keySet())
		{			
			list[count] = getDomainMap().get(key);
			count++;
		}		
		return list;		
	}
	
	/**
	 * Adds a domain specialization to the registry, will not add it if is already in registry
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	private static void addToDomainMap(DomainSpecialization domainInfo)
	{	
		if (!getDomainMap().containsKey(domainInfo.getName()))
		{
			getDomainMap().put(domainInfo.getName(), domainInfo);
		}		
	}
	
	/**
	 * Get the domain specialization with a given name
	 * 
	 * @return DomainSpecialization
	 * 				the domain specialization
	 * @param String
	 *            the name of the domain specialization you are looking for
	 */
	public static DomainSpecialization getDomain(String name)
	{
		return getDomainMap().get(name);		
	}
	
	/**
	 * Looks for a specific domain part within an ArrayList of domain parts
	 * 
	 * @return boolean
	 * 				true if found
	 * @param DomainSpecializationPart
	 *            the block you are looking for
	 * @param ArrayList<DomainSpecializationPart>
	 * 				the list of domain parts to search
	 */
	public static boolean findInList(DomainSpecializationPart part, ArrayList<DomainSpecializationPart> list)
	{
		for (DomainSpecializationPart dbi: list)
		{
			if (dbi.getName().compareTo(part.getName()) == 0)
			{
				return true;				
			}			
		}
		
		return false;		
	}

	/**
	 * Load all domain specialization information from the extension point
	 * 
	 * @return boolean
	 * 				true if successful	
	 */
	public static boolean loadInfoFromExtensionPoint()
	{
		IExtensionRegistry  registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(Activator.PLUGIN_ID, EXT_POINT_NAME);
		IExtension[] extensions = extensionPoint.getExtensions(); 
		
		for (int i=0; i<extensions.length; i++)
		{
			DomainSpecialization domain = new DomainSpecialization();
			domain.setName(extensions[i].getLabel());
			domain.setContributor(extensions[i].getContributor().getName());
			
			IConfigurationElement[] configElements = extensions[i].getConfigurationElements();			

			                 
			for (int j=0; j<configElements.length; j++)
			{				
				String partType = configElements[j].getName();

				if (partType.compareTo(TAG_DESCRIPTION) == 0) {

					domain.setDescription(configElements[j]
						.getAttribute(TAG_DESCRIPTION));

				} else {
					DomainSpecializationPart part = null;
					
					if (partType.compareTo(DomainSpecializationPart.TYPE_LIBRARY) == 0)
					{
						part = new DSLibrary();
					}
					else if (partType.compareTo(DomainSpecializationPart.TYPE_PROFILE) == 0)
					{
						part = new DSProfile();
					}
					else if (partType.compareTo(DomainSpecializationPart.TYPE_TRANSFORMATION) == 0)
					{
						part = new DSTransformation();
					}
					else if (partType.compareTo(DomainSpecializationPart.TYPE_ANALYSIS) == 0)
					{
						part = new DSAnalysis();
					}else{
						//this part type not recognized so ignore
						continue;
					}
							
					part.setName(configElements[j].getAttribute(TAG_NAME));
					part.setType(partType);					
					
					domain.addPart(part);					
				}
			}
			addToDomainMap(domain);			
		}           
		return true;
	}	

	/**
	 * Debug function that displays all the domain specialization in XML format in log file
	 * 
	 * @return boolean
	 * 				true if successful
	 */
	public static boolean displayToLog()
	{
		ILog logObj = Activator.getDefault().getLog();

		for (DomainSpecialization domain: getDomainList())
		{
			String logMsg = NLS.bind(Messages.DomainRegistry_DomainLogMessage, domain.getName());
			
			for (DomainSpecializationPart part: domain.getPartList())
			{
				logMsg += NLS.bind(Messages.DomainRegistry_PartLogMessage, part.getName());				 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			logMsg += " " + Messages.DomainRegistry_DomainLogEndMessage; //$NON-NLS-1$
			
			Status s = new Status(IStatus.OK, Activator.PLUGIN_ID, 0, logMsg, null);
			logObj.log(s);
		}
		return true;
	}
	
	/**
	 * Applies profiles to a model
	 * 
	 * @param DSProfile[]
	 *            an array of the profiles to be applied
	 * @param Model
	 * 				the model to which the profiles will be applied
	 */
	public static BasicDiagnostic applyProfiles(DSProfile[] profiles, Model model)
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint xpt = registry.getExtensionPoint("com.ibm.xtools.uml.msl.UMLProfiles");//$NON-NLS-1$		
		IExtension[] profileExtensions = xpt.getExtensions();
		ArrayList<IExtension> selectedProfileExtensions = new ArrayList<IExtension>();
		
		BasicDiagnostic diagnostic = new BasicDiagnostic(Activator.PLUGIN_ID, IStatus.ERROR, Messages.DomainRegistry_UMLProfileError, null); 
		
		for (DomainSpecializationPart lib: profiles)
		{
			boolean found = false;
			for (IExtension ext: profileExtensions)
			{
				if (lib.getName().compareTo(ext.getLabel()) == 0)
				{
					selectedProfileExtensions.add(ext);
					found = true;
					break;
				}				
			}
			
			if (found == false)
			{
				ILog logObj = Activator.getDefault().getLog();
				String logMsg = NLS.bind(Messages.DomainRegistry_UMLProfileErrorMessage, lib.getName());
				Status s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, logMsg, null);
				logObj.log(s);		
				diagnostic.add(BasicDiagnostic.toDiagnostic(s));			
			}
		}		
		
		for (IExtension extension: selectedProfileExtensions)
		{
			Profile profile = null;
			try
			{
				
				IConfigurationElement[] ce = extension.getConfigurationElements();

				// load the profile
				URI uri = URI.createURI(ce[0].getAttribute("path"));//$NON-NLS-1$
				Resource resource = UMLModeler.getEditingDomain().getResourceSet().getResource(uri,	true);
				profile = (org.eclipse.uml2.uml.Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
				
				// apply the profile						
				model.applyProfile(profile);
				
			}
			catch (Exception ex)
			{	
				ILog logObj = Activator.getDefault().getLog();
				String logMsg = NLS.bind(Messages.DomainRegistry_UMLProfileLoadErrorMessage, extension.getLabel());
				Status s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, logMsg, ex);
				logObj.log(s);				
				diagnostic.add(BasicDiagnostic.toDiagnostic(s));			
			}			
		}
		return diagnostic;
	}
	
	/**
	 * Imports the model libraries into the model
	 * 
	 * @param DSLibrary[]
	 *            an array of the libraries to be imported
	 * @param Model
	 * 				the model to which the libraries will be imported
	 */		
	public static BasicDiagnostic importModelLibraries(DSLibrary[] libraries, Model model)
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint xpt = registry.getExtensionPoint("com.ibm.xtools.uml.msl.UMLLibraries");//$NON-NLS-1$		
		IExtension[] libraryExtensions = xpt.getExtensions();
		ArrayList<IExtension> selectedLibraryExtensions = new ArrayList<IExtension>();		

		BasicDiagnostic diagnostic = new BasicDiagnostic(Activator.PLUGIN_ID, IStatus.ERROR, Messages.DomainRegistry_UMLLibraryError, null); 
		
		for (DomainSpecializationPart lib: libraries)
		{
			boolean found = false;
			for (IExtension ext: libraryExtensions)
			{
				if (lib.getName().compareTo(ext.getLabel()) == 0)
				{
					selectedLibraryExtensions.add(ext);
					found = true;
					break;
				}				
			}
			
			if (found == false)
			{
				ILog logObj = Activator.getDefault().getLog();
				String logMsg = NLS.bind(Messages.DomainRegistry_UMLLibraryErrorMessage, lib.getName());
				Status s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, logMsg, null);
				logObj.log(s);
				diagnostic.add(BasicDiagnostic.toDiagnostic(s));			
			}
		}		
		
		for (IExtension extension : selectedLibraryExtensions)
		{
			try
			{
				IConfigurationElement[] ce = extension.getConfigurationElements();

				URI uri = URI.createURI(ce[0].getAttribute("path"));//$NON-NLS-1$
				Resource resource = UMLModeler.getEditingDomain().getResourceSet().getResource(uri,	true);
				Model modelLib = (Model) resource.getContents().get(0);
				org.eclipse.uml2.uml.Package package_ = model.createNestedPackage(modelLib.getName());
				package_.createPackageImport(modelLib);
						
				EList<Type> ownedTypes = modelLib.getOwnedTypes();
						
				for (Type type : ownedTypes) 
				{
					package_.createElementImport(type);
				}
			}
			catch (Exception ex)
			{
				ILog logObj = Activator.getDefault().getLog();
				String logMsg = NLS.bind(Messages.DomainRegistry_UMLLibraryLoadErrorMessage, extension.getLabel());
				Status s = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, logMsg, ex);
				logObj.log(s);		
				diagnostic.add(BasicDiagnostic.toDiagnostic(s));				
			}
		}	
		return diagnostic;
	}
	
	private static ArrayList<DomainSpecializationPart> getParts(String type, DomainSpecialization[] domains)
	{
		ArrayList<DomainSpecializationPart> partList = new ArrayList<DomainSpecializationPart>();
		
		for (DomainSpecialization domain : domains)
		{
			for (DomainSpecializationPart part : domain.getPartList())
			{										
				if (part.getType().compareTo(type) == 0)
				{
					if (!DomainRegistry.findInList(part, partList))						
						partList.add(part);																															
				}				
			}
		}
		return partList;
	}
	
	/**
	 * Gets all the libraries within an array of domains
	 * 
	 * @return DSLibrary[]
	 * 				the array of libraries found in the domains
	 * @param DomainSpecialization
	 *            the array of domains to search
	 */
	public static DSLibrary[] getLibraries(DomainSpecialization[] domains)
	{
		ArrayList<DomainSpecializationPart> partList = getParts(DomainSpecializationPart.TYPE_LIBRARY, domains);
		
		DSLibrary[] libArray = new DSLibrary[partList.size()];
		for (int i=0; i<partList.size(); i++)
		{
			libArray[i] = (DSLibrary) partList.get(i);		
		}
		return libArray;	
	}
	
	/**
	 * Gets all the profiles within an array of domains
	 * 
	 * @return DSProfile[]
	 * 				the array of profiles found in the domains
	 * @param DomainSpecialization
	 *            the array of domains to search
	 */
	public static DSProfile[] getProfiles(DomainSpecialization[] domains)
	{
		ArrayList<DomainSpecializationPart> partList = getParts(DomainSpecializationPart.TYPE_PROFILE, domains);
		
		DSProfile[] profileArray = new DSProfile[partList.size()];
		for (int i=0; i<partList.size(); i++)
		{
			profileArray[i] = (DSProfile) partList.get(i);		
		}
		return profileArray;	
	}	
	
}

