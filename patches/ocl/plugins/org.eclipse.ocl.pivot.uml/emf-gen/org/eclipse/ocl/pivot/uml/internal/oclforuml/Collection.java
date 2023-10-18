/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies the null-free-ness of a Collection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Multiplicity Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Multiplicity Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #setBase_MultiplicityElement(MultiplicityElement)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollection_Base_MultiplicityElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MultiplicityElement getBase_MultiplicityElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #getBase_MultiplicityElement()
	 * @generated
	 */
	void setBase_MultiplicityElement(MultiplicityElement value);

	/**
	 * Returns the value of the '<em><b>Is Null Free</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the type of the TypedElement is a null-free Collection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Null Free</em>' attribute.
	 * @see #isSetIsNullFree()
	 * @see #unsetIsNullFree()
	 * @see #setIsNullFree(boolean)
	 * @see org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage#getCollection_IsNullFree()
	 * @model default="false" unsettable="true" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#isNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Null Free</em>' attribute.
	 * @see #isSetIsNullFree()
	 * @see #unsetIsNullFree()
	 * @see #isNullFree()
	 * @generated
	 */
	void setIsNullFree(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#isNullFree <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsNullFree()
	 * @see #isNullFree()
	 * @see #setIsNullFree(boolean)
	 * @generated
	 */
	void unsetIsNullFree();

	/**
	 * Returns whether the value of the '{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection#isNullFree <em>Is Null Free</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Null Free</em>' attribute is set.
	 * @see #unsetIsNullFree()
	 * @see #isNullFree()
	 * @see #setIsNullFree(boolean)
	 * @generated
	 */
	boolean isSetIsNullFree();

} // Collection
