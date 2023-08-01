/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.matching;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This code is used to ensure the same way to calculate hashcode
 *
 * @author Patrick Tessier
 *
 */
public class HashCodeCalculus {

	public static int getHashCode(EObject eObject) {
		return eObject.hashCode();
	}

	public static int getHashCode(EObject eObject, EReference eref) {
		final int hashPrime1 = 47;
		final int hashPrime2 = 13;
		return eref.hashCode() * hashPrime1 + eObject.hashCode() + hashPrime2;

	}
}
