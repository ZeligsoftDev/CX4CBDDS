/**
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.EntryRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.UmlStatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl.EntryRuleImpl#getKind <em>Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.state.xtext.umlState.impl.EntryRuleImpl#getBehaviorName <em>Behavior Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryRuleImpl extends MinimalEObjectImpl.Container implements EntryRule {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final BehaviorKind KIND_EDEFAULT = BehaviorKind.ACTIVITY;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected BehaviorKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getBehaviorName() <em>Behavior Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBehaviorName()
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBehaviorName() <em>Behavior Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBehaviorName()
	 * @generated
	 * @ordered
	 */
	protected String behaviorName = BEHAVIOR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EntryRuleImpl() {
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
		return UmlStatePackage.Literals.ENTRY_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BehaviorKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKind(BehaviorKind newKind) {
		BehaviorKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlStatePackage.ENTRY_RULE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBehaviorName() {
		return behaviorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBehaviorName(String newBehaviorName) {
		String oldBehaviorName = behaviorName;
		behaviorName = newBehaviorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlStatePackage.ENTRY_RULE__BEHAVIOR_NAME, oldBehaviorName, behaviorName));
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
		case UmlStatePackage.ENTRY_RULE__KIND:
			return getKind();
		case UmlStatePackage.ENTRY_RULE__BEHAVIOR_NAME:
			return getBehaviorName();
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
		case UmlStatePackage.ENTRY_RULE__KIND:
			setKind((BehaviorKind) newValue);
			return;
		case UmlStatePackage.ENTRY_RULE__BEHAVIOR_NAME:
			setBehaviorName((String) newValue);
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
		case UmlStatePackage.ENTRY_RULE__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case UmlStatePackage.ENTRY_RULE__BEHAVIOR_NAME:
			setBehaviorName(BEHAVIOR_NAME_EDEFAULT);
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
		case UmlStatePackage.ENTRY_RULE__KIND:
			return kind != KIND_EDEFAULT;
		case UmlStatePackage.ENTRY_RULE__BEHAVIOR_NAME:
			return BEHAVIOR_NAME_EDEFAULT == null ? behaviorName != null : !BEHAVIOR_NAME_EDEFAULT.equals(behaviorName);
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", behaviorName: ");
		result.append(behaviorName);
		result.append(')');
		return result.toString();
	}

} // EntryRuleImpl
