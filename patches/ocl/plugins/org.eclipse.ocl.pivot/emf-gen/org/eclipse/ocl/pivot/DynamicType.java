/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.DynamicType#getOwnedDynamicProperties <em>Owned Dynamic Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getDynamicType()
 * @generated
 */
public interface DynamicType extends org.eclipse.ocl.pivot.Class, DynamicElement
{
	/**
	 * Returns the value of the '<em><b>Owned Dynamic Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.DynamicProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Dynamic Properties</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getDynamicType_OwnedDynamicProperties()
	 * @generated
	 */
	@NonNull List<DynamicProperty> getOwnedDynamicProperties();

} // DynamicType
