/**
 */
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Name Declaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A statement that declares the type of a local name and assigns it an
 * initial value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#isHasMultiplicity <em>Has Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#isIsAny <em>Is Any</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement()
 * @model
 * @generated
 */
public interface LocalNameDeclarationStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local name being declared.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_Name()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='AssignableLocalNameDeclaration' unique='false' upper='*'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression to be evaluated to provide the initial value to be assigned to the local name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Has Multiplicity</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the local name is to have a multiplicity upper bound of * rather than 1.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Has Multiplicity</em>' attribute.
	 * @see #setHasMultiplicity(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_HasMultiplicity()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isHasMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#isHasMultiplicity <em>Has Multiplicity</em>}' attribute.
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
	 * The declared type of the local name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(QualifiedName)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_TypeName()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getTypeName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type declared for the given local name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ElementReference)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_Type()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='self.typeCached()'"
	 * @generated
	 */
	ElementReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ElementReference value);

	/**
	 * Returns the value of the '<em><b>Is Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the local name is being declared with an empty type.
	 * (Added solely to allow proper Xtext re-serialization.)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Any</em>' attribute.
	 * @see #setIsAny(boolean)
	 * @see org.eclipse.papyrus.uml.alf.AlfPackage#getLocalNameDeclarationStatement_IsAny()
	 * @model
	 * @generated
	 */
	boolean isIsAny();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement#isIsAny <em>Is Any</em>}' attribute.
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
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='NameBinding{name = self.name}.toName()'"
	 * @generated
	 */
	String actualName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            AssignedSource{\n              name = self.actualName(),\n              source = self,\n              type = self.type,\n              lower = 0,\n              upper = if self.hasMultiplicity then -1 else 1 endif\n            }.update(self.expression.assignmentAfter)'"
	 * @generated
	 */
	EList<AssignedSource> assignmentsAfter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments before the expression of a local name declaration
	 * statement are the same as the assignments before the statement.
	 * (See SyntaxElement::assignmentsBefore(element) operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean localNameDeclarationStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the type name in a local name declaration statement is not empty, then
	 * it must resolve to a non-template classifier and the expression must be
	 * assignable to that classifier.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n        self.typeName <> null implies \n          self.type <> null and not self.type.isTemplate()\n          and AssignableLocalNameDeclaration{localNameDeclaration = self}.\n            isAssignableFrom(self.expression)'"
	 * @generated
	 */
	boolean localNameDeclarationStatementType(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The local name in a local name declaration statement must be unassigned
	 * before the statement and before the expression in the statement.
	 * It must remain unassigned after the expression.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            not self.expression.assignmentBefore->exists(a | a.name = self.actualName()) and\n            not self.expression.assignmentAfter->exists(a | a.name = self.actualName())'"
	 * @generated
	 */
	boolean localNameDeclarationStatementLocalName(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assignments after a local name declaration statement are the
	 * assignments after the expression of the statement plus a new assignment
	 * for the local name defined by the statement. The assigned source for the
	 * local name is the local name declaration statement. The local name has
	 * the type denoted by the type name if this is not empty and is untyped
	 * otherwise. If the statement has multiplicity, then the multiplicity of
	 * the local name is [0..*], otherwise it is [0..1].
	 * (See assignmentsAfter() operation.)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean localNameDeclarationStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If a local name declaration statement does not have multiplicity, then
	 * the multiplicity of upper bound of the assigned expression must not be
	 * greater than 1.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='(not self.hasMultiplicity) implies self.expression.upper <=1'"
	 * @generated
	 */
	boolean localNameDeclarationStatementExpressionMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of a local name declaration statement with a type name is the
	 * single classifier referent of the type name. Otherwise the type is empty.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean localNameDeclarationStatementTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ElementReference typeCached();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n            if self.typeName = null then null\n            else \n              let referent = self.typeName.referent->select(isClassifier()) in\n                if referent->size() <> 1 then null\n                else self.typeName.referent->any(true)\n                endif\n            endif'"
	 * @generated
	 */
	ElementReference type();

} // LocalNameDeclarationStatement
