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
package com.zeligsoft.base.toolingmodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegate Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.DelegateAction#getClassName <em>Class Name</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.DelegateAction#getHostBundle <em>Host Bundle</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getDelegateAction()
 * @model
 * @generated
 */
public interface DelegateAction extends MenuAction {

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getDelegateAction_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.DelegateAction#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Host Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host Bundle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host Bundle</em>' attribute.
	 * @see #setHostBundle(String)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getDelegateAction_HostBundle()
	 * @model
	 * @generated
	 */
	String getHostBundle();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.DelegateAction#getHostBundle <em>Host Bundle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Bundle</em>' attribute.
	 * @see #getHostBundle()
	 * @generated
	 */
	void setHostBundle(String value);
} // DelegateAction
