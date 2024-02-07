/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.DoRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.ExitRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.QualifiedName;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.SubmachineRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStateFactory;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlStatePackageImpl extends EPackageImpl implements UmlStatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass submachineRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass entryRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass doRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass exitRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum behaviorKindEEnum = null;

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
	 * @see org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlStatePackageImpl() {
		super(eNS_URI, UmlStateFactory.eINSTANCE);
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
	 * This method is used to initialize {@link UmlStatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlStatePackage init() {
		if (isInited)
			return (UmlStatePackage) EPackage.Registry.INSTANCE.getEPackage(UmlStatePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUmlStatePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UmlStatePackageImpl theUmlStatePackage = registeredUmlStatePackage instanceof UmlStatePackageImpl ? (UmlStatePackageImpl) registeredUmlStatePackage : new UmlStatePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlStatePackage.createPackageContents();

		// Initialize created meta-data
		theUmlStatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlStatePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlStatePackage.eNS_URI, theUmlStatePackage);
		return theUmlStatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStateRule() {
		return stateRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStateRule_Name() {
		return (EAttribute) stateRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateRule_Submachine() {
		return (EReference) stateRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateRule_Entry() {
		return (EReference) stateRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateRule_Do() {
		return (EReference) stateRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateRule_Exit() {
		return (EReference) stateRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubmachineRule() {
		return submachineRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubmachineRule_Path() {
		return (EReference) submachineRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubmachineRule_Submachine() {
		return (EReference) submachineRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getQualifiedName() {
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Path() {
		return (EReference) qualifiedNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getQualifiedName_Remaining() {
		return (EReference) qualifiedNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEntryRule() {
		return entryRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEntryRule_Kind() {
		return (EAttribute) entryRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEntryRule_BehaviorName() {
		return (EAttribute) entryRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDoRule() {
		return doRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDoRule_Kind() {
		return (EAttribute) doRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDoRule_BehaviorName() {
		return (EAttribute) doRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExitRule() {
		return exitRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getExitRule_Kind() {
		return (EAttribute) exitRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getExitRule_BehaviorName() {
		return (EAttribute) exitRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getBehaviorKind() {
		return behaviorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlStateFactory getUmlStateFactory() {
		return (UmlStateFactory) getEFactoryInstance();
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
		stateRuleEClass = createEClass(STATE_RULE);
		createEAttribute(stateRuleEClass, STATE_RULE__NAME);
		createEReference(stateRuleEClass, STATE_RULE__SUBMACHINE);
		createEReference(stateRuleEClass, STATE_RULE__ENTRY);
		createEReference(stateRuleEClass, STATE_RULE__DO);
		createEReference(stateRuleEClass, STATE_RULE__EXIT);

		submachineRuleEClass = createEClass(SUBMACHINE_RULE);
		createEReference(submachineRuleEClass, SUBMACHINE_RULE__PATH);
		createEReference(submachineRuleEClass, SUBMACHINE_RULE__SUBMACHINE);

		qualifiedNameEClass = createEClass(QUALIFIED_NAME);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__PATH);
		createEReference(qualifiedNameEClass, QUALIFIED_NAME__REMAINING);

		entryRuleEClass = createEClass(ENTRY_RULE);
		createEAttribute(entryRuleEClass, ENTRY_RULE__KIND);
		createEAttribute(entryRuleEClass, ENTRY_RULE__BEHAVIOR_NAME);

		doRuleEClass = createEClass(DO_RULE);
		createEAttribute(doRuleEClass, DO_RULE__KIND);
		createEAttribute(doRuleEClass, DO_RULE__BEHAVIOR_NAME);

		exitRuleEClass = createEClass(EXIT_RULE);
		createEAttribute(exitRuleEClass, EXIT_RULE__KIND);
		createEAttribute(exitRuleEClass, EXIT_RULE__BEHAVIOR_NAME);

		// Create enums
		behaviorKindEEnum = createEEnum(BEHAVIOR_KIND);
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
		initEClass(stateRuleEClass, StateRule.class, "StateRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateRule_Name(), theEcorePackage.getEString(), "name", null, 0, 1, StateRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateRule_Submachine(), this.getSubmachineRule(), null, "submachine", null, 0, 1, StateRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateRule_Entry(), this.getEntryRule(), null, "entry", null, 0, 1, StateRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateRule_Do(), this.getDoRule(), null, "do", null, 0, 1, StateRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateRule_Exit(), this.getExitRule(), null, "exit", null, 0, 1, StateRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(submachineRuleEClass, SubmachineRule.class, "SubmachineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubmachineRule_Path(), this.getQualifiedName(), null, "path", null, 0, 1, SubmachineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubmachineRule_Submachine(), theUMLPackage.getStateMachine(), null, "submachine", null, 0, 1, SubmachineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedName_Path(), theUMLPackage.getNamespace(), null, "path", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedName_Remaining(), this.getQualifiedName(), null, "remaining", null, 0, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(entryRuleEClass, EntryRule.class, "EntryRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntryRule_Kind(), this.getBehaviorKind(), "kind", null, 0, 1, EntryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntryRule_BehaviorName(), theEcorePackage.getEString(), "behaviorName", null, 0, 1, EntryRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doRuleEClass, DoRule.class, "DoRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoRule_Kind(), this.getBehaviorKind(), "kind", null, 0, 1, DoRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoRule_BehaviorName(), theEcorePackage.getEString(), "behaviorName", null, 0, 1, DoRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exitRuleEClass, ExitRule.class, "ExitRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExitRule_Kind(), this.getBehaviorKind(), "kind", null, 0, 1, ExitRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExitRule_BehaviorName(), theEcorePackage.getEString(), "behaviorName", null, 0, 1, ExitRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(behaviorKindEEnum, BehaviorKind.class, "BehaviorKind");
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.ACTIVITY);
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.STATE_MACHINE);
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.OPAQUE_BEHAVIOR);

		// Create resource
		createResource(eNS_URI);
	}

} // UmlStatePackageImpl
