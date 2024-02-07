/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A specification of the elements of a sequence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceElements#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceElements#getLower <em>Lower</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceElements()
 * @model abstract="true"
 * @generated
 */
public interface SequenceElements extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of the elements of the sequence. The
	 * derivation for this property is given in the subclasses of SequenceElements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(BigInteger)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceElements_Upper()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.upper()'"
	 * @generated
	 */
	BigInteger getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceElements#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of the elements of the sequence. The derivation
	 * for this property is given in the subclasses of SequenceElements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(BigInteger)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceElements_Lower()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.lower()'"
	 * @generated
	 */
	BigInteger getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceElements#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(BigInteger value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean conformsTo(ElementReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	BigInteger lower();

} // SequenceElements
