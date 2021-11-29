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
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteDiagramKind;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectResolvingEList;

import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteTool;
import com.zeligsoft.ddk.zdl.zdlgen.GenPaletteToolContainer;
import com.zeligsoft.ddk.zdl.zdlgen.ZDLGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Palette Tool Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl#getOwnedObjects <em>Owned Object</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl#getTools <em>Tool</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl#getOwnedTools <em>Owned Tool</em>}</li>
 *   <li>{@link com.zeligsoft.ddk.zdl.zdlgen.internal.impl.GenPaletteToolContainerImpl#getTargetDiagrams <em>Target Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenPaletteToolContainerImpl extends GenPaletteItemImpl implements GenPaletteToolContainer {

	/**
	 * The cached value of the '{@link #getTools() <em>Tool</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTools()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteTool> tools;

	/**
	 * The cached value of the '{@link #getOwnedTools() <em>Owned Tool</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTools()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteTool> ownedTools;

	/**
	 * The cached value of the '{@link #getTargetDiagrams() <em>Target Diagram</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<GenPaletteDiagramKind> targetDiagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPaletteToolContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ZDLGenPackage.Literals.GEN_PALETTE_TOOL_CONTAINER;
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
								ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS));
			}
			return ownedObjects;
		}
		return new DerivedUnionEObjectEList<GenDomainObject>(GenDomainObject.class, this,
				ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT, OWNED_OBJECT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedObjects() <em>Owned Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedObjects()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_OBJECT_ESUBSETS = new int[] {
			ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteTool> getOwnedTools() {
		if (ownedTools == null) {
			ownedTools = new SubsetSupersetEObjectContainmentWithInverseEList<GenPaletteTool>(GenPaletteTool.class,
					this, ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL, OWNED_TOOL_ESUPERSETS, null,
					ZDLGenPackage.GEN_PALETTE_TOOL__CONTAINER);
		}
		return ownedTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getOwnedTool(String name) {
		return getOwnedTool(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getOwnedTool(String name, boolean ignoreCase, EClass eClass) {
		ownedToolLoop: for (GenPaletteTool ownedTool : getOwnedTools()) {
			if (eClass != null && !eClass.isInstance(ownedTool))
				continue ownedToolLoop;
			if (name != null
					&& !(ignoreCase ? name.equalsIgnoreCase(ownedTool.getName()) : name.equals(ownedTool.getName())))
				continue ownedToolLoop;
			return ownedTool;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteDiagramKind> getTargetDiagrams() {
		if (targetDiagrams == null) {
			targetDiagrams = new EDataTypeUniqueEList<GenPaletteDiagramKind>(GenPaletteDiagramKind.class, this,
					ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM);
		}
		return targetDiagrams;
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
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOwnedTools()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenPaletteTool> getTools() {
		if (tools == null) {
			tools = new SubsetSupersetEObjectResolvingEList<GenPaletteTool>(GenPaletteTool.class, this,
					ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL, null, TOOL_ESUBSETS);
		}
		return tools;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getTools() <em>Tool</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTools()
	 * @generated
	 * @ordered
	 */
	protected static final int[] TOOL_ESUBSETS = new int[] { ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL };

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedTools() <em>Owned Tool</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTools()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_TOOL_ESUPERSETS = new int[] { ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getTool(String name) {
		return getTool(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenPaletteTool getTool(String name, boolean ignoreCase, EClass eClass) {
		toolLoop: for (GenPaletteTool tool : getTools()) {
			if (eClass != null && !eClass.isInstance(tool))
				continue toolLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(tool.getName()) : name.equals(tool.getName())))
				continue toolLoop;
			return tool;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			return ((InternalEList<?>) getOwnedTools()).basicRemove(otherEnd, msgs);
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
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL:
			return getTools();
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			return getOwnedTools();
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM:
			return getTargetDiagrams();
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
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL:
			getTools().clear();
			getTools().addAll((Collection<? extends GenPaletteTool>) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			getOwnedTools().clear();
			getOwnedTools().addAll((Collection<? extends GenPaletteTool>) newValue);
			return;
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM:
			getTargetDiagrams().clear();
			getTargetDiagrams().addAll((Collection<? extends GenPaletteDiagramKind>) newValue);
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
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL:
			getTools().clear();
			return;
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			getOwnedTools().clear();
			return;
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM:
			getTargetDiagrams().clear();
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
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_OBJECT:
			return isSetOwnedObjects();
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TOOL:
			return tools != null && !tools.isEmpty();
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL:
			return ownedTools != null && !ownedTools.isEmpty();
		case ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__TARGET_DIAGRAM:
			return targetDiagrams != null && !targetDiagrams.isEmpty();
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
		result.append(" (targetDiagram: "); //$NON-NLS-1$
		result.append(targetDiagrams);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedObjects() {
		return super.isSetOwnedObjects() || eIsSet(ZDLGenPackage.GEN_PALETTE_TOOL_CONTAINER__OWNED_TOOL);
	}

} //GenPaletteToolContainerImpl
