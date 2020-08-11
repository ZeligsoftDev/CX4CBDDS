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

import com.zeligsoft.ddk.zdl.zdlgen.GenDomainObject;
import com.zeligsoft.ddk.zdl.zdlgen.GenPalette;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDrawer;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Palette</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl#getDrawers <em>Drawer</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteImpl#getOwnedDrawers <em>Owned Drawer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenPaletteImpl extends GenPaletteItemImpl implements GenPalette {

	/**
	 * The cached value of the '{@link #getDrawers() <em>Drawer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawers()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteDrawer> drawers;

	/**
	 * The cached value of the '{@link #getOwnedDrawers() <em>Owned Drawer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDrawers()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteDrawer> ownedDrawers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPaletteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_PALETTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenDomainObject> getOwnedObjects() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<GenDomainObject> ownedObjects = (EList<GenDomainObject>) cache.get(eResource, this,
					ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT);
			if (ownedObjects == null) {
				cache.put(eResource, this, ZDLGenPackage.Literals.GEN_DOMAIN_OBJECT__OWNED_OBJECT,
						ownedObjects = new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
								ZDLGenPackage.GEN_PALETTE__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_PALETTE__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] { ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteDrawer> getDrawers() {
		if (drawers == null) {
			drawers = new SubsetSupersetEObjectResolvingEList<GenPaletteDrawer>(GenPaletteDrawer.class, this,
					ZDLGenPackage.GEN_PALETTE__DRAWER, null, DRAWER_ESUBSETS);
		}
		return drawers;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getDrawers() <em>Drawer</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] DRAWER_ESUBSETS = new int[] { ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer getDrawer(String name) {
		return getDrawer(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer getDrawer(String name, boolean ignoreCase) {
		drawerLoop: for (GenPaletteDrawer drawer : getDrawers()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(drawer.getName()) : name.equals(drawer.getName())))
				continue drawerLoop;
			return drawer;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteDrawer> getOwnedDrawers() {
		if (ownedDrawers == null) {
			ownedDrawers = new SubsetSupersetEObjectContainmentWithInverseEList<GenPaletteDrawer>(
					GenPaletteDrawer.class, this, ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER, OWNED_DRAWER_ESUPERSETS,
					null, ZDLGenPackage.GEN_PALETTE_DRAWER__PALETTE);
		}
		return ownedDrawers;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedDrawers() <em>Owned Drawer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDrawers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_DRAWER_ESUPERSETS = new int[] { ZDLGenPackage.GEN_PALETTE__DRAWER };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer getOwnedDrawer(String name) {
		return getOwnedDrawer(name, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteDrawer getOwnedDrawer(String name, boolean ignoreCase) {
		ownedDrawerLoop: for (GenPaletteDrawer ownedDrawer : getOwnedDrawers()) {
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(ownedDrawer.getName())
					: name.equals(ownedDrawer.getName())))
				continue ownedDrawerLoop;
			return ownedDrawer;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedDrawers()).basicAdd(otherEnd, msgs);
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
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			return ((InternalEList<?>) getOwnedDrawers()).basicRemove(otherEnd, msgs);
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
		case ZDLGenPackage.GEN_PALETTE__DRAWER:
			return getDrawers();
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			return getOwnedDrawers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE__DRAWER:
			getDrawers().clear();
			getDrawers().addAll((Collection<? extends GenPaletteDrawer>) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			getOwnedDrawers().clear();
			getOwnedDrawers().addAll((Collection<? extends GenPaletteDrawer>) newValue);
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
		case ZDLGenPackage.GEN_PALETTE__DRAWER:
			getDrawers().clear();
			return;
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			getOwnedDrawers().clear();
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
		case ZDLGenPackage.GEN_PALETTE__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_PALETTE__DRAWER:
			return drawers != null && !drawers.isEmpty();
		case ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER:
			return ownedDrawers != null && !ownedDrawers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_PALETTE__OWNED_DRAWER);
	}

} //GenPaletteImpl
