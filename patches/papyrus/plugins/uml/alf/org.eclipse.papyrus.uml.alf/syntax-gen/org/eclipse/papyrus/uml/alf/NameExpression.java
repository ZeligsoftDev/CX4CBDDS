/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An expression that comprises a name reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameExpression#getEnumerationLiteral <em>Enumeration Literal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameExpression#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameExpression#getPropertyAccess <em>Property Access</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameExpression#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameExpression()
 * @model
 * @generated
 */
public interface NameExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Enumeration Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The identified enumeration literal, if the referenced name is for an enumeration literal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enumeration Literal</em>' reference.
	 * @see #setEnumerationLiteral(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameExpression_EnumerationLiteral()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.name.isFeatureReference then null\n        else\n          let referents = self.name.referent->select(isEnumerationLiteral()) in\n            if referents->size() <> 1 then null\n            else referents->any(true)\n            endif\n        endif'"
	 * @generated
	 */
	ElementReference getEnumerationLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameExpression#getEnumerationLiteral <em>Enumeration Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration Literal</em>' reference.
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	void setEnumerationLiteral(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned source for the referenced name, if the name is a local or
	 * parameter name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment</em>' reference.
	 * @see #setAssignment(AssignedSource)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameExpression_Assignment()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n      if self.name.isFeatureReference then null\n      else\n        let localName = self.name.unqualifiedName.toName() in\n          if name.qualification = null then\n            self.assignmentFor(localName)\n          else\n            let parameterReferent = self.parameterReferent() in\n              if parameterReferent <> null and \n                  parameterReferent.namespace().equals(self.currentScope()) then\n                self.assignmentFor(localName)\n              else\n                null\n              endif\n          endif\n      endif'"
	 * @generated
	 */
	AssignedSource getAssignment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameExpression#getAssignment <em>Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' reference.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(AssignedSource value);

	/**
	 * Returns the value of the '<em><b>Property Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The equivalent property access expression, if the referenced name
	 * disambiguates to a feature reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property Access</em>' reference.
	 * @see #setPropertyAccess(PropertyAccessExpression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameExpression_PropertyAccess()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        let disambiguation = self.name.disambiguation in\n          if disambiguation = null then null\n          else\n            PropertyAccessExpression{\n              featureReference = disambiguation,\n              owner = self\n            } \n          endif'"
	 * @generated
	 */
	PropertyAccessExpression getPropertyAccess();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameExpression#getPropertyAccess <em>Property Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Access</em>' reference.
	 * @see #getPropertyAccess()
	 * @generated
	 */
	void setPropertyAccess(PropertyAccessExpression value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The qualified name referenced in this expression. (For a local name, this
	 * will actually have no qualification.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameExpression_Name()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualifiedName getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameExpression#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(QualifiedName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignment = self.assignment in\n          if assignment <> null then assignment.type\n          else\n            let enumerationLiteral = self.enumerationLiteral in\n              if enumerationLiteral <> null then enumerationLiteral.type()\n              else\n                let propertyAccess = self.propertyAccess in\n                  if propertyAccess <> null then propertyAccess.type\n                  else null\n                  endif\n              endif\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n       let assignment = self.assignment in\n          if assignment <> null then assignment.upper\n          else\n            let enumerationLiteral = self.enumerationLiteral in\n              if enumerationLiteral <> null then 1\n              else\n                let propertyAccess = self.propertyAccess in\n                  if propertyAccess <> null then propertyAccess.upper\n                  else 1 -- Note: This ensures a name defined as an \"out\" argument is not considered null.\n                  endif\n              endif\n          endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n       let assignment = self.assignment in\n          if assignment <> null then assignment.lower\n          else\n            let enumerationLiteral = self.enumerationLiteral in\n              if enumerationLiteral <> null then 1\n              else\n                let propertyAccess = self.propertyAccess in\n                  if propertyAccess <> null then propertyAccess.lower\n                  else 0\n                  endif\n              endif\n          endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let referents = self.name.referent->select(isParameter()) in\n        if referents->size() <> 1 then null\n        else referents->any(true)\n        endif'"
	 * @generated
	 */
	ElementReference parameterReferent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the source of a local name is a For Statement, it must be a @parallel
	 * local name and it is only legal if this name expression is the target of
	 * a CollectionFunctions::add invocation.
	 * <!-- end-model-doc -->
	 * @model localNameRequired="true"
	 * @generated
	 */
	AssignedSource assignmentFor(String localName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model localNameRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let assignments = self.assignmentBefore->select(name = localName) in\n        if assignments->isEmpty() or \n           assignments->forAll(isParallelLocalName) and not self.isAddTargetName()\n        then \n          null\n        else \n          assignments->any(true)\n        endif'"
	 * @generated
	 */
	AssignedSource assignmentFor_(String localName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n      let expression = self.enclosingExpression() in\n        if expression = null then false\n        else expression.isAddTarget(self)\n        endif'"
	 * @generated
	 */
	boolean isAddTargetName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the name in a name expression is a local or parameter name, then its
	 * assignment is its assigned source before the expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionAssignmentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the name in a name expression resolves to an enumeration literal name,
	 * then that is the enumeration literal for the expression.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionEnumerationLiteralDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the name in a name expression disambiguates to a feature reference,
	 * then the equivalent property access expression has the disambiguation of
	 * the name as its feature. The assignments before the property access
	 * expression are the same as those before the name expression.
	 * (See also the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionPropertyAccessDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a name expression is determined by its name. If the name is a
	 * local name or parameter with an assignment, then the type of the name
	 * expression is the type of that assignment. If the name is an enumeration
	 * literal, then the type of the name expression is the corresponding
	 * enumeration. If the name disambiguates to a feature reference, then the
	 * type of the name expression is the type of the equivalent property access
	 * expression.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity upper bound of a name expression is determined by its
	 * name.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The multiplicity lower bound of a name expression is determined by its
	 * name.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the name referenced by this expression is not a disambiguated feature
	 * reference or a local or parameter name, then it must resolve to exactly
	 * one enumeration literal.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.validateNameExpressionResolution()'"
	 * @generated
	 */
	boolean nameExpressionResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.propertyAccess <> null or \n        self.assignment <> null and self.assignment.source <> null or \n        self.enumerationLiteral <> null or\n        -- NOTE: The following allows the name of a name expression that is an\n        -- an argument of an out parameter to be unassigned.\n        let owner = \n          if self.owner().oclIsKindOf(NamedExpression) then self.owner().owner()\n          else self.owner()\n          endif\n        in\n          owner.oclIsKindOf(_\'Tuple\') and\n          owner.oclAsType(_\'Tuple\').output->exists(\n            expression = self and\n            owner.oclAsType(_\'Tuple\').invocation.parameterNamed(name).direction() = \'out\'\n          )'"
	 * @generated
	 */
	boolean validateNameExpressionResolution();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If propertyAccess is not empty (i.e., if the referenced name disambiguates
	 * to a feature reference), then return the assignments after the
	 * property access expression. Otherwise, return the result of the superclass
	 * updateAssignments operation.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n                let propertyAccess = self.propertyAccess in\n                  if propertyAccess <> null then propertyAccess.assignmentAfter\n                  else self.Expression_updateAssignments()\n                  endif'"
	 * @generated
	 */
	EList<AssignedSource> updateAssignments();

} // NameExpression
