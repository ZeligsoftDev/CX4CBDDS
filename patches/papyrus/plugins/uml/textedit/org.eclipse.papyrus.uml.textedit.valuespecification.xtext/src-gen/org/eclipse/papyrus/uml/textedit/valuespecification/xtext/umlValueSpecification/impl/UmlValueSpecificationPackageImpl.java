/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralBooleanRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralIntegerOrUnlimitedNaturalRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralNullRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralRealRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.LiteralStringRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationFactory;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlValueSpecificationPackageImpl extends EPackageImpl implements UmlValueSpecificationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass abstractRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalBooleanRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalIntegerOrUnlimitedNaturalRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalRealRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalNullRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalStringRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass undefinedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass visibilityKindEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlValueSpecificationPackageImpl() {
		super(eNS_URI, UmlValueSpecificationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link UmlValueSpecificationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlValueSpecificationPackage init() {
		if (isInited)
			return (UmlValueSpecificationPackage) EPackage.Registry.INSTANCE.getEPackage(UmlValueSpecificationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUmlValueSpecificationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UmlValueSpecificationPackageImpl theUmlValueSpecificationPackage = registeredUmlValueSpecificationPackage instanceof UmlValueSpecificationPackageImpl ? (UmlValueSpecificationPackageImpl) registeredUmlValueSpecificationPackage
				: new UmlValueSpecificationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlValueSpecificationPackage.createPackageContents();

		// Initialize created meta-data
		theUmlValueSpecificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlValueSpecificationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlValueSpecificationPackage.eNS_URI, theUmlValueSpecificationPackage);
		return theUmlValueSpecificationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAbstractRule() {
		return abstractRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAbstractRule_Visibility() {
		return (EReference) abstractRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAbstractRule_Name() {
		return (EAttribute) abstractRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAbstractRule_InstanceSpecification() {
		return (EReference) abstractRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAbstractRule_Value() {
		return (EReference) abstractRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAbstractRule_Undefined() {
		return (EReference) abstractRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralBooleanRule() {
		return literalBooleanRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralBooleanRule_Value() {
		return (EAttribute) literalBooleanRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralIntegerOrUnlimitedNaturalRule() {
		return literalIntegerOrUnlimitedNaturalRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralIntegerOrUnlimitedNaturalRule_Value() {
		return (EAttribute) literalIntegerOrUnlimitedNaturalRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralIntegerOrUnlimitedNaturalRule_Unlimited() {
		return (EAttribute) literalIntegerOrUnlimitedNaturalRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralRealRule() {
		return literalRealRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralRealRule_Value() {
		return (EAttribute) literalRealRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralNullRule() {
		return literalNullRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralNullRule_Value() {
		return (EAttribute) literalNullRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralStringRule() {
		return literalStringRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLiteralStringRule_Value() {
		return (EAttribute) literalStringRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUndefinedRule() {
		return undefinedRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUndefinedRule_Value() {
		return (EAttribute) undefinedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVisibilityKind() {
		return visibilityKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVisibilityKind_Public() {
		return (EAttribute) visibilityKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVisibilityKind_Private() {
		return (EAttribute) visibilityKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVisibilityKind_Protected() {
		return (EAttribute) visibilityKindEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVisibilityKind_Package() {
		return (EAttribute) visibilityKindEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlValueSpecificationFactory getUmlValueSpecificationFactory() {
		return (UmlValueSpecificationFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		abstractRuleEClass = createEClass(ABSTRACT_RULE);
		createEReference(abstractRuleEClass, ABSTRACT_RULE__VISIBILITY);
		createEAttribute(abstractRuleEClass, ABSTRACT_RULE__NAME);
		createEReference(abstractRuleEClass, ABSTRACT_RULE__INSTANCE_SPECIFICATION);
		createEReference(abstractRuleEClass, ABSTRACT_RULE__VALUE);
		createEReference(abstractRuleEClass, ABSTRACT_RULE__UNDEFINED);

		literalBooleanRuleEClass = createEClass(LITERAL_BOOLEAN_RULE);
		createEAttribute(literalBooleanRuleEClass, LITERAL_BOOLEAN_RULE__VALUE);

		literalIntegerOrUnlimitedNaturalRuleEClass = createEClass(LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE);
		createEAttribute(literalIntegerOrUnlimitedNaturalRuleEClass, LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__VALUE);
		createEAttribute(literalIntegerOrUnlimitedNaturalRuleEClass, LITERAL_INTEGER_OR_UNLIMITED_NATURAL_RULE__UNLIMITED);

		literalRealRuleEClass = createEClass(LITERAL_REAL_RULE);
		createEAttribute(literalRealRuleEClass, LITERAL_REAL_RULE__VALUE);

		literalNullRuleEClass = createEClass(LITERAL_NULL_RULE);
		createEAttribute(literalNullRuleEClass, LITERAL_NULL_RULE__VALUE);

		literalStringRuleEClass = createEClass(LITERAL_STRING_RULE);
		createEAttribute(literalStringRuleEClass, LITERAL_STRING_RULE__VALUE);

		undefinedRuleEClass = createEClass(UNDEFINED_RULE);
		createEAttribute(undefinedRuleEClass, UNDEFINED_RULE__VALUE);

		visibilityKindEClass = createEClass(VISIBILITY_KIND);
		createEAttribute(visibilityKindEClass, VISIBILITY_KIND__PUBLIC);
		createEAttribute(visibilityKindEClass, VISIBILITY_KIND__PRIVATE);
		createEAttribute(visibilityKindEClass, VISIBILITY_KIND__PROTECTED);
		createEAttribute(visibilityKindEClass, VISIBILITY_KIND__PACKAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractRule_Visibility(), this.getVisibilityKind(), null, "visibility", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getAbstractRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractRule_InstanceSpecification(), theUMLPackage.getInstanceSpecification(), null, "instanceSpecification", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractRule_Value(), theEcorePackage.getEObject(), null, "value", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractRule_Undefined(), this.getUndefinedRule(), null, "undefined", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalBooleanRuleEClass, LiteralBooleanRule.class, "LiteralBooleanRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralBooleanRule_Value(), theEcorePackage.getEString(), "value", null, 0, 1, LiteralBooleanRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalIntegerOrUnlimitedNaturalRuleEClass, LiteralIntegerOrUnlimitedNaturalRule.class, "LiteralIntegerOrUnlimitedNaturalRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralIntegerOrUnlimitedNaturalRule_Value(), theEcorePackage.getEInt(), "value", null, 0, 1, LiteralIntegerOrUnlimitedNaturalRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getLiteralIntegerOrUnlimitedNaturalRule_Unlimited(), theEcorePackage.getEString(), "unlimited", null, 0, 1, LiteralIntegerOrUnlimitedNaturalRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(literalRealRuleEClass, LiteralRealRule.class, "LiteralRealRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralRealRule_Value(), theEcorePackage.getEDouble(), "value", null, 0, 1, LiteralRealRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalNullRuleEClass, LiteralNullRule.class, "LiteralNullRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralNullRule_Value(), theEcorePackage.getEString(), "value", null, 0, 1, LiteralNullRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalStringRuleEClass, LiteralStringRule.class, "LiteralStringRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralStringRule_Value(), theEcorePackage.getEString(), "value", null, 0, 1, LiteralStringRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(undefinedRuleEClass, UndefinedRule.class, "UndefinedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUndefinedRule_Value(), theEcorePackage.getEString(), "value", null, 0, 1, UndefinedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visibilityKindEClass, VisibilityKind.class, "VisibilityKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisibilityKind_Public(), theEcorePackage.getEString(), "public", null, 0, 1, VisibilityKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisibilityKind_Private(), theEcorePackage.getEString(), "private", null, 0, 1, VisibilityKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisibilityKind_Protected(), theEcorePackage.getEString(), "protected", null, 0, 1, VisibilityKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisibilityKind_Package(), theEcorePackage.getEString(), "package", null, 0, 1, VisibilityKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // UmlValueSpecificationPackageImpl
