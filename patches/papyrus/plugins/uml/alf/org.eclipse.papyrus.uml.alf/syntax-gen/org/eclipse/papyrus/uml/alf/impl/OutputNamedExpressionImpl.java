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
import org.eclipse.papyrus.uml.alf.LeftHandSide;
import org.eclipse.papyrus.uml.alf.OutputNamedExpression;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Named Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.OutputNamedExpressionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputNamedExpressionImpl extends InputNamedExpressionImpl implements OutputNamedExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputNamedExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getOutputNamedExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSide getLeftHandSide() {
		return (LeftHandSide)eGet(AlfPackage.eINSTANCE.getOutputNamedExpression_LeftHandSide(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftHandSide(LeftHandSide newLeftHandSide) {
		eSet(AlfPackage.eINSTANCE.getOutputNamedExpression_LeftHandSide(), newLeftHandSide);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean outputNamedExpressionLeftHandSideDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.OUTPUT_NAMED_EXPRESSION__OUTPUT_NAMED_EXPRESSION_LEFT_HAND_SIDE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "outputNamedExpressionLeftHandSideDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #outputNamedExpressionForm(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Output Named Expression Form</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #outputNamedExpressionForm(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_NAMED_EXPRESSION_FORM_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.expression = null or self.hasLegalExpression()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean outputNamedExpressionForm(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getOutputNamedExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getOutputNamedExpression__OutputNamedExpressionForm__DiagnosticChain_Map(),
				 OUTPUT_NAMED_EXPRESSION_FORM_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.OUTPUT_NAMED_EXPRESSION__OUTPUT_NAMED_EXPRESSION_FORM);
	}

	/**
	 * The cached invocation delegate for the '{@link #hasLegalExpression() <em>Has Legal Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #hasLegalExpression()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate HAS_LEGAL_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getOutputNamedExpression__HasLegalExpression()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasLegalExpression() {
		try {
			return (Boolean)HAS_LEGAL_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case AlfPackage.OUTPUT_NAMED_EXPRESSION___OUTPUT_NAMED_EXPRESSION_LEFT_HAND_SIDE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return outputNamedExpressionLeftHandSideDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.OUTPUT_NAMED_EXPRESSION___OUTPUT_NAMED_EXPRESSION_FORM__DIAGNOSTICCHAIN_MAP:
				return outputNamedExpressionForm((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.OUTPUT_NAMED_EXPRESSION___HAS_LEGAL_EXPRESSION:
				return hasLegalExpression();
		}
		return super.eInvoke(operationID, arguments);
	}

} // OutputNamedExpressionImpl
