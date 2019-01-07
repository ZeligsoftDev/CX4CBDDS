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

package com.zeligsoft.base.zml.codegeneration.xtend.utils;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class FileNames {

	private static final List<String> GeneratedFiles = new LinkedList<String>();

	private static String GenerationFolder = ""; //$NON-NLS-1$

	public static void setGenerationFolder(String folder) {
		GeneratedFiles.clear();
		GenerationFolder = folder.replace('\\', '/');
		if(GenerationFolder.charAt(GenerationFolder.length() - 1) != '/')
			GenerationFolder += '/';
	}

	public static void addGeneratedFile(String filename) {
		if (filename.startsWith(GenerationFolder))
			GeneratedFiles.add(filename.replaceFirst(GenerationFolder, "")); //$NON-NLS-1$
		else
			GeneratedFiles.add(filename);
	}

	public static List<String> getAllFilenames() {
		return GeneratedFiles;
	}

	/**
	 * Source file name functions
	 */
	public static String getComponentSourceFileName(Type component) {
		return "zce" + component.getName() + "Worker.c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentContainerSourceFileName(Type component) {
		return "zce" + component.getName() + "Container.c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentUsrSourceFileName(Component component) {
		return "usr" + component.getName() + "Worker.c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentProvidesImplFileName(Component component) {
		return "zceProvidesPort_" + component.getName() + ".h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentRequiresImplFileName(Component component) {
		return "zceRequiresPort_" + component.getName() + ".h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getConfiguratorSourceFileName(Property component) {
		return "zce" + component.getName() + "Configurator.c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Header file name functions
	 */
	public static String getComponentHeaderFileName(Type component) {
		return "zce" + component.getName() + "Worker.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentUsrHeaderFileName(Component component) {
		return "usr" + component.getName() + "Worker.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentForwardDeclaresHeaderFileName(
			Type component) {
		return "zce" + component.getName() + "ComponentFwdDeclares.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentContainerHeaderFileName(Type component) {
		return "zce" + component.getName() + "Container.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentContainerIdsHeaderFileName(Type component) {
		return "zce" + component.getName() + "Ids.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getConfiguratorHeaderFileName(Property component) {
		return "zce" + component.getName() + "Configurator.h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Object file name functions
	 */
	public static String getComponentWorkerStructName(Type component) {
		return "zce" + component.getName() + "Worker"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentUsrObjectFileName(Component component) {
		return "usr" + component.getName() + "Worker"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentContainerStructName(Type component) {
		return "zce" + component.getName() + "Container"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getInterfaceProvidesObjectFileName(Interface intf) {
		return "zceProvidesPort_" + intf.getName(); //$NON-NLS-1$
	}

	public static String getInterfaceRequiresObjectFileName(Interface intf) {
		return "zceRequiresPort_" + intf.getName(); //$NON-NLS-1$
	}

	public static String getInterfaceBaseObjectFileName(Interface intf) {
		return "zceBase_" + intf.getName(); //$NON-NLS-1$
	}

	public static String getConfiguratorStructName(Property component) {
		return "zce" + component.getName() + "Configurator"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getComponentIdFileName(Type component) {
		return "zce" + component.getName() + "Id"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Executable file name functions
	 */
	public static String getComponentExecutableFileName(Component component) {
		return component.getName() + ".out"; //$NON-NLS-1$
	}

	/**
	 * Interface file name functions
	 */
	public static String getInterfaceBaseDefFileName(Interface intf) {
		return "zceBase_" + intf.getName() + ".h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getInterfaceProvidesDefFileName(Interface intf) {
		return "zceProvidesPort_" + intf.getName() + ".h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getInterfaceProvidesSourceFileName(Interface intf) {
		return "zceProvidesPort_" + intf.getName() + ".c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getInterfaceRequiresDefFileName(Interface intf) {
		return "zceRequiresPort_" + intf.getName() + ".h"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String getInterfaceRequiresSourceFileName(Interface intf) {
		return "zceRequiresPort_" + intf.getName() + ".c"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Component Port Id functions
	 */

	public static String getComponentPortId(Type component, Port port) {
		return "e" + component.getName().toUpperCase() + "_PORT_" //$NON-NLS-1$ //$NON-NLS-2$
			+ port.getName().toUpperCase() + "_INT_ID"; //$NON-NLS-1$
	}

}
