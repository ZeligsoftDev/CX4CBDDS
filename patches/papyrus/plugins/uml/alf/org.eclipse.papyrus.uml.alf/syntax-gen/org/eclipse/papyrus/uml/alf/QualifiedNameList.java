/**
 */
package org.eclipse.papyrus.uml.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A group of qualified names.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.QualifiedNameList#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedNameList()
 * @model
 * @generated
 */
public interface QualifiedNameList extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.QualifiedName}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The names in the group.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getQualifiedNameList_Name()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<QualifiedName> getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Handle specially the cases of a specialization list and a redefinition list.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            let owner = self.owner() in\n              if owner.oclIsKindOf(ClassifierDefinition) then\n                owner.oclAsType(ClassifierDefinition).outerScope()\n              else if owner.oclIsKindOf(OperationDefinition) then\n                owner.oclAsType(OperationDefinition).containingMember().namespace.outerScope()\n              else\n                self.SyntaxElement_currentScope()\n              endif endif'"
	 * @generated
	 */
	ElementReference currentScope();

} // QualifiedNameList
