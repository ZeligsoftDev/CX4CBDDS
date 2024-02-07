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
import org.eclipse.papyrus.uml.alf.MemberDefinition;
import org.eclipse.papyrus.uml.alf.PropertyDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.SyntaxElement;
import org.eclipse.papyrus.uml.alf.TypedElementDefinition;

import org.eclipse.papyrus.uml.alf.util.AlfValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyDefinitionImpl#isIsComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyDefinitionImpl#getInitializer <em>Initializer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyDefinitionImpl#isIsCollectionConversion <em>Is Collection Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyDefinitionImpl#isIsBitStringConversion <em>Is Bit String Conversion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.impl.PropertyDefinitionImpl#getTypePart <em>Type Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDefinitionImpl extends MemberDefinitionImpl implements PropertyDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlfPackage.eINSTANCE.getPropertyDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsComposite() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getPropertyDefinition_IsComposite(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		eSet(AlfPackage.eINSTANCE.getPropertyDefinition_IsComposite(), newIsComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitializer() {
		return (Expression)eGet(AlfPackage.eINSTANCE.getPropertyDefinition_Initializer(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializer(Expression newInitializer) {
		eSet(AlfPackage.eINSTANCE.getPropertyDefinition_Initializer(), newInitializer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollectionConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getPropertyDefinition_IsCollectionConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollectionConversion(boolean newIsCollectionConversion) {
		eSet(AlfPackage.eINSTANCE.getPropertyDefinition_IsCollectionConversion(), newIsCollectionConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBitStringConversion() {
		return (Boolean)eGet(AlfPackage.eINSTANCE.getPropertyDefinition_IsBitStringConversion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBitStringConversion(boolean newIsBitStringConversion) {
		eSet(AlfPackage.eINSTANCE.getPropertyDefinition_IsBitStringConversion(), newIsBitStringConversion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElementDefinition getTypePart() {
		return (TypedElementDefinition)eGet(AlfPackage.eINSTANCE.getPropertyDefinition_TypePart(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypePart(TypedElementDefinition newTypePart) {
		eSet(AlfPackage.eINSTANCE.getPropertyDefinition_TypePart(), newTypePart);
	}

	/**
	 * The cached invocation delegate for the '{@link #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement) <em>Assignments Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #assignmentsBefore(org.eclipse.papyrus.uml.alf.SyntaxElement)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ASSIGNMENTS_BEFORE_SYNTAX_ELEMENT__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyDefinition__AssignmentsBefore__SyntaxElement()).getInvocationDelegate();

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
	 * The cached invocation delegate for the '{@link #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation) <em>Annotation Allowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #annotationAllowed(org.eclipse.papyrus.uml.alf.StereotypeAnnotation)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyDefinition__AnnotationAllowed__StereotypeAnnotation()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		try {
			return (Boolean)ANNOTATION_ALLOWED_STEREOTYPE_ANNOTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{annotation}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference) <em>Is Same Kind As</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSameKindAs(org.eclipse.papyrus.uml.alf.ElementReference)
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyDefinition__IsSameKindAs__ElementReference()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSameKindAs(ElementReference member) {
		try {
			return (Boolean)IS_SAME_KIND_AS_ELEMENT_REFERENCE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{member}));
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #isFeature() <em>Is Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFeature()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate IS_FEATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)AlfPackage.eINSTANCE.getPropertyDefinition__IsFeature()).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFeature() {
		try {
			return (Boolean)IS_FEATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached validation expression for the '{@link #propertyDefinitionInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Property Definition Initializer</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #propertyDefinitionInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_DEFINITION_INITIALIZER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "\n" +
		"        self.initializer <> null implies \n" +
		"          self.typePart.isAssignableFrom(self.initializer)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean propertyDefinitionInitializer(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			AlfValidator.validate
				(AlfPackage.eINSTANCE.getPropertyDefinition(),
				 this,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 AlfPackage.eINSTANCE.getPropertyDefinition__PropertyDefinitionInitializer__DiagnosticChain_Map(),
				 PROPERTY_DEFINITION_INITIALIZER_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				 Diagnostic.ERROR,
				 AlfValidator.DIAGNOSTIC_SOURCE,
				 AlfValidator.PROPERTY_DEFINITION__PROPERTY_DEFINITION_INITIALIZER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean propertyDefinitionIsCollectionConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyDefinitionIsCollectionConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean propertyDefinitionIsBitStringConversionDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_BIT_STRING_CONVERSION_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyDefinitionIsBitStringConversionDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean propertyDefinitionIsFeatureDerivation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 AlfValidator.PROPERTY_DEFINITION__PROPERTY_DEFINITION_IS_FEATURE_DERIVATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "propertyDefinitionIsFeatureDerivation", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SyntaxElement.class) {
			switch (baseOperationID) {
				case AlfPackage.SYNTAX_ELEMENT___ASSIGNMENTS_BEFORE__SYNTAXELEMENT: return AlfPackage.PROPERTY_DEFINITION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == MemberDefinition.class) {
			switch (baseOperationID) {
				case AlfPackage.MEMBER_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION: return AlfPackage.PROPERTY_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION;
				case AlfPackage.MEMBER_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE: return AlfPackage.PROPERTY_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE;
				case AlfPackage.MEMBER_DEFINITION___IS_FEATURE: return AlfPackage.PROPERTY_DEFINITION___IS_FEATURE;
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
			case AlfPackage.PROPERTY_DEFINITION___ASSIGNMENTS_BEFORE__SYNTAXELEMENT:
				return assignmentsBefore((SyntaxElement)arguments.get(0));
			case AlfPackage.PROPERTY_DEFINITION___ANNOTATION_ALLOWED__STEREOTYPEANNOTATION:
				return annotationAllowed((StereotypeAnnotation)arguments.get(0));
			case AlfPackage.PROPERTY_DEFINITION___IS_SAME_KIND_AS__ELEMENTREFERENCE:
				return isSameKindAs((ElementReference)arguments.get(0));
			case AlfPackage.PROPERTY_DEFINITION___IS_FEATURE:
				return isFeature();
			case AlfPackage.PROPERTY_DEFINITION___PROPERTY_DEFINITION_INITIALIZER__DIAGNOSTICCHAIN_MAP:
				return propertyDefinitionInitializer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_DEFINITION___PROPERTY_DEFINITION_IS_COLLECTION_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyDefinitionIsCollectionConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_DEFINITION___PROPERTY_DEFINITION_IS_BIT_STRING_CONVERSION_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyDefinitionIsBitStringConversionDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case AlfPackage.PROPERTY_DEFINITION___PROPERTY_DEFINITION_IS_FEATURE_DERIVATION__DIAGNOSTICCHAIN_MAP:
				return propertyDefinitionIsFeatureDerivation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // PropertyDefinitionImpl
