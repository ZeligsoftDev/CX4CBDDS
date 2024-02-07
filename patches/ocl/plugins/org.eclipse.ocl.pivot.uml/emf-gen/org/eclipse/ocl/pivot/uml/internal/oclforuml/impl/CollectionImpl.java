/**
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.uml.internal.oclforuml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.Collection;
import org.eclipse.ocl.pivot.uml.internal.oclforuml.OCLforUMLPackage;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.CollectionImpl#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.uml.internal.oclforuml.impl.CollectionImpl#isNullFree <em>Is Null Free</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionImpl
		extends EObjectImpl
		implements Collection {

	/**
	 * The cached value of the '{@link #getBase_MultiplicityElement() <em>Base Multiplicity Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_MultiplicityElement()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityElement base_MultiplicityElement;

	/**
	 * The default value of the '{@link #isNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullFree()
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFree = IS_NULL_FREE_EDEFAULT;

	/**
	 * This is true if the Is Null Free attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFreeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLforUMLPackage.Literals.COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MultiplicityElement getBase_MultiplicityElement() {
		if (base_MultiplicityElement != null && base_MultiplicityElement.eIsProxy())
		{
			InternalEObject oldBase_MultiplicityElement = (InternalEObject)base_MultiplicityElement;
			base_MultiplicityElement = (MultiplicityElement)eResolveProxy(oldBase_MultiplicityElement);
			if (base_MultiplicityElement != oldBase_MultiplicityElement)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT, oldBase_MultiplicityElement, base_MultiplicityElement));
			}
		}
		return base_MultiplicityElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityElement basicGetBase_MultiplicityElement() {
		return base_MultiplicityElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_MultiplicityElement(
			MultiplicityElement newBase_MultiplicityElement) {
		MultiplicityElement oldBase_MultiplicityElement = base_MultiplicityElement;
		base_MultiplicityElement = newBase_MultiplicityElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT, oldBase_MultiplicityElement, base_MultiplicityElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNullFree() {
		return isNullFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree) {
		boolean oldIsNullFree = isNullFree;
		isNullFree = newIsNullFree;
		boolean oldIsNullFreeESet = isNullFreeESet;
		isNullFreeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLforUMLPackage.COLLECTION__IS_NULL_FREE, oldIsNullFree, isNullFree, !oldIsNullFreeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsNullFree() {
		boolean oldIsNullFree = isNullFree;
		boolean oldIsNullFreeESet = isNullFreeESet;
		isNullFree = IS_NULL_FREE_EDEFAULT;
		isNullFreeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OCLforUMLPackage.COLLECTION__IS_NULL_FREE, oldIsNullFree, IS_NULL_FREE_EDEFAULT, oldIsNullFreeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsNullFree() {
		return isNullFreeESet;
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
			case OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT:
				if (resolve) return getBase_MultiplicityElement();
				return basicGetBase_MultiplicityElement();
			case OCLforUMLPackage.COLLECTION__IS_NULL_FREE:
				return isNullFree();
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
			case OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT:
				setBase_MultiplicityElement((MultiplicityElement)newValue);
				return;
			case OCLforUMLPackage.COLLECTION__IS_NULL_FREE:
				setIsNullFree((Boolean)newValue);
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
			case OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT:
				setBase_MultiplicityElement((MultiplicityElement)null);
				return;
			case OCLforUMLPackage.COLLECTION__IS_NULL_FREE:
				unsetIsNullFree();
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
			case OCLforUMLPackage.COLLECTION__BASE_MULTIPLICITY_ELEMENT:
				return base_MultiplicityElement != null;
			case OCLforUMLPackage.COLLECTION__IS_NULL_FREE:
				return isSetIsNullFree();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isNullFree: "); //$NON-NLS-1$
		if (isNullFreeESet) result.append(isNullFree); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //CollectionImpl
