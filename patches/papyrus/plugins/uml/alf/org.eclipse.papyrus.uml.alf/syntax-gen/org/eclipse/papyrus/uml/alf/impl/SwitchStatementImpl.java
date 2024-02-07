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
import org.eclipse.papyrus.uml.alf.Annotation;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.SwitchClause;
import org.eclipse.papyrus.uml.alf.SwitchStatement;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SwitchStatementImpl#getNonDefaultClause <em>Non Default Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SwitchStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SwitchStatementImpl#getDefaultClause <em>Default Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SwitchStatementImpl#isIsAssured <em>Is Assured</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SwitchStatementImpl#isIsDeterminate <em>Is Determinate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwitchStatementImpl extends StatementImpl implements SwitchStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSwitchStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SwitchClause> getNonDefaultClause() {
		return (EList<SwitchClause>)eGet(AlfPackage.eINSTANCE.getSwitchStatement_NonDefaultClause(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getSwitchStatement_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getSwitchStatement_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getDefaultClause() {
		return (Block)eGet(AlfPackage.eINSTANCE.getSwitchStatement_DefaultClause(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultClause(Block newDefaultClause) {
		eSet(AlfPackage.eINSTANCE.getSwitchStatement_DefaultClause(), newDefaultClause);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAssured() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSwitchStatement_IsAssured(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAssured(boolean newIsAssured) {
		eSet(AlfPackage.eINSTANCE.getSwitchStatement_IsAssured(), newIsAssured);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDeterminate() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSwitchStatement_IsDeterminate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDeterminate(boolean newIsDeterminate) {
		eSet(AlfPackage.eINSTANCE.getSwitchStatement_IsDeterminate(), newIsDeterminate);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSwitchStatement__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSwitchStatement__AssignmentsAfter()).getInvocationDelegate();

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
	public boolean switchStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "switchStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #switchStatementCaseAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Switch Statement Case Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #switchStatementCaseAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SWITCH_STATEMENT_CASE_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                            self.nonDefaultClause.case.newAssignments()->isUnique(name)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean switchStatementCaseAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSwitchStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSwitchStatement__SwitchStatementCaseAssignments__DiagnosticChain_Map(),
				 SWITCH_STATEMENT_CASE_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_CASE_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean switchStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "switchStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #switchStatementAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Switch Statement Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #switchStatementAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SWITCH_STATEMENT_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                            let newNames = self.assignmentAfter.name->excludingAll(self.assignmentBefore.name) in\n" +
		"\t                            if self.defaultClause = null then\n" +
		"\t                              newNames->isEmpty()\n" +
		"\t                            else\n" +
		"\t                              self.nonDefaultClause.block->including(self.defaultClause)->forAll(\n" +
		"\t                              \tassignmentAfter.name->includesAll(newNames)\n" +
		"\t                              )\n" +
		"\t                            endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean switchStatementAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSwitchStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSwitchStatement__SwitchStatementAssignments__DiagnosticChain_Map(),
				 SWITCH_STATEMENT_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_ASSIGNMENTS);
	}

	/**
	 * The cached validation expression for the '{@link #switchStatementExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Switch Statement Expression</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #switchStatementExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SWITCH_STATEMENT_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.expression.upper <= 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean switchStatementExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSwitchStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSwitchStatement__SwitchStatementExpression__DiagnosticChain_Map(),
				 SWITCH_STATEMENT_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean switchStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_ENCLOSED_STATEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "switchStatementEnclosedStatements", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean switchStatementIsDeterminateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_IS_DETERMINATE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "switchStatementIsDeterminateDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean switchStatementIsAssuredDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SWITCH_STATEMENT__SWITCH_STATEMENT_IS_ASSURED_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "switchStatementIsAssuredDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSwitchStatement__AnnotationAllowed__Annotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean annotationAllowed(Annotation annotation) {
		try {
			return (Boolean)ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SyntaxElement.class) {
			switch (baseOperationID) {
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.SWITCH_STATEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case AlfPackage.STATEMENT___ANNOTATION_ALLOWED__ANNOTATION: return AlfPackage.SWITCH_STATEMENT___ANNOTATION_ALLOWED__ANNOTATION;
				case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER: return AlfPackage.SWITCH_STATEMENT___ASSIGNMENTS_AFTER;
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
			case AlfPackage.SWITCH_STATEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.SWITCH_STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return switchStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_CASE_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return switchStatementCaseAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return switchStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return switchStatementAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return switchStatementExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_ENCLOSED_STATEMENTS__DIAGNOSTICCHAIN_MAP:
				return switchStatementEnclosedStatements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_IS_DETERMINATE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return switchStatementIsDeterminateDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___SWITCH_STATEMENT_IS_ASSURED_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return switchStatementIsAssuredDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SWITCH_STATEMENT___ANNOTATION_ALLOWED__ANNOTATION:
				return annotationAllowed((Annotation)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SwitchStatementImpl
