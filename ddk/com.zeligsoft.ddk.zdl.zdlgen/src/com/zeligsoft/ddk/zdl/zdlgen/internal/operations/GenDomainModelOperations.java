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

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.NamedElement;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackage;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPackageableElement;

/**
 * <!-- begin-user-doc --> A static utility class that provides operations
 * related to '<em><b>Gen Domain Model</b></em>' model objects. <!--
 * end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainModel#getDomainBlock(java.lang.String) <em>Get Domain Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainModelOperations extends GenDomainNamedElementOperations {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainModelOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static GenDomainBlock getDomainBlock(GenDomainModel genDomainModel, String qualifiedName) {
		GenDomainBlock result;

		String[] path = qualifiedName.split(NamedElement.SEPARATOR);

		result = getDomainBlockHelper(genDomainModel, path, 0);

		if (result == null) {
			// perhaps the first element of the path is my name?
			if ((path.length > 0) && UML2Util.safeEquals(path[0], genDomainModel.getName())) {
				result = getDomainBlockHelper(genDomainModel, path, 1);
			}
		}

		return result;
	}

	private static GenDomainBlock getDomainBlockHelper(GenDomainPackage genPackage, String[] path, int start) {
		GenDomainBlock result = null;

		GenDomainPackageableElement child;
		for (int i = start; i < path.length; i++) {
			result = null;
			child = genPackage.getElement(path[i]);

			if (child instanceof GenDomainBlock) {
				result = (GenDomainBlock) child;
			} else if (child instanceof GenDomainPackage) {
				genPackage = (GenDomainPackage) child;
			} else {
				break; // didn't find the result
			}
		}

		return result;
	}

} // GenDomainModelOperations
