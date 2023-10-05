/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionFactory
 * @model kind="package"
 * @generated
 */
public interface UmlTransitionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "umlTransition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/transition/xtext/UmlTransition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "umlTransition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UmlTransitionPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl <em>Transition Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getTransitionRule()
	 * @generated
	 */
	int TRANSITION_RULE = 0;

	/**
	 * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_RULE__TRIGGERS = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_RULE__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_RULE__EFFECT = 2;

	/**
	 * The number of structural features of the '<em>Transition Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EventRuleImpl <em>Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getEventRule()
	 * @generated
	 */
	int EVENT_RULE = 1;

	/**
	 * The number of structural features of the '<em>Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_RULE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.CallOrSignalEventRuleImpl <em>Call Or Signal Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.CallOrSignalEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getCallOrSignalEventRule()
	 * @generated
	 */
	int CALL_OR_SIGNAL_EVENT_RULE = 2;

	/**
	 * The feature id for the '<em><b>Operation Or Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL = EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Or Signal Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_OR_SIGNAL_EVENT_RULE_FEATURE_COUNT = EVENT_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AnyReceiveEventRuleImpl <em>Any Receive Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AnyReceiveEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getAnyReceiveEventRule()
	 * @generated
	 */
	int ANY_RECEIVE_EVENT_RULE = 3;

	/**
	 * The feature id for the '<em><b>Is AReceive Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT = EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Any Receive Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANY_RECEIVE_EVENT_RULE_FEATURE_COUNT = EVENT_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TimeEventRuleImpl <em>Time Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TimeEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getTimeEventRule()
	 * @generated
	 */
	int TIME_EVENT_RULE = 4;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TIME_EVENT_RULE__EXPR = EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TIME_EVENT_RULE_FEATURE_COUNT = EVENT_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.RelativeTimeEventRuleImpl <em>Relative Time Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.RelativeTimeEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getRelativeTimeEventRule()
	 * @generated
	 */
	int RELATIVE_TIME_EVENT_RULE = 5;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATIVE_TIME_EVENT_RULE__EXPR = TIME_EVENT_RULE__EXPR;

	/**
	 * The number of structural features of the '<em>Relative Time Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATIVE_TIME_EVENT_RULE_FEATURE_COUNT = TIME_EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AbsoluteTimeEventRuleImpl <em>Absolute Time Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AbsoluteTimeEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getAbsoluteTimeEventRule()
	 * @generated
	 */
	int ABSOLUTE_TIME_EVENT_RULE = 6;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_TIME_EVENT_RULE__EXPR = TIME_EVENT_RULE__EXPR;

	/**
	 * The number of structural features of the '<em>Absolute Time Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSOLUTE_TIME_EVENT_RULE_FEATURE_COUNT = TIME_EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.ChangeEventRuleImpl <em>Change Event Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.ChangeEventRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getChangeEventRule()
	 * @generated
	 */
	int CHANGE_EVENT_RULE = 7;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT_RULE__EXP = EVENT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Change Event Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CHANGE_EVENT_RULE_FEATURE_COUNT = EVENT_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.GuardRuleImpl <em>Guard Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.GuardRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getGuardRule()
	 * @generated
	 */
	int GUARD_RULE = 8;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GUARD_RULE__CONSTRAINT = 0;

	/**
	 * The number of structural features of the '<em>Guard Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GUARD_RULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EffectRuleImpl
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getEffectRule()
	 * @generated
	 */
	int EFFECT_RULE = 9;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EFFECT_RULE__KIND = 0;

	/**
	 * The feature id for the '<em><b>Behavior Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EFFECT_RULE__BEHAVIOR_NAME = 1;

	/**
	 * The number of structural features of the '<em>Effect Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EFFECT_RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind <em>Behavior Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getBehaviorKind()
	 * @generated
	 */
	int BEHAVIOR_KIND = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule <em>Transition Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Transition Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule
	 * @generated
	 */
	EClass getTransitionRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getTriggers <em>Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Triggers</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getTriggers()
	 * @see #getTransitionRule()
	 * @generated
	 */
	EReference getTransitionRule_Triggers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getGuard()
	 * @see #getTransitionRule()
	 * @generated
	 */
	EReference getTransitionRule_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Effect</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule#getEffect()
	 * @see #getTransitionRule()
	 * @generated
	 */
	EReference getTransitionRule_Effect();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule <em>Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule
	 * @generated
	 */
	EClass getEventRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule <em>Call Or Signal Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Call Or Signal Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule
	 * @generated
	 */
	EClass getCallOrSignalEventRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule#getOperationOrSignal <em>Operation Or Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Operation Or Signal</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule#getOperationOrSignal()
	 * @see #getCallOrSignalEventRule()
	 * @generated
	 */
	EReference getCallOrSignalEventRule_OperationOrSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule <em>Any Receive Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Any Receive Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule
	 * @generated
	 */
	EClass getAnyReceiveEventRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule#getIsAReceiveEvent <em>Is AReceive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is AReceive Event</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule#getIsAReceiveEvent()
	 * @see #getAnyReceiveEventRule()
	 * @generated
	 */
	EAttribute getAnyReceiveEventRule_IsAReceiveEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule <em>Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Time Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule
	 * @generated
	 */
	EClass getTimeEventRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Expr</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule#getExpr()
	 * @see #getTimeEventRule()
	 * @generated
	 */
	EAttribute getTimeEventRule_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule <em>Relative Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Relative Time Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule
	 * @generated
	 */
	EClass getRelativeTimeEventRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule <em>Absolute Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Absolute Time Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule
	 * @generated
	 */
	EClass getAbsoluteTimeEventRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule <em>Change Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Change Event Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule
	 * @generated
	 */
	EClass getChangeEventRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exp</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule#getExp()
	 * @see #getChangeEventRule()
	 * @generated
	 */
	EAttribute getChangeEventRule_Exp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule <em>Guard Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Guard Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule
	 * @generated
	 */
	EClass getGuardRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule#getConstraint()
	 * @see #getGuardRule()
	 * @generated
	 */
	EAttribute getGuardRule_Constraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule <em>Effect Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Effect Rule</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule
	 * @generated
	 */
	EClass getEffectRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getKind()
	 * @see #getEffectRule()
	 * @generated
	 */
	EAttribute getEffectRule_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getBehaviorName <em>Behavior Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Behavior Name</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule#getBehaviorName()
	 * @see #getEffectRule()
	 * @generated
	 */
	EAttribute getEffectRule_BehaviorName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind <em>Behavior Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Behavior Kind</em>'.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind
	 * @generated
	 */
	EEnum getBehaviorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlTransitionFactory getUmlTransitionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl <em>Transition Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getTransitionRule()
		 * @generated
		 */
		EClass TRANSITION_RULE = eINSTANCE.getTransitionRule();

		/**
		 * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION_RULE__TRIGGERS = eINSTANCE.getTransitionRule_Triggers();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION_RULE__GUARD = eINSTANCE.getTransitionRule_Guard();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION_RULE__EFFECT = eINSTANCE.getTransitionRule_Effect();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EventRuleImpl <em>Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getEventRule()
		 * @generated
		 */
		EClass EVENT_RULE = eINSTANCE.getEventRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.CallOrSignalEventRuleImpl <em>Call Or Signal Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.CallOrSignalEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getCallOrSignalEventRule()
		 * @generated
		 */
		EClass CALL_OR_SIGNAL_EVENT_RULE = eINSTANCE.getCallOrSignalEventRule();

		/**
		 * The meta object literal for the '<em><b>Operation Or Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CALL_OR_SIGNAL_EVENT_RULE__OPERATION_OR_SIGNAL = eINSTANCE.getCallOrSignalEventRule_OperationOrSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AnyReceiveEventRuleImpl <em>Any Receive Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AnyReceiveEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getAnyReceiveEventRule()
		 * @generated
		 */
		EClass ANY_RECEIVE_EVENT_RULE = eINSTANCE.getAnyReceiveEventRule();

		/**
		 * The meta object literal for the '<em><b>Is AReceive Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANY_RECEIVE_EVENT_RULE__IS_ARECEIVE_EVENT = eINSTANCE.getAnyReceiveEventRule_IsAReceiveEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TimeEventRuleImpl <em>Time Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TimeEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getTimeEventRule()
		 * @generated
		 */
		EClass TIME_EVENT_RULE = eINSTANCE.getTimeEventRule();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TIME_EVENT_RULE__EXPR = eINSTANCE.getTimeEventRule_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.RelativeTimeEventRuleImpl <em>Relative Time Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.RelativeTimeEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getRelativeTimeEventRule()
		 * @generated
		 */
		EClass RELATIVE_TIME_EVENT_RULE = eINSTANCE.getRelativeTimeEventRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AbsoluteTimeEventRuleImpl <em>Absolute Time Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.AbsoluteTimeEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getAbsoluteTimeEventRule()
		 * @generated
		 */
		EClass ABSOLUTE_TIME_EVENT_RULE = eINSTANCE.getAbsoluteTimeEventRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.ChangeEventRuleImpl <em>Change Event Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.ChangeEventRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getChangeEventRule()
		 * @generated
		 */
		EClass CHANGE_EVENT_RULE = eINSTANCE.getChangeEventRule();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CHANGE_EVENT_RULE__EXP = eINSTANCE.getChangeEventRule_Exp();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.GuardRuleImpl <em>Guard Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.GuardRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getGuardRule()
		 * @generated
		 */
		EClass GUARD_RULE = eINSTANCE.getGuardRule();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GUARD_RULE__CONSTRAINT = eINSTANCE.getGuardRule_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.EffectRuleImpl
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getEffectRule()
		 * @generated
		 */
		EClass EFFECT_RULE = eINSTANCE.getEffectRule();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EFFECT_RULE__KIND = eINSTANCE.getEffectRule_Kind();

		/**
		 * The meta object literal for the '<em><b>Behavior Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EFFECT_RULE__BEHAVIOR_NAME = eINSTANCE.getEffectRule_BehaviorName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind <em>Behavior Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind
		 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.UmlTransitionPackageImpl#getBehaviorKind()
		 * @generated
		 */
		EEnum BEHAVIOR_KIND = eINSTANCE.getBehaviorKind();

	}

} // UmlTransitionPackage
