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
package com.zeligsoft.ddk.zdlgen2umlprofile.filesystem;

import com.zeligsoft.ddk.zdlgen2umlprofile.internal.filesystem.OutputConfiguration;

/**
 * Abstraction of the FileSystem that the SCA Doc documentation generator
 * generates artefacts to.
 * 
 * @author Toby McClean (tmcclean)
 *
 */
public interface IFileSystemAccess {
	public final static String DEFAULT_OUTPUT = "DEFAULT_OUTPUT"; //$NON-NLS-1$
	
	/**
	 * @param fileName using '/' as file separator
	 * @param contents the to-be-written contents.
	 */
	public void generateFile(String fileName, CharSequence contents);
	
	/**
	 * @param fileName using '/' as file separator
	 * @param outputConfigurationName the name of the output configuration
	 * @param contents the to-be-written contents.
	 */
	public void generateFile(String fileName, String outputConfigurationName, CharSequence contents);
	
	/**
	 * @param fileName using '/' as file separator
	 */
	public void deleteFile(String fileName);
	
	/**
	 * @param dir name of the folder
	 * @param outputConfigurationName name of the {@link OutputConfiguration}
	 * 	to use as a base
	 * @return the absolute path to the <code>dir</code> based on the specified
	 * 	{@link OutputConfiguration}
	 */
	public String getFolderPath(String dir, String outputConfigurationName);
	
	/**
	 * 
	 * @param dir name of the folder
	 * @return the absolute path to the <code>dir</code> based on the default
	 * 	{@link OutputConfiguration}
	 */
	public String getFolderPath(String dir);
}
