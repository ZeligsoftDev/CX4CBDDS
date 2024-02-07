/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to create or destroy the links of an association.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#isIsCreation <em>Is Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#isIsClear <em>Is Clear</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#getAssociationName <em>Association Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLinkOperationExpression()
 * @model
 * @generated
 */
public interface LinkOperationExpression extends InvocationExpression {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the link operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLinkOperationExpression_Operation()
	 * @model required="true"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Is Creation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operation is for link creation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Creation</em>' attribute.
	 * @see #setIsCreation(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLinkOperationExpression_IsCreation()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'createLink\''"
	 * @generated
	 */
	boolean isIsCreation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#isIsCreation <em>Is Creation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Creation</em>' attribute.
	 * @see #isIsCreation()
	 * @generated
	 */
	void setIsCreation(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the operation is clearing the association.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Clear</em>' attribute.
	 * @see #setIsClear(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLinkOperationExpression_IsClear()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.operation = \'clearAssoc\''"
	 * @generated
	 */
	boolean isIsClear();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#isIsClear <em>Is Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Clear</em>' attribute.
	 * @see #isIsClear()
	 * @generated
	 */
	void setIsClear(boolean value);

	/**
	 * Returns the value of the '<em><b>Association Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name of the association whose links are being acted on.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Association Name</em>' containment reference.
	 * @see #setAssociationName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLinkOperationExpression_AssociationName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getAssociationName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LinkOperationExpression#getAssociationName <em>Association Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Name</em>' containment reference.
	 * @see #getAssociationName()
	 * @generated
	 */
	void setAssociationName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.associationName.referent->select(isAssociation()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='null'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A link operation expression is for link creation if its operation is
	 * "createLink".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean linkOperationExpressionIsCreationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A link operation expression is for clearing an association if the
	 * operation is "clearAssoc".
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean linkOperationExpressionIsClearDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The referent for a link operation expression is the named association.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean linkOperationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There is no feature for a link operation expression.
	 * (See the feature() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean linkOperationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name of a link operation expression must resolve to a
	 * single association.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tself.referent <> null and \n\t-- Also check that the association owns all its ends.\n\tself.referent.properties()->forAll(isAssociationEnd())'"
	 * @generated
	 */
	boolean linkOperationExpressionAssociationReference(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each argument expression must be assignable to its corresponding
	 * expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      self.tuple.size() <= self.parameterCount() and\n      self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input))'"
	 * @generated
	 */
	boolean linkOperationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For a clear association operation, returns a single, typeless parameter.
	 * Otherwise, returns the ends of the named association.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.isClear then\n          OrderedSet(ElementReference){\n          FormalParameter{\n            direction = \'in\',\n            typePart = TypedElementDefinition{\n              lowerBound = \'1\',\n              upperBound = \'1\'\n            }\n          }.toReference()\n         }\n        else\n          let referent = self.referent in\n            if referent = null then OrderedSet(ElementReference){}\n            else\n              self.referent.associationEnds()->collect(property | \n                -- NOTE: Arguments for a link operation have multiplicity 1..1.\n                parameterFromPropertyWithMultiplicity(property, \'1\', \'1\')\n              )->asOrderedSet()\n            endif\n        endif'"
	 * @generated
	 */
	EList<ElementReference> parameterElements();

} // LinkOperationExpression
