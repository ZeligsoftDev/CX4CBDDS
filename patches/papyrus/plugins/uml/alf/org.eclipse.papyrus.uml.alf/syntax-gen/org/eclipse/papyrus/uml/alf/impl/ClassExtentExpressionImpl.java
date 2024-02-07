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
import org.eclipse.papyrus.uml.alf.ClassExtentExpression;
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Extent Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.ClassExtentExpressionImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassExtentExpressionImpl extends ExpressionImpl implements ClassExtentExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassExtentExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getClassExtentExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getClassName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getClassExtentExpression_ClassName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(QualifiedName newClassName) {
		eSet(AlfPackage.eINSTANCE.getClassExtentExpression_ClassName(), newClassName);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassExtentExpression__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassExtentExpression__Upper()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassExtentExpression__Lower()).getInvocationDelegate();

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
	public boolean classExtentExpressionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classExtentExpressionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean classExtentExpressionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classExtentExpressionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean classExtentExpressionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "classExtentExpressionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #classExtentExpressionExtentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Class Extent Expression Extent Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #classExtentExpressionExtentType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EXTENT_EXPRESSION_EXTENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "self.validateClassExtentExpressionExtentType()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean classExtentExpressionExtentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getClassExtentExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getClassExtentExpression__ClassExtentExpressionExtentType__DiagnosticChain_Map(),
				 CLASS_EXTENT_EXPRESSION_EXTENT_TYPE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.CLASS_EXTENT_EXPRESSION__CLASS_EXTENT_EXPRESSION_EXTENT_TYPE);
	}

	/**
	 * The cached invocation delegate for the '{@link #validateClassExtentExpressionExtentType() <em>Validate Class Extent Expression Extent Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #validateClassExtentExpressionExtentType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate VALIDATE_CLASS_EXTENT_EXPRESSION_EXTENT_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getClassExtentExpression__ValidateClassExtentExpressionExtentType()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassExtentExpressionExtentType() {
		try {
			return (Boolean)VALIDATE_CLASS_EXTENT_EXPRESSION_EXTENT_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
			case AlfPackage.CLASS_EXTENT_EXPRESSION___TYPE:
				return type();
			case AlfPackage.CLASS_EXTENT_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.CLASS_EXTENT_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.CLASS_EXTENT_EXPRESSION___CLASS_EXTENT_EXPRESSION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return classExtentExpressionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASS_EXTENT_EXPRESSION___CLASS_EXTENT_EXPRESSION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return classExtentExpressionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASS_EXTENT_EXPRESSION___CLASS_EXTENT_EXPRESSION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return classExtentExpressionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASS_EXTENT_EXPRESSION___CLASS_EXTENT_EXPRESSION_EXTENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return classExtentExpressionExtentType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.CLASS_EXTENT_EXPRESSION___VALIDATE_CLASS_EXTENT_EXPRESSION_EXTENT_TYPE:
				return validateClassExtentExpressionExtentType();
		}
		return super.eInvoke(operationID, arguments);
	}

} // ClassExtentExpressionImpl
