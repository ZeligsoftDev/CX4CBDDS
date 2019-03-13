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
package com.zeligsoft.cx.codegen.postprocessor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.zdl.Activator;

/**
 * Manages all code-editor postprocessors in a running workbench.
 * 
 * @author smcfee
 *
 */
public class CodeEditorPostProcessorRegistry {

	public static CodeEditorPostProcessorRegistry INSTANCE = new CodeEditorPostProcessorRegistry();
	
	private CodeEditorPostProcessorRegistry() {
		initializeContributors();
	}
	
	private List<CodeEditorPostProcessor> contributors;
	
	private void initializeContributors() {
		contributors =  new ArrayList<CodeEditorPostProcessor>();
		
		String namespace = "com.zeligsoft.cx.codegen"; //$NON-NLS-1$
		String extensionPointName = "codeeditorpostprocessor"; //$NON-NLS-1$
		IExtension[] extensions = Platform.getExtensionRegistry()
		.getExtensionPoint(namespace, extensionPointName).getExtensions();

		if (extensions.length <= 0) {
			return;
		}
	
		for (int i = 0; i < extensions.length; i += 1) {
			IConfigurationElement[] entries = extensions[i]
				.getConfigurationElements();
			
			// Loop thru <concept> tags
			for (int i2 = 0; i2 < entries.length; i2 += 1) {
				String classString = entries[i2].getAttribute("class"); //$NON-NLS-1$
				String bundleString = entries[i2].getDeclaringExtension().getNamespaceIdentifier();
				
				try {
					Bundle bundle = Platform.getBundle(bundleString);
					if (bundle == null) {
						// Error in the plugin.xml most likely
						Activator.getDefault().error("Cannot find bundle " + bundleString, null); //$NON-NLS-1$
						throw new IllegalArgumentException(
							NLS.bind("Cannot find bundle " + bundleString, bundleString)); //$NON-NLS-1$
					}
					@SuppressWarnings("unchecked")					
					Class<CodeEditorPostProcessor> clazz = (Class<CodeEditorPostProcessor>) bundle.loadClass(classString);
					CodeEditorPostProcessor contributor = clazz.newInstance();
					contributors.add(contributor);
				} catch(ClassNotFoundException ce) {
					Activator.getDefault().error("Failed to load codeeditor postprocessor class=" + classString, ce); //$NON-NLS-1$ 
				} catch(InstantiationException ie) {
					Activator.getDefault().error("Failed to load codeeditor postprocessor class=" + classString , ie); //$NON-NLS-1$
				} catch (IllegalAccessException ee) {
					Activator.getDefault().error("Failed to load codeeditor postprocessor class=" + classString, ee); //$NON-NLS-1$ 
				}	
			}
		}
	}
	
	public void notifyObject(EObject eobj) {
		for( CodeEditorPostProcessor pp : contributors ) {
			pp.notifyObject(eobj);
		}
	}
	
	public void postProcess() {
		for( CodeEditorPostProcessor pp : contributors ) {
			pp.postProcess();
		}
	}
}
