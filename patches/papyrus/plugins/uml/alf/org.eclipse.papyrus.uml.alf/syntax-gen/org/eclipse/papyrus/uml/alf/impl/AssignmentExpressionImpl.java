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
import org.eclipse.papyrus.uml.alf.AssignmentExpression;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.LeftHandSide;

import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsIndexed <em>Is Indexed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsArithmetic <em>Is Arithmetic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsLogical <em>Is Logical</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsShift <em>Is Shift</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsConcatenation <em>Is Concatenation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsDefinition <em>Is Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsSimple <em>Is Simple</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsFeature <em>Is Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsDataValueUpdate <em>Is Data Value Update</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.AssignmentExpressionImpl#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getAssignmentExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperator() {
		return (String)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_Operator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(String newOperator) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_Operator(), newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSide getLeftHandSide() {
		return (LeftHandSide)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_LeftHandSide(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftHandSide(LeftHandSide newLeftHandSide) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_LeftHandSide(), newLeftHandSide);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRightHandSide() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_RightHandSide(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightHandSide(Expression newRightHandSide) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_RightHandSide(), newRightHandSide);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignedSource getAssignment() {
		return (AssignedSource)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_Assignment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignment(AssignedSource newAssignment) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_Assignment(), newAssignment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getFeature() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_Feature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(ElementReference newFeature) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_Feature(), newFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIndexed() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsIndexed(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIndexed(boolean newIsIndexed) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsIndexed(), newIsIndexed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsArithmetic() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsArithmetic(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsArithmetic(boolean newIsArithmetic) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsArithmetic(), newIsArithmetic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLogical() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsLogical(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLogical(boolean newIsLogical) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsLogical(), newIsLogical);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsShift() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsShift(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsShift(boolean newIsShift) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsShift(), newIsShift);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsConcatenation() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsConcatenation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConcatenation(boolean newIsConcatenation) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsConcatenation(), newIsConcatenation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDefinition() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsDefinition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDefinition(boolean newIsDefinition) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsDefinition(), newIsDefinition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSimple() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsSimple(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSimple(boolean newIsSimple) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsSimple(), newIsSimple);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFeature() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsFeature(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFeature(boolean newIsFeature) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsFeature(), newIsFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDataValueUpdate() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsDataValueUpdate(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDataValueUpdate(boolean newIsDataValueUpdate) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsDataValueUpdate(), newIsDataValueUpdate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollectionConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsCollectionConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollectionConversion(boolean newIsCollectionConversion) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsCollectionConversion(), newIsCollectionConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBitStringConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getAssignmentExpression_IsBitStringConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBitStringConversion(boolean newIsBitStringConversion) {
		eSet(AlfPackage.eINSTANCE.getAssignmentExpression_IsBitStringConversion(), newIsBitStringConversion);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignmentExpression__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignmentExpression__Upper()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignmentExpression__Lower()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	public boolean assignmentExpressionIsSimpleDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_SIMPLE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsSimpleDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsArithmeticDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_ARITHMETIC_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsArithmeticDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsDefinitionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_DEFINITION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsDefinitionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsIndexedDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_INDEXED_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsIndexedDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsDataValueUpdateDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsDataValueUpdateDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionAssignmentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_ASSIGNMENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionAssignmentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionExpressionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_EXPRESSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionExpressionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #assignmentExpressionSimpleAssignmentTypeConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assignment Expression Simple Assignment Type Conformance</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentExpressionSimpleAssignmentTypeConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_TYPE_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        (self.isSimple and not self.isDefinition) implies\n" +
		"          self.leftHandSide.isTypeConformantWith(self.rightHandSide)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionSimpleAssignmentTypeConformance(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAssignmentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentExpressionSimpleAssignmentTypeConformance__DiagnosticChain_Map(),
				 ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_TYPE_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_TYPE_CONFORMANCE);
	}

	/**
	 * The cached validation expression for the '{@link #assignmentExpressionSimpleAssignmentMultiplicityConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assignment Expression Simple Assignment Multiplicity Conformance</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentExpressionSimpleAssignmentMultiplicityConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_MULTIPLICITY_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        (self.isSimple and not self.isDefinition) implies\n" +
		"          self.leftHandSide.isMultiplicityConformantWith(self.rightHandSide)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionSimpleAssignmentMultiplicityConformance(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAssignmentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentExpressionSimpleAssignmentMultiplicityConformance__DiagnosticChain_Map(),
				 ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_MULTIPLICITY_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_MULTIPLICITY_CONFORMANCE);
	}

	/**
	 * The cached validation expression for the '{@link #assignmentExpressionCompoundAssignmentTypeConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assignment Expression Compound Assignment Type Conformance</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentExpressionCompoundAssignmentTypeConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_TYPE_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"    not self.isSimple implies\n" +
		"      let lhsType = self.leftHandSide.type in\n" +
		"      let rhsType = self.rightHandSide.type in\n" +
		"        lhsType <> null and rhsType <> null and\n" +
		"          (self.isArithmetic and \n" +
		"            self.isIntegerType(lhsType) and self.isIntegerType(rhsType) or\n" +
		"           self.isLogical and\n" +
		"            (self.isBooleanType(lhsType) and self.isBooleanType(rhsType) or\n" +
		"             self.isBitStringType(lhsType) and \n" +
		"              (self.isBitStringType(rhsType) or self.isIntegerType(rhsType))\n" +
		"            ) or\n" +
		"           self.isShift and\n" +
		"            self.isBitStringType(lhsType) and self.isIntegerType(rhsType) or\n" +
		"           self.isConcatenation and\n" +
		"            self.isStringType(lhsType) and self.isStringType(rhsType)\n" +
		"          )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionCompoundAssignmentTypeConformance(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAssignmentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentExpressionCompoundAssignmentTypeConformance__DiagnosticChain_Map(),
				 ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_TYPE_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_TYPE_CONFORMANCE);
	}

	/**
	 * The cached validation expression for the '{@link #assignmentExpressionCompoundAssignmentMultiplicityConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assignment Expression Compound Assignment Multiplicity Conformance</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentExpressionCompoundAssignmentMultiplicityConformance(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_MULTIPLICITY_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "(not self.isSimple) implies \n" +
		"                (self.leftHandSide.upper = 1 and self.rightHandSide.upper = 1)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionCompoundAssignmentMultiplicityConformance(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAssignmentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentExpressionCompoundAssignmentMultiplicityConformance__DiagnosticChain_Map(),
				 ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_MULTIPLICITY_CONFORMANCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_MULTIPLICITY_CONFORMANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsCollectionConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean assignmentExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "assignmentExpressionIsBitStringConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #assignmentExpressionDataValueUpdateLegality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Assignment Expression Data Value Update Legality</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentExpressionDataValueUpdateLegality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_EXPRESSION_DATA_VALUE_UPDATE_LEGALITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let feature = self.leftHandSide.feature() in\n" +
		"          feature <> null implies\n" +
		"            let type = feature.expression.type in\n" +
		"              (type <> null and type.isDataType()) implies\n" +
		"                self.isDataValueUpdate";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean assignmentExpressionDataValueUpdateLegality(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getAssignmentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getAssignmentExpression__AssignmentExpressionDataValueUpdateLegality__DiagnosticChain_Map(),
				 ASSIGNMENT_EXPRESSION_DATA_VALUE_UPDATE_LEGALITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.ASSIGNMENT_EXPRESSION__ASSIGNMENT_EXPRESSION_DATA_VALUE_UPDATE_LEGALITY);
	}

	/**
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getAssignmentExpression__UpdateAssignments()).getInvocationDelegate();

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
		if (baseClass == SyntaxElement.class) {
			switch (baseOperationID) {
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.ASSIGNMENT_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.ASSIGNMENT_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.ASSIGNMENT_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.ASSIGNMENT_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.ASSIGNMENT_EXPRESSION___TYPE:
				return type();
			case AlfPackage.ASSIGNMENT_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.ASSIGNMENT_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_SIMPLE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsSimpleDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_ARITHMETIC_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsArithmeticDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_DEFINITION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsDefinitionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_INDEXED_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsIndexedDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_DATA_VALUE_UPDATE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsDataValueUpdateDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_ASSIGNMENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionAssignmentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_EXPRESSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionExpressionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_TYPE_CONFORMANCE__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionSimpleAssignmentTypeConformance((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_SIMPLE_ASSIGNMENT_MULTIPLICITY_CONFORMANCE__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionSimpleAssignmentMultiplicityConformance((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_TYPE_CONFORMANCE__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionCompoundAssignmentTypeConformance((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_COMPOUND_ASSIGNMENT_MULTIPLICITY_CONFORMANCE__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionCompoundAssignmentMultiplicityConformance((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsCollectionConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionIsBitStringConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___ASSIGNMENT_EXPRESSION_DATA_VALUE_UPDATE_LEGALITY__DIAGNOSTICCHAIN_MAP:
				return assignmentExpressionDataValueUpdateLegality((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.ASSIGNMENT_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
		}
		return super.eInvoke(operationID, arguments);
	}

} // AssignmentExpressionImpl
