/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The definition of a loop variable in a for statement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isTypeIsInferred <em>Type Is Inferred</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsFirst <em>Is First</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition()
 * @model
 * @generated
 */
public interface LoopVariableDefinition extends SyntaxElement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_Variable()
	 * @model required="true"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

	/**
	 * Returns the value of the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If there is only one expression, then this expression is evaluated to produce a sequence of values to be assigned to the loop variable on successive iterations. Otherwise it is evaluated to provide the first value of a range of values to be assigned to the loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression1</em>' containment reference.
	 * @see #setExpression1(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_Expression1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression1();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getExpression1 <em>Expression1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression1</em>' containment reference.
	 * @see #getExpression1()
	 * @generated
	 */
	void setExpression1(Expression value);

	/**
	 * Returns the value of the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to give the second value in a range of values to be assigned to the loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression2</em>' containment reference.
	 * @see #setExpression2(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_Expression2()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression2();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getExpression2 <em>Expression2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression2</em>' containment reference.
	 * @see #getExpression2()
	 * @generated
	 */
	void setExpression2(Expression value);

	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declared type of the loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Type Is Inferred</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the type of the variable is inferred or declared explicitly.
	 * NOTE: This flag is necessary to because a variable that is explicitly
	 * declared to have type "any" will have an empty typeName,
	 * just like a variable whose type is to be inferred, but, in the former
	 * case, the type is actually intended to be empty, not inferred.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Is Inferred</em>' attribute.
	 * @see #setTypeIsInferred(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_TypeIsInferred()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isTypeIsInferred();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isTypeIsInferred <em>Type Is Inferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Is Inferred</em>' attribute.
	 * @see #isTypeIsInferred()
	 * @generated
	 */
	void setTypeIsInferred(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Collection Conversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether collection conversion is required.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #setIsCollectionConversion(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_IsCollectionConversion()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n      let type = self.type in\n        type <> null and self.isCollectionClass(type) and\n          self.expression1 <> null and self.expression1.upper <= 1'"
	 * @generated
	 */
	boolean isIsCollectionConversion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsCollectionConversion <em>Is Collection Conversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collection Conversion</em>' attribute.
	 * @see #isIsCollectionConversion()
	 * @generated
	 */
	void setIsCollectionConversion(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declared or inferred type of the loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_Type()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n      if self.typeIsInferred then expression1.type\n      else if self.typeName = null then null\n      else self.typeName.referent->any(isClassifier())\n      endif endif'"
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is First</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this definition is the first in the list of definitions in the
	 * enclosing for statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is First</em>' attribute.
	 * @see #setIsFirst(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_IsFirst()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.enclosingStatement().oclAsType(ForStatement).variableDefinition->at(1) = self'"
	 * @generated
	 */
	boolean isIsFirst();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsFirst <em>Is First</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is First</em>' attribute.
	 * @see #isIsFirst()
	 * @generated
	 */
	void setIsFirst(boolean value);

	/**
	 * Returns the value of the '<em><b>Assignment Before</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically before this loop
	 * variable definition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment Before</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_AssignmentBefore()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.assignmentsBefore()'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentBefore();

	/**
	 * Returns the value of the '<em><b>Assignment After</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.AssignedSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assigned sources for local names available lexically after this loop
	 * variable definition. This includes not only any assignments made within
	 * the statement, but also any assignments that are unchanged from before
	 * the statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assignment After</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_AssignmentAfter()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n      let assignmentsAfter =\n        if self.expression2 = null then \n          self.expression1.assignmentAfter\n        else \n          self.updateAll(\n            self.expression1.assignmentAfter,\n            self.expression2.newAssignments()\n          )\n        endif\n      in\n        AssignedSource{\n          name = self.variable,\n          source = self,\n          type = \n            if self.isCollectionConversion then self.type.collectionArgument() \n            else self.type \n            endif,\n          lower = if self.isFirst then 1 else 0 endif,\n          upper = 1\n        }.update(assignmentsAfter)'"
	 * @generated
	 */
	EList<AssignedSource> getAssignmentAfter();

	/**
	 * Returns the value of the '<em><b>Is Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the loop variable has an empty type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Any</em>' attribute.
	 * @see #setIsAny(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLoopVariableDefinition_IsAny()
	 * @model
	 * @generated
	 */
	boolean isIsAny();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LoopVariableDefinition#isIsAny <em>Is Any</em>}' attribute.
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
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NameBinding{name=self.variable}.toName()'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the assignments made within this loop variable definition.
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let assignmentsBefore = self.assignmentBefore in\n          self.assignmentAfter->select(isNew(assignmentsBefore))'"
	 * @generated
	 */
	EList<AssignedSource> newAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a loop variable definition include the assignments
	 * after the expression (or expressions) of the definition plus a new
	 * assigned source for the loop variable itself. The assigned source for the
	 * loop variable is the loop variable definition. The multiplicity upper
	 * bound for the variable is 1. The multiplicity lower bound is 1 if the
	 * loop variable definition is the first in a for statement and 0 otherwise.
	 * If collection conversion is not required, then the variable has the
	 * inferred or declared type from the definition. If collection conversion
	 * is required, then the variable has the argument type of the collection
	 * class.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean loopVariableDefinitionAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expressions of a loop variable definition are
	 * the assignments before the loop variable definition.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean loopVariableDefinitionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a loop variable definition has two expressions, then both expressions
	 * must have type Integer and a multiplicity upper bound of 1, and no name
	 * may be newly assigned or reassigned in more than one of the expressions.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.expression2 = null then true\n        else\n          let type1 = self.expression1.type in\n          let type2 = self.expression2.type in\n            type1 <> null and self.isIntegerType(type) and self.expression1.upper = 1 and\n            type2 <> null and self.isIntegerType(type) and self.expression2.upper = 1 and\n            expression1.newAssignments().name->excludesAll(expression2.newAssignments().name)\n        endif'"
	 * @generated
	 */
	boolean loopVariableDefinitionRangeExpressions(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a loop variable definition has a type name, then this name must
	 * resolve to a non-template classifier.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.typeName = null then true\n        else\n          let referents = self.typeName.referent->select(isClassifier()) in\n            referents->size() = 1 and not referents->exists(isTemplate())\n        endif'"
	 * @generated
	 */
	boolean loopVariableDefinitionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the type of a loop variable is not inferred, then the variable has the
	 * type denoted by the type name, if it is not empty, and is untyped
	 * otherwise. If the type is inferred, them the variable has the same type
	 * as the expression in its definition.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean loopVariableDefinitionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the type of a loop variable definition is not inferred, then the first
	 * expression of the definition must have a type that conforms to the
	 * declared type.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        if self.typeIsInferred then true\n        else self.expression1.type.conformsTo(self.type)\n        endif'"
	 * @generated
	 */
	boolean loopVariableDefinitionDeclaredType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Collection conversion is required for a loop variable definition if the
	 * type for the definition is the instantiation of a collection class and
	 * the multiplicity upper bound of the first expression is no greater than 1.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean loopVariableDefinitionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable name given in a loop variable definition must be unassigned
	 * after the expression or expressions in the definition.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.expression1.assignmentAfter.name->excludes(self.actualName()) and\n        self.expression2 <> null implies\n          self.expression2.assignmentAfter.name->excludes(self.actualName())'"
	 * @generated
	 */
	boolean loopVariableDefinitionVariable(DiagnosticChain diagnostics, Map<Object, Object> context);

} // LoopVariableDefinition
