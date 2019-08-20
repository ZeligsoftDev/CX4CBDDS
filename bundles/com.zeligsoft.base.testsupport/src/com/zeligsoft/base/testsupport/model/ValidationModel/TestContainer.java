/**
 * Copyright 2018 ADLINK Technology Limited.
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
 *
 */
package com.zeligsoft.base.testsupport.model.ValidationModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.testsupport.model.ValidationModel.TestContainer#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getTestContainer()
 * @model
 * @generated
 */
public interface TestContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getTestContainer_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitTest> getTests();

} // TestContainer
