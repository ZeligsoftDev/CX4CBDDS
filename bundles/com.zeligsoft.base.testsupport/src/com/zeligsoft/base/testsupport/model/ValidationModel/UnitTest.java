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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getName <em>Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getId <em>Id</em>}</li>
 *   <li>{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#isIsTested <em>Is Tested</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getUnitTest()
 * @model
 * @generated
 */
public interface UnitTest extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getUnitTest_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getUnitTest_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Is Tested</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Tested</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Tested</em>' attribute.
	 * @see #setIsTested(boolean)
	 * @see com.zeligsoft.base.testsupport.model.ValidationModel.ValidationModelPackage#getUnitTest_IsTested()
	 * @model
	 * @generated
	 */
	boolean isIsTested();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.testsupport.model.ValidationModel.UnitTest#isIsTested <em>Is Tested</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Tested</em>' attribute.
	 * @see #isIsTested()
	 * @generated
	 */
	void setIsTested(boolean value);

} // UnitTest
