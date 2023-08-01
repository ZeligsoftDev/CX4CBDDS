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


/***
 * An IMatchingItem implementation that matches for IReferencables
 *
 * @author proland
 */
public class ReferencableMatchingItem implements IMatchingItem {

	Object object;

	public ReferencableMatchingItem(Object object) {
		this.object = object;
	}

	public boolean matchingItemEquals(Object obj) {
		if (obj instanceof IReferencable) {
			IReferencable referencable = (IReferencable) obj;
			return referencable.getElementBehind().equals(object);
		}
		return super.equals(obj);
	}

	public int matchingItemHashcode() {
		if (object != null) {
			return object.hashCode();
		}
		return 0;
	}

}
