/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifier Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl#getRedefines <em>Redefines</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl#getSubsets <em>Subsets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModifierSpecificationImpl extends MinimalEObjectImpl.Container implements ModifierSpecification {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final ModifierKind VALUE_EDEFAULT = ModifierKind.READ_ONLY;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ModifierKind value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRedefines() <em>Redefines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRedefines()
	 * @generated
	 * @ordered
	 */
	protected RedefinesRule redefines;

	/**
	 * The cached value of the '{@link #getSubsets() <em>Subsets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubsets()
	 * @generated
	 * @ordered
	 */
	protected SubsetsRule subsets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModifierSpecificationImpl() {
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
		return UmlPortPackage.Literals.MODIFIER_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModifierKind getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(ModifierKind newValue) {
		ModifierKind oldValue = value;
		value = newValue == null ? VALUE_EDEFAULT : newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.MODIFIER_SPECIFICATION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RedefinesRule getRedefines() {
		return redefines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRedefines(RedefinesRule newRedefines, NotificationChain msgs) {
		RedefinesRule oldRedefines = redefines;
		redefines = newRedefines;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES, oldRedefines, newRedefines);
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
	public void setRedefines(RedefinesRule newRedefines) {
		if (newRedefines != redefines) {
			NotificationChain msgs = null;
			if (redefines != null)
				msgs = ((InternalEObject) redefines).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES, null, msgs);
			if (newRedefines != null)
				msgs = ((InternalEObject) newRedefines).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES, null, msgs);
			msgs = basicSetRedefines(newRedefines, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES, newRedefines, newRedefines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubsetsRule getSubsets() {
		return subsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSubsets(SubsetsRule newSubsets, NotificationChain msgs) {
		SubsetsRule oldSubsets = subsets;
		subsets = newSubsets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS, oldSubsets, newSubsets);
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
	public void setSubsets(SubsetsRule newSubsets) {
		if (newSubsets != subsets) {
			NotificationChain msgs = null;
			if (subsets != null)
				msgs = ((InternalEObject) subsets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS, null, msgs);
			if (newSubsets != null)
				msgs = ((InternalEObject) newSubsets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS, null, msgs);
			msgs = basicSetSubsets(newSubsets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS, newSubsets, newSubsets));
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
		case UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES:
			return basicSetRedefines(null, msgs);
		case UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS:
			return basicSetSubsets(null, msgs);
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
		case UmlPortPackage.MODIFIER_SPECIFICATION__VALUE:
			return getValue();
		case UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES:
			return getRedefines();
		case UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS:
			return getSubsets();
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
		case UmlPortPackage.MODIFIER_SPECIFICATION__VALUE:
			setValue((ModifierKind) newValue);
			return;
		case UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES:
			setRedefines((RedefinesRule) newValue);
			return;
		case UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS:
			setSubsets((SubsetsRule) newValue);
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
		case UmlPortPackage.MODIFIER_SPECIFICATION__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		case UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES:
			setRedefines((RedefinesRule) null);
			return;
		case UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS:
			setSubsets((SubsetsRule) null);
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
		case UmlPortPackage.MODIFIER_SPECIFICATION__VALUE:
			return value != VALUE_EDEFAULT;
		case UmlPortPackage.MODIFIER_SPECIFICATION__REDEFINES:
			return redefines != null;
		case UmlPortPackage.MODIFIER_SPECIFICATION__SUBSETS:
			return subsets != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} // ModifierSpecificationImpl
