/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper for treating an element reference as an assignable element.
 * This is necessary to tie into the ownership hierarchy, so library
 * type resolution works correctly.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignableElementReference#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElementReference()
 * @model
 * @generated
 */
public interface AssignableElementReference extends AssignableElement {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableElementReference_Reference()
	 * @model required="true"
	 * @generated
	 */
	ElementReference getReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignableElementReference#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(ElementReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.reference.type()'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.reference.lower()'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.reference.upper()'"
	 * @generated
	 */
	BigInteger upper();

} // AssignableElementReference
