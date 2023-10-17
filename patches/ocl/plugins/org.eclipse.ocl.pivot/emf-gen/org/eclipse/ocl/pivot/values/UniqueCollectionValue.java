/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.values;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Collection Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.pivot.values.ValuesPackage#getUniqueCollectionValue()
 * @generated
 */
public interface UniqueCollectionValue extends CollectionValue {
	/**
	 * @generated NOT
	 */
	@NonNull UniqueCollectionValue minus(@NonNull UniqueCollectionValue set);

	/**
	 * @generated NOT
	 */
	@NonNull UniqueCollectionValue symmetricDifference(@NonNull UniqueCollectionValue set);
} // UniqueCollectionValue
