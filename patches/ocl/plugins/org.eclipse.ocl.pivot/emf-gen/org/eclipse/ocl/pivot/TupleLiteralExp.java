/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ocl.pivot.TupleLiteralExp#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ocl.pivot.PivotPackage#getTupleLiteralExp()
 * @generated
 */
public interface TupleLiteralExp
		extends LiteralExp {

	/**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.TupleLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.pivot.PivotPackage#getTupleLiteralExp_OwnedParts()
	 * @generated
	 */
	List<TupleLiteralPart> getOwnedParts();

} // TupleLiteralExp
