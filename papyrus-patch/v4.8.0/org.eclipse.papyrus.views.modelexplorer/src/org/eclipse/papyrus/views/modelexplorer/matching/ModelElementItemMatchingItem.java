/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *  Philippe Roland (Atos) philippe.roland@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.matching;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;

/***
 * An IMatchingItem implementation that matches for ModelElementItem
 *
 * @author proland
 */
public class ModelElementItemMatchingItem implements IMatchingItem {

	EObject element;

	public ModelElementItemMatchingItem(EObject currentEObject) {
		this.element = currentEObject;
	}

	public boolean matchingItemEquals(Object obj) {
		if (element != null && obj instanceof EObjectTreeElement) {
			return element == ((EObjectTreeElement) obj).getEObject();
		}
		return super.equals(obj);
	}

	public int matchingItemHashcode() {
		if (element != null) {
			return HashCodeCalculus.getHashCode(element);
		}
		return 0;
	}

}
