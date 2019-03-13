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
package com.zeligsoft.base.toolingmodel.impl;

import com.zeligsoft.base.toolingmodel.Stack;
import com.zeligsoft.base.toolingmodel.Tool;
import com.zeligsoft.base.toolingmodel.ToolContainer;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.StackImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.StackImpl#getTargetDiagram <em>Target Diagram</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.StackImpl#getActiveTool <em>Active Tool</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StackImpl extends ToolImpl implements Stack {

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> tool;

	/**
	 * The cached value of the '{@link #getTargetDiagram() <em>Target Diagram</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDiagram()
	 * @generated
	 * @ordered
	 */
	protected EList<String> targetDiagram;

	/**
	 * The cached value of the '{@link #getActiveTool() <em>Active Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveTool()
	 * @generated
	 * @ordered
	 */
	protected Tool activeTool;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.STACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getTool() {
		if (tool == null) {
			tool = new EObjectContainmentEList<Tool>(Tool.class, this,
					ToolingModelPackage.STACK__TOOL);
		}
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTargetDiagram() {
		if (targetDiagram == null) {
			targetDiagram = new EDataTypeUniqueEList<String>(String.class,
					this, ToolingModelPackage.STACK__TARGET_DIAGRAM);
		}
		return targetDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool getActiveTool() {
		if (activeTool != null && activeTool.eIsProxy()) {
			InternalEObject oldActiveTool = (InternalEObject) activeTool;
			activeTool = (Tool) eResolveProxy(oldActiveTool);
			if (activeTool != oldActiveTool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ToolingModelPackage.STACK__ACTIVE_TOOL,
							oldActiveTool, activeTool));
			}
		}
		return activeTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool basicGetActiveTool() {
		return activeTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveTool(Tool newActiveTool) {
		Tool oldActiveTool = activeTool;
		activeTool = newActiveTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ToolingModelPackage.STACK__ACTIVE_TOOL, oldActiveTool,
					activeTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ToolingModelPackage.STACK__TOOL:
			return ((InternalEList<?>) getTool()).basicRemove(otherEnd, msgs);
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
		case ToolingModelPackage.STACK__TOOL:
			return getTool();
		case ToolingModelPackage.STACK__TARGET_DIAGRAM:
			return getTargetDiagram();
		case ToolingModelPackage.STACK__ACTIVE_TOOL:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ToolingModelPackage.STACK__TOOL:
			getTool().clear();
			getTool().addAll((Collection<? extends Tool>) newValue);
			return;
		case ToolingModelPackage.STACK__TARGET_DIAGRAM:
			getTargetDiagram().clear();
			getTargetDiagram().addAll((Collection<? extends String>) newValue);
			return;
		case ToolingModelPackage.STACK__ACTIVE_TOOL:
			setActiveTool((Tool) newValue);
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
		case ToolingModelPackage.STACK__TOOL:
			getTool().clear();
			return;
		case ToolingModelPackage.STACK__TARGET_DIAGRAM:
			getTargetDiagram().clear();
			return;
		case ToolingModelPackage.STACK__ACTIVE_TOOL:
			setActiveTool((Tool) null);
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
		case ToolingModelPackage.STACK__TOOL:
			return tool != null && !tool.isEmpty();
		case ToolingModelPackage.STACK__TARGET_DIAGRAM:
			return targetDiagram != null && !targetDiagram.isEmpty();
		case ToolingModelPackage.STACK__ACTIVE_TOOL:
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
		if (baseClass == ToolContainer.class) {
			switch (derivedFeatureID) {
			case ToolingModelPackage.STACK__TOOL:
				return ToolingModelPackage.TOOL_CONTAINER__TOOL;
			case ToolingModelPackage.STACK__TARGET_DIAGRAM:
				return ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM;
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
		if (baseClass == ToolContainer.class) {
			switch (baseFeatureID) {
			case ToolingModelPackage.TOOL_CONTAINER__TOOL:
				return ToolingModelPackage.STACK__TOOL;
			case ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM:
				return ToolingModelPackage.STACK__TARGET_DIAGRAM;
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
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (targetDiagram: "); //$NON-NLS-1$
		result.append(targetDiagram);
		result.append(')');
		return result.toString();
	}

} //StackImpl
