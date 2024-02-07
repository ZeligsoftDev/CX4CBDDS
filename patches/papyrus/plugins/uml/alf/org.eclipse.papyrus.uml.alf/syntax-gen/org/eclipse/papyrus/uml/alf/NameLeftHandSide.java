/**
 */
package org.eclipse.papyrus.uml.alf;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A left-hand side that is a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameLeftHandSide#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.NameLeftHandSide#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameLeftHandSide()
 * @model
 * @generated
 */
public interface NameLeftHandSide extends LeftHandSide {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name that is the target of the assignment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameLeftHandSide_Target()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameLeftHandSide#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An optional expression that evaluates to an index into the values of an
	 * ordered sequence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getNameLeftHandSide_Index()
	 * @model containment="true"
	 * @generated
	 */
	Expression getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.NameLeftHandSide#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.target'"
	 * @generated
	 */
	QualifiedName target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.index'"
	 * @generated
	 */
	Expression index();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let feature = self.feature() in\n          if feature <> null then\n            let referents = feature.referent->select(isProperty()) in\n              if referents->size() <> 1 then null\n              else referents->any(true)\n              endif\n          else\n            let oldAssignment = self.oldAssignment() in\n              if oldAssignment = null then null\n              else\n                let parameterReferent = self.parameterReferent() in\n                  if parameterReferent <> null then parameterReferent\n                  else oldAssignment.source.toReference()\n                  endif \n              endif\n          endif'"
	 * @generated
	 */
	ElementReference referent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.target().referent->select(isParameter()) in\n          if referents->size() <> 1 then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	ElementReference parameterReferent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let oldAssignment = self.oldAssignment() in\n          if oldAssignment = null then self.LeftHandSide_type()\n          else oldAssignment.type\n          endif'"
	 * @generated
	 */
	ElementReference type();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let oldAssignment = self.oldAssignment() in\n          if self.index <> null or oldAssignment = null then \n            self.LeftHandSide_upper()\n          else oldAssignment.upper\n          endif'"
	 * @generated
	 */
	BigInteger upper();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let oldAssignment = self.oldAssignment() in\n          if self.index <> null or oldAssignment = null then \n            self.LeftHandSide_lower()\n          else oldAssignment.lower\n          endif'"
	 * @generated
	 */
	BigInteger lower();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referents = self.assignmentBefore->select(name = self.localName()) in\n          if referents->isEmpty() then null\n          else referents->any(true)\n          endif'"
	 * @generated
	 */
	AssignedSource oldAssignment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.target().disambiguation'"
	 * @generated
	 */
	FeatureReference feature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tlet expression = self.primary() in\n\t\t\t\t\tif self.index = null then expression\n\t\t\t\t\telse\n\t\t\t\t\t\tSequenceAccessExpression{\n\t\t\t\t\t\t\tprimary = expression,\n\t\t\t\t\t\t\tindex = index.reference(),\n\t\t\t\t\t\t\towner = self\n\t\t\t\t\t\t}\n\t\t\t\t\tendif'"
	 * @generated
	 */
	Expression expression();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\t\tlet feature = self.feature() in\n\t\t\t\tif feature = null then\n\t\t\t\t\tNameExpression{\n\t\t\t\t\t\tname = self.target.copy(),\n\t\t\t\t\t\towner = self\n\t\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\tPropertyAccessExpression{\n\t\t\t\t\t\tfeature = feature,\n\t\t\t\t\t\towner = self\n\t\t\t\t\t}\n\t\t\t\tendif'"
	 * @generated
	 */
	Expression primary();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.feature() <> null then null\n        else self.target().unqualifiedName.toName()\n        endif'"
	 * @generated
	 */
	String localName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name left-hand side has an index, then the assignments after the
	 * left-hand side are the same as the assignments after the index. If the
	 * left-hand side has no index, but its target disambiguates to a feature
	 * reference, then the assignments after the left-hand side are the
	 * assignments after the feature expression. Otherwise the assignments
	 * after the left-hand side are the same as the assignments before the
	 * left-hand side.
	 * (See the LeftHandSide::assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameLeftHandSideAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target of a name left hand side may not already have an assigned
	 * source that is a loop variable definition, an annotation, a sequence
	 * expansion expression or a parameter that is an in parameter.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let referent = self.referent in\n          if referent = null then true\n          else if referent.isParameter() then\n            referent.direction() <> \'in\'\n          else if referent.isProperty() then\n            let expression = self.feature().expression in\n              -- This condition ensures that there will be an assigned name\n              -- for an assignment to an attribute of a data type.\n              expression.type.isDataType() implies self.isDataValueUpdate()\n          else\n            not (referent.isLoopVariable() or\n                 referent.isAnnotation() or\n                 referent.isSequenceExpansionExpression()\n            )\n          endif endif endif'"
	 * @generated
	 */
	boolean nameLeftHandSideTargetAssignment(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target of a name left-hand side disambiguates to a feature
	 * reference, then the assignments before the expression of the feature
	 * reference are the assignments before the left-hand side. If a name
	 * left-hand side has an index, then the target must either disambiguate
	 * to a feature reference or already have an assigned source, and the
	 * assignments before the index expression are the assignments before the
	 * left-hand side or, if the target disambiguates to a feature reference,
	 * the assignments after the expression of the feature reference.
	 * (See also the LeftHandSide::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.index <> null implies \n          (self.feature() <> null or self.oldAssignment() <> null)'"
	 * @generated
	 */
	boolean nameLeftHandSideAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target of a name left-hand side disambiguates to a structural
	 * feature, then the referent of the left-hand side is that feature. If the
	 * target resolves to a parameter, then the referent is that parameter. If
	 * the target resolves to a local name, then the referent is the assigned
	 * source for that local name, if it has one.
	 * (See the referent() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameLeftHandSideReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name left-hand side is indexed, then its lower bound is 1.
	 * Otherwise, if the left-hand side is for a local name with an assignment,
	 * than its lower bound is that of the assignment, else, if it has a
	 * referent, then its lower bound is that of the referent.
	 * (See the lower() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameLeftHandSideLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name left-hand side is indexed, then its upper bound is 1.
	 * Otherwise, if the left-hand side is for a local name with an assignment,
	 * than its upper bound is that of the assignment, else, if it has a
	 * referent, then its upper bound is that of the referent.
	 * (See the upper() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameLeftHandSideUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a name left-hand side is for a local name with an assignment, then its
	 * type is that of that assignment. Otherwise, if the left-hand side has a
	 * referent, then its type is the type of that referent.
	 * (See the type() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean nameLeftHandSideTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target of a name left-hand side is qualified, then, if it does not
	 * disambiguate to a feature, it must have a referent that is a parameter of
	 * an operation or behavior that is the current scope the left-hand is in,
	 * and, if it does disambiguate to a feature, it must have a single referent
	 * that is a structural feature.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.target().qualification <> null implies\n        let referent = self.referent in\n          referent <> null and referent.isParameter() or\n          let feature = self.feature() in\n            feature <> null and \n              -- TODO: This should be a separate constraint.\n              feature.expression.upper = 1'"
	 * @generated
	 */
	boolean nameLeftHandSideTargetResolution(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the target of a name left-hand side disambiguates to a feature
	 * reference, and the left-hand side has an index, then the referent of the
	 * feature reference must be ordered and non-unique.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.index() <> null implies\n          let referent = self.referent in\n            referent <> null and referent.isFeature() implies\n              referent.isOrdered() and referent.isNonunique()'"
	 * @generated
	 */
	boolean nameLeftHandSideIndexedFeature(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target of a name left-hand side must not have a template binding.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.target.templateName = null'"
	 * @generated
	 */
	boolean nameLeftHandSideNontemplateTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

} // NameLeftHandSide
