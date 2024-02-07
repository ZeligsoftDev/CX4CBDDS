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
import org.eclipse.papyrus.uml.alf.BlockStatement;
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BlockStatementImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BlockStatementImpl#isIsParallel <em>Is Parallel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockStatementImpl extends StatementImpl implements BlockStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getBlockStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		return (Block)eGet(AlfPackage.eINSTANCE.getBlockStatement_Block(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		eSet(AlfPackage.eINSTANCE.getBlockStatement_Block(), newBlock);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsParallel() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getBlockStatement_IsParallel(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsParallel(boolean newIsParallel) {
		eSet(AlfPackage.eINSTANCE.getBlockStatement_IsParallel(), newIsParallel);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsAfter() <em>Assignments After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBlockStatement__AssignmentsAfter()).getInvocationDelegate();

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
	 * The cached validation expression for the '{@link #blockStatementParallelAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Block Statement Parallel Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #blockStatementParallelAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String BLOCK_STATEMENT_PARALLEL_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"                    if not self.isParallel or self.block = null then true\n" +
		"                    else self.block.statement.statement.newAssignments()->\n" +
		"                        isUnique(name)\n" +
		"                    endif";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean blockStatementParallelAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getBlockStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getBlockStatement__BlockStatementParallelAssignments__DiagnosticChain_Map(),
				 BLOCK_STATEMENT_PARALLEL_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.BLOCK_STATEMENT__BLOCK_STATEMENT_PARALLEL_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean blockStatementAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK_STATEMENT__BLOCK_STATEMENT_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockStatementAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean blockStatementAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK_STATEMENT__BLOCK_STATEMENT_ASSIGNMENTS_AFTER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockStatementAssignmentsAfter", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean blockStatementEnclosedStatements(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK_STATEMENT__BLOCK_STATEMENT_ENCLOSED_STATEMENTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockStatementEnclosedStatements", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean blockStatementIsParallelDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BLOCK_STATEMENT__BLOCK_STATEMENT_IS_PARALLEL_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "blockStatementIsParallelDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBlockStatement__AnnotationAllowed__Annotation()).getInvocationDelegate();

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
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case AlfPackage.STATEMENT___ANNOTATION_ALLOWED__ANNOTATION: return AlfPackage.BLOCK_STATEMENT___ANNOTATION_ALLOWED__ANNOTATION;
				case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER: return AlfPackage.BLOCK_STATEMENT___ASSIGNMENTS_AFTER;
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
			case AlfPackage.BLOCK_STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.BLOCK_STATEMENT___BLOCK_STATEMENT_PARALLEL_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return blockStatementParallelAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK_STATEMENT___BLOCK_STATEMENT_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return blockStatementAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK_STATEMENT___BLOCK_STATEMENT_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return blockStatementAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK_STATEMENT___BLOCK_STATEMENT_ENCLOSED_STATEMENTS__DIAGNOSTICCHAIN_MAP:
				return blockStatementEnclosedStatements((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK_STATEMENT___BLOCK_STATEMENT_IS_PARALLEL_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return blockStatementIsParallelDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BLOCK_STATEMENT___ANNOTATION_ALLOWED__ANNOTATION:
				return annotationAllowed((Annotation)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // BlockStatementImpl
