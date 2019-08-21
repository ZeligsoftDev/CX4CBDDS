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
package com.zeligsoft.domain.idl3plus.connectorregistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;

import com.zeligsoft.domain.idl3plus.Activator;

/**
 * Class that keeps track of DDS Connectors registered with the com.zeligsoft.domain.dds4ccm.connector_configuration extension point,
 * to allow configuration of generation parameters, import parameters, modeling parameters, and so on. This allows external clients to
 * configure their own DDS connector model libraries without requiring a code change from us.
 *  
 * @author smcfee
 *
 */
public class ConnectorRegistry {

	private static ConnectorRegistry INSTANCE = null;
	
	private static final String PLUG_IN_NAME = Activator.PLUGIN_ID;
	
	private static final String EXT_ROOT_NODE_NAME = "model_library_configuration"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_CONNECTOR_NAME = "connector"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_MODULE_NAME = "module"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_NAME = "name"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_GENERATION_OPTIONS = "generationOptions"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_IMPORT_OPTIONS = "importOptions"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_INCLUDE_FILE = "includeFile"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_PORT_ICONS = "portIcon"; //$NON-NLS-1$
	
	private static final String EXT_ENTRY_PORT_ICONS_PORTTYPE_NAME = "name"; //$NON-NLS-1$

	private static final String EXT_ENTRY_PORT_ICONS_DEFAULT = "portIcon"; //$NON-NLS-1$

	private static final String EXT_ENTRY_PORT_ICONS_CONJUGATED = "conjugatedPortIcon"; //$NON-NLS-1$

	private static HashMap<String, ConnectorConfiguration> connectorInfo = new HashMap<String, ConnectorConfiguration>();
	
	private static HashMap<String, PortIconConfiguration> portIconInfo = new HashMap<String, PortIconConfiguration>();

	public static ConnectorRegistry getInstance() {
		if( INSTANCE == null ) {
			INSTANCE = new ConnectorRegistry();
		}
		return INSTANCE;
	}
	
	private ConnectorRegistry() {
		loadRegistry();
	}
	
	/**
	 *  Find all registered extensions of our extension point and create configuration objects that can then be queried by name.
	 * 
	 *  The qualified name of the template module is used as the key.
	 **/
	private void loadRegistry() {
		IExtension[] extensions = Platform.getExtensionRegistry()
			.getExtensionPoint(PLUG_IN_NAME, EXT_ROOT_NODE_NAME)
			.getExtensions();

		if (extensions.length <= 0) {
			return;
		}

		for (int i = 0; i < extensions.length; i += 1) {
			IConfigurationElement[] entries = extensions[i]
				.getConfigurationElements();
			
			// Loop thru <connector> tags
			for (int i2 = 0; i2 < entries.length; i2 += 1) {
				String elementName = entries[i2].getName();
				if( elementName.matches(EXT_ENTRY_CONNECTOR_NAME)) {									
					// connector
					String connectorName = entries[i2].getAttribute(EXT_ENTRY_NAME);
					
					List<String> includeFileNames = getIncludeFiles(entries[i2]);
					portIconInfo.putAll(getPortIcons(entries[i2]));
					connectorInfo.put(connectorName,
							new ConnectorConfiguration(connectorName,
									includeFileNames));

				} else if( elementName.matches(EXT_ENTRY_MODULE_NAME)) {
					String moduleName = entries[i2].getAttribute(EXT_ENTRY_NAME);
					
					List<String> includeFileNames = getIncludeFiles(entries[i2]);
					portIconInfo.putAll(getPortIcons(entries[i2]));
					connectorInfo.put(moduleName, new ConnectorConfiguration(
							moduleName, includeFileNames));
				}
			}
		}
	}
	
	/**
	 * Collect port icons customization
	 * 
	 * @param element
	 * @return
	 */
	private Map<String, PortIconConfiguration> getPortIcons(
			IConfigurationElement element) {
		Map<String, PortIconConfiguration> map = new HashMap<String, PortIconConfiguration>();

		String contributor = ((RegistryContributor) element
				.getContributor()).getActualName();

		IConfigurationElement[] portIconsEntries = element
				.getChildren(EXT_ENTRY_PORT_ICONS);

		for (int i3 = 0; i3 < portIconsEntries.length; i3 += 1) {

			String porttypeName = portIconsEntries[i3]
					.getAttribute(EXT_ENTRY_PORT_ICONS_PORTTYPE_NAME);
			String defaultIcon = portIconsEntries[i3]
					.getAttribute(EXT_ENTRY_PORT_ICONS_DEFAULT);
			String conjugatedIcon = portIconsEntries[i3]
					.getAttribute(EXT_ENTRY_PORT_ICONS_CONJUGATED);
			map.put(porttypeName, new PortIconConfiguration(contributor,
					defaultIcon, conjugatedIcon));
		}

		return map;
	}
	
	private List<String> getIncludeFiles(IConfigurationElement element) {
		ArrayList<String> includeFileNames = new ArrayList<String>();
		
		IConfigurationElement[] generationOptions = element.getChildren(EXT_ENTRY_GENERATION_OPTIONS);
		
		@SuppressWarnings("unused") // will be used later most likely.
		IConfigurationElement[] importOptions = element.getChildren(EXT_ENTRY_IMPORT_OPTIONS);

		for (int i3 = 0; i3 < generationOptions.length; i3 += 1) {

			IConfigurationElement[] includeFiles = generationOptions[i3].getChildren(EXT_ENTRY_INCLUDE_FILE);
			
			for( int includeIdx = 0; includeIdx < includeFiles.length; includeIdx++ ) {
				includeFileNames.add(includeFiles[includeIdx].getValue());
			}

		}
		
		return includeFileNames;
	}
	
	/**
	 * Retrieve the configuration information for a DDS connector.
	 * 
	 * @param name The qualified name of the template module for which there is associated configuration information.
	 * @return The configuration object if the connector type is registered, and null if not.
	 */
	public ConnectorConfiguration getConfiguration(String name) {
		return connectorInfo.get(name);
	}
	
	/**
	 * Queries the port icon configuration for the given qualified name
	 * 
	 * @param qualifiedName
	 *            qualified name of the port type
	 * @return Port icon configuration for the given port type qualified name
	 */
	public PortIconConfiguration getPortIconConfiguration(String qualifiedName) {
		return portIconInfo.get(qualifiedName);
	}
	
	public class ConnectorConfiguration {

		private String name;

		public String getName() {
			return name;
		}

		private List<String> includeFileNames = new ArrayList<String>();

		public List<String> getIncludeFileNames() {
			return includeFileNames;
		}

		public ConnectorConfiguration(String name, List<String> includeFileNames) {
			this.name = name;
			this.includeFileNames = includeFileNames;
		}
	}

	/**
	 * Port icon configuration class
	 * 
	 * @author ysroh
	 * 
	 */
	public class PortIconConfiguration {
		private String defaultIconPath;
		private String conjugatedPortIconPath;
		private String contributorName;

		public PortIconConfiguration(String contributor,
				String defaultIconPath, String conjugatedIconPath) {
			this.contributorName = contributor;
			this.defaultIconPath = defaultIconPath;
			this.conjugatedPortIconPath = conjugatedIconPath;
		}

		public String getDefaultIconPath() {
			return defaultIconPath;
		}

		public String getConjugatedIconPath() {
			return conjugatedPortIconPath;
		}

		public String getContributorName() {
			return contributorName;
		}
	}
}
