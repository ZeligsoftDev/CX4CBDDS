/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UmlTransitionFactoryImpl extends EFactoryImpl implements UmlTransitionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UmlTransitionFactory init() {
		try {
			UmlTransitionFactory theUmlTransitionFactory = (UmlTransitionFactory) EPackage.Registry.INSTANCE.getEFactory(UmlTransitionPackage.eNS_URI);
			if (theUmlTransitionFactory != null) {
				return theUmlTransitionFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlTransitionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlTransitionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UmlTransitionPackage.TRANSITION_RULE:
			return createTransitionRule();
		case UmlTransitionPackage.EVENT_RULE:
			return createEventRule();
		case UmlTransitionPackage.CALL_OR_SIGNAL_EVENT_RULE:
			return createCallOrSignalEventRule();
		case UmlTransitionPackage.ANY_RECEIVE_EVENT_RULE:
			return createAnyReceiveEventRule();
		case UmlTransitionPackage.TIME_EVENT_RULE:
			return createTimeEventRule();
		case UmlTransitionPackage.RELATIVE_TIME_EVENT_RULE:
			return createRelativeTimeEventRule();
		case UmlTransitionPackage.ABSOLUTE_TIME_EVENT_RULE:
			return createAbsoluteTimeEventRule();
		case UmlTransitionPackage.CHANGE_EVENT_RULE:
			return createChangeEventRule();
		case UmlTransitionPackage.GUARD_RULE:
			return createGuardRule();
		case UmlTransitionPackage.EFFECT_RULE:
			return createEffectRule();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case UmlTransitionPackage.BEHAVIOR_KIND:
			return createBehaviorKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case UmlTransitionPackage.BEHAVIOR_KIND:
			return convertBehaviorKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransitionRule createTransitionRule() {
		TransitionRuleImpl transitionRule = new TransitionRuleImpl();
		return transitionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EventRule createEventRule() {
		EventRuleImpl eventRule = new EventRuleImpl();
		return eventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CallOrSignalEventRule createCallOrSignalEventRule() {
		CallOrSignalEventRuleImpl callOrSignalEventRule = new CallOrSignalEventRuleImpl();
		return callOrSignalEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnyReceiveEventRule createAnyReceiveEventRule() {
		AnyReceiveEventRuleImpl anyReceiveEventRule = new AnyReceiveEventRuleImpl();
		return anyReceiveEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeEventRule createTimeEventRule() {
		TimeEventRuleImpl timeEventRule = new TimeEventRuleImpl();
		return timeEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RelativeTimeEventRule createRelativeTimeEventRule() {
		RelativeTimeEventRuleImpl relativeTimeEventRule = new RelativeTimeEventRuleImpl();
		return relativeTimeEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbsoluteTimeEventRule createAbsoluteTimeEventRule() {
		AbsoluteTimeEventRuleImpl absoluteTimeEventRule = new AbsoluteTimeEventRuleImpl();
		return absoluteTimeEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ChangeEventRule createChangeEventRule() {
		ChangeEventRuleImpl changeEventRule = new ChangeEventRuleImpl();
		return changeEventRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GuardRule createGuardRule() {
		GuardRuleImpl guardRule = new GuardRuleImpl();
		return guardRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectRule createEffectRule() {
		EffectRuleImpl effectRule = new EffectRuleImpl();
		return effectRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehaviorKind createBehaviorKindFromString(EDataType eDataType, String initialValue) {
		BehaviorKind result = BehaviorKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBehaviorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlTransitionPackage getUmlTransitionPackage() {
		return (UmlTransitionPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlTransitionPackage getPackage() {
		return UmlTransitionPackage.eINSTANCE;
	}

} // UmlTransitionFactoryImpl
