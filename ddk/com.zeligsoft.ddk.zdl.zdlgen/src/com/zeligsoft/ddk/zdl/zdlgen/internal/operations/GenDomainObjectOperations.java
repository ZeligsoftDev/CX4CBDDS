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

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenModel;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Gen Domain Object</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getGenModel() <em>Get Gen Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainObjectOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainObjectOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static GenModel getGenModel(GenDomainObject genDomainObject) {
		GenModel result = null;
		EObject container = genDomainObject.eContainer();

		while (container != null) {
			if (container instanceof GenModel) {
				result = (GenModel) container;
				break;
			}
			container = container.eContainer();
		}

		return result;
	}

} // GenDomainObjectOperations