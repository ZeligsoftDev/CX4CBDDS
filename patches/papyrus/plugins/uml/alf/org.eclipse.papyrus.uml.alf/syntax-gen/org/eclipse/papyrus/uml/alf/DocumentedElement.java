/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documented Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A syntax element that has documentation comments associated with it.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.DocumentedElement#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getDocumentedElement()
 * @model abstract="true"
 * @generated
 */
public interface DocumentedElement extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The documentation text to be associated with a syntax element. Each string is intended to be mapped to the body of a comment element in the target UML model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Documentation</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getDocumentedElement_Documentation()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getDocumentation();

} // DocumentedElement
