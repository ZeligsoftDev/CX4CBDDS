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
package com.zeligsoft.ddk.zdl.zdlgen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainAttribute()
 * @model
 * @generated
 */
public interface GenDomainAttribute extends GenDomainStructuralFeature {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(GenDomainDataType)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainAttribute_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenDomainDataType getType();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(GenDomainDataType value);

} // GenDomainAttribute
