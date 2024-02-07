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
import org.eclipse.papyrus.uml.alf.SequenceAccessExpression;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceAccessExpressionImpl#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.SequenceAccessExpressionImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceAccessExpressionImpl extends ExpressionImpl implements SequenceAccessExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getSequenceAccessExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getPrimary() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getSequenceAccessExpression_Primary(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(Expression newPrimary) {
		eSet(AlfPackage.eINSTANCE.getSequenceAccessExpression_Primary(), newPrimary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIndex() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getSequenceAccessExpression_Index(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(Expression newIndex) {
		eSet(AlfPackage.eINSTANCE.getSequenceAccessExpression_Index(), newIndex);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceAccessExpression__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceAccessExpression__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceAccessExpression__Upper()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #updateAssignments() <em>Update Assignments</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #updateAssignments()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate UPDATE_ASSIGNMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getSequenceAccessExpression__UpdateAssignments()).getInvocationDelegate();

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
	public boolean sequenceAccessExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceAccessExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceAccessExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceAccessExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean sequenceAccessExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sequenceAccessExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #sequenceAccessExpressionIndexType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Access Expression Index Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceAccessExpressionIndexType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_ACCESS_EXPRESSION_INDEX_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let type = self.index.type in\n" +
		"          type <> null and self.isIntegerType(type)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceAccessExpressionIndexType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceAccessExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceAccessExpression__SequenceAccessExpressionIndexType__DiagnosticChain_Map(),
				 SEQUENCE_ACCESS_EXPRESSION_INDEX_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_INDEX_TYPE);
	}

	/**
	 * The cached validation expression for the '{@link #sequenceAccessExpressionIndexMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Access Expression Index Multiplicity</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #sequenceAccessExpressionIndexMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_ACCESS_EXPRESSION_INDEX_MULTIPLICITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.index.upper = 1";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sequenceAccessExpressionIndexMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getSequenceAccessExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getSequenceAccessExpression__SequenceAccessExpressionIndexMultiplicity__DiagnosticChain_Map(),
				 SEQUENCE_ACCESS_EXPRESSION_INDEX_MULTIPLICITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.SEQUENCE_ACCESS_EXPRESSION__SEQUENCE_ACCESS_EXPRESSION_INDEX_MULTIPLICITY);
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
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.SEQUENCE_ACCESS_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.SEQUENCE_ACCESS_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.SEQUENCE_ACCESS_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Expression.class) {
			switch (baseOperationID) {
				case AlfPackage.EXPRESSION___UPDATE_ASSIGNMENTS: return AlfPackage.SEQUENCE_ACCESS_EXPRESSION___UPDATE_ASSIGNMENTS;
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
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___TYPE:
				return type();
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___UPDATE_ASSIGNMENTS:
				return updateAssignments();
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___SEQUENCE_ACCESS_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceAccessExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___SEQUENCE_ACCESS_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceAccessExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___SEQUENCE_ACCESS_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return sequenceAccessExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___SEQUENCE_ACCESS_EXPRESSION_INDEX_TYPE__DIAGNOSTICCHAIN_MAP:
				return sequenceAccessExpressionIndexType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION___SEQUENCE_ACCESS_EXPRESSION_INDEX_MULTIPLICITY__DIAGNOSTICCHAIN_MAP:
				return sequenceAccessExpressionIndexMultiplicity((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SequenceAccessExpressionImpl
