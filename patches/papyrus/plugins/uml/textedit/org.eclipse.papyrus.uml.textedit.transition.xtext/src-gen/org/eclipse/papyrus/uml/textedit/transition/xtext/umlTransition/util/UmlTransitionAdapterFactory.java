/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage
 * @generated
 */
public class UmlTransitionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UmlTransitionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlTransitionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlTransitionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UmlTransitionSwitch<Adapter> modelSwitch = new UmlTransitionSwitch<Adapter>() {
		@Override
		public Adapter caseTransitionRule(TransitionRule object) {
			return createTransitionRuleAdapter();
		}

		@Override
		public Adapter caseEventRule(EventRule object) {
			return createEventRuleAdapter();
		}

		@Override
		public Adapter caseCallOrSignalEventRule(CallOrSignalEventRule object) {
			return createCallOrSignalEventRuleAdapter();
		}

		@Override
		public Adapter caseAnyReceiveEventRule(AnyReceiveEventRule object) {
			return createAnyReceiveEventRuleAdapter();
		}

		@Override
		public Adapter caseTimeEventRule(TimeEventRule object) {
			return createTimeEventRuleAdapter();
		}

		@Override
		public Adapter caseRelativeTimeEventRule(RelativeTimeEventRule object) {
			return createRelativeTimeEventRuleAdapter();
		}

		@Override
		public Adapter caseAbsoluteTimeEventRule(AbsoluteTimeEventRule object) {
			return createAbsoluteTimeEventRuleAdapter();
		}

		@Override
		public Adapter caseChangeEventRule(ChangeEventRule object) {
			return createChangeEventRuleAdapter();
		}

		@Override
		public Adapter caseGuardRule(GuardRule object) {
			return createGuardRuleAdapter();
		}

		@Override
		public Adapter caseEffectRule(EffectRule object) {
			return createEffectRuleAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule <em>Transition Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule
	 * @generated
	 */
	public Adapter createTransitionRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule <em>Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule
	 * @generated
	 */
	public Adapter createEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule <em>Call Or Signal Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule
	 * @generated
	 */
	public Adapter createCallOrSignalEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule <em>Any Receive Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AnyReceiveEventRule
	 * @generated
	 */
	public Adapter createAnyReceiveEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule <em>Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule
	 * @generated
	 */
	public Adapter createTimeEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule <em>Relative Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule
	 * @generated
	 */
	public Adapter createRelativeTimeEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule <em>Absolute Time Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.AbsoluteTimeEventRule
	 * @generated
	 */
	public Adapter createAbsoluteTimeEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule <em>Change Event Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule
	 * @generated
	 */
	public Adapter createChangeEventRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule <em>Guard Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule
	 * @generated
	 */
	public Adapter createGuardRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule <em>Effect Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule
	 * @generated
	 */
	public Adapter createEffectRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // UmlTransitionAdapterFactory
