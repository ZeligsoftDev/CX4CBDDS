/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Invocation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.FeatureInvocationExpressionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureInvocationExpressionImpl extends InvocationExpressionImpl implements FeatureInvocationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureInvocationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getFeatureInvocationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference getTarget() {
		return (FeatureReference)eGet(AlfPackage.eINSTANCE.getFeatureInvocationExpression_Target(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(FeatureReference newTarget) {
		eSet(AlfPackage.eINSTANCE.getFeatureInvocationExpression_Target(), newTarget);
	}

	/**
	 * The cached invocation delegate for the '{@link #feature() <em>Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #feature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureInvocationExpression__Feature()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureInvocationExpression__Referent()).getInvocationDelegate();

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
	 * @generated
	 */
	public boolean featureInvocationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureInvocationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureInvocationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureInvocationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #featureInvocationExpressionReferentExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Invocation Expression Referent Exists</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureInvocationExpressionReferentExists(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_INVOCATION_EXPRESSION_REFERENT_EXISTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.isImplicit or self.referent <> null and\n" +
		"          -- TODO: Remove this check once overloading resolution is implemented.\n" +
		"          self.tuple.size() <= self.parameterCount() and\n" +
		"          self.tuple.input()->forAll(input | self.parameterIsAssignableFrom(input)) and\n" +
		"          self.tuple.output()->forAll(output | self.parameterIsAssignableTo(output))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureInvocationExpressionReferentExists(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureInvocationExpression__FeatureInvocationExpressionReferentExists__DiagnosticChain_Map(),
				 FEATURE_INVOCATION_EXPRESSION_REFERENT_EXISTS_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_REFERENT_EXISTS);
	}

	/**
	 * The cached validation expression for the '{@link #featureInvocationExpressionAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Invocation Expression Alternative Constructor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureInvocationExpressionAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.alternativeConstructorIsValid()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureInvocationExpressionAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureInvocationExpression__FeatureInvocationExpressionAlternativeConstructor__DiagnosticChain_Map(),
				 FEATURE_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR);
	}

	/**
	 * The cached validation expression for the '{@link #featureInvocationExpressionImplicitAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Invocation Expression Implicit Alternative Constructor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureInvocationExpressionImplicitAlternativeConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_INVOCATION_EXPRESSION_IMPLICIT_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.target = null implies\n" +
		"          let referent = self.referent in\n" +
		"            referent <> null and referent.isConstructor()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureInvocationExpressionImplicitAlternativeConstructor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureInvocationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureInvocationExpression__FeatureInvocationExpressionImplicitAlternativeConstructor__DiagnosticChain_Map(),
				 FEATURE_INVOCATION_EXPRESSION_IMPLICIT_ALTERNATIVE_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_INVOCATION_EXPRESSION__FEATURE_INVOCATION_EXPRESSION_IMPLICIT_ALTERNATIVE_CONSTRUCTOR);
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
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE_INVOCATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureInvocationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE_INVOCATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureInvocationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE_INVOCATION_EXPRESSION_REFERENT_EXISTS__DIAGNOSTICCHAIN_MAP:
				return featureInvocationExpressionReferentExists((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE_INVOCATION_EXPRESSION_ALTERNATIVE_CONSTRUCTOR__DIAGNOSTICCHAIN_MAP:
				return featureInvocationExpressionAlternativeConstructor((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION___FEATURE_INVOCATION_EXPRESSION_IMPLICIT_ALTERNATIVE_CONSTRUCTOR__DIAGNOSTICCHAIN_MAP:
				return featureInvocationExpressionImplicitAlternativeConstructor((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // FeatureInvocationExpressionImpl
