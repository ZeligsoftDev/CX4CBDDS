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
 * A representation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.Stack#getActiveTool <em>Active Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getStack()
 * @model
 * @generated
 */
public interface Stack extends Tool, ToolContainer {

	/**
	 * Returns the value of the '<em><b>Active Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Tool</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Tool</em>' reference.
	 * @see #setActiveTool(Tool)
	 * @see com.zeligsoft.base.toolingmodel.ToolingModelPackage#getStack_ActiveTool()
	 * @model
	 * @generated
	 */
	Tool getActiveTool();

	/**
	 * Sets the value of the '{@link com.zeligsoft.base.toolingmodel.Stack#getActiveTool <em>Active Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Tool</em>' reference.
	 * @see #getActiveTool()
	 * @generated
	 */
	void setActiveTool(Tool value);

} // Stack
