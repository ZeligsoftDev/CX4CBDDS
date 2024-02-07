/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.NonFinalClause;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concurrent Clauses</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ConcurrentClausesImpl#getClause <em>Clause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcurrentClausesImpl extends SyntaxElementImpl implements ConcurrentClauses {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcurrentClausesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getConcurrentClauses();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NonFinalClause> getClause() {
		return (EList<NonFinalClause>)eGet(AlfPackage.eINSTANCE.getConcurrentClauses_Clause(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean concurrentClausesAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CONCURRENT_CLAUSES__CONCURRENT_CLAUSES_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "concurrentClausesAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #concurrentClausesConditionAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Concurrent Clauses Condition Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #concurrentClausesConditionAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CONCURRENT_CLAUSES_CONDITION_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.clause.condition.newAssignments()->isUnique(name)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean concurrentClausesConditionAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getConcurrentClauses(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getConcurrentClauses__ConcurrentClausesConditionAssignments__DiagnosticChain_Map(),
				 CONCURRENT_CLAUSES_CONDITION_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CONCURRENT_CLAUSES__CONCURRENT_CLAUSES_CONDITION_ASSIGNMENTS);
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
			case AlfPackage.CONCURRENT_CLAUSES___CONCURRENT_CLAUSES_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return concurrentClausesAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CONCURRENT_CLAUSES___CONCURRENT_CLAUSES_CONDITION_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return concurrentClausesConditionAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ConcurrentClausesImpl
