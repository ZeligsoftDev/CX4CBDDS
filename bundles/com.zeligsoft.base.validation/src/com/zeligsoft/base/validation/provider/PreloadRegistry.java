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
package com.zeligsoft.base.validation.provider;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import com.zeligsoft.base.validation.Activator;
import com.zeligsoft.base.validation.l10n.Messages;
import com.zeligsoft.base.zdl.ZDLNames;
import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Registry reader for the <tt>com.zeligsoft.base.validation.preload</tt>
 * extension point.
 * 
 * @author Christian W. Damus (cdamus)
 */
class PreloadRegistry
		extends RegistryReader {

	private static final String EXT_PT = "preload"; //$NON-NLS-1$

	private static final String E_ZDL = "zdl"; //$NON-NLS-1$

	private static final String A_URI = "uri"; //$NON-NLS-1$

	static final PreloadRegistry INSTANCE = new PreloadRegistry();

	private ResourceSet rset;

	/**
	 * Initializes me.
	 */
	private PreloadRegistry() {
		super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_PT);
	}

	@Override
	public void readRegistry() {
		rset = new ResourceSetImpl();

		super.readRegistry();

		destroy(rset);
	}

	private void destroy(ResourceSet rset) {
		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
		rset = null;
	}

	@Override
	protected boolean readElement(IConfigurationElement element) {
		if (E_ZDL.equals(element.getName())) {
			String uriString = element.getAttribute(A_URI);

			if (UML2Util.isEmpty(uriString)) {
				logMissingAttribute(element, A_URI);
				return false;
			} else {
				try {
					preload(URI.createURI(uriString));
				} catch (Exception e) {
					Activator.getDefault().error(
						Messages.PreloadRegistry_badURI, e);
				}
			}

			return true;
		}

		return false;
	}

	private void preload(URI uri) {
		boolean cleanupResourceSet = false;

		if (rset == null) {
			// this happens when processing dynamic extension additions
			rset = new ResourceSetImpl();
			cleanupResourceSet = true;
		}

		Resource res = rset.getResource(uri, true);
		Package zdlModel = (Package) EcoreUtil.getObjectByType(res
			.getContents(), UMLPackage.Literals.PACKAGE);

		for (TreeIterator<EObject> iter = zdlModel.eAllContents(); iter
			.hasNext();) {
			EObject next = iter.next();

			if (next instanceof Class) {
				Class concept = (Class) next;

				if (ZDLUtil.isZDLConcept(concept, ZDLNames.DOMAIN_CONCEPT)) {
					try {
						ZDLConstraintManager.getInstance().getConstraints(
							concept);
					} catch (Exception e) {
						Activator.getDefault().error(
							NLS.bind(Messages.PreloadRegistry_badConcept, uri,
								concept.getQualifiedName()), e);
					}
				}

				iter.prune();
			} else if(ZDLUtil.isZDLConcept(next, ZDLNames.DOMAIN_BLOCK)) {
				// load any of the constraints that are not
				// owned by a domain concept but rather by a 
				// domain block
				ZDLConstraintManager.getInstance()
								.loadConstraints((Package) next);
			}
			else if (!(next instanceof Package)) {
				iter.prune();
			}
		}

		if (cleanupResourceSet) {
			destroy(rset);
		}
	}
}
