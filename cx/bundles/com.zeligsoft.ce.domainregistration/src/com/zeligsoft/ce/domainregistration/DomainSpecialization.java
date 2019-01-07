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

/**
 * Class that contains information about domain specializations
 * 
 * @author sduchesneau
 *
 */
public class DomainSpecialization
{
	private String id;
	private String name;
	private String contributor;
	private String description;
	private boolean listOutdated;
	
	private ArrayList<DomainSpecializationPart> partList;	
	private HashMap<String, DomainSpecializationPart> partMap; 
	
	public DomainSpecialization()
	{
		partMap = new HashMap<String, DomainSpecializationPart>();
		listOutdated = true;
	}

	/**
	 * Get the id of this domain specialization
	 * 
	 * @return String
	 * 				id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Set the id of this domain specialization
	 * 
	 * @param String
	 * 				id
	 */
	public void setId(String id)
	{
		if (id == null)
			id = ""; //$NON-NLS-1$
		else
			this.id = id;
	}

	/**
	 * Get the name of this domain specialization
	 * 
	 * @return String
	 * 				name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set the name of this domain specialization
	 * 
	 * @param String
	 * 				name
	 */
	public void setName(String name)
	{
		if (name == null)
			name = ""; //$NON-NLS-1$
		else
			this.name = name;
	}
	
	/**
	 * Adds a domain part to this domain specialization, will not add it if is already in domain specialization
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	public void addPart(DomainSpecializationPart part)
	{
		listOutdated = true;
		
		if (!partMap.containsKey(part.getName()))
		{				
			partMap.put(part.getName(), part);
		}
	}
	
	/**
	 * get a domain part 
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	public DSAnalysis getAnalysis(String name)
	{
		DomainSpecializationPart part = partMap.get(name);
		if (part instanceof DSAnalysis)
			return (DSAnalysis) part;
		else
			return null;
	}

	/**
	 * get a domain part 
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	public DSTransformation getTranformation(String name)
	{
		DomainSpecializationPart part = partMap.get(name);
		if (part instanceof DSTransformation)
			return (DSTransformation) part;
		else
			return null;
	}
	
	/**
	 * get a domain part 
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	public DSProfile getProfile(String name)
	{
		DomainSpecializationPart part = partMap.get(name);
		if (part instanceof DSProfile)
			return (DSProfile) part;
		else
			return null;
	}
	
	/**
	 * get a domain library 
	 * 
	 * @param DomainSpecialization
	 *            the domain specialization
	 */
	public DSLibrary getLibrary(String name)
	{
		DomainSpecializationPart part = partMap.get(name);
		if (part instanceof DSLibrary)
			return (DSLibrary) part;
		else
			return null;
	}
	
	/**
	 * Get an array list of all the parts in this domain specialization
	 * 
	 * @return ArrayList<DomainSpecializationPart>
	 * 				list of parts
	 */
	public ArrayList<DomainSpecializationPart> getPartList()
	{
		if (listOutdated == true)
		{
			partList = new ArrayList<DomainSpecializationPart>();
			for (String key: partMap.keySet())
			{
				partList.add(partMap.get(key));			
			}
			listOutdated = false;
		}
		return partList;		
	}
	
	/**
	 * Get an array of all the libraries in this domain specialization
	 * 
	 * @return DSLibrary[]
	 * 				array of libraries
	 */
	public DSLibrary[] getLibraries()
	{
		ArrayList<DSLibrary> libList = new ArrayList<DSLibrary>();
		
		for (DomainSpecializationPart part: getPartList())
		{
			if (part instanceof DSLibrary)
			{
				libList.add((DSLibrary)part);
			}		
		}
		
		DSLibrary[] libArray = new DSLibrary[libList.size()];
		for (int i=0; i<libList.size(); i++)
		{
			libArray[i] = libList.get(i);			
		}
		return libArray;		
	}
	
	/**
	 * Get an array of all the profile in this domain specialization
	 * 
	 * @return DSProfile
	 * 				array of profiles
	 */
	public DSProfile[] getProfiles()
	{
		ArrayList<DSProfile> profileList = new ArrayList<DSProfile>();
		
		for (DomainSpecializationPart part: getPartList())
		{
			if (part instanceof DSProfile)
			{
				profileList.add((DSProfile)part);
			}		
		}
		
		DSProfile[] profileArray = new DSProfile[profileList.size()];
		for (int i=0; i<profileList.size(); i++)
		{
			profileArray[i] = profileList.get(i);			
		}
		return profileArray;
	}

	/**
	 * Get the contributor of this domain specialization
	 * 
	 * @return String
	 * 				contributor
	 */
	public String getContributor()
	{
		return contributor;
	}

	/**
	 * Get the contributor of this domain specialization
	 * 
	 * @return String
	 * 				description
	 */
	public String getDescription()
	{
		return description;
	}	
	
	/**
	 * Set the contributor of this domain specialization
	 * 
	 * @param String
	 * 				contributor
	 */
	public void setContributor(String contributor)
	{
		if (contributor == null)
			contributor = ""; //$NON-NLS-1$
		else
			this.contributor = contributor;
	}
	
	/**
	 * Set the contributor of this domain specialization
	 * 
	 * @param String
	 * 				description
	 */
	public void setDescription(String description)
	{
		if (description == null)
			description = ""; //$NON-NLS-1$
		else
			this.description = description;
	}
	
}
