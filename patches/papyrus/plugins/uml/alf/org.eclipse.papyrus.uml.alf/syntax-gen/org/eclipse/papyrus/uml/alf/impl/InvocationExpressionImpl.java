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
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.InputNamedExpression;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.OutputNamedExpression;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.Tuple;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsBehavior <em>Is Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsAssociationEnd <em>Is Association End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsOperation <em>Is Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsDestructor <em>Is Destructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsImplicit <em>Is Implicit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#isIsSignal <em>Is Signal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InvocationExpressionImpl#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InvocationExpressionImpl extends ExpressionImpl implements InvocationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected InvocationExpressionImpl() {
		super();
		this.registerCaching();
	}

	public void clear() {
		super.clear();
		this.referent = null;
		this.notResolved = true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getInvocationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBehavior() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsBehavior(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBehavior(boolean newIsBehavior) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsBehavior(), newIsBehavior);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAssociationEnd() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsAssociationEnd(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAssociationEnd(boolean newIsAssociationEnd) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsAssociationEnd(), newIsAssociationEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference getFeature() {
		return (FeatureReference)eGet(AlfPackage.eINSTANCE.getInvocationExpression_Feature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(FeatureReference newFeature) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_Feature(), newFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOperation() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsOperation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOperation(boolean newIsOperation) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsOperation(), newIsOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDestructor() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsDestructor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDestructor(boolean newIsDestructor) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsDestructor(), newIsDestructor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsImplicit() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsImplicit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsImplicit(boolean newIsImplicit) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsImplicit(), newIsImplicit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getReferent() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getInvocationExpression_Referent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(ElementReference newReferent) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_Referent(), newReferent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ElementReference> getParameter() {
		return (EList<ElementReference>)eGet(AlfPackage.eINSTANCE.getInvocationExpression_Parameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSignal() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInvocationExpression_IsSignal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSignal(boolean newIsSignal) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_IsSignal(), newIsSignal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tuple getTuple() {
		return (Tuple)eGet(AlfPackage.eINSTANCE.getInvocationExpression_Tuple(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTuple(Tuple newTuple) {
		eSet(AlfPackage.eINSTANCE.getInvocationExpression_Tuple(), newTuple);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference feature() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference InvocationExpression_type() {
		try {
			return (ElementReference)INVOCATION_EXPRESSION_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public BigInteger InvocationExpression_upper() {
		try {
			return (BigInteger)INVOCATION_EXPRESSION_UPPER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public BigInteger lower() {
		try {
			return (BigInteger)LOWER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public BigInteger InvocationExpression_lower() {
		try {
			return (BigInteger)INVOCATION_EXPRESSION_LOWER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference parameterNamed(String name) {
		try {
			return (ElementReference)PARAMETER_NAMED_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{name}));
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
	public BigInteger parameterCount() {
		try {
			return (BigInteger)PARAMETER_COUNT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean parameterIsAssignableFrom(InputNamedExpression input) {
		try {
			return (Boolean)PARAMETER_IS_ASSIGNABLE_FROM_INPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{input}));
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
	public boolean parameterIsAssignableTo(OutputNamedExpression output) {
		try {
			return (Boolean)PARAMETER_IS_ASSIGNABLE_TO_OUTPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{output}));
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
	public boolean alternativeConstructorIsValid() {
		try {
			return (Boolean)ALTERNATIVE_CONSTRUCTOR_IS_VALID__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ElementReference bindTemplateImplicitArguments(ElementReference referent, Expression primary) {
		return this.bindTemplateImplicitArguments1(referent, primary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference effectiveType(ElementReference parameter, Expression expression) {
		try {
			return (ElementReference)EFFECTIVE_TYPE_ELEMENT_REFERENCE_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{parameter, expression}));
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
	public boolean invocationExpressionIsBehaviorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_BEHAVIOR_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsBehaviorDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionIsAssociationEndDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_ASSOCIATION_END_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsAssociationEndDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionIsOperationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_OPERATION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsOperationDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionIsDestructorDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_DESTRUCTOR_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsDestructorDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionIsImplicitDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_IMPLICIT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsImplicitDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionIsSignalDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_IS_SIGNAL_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionIsSignalDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionParameterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_PARAMETER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionParameterDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean invocationExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "invocationExpressionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean invocationExpressionTemplateParameters(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getInvocationExpression__InvocationExpressionTemplateParameters__DiagnosticChain_Map(),
				 INVOCATION_EXPRESSION_TEMPLATE_PARAMETERS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INVOCATION_EXPRESSION__INVOCATION_EXPRESSION_TEMPLATE_PARAMETERS);
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
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.INVOCATION_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.INVOCATION_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.INVOCATION_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.INVOCATION_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.INVOCATION_EXPRESSION___UPDATE_ASSIGNMENTS;
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
	public EList<ElementReference> parameterElements() {
		try {
			return (EList<ElementReference>)PARAMETER_ELEMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	@SuppressWarnings("unchecked")
	public EList<ElementReference> InvocationExpression_parameterElements() {
		try {
			return (EList<ElementReference>)INVOCATION_EXPRESSION_PARAMETER_ELEMENTS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference parameterFromProperty(ElementReference property) {
		try {
			return (ElementReference)PARAMETER_FROM_PROPERTY_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{property}));
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
	public ElementReference parameterFromPropertyWithMultiplicity(ElementReference property, String lower, String upper) {
		try {
			return (ElementReference)PARAMETER_FROM_PROPERTY_WITH_MULTIPLICITY_ELEMENT_REFERENCE_STRING_STRING__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{property, lower, upper}));
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
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__Type()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #InvocationExpression_type() <em>Invocation Expression type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InvocationExpression_type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INVOCATION_EXPRESSION_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__InvocationExpression_type()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__Upper()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #InvocationExpression_upper() <em>Invocation Expression upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InvocationExpression_upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INVOCATION_EXPRESSION_UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__InvocationExpression_upper()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__Lower()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #InvocationExpression_lower() <em>Invocation Expression lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InvocationExpression_lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INVOCATION_EXPRESSION_LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__InvocationExpression_lower()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterNamed(java.lang.String) <em>Parameter Named</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterNamed(java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_NAMED_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterNamed__String()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterCount() <em>Parameter Count</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterCount()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_COUNT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterCount()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterIsAssignableFrom(org.eclipse.papyrus.uml.alf.InputNamedExpression) <em>Parameter Is Assignable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterIsAssignableFrom(org.eclipse.papyrus.uml.alf.InputNamedExpression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_IS_ASSIGNABLE_FROM_INPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterIsAssignableFrom__InputNamedExpression()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterIsAssignableTo(org.eclipse.papyrus.uml.alf.OutputNamedExpression) <em>Parameter Is Assignable To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterIsAssignableTo(org.eclipse.papyrus.uml.alf.OutputNamedExpression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_IS_ASSIGNABLE_TO_OUTPUT_NAMED_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterIsAssignableTo__OutputNamedExpression()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #alternativeConstructorIsValid() <em>Alternative Constructor Is Valid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #alternativeConstructorIsValid()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ALTERNATIVE_CONSTRUCTOR_IS_VALID__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__AlternativeConstructorIsValid()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #bindTemplateImplicitArguments1(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.Expression) <em>Bind Template Implicit Arguments1</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #bindTemplateImplicitArguments1(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BIND_TEMPLATE_IMPLICIT_ARGUMENTS1_ELEMENT_REFERENCE_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__BindTemplateImplicitArguments1__ElementReference_Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference bindTemplateImplicitArguments1(ElementReference referent, Expression primary) {
		try {
			return (ElementReference)BIND_TEMPLATE_IMPLICIT_ARGUMENTS1_ELEMENT_REFERENCE_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{referent, primary}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #effectiveType(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.Expression) <em>Effective Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #effectiveType(org.eclipse.papyrus.uml.alf.ElementReference, org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EFFECTIVE_TYPE_ELEMENT_REFERENCE_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__EffectiveType__ElementReference_Expression()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterElements() <em>Parameter Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterElements()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #InvocationExpression_parameterElements() <em>Invocation Expression parameter Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InvocationExpression_parameterElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INVOCATION_EXPRESSION_PARAMETER_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__InvocationExpression_parameterElements()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterFromProperty(org.eclipse.papyrus.uml.alf.ElementReference) <em>Parameter From Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterFromProperty(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_FROM_PROPERTY_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterFromProperty__ElementReference()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #parameterFromPropertyWithMultiplicity(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String, java.lang.String) <em>Parameter From Property With Multiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterFromPropertyWithMultiplicity(org.eclipse.papyrus.uml.alf.ElementReference, java.lang.String, java.lang.String)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_FROM_PROPERTY_WITH_MULTIPLICITY_ELEMENT_REFERENCE_STRING_STRING__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__ParameterFromPropertyWithMultiplicity__ElementReference_String_String()).getInvocationDelegate();
	/**
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInvocationExpression__UpdateAssignments()).getInvocationDelegate();
	/**
	 * The cached validation expression for the '{@link #invocationExpressionTemplateParameters(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Invocation Expression Template Parameters</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #invocationExpressionTemplateParameters(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INVOCATION_EXPRESSION_TEMPLATE_PARAMETERS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      let referent = self.referent in\n" +
		"        referent <> null implies\n" +
		"          let template = referent.template() in\n" +
		"            template <> null implies \n" +
		"              let parameters = template.templateParameters() in\n" +
		"              let actuals = referent.templateActuals() in\n" +
		"                parameters->size() = actuals->size() and\n" +
		"                parameters->size() <> 0 implies\n" +
		"                  Sequence{1..parameters->size()}->forAll(i |\n" +
		"                    let parameter = parameters->at(i) in\n" +
		"                    let actual = actuals->at(i) in\n" +
		"                      parameter.isClassifierTemplateParameter() and\n" +
		"                      parameter.parents()->forAll(p | actual.conformsTo(p))\n" +
		"                    )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference referent() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private ElementReference referent = null;
	private boolean notResolved = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ElementReference referentCached() {
		if (this.notResolved) {
			this.referent = this.referent();
			this.notResolved = false;
		}
		return this.referent;
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
			case AlfPackage.INVOCATION_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.INVOCATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.INVOCATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.INVOCATION_EXPRESSION___REFERENT_CACHED:
				return referentCached();
			case AlfPackage.INVOCATION_EXPRESSION___TYPE:
				return type();
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_TYPE:
				return InvocationExpression_type();
			case AlfPackage.INVOCATION_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_UPPER:
				return InvocationExpression_upper();
			case AlfPackage.INVOCATION_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_LOWER:
				return InvocationExpression_lower();
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_NAMED__STRING:
				return parameterNamed((String)arguments.get(0));
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_COUNT:
				return parameterCount();
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_IS_ASSIGNABLE_FROM__INPUTNAMEDEXPRESSION:
				return parameterIsAssignableFrom((InputNamedExpression)arguments.get(0));
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_IS_ASSIGNABLE_TO__OUTPUTNAMEDEXPRESSION:
				return parameterIsAssignableTo((OutputNamedExpression)arguments.get(0));
			case AlfPackage.INVOCATION_EXPRESSION___ALTERNATIVE_CONSTRUCTOR_IS_VALID:
				return alternativeConstructorIsValid();
			case AlfPackage.INVOCATION_EXPRESSION___BIND_TEMPLATE_IMPLICIT_ARGUMENTS__ELEMENTREFERENCE_EXPRESSION:
				return bindTemplateImplicitArguments((ElementReference)arguments.get(0), (Expression)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___BIND_TEMPLATE_IMPLICIT_ARGUMENTS1__ELEMENTREFERENCE_EXPRESSION:
				return bindTemplateImplicitArguments1((ElementReference)arguments.get(0), (Expression)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___EFFECTIVE_TYPE__ELEMENTREFERENCE_EXPRESSION:
				return effectiveType((ElementReference)arguments.get(0), (Expression)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_ELEMENTS:
				return parameterElements();
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_PARAMETER_ELEMENTS:
				return InvocationExpression_parameterElements();
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_FROM_PROPERTY__ELEMENTREFERENCE:
				return parameterFromProperty((ElementReference)arguments.get(0));
			case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_FROM_PROPERTY_WITH_MULTIPLICITY__ELEMENTREFERENCE_STRING_STRING:
				return parameterFromPropertyWithMultiplicity((ElementReference)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_BEHAVIOR_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsBehaviorDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_ASSOCIATION_END_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsAssociationEndDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_OPERATION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsOperationDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_DESTRUCTOR_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsDestructorDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_IMPLICIT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsImplicitDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_IS_SIGNAL_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionIsSignalDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_PARAMETER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionParameterDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INVOCATION_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
			case AlfPackage.INVOCATION_EXPRESSION___INVOCATION_EXPRESSION_TEMPLATE_PARAMETERS__DIAGNOSTICCHAIN_MAP:
				return invocationExpressionTemplateParameters((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // InvocationExpressionImpl
