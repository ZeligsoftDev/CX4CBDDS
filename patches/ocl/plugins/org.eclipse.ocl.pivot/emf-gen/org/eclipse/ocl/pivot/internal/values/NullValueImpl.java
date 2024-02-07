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
package org.eclipse.ocl.pivot.internal.values;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.OclVoidTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.OCLValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Null Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated not
 */
public class NullValueImpl extends UndefinedValueImpl implements NullValue
{
	private static final long serialVersionUID = 1L;

	/**
	 * The number of structural features of the '<em>Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE_FEATURE_COUNT = ObjectValueImpl.OBJECT_VALUE_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.NULL_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NullValueImpl() {
		super(null);
	}

	@Override
	public List<Object> asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		return null;
	}

	@Override
	public Element asElement() {
		return null;
	}

	@Override
	public List<Object> asUnboxedObject(@NonNull IdResolver idResolver) {
		return null;
	}

	@Override
	public @NonNull LiteralExp createLiteralExp() {
		return PivotFactory.eINSTANCE.createNullLiteralExp();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NullValueImpl;
	}

	public @NonNull Type getType(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getOclInvalidType();
	}

	@Override
	public @NonNull OclVoidTypeId getTypeId() {
		return TypeId.OCL_VOID;
	}

	@Override
	public int hashCode() {
		return 0x33333337;
	}

	@Override
	public int intValue() {
    	toInvalidValue();		// throws rather than returns
    	return 0;
	}

	@Override
	public boolean isInvalid() {
		return false;
	}

	@Override
	public boolean oclEquals(@NonNull OCLValue thatValue) {
		return equals(thatValue);
	}

	@Override
	public int oclHashCode() {
		return hashCode();
	}

	@Override
	public String toString() {
		return "null";
	}
} //NullValueImpl
