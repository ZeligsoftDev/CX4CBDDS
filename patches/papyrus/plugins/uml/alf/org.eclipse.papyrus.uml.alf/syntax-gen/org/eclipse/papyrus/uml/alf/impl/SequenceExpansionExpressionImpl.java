/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.math.BigInteger;
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
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.ExtentOrExpression;
import org.eclipse.papyrus.uml.alf.SequenceExpansionExpression;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Expansion Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#getVariableSource <em>Variable Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#isIsSelectOrReject <em>Is Select Or Reject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#isIsCollectOrIterate <em>Is Collect Or Iterate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#isIsForAllOrExistsOrOne <em>Is For All Or Exists Or One</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceExpansionExpressionImpl#isIsIsUnique <em>Is Is Unique</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceExpansionExpressionImpl extends ExpressionImpl implements SequenceExpansionExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceExpansionExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSequenceExpansionExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return (String)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Operation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Operation(), newOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariable() {
		return (String)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Variable(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(String newVariable) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Variable(), newVariable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource getVariableSource() {
		return (AssignedSource)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_VariableSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableSource(AssignedSource newVariableSource) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_VariableSource(), newVariableSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getArgument() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Argument(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgument(Expression newArgument) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Argument(), newArgument);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtentOrExpression getPrimary() {
		return (ExtentOrExpression)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Primary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(ExtentOrExpression newPrimary) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_Primary(), newPrimary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSelectOrReject() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsSelectOrReject(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSelectOrReject(boolean newIsSelectOrReject) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsSelectOrReject(), newIsSelectOrReject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollectOrIterate() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsCollectOrIterate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollectOrIterate(boolean newIsCollectOrIterate) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsCollectOrIterate(), newIsCollectOrIterate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsForAllOrExistsOrOne() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsForAllOrExistsOrOne(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsForAllOrExistsOrOne(boolean newIsForAllOrExistsOrOne) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsForAllOrExistsOrOne(), newIsForAllOrExistsOrOne);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIsUnique() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsIsUnique(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIsUnique(boolean newIsIsUnique) {
		eSet(AlfPackage.eINSTANCE.getSequenceExpansionExpression_IsIsUnique(), newIsIsUnique);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #assignmentsAfterPrimary() <em>Assignments After Primary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsAfterPrimary()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_AFTER_PRIMARY__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__AssignmentsAfterPrimary()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> assignmentsAfterPrimary() {
		try {
			return (EList<AssignedSource>)ASSIGNMENTS_AFTER_PRIMARY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__Type()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference type() {
		try {
			return (ElementReference)TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__Lower()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lower() {
		try {
			return (BigInteger)LOWER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__Upper()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upper() {
		try {
			return (BigInteger)UPPER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean sequenceExpansionExpressionVariableSourceDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_SOURCE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceExpansionExpressionVariableSourceDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceExpansionExpressionAssignmentsBeforePrimary(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_PRIMARY,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceExpansionExpressionAssignmentsBeforePrimary", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceExpansionExpressionAssignmentsBeforeArgument(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_ARGUMENT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceExpansionExpressionAssignmentsBeforeArgument", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #sequenceExpansionExpressionVariableName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Expansion Expression Variable Name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceExpansionExpressionVariableName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        not self.assignmentsAfterPrimary()->exists(name = self.variable)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceExpansionExpressionVariableName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__SequenceExpansionExpressionVariableName__DiagnosticChain_Map(),
				 SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_NAME);
	}

	/**
	 * The cached validation expression for the '{@link #sequenceExpansionExpressionAssignmentsAfterArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Expansion Expression Assignments After Argument</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceExpansionExpressionAssignmentsAfterArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_AFTER_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.argument <> null implies self.argument.newAssignments()->isEmpty()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceExpansionExpressionAssignmentsAfterArgument(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__SequenceExpansionExpressionAssignmentsAfterArgument__DiagnosticChain_Map(),
				 SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_AFTER_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_AFTER_ARGUMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean selectOrRejectExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "selectOrRejectExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean selectOrRejectExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "selectOrRejectExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean selectOrRejectExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "selectOrRejectExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #selectOrRejectExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Select Or Reject Expression Argument</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #selectOrRejectExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SELECT_OR_REJECT_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        (self.isSelectOrReject and self.argument <> null) implies\n" +
		"          self.isBooleanType(self.argument.type) and\n" +
		"          self.argument.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean selectOrRejectExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__SelectOrRejectExpressionArgument__DiagnosticChain_Map(),
				 SELECT_OR_REJECT_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SELECT_OR_REJECT_EXPRESSION_ARGUMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean collectOrIterateExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "collectOrIterateExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean collectOrIterateExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "collectOrIterateExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean collectOrIterateExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__COLLECT_OR_ITERATE_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "collectOrIterateExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean forAllOrExistsOrOneExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "forAllOrExistsOrOneExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean forAllOrExistsOrOneExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "forAllOrExistsOrOneExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean forAllOrExistsOrOneExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "forAllOrExistsOrOneExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #forAllOrExistsOrOneExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>For All Or Exists Or One Expression Argument</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #forAllOrExistsOrOneExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"          (self.isForAllOrExistsOrOne and self.argument <> null) implies\n" +
		"            self.isBooleanType(self.argument.type) and\n" +
		"            self.argument.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean forAllOrExistsOrOneExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__ForAllOrExistsOrOneExpressionArgument__DiagnosticChain_Map(),
				 FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUniqueExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "isUniqueExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean isUniqueExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "isUniqueExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean isUniqueExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "isUniqueExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #isUniqueExpressionExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Is Unique Expression Expression Argument</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUniqueExpressionExpressionArgument(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        (self.isIsUnique and self.argument <> null) implies \n" +
		"          self.argument.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUniqueExpressionExpressionArgument(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__IsUniqueExpressionExpressionArgument__DiagnosticChain_Map(),
				 IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT);
	}

	/**
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceExpansionExpression__UpdateAssignments()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AssignedSource> updateAssignments() {
		try {
			return (EList<AssignedSource>)UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #sequenceExpansionExpressionOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Expansion Expression Operation</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceExpansionExpressionOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_EXPANSION_EXPRESSION_OPERATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      self.isSelectOrReject or self.isCollectOrIterate or \n" +
		"      self.isForAllOrExistsOrOne or self.isIsUnique";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceExpansionExpressionOperation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceExpansionExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceExpansionExpression__SequenceExpansionExpressionOperation__DiagnosticChain_Map(),
				 SEQUENCE_EXPANSION_EXPRESSION_OPERATION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_EXPANSION_EXPRESSION__SEQUENCE_EXPANSION_EXPRESSION_OPERATION);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___ASSIGNMENTS_AFTER_PRIMARY:
				return assignmentsAfterPrimary();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___TYPE:
				return type();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_SOURCE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionVariableSourceDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_PRIMARY__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionAssignmentsBeforePrimary((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_BEFORE_ARGUMENT__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionAssignmentsBeforeArgument((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_VARIABLE_NAME__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionVariableName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_ASSIGNMENTS_AFTER_ARGUMENT__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionAssignmentsAfterArgument((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SELECT_OR_REJECT_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return selectOrRejectExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SELECT_OR_REJECT_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return selectOrRejectExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SELECT_OR_REJECT_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return selectOrRejectExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SELECT_OR_REJECT_EXPRESSION_ARGUMENT__DIAGNOSTICCHAIN_MAP:
				return selectOrRejectExpressionArgument((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___COLLECT_OR_ITERATE_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return collectOrIterateExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___COLLECT_OR_ITERATE_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return collectOrIterateExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___COLLECT_OR_ITERATE_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return collectOrIterateExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return forAllOrExistsOrOneExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return forAllOrExistsOrOneExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return forAllOrExistsOrOneExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___FOR_ALL_OR_EXISTS_OR_ONE_EXPRESSION_ARGUMENT__DIAGNOSTICCHAIN_MAP:
				return forAllOrExistsOrOneExpressionArgument((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___IS_UNIQUE_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return isUniqueExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___IS_UNIQUE_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return isUniqueExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___IS_UNIQUE_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return isUniqueExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___IS_UNIQUE_EXPRESSION_EXPRESSION_ARGUMENT__DIAGNOSTICCHAIN_MAP:
				return isUniqueExpressionExpressionArgument((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION___SEQUENCE_EXPANSION_EXPRESSION_OPERATION__DIAGNOSTICCHAIN_MAP:
				return sequenceExpansionExpressionOperation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SequenceExpansionExpressionImpl
