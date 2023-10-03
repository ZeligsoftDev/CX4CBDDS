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
import org.eclipse.papyrus.uml.alf.ElementReference;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.TypedElementDefinition;
import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#isIsNonunique <em>Is Nonunique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#isIsSequence <em>Is Sequence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#getActualType <em>Actual Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#isIsAny <em>Is Any</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.TypedElementDefinitionImpl#isIsMultiplicity <em>Is Multiplicity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedElementDefinitionImpl extends AssignableElementImpl implements TypedElementDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementDefinitionImpl() {
		super();
	}

	public String getId() {
		SyntaxElementImpl owner = (SyntaxElementImpl) this.owner();
		return super.getId() + (owner == null ? "" : " for " + owner.getId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getTypedElementDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerBound() {
		return (String)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_LowerBound(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(String newLowerBound) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_LowerBound(), newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpperBound() {
		return (String)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_UpperBound(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(String newUpperBound) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_UpperBound(), newUpperBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsOrdered(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsOrdered(), newIsOrdered);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsNonunique() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsNonunique(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsNonunique(boolean newIsNonunique) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsNonunique(), newIsNonunique);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getTypeName() {
		return (QualifiedName)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_TypeName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(QualifiedName newTypeName) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_TypeName(), newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getActualType() {
		return (ElementReference)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_ActualType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualType(ElementReference newActualType) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_ActualType(), newActualType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAny() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsAny(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAny(boolean newIsAny) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsAny(), newIsAny);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSequence() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsSequence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSequence(boolean newIsSequence) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsSequence(), newIsSequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMultiplicity() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsMultiplicity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMultiplicity(boolean newIsMultiplicity) {
		eSet(AlfPackage.eINSTANCE.getTypedElementDefinition_IsMultiplicity(), newIsMultiplicity);
	}

	/**
	 * The cached invocation delegate for the '{@link #isOrdered() <em>Is Ordered</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_ORDERED__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTypedElementDefinition__IsOrdered()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered() {
		try {
			return (Boolean)IS_ORDERED__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isNonunique() <em>Is Nonunique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonunique()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_NONUNIQUE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTypedElementDefinition__IsNonunique()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNonunique() {
		try {
			return (Boolean)IS_NONUNIQUE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public boolean typedElementDefinitionLowerDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_LOWER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "typedElementDefinitionLowerDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean typedElementDefinitionUpperDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_UPPER_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "typedElementDefinitionUpperDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean typedElementDefinitionTypeDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_TYPE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "typedElementDefinitionTypeDerivation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached validation expression for the '{@link #typedElementDefinitionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Typed Element Definition Type Name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #typedElementDefinitionTypeName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TYPED_ELEMENT_DEFINITION_TYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"    self.typeName = null or self.type <> null and not self.type.isTemplate()";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean typedElementDefinitionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getTypedElementDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getTypedElementDefinition__TypedElementDefinitionTypeName__DiagnosticChain_Map(),
				 TYPED_ELEMENT_DEFINITION_TYPE_NAME_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.TYPED_ELEMENT_DEFINITION__TYPED_ELEMENT_DEFINITION_TYPE_NAME);
	}

	/**
	 * The cached invocation delegate for the '{@link #type() <em>Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #type()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTypedElementDefinition__Type()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate LOWER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTypedElementDefinition__Lower()).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate UPPER__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getTypedElementDefinition__Upper()).getInvocationDelegate();

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
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlfPackage.TYPED_ELEMENT_DEFINITION___IS_ORDERED:
				return isOrdered();
			case AlfPackage.TYPED_ELEMENT_DEFINITION___IS_NONUNIQUE:
				return isNonunique();
			case AlfPackage.TYPED_ELEMENT_DEFINITION___TYPED_ELEMENT_DEFINITION_LOWER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return typedElementDefinitionLowerDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TYPED_ELEMENT_DEFINITION___TYPED_ELEMENT_DEFINITION_UPPER_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return typedElementDefinitionUpperDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TYPED_ELEMENT_DEFINITION___TYPED_ELEMENT_DEFINITION_TYPE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return typedElementDefinitionTypeDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TYPED_ELEMENT_DEFINITION___TYPED_ELEMENT_DEFINITION_TYPE_NAME__DIAGNOSTICCHAIN_MAP:
				return typedElementDefinitionTypeName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.TYPED_ELEMENT_DEFINITION___TYPE:
				return type();
			case AlfPackage.TYPED_ELEMENT_DEFINITION___LOWER:
				return lower();
			case AlfPackage.TYPED_ELEMENT_DEFINITION___UPPER:
				return upper();
		}
		return super.eInvoke(operationID, arguments);
	}

} // TypedElementDefinitionImpl
