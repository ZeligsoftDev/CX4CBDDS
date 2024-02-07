/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotated Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AnnotatedStatement#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.AnnotatedStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAnnotatedStatement()
 * @model
 * @generated
 */
public interface AnnotatedStatement extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The annotations applied to this statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Annotation</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAnnotatedStatement_Annotation()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='BoundClassifier' unique='false' upper='*'"
	 * @generated
	 */
	EList<String> getAnnotation();

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(Statement)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getAnnotatedStatement_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.AnnotatedStatement#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * External
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> annotations();

} // AnnotatedStatement
