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
import org.eclipse.papyrus.uml.alf.NonFinalClause;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Final Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NonFinalClauseImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.NonFinalClauseImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonFinalClauseImpl extends SyntaxElementImpl implements NonFinalClause {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonFinalClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getNonFinalClause();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCondition() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getNonFinalClause_Condition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		eSet(AlfPackage.eINSTANCE.getNonFinalClause_Condition(), newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBody() {
		return (Block)eGet(AlfPackage.eINSTANCE.getNonFinalClause_Body(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Block newBody) {
		eSet(AlfPackage.eINSTANCE.getNonFinalClause_Body(), newBody);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNonFinalClause__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #assignmentsBefore() <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNonFinalClause__AssignmentsBefore()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsBefore() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_BEFORE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getNonFinalClause__AssignmentsAfter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nonFinalClauseAssignmentsBeforeBody(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_ASSIGNMENTS_BEFORE_BODY,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "nonFinalClauseAssignmentsBeforeBody", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #nonFinalClauseConditionLocalNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Non Final Clause Condition Local Names</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nonFinalClauseConditionLocalNames(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NON_FINAL_CLAUSE_CONDITION_LOCAL_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      self.condition.assignmentBefore.name->includesAll(\n" +
		"                        self.condition.assignmentAfter.name\n" +
		"                      )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nonFinalClauseConditionLocalNames(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNonFinalClause(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNonFinalClause__NonFinalClauseConditionLocalNames__DiagnosticChain_Map(),
				 NON_FINAL_CLAUSE_CONDITION_LOCAL_NAMES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_CONDITION_LOCAL_NAMES);
	}

	/**
	 * The cached validation expression for the '{@link #nonFinalClauseConditionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Non Final Clause Condition Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #nonFinalClauseConditionType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NON_FINAL_CLAUSE_CONDITION_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                      let type = self.condition.type in\n" +
		"                        type <> null and self.isBooleanType(type) and \n" +
		"                        condition.upper <= 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nonFinalClauseConditionType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getNonFinalClause(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getNonFinalClause__NonFinalClauseConditionType__DiagnosticChain_Map(),
				 NON_FINAL_CLAUSE_CONDITION_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.NON_FINAL_CLAUSE__NON_FINAL_CLAUSE_CONDITION_TYPE);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE: return AlfPackage.NON_FINAL_CLAUSE___ASSIGNMENTS_BEFORE;
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.NON_FINAL_CLAUSE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
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
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.NON_FINAL_CLAUSE___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.NON_FINAL_CLAUSE___ASSIGNMENTS_BEFORE:
				return assignmentsBefore();
			case AlfPackage.NON_FINAL_CLAUSE___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.NON_FINAL_CLAUSE___NON_FINAL_CLAUSE_ASSIGNMENTS_BEFORE_BODY__DIAGNOSTICCHAIN_MAP:
				return nonFinalClauseAssignmentsBeforeBody((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NON_FINAL_CLAUSE___NON_FINAL_CLAUSE_CONDITION_LOCAL_NAMES__DIAGNOSTICCHAIN_MAP:
				return nonFinalClauseConditionLocalNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.NON_FINAL_CLAUSE___NON_FINAL_CLAUSE_CONDITION_TYPE__DIAGNOSTICCHAIN_MAP:
				return nonFinalClauseConditionType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // NonFinalClauseImpl
