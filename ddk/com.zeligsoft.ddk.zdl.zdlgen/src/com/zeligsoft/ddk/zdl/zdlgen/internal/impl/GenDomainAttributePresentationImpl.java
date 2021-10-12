/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.ddk.zdl.zdlgen.internal.impl;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentation;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainAttributePresentationKind;
import com.zeligsoft.ddk.zdl.zdlgen.GenDomainPresentationModelKind;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.common.util.CacheAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Domain Attribute Presentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#getPresentationHint <em>Presentation Hint</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#getPresentationKind <em>Presentation Kind</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenDomainAttributePresentationImpl#getVisibleModelType <em>Visible Model Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenDomainAttributePresentationImpl extends EObjectImpl implements GenDomainAttributePresentation {
	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final int VISIBLE_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int READ_ONLY_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #getPresentationHint() <em>Presentation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationHint()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENTATION_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPresentationHint() <em>Presentation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationHint()
	 * @generated
	 * @ordered
	 */
	protected String presentationHint = PRESENTATION_HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresentationKind() <em>Presentation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationKind()
	 * @generated
	 * @ordered
	 */
	protected static final GenDomainAttributePresentationKind PRESENTATION_KIND_EDEFAULT = GenDomainAttributePresentationKind.OTHER;

	/**
	 * The cached value of the '{@link #getPresentationKind() <em>Presentation Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationKind()
	 * @generated
	 * @ordered
	 */
	protected GenDomainAttributePresentationKind presentationKind = PRESENTATION_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 8000;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibleModelType() <em>Visible Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleModelType()
	 * @generated
	 * @ordered
	 */
	protected static final GenDomainPresentationModelKind VISIBLE_MODEL_TYPE_EDEFAULT = GenDomainPresentationModelKind.ALL;

	/**
	 * The cached value of the '{@link #getVisibleModelType() <em>Visible Model Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleModelType()
	 * @generated
	 * @ordered
	 */
	protected GenDomainPresentationModelKind visibleModelType = VISIBLE_MODEL_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenDomainAttributePresentationImpl() {
		super();
		eFlags |= VISIBLE_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_DOMAIN_ATTRIBUTE_PRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVisible() {
		return (eFlags & VISIBLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisible(boolean newVisible) {
		boolean oldVisible = (eFlags & VISIBLE_EFLAG) != 0;
		if (newVisible)
			eFlags |= VISIBLE_EFLAG;
		else
			eFlags &= ~VISIBLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE, oldVisible, newVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReadOnly() {
		return (eFlags & READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = (eFlags & READ_ONLY_EFLAG) != 0;
		if (newReadOnly)
			eFlags |= READ_ONLY_EFLAG;
		else
			eFlags &= ~READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY, oldReadOnly, newReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPresentationHint() {
		return presentationHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentationHint(String newPresentationHint) {
		String oldPresentationHint = presentationHint;
		presentationHint = newPresentationHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT, oldPresentationHint,
					presentationHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainAttributePresentationKind getPresentationKind() {
		return presentationKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentationKind(GenDomainAttributePresentationKind newPresentationKind) {
		GenDomainAttributePresentationKind oldPresentationKind = presentationKind;
		presentationKind = newPresentationKind == null ? PRESENTATION_KIND_EDEFAULT : newPresentationKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND, oldPresentationKind,
					presentationKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenDomainPresentationModelKind getVisibleModelType() {
		return visibleModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibleModelType(GenDomainPresentationModelKind newVisibleModelType) {
		GenDomainPresentationModelKind oldVisibleModelType = visibleModelType;
		visibleModelType = newVisibleModelType == null ? VISIBLE_MODEL_TYPE_EDEFAULT : newVisibleModelType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE, oldVisibleModelType,
					visibleModelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
			return isVisible();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
			return isReadOnly();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
			return getPresentationHint();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
			return getPresentationKind();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
			return getOrder();
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE:
			return getVisibleModelType();
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
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
			setVisible((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
			setReadOnly((Boolean) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
			setPresentationHint((String) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
			setPresentationKind((GenDomainAttributePresentationKind) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
			setOrder((Integer) newValue);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE:
			setVisibleModelType((GenDomainPresentationModelKind) newValue);
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
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
			setVisible(VISIBLE_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
			setPresentationHint(PRESENTATION_HINT_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
			setPresentationKind(PRESENTATION_KIND_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
			setOrder(ORDER_EDEFAULT);
			return;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE:
			setVisibleModelType(VISIBLE_MODEL_TYPE_EDEFAULT);
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
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE:
			return ((eFlags & VISIBLE_EFLAG) != 0) != VISIBLE_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__READ_ONLY:
			return ((eFlags & READ_ONLY_EFLAG) != 0) != READ_ONLY_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_HINT:
			return PRESENTATION_HINT_EDEFAULT == null ? presentationHint != null
					: !PRESENTATION_HINT_EDEFAULT.equals(presentationHint);
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__PRESENTATION_KIND:
			return presentationKind != PRESENTATION_KIND_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__ORDER:
			return order != ORDER_EDEFAULT;
		case ZDLGenPackage.GEN_DOMAIN_ATTRIBUTE_PRESENTATION__VISIBLE_MODEL_TYPE:
			return visibleModelType != VISIBLE_MODEL_TYPE_EDEFAULT;
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (visible: "); //$NON-NLS-1$
		result.append((eFlags & VISIBLE_EFLAG) != 0);
		result.append(", readOnly: "); //$NON-NLS-1$
		result.append((eFlags & READ_ONLY_EFLAG) != 0);
		result.append(", presentationHint: "); //$NON-NLS-1$
		result.append(presentationHint);
		result.append(", presentationKind: "); //$NON-NLS-1$
		result.append(presentationKind);
		result.append(", order: "); //$NON-NLS-1$
		result.append(order);
		result.append(", visibleModelType: "); //$NON-NLS-1$
		result.append(visibleModelType);
		result.append(')');
		return result.toString();
	}

	/**
	 * Retrieves the cache adapter for this '<em><b>Gen Domain Attribute Presentation</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The cache adapter for this '<em><b>Gen Domain Attribute Presentation</b></em>'.
	 * @generated
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.getInstance();
	}

} //GenDomainAttributePresentationImpl
