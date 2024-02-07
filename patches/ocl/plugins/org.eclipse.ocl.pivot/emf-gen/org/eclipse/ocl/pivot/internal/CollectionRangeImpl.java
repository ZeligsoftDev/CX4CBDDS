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
package org.eclipse.ocl.pivot.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionRangeImpl#getOwnedFirst <em>Owned First</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.CollectionRangeImpl#getOwnedLast <em>Owned Last</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionRangeImpl
		extends CollectionLiteralPartImpl
		implements CollectionRange {

	/**
	 * The number of structural features of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_RANGE_FEATURE_COUNT = CollectionLiteralPartImpl.COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Collection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_RANGE_OPERATION_COUNT = CollectionLiteralPartImpl.COLLECTION_LITERAL_PART_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getOwnedFirst() <em>Owned First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFirst()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedFirst;

	/**
	 * The cached value of the '{@link #getOwnedLast() <em>Owned Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLast()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedLast;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedFirst() {
		return ownedFirst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedFirst(OCLExpression newOwnedFirst, NotificationChain msgs)
	{
		OCLExpression oldOwnedFirst = ownedFirst;
		ownedFirst = newOwnedFirst;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 8, oldOwnedFirst, newOwnedFirst);
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
	public void setOwnedFirst(OCLExpression newOwnedFirst) {
		if (newOwnedFirst != ownedFirst)
		{
			NotificationChain msgs = null;
			if (ownedFirst != null)
				msgs = ((InternalEObject)ownedFirst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (8), null, msgs);
			if (newOwnedFirst != null)
				msgs = ((InternalEObject)newOwnedFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (8), null, msgs);
			msgs = basicSetOwnedFirst(newOwnedFirst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, newOwnedFirst, newOwnedFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedLast() {
		return ownedLast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedLast(OCLExpression newOwnedLast, NotificationChain msgs)
	{
		OCLExpression oldOwnedLast = ownedLast;
		ownedLast = newOwnedLast;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 9, oldOwnedLast, newOwnedLast);
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
	public void setOwnedLast(OCLExpression newOwnedLast) {
		if (newOwnedLast != ownedLast)
		{
			NotificationChain msgs = null;
			if (ownedLast != null)
				msgs = ((InternalEObject)ownedLast).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (9), null, msgs);
			if (newOwnedLast != null)
				msgs = ((InternalEObject)newOwnedLast).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (9), null, msgs);
			msgs = basicSetOwnedLast(newOwnedLast, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 9, newOwnedLast, newOwnedLast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case 0:
				return ((InternalEList<?>)getAnnotatingComments()).basicRemove(otherEnd, msgs);
			case 1:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case 2:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedExtensions()).basicRemove(otherEnd, msgs);
			case 8:
				return basicSetOwnedFirst(null, msgs);
			case 9:
				return basicSetOwnedLast(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case 0:
				return getAnnotatingComments();
			case 1:
				return getOwnedAnnotations();
			case 2:
				return getOwnedComments();
			case 3:
				return getOwnedExtensions();
			case 4:
				return getName();
			case 5:
				return isIsMany();
			case 6:
				return isIsRequired();
			case 7:
				if (resolve) return getType();
				return basicGetType();
			case 8:
				return getOwnedFirst();
			case 9:
				return getOwnedLast();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case 0:
				getAnnotatingComments().clear();
				getAnnotatingComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 1:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Element>)newValue);
				return;
			case 2:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case 3:
				getOwnedExtensions().clear();
				getOwnedExtensions().addAll((Collection<? extends ElementExtension>)newValue);
				return;
			case 4:
				setName((String)newValue);
				return;
			case 6:
				setIsRequired((Boolean)newValue);
				return;
			case 7:
				setType((Type)newValue);
				return;
			case 8:
				setOwnedFirst((OCLExpression)newValue);
				return;
			case 9:
				setOwnedLast((OCLExpression)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
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
			case 0:
				getAnnotatingComments().clear();
				return;
			case 1:
				getOwnedAnnotations().clear();
				return;
			case 2:
				getOwnedComments().clear();
				return;
			case 3:
				getOwnedExtensions().clear();
				return;
			case 4:
				setName(NAME_EDEFAULT);
				return;
			case 6:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case 7:
				setType((Type)null);
				return;
			case 8:
				setOwnedFirst((OCLExpression)null);
				return;
			case 9:
				setOwnedLast((OCLExpression)null);
				return;
		}
		eDynamicUnset(featureID);
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
			case 0:
				return annotatingComments != null && !annotatingComments.isEmpty();
			case 1:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case 2:
				return ownedComments != null && !ownedComments.isEmpty();
			case 3:
				return ownedExtensions != null && !ownedExtensions.isEmpty();
			case 4:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 5:
				return isIsMany() != IS_MANY_EDEFAULT;
			case 6:
				return ((eFlags & IS_REQUIRED_EFLAG) != 0) != IS_REQUIRED_EDEFAULT;
			case 7:
				return type != null;
			case 8:
				return ownedFirst != null;
			case 9:
				return ownedLast != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitCollectionRange(this);
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.INTEGER_RANGE;
	}
} //CollectionRangeImpl
