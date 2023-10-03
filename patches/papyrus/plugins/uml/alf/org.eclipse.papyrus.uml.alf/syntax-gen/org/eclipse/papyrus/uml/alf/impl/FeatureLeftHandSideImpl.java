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
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureLeftHandSide;
import org.eclipse.papyrus.uml.alf.FeatureReference;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Left Hand Side</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.FeatureLeftHandSideImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureLeftHandSideImpl extends LeftHandSideImpl implements FeatureLeftHandSide {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureLeftHandSideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getFeatureLeftHandSide();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getFeatureLeftHandSide_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getFeatureLeftHandSide_Expression(), newExpression);
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureLeftHandSide__Referent()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #feature() <em>Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #feature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureLeftHandSide__Feature()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #expression() <em>Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #expression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureLeftHandSide__Expression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression expression() {
		try {
			return (Expression)EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #index() <em>Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #index()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate INDEX__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureLeftHandSide__Index()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression index() {
		try {
			return (Expression)INDEX__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #localName() <em>Local Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localName()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOCAL_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getFeatureLeftHandSide__LocalName()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String localName() {
		try {
			return (String)LOCAL_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean featureLeftHandSideAssignmentBeforeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_BEFORE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideAssignmentBeforeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureLeftHandSideAssignmentAfterDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideAssignmentAfterDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #featureLeftHandSideFeatureExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Left Hand Side Feature Expression</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureLeftHandSideFeatureExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_LEFT_HAND_SIDE_FEATURE_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let expression = self.feature().expression in\n" +
		"        let type = expression.type in\n" +
		"          expression.upper = 1 and\n" +
		"          -- Note: The following condition ensures that a data value update will\n" +
		"          -- be to an existing assigned name.\n" +
		"          (type <> null and type.isDataType()) implies self.isDataValueUpdate()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureLeftHandSideFeatureExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureLeftHandSide__FeatureLeftHandSideFeatureExpression__DiagnosticChain_Map(),
				 FEATURE_LEFT_HAND_SIDE_FEATURE_EXPRESSION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_FEATURE_EXPRESSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureLeftHandSideAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureLeftHandSideReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureLeftHandSideTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureLeftHandSideLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean featureLeftHandSideUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "featureLeftHandSideUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #featureLeftHandSideReferentConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Left Hand Side Referent Constraint</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureLeftHandSideReferentConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_LEFT_HAND_SIDE_REFERENT_CONSTRAINT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.referent <> null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureLeftHandSideReferentConstraint(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureLeftHandSide__FeatureLeftHandSideReferentConstraint__DiagnosticChain_Map(),
				 FEATURE_LEFT_HAND_SIDE_REFERENT_CONSTRAINT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_REFERENT_CONSTRAINT);
	}

	/**
	 * The cached validation expression for the '{@link #featureLeftHandSideIndexedFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Feature Left Hand Side Indexed Feature</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #featureLeftHandSideIndexedFeature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_LEFT_HAND_SIDE_INDEXED_FEATURE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.index() <> null implies\n" +
		"          let referent = self.referent in\n" +
		"            referent <> null and referent.isOrdered() and referent.isNonunique()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean featureLeftHandSideIndexedFeature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getFeatureLeftHandSide(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getFeatureLeftHandSide__FeatureLeftHandSideIndexedFeature__DiagnosticChain_Map(),
				 FEATURE_LEFT_HAND_SIDE_INDEXED_FEATURE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.FEATURE_LEFT_HAND_SIDE__FEATURE_LEFT_HAND_SIDE_INDEXED_FEATURE);
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
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___REFERENT:
				return referent();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE:
				return feature();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___EXPRESSION:
				return expression();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___INDEX:
				return index();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___LOCAL_NAME:
				return localName();
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_BEFORE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideAssignmentBeforeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_ASSIGNMENT_AFTER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideAssignmentAfterDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_FEATURE_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideFeatureExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_REFERENT_CONSTRAINT__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideReferentConstraint((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.FEATURE_LEFT_HAND_SIDE___FEATURE_LEFT_HAND_SIDE_INDEXED_FEATURE__DIAGNOSTICCHAIN_MAP:
				return featureLeftHandSideIndexedFeature((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // FeatureLeftHandSideImpl
