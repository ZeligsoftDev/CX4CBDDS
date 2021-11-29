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

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Domain Block Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getTarget <em>Target</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainBlockReference <em>Domain Block Reference</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainSpecialization <em>Domain Specialization</em>}</li>
 * </ul>
 *
 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlockReference()
 * @model
 * @generated
 */
public interface GenDomainBlockReference extends GenDomainObject {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GenDomainBlock)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlockReference_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenDomainBlock getTarget();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GenDomainBlock value);

	/**
	 * Returns the value of the '<em><b>Domain Block Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Block Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Block Reference</em>' reference.
	 * @see #setDomainBlockReference(Dependency)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlockReference_DomainBlockReference()
	 * @model required="true"
	 * @generated
	 */
	Dependency getDomainBlockReference();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainBlockReference <em>Domain Block Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Block Reference</em>' reference.
	 * @see #getDomainBlockReference()
	 * @generated
	 */
	void setDomainBlockReference(Dependency value);

	/**
	 * Returns the value of the '<em><b>Domain Specialization</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainBlocks <em>Domain Block</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject#getOwner() <em>Owner</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Specialization</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Specialization</em>' container reference.
	 * @see #setDomainSpecialization(GenDomainSpecialization)
	 * @see com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage#getGenDomainBlockReference_DomainSpecialization()
	 * @see com.zeligsoft.ddk.zdl.zdlgen.GenDomainSpecialization#getDomainBlocks
	 * @model opposite="domainBlock" required="true" transient="false" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	GenDomainSpecialization getDomainSpecialization();

	/**
	 * Sets the value of the '{@link com.zeligsoft.ddk.zdl.zdlgen.GenDomainBlockReference#getDomainSpecialization <em>Domain Specialization</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Specialization</em>' container reference.
	 * @see #getDomainSpecialization()
	 * @generated
	 */
	void setDomainSpecialization(GenDomainSpecialization value);

} // GenDomainBlockReference
