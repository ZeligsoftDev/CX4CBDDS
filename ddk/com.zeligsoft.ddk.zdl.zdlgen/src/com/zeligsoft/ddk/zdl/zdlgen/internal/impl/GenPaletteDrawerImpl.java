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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;
import com.zeligsoft.ddk.zdl.zdlgen.internal.operations.GenPaletteDrawerOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Palette Drawer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl#getSpecializes <em>Specializes</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteDrawerImpl#getPalette <em>Palette</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPaletteDrawerImpl extends GenPaletteToolContainerImpl implements GenPaletteDrawer {

	/**
	 * The cached value of the '{@link #getSpecializes() <em>Specializes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializes()
	 * @generated
	 * @ordered
	 */
	protected GenPaletteDrawer specializes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPaletteDrawerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_PALETTE_DRAWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject getOwner() {
		GenDomainObject owner = basicGetOwner();
		return owner != null && owner.eIsProxy() ? (GenDomainObject) eResolveProxy((InternalEObject) owner) : owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenDomainObject basicGetOwner() {
		GenPalette palette = getPalette();
		if (palette != null) {
			return palette;
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer getSpecializes() {
		if (specializes != null && specializes.eIsProxy()) {
			InternalEObject oldSpecializes = (InternalEObject) specializes;
			specializes = (GenPaletteDrawer) eResolveProxy(oldSpecializes);
			if (specializes != oldSpecializes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES, oldSpecializes, specializes));
			}
		}
		return specializes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteDrawer basicGetSpecializes() {
		return specializes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecializes(GenPaletteDrawer newSpecializes) {
		GenPaletteDrawer oldSpecializes = specializes;
		specializes = newSpecializes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES,
					oldSpecializes, specializes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPalette getPalette() {
		if (eContainerFeatureID() != ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE)
			return null;
		return (GenPalette) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPalette(GenPalette newPalette, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPalette, ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPalette(GenPalette newPalette) {
		if (newPalette != eInternalContainer()
				|| (eContainerFeatureID() != ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE && newPalette != null)) {
			if (EcoreUtil.isAncestor(this, newPalette))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPalette != null)
				msgs = ((InternalEObject) newPalette).eInverseAdd(this, ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER,
						GenPalette.class, msgs);
			msgs = basicSetPalette(newPalette, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE, newPalette,
					newPalette));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteTool> allTools() {
		return GenPaletteDrawerOperations.allTools(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPalette((GenPalette) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			return basicSetPalette(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			return eInternalContainer().eInverseRemove(this, ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER, GenPalette.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES:
			if (resolve)
				return getSpecializes();
			return basicGetSpecializes();
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			return getPalette();
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
		case ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES:
			setSpecializes((GenPaletteDrawer) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			setPalette((GenPalette) newValue);
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
		case ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES:
			setSpecializes((GenPaletteDrawer) null);
			return;
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			setPalette((GenPalette) null);
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
		case ZDLGenPackage.GEN_PALETTE_DRAWER__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_PALETTE_DRAWER__SPECIALIZES:
			return specializes != null;
		case ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE:
			return getPalette() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE);
	}

} //GenPaletteDrawerImpl
