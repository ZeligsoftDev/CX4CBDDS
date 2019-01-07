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

/**
 * Super class that contains information about the domain parts (libraries, profiles, transformations, and analysis...)
 * 
 * @author sduchesneau
 *
 */
public class DomainSpecializationPart
{	
	public static final String TYPE_PROFILE = "profile";	 //$NON-NLS-1$
	public static final String TYPE_LIBRARY = "model-library"; //$NON-NLS-1$
	public static final String TYPE_ANALYSIS = "analysis"; //$NON-NLS-1$
	public static final String TYPE_TRANSFORMATION = "transformation"; //$NON-NLS-1$
	
	private String name;	
	private String type;
	
	
	public DomainSpecializationPart()
	{
		name = ""; //$NON-NLS-1$
		type = ""; //$NON-NLS-1$
	}
	
	/**
	 * Get the name of this domain part
	 * 
	 * @return String
	 * 				name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of this domain part
	 * 
	 * @param String
	 * 				name
	 */
	public void setName(String name)
	{
		if (name == null)
			this.name = ""; //$NON-NLS-1$
		else
			this.name = name;
	}

	
	/**
	 * Get the type of this domain part
	 * 
	 * @return String
	 * 				type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Set the type of this domain part
	 * 
	 * @param String
	 * 				type
	 */
	public void setType(String type)
	{
		if (type == null)
			type = ""; //$NON-NLS-1$
		else
			this.type = type;
	}
	
}
