/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.DirectionRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getVisibility <em>Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getDirection <em>Direction</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#isTypeUndefined <em>Type Undefined</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getEffect <em>Effect</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterRuleImpl extends MinimalEObjectImpl.Container implements ParameterRule {
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityRule visibility;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionRule direction;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeRule type;

	/**
	 * The default value of the '{@link #isTypeUndefined() <em>Type Undefined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isTypeUndefined()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPE_UNDEFINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTypeUndefined() <em>Type Undefined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isTypeUndefined()
	 * @generated
	 * @ordered
	 */
	protected boolean typeUndefined = TYPE_UNDEFINED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityRule multiplicity;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected ModifiersRule modifiers;

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
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected DefaultValueRule defaultValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ParameterRuleImpl() {
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
		return UmlParameterPackage.Literals.PARAMETER_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityRule getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetVisibility(VisibilityRule newVisibility, NotificationChain msgs) {
		VisibilityRule oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__VISIBILITY, oldVisibility, newVisibility);
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
	public void setVisibility(VisibilityRule newVisibility) {
		if (newVisibility != visibility) {
			NotificationChain msgs = null;
			if (visibility != null)
				msgs = ((InternalEObject) visibility).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__VISIBILITY, null, msgs);
			if (newVisibility != null)
				msgs = ((InternalEObject) newVisibility).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__VISIBILITY, null, msgs);
			msgs = basicSetVisibility(newVisibility, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__VISIBILITY, newVisibility, newVisibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DirectionRule getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDirection(DirectionRule newDirection, NotificationChain msgs) {
		DirectionRule oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__DIRECTION, oldDirection, newDirection);
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
	public void setDirection(DirectionRule newDirection) {
		if (newDirection != direction) {
			NotificationChain msgs = null;
			if (direction != null)
				msgs = ((InternalEObject) direction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__DIRECTION, null, msgs);
			if (newDirection != null)
				msgs = ((InternalEObject) newDirection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__DIRECTION, null, msgs);
			msgs = basicSetDirection(newDirection, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__DIRECTION, newDirection, newDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeRule getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetType(TypeRule newType, NotificationChain msgs) {
		TypeRule oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__TYPE, oldType, newType);
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
	public void setType(TypeRule newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isTypeUndefined() {
		return typeUndefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypeUndefined(boolean newTypeUndefined) {
		boolean oldTypeUndefined = typeUndefined;
		typeUndefined = newTypeUndefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__TYPE_UNDEFINED, oldTypeUndefined, typeUndefined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiplicityRule getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(MultiplicityRule newMultiplicity, NotificationChain msgs) {
		MultiplicityRule oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
	public void setMultiplicity(MultiplicityRule newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject) multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject) newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY, newMultiplicity, newMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifiersRule getModifiers() {
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModifiers(ModifiersRule newModifiers, NotificationChain msgs) {
		ModifiersRule oldModifiers = modifiers;
		modifiers = newModifiers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MODIFIERS, oldModifiers, newModifiers);
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
	public void setModifiers(ModifiersRule newModifiers) {
		if (newModifiers != modifiers) {
			NotificationChain msgs = null;
			if (modifiers != null)
				msgs = ((InternalEObject) modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MODIFIERS, null, msgs);
			if (newModifiers != null)
				msgs = ((InternalEObject) newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__MODIFIERS, null, msgs);
			msgs = basicSetModifiers(newModifiers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__MODIFIERS, newModifiers, newModifiers));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__EFFECT, oldEffect, newEffect);
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
				msgs = ((InternalEObject) effect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__EFFECT, null, msgs);
			if (newEffect != null)
				msgs = ((InternalEObject) newEffect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__EFFECT, null, msgs);
			msgs = basicSetEffect(newEffect, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__EFFECT, newEffect, newEffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultValueRule getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(DefaultValueRule newDefaultValue, NotificationChain msgs) {
		DefaultValueRule oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
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
	public void setDefaultValue(DefaultValueRule newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject) defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject) newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
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
		case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
			return basicSetVisibility(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
			return basicSetDirection(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__TYPE:
			return basicSetType(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
			return basicSetMultiplicity(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
			return basicSetModifiers(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__EFFECT:
			return basicSetEffect(null, msgs);
		case UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE:
			return basicSetDefaultValue(null, msgs);
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
		case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
			return getVisibility();
		case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
			return getDirection();
		case UmlParameterPackage.PARAMETER_RULE__NAME:
			return getName();
		case UmlParameterPackage.PARAMETER_RULE__TYPE:
			return getType();
		case UmlParameterPackage.PARAMETER_RULE__TYPE_UNDEFINED:
			return isTypeUndefined();
		case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
			return getMultiplicity();
		case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
			return getModifiers();
		case UmlParameterPackage.PARAMETER_RULE__EFFECT:
			return getEffect();
		case UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE:
			return getDefaultValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
			setVisibility((VisibilityRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
			setDirection((DirectionRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__NAME:
			setName((String) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__TYPE:
			setType((TypeRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__TYPE_UNDEFINED:
			setTypeUndefined((Boolean) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
			setMultiplicity((MultiplicityRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
			setModifiers((ModifiersRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__EFFECT:
			setEffect((EffectRule) newValue);
			return;
		case UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE:
			setDefaultValue((DefaultValueRule) newValue);
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
		case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
			setVisibility((VisibilityRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
			setDirection((DirectionRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case UmlParameterPackage.PARAMETER_RULE__TYPE:
			setType((TypeRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__TYPE_UNDEFINED:
			setTypeUndefined(TYPE_UNDEFINED_EDEFAULT);
			return;
		case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
			setMultiplicity((MultiplicityRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
			setModifiers((ModifiersRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__EFFECT:
			setEffect((EffectRule) null);
			return;
		case UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE:
			setDefaultValue((DefaultValueRule) null);
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
		case UmlParameterPackage.PARAMETER_RULE__VISIBILITY:
			return visibility != null;
		case UmlParameterPackage.PARAMETER_RULE__DIRECTION:
			return direction != null;
		case UmlParameterPackage.PARAMETER_RULE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case UmlParameterPackage.PARAMETER_RULE__TYPE:
			return type != null;
		case UmlParameterPackage.PARAMETER_RULE__TYPE_UNDEFINED:
			return typeUndefined != TYPE_UNDEFINED_EDEFAULT;
		case UmlParameterPackage.PARAMETER_RULE__MULTIPLICITY:
			return multiplicity != null;
		case UmlParameterPackage.PARAMETER_RULE__MODIFIERS:
			return modifiers != null;
		case UmlParameterPackage.PARAMETER_RULE__EFFECT:
			return effect != null;
		case UmlParameterPackage.PARAMETER_RULE__DEFAULT_VALUE:
			return defaultValue != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", typeUndefined: ");
		result.append(typeUndefined);
		result.append(')');
		return result.toString();
	}

} // ParameterRuleImpl
