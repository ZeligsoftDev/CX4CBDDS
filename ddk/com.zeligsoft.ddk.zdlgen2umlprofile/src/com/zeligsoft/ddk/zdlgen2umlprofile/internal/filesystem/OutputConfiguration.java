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
package com.zeligsoft.ddk.zdlgen2umlprofile.internal.filesystem;

public class OutputConfiguration {
	private String name;
	
	private String description;
	
	private String outputDirectory;
	
	private boolean createOutputDirectory;
	
	private boolean cleanupDerivedResources = true;
	
	private boolean overrideExistingResources = true;
	
	private boolean setDerivedProperty = true;
	
	private boolean canClearOutputDirectory = false;
	
	public OutputConfiguration(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOutputDirectory() {
		return outputDirectory;
	}
	
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	
	public boolean isCleanupDerivedResources() {
		return cleanupDerivedResources;
	}
	
	public void setCleanupDerivedResources(boolean cleanupDerivedResources) {
		this.cleanupDerivedResources = cleanupDerivedResources;
	}
	
	public boolean isOverrideExistingResources() {
		return overrideExistingResources;
	}
	
	public void setOverrideExistingResources(boolean overrideExistingResources) {
		this.overrideExistingResources = overrideExistingResources;
	}
	
	public boolean isSetDerivedProperty() {
		return setDerivedProperty;
	}
	
	public void setSetDerivedProperty(boolean setDerivedProperty) {
		this.setDerivedProperty = setDerivedProperty;
	}
	
	public boolean isCreateOutputDirectory() {
		return createOutputDirectory;
	}
	
	public void setCreateOutputDirectory(boolean createOutputDirectory) {
		this.createOutputDirectory = createOutputDirectory;
	}
	
	public boolean isCanClearOutputDirectory() {
		return canClearOutputDirectory;
	}
	
	public void setCanClearOutputDirectory(boolean canClearOutputDirectory) {
		this.canClearOutputDirectory = canClearOutputDirectory;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutputConfiguration other = (OutputConfiguration) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
