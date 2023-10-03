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
import org.eclipse.papyrus.uml.alf.AssignedSource;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.alf.ExtentOrExpression;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.LeftHandSide;
import org.eclipse.papyrus.uml.alf.OutputNamedExpression;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.SequenceOperationExpression;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceOperationExpressionImpl#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceOperationExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceOperationExpressionImpl#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceOperationExpressionImpl#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceOperationExpressionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceOperationExpressionImpl extends InvocationExpressionImpl implements SequenceOperationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceOperationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSequenceOperationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtentOrExpression getPrimary() {
		return (ExtentOrExpression)eGet(AlfPackage.eINSTANCE.getSequenceOperationExpression_Primary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(ExtentOrExpression newPrimary) {
		eSet(AlfPackage.eINSTANCE.getSequenceOperationExpression_Primary(), newPrimary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getOperation() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getSequenceOperationExpression_Operation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(QualifiedName newOperation) {
		eSet(AlfPackage.eINSTANCE.getSequenceOperationExpression_Operation(), newOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollectionConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceOperationExpression_IsCollectionConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollectionConversion(boolean newIsCollectionConversion) {
		eSet(AlfPackage.eINSTANCE.getSequenceOperationExpression_IsCollectionConversion(), newIsCollectionConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBitStringConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getSequenceOperationExpression_IsBitStringConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBitStringConversion(boolean newIsBitStringConversion) {
		eSet(AlfPackage.eINSTANCE.getSequenceOperationExpression_IsBitStringConversion(), newIsBitStringConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftHandSide getLeftHandSide() {
		return (LeftHandSide)eGet(AlfPackage.eINSTANCE.getSequenceOperationExpression_LeftHandSide(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftHandSide(LeftHandSide newLeftHandSide) {
		eSet(AlfPackage.eINSTANCE.getSequenceOperationExpression_LeftHandSide(), newLeftHandSide);
	}

	/**
	 * The cached invocation delegate for the '{@link #feature() <em>Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #feature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__Feature()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__Referent()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #isAddTarget(org.eclipse.papyrus.uml.alf.Expression) <em>Is Add Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddTarget(org.eclipse.papyrus.uml.alf.Expression)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ADD_TARGET_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__IsAddTarget__Expression()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #firstParameter() <em>First Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #firstParameter()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FIRST_PARAMETER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__FirstParameter()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference firstParameter() {
		try {
			return (ElementReference)FIRST_PARAMETER__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #firstArgument() <em>First Argument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #firstArgument()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate FIRST_ARGUMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__FirstArgument()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputNamedExpression firstArgument() {
		try {
			return (OutputNamedExpression)FIRST_ARGUMENT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean sequenceOperationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceOperationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #sequenceOperationExpressionOperationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Operation Expression Operation Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceOperationExpressionOperationReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_OPERATION_EXPRESSION_OPERATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let parameter = self.firstParameter() in\n" +
		"          parameter <> null and\n" +
		"            let direction = parameter.direction() in\n" +
		"            let expression = self.primary.expression in\n" +
		"              (direction = 'in' or direction = 'inout') and\n" +
		"              parameter.lower() = 0 and parameter.upper() = -1 and\n" +
		"              expression <> null implies parameter.isAssignableFrom(expression)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionOperationReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceOperationExpression__SequenceOperationExpressionOperationReferent__DiagnosticChain_Map(),
				 SEQUENCE_OPERATION_EXPRESSION_OPERATION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_OPERATION_REFERENT);
	}

	/**
	 * The cached validation expression for the '{@link #sequenceOperationExpressionTargetCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Operation Expression Target Compatibility</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceOperationExpressionTargetCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_OPERATION_EXPRESSION_TARGET_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let expression = self.primary.expression in\n" +
		"        let parameter = self.firstParameter() in\n" +
		"          expression <> null and parameter <> null and \n" +
		"          parameter.direction() = 'inout' implies\n" +
		"            let lhs = self.leftHandSide in\n" +
		"              lhs <> null and \n" +
		"              let assignedName = lhs.assignedName() in\n" +
		"                (assignedName <> null implies \n" +
		"                  self.assignmentBefore->exists(name = assignedName)\n" +
		"                ) and\n" +
		"                let expressionType = self.type in\n" +
		"                let type = parameter.type() in\n" +
		"                  type <> null and type.equals(expressionType) or\n" +
		"                  type = null and expressionType = null";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionTargetCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceOperationExpression__SequenceOperationExpressionTargetCompatibility__DiagnosticChain_Map(),
				 SEQUENCE_OPERATION_EXPRESSION_TARGET_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_TARGET_COMPATIBILITY);
	}

	/**
	 * The cached validation expression for the '{@link #sequenceOperationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Operation Expression Argument Compatibility</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceOperationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.referent <> null implies\n" +
		"          (self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n" +
		"           self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))\n" +
		"          )";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceOperationExpression__SequenceOperationExpressionArgumentCompatibility__DiagnosticChain_Map(),
				 SEQUENCE_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionAssignmentsBefore(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_BEFORE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionAssignmentsBefore", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceOperationExpressionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionIsCollectionConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceOperationExpressionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionIsBitStringConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #sequenceOperationExpressionAssignmentsAfter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Operation Expression Assignments After</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceOperationExpressionAssignmentsAfter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_AFTER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let expression = self.primary.expression in\n" +
		"          expression <> null implies\n" +
		"            expression.newAssignments().name->\n" +
		"              excludesAll(self.tuple.newAssignments().name)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionAssignmentsAfter(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceOperationExpression__SequenceOperationExpressionAssignmentsAfter__DiagnosticChain_Map(),
				 SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_AFTER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_AFTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceOperationExpressionLeftHandSideDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_OPERATION_EXPRESSION__SEQUENCE_OPERATION_EXPRESSION_LEFT_HAND_SIDE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceOperationExpressionLeftHandSideDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__UpdateAssignments()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #parameterElements() <em>Parameter Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceOperationExpression__ParameterElements()).getInvocationDelegate();

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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___UPDATE_ASSIGNMENTS;
				case AlfPackage.EXPRESSION___IS_ADD_TARGET__EXPRESSION: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___IS_ADD_TARGET__EXPRESSION;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == InvocationExpression.class) {
			switch (baseOperationID) {
				case AlfPackage.INVOCATION_EXPRESSION___FEATURE: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___FEATURE;
				case AlfPackage.INVOCATION_EXPRESSION___REFERENT: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___REFERENT;
				case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_ELEMENTS: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___PARAMETER_ELEMENTS;
				case AlfPackage.INVOCATION_EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.SEQUENCE_OPERATION_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___IS_ADD_TARGET__EXPRESSION:
				return isAddTarget((Expression)arguments.get(0));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___FIRST_PARAMETER:
				return firstParameter();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___FIRST_ARGUMENT:
				return firstArgument();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_OPERATION_REFERENT__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionOperationReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_TARGET_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionTargetCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionArgumentCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_BEFORE__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionAssignmentsBefore((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_IS_COLLECTION_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionIsCollectionConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_IS_BIT_STRING_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionIsBitStringConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_ASSIGNMENTS_AFTER__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionAssignmentsAfter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___SEQUENCE_OPERATION_EXPRESSION_LEFT_HAND_SIDE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceOperationExpressionLeftHandSideDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION___PARAMETER_ELEMENTS:
				return parameterElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} // SequenceOperationExpressionImpl
