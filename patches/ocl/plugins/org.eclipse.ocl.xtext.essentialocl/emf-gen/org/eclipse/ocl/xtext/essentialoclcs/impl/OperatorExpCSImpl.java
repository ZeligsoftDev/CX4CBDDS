/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl#getOwnedRight <em>Owned Right</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.OperatorExpCSImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OperatorExpCSImpl
extends ExpCSImpl
implements OperatorExpCS {

	/**
	 * The number of structural features of the '<em>Operator Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OPERATOR_EXP_CS_FEATURE_COUNT = ExpCSImpl.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedRight() <em>Owned Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRight()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedRight;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ExpCS source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.OPERATOR_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedRight()
	{
		return ownedRight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRight(ExpCS newOwnedRight, NotificationChain msgs)
	{
		ExpCS oldOwnedRight = ownedRight;
		ownedRight = newOwnedRight;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9, oldOwnedRight, newOwnedRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedRight(ExpCS newOwnedRight)
	{
		if (newOwnedRight != ownedRight)
		{
			NotificationChain msgs = null;
			if (ownedRight != null)
				msgs = ((InternalEObject)ownedRight).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9), null, msgs);
			if (newOwnedRight != null)
				msgs = ((InternalEObject)newOwnedRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9), null, msgs);
			msgs = basicSetOwnedRight(newOwnedRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9, newOwnedRight, newOwnedRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				return getName();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9:
				return getOwnedRight();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10:
				return getSource();
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
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				setName((String)newValue);
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9:
				setOwnedRight((ExpCS)newValue);
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
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				setName(NAME_EDEFAULT);
				return;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9:
				setOwnedRight((ExpCS)null);
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
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9:
				return ownedRight != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 10:
				return source != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElementCS.class)
		{
			switch (derivedFeatureID)
			{
				case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8: return 5;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElementCS.class)
		{
			switch (baseFeatureID)
			{
				case 5: return ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 9:
				return basicSetOwnedRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	private Precedence precedence = null;
	private int precedenceOrder = 0;

	protected @Nullable ExpCS getExpressionForLeft(@NonNull ExpCS csLeft) {
		if (csLeft instanceof OperatorExpCS) {
			OperatorExpCS csLeftOperator = (OperatorExpCS) csLeft;
			if (csLeftOperator.isLocalLeftAncestorOf(this)) {
				return null;
			}
		}
		return getExpressionForLefts(csLeft.getLocalLeft(), csLeft);
	}
	private @NonNull ExpCS getExpressionForLefts(@Nullable ExpCS csLeft, @NonNull ExpCS csLowestLeft) {
		if (csLeft == null) {
			return csLowestLeft;
		}
		if (csLeft instanceof OperatorExpCS) {
			OperatorExpCS csLeftOperator = (OperatorExpCS) csLeft;
			if (csLeftOperator.isLocalLeftAncestorOf(this)) {
				return csLowestLeft;
			}
			if (csLeftOperator.isLocalLeftAncestorOf(csLowestLeft)) {
				return getExpressionForLefts(csLeft.getLocalLeft(), csLeft);
			}
		}
		return getExpressionForLefts(csLeft.getLocalLeft(), csLowestLeft);
	}

	protected @Nullable ExpCS getExpressionForRight(@NonNull ExpCS csRight) {
		if (csRight instanceof OperatorExpCS) {
			OperatorExpCS csRightOperator = (OperatorExpCS) csRight;
			if (csRightOperator.isLocalRightAncestorOf(this)) {
				return null;
			}
		}
		return getExpressionForRights(csRight.getLocalRight(), csRight);
	}
	private @NonNull ExpCS getExpressionForRights(@Nullable ExpCS csRight, @NonNull ExpCS csLowestRight) {
		if (csRight == null) {
			return csLowestRight;
		}
		if (csRight instanceof OperatorExpCS) {
			OperatorExpCS csRightOperator = (OperatorExpCS) csRight;
			if (csRightOperator.isLocalRightAncestorOf(this)) {
				return csLowestRight;
			}
			if (csRightOperator.isLocalRightAncestorOf(csLowestRight)) {
				return getExpressionForRights(csRight.getLocalRight(), csRight);
			}
		}
		return getExpressionForRights(csRight.getLocalRight(), csLowestRight);
	}

	@Override
	public @Nullable ExpCS getLocalRight() {
		ExpCS ownedRight = getOwnedRight();
		return ownedRight != null ? ownedRight.getLocalLeftmostDescendant() : null;
	}

	@Override
	public @NonNull ExpCS getLocalRightmostDescendant() {
		ExpCS ownedRight = getOwnedRight();
		return ownedRight != null ? ownedRight.getLocalRightmostDescendant() : this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ElementCS getParent()
	{
		ExpCS parent = getLocalParent();
		if (parent != null) {
			return parent;
		}
		EObject eContainer = eContainer();
		while (eContainer instanceof OperatorExpCS) {
			eContainer = eContainer.eContainer();
		}
		return eContainer instanceof ElementCS ? (ElementCS) eContainer : null;		// Avoid CCE for Bug 432749
	}

	@Override
	public @NonNull Precedence getPrecedence() {
		return precedence != null ? precedence : PrecedenceManager.NULL_PRECEDENCE;
	}

	@Override
	public int getPrecedenceOrder() {
		return precedenceOrder;
	}

	@Override
	public abstract ExpCS getSource();

	@Override
	public boolean isLocalLeftAncestorOf(@NonNull ExpCS csExp) {	// csExp should be to the right of this for associativity resolution
		int leftOrder = getPrecedenceOrder();
		int rightOrder = csExp.getPrecedenceOrder();
		if (leftOrder > rightOrder) {
			return true;
		}
		else if (leftOrder > rightOrder) {
			return false;
		}
		else if (getPrecedence().getAssociativity() == AssociativityKind.RIGHT) {
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean hasSource = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("cast")
	@Override
	public void resetPivot() {
		assert this instanceof ExpCSImpl;	// Enforce correct ordering of base classes
		super.resetPivot();
		precedence = null;
		source = null;
		hasSource = false;
	}

	@Override
	public void setPrecedence(@Nullable Precedence newPrecedence, int newPrecedenceOrder) {
		precedence = newPrecedence;
		precedenceOrder = newPrecedenceOrder;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //OperatorCSImpl
