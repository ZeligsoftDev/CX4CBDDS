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
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.BehaviorInvocationExpressionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorInvocationExpressionImpl extends InvocationExpressionImpl implements BehaviorInvocationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorInvocationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getBehaviorInvocationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTarget() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getBehaviorInvocationExpression_Target(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(QualifiedName newTarget) {
		eSet(AlfPackage.eINSTANCE.getBehaviorInvocationExpression_Target(), newTarget);
	}

	/**
	 * The cached invocation delegate for the '{@link #isAddTarget(org.eclipse.papyrus.uml.alf.Expression) <em>Is Add Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddTarget(org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBehaviorInvocationExpression__IsAddTarget__Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddTarget(Expression targetExpression) {
		try {
			return (Boolean)IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{targetExpression}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBehaviorInvocationExpression__Referent()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference referent() {
		try {
			return (ElementReference)REFERENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public ElementReference referent1() {
		return BehaviorInvocation_referent();
	}

	/**
	 * The cached invocation delegate for the '{@link #BehaviorInvocation_referent() <em>Behavior Invocation referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BehaviorInvocation_referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate BEHAVIOR_INVOCATION_REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBehaviorInvocationExpression__BehaviorInvocation_referent()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference BehaviorInvocation_referent() {
		try {
			return (ElementReference)BEHAVIOR_INVOCATION_REFERENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #feature() <em>Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #feature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getBehaviorInvocationExpression__Feature()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference feature() {
		try {
			return (FeatureReference)FEATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean behaviorInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "behaviorInvocationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean behaviorInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "behaviorInvocationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #behaviorInvocationExpressionReferentConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Behavior Invocation Expression Referent Constraint</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #behaviorInvocationExpressionReferentConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_CONSTRAINT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.isImplicit or \n" +
		"        let referent = self.referent in\n" +
		"          referent <> null and \n" +
		"          -- NOTE: This check prevents the invocation from disambiguating to an \n" +
		"          -- illegal constructor invocation.\n" +
		"          not referent.isConstructor() and\n" +
		"          -- Also check that the association owns all its ends.\n" +
		"          referent.isAssociationEnd() implies\n" +
		"          \treferent.association().properties()->forAll(isAssociationEnd())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean behaviorInvocationExpressionReferentConstraint(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getBehaviorInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getBehaviorInvocationExpression__BehaviorInvocationExpressionReferentConstraint__DiagnosticChain_Map(),
				 BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_CONSTRAINT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_CONSTRAINT);
	}

	/**
	 * The cached validation expression for the '{@link #behaviorInvocationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Behavior Invocation Expression Argument Compatibility</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #behaviorInvocationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_INVOCATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        -- TODO: Handle overloading for feature invocations.\n" +
		"        self.tuple.size() <= self.parameterCount() and\n" +
		"        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n" +
		"        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean behaviorInvocationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getBehaviorInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getBehaviorInvocationExpression__BehaviorInvocationExpressionArgumentCompatibility__DiagnosticChain_Map(),
				 BEHAVIOR_INVOCATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_ARGUMENT_COMPATIBILITY);
	}

	/**
	 * The cached validation expression for the '{@link #behaviorInvocationExpressionAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Behavior Invocation Expression Alternative Constructor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #behaviorInvocationExpressionAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.alternativeConstructorIsValid()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean behaviorInvocationExpressionAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getBehaviorInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getBehaviorInvocationExpression__BehaviorInvocationExpressionAlternativeConstructor__DiagnosticChain_Map(),
				 BEHAVIOR_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.BEHAVIOR_INVOCATION_EXPRESSION__BEHAVIOR_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___IS_ADD_TARGET__EXPRESSION: return AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___IS_ADD_TARGET__EXPRESSION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == InvocationExpression.class) {
			switch (baseOperationID) {
				case AlfPackage.INVOCATION_EXPRESSION___FEATURE: return AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___FEATURE;
				case AlfPackage.INVOCATION_EXPRESSION___REFERENT: return AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___REFERENT;
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
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___IS_ADD_TARGET__EXPRESSION:
				return isAddTarget((Expression)arguments.get(0));
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___REFERENT1:
				return referent1();
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_REFERENT:
				return BehaviorInvocation_referent();
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return behaviorInvocationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return behaviorInvocationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_EXPRESSION_REFERENT_CONSTRAINT__DIAGNOSTICCHAIN_MAP:
				return behaviorInvocationExpressionReferentConstraint((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_EXPRESSION_ARGUMENT_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return behaviorInvocationExpressionArgumentCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION___BEHAVIOR_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR__DIAGNOSTICCHAIN_MAP:
				return behaviorInvocationExpressionAlternativeConstructor((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // BehaviorInvocationExpressionImpl
