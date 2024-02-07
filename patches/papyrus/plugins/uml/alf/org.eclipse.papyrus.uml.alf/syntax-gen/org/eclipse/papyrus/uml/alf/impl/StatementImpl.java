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
import org.eclipse.papyrus.uml.alf.Statement;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StatementImpl#getAssignmentBefore <em>Assignment Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StatementImpl#getAssignmentAfter <em>Assignment After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StatementImpl#getEnclosingStatement <em>Enclosing Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.StatementImpl#isIsIsolated <em>Is Isolated</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StatementImpl extends SyntaxElementImpl implements Statement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected StatementImpl() {
		super();
		this.registerCaching();
	}

	@Override
	public void clear() {
		super.clear();
		this.assignmentsAfter = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getStatement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentBefore() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getStatement_AssignmentBefore(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> getAssignmentAfter() {
		return (EList<AssignedSource>)eGet(AlfPackage.eINSTANCE.getStatement_AssignmentAfter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getEnclosingStatement() {
		return (Statement)eGet(AlfPackage.eINSTANCE.getStatement_EnclosingStatement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingStatement(Statement newEnclosingStatement) {
		eSet(AlfPackage.eINSTANCE.getStatement_EnclosingStatement(), newEnclosingStatement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIsolated() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getStatement_IsIsolated(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIsolated(boolean newIsIsolated) {
		eSet(AlfPackage.eINSTANCE.getStatement_IsIsolated(), newIsIsolated);
	}

	/**
	 * The cached invocation delegate for the '{@link #enclosingLoopStatement() <em>Enclosing Loop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #enclosingLoopStatement()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ENCLOSING_LOOP_STATEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__EnclosingLoopStatement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__AnnotationAllowed__Annotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean statementAnnotationsAllowed(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStatement__StatementAnnotationsAllowed__DiagnosticChain_Map(),
				 STATEMENT_ANNOTATIONS_ALLOWED_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STATEMENT__STATEMENT_ANNOTATIONS_ALLOWED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean statementUniqueAssignments(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getStatement(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getStatement__StatementUniqueAssignments__DiagnosticChain_Map(),
				 STATEMENT_UNIQUE_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.STATEMENT__STATEMENT_UNIQUE_ASSIGNMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean statementIsIsolatedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.STATEMENT__STATEMENT_IS_ISOLATED_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "statementIsIsolatedDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean annotationAllowed(Annotation annotation) {
		try {
			return (Boolean)ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #Statement_annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation) <em>Statement annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Statement_annotationAllowed(org.eclipse.papyrus.uml.alf.Annotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STATEMENT_ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__Statement_annotationAllowed__Annotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Statement_annotationAllowed(Annotation annotation) {
		try {
			return (Boolean)STATEMENT_ANNOTATION_ALLOWED_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #annotation() <em>Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotation()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__Annotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Annotation> annotation() {
		try {
			return (EList<Annotation>)ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #hasAnnotation(java.lang.String) <em>Has Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #hasAnnotation(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate HAS_ANNOTATION_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__HasAnnotation__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasAnnotation(String name) {
		try {
			return (Boolean)HAS_ANNOTATION_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
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
	protected static final EOperation.Internal.InvocationDelegate NEW_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__NewAssignments()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #resolve(java.lang.String) <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #resolve(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate RESOLVE_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__Resolve__String()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxElement resolve(String name) {
		try {
			return (SyntaxElement)RESOLVE_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
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
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__AssignmentsAfter()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #Statement_assignmentsAfter() <em>Statement assignments After</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Statement_assignmentsAfter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate STATEMENT_ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__Statement_assignmentsAfter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> Statement_assignmentsAfter() {
		try {
			return (EList<AssignedSource>)STATEMENT_ASSIGNMENTS_AFTER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	private EList<AssignedSource> assignmentsAfter = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<AssignedSource> assignmentsAfterCached() {
		if (this.assignmentsAfter == null) {
			this.assignmentsAfter = this.assignmentsAfter();
		}
		return this.assignmentsAfter;
	}

	/**
	 * The cached invocation delegate for the '{@link #mergeAssignments(org.eclipse.emf.common.util.EList) <em>Merge Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #mergeAssignments(org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MERGE_ASSIGNMENTS_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__MergeAssignments__EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> mergeAssignments(EList<Block> blocks) {
		try {
			return (EList<AssignedSource>)MERGE_ASSIGNMENTS_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{blocks}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #merge(java.lang.String, org.eclipse.emf.common.util.EList) <em>Merge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #merge(java.lang.String, org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate MERGE_STRING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getStatement__Merge__String_EList()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource merge(String name, EList<AssignedSource> assignments) {
		try {
			return (AssignedSource)MERGE_STRING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{name, assignments}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #statementAnnotationsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Statement Annotations Allowed</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #statementAnnotationsAllowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_ANNOTATIONS_ALLOWED_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.annotation()->forAll(a | self.annotationAllowed(a))";
	/**
	 * The cached validation expression for the '{@link #statementUniqueAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Statement Unique Assignments</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #statementUniqueAssignments(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_UNIQUE_ASSIGNMENTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.assignmentBefore->isUnique(name) and self.assignmentAfter->isUnique(name)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.STATEMENT___ENCLOSING_LOOP_STATEMENT:
				return enclosingLoopStatement();
			case AlfPackage.STATEMENT___ANNOTATION_ALLOWED__ANNOTATION:
				return annotationAllowed((Annotation)arguments.get(0));
			case AlfPackage.STATEMENT___STATEMENT_ANNOTATION_ALLOWED__ANNOTATION:
				return Statement_annotationAllowed((Annotation)arguments.get(0));
			case AlfPackage.STATEMENT___ANNOTATION:
				return annotation();
			case AlfPackage.STATEMENT___HAS_ANNOTATION__STRING:
				return hasAnnotation((String)arguments.get(0));
			case AlfPackage.STATEMENT___NEW_ASSIGNMENTS:
				return newAssignments();
			case AlfPackage.STATEMENT___RESOLVE__STRING:
				return resolve((String)arguments.get(0));
			case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER:
				return assignmentsAfter();
			case AlfPackage.STATEMENT___STATEMENT_ASSIGNMENTS_AFTER:
				return Statement_assignmentsAfter();
			case AlfPackage.STATEMENT___ASSIGNMENTS_AFTER_CACHED:
				return assignmentsAfterCached();
			case AlfPackage.STATEMENT___MERGE_ASSIGNMENTS__ELIST:
				return mergeAssignments((EList<Block>)arguments.get(0));
			case AlfPackage.STATEMENT___MERGE__STRING_ELIST:
				return merge((String)arguments.get(0), (EList<AssignedSource>)arguments.get(1));
			case AlfPackage.STATEMENT___STATEMENT_ANNOTATIONS_ALLOWED__DIAGNOSTICCHAIN_MAP:
				return statementAnnotationsAllowed((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STATEMENT___STATEMENT_UNIQUE_ASSIGNMENTS__DIAGNOSTICCHAIN_MAP:
				return statementUniqueAssignments((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.STATEMENT___STATEMENT_IS_ISOLATED_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return statementIsIsolatedDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // StatementImpl
