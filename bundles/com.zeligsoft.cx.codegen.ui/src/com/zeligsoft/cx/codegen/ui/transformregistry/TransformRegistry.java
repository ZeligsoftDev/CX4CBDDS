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

package com.zeligsoft.cx.codegen.ui.transformregistry;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.osgi.framework.Bundle;

import com.zeligsoft.cx.codegen.editor.IValidationFactory;
import com.zeligsoft.cx.codegen.ui.CodeGenUIPlugin;
import com.zeligsoft.cx.codegen.ui.l10n.Messages;

/**
 * A transform service for getting extension registry information
 * 
 * @author Laura Li
 * 
 */
public class TransformRegistry {

	/**
	 * Map of fully qualified ZDLConcept name to a List of WorkflowEntry
	 */
	private static HashMap<String, List<WorkflowEntry>> transformsmap = null;
	
	private static Map<URL, List<WorkflowEntry>> workflowURLToEntryMap = null;
	
	/**
	 * List of vetoed (overridden) IDs.
	 */
	private static List<String> vetoId = new ArrayList<String>();
	
	private static final String PLUG_IN_CODEGEN_NAME = "com.zeligsoft.cx.codegen.ui"; //$NON-NLS-1$

	private static final String EXT_ROOT_NODE_NAME = "transformation"; //$NON-NLS-1$

	private static final String EXT_ENTRY_TYPE = "type";//$NON-NLS-1$
	
	private static final String EXT_ENTRY_UMLTYPE = "umlType";//$NON-NLS-1$
	
	private static final String EXT_ENTRY_ID = "id"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_OVERRIDE_ID = "overrideId"; //$NON-NLS-1$

	private static final String EXT_ENTRY_WORKFLOW_PATH = "path";//$NON-NLS-1$

	private static final String EXT_ENTRY_DISPLAY_LABEL = "label";//$NON-NLS-1$
	
	private static final String EXT_ENTRY_VALIDATION_FACTORY = "validationFactory"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_WORKFLOWENTRY_LICENSER = "licenser"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_CANCEL_ON_ERROR = "cancelOnValidationError"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_VISIBILITY_TEST = "visibilityTest"; //$NON-NLS-1$ 	
	
	private static final String EXT_FILEEXT_ROOT_NODE_NAME = "transformationFileExtensions"; //$NON-NLS-1$

	private static final String EXT_FILEEXT_WORKFLOW_PATH = "workflowPath"; //$NON-NLS-1$

	private static final String EXT_FILEEXT_FILE_EXTENSIONS = "fileExtensions"; //$NON-NLS-1$

	/**
	 * The singleton instance of the TransformRegistry
	 */
	public static final TransformRegistry INSTANCE = new TransformRegistry();

	private TransformRegistry() {
		// no op
	}

	private static HashMap<String, List<WorkflowEntry>> getTransformMap() {
		if (transformsmap == null) {
			transformsmap = new HashMap<String, List<WorkflowEntry>>();
			workflowURLToEntryMap = new HashMap<URL, List<WorkflowEntry>>();
			TransformRegistry.INSTANCE.readTransformationExtensions();
			TransformRegistry.INSTANCE.readFileExtExtensions();
		}
		return transformsmap;
	}

	@SuppressWarnings("unused")
	private void readTransformationExtensions() {
		IExtension[] extensions = Platform.getExtensionRegistry()
			.getExtensionPoint(PLUG_IN_CODEGEN_NAME, EXT_ROOT_NODE_NAME)
			.getExtensions();

		if (extensions.length <= 0) {
			return;
		}

		for (int i = 0; i < extensions.length; i += 1) {
			IConfigurationElement[] entries = extensions[i]
				.getConfigurationElements();
			
			// Loop thru <concept> tags
			for (int i2 = 0; i2 < entries.length; i2 += 1) {
				String concept = entries[i2].getAttribute(EXT_ENTRY_TYPE);
					
				if(UML2Util.isEmpty(concept)){
					concept = entries[i2].getAttribute(EXT_ENTRY_UMLTYPE);
				}
				
				if( concept != null) {									
					// transformation
					
					IConfigurationElement[] workflows = entries[i2].getChildren();
	
					for (int i3 = 0; i3 < workflows.length; i3 += 1) {
	
						String path = workflows[i3]
							.getAttribute(EXT_ENTRY_WORKFLOW_PATH);
						String displayLabel = workflows[i3]
							.getAttribute(EXT_ENTRY_DISPLAY_LABEL);
						String validationFactory = workflows[i3]
						    .getAttribute(EXT_ENTRY_VALIDATION_FACTORY);
						String cancelOnValidationError = workflows[i3]
						     .getAttribute(EXT_ENTRY_CANCEL_ON_ERROR);  
						boolean cancelOnError = "true".equals(cancelOnValidationError); //$NON-NLS-1$
						String id = workflows[i3].getAttribute(EXT_ENTRY_ID);
						String overrideId = workflows[i3].getAttribute(EXT_ENTRY_OVERRIDE_ID);
						String workflowEntryLicenser = workflows[i3].getAttribute(EXT_ENTRY_WORKFLOWENTRY_LICENSER);
						String visibilityTest = workflows[i3].getAttribute(EXT_ENTRY_VISIBILITY_TEST);
						
						if( overrideId != null) {
							vetoId.add(overrideId);
						}
	
						URL url = null;
						String pluginId = entries[i2].getDeclaringExtension()
							.getNamespaceIdentifier();
						Bundle bundle = Platform.getBundle(pluginId);
						url = bundle.getEntry(path);
						if (url == null) {
							try {
								url = new URL(path);
							} catch (MalformedURLException e) {
								CodeGenUIPlugin
									.getDefault()
									.error(
										Messages.TransformRegistry_InvalidWorkflowPathLog,
										e);
							}
						}
						if (url == null || displayLabel == null) {
							// do not add entries without a URL or label.
							continue;
						}
						
						// optional visibilityTest field to determine whether or not the entry should be added
						// to the workflow and shown in the Generate menu
						IFilter visibilityFilter = null;
						if(visibilityTest != null){
							try{
								if(bundle == null){
									throw new IllegalArgumentException(NLS.bind("Cannot find bundle " + pluginId, pluginId)); //$NON-NLS-1$
								}								
								@SuppressWarnings("unchecked")
								Class<IFilter> clazz = (Class<IFilter>) bundle.loadClass(visibilityTest);
								visibilityFilter = clazz.newInstance();
							}catch(Exception e){
								CodeGenUIPlugin.getDefault().error
									(Messages.TransformRegistry_InvalidVisibilityTestClass, e);
							}
						}
						
						// only if the workflowEntry is correctly licensed, OR if there is no license required
						// do we create the workflowEntry
						if (workflowEntryLicenser == null){
							
							IValidationFactory factory = null;
							if( validationFactory != null ) {
								// Validation factory is optional, but if specified must be valid.
								try {
								if (bundle == null) {
									throw new IllegalArgumentException(
										NLS.bind("Cannot find bundle " + pluginId, pluginId)); //$NON-NLS-1$
								}
								@SuppressWarnings("unchecked")					
								Class<IValidationFactory> clazz = (Class<IValidationFactory>) bundle.loadClass(validationFactory);
								factory = clazz.newInstance();
								} catch( Exception e ) {
									CodeGenUIPlugin.getDefault().error
										(Messages.TransformRegistry_InvalidWorkflowValidationFactory, e);
								}
							}
		
							WorkflowEntry.DiagnosticInfo dInfo = new WorkflowEntry.DiagnosticInfo(bundle);
							WorkflowEntry info = new WorkflowEntry(url, displayLabel, factory, cancelOnError, dInfo, id, visibilityFilter);
							
							if (workflowURLToEntryMap.containsKey(url)) {
								workflowURLToEntryMap.get(url).add(info);
							} else {
								List<WorkflowEntry> workflowsForURL = new ArrayList<>();
								workflowsForURL.add(info);
								workflowURLToEntryMap.put(url, workflowsForURL);
							}
							
							if (TransformRegistry.getTransformMap()
								.containsKey(concept) == false) {
								// this is a new entry in the hash map
								ArrayList<WorkflowEntry> newlist = new ArrayList<WorkflowEntry>();
								newlist.add(info);
								TransformRegistry.getTransformMap().put(concept,
									newlist);
							} else {
								// this is an existing entry in the hash map
								List<WorkflowEntry> curlist = TransformRegistry
									.getTransformMap().get(concept);
								curlist.add(info);
							}
						}
					}
				}
			}

		}
	}
	
	private void readFileExtExtensions() {
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(PLUG_IN_CODEGEN_NAME, EXT_FILEEXT_ROOT_NODE_NAME).getExtensions();

		for (IExtension extension : extensions) {
			IConfigurationElement[] configElements = extension.getConfigurationElements();
			for (IConfigurationElement configElement : configElements) {
				String workflowPath = configElement.getAttribute(EXT_FILEEXT_WORKFLOW_PATH);
				String fileExtensions = configElement.getAttribute(EXT_FILEEXT_FILE_EXTENSIONS);
				String pluginId = configElement.getDeclaringExtension().getNamespaceIdentifier();
				Bundle bundle = Platform.getBundle(pluginId);
				URL url = bundle.getEntry(workflowPath);
				if (url == null) {
					try {
						url = new URL(workflowPath);
					} catch (MalformedURLException e) {
						CodeGenUIPlugin.getDefault().error(Messages.TransformRegistry_InvalidWorkflowPathLog, e);
					}
				}
				if (url == null) {
					// do not add entries without a URL
					continue;
				}

				List<WorkflowEntry> entries = workflowURLToEntryMap.get(url);
				if (entries != null) {
					for (WorkflowEntry entry : entries) {
						if (entry != null) {
							List<String> fileExtList = new ArrayList<>();
							String[] fileExts = fileExtensions.trim().split(" *, *"); //$NON-NLS-1$
							for (String fileExt : fileExts) {
								if (fileExt.startsWith(".")) { //$NON-NLS-1$
									fileExt = fileExt.substring(1); //$NON-NLS-1$
								}
								fileExtList.add(fileExt);
							}
							entry.setFileExtensions(fileExtList);
						}
					}
				}
			}
		}
	}

	/**
	 * Returns the relates workflow urls applicable to the given concept.
	 * 
	 * @param concept
	 * @return
	 */
	public List<WorkflowEntry> getTransformationWorkflows(String concept, EObject eObject) {
		
		List<WorkflowEntry> result = TransformRegistry.getTransformMap().get(concept);
		return result == null ? new ArrayList<WorkflowEntry>() : result;

	}
	
}
