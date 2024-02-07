/**
 */
package org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.SequenceTermRule;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.UmlMessagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Term Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl#getSequencialOrder <em>Sequencial Order</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl#getSequenceName <em>Sequence Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.impl.SequenceTermRuleImpl#getRecurrence <em>Recurrence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceTermRuleImpl extends MinimalEObjectImpl.Container implements SequenceTermRule {
	/**
	 * The default value of the '{@link #getSequencialOrder() <em>Sequencial Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSequencialOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int SEQUENCIAL_ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSequencialOrder() <em>Sequencial Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSequencialOrder()
	 * @generated
	 * @ordered
	 */
	protected int sequencialOrder = SEQUENCIAL_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSequenceName() <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String sequenceName = SEQUENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecurrence() <em>Recurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRecurrence()
	 * @generated
	 * @ordered
	 */
	protected static final String RECURRENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecurrence() <em>Recurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRecurrence()
	 * @generated
	 * @ordered
	 */
	protected String recurrence = RECURRENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SequenceTermRuleImpl() {
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
		return UmlMessagePackage.Literals.SEQUENCE_TERM_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getSequencialOrder() {
		return sequencialOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSequencialOrder(int newSequencialOrder) {
		int oldSequencialOrder = sequencialOrder;
		sequencialOrder = newSequencialOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER, oldSequencialOrder, sequencialOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSequenceName() {
		return sequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSequenceName(String newSequenceName) {
		String oldSequenceName = sequenceName;
		sequenceName = newSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCE_NAME, oldSequenceName, sequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRecurrence() {
		return recurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRecurrence(String newRecurrence) {
		String oldRecurrence = recurrence;
		recurrence = newRecurrence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlMessagePackage.SEQUENCE_TERM_RULE__RECURRENCE, oldRecurrence, recurrence));
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
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER:
			return getSequencialOrder();
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCE_NAME:
			return getSequenceName();
		case UmlMessagePackage.SEQUENCE_TERM_RULE__RECURRENCE:
			return getRecurrence();
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
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER:
			setSequencialOrder((Integer) newValue);
			return;
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCE_NAME:
			setSequenceName((String) newValue);
			return;
		case UmlMessagePackage.SEQUENCE_TERM_RULE__RECURRENCE:
			setRecurrence((String) newValue);
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
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER:
			setSequencialOrder(SEQUENCIAL_ORDER_EDEFAULT);
			return;
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCE_NAME:
			setSequenceName(SEQUENCE_NAME_EDEFAULT);
			return;
		case UmlMessagePackage.SEQUENCE_TERM_RULE__RECURRENCE:
			setRecurrence(RECURRENCE_EDEFAULT);
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
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCIAL_ORDER:
			return sequencialOrder != SEQUENCIAL_ORDER_EDEFAULT;
		case UmlMessagePackage.SEQUENCE_TERM_RULE__SEQUENCE_NAME:
			return SEQUENCE_NAME_EDEFAULT == null ? sequenceName != null : !SEQUENCE_NAME_EDEFAULT.equals(sequenceName);
		case UmlMessagePackage.SEQUENCE_TERM_RULE__RECURRENCE:
			return RECURRENCE_EDEFAULT == null ? recurrence != null : !RECURRENCE_EDEFAULT.equals(recurrence);
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
		result.append(" (sequencialOrder: ");
		result.append(sequencialOrder);
		result.append(", sequenceName: ");
		result.append(sequenceName);
		result.append(", recurrence: ");
		result.append(recurrence);
		result.append(')');
		return result.toString();
	}

} // SequenceTermRuleImpl
