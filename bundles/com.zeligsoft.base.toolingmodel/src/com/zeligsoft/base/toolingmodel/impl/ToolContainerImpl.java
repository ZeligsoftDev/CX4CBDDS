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

import com.zeligsoft.base.toolingmodel.Tool;
import com.zeligsoft.base.toolingmodel.ToolContainer;
import com.zeligsoft.base.toolingmodel.ToolingModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link com.zeligsoft.base.toolingmodel.impl.ToolContainerImpl#getTargetDiagram <em>Target Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ToolContainerImpl extends PaletteItemImpl implements ToolContainer {

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ToolingModelPackage.Literals.TOOL_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getTool() {
		if (tool == null) {
			tool = new EObjectContainmentEList<Tool>(Tool.class, this, ToolingModelPackage.TOOL_CONTAINER__TOOL);
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
			targetDiagram = new EDataTypeUniqueEList<String>(String.class, this,
					ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM);
		}
		return targetDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ToolingModelPackage.TOOL_CONTAINER__TOOL:
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
		case ToolingModelPackage.TOOL_CONTAINER__TOOL:
			return getTool();
		case ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM:
			return getTargetDiagram();
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
		case ToolingModelPackage.TOOL_CONTAINER__TOOL:
			getTool().clear();
			getTool().addAll((Collection<? extends Tool>) newValue);
			return;
		case ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM:
			getTargetDiagram().clear();
			getTargetDiagram().addAll((Collection<? extends String>) newValue);
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
		case ToolingModelPackage.TOOL_CONTAINER__TOOL:
			getTool().clear();
			return;
		case ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM:
			getTargetDiagram().clear();
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
		case ToolingModelPackage.TOOL_CONTAINER__TOOL:
			return tool != null && !tool.isEmpty();
		case ToolingModelPackage.TOOL_CONTAINER__TARGET_DIAGRAM:
			return targetDiagram != null && !targetDiagram.isEmpty();
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
		result.append(targetDiagram);
		result.append(')');
		return result.toString();
	}

} //ToolContainerImpl
