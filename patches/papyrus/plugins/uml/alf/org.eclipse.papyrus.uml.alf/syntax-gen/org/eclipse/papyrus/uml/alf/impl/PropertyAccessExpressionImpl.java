/**
 */
package org.eclipse.papyrus.uml.alf.impl;

import java.lang.reflect.InvocationTargetException;

import java.math.BigInteger;
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
import org.eclipse.papyrus.uml.alf.AssignableElement;
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.PropertyAccessExpression;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyAccessExpressionImpl#getFeatureReference <em>Feature Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyAccessExpressionImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyAccessExpressionImpl extends ExpressionImpl implements PropertyAccessExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getPropertyAccessExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference getFeatureReference() {
		return (FeatureReference)eGet(AlfPackage.eINSTANCE.getPropertyAccessExpression_FeatureReference(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureReference(FeatureReference newFeatureReference) {
		eSet(AlfPackage.eINSTANCE.getPropertyAccessExpression_FeatureReference(), newFeatureReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getFeature() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getPropertyAccessExpression_Feature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(ElementReference newFeature) {
		eSet(AlfPackage.eINSTANCE.getPropertyAccessExpression_Feature(), newFeature);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyAccessExpression__Type()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #upper() <em>Upper</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #upper()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyAccessExpression__Upper()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #lower() <em>Lower</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #lower()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyAccessExpression__Lower()).getInvocationDelegate();

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
	public boolean propertyAccessExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyAccessExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean propertyAccessExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyAccessExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean propertyAccessExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyAccessExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean propertyAccessExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyAccessExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #propertyAccessExpressionFeatureResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Property Access Expression Feature Resolution</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #propertyAccessExpressionFeatureResolution(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_ACCESS_EXPRESSION_FEATURE_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.feature <> null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean propertyAccessExpressionFeatureResolution(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getPropertyAccessExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getPropertyAccessExpression__PropertyAccessExpressionFeatureResolution__DiagnosticChain_Map(),
				 PROPERTY_ACCESS_EXPRESSION_FEATURE_RESOLUTION_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_FEATURE_RESOLUTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean propertyAccessExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_ACCESS_EXPRESSION__PROPERTY_ACCESS_EXPRESSION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyAccessExpressionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyAccessExpression__UpdateAssignments()).getInvocationDelegate();

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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.PROPERTY_ACCESS_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.PROPERTY_ACCESS_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.PROPERTY_ACCESS_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.PROPERTY_ACCESS_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___TYPE:
				return type();
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_FEATURE_RESOLUTION__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionFeatureResolution((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___PROPERTY_ACCESS_EXPRESSION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return propertyAccessExpressionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
		}
		return super.eInvoke(operationID, arguments);
	}

} // PropertyAccessExpressionImpl
