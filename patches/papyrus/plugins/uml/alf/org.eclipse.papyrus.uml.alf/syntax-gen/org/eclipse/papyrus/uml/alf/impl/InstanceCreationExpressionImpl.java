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
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.InstanceCreationExpression;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Creation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InstanceCreationExpressionImpl#isIsConstructorless <em>Is Constructorless</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InstanceCreationExpressionImpl#isIsObjectCreation <em>Is Object Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.InstanceCreationExpressionImpl#getConstructor <em>Constructor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceCreationExpressionImpl extends InvocationExpressionImpl implements InstanceCreationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceCreationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getInstanceCreationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsConstructorless() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInstanceCreationExpression_IsConstructorless(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConstructorless(boolean newIsConstructorless) {
		eSet(AlfPackage.eINSTANCE.getInstanceCreationExpression_IsConstructorless(), newIsConstructorless);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsObjectCreation() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getInstanceCreationExpression_IsObjectCreation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsObjectCreation(boolean newIsObjectCreation) {
		eSet(AlfPackage.eINSTANCE.getInstanceCreationExpression_IsObjectCreation(), newIsObjectCreation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getConstructor() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getInstanceCreationExpression_Constructor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructor(QualifiedName newConstructor) {
		eSet(AlfPackage.eINSTANCE.getInstanceCreationExpression_Constructor(), newConstructor);
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__Referent()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__Feature()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__Upper()).getInvocationDelegate();

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
	public boolean instanceCreationExpressionIsObjectCreationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_IS_OBJECT_CREATION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "instanceCreationExpressionIsObjectCreationDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean instanceCreationExpressionIsConstructorlessDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_IS_CONSTRUCTORLESS_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "instanceCreationExpressionIsConstructorlessDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean instanceCreationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "instanceCreationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean instanceCreationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "instanceCreationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #instanceCreationExpressionConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Instance Creation Expression Constructor</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #instanceCreationExpressionConstructor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CREATION_EXPRESSION_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let referent = self.referent in\n" +
		"          referent <> null and\n" +
		"            (referent.isDataType() or referent.isClass() or referent.isOperation())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean instanceCreationExpressionConstructor(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getInstanceCreationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getInstanceCreationExpression__InstanceCreationExpressionConstructor__DiagnosticChain_Map(),
				 INSTANCE_CREATION_EXPRESSION_CONSTRUCTOR_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_CONSTRUCTOR);
	}

	/**
	 * The cached validation expression for the '{@link #instanceCreationExpressionConstructorlessLegality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Instance Creation Expression Constructorless Legality</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #instanceCreationExpressionConstructorlessLegality(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CREATION_EXPRESSION_CONSTRUCTORLESS_LEGALITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.isConstructorless implies \n" +
		"          self.tuple.size() = 0 and \n" +
		"            not self.referent.ownedMembers()->exists(isConstructor())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean instanceCreationExpressionConstructorlessLegality(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getInstanceCreationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getInstanceCreationExpression__InstanceCreationExpressionConstructorlessLegality__DiagnosticChain_Map(),
				 INSTANCE_CREATION_EXPRESSION_CONSTRUCTORLESS_LEGALITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_CONSTRUCTORLESS_LEGALITY);
	}

	/**
	 * The cached validation expression for the '{@link #instanceCreationExpressionDataTypeCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Instance Creation Expression Data Type Compatibility</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #instanceCreationExpressionDataTypeCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CREATION_EXPRESSION_DATA_TYPE_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        -- TODO: Once overloading resolution is implemented, change this to only\n" +
		"        -- be for data value creation.\n" +
		"        self.tuple.size() <= self.parameterCount() and\n" +
		"        self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input)) and\n" +
		"        self.tuple.output->forAll(output | self.parameterIsAssignableTo(output))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean instanceCreationExpressionDataTypeCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getInstanceCreationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getInstanceCreationExpression__InstanceCreationExpressionDataTypeCompatibility__DiagnosticChain_Map(),
				 INSTANCE_CREATION_EXPRESSION_DATA_TYPE_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_DATA_TYPE_COMPATIBILITY);
	}

	/**
	 * The cached validation expression for the '{@link #instanceCreationExpressionReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Instance Creation Expression Referent</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #instanceCreationExpressionReferent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CREATION_EXPRESSION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        let referent = self.referent in\n" +
		"        let classReferent =\n" +
		"          if referent <> null and referent.isOperation() then \n" +
		"            referent.namespace()\n" +
		"          else\n" +
		"            referent\n" +
		"          endif\n" +
		"        in\n" +
		"          referent <> null and not referent.isAbstractClassifier()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean instanceCreationExpressionReferent(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getInstanceCreationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getInstanceCreationExpression__InstanceCreationExpressionReferent__DiagnosticChain_Map(),
				 INSTANCE_CREATION_EXPRESSION_REFERENT_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.INSTANCE_CREATION_EXPRESSION__INSTANCE_CREATION_EXPRESSION_REFERENT);
	}

	/**
	 * The cached invocation delegate for the '{@link #parameterElements() <em>Parameter Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getInstanceCreationExpression__ParameterElements()).getInvocationDelegate();

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
		if (baseClass == AssignableElement.class) {
			switch (baseOperationID) {
				case AlfPackage.ASSIGNABLE_ELEMENT___TYPE: return AlfPackage.INSTANCE_CREATION_EXPRESSION___TYPE;
				case AlfPackage.ASSIGNABLE_ELEMENT___LOWER: return AlfPackage.INSTANCE_CREATION_EXPRESSION___LOWER;
				case AlfPackage.ASSIGNABLE_ELEMENT___UPPER: return AlfPackage.INSTANCE_CREATION_EXPRESSION___UPPER;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == InvocationExpression.class) {
			switch (baseOperationID) {
				case AlfPackage.INVOCATION_EXPRESSION___FEATURE: return AlfPackage.INSTANCE_CREATION_EXPRESSION___FEATURE;
				case AlfPackage.INVOCATION_EXPRESSION___REFERENT: return AlfPackage.INSTANCE_CREATION_EXPRESSION___REFERENT;
				case AlfPackage.INVOCATION_EXPRESSION___TYPE: return AlfPackage.INSTANCE_CREATION_EXPRESSION___TYPE;
				case AlfPackage.INVOCATION_EXPRESSION___UPPER: return AlfPackage.INSTANCE_CREATION_EXPRESSION___UPPER;
				case AlfPackage.INVOCATION_EXPRESSION___LOWER: return AlfPackage.INSTANCE_CREATION_EXPRESSION___LOWER;
				case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_ELEMENTS: return AlfPackage.INSTANCE_CREATION_EXPRESSION___PARAMETER_ELEMENTS;
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
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___TYPE:
				return type();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___LOWER:
				return lower();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___UPPER:
				return upper();
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_IS_OBJECT_CREATION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionIsObjectCreationDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_IS_CONSTRUCTORLESS_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionIsConstructorlessDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_CONSTRUCTOR__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionConstructor((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_CONSTRUCTORLESS_LEGALITY__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionConstructorlessLegality((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_DATA_TYPE_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionDataTypeCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___INSTANCE_CREATION_EXPRESSION_REFERENT__DIAGNOSTICCHAIN_MAP:
				return instanceCreationExpressionReferent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.INSTANCE_CREATION_EXPRESSION___PARAMETER_ELEMENTS:
				return parameterElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} // InstanceCreationExpressionImpl
