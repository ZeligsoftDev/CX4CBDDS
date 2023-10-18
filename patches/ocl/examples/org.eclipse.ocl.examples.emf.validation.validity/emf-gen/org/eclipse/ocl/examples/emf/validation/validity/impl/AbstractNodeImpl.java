/*******************************************************************************
 * Copyright (c) 2013, 2020 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.emf.validation.validity.AbstractNode;
import org.eclipse.ocl.examples.emf.validation.validity.Result;
import org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AbstractNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl#isGrayed <em>Grayed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.impl.AbstractNodeImpl#getWorstResult <em>Worst Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractNodeImpl extends MinimalEObjectImpl.Container implements AbstractNode {
	/**
	 * The number of structural features of the '<em>Abstract Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_NODE_FEATURE_COUNT = 5;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isGrayed() <em>Grayed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrayed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GRAYED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGrayed() <em>Grayed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrayed()
	 * @generated
	 * @ordered
	 */
	protected boolean grayed = GRAYED_EDEFAULT;

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
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorstResult() <em>Worst Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorstResult()
	 * @generated
	 * @ordered
	 */
	protected Result worstResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValidityPackage.Literals.ABSTRACT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		enabled = newEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGrayed() {
		return grayed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Result getWorstResult() {
		return worstResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorstResultGen(Result newWorstResult) {
		worstResult = newWorstResult;
	}
	@Override
	public void setWorstResult(Result newWorstResult) {
		if (newWorstResult != worstResult) {
			Result oldWorstResult = worstResult;
			setWorstResultGen(newWorstResult);
			if (isWorstResult(newWorstResult, oldWorstResult)) {
				AbstractNode parent = getParent();
				if ((parent != null) && isWorstResult(newWorstResult, parent.getWorstResult())) {
					parent.setWorstResult(newWorstResult);
				}
			}
		}
	}
	private boolean isWorstResult(Result newWorstResult, Result oldWorstResult) {
		if (newWorstResult == null) {
			return false;
		}
		if (oldWorstResult == null) {
			return true;
		}
		return newWorstResult.getSeverity().ordinal() > oldWorstResult.getSeverity().ordinal();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract AbstractNode getParent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public @NonNull abstract EList<? extends AbstractNode> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 0:
				return isEnabled();
			case 1:
				return isGrayed();
			case 2:
				return isVisible();
			case 3:
				return getLabel();
			case 4:
				return getWorstResult();
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
			case 0:
				setEnabled((Boolean)newValue);
				return;
			case 3:
				setLabel((String)newValue);
				return;
			case 4:
				setWorstResult((Result)newValue);
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
			case 0:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case 3:
				setLabel(LABEL_EDEFAULT);
				return;
			case 4:
				setWorstResult((Result)null);
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
			case 0:
				return enabled != ENABLED_EDEFAULT;
			case 1:
				return grayed != GRAYED_EDEFAULT;
			case 2:
				return visible != VISIBLE_EDEFAULT;
			case 3:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case 4:
				return worstResult != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		return String.valueOf(label);
	}

	public static final @NonNull AbstractNode @NonNull [] NO_CHILDREN = new AbstractNode[0];

	private @NonNull AbstractNode @NonNull [] visibleChildren = NO_CHILDREN;

	@Override
	public int countVisibleChildren() {
		int allChildren = 1;
		for (AbstractNode child : visibleChildren) {
			allChildren += child.countVisibleChildren();
		}
		return allChildren;
	}

	@Override
	public void getGrayedElements(@NonNull List<AbstractNode> grayedNodes) {
		if (grayed) {
			grayedNodes.add(this);
		}
		for (AbstractNode child : visibleChildren) {
			child.getGrayedElements(grayedNodes);
		}
	}

	@Override
	public @NonNull AbstractNode @NonNull [] getVisibleChildren() {
		return visibleChildren;
	}

	@Override
	public int refreshGrayed() {
		boolean isEnabled = enabled;
		boolean isDisabled = !isEnabled;
		for (AbstractNode child : visibleChildren) {
			int childStatus = child.refreshGrayed();
			if (childStatus >= 0) {
				isEnabled = true;
			}
			if (childStatus <= 0) {
				isDisabled = true;
			}
		}
		if (!isDisabled) {
			grayed = false;
			return 1;
		}
		else if (!isEnabled) {
			grayed = false;
			return -1;
		}
		else {
			grayed = true;
			//			System.out.println("Grayed " + eClass().getName() + " " + ILabelGenerator.Registry.INSTANCE.labelFor(getContext()));
			return 0;
		}
	}

	@Override
	public boolean refreshVisibleChildren(@NonNull Iterable<@NonNull IVisibilityFilter> visibilityFilters) {
		List<@NonNull ? extends AbstractNode> nullFreeChildren = ClassUtil.nullFree(getChildren());
		List<@NonNull ? extends AbstractNode> children = new ArrayList<>(nullFreeChildren);		// Avoid CME from refresh during discover
		List<@NonNull AbstractNode> list = new ArrayList<>(children.size());
		for (@NonNull AbstractNode node : children) {
			if (node.refreshVisibleChildren(visibilityFilters)) {
				list.add(node);
			}
		}
		for (@NonNull IVisibilityFilter filter : visibilityFilters) {
			if (!filter.isVisible(this)) {
				this.visibleChildren = NO_CHILDREN;
				this.visible = false;
				return false;
			}
		}
		@NonNull AbstractNode @NonNull [] array = list.toArray(new @NonNull AbstractNode @NonNull [list.size()]);
		this.visibleChildren = array;
		this.visible = true;
		return true;
	}
} //AbstractNodeImpl
