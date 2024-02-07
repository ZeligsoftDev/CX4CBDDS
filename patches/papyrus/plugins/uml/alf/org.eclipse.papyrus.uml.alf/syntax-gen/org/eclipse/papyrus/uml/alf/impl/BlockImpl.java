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
import org.eclipse.papyrus.uml.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BlockImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BlockImpl#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BlockImpl#getAssignmentBefore <em>Assignment Before</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockImpl extends SyntaxElementImpl implements Block {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getBlock();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AnnotatedStatement> getStatement() {
		return (EList<AnnotatedStatement>)eGet(AlfPackage.eINSTANCE.getBlock_Statement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentAfter() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getBlock_AssignmentAfter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentBefore() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getBlock_AssignmentBefore(), true);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBlock__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #newAssignments() <em>New Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #newAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NEW_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBlock__NewAssignments()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> newAssignments() {
		try {
			return (EList<AssignedSource>)NEW_ASSIGNMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean blockAssignmentsBeforeStatements(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK__BLOCK_ASSIGNMENTS_BEFORE_STATEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockAssignmentsBeforeStatements", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean blockAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK__BLOCK_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean blockAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK__BLOCK_ASSIGNMENT_AFTER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockAssignmentAfterDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.BLOCK___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
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
			case AlfPackage.BLOCK___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.BLOCK___NEW_ASSIGNMENTS:
				return newAssignments();
			case AlfPackage.BLOCK___BLOCK_ASSIGNMENTS_BEFORE_STATEMENTS__DIAGNOSTICCHAIN_MAP:
				return blockAssignmentsBeforeStatements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK___BLOCK_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return blockAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK___BLOCK_ASSIGNMENT_AFTER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return blockAssignmentAfterDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // BlockImpl
