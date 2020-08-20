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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteStack;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Palette Stack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteStackImpl#getActiveTool <em>Active Tool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPaletteStackImpl extends GenPaletteToolContainerImpl implements GenPaletteStack {

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected GenPaletteTool overrides;
	/**
	 * The cached value of the '{@link #getActiveTool() <em>Active Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveTool()
	 * @generated
	 * @ordered
	 */
	protected GenPaletteTool activeTool;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPaletteStackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_PALETTE_STACK;
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
		GenPaletteToolContainer container = getContainer();
		if (container != null) {
			return container;
		}
		return super.basicGetOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject) overrides;
			overrides = (GenPaletteTool) eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES, oldOverrides, overrides));
			}
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteTool basicGetOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverrides(GenPaletteTool newOverrides) {
		GenPaletteTool oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES,
					oldOverrides, overrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteToolContainer getContainer() {
		if (eContainerFeatureID() != ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER)
			return null;
		return (GenPaletteToolContainer) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(GenPaletteToolContainer newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainer, ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(GenPaletteToolContainer newContainer) {
		if (newContainer != eInternalContainer()
				|| (eContainerFeatureID() != ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject) newContainer).eInverseAdd(this,
						ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL, GenPaletteToolContainer.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER,
					newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getActiveTool() {
		if (activeTool != null && activeTool.eIsProxy()) {
			InternalEObject oldActiveTool = (InternalEObject) activeTool;
			activeTool = (GenPaletteTool) eResolveProxy(oldActiveTool);
			if (activeTool != oldActiveTool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL, oldActiveTool, activeTool));
			}
		}
		return activeTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPaletteTool basicGetActiveTool() {
		return activeTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActiveTool(GenPaletteTool newActiveTool) {
		GenPaletteTool oldActiveTool = activeTool;
		activeTool = newActiveTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL,
					oldActiveTool, activeTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainer((GenPaletteToolContainer) otherEnd, msgs);
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
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			return basicSetContainer(null, msgs);
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
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			return eInternalContainer().eInverseRemove(this, ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL,
					GenPaletteToolContainer.class, msgs);
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
		case ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES:
			if (resolve)
				return getOverrides();
			return basicGetOverrides();
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			return getContainer();
		case ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL:
			if (resolve)
				return getActiveTool();
			return basicGetActiveTool();
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
		case ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES:
			setOverrides((GenPaletteTool) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			setContainer((GenPaletteToolContainer) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL:
			setActiveTool((GenPaletteTool) newValue);
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
		case ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES:
			setOverrides((GenPaletteTool) null);
			return;
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			setContainer((GenPaletteToolContainer) null);
			return;
		case ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL:
			setActiveTool((GenPaletteTool) null);
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
		case ZDLGenPackage.GEN_PALETTE_STACK__OWNER:
			return isSetOwner();
		case ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES:
			return overrides != null;
		case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
			return getContainer() != null;
		case ZDLGenPackage.GEN_PALETTE_STACK__ACTIVE_TOOL:
			return activeTool != null;
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
		if (baseClass == GenPaletteTool.class) {
			switch (derivedFeatureID) {
			case ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES:
				return ZDLGenPackage.GEN_PALETTE_TOOL__OVERRIDES;
			case ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER:
				return ZDLGenPackage.GEN_PALETTE_TOOL__CONTAINER;
			default:
				return -1;
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
		if (baseClass == GenPaletteTool.class) {
			switch (baseFeatureID) {
			case ZDLGenPackage.GEN_PALETTE_TOOL__OVERRIDES:
				return ZDLGenPackage.GEN_PALETTE_STACK__OVERRIDES;
			case ZDLGenPackage.GEN_PALETTE_TOOL__CONTAINER:
				return ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER;
			default:
				return -1;
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
	public boolean isSetOwner() {
		return super.isSetOwner() || eIsSet(ZDLGenPackage.GEN_PALETTE_STACK__CONTAINER);
	}

} //GenPaletteStackImpl
