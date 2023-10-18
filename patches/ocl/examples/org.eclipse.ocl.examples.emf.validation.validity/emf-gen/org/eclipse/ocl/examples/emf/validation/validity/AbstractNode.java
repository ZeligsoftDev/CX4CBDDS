/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.utilities.IVisibilityFilter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AbstractNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isGrayed <em>Grayed</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getWorstResult <em>Worst Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode_Enabled()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Grayed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grayed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grayed</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode_Grayed()
	 * @model default="false" required="true" changeable="false"
	 * @generated
	 */
	boolean isGrayed();

	/**
	 * Returns the value of the '<em><b>Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible</em>' attribute.
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode_Visible()
	 * @model default="true" required="true" changeable="false"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode_Label()
	 * @model default="" required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Worst Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Worst Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worst Result</em>' reference.
	 * @see #setWorstResult(Result)
	 * @see org.eclipse.ocl.examples.emf.validation.validity.ValidityPackage#getAbstractNode_WorstResult()
	 * @model resolveProxies="false" transient="true" derived="true"
	 * @generated
	 */
	@Nullable Result getWorstResult();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.emf.validation.validity.AbstractNode#getWorstResult <em>Worst Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Worst Result</em>' reference.
	 * @see #getWorstResult()
	 * @generated
	 */
	void setWorstResult(Result value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	@Nullable AbstractNode getParent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	@NonNull EList<? extends AbstractNode> getChildren();

	/**
	 * Return the number of visible children in this node and its descendants.
	 */
	int countVisibleChildren();

	/**
	 * Fill grayedNodes with all grayed nodes in this node and its descendants.
	 */
	void getGrayedElements(@NonNull List<AbstractNode> grayedNodes);

	/**
	 * Return the fraction of getChildren() that are visible in an array to suit access by a ContentProvider.
	 */
	@NonNull AbstractNode @NonNull [] getVisibleChildren();

	/**
	 * Update the grayed status of this node and all its descendants, returning &gt;0 if this node and its children are consistently enabled,
	 * &lt;0 is consistently disbaled and 0 otherwise.
	 */
	int refreshGrayed();

	/**
	 * Update the visible status of this node and all its descendants by comuting the AND of the visibilityFilters at each node.
	 * Return strue if this  node visible.
	 */
	boolean refreshVisibleChildren(@NonNull Iterable<@NonNull IVisibilityFilter> visibilityFilters);
} // AbstractNode
