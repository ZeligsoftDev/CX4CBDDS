/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.TypeRule;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;
import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getVisibility <em>Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#isDerived <em>Derived</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#isTypeUndefined <em>Type Undefined</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.impl.PropertyRuleImpl#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyRuleImpl extends MinimalEObjectImpl.Container implements PropertyRule {
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
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

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
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected DefaultValueRule default_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PropertyRuleImpl() {
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
		return UmlPropertyPackage.Literals.PROPERTY_RULE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__VISIBILITY, oldVisibility, newVisibility);
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
				msgs = ((InternalEObject) visibility).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__VISIBILITY, null, msgs);
			if (newVisibility != null)
				msgs = ((InternalEObject) newVisibility).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__VISIBILITY, null, msgs);
			msgs = basicSetVisibility(newVisibility, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__VISIBILITY, newVisibility, newVisibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__DERIVED, oldDerived, derived));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__TYPE, oldType, newType);
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
				msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__TYPE, newType, newType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__TYPE_UNDEFINED, oldTypeUndefined, typeUndefined));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
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
				msgs = ((InternalEObject) multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject) newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, oldModifiers, newModifiers);
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
				msgs = ((InternalEObject) modifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, null, msgs);
			if (newModifiers != null)
				msgs = ((InternalEObject) newModifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, null, msgs);
			msgs = basicSetModifiers(newModifiers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__MODIFIERS, newModifiers, newModifiers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultValueRule getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDefault(DefaultValueRule newDefault, NotificationChain msgs) {
		DefaultValueRule oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__DEFAULT, oldDefault, newDefault);
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
	public void setDefault(DefaultValueRule newDefault) {
		if (newDefault != default_) {
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject) default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject) newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPropertyPackage.PROPERTY_RULE__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPropertyPackage.PROPERTY_RULE__DEFAULT, newDefault, newDefault));
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
		case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
			return basicSetVisibility(null, msgs);
		case UmlPropertyPackage.PROPERTY_RULE__TYPE:
			return basicSetType(null, msgs);
		case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
			return basicSetMultiplicity(null, msgs);
		case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
			return basicSetModifiers(null, msgs);
		case UmlPropertyPackage.PROPERTY_RULE__DEFAULT:
			return basicSetDefault(null, msgs);
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
		case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
			return getVisibility();
		case UmlPropertyPackage.PROPERTY_RULE__DERIVED:
			return isDerived();
		case UmlPropertyPackage.PROPERTY_RULE__NAME:
			return getName();
		case UmlPropertyPackage.PROPERTY_RULE__TYPE:
			return getType();
		case UmlPropertyPackage.PROPERTY_RULE__TYPE_UNDEFINED:
			return isTypeUndefined();
		case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
			return getMultiplicity();
		case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
			return getModifiers();
		case UmlPropertyPackage.PROPERTY_RULE__DEFAULT:
			return getDefault();
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
		case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
			setVisibility((VisibilityRule) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__DERIVED:
			setDerived((Boolean) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__NAME:
			setName((String) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__TYPE:
			setType((TypeRule) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__TYPE_UNDEFINED:
			setTypeUndefined((Boolean) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
			setMultiplicity((MultiplicityRule) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
			setModifiers((ModifiersRule) newValue);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__DEFAULT:
			setDefault((DefaultValueRule) newValue);
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
		case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
			setVisibility((VisibilityRule) null);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__DERIVED:
			setDerived(DERIVED_EDEFAULT);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__TYPE:
			setType((TypeRule) null);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__TYPE_UNDEFINED:
			setTypeUndefined(TYPE_UNDEFINED_EDEFAULT);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
			setMultiplicity((MultiplicityRule) null);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
			setModifiers((ModifiersRule) null);
			return;
		case UmlPropertyPackage.PROPERTY_RULE__DEFAULT:
			setDefault((DefaultValueRule) null);
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
		case UmlPropertyPackage.PROPERTY_RULE__VISIBILITY:
			return visibility != null;
		case UmlPropertyPackage.PROPERTY_RULE__DERIVED:
			return derived != DERIVED_EDEFAULT;
		case UmlPropertyPackage.PROPERTY_RULE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case UmlPropertyPackage.PROPERTY_RULE__TYPE:
			return type != null;
		case UmlPropertyPackage.PROPERTY_RULE__TYPE_UNDEFINED:
			return typeUndefined != TYPE_UNDEFINED_EDEFAULT;
		case UmlPropertyPackage.PROPERTY_RULE__MULTIPLICITY:
			return multiplicity != null;
		case UmlPropertyPackage.PROPERTY_RULE__MODIFIERS:
			return modifiers != null;
		case UmlPropertyPackage.PROPERTY_RULE__DEFAULT:
			return default_ != null;
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
		result.append(" (derived: ");
		result.append(derived);
		result.append(", name: ");
		result.append(name);
		result.append(", typeUndefined: ");
		result.append(typeUndefined);
		result.append(')');
		return result.toString();
	}

} // PropertyRuleImpl
