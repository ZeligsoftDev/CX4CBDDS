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
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.InvocationExpression;
import org.eclipse.papyrus.uml.alf.LinkOperationExpression;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LinkOperationExpressionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LinkOperationExpressionImpl#isIsCreation <em>Is Creation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LinkOperationExpressionImpl#isIsClear <em>Is Clear</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.LinkOperationExpressionImpl#getAssociationName <em>Association Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinkOperationExpressionImpl extends InvocationExpressionImpl implements LinkOperationExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkOperationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getLinkOperationExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return (String)eGet(AlfPackage.eINSTANCE.getLinkOperationExpression_Operation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		eSet(AlfPackage.eINSTANCE.getLinkOperationExpression_Operation(), newOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCreation() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLinkOperationExpression_IsCreation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCreation(boolean newIsCreation) {
		eSet(AlfPackage.eINSTANCE.getLinkOperationExpression_IsCreation(), newIsCreation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsClear() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getLinkOperationExpression_IsClear(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsClear(boolean newIsClear) {
		eSet(AlfPackage.eINSTANCE.getLinkOperationExpression_IsClear(), newIsClear);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getAssociationName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getLinkOperationExpression_AssociationName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationName(QualifiedName newAssociationName) {
		eSet(AlfPackage.eINSTANCE.getLinkOperationExpression_AssociationName(), newAssociationName);
	}

	/**
	 * The cached invocation delegate for the '{@link #referent() <em>Referent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #referent()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate REFERENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLinkOperationExpression__Referent()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLinkOperationExpression__Feature()).getInvocationDelegate();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean linkOperationExpressionIsCreationDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_IS_CREATION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "linkOperationExpressionIsCreationDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean linkOperationExpressionIsClearDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_IS_CLEAR_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "linkOperationExpressionIsClearDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean linkOperationExpressionReferentDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_REFERENT_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "linkOperationExpressionReferentDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean linkOperationExpressionFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "linkOperationExpressionFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #linkOperationExpressionAssociationReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Link Operation Expression Association Reference</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #linkOperationExpressionAssociationReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_OPERATION_EXPRESSION_ASSOCIATION_REFERENCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"\tself.referent <> null and \n" +
		"\t-- Also check that the association owns all its ends.\n" +
		"\tself.referent.properties()->forAll(isAssociationEnd())";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean linkOperationExpressionAssociationReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLinkOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLinkOperationExpression__LinkOperationExpressionAssociationReference__DiagnosticChain_Map(),
				 LINK_OPERATION_EXPRESSION_ASSOCIATION_REFERENCE_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_ASSOCIATION_REFERENCE);
	}

	/**
	 * The cached validation expression for the '{@link #linkOperationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Link Operation Expression Argument Compatibility</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #linkOperationExpressionArgumentCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"      self.tuple.size() <= self.parameterCount() and\n" +
		"      self.tuple.input->forAll(input | self.parameterIsAssignableFrom(input))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean linkOperationExpressionArgumentCompatibility(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getLinkOperationExpression(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getLinkOperationExpression__LinkOperationExpressionArgumentCompatibility__DiagnosticChain_Map(),
				 LINK_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.LINK_OPERATION_EXPRESSION__LINK_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY);
	}

	/**
	 * The cached invocation delegate for the '{@link #parameterElements() <em>Parameter Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parameterElements()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate PARAMETER_ELEMENTS__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getLinkOperationExpression__ParameterElements()).getInvocationDelegate();

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
		if (baseClass == InvocationExpression.class) {
			switch (baseOperationID) {
				case AlfPackage.INVOCATION_EXPRESSION___FEATURE: return AlfPackage.LINK_OPERATION_EXPRESSION___FEATURE;
				case AlfPackage.INVOCATION_EXPRESSION___REFERENT: return AlfPackage.LINK_OPERATION_EXPRESSION___REFERENT;
				case AlfPackage.INVOCATION_EXPRESSION___PARAMETER_ELEMENTS: return AlfPackage.LINK_OPERATION_EXPRESSION___PARAMETER_ELEMENTS;
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
			case AlfPackage.LINK_OPERATION_EXPRESSION___REFERENT:
				return referent();
			case AlfPackage.LINK_OPERATION_EXPRESSION___FEATURE:
				return feature();
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_IS_CREATION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionIsCreationDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_IS_CLEAR_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionIsClearDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_REFERENT_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionReferentDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_ASSOCIATION_REFERENCE__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionAssociationReference((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___LINK_OPERATION_EXPRESSION_ARGUMENT_COMPATIBILITY__DIAGNOSTICCHAIN_MAP:
				return linkOperationExpressionArgumentCompatibility((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.LINK_OPERATION_EXPRESSION___PARAMETER_ELEMENTS:
				return parameterElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} // LinkOperationExpressionImpl
