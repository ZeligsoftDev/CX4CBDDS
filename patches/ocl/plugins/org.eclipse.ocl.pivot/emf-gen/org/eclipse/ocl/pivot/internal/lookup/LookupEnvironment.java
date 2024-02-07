/**
 * Copyright (c) 2014, 2018 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 */
package org.eclipse.ocl.pivot.internal.lookup;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.internal.lookup.LookupPackage#getLookupEnvironment()
 * @generated
 */
public interface LookupEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupPackage#getLookupEnvironment_NamedElements()
	 * @generated
	 */
	EList<NamedElement> getNamedElements();

	/**
	 * Returns the value of the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Env</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Env</em>' reference.
	 * @see #setParentEnv(LookupEnvironment)
	 * @see org.eclipse.ocl.pivot.internal.lookup.LookupPackage#getLookupEnvironment_ParentEnv()
	 * @generated
	 */
	LookupEnvironment getParentEnv();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.internal.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Env</em>' reference.
	 * @see #getParentEnv()
	 * @generated
	 */
	void setParentEnv(LookupEnvironment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	<NE extends NamedElement> LookupEnvironment addElements(Collection<NE> elements);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LookupEnvironment addElement(NamedElement element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean hasFinalResult();

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.1
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Executor getExecutor();

} // LookupEnvironment
