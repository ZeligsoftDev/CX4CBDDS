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
package com.zeligsoft.cx.deployment.treeeditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;

import com.zeligsoft.cx.deployment.treeeditor.actions.AbstractDeploymetEditorPopupAction;
import com.zeligsoft.cx.deployment.treeeditor.ui.Activator;

public class DeploymentEditorPopupMenuRegistryReader extends RegistryReader {

	public static DeploymentEditorPopupMenuRegistryReader INSTANCE = new DeploymentEditorPopupMenuRegistryReader();

	private static final String A_NAME = "name"; //$NON-NLS-1$

	private static final String A_CLASS = "class"; //$NON-NLS-1$

	private static final String A_DOMAIN = "domain"; //$NON-NLS-1$

	private static final String A_MENUBAR_PATH = "menubarPath"; //$NON-NLS-1$

	private static final String A_SHOW_ON_CONFIGURATION = "showOnConfiguration"; //$NON-NLS-1$

	private static final String A_SHOW_ON_DEPLOYMENT = "showOnDeployment"; //$NON-NLS-1$

	private List<DeploymentEditorPopupMenuRegistry> menuContributions = new ArrayList<DeploymentEditorPopupMenuRegistry>();

	public DeploymentEditorPopupMenuRegistryReader() {
		super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
				Activator.DEPLOYMENT_EDITOR_POPUP_MENU_EXTPT);
		readRegistry();
	}

	public class DeploymentEditorPopupMenuRegistry {

		private String name;

		private String domain;

		private String menubarPath = ""; //$NON-NLS-1$
		
		private AbstractDeploymetEditorPopupAction action;

		private boolean showOnConfiguration;

		private boolean showOnDeployment;

		public DeploymentEditorPopupMenuRegistry() {
			// TODO Auto-generated constructor stub
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setAction(AbstractDeploymetEditorPopupAction action) {
			this.action = action;
		}

		public AbstractDeploymetEditorPopupAction getAction() {
			return action;
		}

		public void setShowOnConfiguration(boolean showOnConfiguration) {
			this.showOnConfiguration = showOnConfiguration;
		}

		public boolean isShowOnConfiguration() {
			return showOnConfiguration;
		}

		public void setShowOnDeployment(boolean showOnDeployment) {
			this.showOnDeployment = showOnDeployment;
		}

		public boolean isShowOnDeployment() {
			return showOnDeployment;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return domain;
		}

		public void setMenubarPath(String menubarPath) {
			this.menubarPath = menubarPath;
		}

		public String getMenubarPath() {
			return menubarPath;
		}

	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {

		if (add) {
			String name = element.getAttribute(A_NAME);
			if ((name == null) || (name.length() == 0)) {
				logMissingAttribute(element, A_NAME);
				return false;
			}
			DeploymentEditorPopupMenuRegistry registry = new DeploymentEditorPopupMenuRegistry();
			registry.setName(name);

			registry.setDomain(element.getAttribute(A_DOMAIN));
			
			if(element.getAttribute(A_MENUBAR_PATH) != null){
				registry.setMenubarPath(element.getAttribute(A_MENUBAR_PATH));
			}

			Object obj=null;
			try {
				obj = element.createExecutableExtension(A_CLASS);
			} catch (CoreException e) {
				Activator.getDefault().error("Invalid class for popup action", e); //$NON-NLS-1$
				return false;

			}
			if (!(obj instanceof AbstractDeploymetEditorPopupAction)) {
				return false;
			}
			registry.setAction((AbstractDeploymetEditorPopupAction) obj);
			registry.setShowOnConfiguration(Boolean.valueOf(element
					.getAttribute(A_SHOW_ON_CONFIGURATION)));

			registry.setShowOnDeployment(Boolean.valueOf(element
					.getAttribute(A_SHOW_ON_DEPLOYMENT)));

			menuContributions.add(registry);
		}

		return true;
	}

	public List<DeploymentEditorPopupMenuRegistry> getMenuContributions() {
		return menuContributions;
	}
}
