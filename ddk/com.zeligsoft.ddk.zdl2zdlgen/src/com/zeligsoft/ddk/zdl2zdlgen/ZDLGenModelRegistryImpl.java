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
package com.zeligsoft.ddk.zdl2zdlgen;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.ddk.zdl.zdlgen.GenModel;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * Default implementation of the {@link ZDLGenModelRegistry} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ZDLGenModelRegistryImpl
		implements ZDLGenModelRegistry {

	private static final String E_DOMAIN_MODEL = "domainModel"; //$NON-NLS-1$

	private static final String A_URI = "uri"; //$NON-NLS-1$

	private static final String A_GEN_MODEL = "genModel"; //$NON-NLS-1$

	private Map<URI, URI> zdlgenModels = new java.util.HashMap<URI, URI>();

	/**
	 * Initializes me.
	 */
	protected ZDLGenModelRegistryImpl() {
		new ZDLGenModelRegistryReader().readRegistry();
	}

	@Override
	public synchronized GenModel getGenModel(URI nsURI, ResourceSet rset) {
		GenModel result = null;
		URI locationURI = zdlgenModels.get(nsURI);

		if (locationURI != null) {
			Resource resource = rset.getResource(locationURI, true);
			result = (GenModel) EcoreUtil.getObjectByType(resource
				.getContents(), ZDLGenPackage.Literals.GEN_MODEL);
		}

		return result;
	}

	@Override
	public synchronized void registerModel(GenModel zdlgenModel, URI nsURI) {
		if (nsURI == null) {
			throw new IllegalArgumentException("null nsURI"); //$NON-NLS-1$
		}

		URI locationURI = EcoreUtil.getURI(zdlgenModel);
		if (locationURI == null) {
			throw new IllegalArgumentException(
				"zdlgenModel is not in a resource"); //$NON-NLS-1$
		}

		zdlgenModels.put(nsURI, locationURI.trimFragment());
	}

	@Override
	public synchronized void unregisterModel(URI nsURI) {
		zdlgenModels.remove(nsURI);
	}

	/**
	 * An EMF-style registry reader that loads the registry extensions and
	 * stays current with changes.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class ZDLGenModelRegistryReader
			extends RegistryReader {

		/**
		 * Initializes me.
		 */
		public ZDLGenModelRegistryReader() {
			super(Platform.getExtensionRegistry(),
				com.zeligsoft.base.zdl.Activator.PLUGIN_ID,
				com.zeligsoft.base.zdl.Activator.DOMAIN_MODELS_EXTPT);
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			if (E_DOMAIN_MODEL.equals(element.getName())) {
				String uri = element.getAttribute(A_URI);
				if ((uri == null) || (uri.length() == 0)) {
					logMissingAttribute(element, A_URI);
					return false;
				}

				URI nsURI = URI.createURI(uri);

				if (add) {
					String path = element.getAttribute(A_GEN_MODEL);
					if ((path != null) && (path.length() > 0)) {
						URI locationURI = URI.createURI(path, true);
						if (locationURI.isRelative()) {
							String pluginID = element.getContributor().getName();
							locationURI = URI.createPlatformPluginURI(pluginID
								+ '/' + path, true);
						}
	
						synchronized (ZDLGenModelRegistryImpl.this) {
							zdlgenModels.put(nsURI, locationURI);
						}
					}
				} else {
					synchronized (ZDLGenModelRegistryImpl.this) {
						zdlgenModels.remove(nsURI);
					}
				}

				return true;
			}

			return false;
		}
	}
}
