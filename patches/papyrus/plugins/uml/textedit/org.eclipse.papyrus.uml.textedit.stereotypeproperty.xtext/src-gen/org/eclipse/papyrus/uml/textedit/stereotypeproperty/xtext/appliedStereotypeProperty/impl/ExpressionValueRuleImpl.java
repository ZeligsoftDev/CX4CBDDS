/**
 */
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.uml.alf.Expression;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.ExpressionValueRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Value Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.impl.ExpressionValueRuleImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionValueRuleImpl extends MinimalEObjectImpl.Container implements ExpressionValueRule {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExpressionValueRuleImpl() {
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
		return AppliedStereotypePropertyPackage.Literals.EXPRESSION_VALUE_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION, oldExpression, newExpression);
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
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION, newExpression, newExpression));
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
		case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION:
			return basicSetExpression(null, msgs);
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
		case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION:
			return getExpression();
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
		case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION:
			setExpression((Expression) newValue);
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
		case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION:
			setExpression((Expression) null);
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
		case AppliedStereotypePropertyPackage.EXPRESSION_VALUE_RULE__EXPRESSION:
			return expression != null;
		}
		return super.eIsSet(featureID);
	}

} // ExpressionValueRuleImpl
