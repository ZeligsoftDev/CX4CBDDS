/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.cx.langc.impl;

import com.zeligsoft.cx.codegen.io.CodeWriter;
import com.zeligsoft.cx.langc.CastExpr;
import com.zeligsoft.cx.langc.ElementReference;
import com.zeligsoft.cx.langc.Expression;
import com.zeligsoft.cx.langc.LangCPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cast Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.cx.langc.impl.CastExprImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link com.zeligsoft.cx.langc.impl.CastExprImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CastExprImpl extends ExpressionImpl implements CastExpr {
	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected ElementReference targetType;

	/**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected Expression expr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LangCPackage.Literals.CAST_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementReference getTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetType(ElementReference newTargetType, NotificationChain msgs) {
		ElementReference oldTargetType = targetType;
		targetType = newTargetType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.CAST_EXPR__TARGET_TYPE, oldTargetType, newTargetType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(ElementReference newTargetType) {
		if (newTargetType != targetType) {
			NotificationChain msgs = null;
			if (targetType != null)
				msgs = ((InternalEObject)targetType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.CAST_EXPR__TARGET_TYPE, null, msgs);
			if (newTargetType != null)
				msgs = ((InternalEObject)newTargetType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.CAST_EXPR__TARGET_TYPE, null, msgs);
			msgs = basicSetTargetType(newTargetType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.CAST_EXPR__TARGET_TYPE, newTargetType, newTargetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpr() {
		return expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs) {
		Expression oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LangCPackage.CAST_EXPR__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(Expression newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LangCPackage.CAST_EXPR__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LangCPackage.CAST_EXPR__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LangCPackage.CAST_EXPR__EXPR, newExpr, newExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LangCPackage.CAST_EXPR__TARGET_TYPE:
				return basicSetTargetType(null, msgs);
			case LangCPackage.CAST_EXPR__EXPR:
				return basicSetExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LangCPackage.CAST_EXPR__TARGET_TYPE:
				return getTargetType();
			case LangCPackage.CAST_EXPR__EXPR:
				return getExpr();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LangCPackage.CAST_EXPR__TARGET_TYPE:
				setTargetType((ElementReference)newValue);
				return;
			case LangCPackage.CAST_EXPR__EXPR:
				setExpr((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LangCPackage.CAST_EXPR__TARGET_TYPE:
				setTargetType((ElementReference)null);
				return;
			case LangCPackage.CAST_EXPR__EXPR:
				setExpr((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LangCPackage.CAST_EXPR__TARGET_TYPE:
				return targetType != null;
			case LangCPackage.CAST_EXPR__EXPR:
				return expr != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public ElementReference basicGetType() {
		return getTargetType();
	}

	@Override public int getPrecendence() { return 41; }

	@Override
	public boolean write(CodeWriter code) {
		return code.write('(')
			&& getTargetType().write(code, null)
			&& code.write(')')
			&& getExpr().write(code);
	}

} //CastExprImpl
