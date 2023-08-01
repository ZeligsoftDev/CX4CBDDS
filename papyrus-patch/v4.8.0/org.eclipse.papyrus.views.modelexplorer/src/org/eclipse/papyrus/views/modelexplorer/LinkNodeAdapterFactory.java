/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Philippe ROLAND (Atos) - initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;

/**
 * This factory returns a LinkNode instance for any adapter instancing LinkItem or EReference
 *
 * @author proland
 *
 */
public class LinkNodeAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == LinkNode.class) {
			if (adaptableObject instanceof EReferenceTreeElement || adaptableObject instanceof EReference) {
				return LinkNode.LinkNodeInstance;
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] {};
	}

}
