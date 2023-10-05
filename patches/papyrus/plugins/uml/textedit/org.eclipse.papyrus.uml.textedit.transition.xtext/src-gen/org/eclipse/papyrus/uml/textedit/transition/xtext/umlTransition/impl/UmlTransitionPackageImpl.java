/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionFactory;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlTransitionPackageImpl extends EPackageImpl implements UmlTransitionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass transitionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass callOrSignalEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass anyReceiveEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass relativeTimeEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass absoluteTimeEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass changeEventRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass guardRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass effectRuleEClass = null;

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
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlTransitionPackageImpl() {
		super(eNS_URI, UmlTransitionFactory.eINSTANCE);
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
	 * This method is used to initialize {@link UmlTransitionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlTransitionPackage init() {
		if (isInited)
			return (UmlTransitionPackage) EPackage.Registry.INSTANCE.getEPackage(UmlTransitionPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUmlTransitionPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UmlTransitionPackageImpl theUmlTransitionPackage = registeredUmlTransitionPackage instanceof UmlTransitionPackageImpl ? (UmlTransitionPackageImpl) registeredUmlTransitionPackage : new UmlTransitionPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlTransitionPackage.createPackageContents();

		// Initialize created meta-data
		theUmlTransitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlTransitionPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlTransitionPackage.eNS_URI, theUmlTransitionPackage);
		return theUmlTransitionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTransitionRule() {
		return transitionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransitionRule_Triggers() {
		return (EReference) transitionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransitionRule_Guard() {
		return (EReference) transitionRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransitionRule_Effect() {
		return (EReference) transitionRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEventRule() {
		return eventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCallOrSignalEventRule() {
		return callOrSignalEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCallOrSignalEventRule_OperationOrSignal() {
		return (EReference) callOrSignalEventRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAnyReceiveEventRule() {
		return anyReceiveEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAnyReceiveEventRule_IsAReceiveEvent() {
		return (EAttribute) anyReceiveEventRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeEventRule() {
		return timeEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTimeEventRule_Expr() {
		return (EAttribute) timeEventRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRelativeTimeEventRule() {
		return relativeTimeEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAbsoluteTimeEventRule() {
		return absoluteTimeEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getChangeEventRule() {
		return changeEventRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getChangeEventRule_Exp() {
		return (EAttribute) changeEventRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGuardRule() {
		return guardRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGuardRule_Constraint() {
		return (EAttribute) guardRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEffectRule() {
		return effectRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEffectRule_Kind() {
		return (EAttribute) effectRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEffectRule_BehaviorName() {
		return (EAttribute) effectRuleEClass.getEStructuralFeatures().get(1);
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
	public UmlTransitionFactory getUmlTransitionFactory() {
		return (UmlTransitionFactory) getEFactoryInstance();
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
		transitionRuleEClass = createEClass(TRANSITION_RULE);
		createEReference(transitionRuleEClass, TRANSITION_RULE__TRIGGERS);
		createEReference(transitionRuleEClass, TRANSITION_RULE__GUARD);
		createEReference(transitionRuleEClass, TRANSITION_RULE__EFFECT);

		eventRuleEClass = createEClass(EVENT_RULE);

		callOrSignalEventRuleEClass = createEClass(CALL_OR_SIGNAL_EVENT_RULE);
		createEReference(callOrSignalEventRuleEClass, CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL);

		anyReceiveEventRuleEClass = createEClass(ANY_RECEIVE_EVENT_RULE);
		createEAttribute(anyReceiveEventRuleEClass, ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT);

		timeEventRuleEClass = createEClass(TIME_EVENT_RULE);
		createEAttribute(timeEventRuleEClass, TIME_EVENT_RULE__EXPR);

		relativeTimeEventRuleEClass = createEClass(RELATIVE_TIME_EVENT_RULE);

		absoluteTimeEventRuleEClass = createEClass(ABSOLUTE_TIME_EVENT_RULE);

		changeEventRuleEClass = createEClass(CHANGE_EVENT_RULE);
		createEAttribute(changeEventRuleEClass, CHANGE_EVENT_RULE__EXP);

		guardRuleEClass = createEClass(GUARD_RULE);
		createEAttribute(guardRuleEClass, GUARD_RULE__CONSTRAINT);

		effectRuleEClass = createEClass(EFFECT_RULE);
		createEAttribute(effectRuleEClass, EFFECT_RULE__KIND);
		createEAttribute(effectRuleEClass, EFFECT_RULE__BEHAVIOR_NAME);

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
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		callOrSignalEventRuleEClass.getESuperTypes().add(this.getEventRule());
		anyReceiveEventRuleEClass.getESuperTypes().add(this.getEventRule());
		timeEventRuleEClass.getESuperTypes().add(this.getEventRule());
		relativeTimeEventRuleEClass.getESuperTypes().add(this.getTimeEventRule());
		absoluteTimeEventRuleEClass.getESuperTypes().add(this.getTimeEventRule());
		changeEventRuleEClass.getESuperTypes().add(this.getEventRule());

		// Initialize classes and features; add operations and parameters
		initEClass(transitionRuleEClass, TransitionRule.class, "TransitionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionRule_Triggers(), this.getEventRule(), null, "triggers", null, 0, -1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionRule_Guard(), this.getGuardRule(), null, "guard", null, 0, 1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionRule_Effect(), this.getEffectRule(), null, "effect", null, 0, 1, TransitionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventRuleEClass, EventRule.class, "EventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callOrSignalEventRuleEClass, CallOrSignalEventRule.class, "CallOrSignalEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallOrSignalEventRule_OperationOrSignal(), theUMLPackage.getNamedElement(), null, "operationOrSignal", null, 0, 1, CallOrSignalEventRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anyReceiveEventRuleEClass, AnyReceiveEventRule.class, "AnyReceiveEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnyReceiveEventRule_IsAReceiveEvent(), theEcorePackage.getEString(), "isAReceiveEvent", null, 0, 1, AnyReceiveEventRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeEventRuleEClass, TimeEventRule.class, "TimeEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeEventRule_Expr(), theEcorePackage.getEString(), "expr", null, 0, 1, TimeEventRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relativeTimeEventRuleEClass, RelativeTimeEventRule.class, "RelativeTimeEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(absoluteTimeEventRuleEClass, AbsoluteTimeEventRule.class, "AbsoluteTimeEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(changeEventRuleEClass, ChangeEventRule.class, "ChangeEventRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangeEventRule_Exp(), theEcorePackage.getEString(), "exp", null, 0, 1, ChangeEventRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardRuleEClass, GuardRule.class, "GuardRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuardRule_Constraint(), theEcorePackage.getEString(), "constraint", null, 0, 1, GuardRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(effectRuleEClass, EffectRule.class, "EffectRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEffectRule_Kind(), this.getBehaviorKind(), "kind", null, 0, 1, EffectRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEffectRule_BehaviorName(), theEcorePackage.getEString(), "behaviorName", null, 0, 1, EffectRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(behaviorKindEEnum, BehaviorKind.class, "BehaviorKind");
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.ACTIVITY);
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.STATE_MACHINE);
		addEEnumLiteral(behaviorKindEEnum, BehaviorKind.OPAQUE_BEHAVIOR);

		// Create resource
		createResource(eNS_URI);
	}

} // UmlTransitionPackageImpl
