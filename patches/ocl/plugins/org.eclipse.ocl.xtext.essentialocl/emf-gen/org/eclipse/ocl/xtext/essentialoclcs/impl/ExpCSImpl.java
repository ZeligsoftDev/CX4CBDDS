/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.essentialoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.internal.manager.PrecedenceManager;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.OperatorExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#isHasError <em>Has Error</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getLocalLeft <em>Local Left</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getLocalLeftmostDescendant <em>Local Leftmost Descendant</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getLocalParent <em>Local Parent</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getLocalRight <em>Local Right</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getLocalRightmostDescendant <em>Local Rightmost Descendant</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl#getPrecedenceOrder <em>Precedence Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpCSImpl
extends ModelElementCSImpl
implements ExpCS {

	/**
	 * The number of structural features of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXP_CS_FEATURE_COUNT = ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 8;
	/**
	 * The default value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_ERROR_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isHasError() <em>Has Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasError()
	 * @generated
	 * @ordered
	 */
	protected boolean hasError = HAS_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrecedenceOrder() <em>Precedence Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecedenceOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int PRECEDENCE_ORDER_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSPackage.Literals.EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasError()
	{
		return hasError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasError(boolean newHasError)
	{
		boolean oldHasError = hasError;
		hasError = newHasError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0, oldHasError, hasError));
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0:
				return isHasError();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1:
				return getLocalLeft();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2:
				return getLocalLeftmostDescendant();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3:
				return getLocalParent();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4:
				return getLocalRight();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 5:
				return getLocalRightmostDescendant();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 6:
				return getPrecedence();
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 7:
				return getPrecedenceOrder();
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0:
				setHasError((Boolean)newValue);
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
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0:
				setHasError(HAS_ERROR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0:
				return hasError != HAS_ERROR_EDEFAULT;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1:
				return getLocalLeft() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2:
				return getLocalLeftmostDescendant() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3:
				return getLocalParent() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4:
				return getLocalRight() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 5:
				return getLocalRightmostDescendant() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 6:
				return getPrecedence() != null;
			case ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 7:
				return getPrecedenceOrder() != PRECEDENCE_ORDER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof EssentialOCLCSVisitor) {
			return (R) ((EssentialOCLCSVisitor<?>)visitor).visitExpCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	protected @Nullable ExpCS localLeft = null;
	protected boolean hasLocalLeft = false;

	@Override
	public @Nullable ExpCS getLocalLeft() {
		if ((localLeft == null) && !hasLocalLeft) {
			hasLocalLeft = true;
			localLeft = getLocalLeftContainer();
		}
		return localLeft;
	}

	@Override
	public @Nullable OperatorExpCS getLocalLeftContainer() {
		EObject eContainer = eContainer();
		if (eContainer instanceof OperatorExpCS) {
			OperatorExpCS csContainer = (OperatorExpCS)eContainer;
			if (csContainer.getOwnedRight() == this) {
				return csContainer;
			}
			else {
				return csContainer.getLocalLeftContainer();
			}
		}
		return null;
	}

	@Override
	public @NonNull ExpCS getLocalLeftmostDescendant() {
		return this;
	}

	private @Nullable OperatorExpCS localParent = null;
	private boolean hasLocalParent = false;

	@Override
	public OperatorExpCS getLocalParent() {
		if ((localParent == null) && !hasLocalParent) {
			hasLocalParent = true;
			OperatorExpCS csNearestLeft = getLocalParentForLeft(getLocalLeft());
			OperatorExpCS csNearestRight = getLocalParentForRight(getLocalRight());
			if (csNearestLeft == null) {
				if (csNearestRight == null) {
					localParent = null;
				}
				else if (csNearestRight == this) {
					localParent = null;
				}
				else if (csNearestRight != this) {
					localParent = csNearestRight;
				}
			}
			else {
				if (csNearestRight == null) {
					localParent = csNearestLeft;
					assert localParent != this;
				}
				else if (csNearestLeft.isLocalLeftAncestorOf(csNearestRight)) {
					localParent = csNearestRight;
					assert localParent != this;
				}
				else {
					localParent = csNearestLeft;
					assert localParent != this;
				}
			}
		}
		return localParent;
	}

	private @Nullable OperatorExpCS getLocalParentForLeft(@Nullable ExpCS csLeft) {
		if (csLeft == null) {
			return null;
		}
		OperatorExpCS csLeftOperator = csLeft instanceof OperatorExpCS ? (OperatorExpCS)csLeft : null;
		if ((csLeftOperator != null) && csLeftOperator.isLocalLeftAncestorOf(this)) {
			return getLocalParentForLefts(csLeft.getLocalLeft(), csLeftOperator);
		}
		else {
			return getLocalParentForLeft(csLeft.getLocalLeft());
		}
	}
	private @NonNull OperatorExpCS getLocalParentForLefts(@Nullable ExpCS csLeft, @NonNull OperatorExpCS csNearestLeft) {
		if (csLeft == null) {
			return csNearestLeft;
		}
		OperatorExpCS csLeftOperator = csLeft instanceof OperatorExpCS ? (OperatorExpCS)csLeft : null;
		if ((csLeftOperator != null) && csNearestLeft.isLocalLeftAncestorOf(csLeft) && csLeftOperator.isLocalLeftAncestorOf(this)) {
			return getLocalParentForLefts(csLeft.getLocalLeft(), csLeftOperator);
		}
		else {
			return csNearestLeft;
		}
	}

	private @Nullable OperatorExpCS getLocalParentForRight(@Nullable ExpCS csRight) {
		if (csRight == null) {
			return null;
		}
		OperatorExpCS csRightOperator = csRight instanceof OperatorExpCS ? (OperatorExpCS)csRight : null;
		if ((csRightOperator != null) && csRightOperator.isLocalRightAncestorOf(this)) {
			return getLocalParentForRights(csRight.getLocalRight(), csRightOperator);
		}
		else {
			return getLocalParentForRight(csRight.getLocalRight());
		}
	}
	private @Nullable OperatorExpCS getLocalParentForRights(@Nullable ExpCS csRight, @NonNull OperatorExpCS csNearestRight) {
		if (csRight == null) {
			return csNearestRight;
		}
		OperatorExpCS csRightOperator = csRight instanceof OperatorExpCS ? (OperatorExpCS)csRight : null;
		if ((csRightOperator != null) && csRightOperator.isLocalRightAncestorOf(this) && csNearestRight.isLocalRightAncestorOf(csRight)) {
			return getLocalParentForRights(csRight.getLocalRight(), csRightOperator);
		}
		else {
			return csNearestRight;
		}
	}

	private @Nullable ExpCS localRight = null;
	private boolean hasLocalRight = false;

	@Override
	public @Nullable ExpCS getLocalRight() {
		if ((localRight == null) && !hasLocalRight) {
			hasLocalRight = true;
			localRight = getLocalRightContainer();
		}
		return localRight;
	}

	@Override
	public @Nullable OperatorExpCS getLocalRightContainer() {
		EObject eContainer = eContainer();
		if (eContainer instanceof InfixExpCS) {
			InfixExpCS csContainer = (InfixExpCS)eContainer;
			if (csContainer.getOwnedLeft() == this) {
				return csContainer;
			}
			else {
				return csContainer.getLocalRightContainer();
			}
		}
		else if (eContainer instanceof PrefixExpCS) {
			PrefixExpCS csContainer = (PrefixExpCS)eContainer;
			return csContainer.getLocalRightContainer();
		}
		return null;
	}

	@Override
	public @NonNull ExpCS getLocalRightmostDescendant() {
		return this;
	}

	@Override
	public ElementCS getParent() {
		ElementCS parent = getLocalParent();
		return parent != null ? parent : super.getParent();
	}

	@Override
	public Precedence getPrecedence() {
		return PrecedenceManager.LEAF_PRECEDENCE;
	}

	@Override
	public int getPrecedenceOrder() {
		return PrecedenceManager.LEAF_PRECEDENCE_ORDER;
	}

	@Override
	public boolean isLocalLeftAncestorOf(@NonNull ExpCS csExp) {	// csExp should be to the right of this for associativity resolution
		return false;
	}

	@Override
	public boolean isLocalRightAncestorOf(@NonNull ExpCS csExp) {	// csExp should be to the left of this for associativity resolution
		return false;
	}

	@Override
	public void resetPivot() {
		super.resetPivot();
		setHasError(false);
		localLeft = null;
		localParent = null;
		localRight = null;
		hasLocalLeft = false;
		hasLocalParent = false;
		hasLocalRight = false;
	}

	@Override
	public final void setPrecedence(Precedence newPrecedence) {
		throw new UnsupportedOperationException(); // Only OperatorExpCS is settable
	}

	@Override
	public void setPrecedence(@Nullable Precedence precedence, int precedenceOrder) {
		throw new UnsupportedOperationException(); // Only OperatorExpCS is settable
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
} //ExpCSImpl
