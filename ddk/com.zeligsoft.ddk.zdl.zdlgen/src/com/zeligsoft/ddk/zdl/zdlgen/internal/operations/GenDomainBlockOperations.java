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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockRelation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainClassifier;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Gen Domain Block</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlock#allClassifiers(com.zeligsoft.ddk.zdl.zdlgen.GenAllDomainCassifiersMode) <em>All Classifiers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenDomainBlockOperations extends GenDomainNamedElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainBlockOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<GenDomainClassifier> allClassifiers(GenDomainBlock genDomainBlock,
			GenAllDomainCassifiersMode mode) {

		EList<GenDomainClassifier> list = new BasicEList<GenDomainClassifier>();
		list.addAll(genDomainBlock.getClassifiers());

		switch (mode) {
		case MERGE:
		case MERGE_AND_IMPORT:
			for (@SuppressWarnings("unused")
			GenDomainBlockRelation merge : genDomainBlock.getMerges()) {
				//TODO: To be implemented in iteration 2
			}
			break;
		case FLAT:
			break;
		case IMPORT:
			break;
		}

		switch (mode) {
		case IMPORT:
		case MERGE_AND_IMPORT:
			for (GenDomainBlockRelation impord : genDomainBlock.getImports()) {
				if (impord.getTarget() != null) {
					list.addAll(impord.getTarget().allClassifiers(mode));
				}
			}
			break;
		case FLAT:
			break;
		case MERGE:
			break;
		}

		return list;
	}

} // GenDomainBlockOperations