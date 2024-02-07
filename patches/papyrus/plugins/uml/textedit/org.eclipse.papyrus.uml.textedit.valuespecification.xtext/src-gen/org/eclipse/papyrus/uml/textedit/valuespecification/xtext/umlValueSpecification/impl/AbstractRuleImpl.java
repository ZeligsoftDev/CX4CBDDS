/**
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.AbstractRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UmlValueSpecificationPackage;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.UndefinedRule;
import org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.VisibilityKind;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl#getVisibility <em>Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl#getInstanceSpecification <em>Instance Specification</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.valuespecification.xtext.umlValueSpecification.impl.AbstractRuleImpl#getUndefined <em>Undefined</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractRuleImpl extends MinimalEObjectImpl.Container implements AbstractRule {
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityKind visibility;

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
	 * The cached value of the '{@link #getInstanceSpecification() <em>Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInstanceSpecification()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification instanceSpecification;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EObject value;

	/**
	 * The cached value of the '{@link #getUndefined() <em>Undefined</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUndefined()
	 * @generated
	 * @ordered
	 */
	protected UndefinedRule undefined;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractRuleImpl() {
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
		return UmlValueSpecificationPackage.Literals.ABSTRACT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VisibilityKind getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetVisibility(VisibilityKind newVisibility, NotificationChain msgs) {
		VisibilityKind oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY, oldVisibility, newVisibility);
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
	public void setVisibility(VisibilityKind newVisibility) {
		if (newVisibility != visibility) {
			NotificationChain msgs = null;
			if (visibility != null)
				msgs = ((InternalEObject) visibility).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY, null, msgs);
			if (newVisibility != null)
				msgs = ((InternalEObject) newVisibility).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY, null, msgs);
			msgs = basicSetVisibility(newVisibility, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY, newVisibility, newVisibility));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification getInstanceSpecification() {
		if (instanceSpecification != null && instanceSpecification.eIsProxy()) {
			InternalEObject oldInstanceSpecification = (InternalEObject) instanceSpecification;
			instanceSpecification = (InstanceSpecification) eResolveProxy(oldInstanceSpecification);
			if (instanceSpecification != oldInstanceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION, oldInstanceSpecification, instanceSpecification));
			}
		}
		return instanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification basicGetInstanceSpecification() {
		return instanceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInstanceSpecification(InstanceSpecification newInstanceSpecification) {
		InstanceSpecification oldInstanceSpecification = instanceSpecification;
		instanceSpecification = newInstanceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION, oldInstanceSpecification, instanceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetValue(EObject newValue, NotificationChain msgs) {
		EObject oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE, oldValue, newValue);
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
	public void setValue(EObject newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UndefinedRule getUndefined() {
		return undefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetUndefined(UndefinedRule newUndefined, NotificationChain msgs) {
		UndefinedRule oldUndefined = undefined;
		undefined = newUndefined;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED, oldUndefined, newUndefined);
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
	public void setUndefined(UndefinedRule newUndefined) {
		if (newUndefined != undefined) {
			NotificationChain msgs = null;
			if (undefined != null)
				msgs = ((InternalEObject) undefined).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED, null, msgs);
			if (newUndefined != null)
				msgs = ((InternalEObject) newUndefined).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED, null, msgs);
			msgs = basicSetUndefined(newUndefined, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED, newUndefined, newUndefined));
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY:
			return basicSetVisibility(null, msgs);
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE:
			return basicSetValue(null, msgs);
		case UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED:
			return basicSetUndefined(null, msgs);
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY:
			return getVisibility();
		case UmlValueSpecificationPackage.ABSTRACT_RULE__NAME:
			return getName();
		case UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION:
			if (resolve)
				return getInstanceSpecification();
			return basicGetInstanceSpecification();
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE:
			return getValue();
		case UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED:
			return getUndefined();
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY:
			setVisibility((VisibilityKind) newValue);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__NAME:
			setName((String) newValue);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION:
			setInstanceSpecification((InstanceSpecification) newValue);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE:
			setValue((EObject) newValue);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED:
			setUndefined((UndefinedRule) newValue);
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY:
			setVisibility((VisibilityKind) null);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION:
			setInstanceSpecification((InstanceSpecification) null);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE:
			setValue((EObject) null);
			return;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED:
			setUndefined((UndefinedRule) null);
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
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VISIBILITY:
			return visibility != null;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case UmlValueSpecificationPackage.ABSTRACT_RULE__INSTANCE_SPECIFICATION:
			return instanceSpecification != null;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__VALUE:
			return value != null;
		case UmlValueSpecificationPackage.ABSTRACT_RULE__UNDEFINED:
			return undefined != null;
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
		result.append(')');
		return result.toString();
	}

} // AbstractRuleImpl
