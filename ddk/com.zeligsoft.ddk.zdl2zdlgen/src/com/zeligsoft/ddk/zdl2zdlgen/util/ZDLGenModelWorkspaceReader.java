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
package com.zeligsoft.ddk.zdl2zdlgen.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * @author Toby McClean (tmcclean)
 * 
 */
public class ZDLGenModelWorkspaceReader {
	/**
	 * 
	 */
	private static final String ZDL_DOMAIN_MODELS_EXT = 
		"com.zeligsoft.base.zdl.domain_models"; //$NON-NLS-1$
	private Map<String, String> uri2DomainModel = new HashMap<String, String>();
	private Map<String, String> uri2GenModel = new HashMap<String, String>();

	/**
 * 
 */
	public ZDLGenModelWorkspaceReader() {
		IPluginModelBase[] plugins = PluginRegistry.getWorkspaceModels();

		for (IPluginModelBase next : plugins) {
			process(next);
		}
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public String getDomainModel(String uri) {
		return uri2DomainModel.get(uri);
	}

	/**
	 * @param key
	 * @return
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public String getGenModel(String uri) {
		return uri2GenModel.get(uri);
	}

	public String getNsURIFromDomainModel(URI domainModelURI) {
		String result = ""; //$NON-NLS-1$
		URIConverter converter =  new ExtensibleURIConverterImpl();

		domainModelURI = converter.normalize(domainModelURI);

		for (Map.Entry<String, String> entry : uri2DomainModel.entrySet()) {
			URI entryURI = URI.createURI(entry.getValue());
			entryURI = converter.normalize(entryURI);
			if (domainModelURI.equals(entryURI)) {
				result = entry.getKey();
				break;
			}
		}

		return result;
	}

	/**
	 * @param next
	 */
	private void process(IPluginModelBase plugin) {
		IPluginExtension[] extensions = plugin.getExtensions(true)
				.getExtensions();

		for (IPluginExtension ext : extensions) {
			if (ZDL_DOMAIN_MODELS_EXT.equals(ext.getPoint())) {
				for (IPluginObject child : ext.getChildren()) {
					if (child instanceof IPluginElement) {
						IPluginElement ipe = (IPluginElement) child;
						if (ipe.getName().equals("domainModel")) { //$NON-NLS-1$
							IPluginAttribute genModelAttr = ipe
									.getAttribute("genModel"); //$NON-NLS-1$
							IPluginAttribute pathAttr = ipe
									.getAttribute("path"); //$NON-NLS-1$
							IPluginAttribute uriAttr = ipe.getAttribute("uri"); //$NON-NLS-1$

							if (genModelAttr != null && pathAttr != null
									&& uriAttr != null
									&& !uriAttr.getValue().isEmpty()) {
								uri2DomainModel.put(uriAttr.getValue(),
										pathAttr.getValue());
								uri2GenModel.put(uriAttr.getValue(),
										genModelAttr.getValue());
							}
						}
					}
				}
				break;
			}
		}

	}
}
