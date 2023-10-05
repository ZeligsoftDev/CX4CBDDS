/**
 */
package org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EffectRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.GuardRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.UmlTransitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl#getTriggers <em>Triggers</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl#getGuard <em>Guard</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.impl.TransitionRuleImpl#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionRuleImpl extends MinimalEObjectImpl.Container implements TransitionRule {
	/**
	 * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<EventRule> triggers;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected GuardRule guard;

	/**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
	protected EffectRule effect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransitionRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlTransitionPackage.Literals.TRANSITION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EventRule> getTriggers() {
		if (triggers == null) {
			triggers = new EObjectContainmentEList<EventRule>(EventRule.class, this, UmlTransitionPackage.TRANSITION_RULE__TRIGGERS);
		}
		return triggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GuardRule getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGuard(GuardRule newGuard, NotificationChain msgs) {
		GuardRule oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.TRANSITION_RULE__GUARD, oldGuard, newGuard);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGuard(GuardRule newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject) guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlTransitionPackage.TRANSITION_RULE__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject) newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlTransitionPackage.TRANSITION_RULE__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.TRANSITION_RULE__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EffectRule getEffect() {
		return effect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEffect(EffectRule newEffect, NotificationChain msgs) {
		EffectRule oldEffect = effect;
		effect = newEffect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.TRANSITION_RULE__EFFECT, oldEffect, newEffect);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEffect(EffectRule newEffect) {
		if (newEffect != effect) {
			NotificationChain msgs = null;
			if (effect != null)
				msgs = ((InternalEObject) effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlTransitionPackage.TRANSITION_RULE__EFFECT, null, msgs);
			if (newEffect != null)
				msgs = ((InternalEObject) newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlTransitionPackage.TRANSITION_RULE__EFFECT, null, msgs);
			msgs = basicSetEffect(newEffect, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlTransitionPackage.TRANSITION_RULE__EFFECT, newEffect, newEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UmlTransitionPackage.TRANSITION_RULE__TRIGGERS:
			return ((InternalEList<?>) getTriggers()).basicRemove(otherEnd, msgs);
		case UmlTransitionPackage.TRANSITION_RULE__GUARD:
			return basicSetGuard(null, msgs);
		case UmlTransitionPackage.TRANSITION_RULE__EFFECT:
			return basicSetEffect(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmlTransitionPackage.TRANSITION_RULE__TRIGGERS:
			return getTriggers();
		case UmlTransitionPackage.TRANSITION_RULE__GUARD:
			return getGuard();
		case UmlTransitionPackage.TRANSITION_RULE__EFFECT:
			return getEffect();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UmlTransitionPackage.TRANSITION_RULE__TRIGGERS:
			getTriggers().clear();
			getTriggers().addAll((Collection<? extends EventRule>) newValue);
			return;
		case UmlTransitionPackage.TRANSITION_RULE__GUARD:
			setGuard((GuardRule) newValue);
			return;
		case UmlTransitionPackage.TRANSITION_RULE__EFFECT:
			setEffect((EffectRule) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UmlTransitionPackage.TRANSITION_RULE__TRIGGERS:
			getTriggers().clear();
			return;
		case UmlTransitionPackage.TRANSITION_RULE__GUARD:
			setGuard((GuardRule) null);
			return;
		case UmlTransitionPackage.TRANSITION_RULE__EFFECT:
			setEffect((EffectRule) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UmlTransitionPackage.TRANSITION_RULE__TRIGGERS:
			return triggers != null && !triggers.isEmpty();
		case UmlTransitionPackage.TRANSITION_RULE__GUARD:
			return guard != null;
		case UmlTransitionPackage.TRANSITION_RULE__EFFECT:
			return effect != null;
		}
		return super.eIsSet(featureID);
	}

} // TransitionRuleImpl
