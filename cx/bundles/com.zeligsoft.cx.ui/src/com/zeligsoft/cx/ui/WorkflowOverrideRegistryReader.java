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
package com.zeligsoft.cx.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.uml2.common.util.UML2Util;

/**
 * Registry reader for extgension point which can override a workflow
 * 
 * @author parmvirs
 * 
 */
public class WorkflowOverrideRegistryReader extends RegistryReader {

	public static WorkflowOverrideRegistryReader INSTANCE = new WorkflowOverrideRegistryReader();

	private static final String WORKFLOW = "workflow"; //$NON-NLS-1$

	private static final String BUNDLE = "bundle"; //$NON-NLS-1$

	private static final String EXTENSION_POINT_ID = "overrideId"; //$NON-NLS-1$

	private Map<String, String> workflow = new HashMap<String, String>();

	private Map<String, String> bundle = new HashMap<String, String>();

	private WorkflowOverrideRegistryReader() {
		super(Platform.getExtensionRegistry(), ZeligsoftCXUIPlugin.PLUGIN_ID,
				ZeligsoftCXUIPlugin.WORKFLOW_OVERRIDE_EXTPT);
		readRegistry();
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {

		if (add) {
			
			String extensionPointId;
			String workflowString;
			String bundleString;
			
			extensionPointId = element.getAttribute(EXTENSION_POINT_ID);
			if (UML2Util.isEmpty(extensionPointId)) {
				logMissingAttribute(element, EXTENSION_POINT_ID);
				return false;
			}

			workflowString = element.getAttribute(WORKFLOW);
			if (UML2Util.isEmpty(workflowString)) {
				logMissingAttribute(element, WORKFLOW);
				return false;
			}
			workflow.put(extensionPointId, workflowString);
			
			bundleString = element.getAttribute(BUNDLE);
			if (UML2Util.isEmpty(bundleString)) {
				logMissingAttribute(element, BUNDLE);
				return false;
			}
			bundle.put(extensionPointId, bundleString);
		}
		return true;
	}

	public String getWorkflow(String overrideId) {
		return workflow.get(overrideId);
	}

	public String getBundle(String overrideId) {
		return bundle.get(overrideId);
	}
}
