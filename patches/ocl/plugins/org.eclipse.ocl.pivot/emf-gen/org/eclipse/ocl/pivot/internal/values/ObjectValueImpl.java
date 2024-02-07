/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.values;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.values.ObjectValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ObjectValueImpl extends ValueImpl implements ObjectValue {
	/**
	 * The number of structural features of the '<em>Object Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE_FEATURE_COUNT = ValueImpl.VALUE_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.OBJECT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectValueImpl() {
		super();
	}

	@Override
	public @NonNull Object asObject() {
		return getObject();
	}

	@Override
	public @NonNull ObjectValue asObjectValue() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ObjectValue)) {
			return false;
		}
		return getObject().equals(((ObjectValue)obj).getObject());
	}

	@Override
	public abstract @NonNull Object getObject();

	@Override
	public int hashCode() {
		return getObject().hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(getObject());
	}
} //ObjectValueImpl
