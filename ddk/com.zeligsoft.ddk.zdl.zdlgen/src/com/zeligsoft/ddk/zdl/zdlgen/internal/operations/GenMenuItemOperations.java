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
package com.zeligsoft.ddk.zdl.zdlgen.internal.operations;

import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.common.util.CacheAdapter;

import com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Gen Menu Item</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenMenuItem#overridenBy() <em>Overriden By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenMenuItemOperations extends GenDomainObjectOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenMenuItemOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static GenMenuItem overridenBy(GenMenuItem genMenuItem) {
		GenMenuItem result = null;
		CacheAdapter cache = CacheAdapter.getCacheAdapter(genMenuItem);

		if (cache == null) {
			result = null;
		} else {
			List<EObject> inverseObjects = new UniqueEList<EObject>(4);
			for (EStructuralFeature.Setting setting : cache.getInverseReferences(genMenuItem)) {
				if (setting.getEStructuralFeature() == ZDLGenPackage.Literals.GEN_MENU_ITEM__OVERRIDES) {
					inverseObjects.add(setting.getEObject());
				}
			}
			if (inverseObjects.size() > 1) {
				throw new IllegalArgumentException(
						Messages.getString("GenMenuItemOperations_ERROR_Too_Many_Overrides") + genMenuItem.toString()); //$NON-NLS-1$
			}

			if (!inverseObjects.isEmpty()) {
				result = (GenMenuItem) inverseObjects.get(0);
			}
		}

		return result;
	}

} // GenMenuItemOperations