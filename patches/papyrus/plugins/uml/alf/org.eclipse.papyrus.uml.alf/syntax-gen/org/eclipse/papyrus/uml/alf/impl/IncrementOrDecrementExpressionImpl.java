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
import org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression;
import org.eclipse.papyrus.uml.alf.LeftHandSide;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Increment Or Decrement Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#isIsPrefix <em>Is Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#isIsFeature <em>Is Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#isIsIndexed <em>Is Indexed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#isIsDataValueUpdate <em>Is Data Value Update</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.IncrementOrDecrementExpressionImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncrementOrDecrementExpressionImpl extends ExpressionImpl implements IncrementOrDecrementExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncrementOrDecrementExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getIncrementOrDecrementExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource getAssignment() {
		return (AssignedSource)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Assignment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignment(AssignedSource newAssignment) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Assignment(), newAssignment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSide getOperand() {
		return (LeftHandSide)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Operand(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperand(LeftHandSide newOperand) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Operand(), newOperand);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getFeature() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Feature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(ElementReference newFeature) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Feature(), newFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPrefix() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsPrefix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPrefix(boolean newIsPrefix) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsPrefix(), newIsPrefix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFeature() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsFeature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFeature(boolean newIsFeature) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsFeature(), newIsFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIndexed() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsIndexed(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIndexed(boolean newIsIndexed) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsIndexed(), newIsIndexed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDataValueUpdate() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsDataValueUpdate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDataValueUpdate(boolean newIsDataValueUpdate) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_IsDataValueUpdate(), newIsDataValueUpdate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator() {
		return (String)eGet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator) {
		eSet(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression_Operator(), newOperator);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getIncrementOrDecrementExpression__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getIncrementOrDecrementExpression__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getIncrementOrDecrementExpression__Upper()).getInvocationDelegate();

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
	public boolean incrementOrDecrementExpressionAssignmentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionAssignmentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionIsFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionIsIndexedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_INDEXED_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionIsIndexedDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionIsDataValueUpdateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionIsDataValueUpdateDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_EXPRESSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionExpressionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean incrementOrDecrementExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #incrementOrDecrementExpressionOperand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Increment Or Decrement Expression Operand</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #incrementOrDecrementExpressionOperand(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INCREMENT_OR_DECREMENT_EXPRESSION_OPERAND_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.isIntegerType(self.operand.type) and self.operand.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean incrementOrDecrementExpressionOperand(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getIncrementOrDecrementExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getIncrementOrDecrementExpression__IncrementOrDecrementExpressionOperand__DiagnosticChain_Map(),
				 INCREMENT_OR_DECREMENT_EXPRESSION_OPERAND_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_OPERAND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean incrementOrDecrementExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INCREMENT_OR_DECREMENT_EXPRESSION__INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "incrementOrDecrementExpressionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getIncrementOrDecrementExpression__UpdateAssignments()).getInvocationDelegate();

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
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___TYPE:
				return type();
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionAssignmentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_IS_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionIsFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_IS_INDEXED_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionIsIndexedDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionIsDataValueUpdateDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_EXPRESSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionExpressionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_OPERAND__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionOperand((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___INCREMENT_OR_DECREMENT_EXPRESSION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return incrementOrDecrementExpressionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
		}
		return super.eInvoke(operationID, arguments);
	}

} // IncrementOrDecrementExpressionImpl
