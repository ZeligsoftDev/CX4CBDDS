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
package com.zeligsoft.base.ui.utils;

import java.net.URL;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import com.zeligsoft.base.zdl.util.ZDLUtil;

/**
 * Registry of shared images defined by ZDL models.
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class ZDLImageRegistry {

	private static final ZDLImageRegistry INSTANCE = new ZDLImageRegistry();

	private ImageRegistry images = new ImageRegistry();

	/**
	 * Not instantiable by clients.
	 */
	private ZDLImageRegistry() {
		super();
	}

	/**
	 * Obtains the shared image registry.
	 * 
	 * @return the ZDL image registry
	 */
	public static ZDLImageRegistry getInstance() {
		return INSTANCE;
	}

	/**
	 * Obtains the ZDL icon for the specified model element, if any is defined
	 * for any of its concepts.
	 * 
	 * @param modelElement
	 *            an instance of a ZDL concept
	 * @return the icon of the first concept that is found to have an icon
	 *         (priority given to firm concept mappings), or <code>null</code>
	 *         if it has no icon
	 */
	public Image getZDLIcon(EObject modelElement) {
		Image result = null;

		for (Class concept : ZDLUtil.getZDLConcepts(modelElement)) {
			result = getIcon(concept);

			if (result != null) {
				break;
			}
		}

		return result;
	}

	/**
	 * Obtains the the icon for the specified domain <tt>concept</tt>, if
	 * any.
	 * 
	 * @param concept
	 *            the ZDL concept
	 * @return the concept's icon, or <code>null</code> if it has no icon
	 */
	public Image getIcon(Class concept) {
		String qname = concept.getQualifiedName();

		Image result = images.get(qname);

		if (result == null) {
			URL iconURL = ZDLUtil.getIcon(concept);

			if (iconURL != null && !UML2Util.isEmpty(iconURL.toString())) {
				ImageDescriptor desc = ImageDescriptor.createFromURL(iconURL);
				images.put(qname, desc);
				result = images.get(qname);
			}
		}

		return result;
	}

	/**
	 * Obtains the icon for the specified domain <tt>reference</tt>, if any.
	 * 
	 * @param reference
	 *            the source end of a ZDL domain reference association
	 * @return the reference's icon, or <code>null</code> if it has no icon
	 */
	public Image getIcon(Property reference) {
		String qname = reference.getQualifiedName();

		Image result = images.get(qname);

		if (result == null) {
			URL iconURL = ZDLUtil.getIcon(reference);

			if (iconURL != null && !UML2Util.isEmpty(iconURL.toString())) {
				ImageDescriptor desc = ImageDescriptor.createFromURL(iconURL);
				images.put(qname, desc);
				result = images.get(qname);
			}
		}

		return result;
	}
}
