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

/**
 * This interface is only useful to create a fake item
 * to match an existing facet item in a facet viewer.
 * To do that each implementation mimics the behavior of the equals and hashCode methods
 * of the corresponding items.
 *
 * @author mvelten
 * @author proland
 *
 */
public interface IMatchingItem {

	/**
	 * Mimics the corresponding class's equals method
	 *
	 * @param obj
	 *            the object to match
	 * @return true if the match is successful
	 */
	public boolean matchingItemEquals(Object obj);

	/**
	 * Mimics the corresponding class's hashcode method
	 *
	 * @return the hashcode
	 */
	public int matchingItemHashcode();
}
