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
package com.zeligsoft.base.zdl;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Default implementation of the {@link DomainModelRegistry} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class DomainModelRegistryImpl
		implements DomainModelRegistry {

	private static final String E_DOMAIN_MODEL = "domainModel"; //$NON-NLS-1$

	private static final String A_URI = "uri"; //$NON-NLS-1$

	private static final String A_PATH = "path"; //$NON-NLS-1$

	private Map<URI, URI> domainModels = new java.util.HashMap<URI, URI>();

	/**
	 * Initializes me.
	 */
	protected DomainModelRegistryImpl() {
		new DomainModelRegistryReader().readRegistry();
	}

	public synchronized Model getModel(URI nsURI, ResourceSet rset) {
		Model result = null;
		URI locationURI = domainModels.get(nsURI);

		if (locationURI != null) {
			Resource resource = rset.getResource(locationURI, true);
			result = (Model) EcoreUtil.getObjectByType(resource.getContents(),
				UMLPackage.Literals.MODEL);
		}

		return result;
	}

	public synchronized void registerModel(Model zdlModel, URI nsURI) {
		if (nsURI == null) {
			throw new IllegalArgumentException("null nsURI"); //$NON-NLS-1$
		}
		
		URI locationURI = EcoreUtil.getURI(zdlModel);
		if (locationURI == null) {
			throw new IllegalArgumentException("zdlModel is not in a resource"); //$NON-NLS-1$
		}
		
		domainModels.put(nsURI, locationURI.trimFragment());
	}
	
	public synchronized void unregisterModel(URI nsURI) {
		domainModels.remove(nsURI);
	}
	
	public URI getNamespaceURI(Model zdlModel) {
		URI result = null;
		
		Resource resource = zdlModel.eResource();
		if (resource != null) {
			URI locationURI = EcoreUtil.getURI(zdlModel).trimFragment();
			
			URIConverter converter;
			if (resource.getResourceSet() != null) {
				converter = resource.getResourceSet().getURIConverter();
			} else {
				converter = new ExtensibleURIConverterImpl();
			}
			
			// use normalized URIs to ensure a canonical comparison
			locationURI = converter.normalize(locationURI);
			
			for (Map.Entry<URI, URI> entry : domainModels.entrySet()) {
				if (locationURI.equals(converter.normalize(entry.getValue()))) {
					result = entry.getKey();
					break;
				}
			}
		}
		
		return result;
	}

	/**
	 * An EMF-style extension point reader that loads the domain-model registry
	 * and stays up-to-date with it.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private class DomainModelRegistryReader
			extends RegistryReader {

		/**
		 * Initializes me.
		 */
		public DomainModelRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
				Activator.DOMAIN_MODELS_EXTPT);
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
					String path = element.getAttribute(A_PATH);
					if ((path == null) || (path.length() == 0)) {
						logMissingAttribute(element, A_PATH);
					}
	
					URI locationURI = URI.createURI(path, true);
					if (locationURI.isRelative()) {
						String pluginID = element.getContributor().getName();
						locationURI = URI.createPlatformPluginURI(pluginID + '/'
							+ path, true);
					}
	
					synchronized (DomainModelRegistryImpl.this) {
						domainModels.put(nsURI, locationURI);
					}
				} else {
					synchronized (DomainModelRegistryImpl.this) {
						domainModels.remove(nsURI);
					}
				}
				
				return true;
			}

			return false;
		}
	}
}
