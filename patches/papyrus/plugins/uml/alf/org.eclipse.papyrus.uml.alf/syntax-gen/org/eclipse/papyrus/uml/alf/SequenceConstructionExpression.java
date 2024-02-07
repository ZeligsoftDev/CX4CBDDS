/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Construction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression used to construct a sequence of values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#isHasMultiplicity <em>Has Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceConstructionExpression()
 * @model
 * @generated
 */
public interface SequenceConstructionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specification of the elements in the sequence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference.
	 * @see #setElements(SequenceElements)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceConstructionExpression_Elements()
	 * @model containment="true"
	 * @generated
	 */
	SequenceElements getElements();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#getElements <em>Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elements</em>' containment reference.
	 * @see #getElements()
	 * @generated
	 */
	void setElements(SequenceElements value);

	/**
	 * Returns the value of the '<em><b>Has Multiplicity</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the sequence construction expression has a multiplicity indicator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Has Multiplicity</em>' attribute.
	 * @see #setHasMultiplicity(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceConstructionExpression_HasMultiplicity()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isHasMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#isHasMultiplicity <em>Has Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Multiplicity</em>' attribute.
	 * @see #isHasMultiplicity()
	 * @generated
	 */
	void setHasMultiplicity(boolean value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the type of the elements in the sequence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceConstructionExpression_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Is Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the sequence construction expression has an empty type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Any</em>' attribute.
	 * @see #setIsAny(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getSequenceConstructionExpression_IsAny()
	 * @model
	 * @generated
	 */
	boolean isIsAny();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.SequenceConstructionExpression#isIsAny <em>Is Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any</em>' attribute.
	 * @see #isIsAny()
	 * @generated
	 */
	void setIsAny(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this expression is contained in the element list of a sequence
	 * construction expression with a collection type, then return that type
	 * name. Otherwise return null.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let expression = self.enclosingExpression() in\n          if expression = null or \n            not expression.oclIsKindOf(SequenceConstructionExpression) then \n            null\n          else\n            let sequenceExpression = \n              expression.oclAsType(SequenceConstructionExpression) \n            in\n              if sequenceExpression.hasMultiplicity then null\n              else sequenceExpression.type\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference collectionType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.typeName <> null then\n          let referents = self.typeName.referent->select(isClassifier()) in\n            if referents->size() <> 1 then null\n            else referents->any(true)\n            endif\n        else\n          let collectionType = self.collectionType() in\n            if collectionType = null then null\n            else collectionType.collectionArgument()\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tif self.type = null then null\n\t\t\t\telse\n\t\t      let name = self.type.name() in\n\t\t      let operationReferents = type.ownedMembers()->select(name() = name and isOperation()) in\n\t\t        if operationReferents->size() <> 1 then null\n\t\t        else operationReferents->any(true).constructorReference()\n\t\t        endif\n\t\t\t  endif'"
	 * @generated
	 */
	ElementReference constructorReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.hasMultiplicity then 1\n        else if self.elements = null then 0 \n        else self.elements.upper\n        endif endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if not self.hasMultiplicity then 1\n        else if self.elements = null then 0 \n        else self.elements.lower\n        endif endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the type name of a sequence construction expression is not empty,
	 * then the type of the expression is the classifier to which the type name
	 * resolves.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceConstructionExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a sequence construction expression has multiplicity, then its
	 * multiplicity upper bound is given by its elements, if this is not empty,
	 * and zero otherwise. If a sequence construction expression does not have
	 * multiplicity, then its multiplicity upper bound is one.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceConstructionExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a sequence construction expression has multiplicity, then its
	 * multiplicity lower bound is given by its elements, if this is not empty,
	 * and zero otherwise. If a sequence construction expression does not have
	 * multiplicity, then its multiplicity lower bound is one.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceConstructionExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the type name of a sequence construction expression is not empty, then
	 * it must resolve to a non-template classifier. If the expression does not
	 * have multiplicity, then the type name must not be empty and the
	 * classifier to which it resolves must be the instantiation of a collection
	 * class.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        (self.typeName <> null implies self.type <> null) and\n        (not self.hasMultiplicity implies \n          self.type <> null and self.isCollectionClass(self.type)\n        )'"
	 * @generated
	 */
	boolean sequenceConstructionExpressionType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the elements of a sequence construction expression are given by a
	 * sequence range, then the expression must have type Integer. If the
	 * elements are given by a sequence element list, and the sequence
	 * construction expression has a non-empty type, then each expression in the
	 * list must have a type that either conforms to the type of the sequence
	 * construction expression or is convertible to it by bit string conversion.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.elements <> null implies \n          let type =\n            if self.hasMultiplicity or self.type = null then self.type\n            else self.type.collectionArgument() \n            endif\n          in\n            self.elements.conformsTo(type)'"
	 * @generated
	 */
	boolean sequenceConstructionExpressionElementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the elements of a sequence construction expression are given by a
	 * sequence expression list, then the assignments before the first
	 * expression in the list are the same as the assignments before the
	 * sequence construction expression, and the assignments before each
	 * subsequent expression are the assignments after the previous expression.
	 * If the elements are given by a sequence range, the assignments before
	 * both expressions in the range are the same as the assignments before the
	 * sequence construction expression.
	 * (See the SyntaxElement::assignmentsBefore(element) operation. See also
	 * the SequenceExpressionList::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sequenceConstructionExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the elements of the sequence construction expression are given by a
	 * sequence expression list, then return the assignments after the last
	 * expression in the list (if the list is empty, then return the assignments
	 * before the sequence construction expression). If the elements are given
	 * by a sequence range, then return the union of the assignments after each
	 * of the expressions in the range.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.elements = null then self.assignmentBefore\n        else self.elements.assignmentsAfter()\n        endif'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // SequenceConstructionExpression
