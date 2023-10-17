/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.pivot.annotations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection EClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.annotations.Collection_EClass#isNullFree <em>Null Free</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage#getCollection_EClass()
 * @model annotation="http://www.eclipse.org/OCL/MetaAnnotation"
 * @generated
 */
public interface Collection_EClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Null Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Null Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Free</em>' attribute.
	 * @see #setNullFree(boolean)
	 * @see org.eclipse.ocl.pivot.annotations.PivotAnnotationsPackage#getCollection_EClass_NullFree()
	 * @model
	 * @generated
	 */
	boolean isNullFree();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.pivot.annotations.Collection_EClass#isNullFree <em>Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Free</em>' attribute.
	 * @see #isNullFree()
	 * @generated
	 */
	void setNullFree(boolean value);

} // Collection_EClass
