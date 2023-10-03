/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classify Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement that changes the classification of an object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getFromList <em>From List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getToList <em>To List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getFromClass <em>From Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getToClass <em>To Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#isIsReclassifyAll <em>Is Reclassify All</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement()
 * @model
 * @generated
 */
public interface ClassifyStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to obtain the object to be reclassified.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>From List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of names of classes to be removed as types of the object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From List</em>' containment reference.
	 * @see #setFromList(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_FromList()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedNameList getFromList();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getFromList <em>From List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From List</em>' containment reference.
	 * @see #getFromList()
	 * @generated
	 */
	void setFromList(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>To List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of names of classes to be added as types of the object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To List</em>' containment reference.
	 * @see #setToList(QualifiedNameList)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_ToList()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedNameList getToList();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#getToList <em>To List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To List</em>' containment reference.
	 * @see #getToList()
	 * @generated
	 */
	void setToList(QualifiedNameList value);

	/**
	 * Returns the value of the '<em><b>From Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classes denoted by the names in the from list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Class</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_FromClass()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.fromList = null then Set(ElementReference){}\n        else self.fromList.name.referent->asSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> getFromClass();

	/**
	 * Returns the value of the '<em><b>To Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.alf.ElementReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The classes denoted by the names in the to list.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Class</em>' reference list.
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_ToClass()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='\n        if self.toList = null then Set(ElementReference){}\n        else self.toList.name.referent->asSet()\n        endif'"
	 * @generated
	 */
	EList<ElementReference> getToClass();

	/**
	 * Returns the value of the '<em><b>Is Reclassify All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether this classify statement reclassifies all types of the target
	 * object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Reclassify All</em>' attribute.
	 * @see #setIsReclassifyAll(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getClassifyStatement_IsReclassifyAll()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsReclassifyAll();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.ClassifyStatement#isIsReclassifyAll <em>Is Reclassify All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Reclassify All</em>' attribute.
	 * @see #isIsReclassifyAll()
	 * @generated
	 */
	void setIsReclassifyAll(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.expression.assignmentAfter'"
	 * @generated
	 */
	EList<AssignedSource> assignmentAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression in a classify statement must have a class as its type and
	 * multiplicity upper bound of 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let type = self.expression.type in\n          type <> null and type.isClass() and self.expression.upper = 1'"
	 * @generated
	 */
	boolean classifyStatementExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All qualified names listed in the from or to lists of a classify
	 * statement must resolve to classes.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let fromNames = \n          if self.fromList = null then Set(QualifiedName){}\n          else self.fromList.name->asSet()\n          endif\n        in\n        let toNames =\n          if self.toList = null then Set(QualifiedName){}\n          else self.toList.name->asSet()\n          endif\n        in\n          fromNames->union(toNames)->forAll(name |\n            let referent = name.referent->select(isClass()) in\n              referent->size() = 1 and\n              referent->forAll(not isTemplate())\n          )'"
	 * @generated
	 */
	boolean classifyStatementClassNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the from and to classes of a classify statement must be subclasses of
	 * the type of the target expression and none of them may have a common
	 * superclass that is a subclass of the type of the target expression (that
	 * is, they must be disjoint subclasses).
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        let classes = self.fromClass->union(self.toClass) in\n        let expressionType = self.expression.type in\n          if expressionType = null then true\n          else\n            classes->\n              forAll(not equals(expressionType) and conformsTo(expressionType)) and\n            let parents : Bag(ElementReference) = classes.allParents()->\n                select(not equals(expressionType) and conformsTo(expressionType)) \n            in\n              parents->forAll(countIn(parents) = 1)\n          endif'"
	 * @generated
	 */
	boolean classifyStatementClasses(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expression of a classify statement are the
	 * same as the assignments before the statement.
	 * (See the assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifyStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a classify statement are the same as the
	 * assignments after its expression.
	 * (See the assignmentAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifyStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The from classes of a classify statement are the class referents of the
	 * qualified names in the from list for the statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifyStatementFromClassDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The to classes of a classify statement are the class referents of the
	 * qualified names in the to list for the statement.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean classifyStatementToClassDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ClassifyStatement
