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
package com.zeligsoft.ddk.zdl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.resources.IPathmapManager;


/**
 * Utilities for working with GMF's path-map URIs and the
 * {@linkplain IPathmapManager pathmap manager}.
 *
 * @author Christian W. Damus (cdamus)
 */
public class PathmapUtil {

	/**
	 * Not instantiable by clients.
	 */
	private PathmapUtil() {
		super();
	}

	/**
	 * Enables pathmap URI management in the GMF style on the specified
	 * resource-set.
	 * 
	 * @param rset a resource set
	 */
	public static void enablePathmaps(ResourceSet rset) {
		TransactionalEditingDomain domain = GMFEditingDomainFactory
			.getInstance().createEditingDomain();

		if (domain != null) {
			for (Adapter next : domain.getResourceSet().eAdapters()) {
				if (next instanceof IPathmapManager) {
					// move the adapter
					domain.getResourceSet().eAdapters().remove(next);
					rset.eAdapters().add(next);
					break;
				}
			}
		}
	}

}
