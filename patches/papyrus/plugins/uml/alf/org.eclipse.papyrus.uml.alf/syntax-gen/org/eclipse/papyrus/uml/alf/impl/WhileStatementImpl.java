/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.WhileStatement;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.WhileStatementImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.WhileStatementImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhileStatementImpl extends StatementImpl implements WhileStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getWhileStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBody() {
		return (Block)eGet(AlfPackage.eINSTANCE.getWhileStatement_Body(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Block newBody) {
		eSet(AlfPackage.eINSTANCE.getWhileStatement_Body(), newBody);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCondition() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getWhileStatement_Condition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		eSet(AlfPackage.eINSTANCE.getWhileStatement_Condition(), newCondition);
	}

	/**
	 * The cached invocation delegate for the '{@link #enclosingLoopStatement() <em>Enclosing Loop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #enclosingLoopStatement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ENCLOSING_LOOP_STATEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getWhileStatement__EnclosingLoopStatement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement enclosingLoopStatement() {
		try {
			return (Statement)ENCLOSING_LOOP_STATEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getWhileStatement__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore(SyntaxElement element) {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{element}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsAfter() <em>Assignments After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getWhileStatement__AssignmentsAfter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsAfter() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean whileStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.WHILE_STATEMENT__WHILE_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "whileStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean whileStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.WHILE_STATEMENT__WHILE_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "whileStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #whileStatementCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>While Statement Condition</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #whileStatementCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String WHILE_STATEMENT_CONDITION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let type = self.condition.type in\n" +
		"          type <> null and self.isBooleanType(type) and self.condition.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean whileStatementCondition(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getWhileStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getWhileStatement__WhileStatementCondition__DiagnosticChain_Map(),
				 WHILE_STATEMENT_CONDITION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.WHILE_STATEMENT__WHILE_STATEMENT_CONDITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean whileStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 AlfValidator.DIAGNOSTIC_SOURCE,
						 AlfValidator.WHILE_STATEMENT__WHILE_STATEMENT_ENCLOSED_STATEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "whileStatementEnclosedStatements", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SyntaxElement.class) {
			switch (baseOperationID) {
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.WHILE_STATEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case AlfPackage.STATEMENT___ENCLOSING_LOOP_STATEMENT: return AlfPackage.WHILE_STATEMENT___ENCLOSING_LOOP_STATEMENT;
				case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER: return AlfPackage.WHILE_STATEMENT___ASSIGNMENTS_AFTER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.WHILE_STATEMENT___ENCLOSING_LOOP_STATEMENT:
				return enclosingLoopStatement();
			case AlfPackage.WHILE_STATEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.WHILE_STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.WHILE_STATEMENT___WHILE_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return whileStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.WHILE_STATEMENT___WHILE_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return whileStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.WHILE_STATEMENT___WHILE_STATEMENT_CONDITION__DIAGNOSTICCHAIN_MAP:
				return whileStatementCondition((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.WHILE_STATEMENT___WHILE_STATEMENT_ENCLOSED_STATEMENTS__DIAGNOSTICCHAIN_MAP:
				return whileStatementEnclosedStatements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // WhileStatementImpl
