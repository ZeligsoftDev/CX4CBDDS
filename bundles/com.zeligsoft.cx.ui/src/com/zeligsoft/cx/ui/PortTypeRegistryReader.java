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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;

import com.zeligsoft.base.zdl.util.ZDLUtil;
import com.zeligsoft.domain.zml.util.ZMLMMNames;

/**
 * A registry of the Port Type Creation extension point.
 * 
 * @author Young-Soo Roh (ysroh)
 * 
 */
public class PortTypeRegistryReader
		extends RegistryReader {

	public static PortTypeRegistryReader INSTANCE = new PortTypeRegistryReader();

	private static final String A_DOMAIN_NAME = "domain"; //$NON-NLS-1$

	private static final String A_INTERFACE_TYPE = "concept"; //$NON-NLS-1$

	private static final String A_PORT_TYPE_CONCEPT = "portTypeConcept"; //$NON-NLS-1$

	private static final String A_ALLOW_INTERFACE_CREATION = "allowInterfaceCreation"; //$NON-NLS-1$

	private static final String A_CREATE_INVERSE_PORT_TYPE = "createInversePortType"; //$NON-NLS-1$

	private static final String A_ENABLE_MULTI_SELECTION = "enableMultiSelection"; //$NON-NLS-1$
	
	private static final String A_ENABLE_NAME_SELECTION = "enableNameSelection"; //$NON-NLS-1$

	private static final String A_SHOW_USES_LIST = "showUsesList"; //$NON-NLS-1$

	private Map<String, PortTypeRegistry> portTypeRegistryMap = new HashMap<String, PortTypeRegistry>();

	/**
	 * Constructor
	 */
	private PortTypeRegistryReader() {
		super(Platform.getExtensionRegistry(), ZeligsoftCXUIPlugin.PLUGIN_ID,
			ZeligsoftCXUIPlugin.PORT_TYPE_EXTPT);
		readRegistry();
	}

	/**
	 * Port type registry class
	 * 
	 * @author ysroh
	 * 
	 */
	public class PortTypeRegistry {

		private String domainName;

		private String interfaceType = null;
		
		private String portTypeConcept = "ZMLMM::ZML_Component::PortType"; //$NON-NLS-1$

		private boolean allowInterfaceCreation = true;
		
		private boolean createInversePortType = true;

		private boolean enableMultiSelection = true;

		private boolean enableNameSelection = false;
		
		private boolean showUsesList = false;

		public PortTypeRegistry() {
			super();
		}

		/**
		 * Queries the domain name
		 * 
		 * @return
		 */
		public String getDomainName() {
			return domainName;
		}

		/**
		 * Queries the interface type
		 * 
		 * @return
		 */
		public String getInterfaceType() {
			if (UML2Util.isEmpty(interfaceType)) {
				return ZMLMMNames.INTERFACE;
			}
			return interfaceType;
		}

		/**
		 * Queries if the allow interface creation is true
		 * 
		 * @return
		 */
		public boolean isAllowInterfaceCreation() {
			return allowInterfaceCreation;
		}

		/**
		 * Queries if the allow multiple selection is true
		 * 
		 * @return
		 */
		public boolean isEnableMultiSelection() {
			return enableMultiSelection;
		}

		/**
		 * Queries if the show uses list is true
		 * 
		 * @return
		 */
		public boolean isShowUsesList() {
			return showUsesList;
		}

		/**
		 * Set domain name
		 * 
		 * @param domainName
		 */
		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}

		/**
		 * Set interface type
		 * 
		 * @param interfaceType
		 */
		public void setInterfaceType(String interfaceType) {
			this.interfaceType = interfaceType;
		}

		/**
		 * Set allow interface creation
		 * 
		 * @param allowInterfaceCreation
		 */
		public void setAllowInterfaceCreation(boolean allowInterfaceCreation) {

			this.allowInterfaceCreation = allowInterfaceCreation;
		}

		/**
		 * Set enable multiple selection
		 * 
		 * @param enableMultiSelection
		 */
		public void setEnableMultiSelection(boolean enableMultiSelection) {
			this.enableMultiSelection = enableMultiSelection;
		}

		/**
		 * Set show uses list
		 * 
		 * @param showUsesList
		 */
		public void setShowUsesList(boolean showUsesList) {
			this.showUsesList = showUsesList;
		}

		public void setEnableNameSelection(boolean enableNameSelection) {
			this.enableNameSelection = enableNameSelection;
		}

		public boolean isEnableNameSelection() {
			return enableNameSelection;
		}

		public void setCreateInversePortType(boolean createInversePortType) {
			this.createInversePortType = createInversePortType;
		}

		public boolean isCreateInversePortType() {
			return createInversePortType;
		}

		public void setPortTypeConcept(String portTypeConcept) {
			this.portTypeConcept = portTypeConcept;
		}

		public String getPortTypeConcept() {
			return portTypeConcept;
		}
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {

		if (add) {
			String domainName = element.getAttribute(A_DOMAIN_NAME);
			if ((domainName == null) || (domainName.length() == 0)) {
				logMissingAttribute(element, A_DOMAIN_NAME);
				return false;
			}
			PortTypeRegistry registry = new PortTypeRegistry();
			registry.setDomainName(domainName);

			registry.setAllowInterfaceCreation(false);
			registry.setCreateInversePortType(true);
			registry.setEnableMultiSelection(false);
			registry.setEnableNameSelection(false);
			registry.setShowUsesList(false);

			registry.setAllowInterfaceCreation(Boolean.valueOf(element
				.getAttribute(A_ALLOW_INTERFACE_CREATION)));

			registry.setEnableMultiSelection(Boolean.valueOf(element
				.getAttribute(A_ENABLE_MULTI_SELECTION)));

			if (element.getAttribute(A_ENABLE_NAME_SELECTION) != null) {
				registry.setEnableNameSelection(Boolean.valueOf(element
						.getAttribute(A_ENABLE_NAME_SELECTION)));
			}
			
			if (element.getAttribute(A_CREATE_INVERSE_PORT_TYPE) != null) {
				registry.setCreateInversePortType(Boolean.valueOf(element
						.getAttribute(A_CREATE_INVERSE_PORT_TYPE)));
			}
			
			registry.setShowUsesList(Boolean.valueOf(element
				.getAttribute(A_SHOW_USES_LIST)));

			registry.setInterfaceType(element.getAttribute(A_INTERFACE_TYPE));
			if(element.getAttribute(A_PORT_TYPE_CONCEPT) != null){
				registry.setPortTypeConcept(element.getAttribute(A_PORT_TYPE_CONCEPT));
			}
			portTypeRegistryMap.put(domainName, registry);

		}

		return true;
	}

	/**
	 * Return port type registry map
	 * 
	 * @return
	 */
	public Map<String, PortTypeRegistry> getPortTypeRegistryMap() {
		return portTypeRegistryMap;
	}

	/**
	 * Return port type registry that matches the domain of the given element
	 * 
	 * @return
	 */
	public PortTypeRegistry getPortTypeRegistry(Element context) {

		Iterator<Profile> iter = ZDLUtil.getZDLProfiles(context).iterator();
		while (iter.hasNext()) {
			Profile profile = iter.next();

			if (portTypeRegistryMap.containsKey(profile.getName())) {
				return portTypeRegistryMap.get(profile.getName());
			}
		}

		return null;
	}
}
