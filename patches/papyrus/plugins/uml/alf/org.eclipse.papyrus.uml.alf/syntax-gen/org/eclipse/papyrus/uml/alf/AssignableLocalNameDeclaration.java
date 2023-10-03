/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable Local Name Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AssignableLocalNameDeclaration#getLocalNameDeclaration <em>Local Name Declaration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableLocalNameDeclaration()
 * @model
 * @generated
 */
public interface AssignableLocalNameDeclaration extends AssignableElement {
	/**
	 * Returns the value of the '<em><b>Local Name Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Name Declaration</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Name Declaration</em>' reference.
	 * @see #setLocalNameDeclaration(LocalNameDeclarationStatement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAssignableLocalNameDeclaration_LocalNameDeclaration()
	 * @model required="true"
	 * @generated
	 */
	LocalNameDeclarationStatement getLocalNameDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AssignableLocalNameDeclaration#getLocalNameDeclaration <em>Local Name Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Name Declaration</em>' reference.
	 * @see #getLocalNameDeclaration()
	 * @generated
	 */
	void setLocalNameDeclaration(LocalNameDeclarationStatement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.localNameDeclaration.type'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='0'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='if self.localNameDeclaration.hasMultiplicity then -1 else 1 endif'"
	 * @generated
	 */
	BigInteger upper();

} // AssignableLocalNameDeclaration
