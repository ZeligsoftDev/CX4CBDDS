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

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFilePostProcessor;
import com.zeligsoft.ddk.zdlgen2umlprofile.filesystem.IFileSystemAccess;

/**
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public abstract class AbstractFileSystemAccess implements IFileSystemAccess {

	/**
	 * A possibly null postProcessor to be run on all files generated with
	 * this FileSystemAccess.
	 */
	protected IFilePostProcessor postProcessor;
	
	private Map<String, OutputConfiguration> outputs = Maps.newLinkedHashMap();
	
	/**
	 * @return the postProcessor which will be run against all
	 * 	files generated with this FileSystemAccess
	 */
	public IFilePostProcessor getPostProcessor() {
		return postProcessor;
	}

	/**
	 * @param postProcessor the postProcessor which will be run against all
	 * 	files generated with this FileSystemAccess
	 */
	public void setPostProcessor(IFilePostProcessor postProcessor) {
		this.postProcessor = postProcessor;
	}

	
	/**
	 * 
	 * @param outputs initialize the output configurations available with this
	 * 	FileSystemAccess, the output configuration can then be referenced
	 * 	by name in the other operations 
	 */
	public void setOutputConfigurations(Map<String, OutputConfiguration> outputs) {
		this.outputs = outputs;
	}
	
	/**
	 * 
	 * @return the output configurations available with this
	 * 	FileSystemAccess
	 */
	public Map<String, OutputConfiguration> getOutputConfigurations() {
		return outputs;
	}
	
	/**
	 * Get the {@link OutputConfiguration} associated with the provided key. 
	 * 
	 * An exception; {@link IllegalArgumentException}; will be thrown if their
	 * is no {@link OutputConfiguration} associated with the provided key.
	 * 
	 * @param outputName the name
	 * @return
	 */
	protected OutputConfiguration getOutputConfig(String outputName) {
		if(!getOutputConfigurations().containsKey(outputName)) {
			throw new IllegalArgumentException(
					String.format("No output configuration with name %s exists.", 
							outputName));
		}
		return getOutputConfigurations().get(outputName);
	}
	
	/**
	 * Provides a map of output name to path relationship.
	 * 
	 * @return A map keyed by the output name and a value that is the
	 * 	output directory associated with it.
	 */
	protected Map<String, String> getPathes() {
		return Maps.transformValues(outputs, new Function<OutputConfiguration, String>() {
			public String apply(OutputConfiguration from) {
				return from.getOutputDirectory();
			}
		});
	}
	
	/**
	 * Set the output directory of the {@link OutputConfiguration} associated
	 * with the provided key; <code>outputName</code>.
	 * 
	 * @param outputName the name of the {@link OutputConfiguration} to modify
	 * @param path the new output directory
	 */
	public void setOutputPath(String outputName, String path) {
		OutputConfiguration configuration = outputs.get(outputName);
		
		if(configuration == null) {
			configuration = new OutputConfiguration(outputName);
			outputs.put(outputName, configuration);
		}
		configuration.setOutputDirectory(path);
	}
	
	/**
	 * Set the output directory of the default {@link OutputConfiguration}.
	 * 
	 * @param path the new output directory for the default
	 */
	public void setOutputPath(String path) {
		setOutputPath(DEFAULT_OUTPUT, path);
	}
	
	/**
	 * Control over whether directories that don't already exist should be
	 * created for the default {@link OutputConfiguration}.
	 * 
	 * @param createOutputDirectory when <code>true</code> directories that
	 * 	don't already exist will be created, <code>false</code> an exception 
	 * 	will be raised when trying to write to a directoy that doesn't already
	 * 	exist.
	 */
	public void setCreateOutputDirectory(boolean createOutputDirectory) {
		setCreateOutputDirectory(DEFAULT_OUTPUT, createOutputDirectory);
	}
	
	/**
	 * Control over whether directories that don't already exist should be
	 * created for the provided {@link OutputConfiguration}.
	 * 
	 * @param outputName the name of the {@link OutputConfiguration}
	 * @param createOutputDirectory createOutputDirectory when <code>true</code> directories that
	 * 	don't already exist will be created, <code>false</code> an exception 
	 * 	will be raised when trying to write to a directoy that doesn't already
	 * 	exist.
	 */
	public void setCreateOutputDirectory(String outputName, boolean createOutputDirectory) {
		OutputConfiguration configuration = outputs.get(outputName);
		
		if(configuration == null) {
			configuration = new OutputConfiguration(outputName);
			outputs.put(outputName, configuration);
		}
		configuration.setCreateOutputDirectory(true);
	}
	
	/* (non-Javadoc)
	 * @see com.prismtech.domain.sca.scadoc.filesystem.IFileSystemAccess#generateFile(java.lang.String, java.lang.CharSequence)
	 */
	@Override
	public void generateFile(String fileName, CharSequence contents) {
		generateFile(fileName, DEFAULT_OUTPUT, contents);
	}

	/* (non-Javadoc)
	 * @see com.prismtech.domain.sca.scadoc.filesystem.IFileSystemAccess#deleteFile(java.lang.String)
	 */
	@Override
	public void deleteFile(String fileName) {
		deleteFile(fileName, DEFAULT_OUTPUT);
	}
	
	public void deleteFile(String fileName, String outputConfigurationName) {
		throw new UnsupportedOperationException();
	}

	protected abstract CharSequence postProcess(String fileName, String outputConfiguration, CharSequence content);
	
	
}
