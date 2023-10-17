/*******************************************************************************
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ValueSpecification;
import org.eclipse.ocl.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ValueSpecificationImpl
		extends TypedElementImpl
		implements ValueSpecification {

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_SPECIFICATION_FEATURE_COUNT = TypedElementImpl.TYPED_ELEMENT_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_SPECIFICATION_OPERATION_COUNT = TypedElementImpl.TYPED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.VALUE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isComputable() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!isComputable()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number integerValue() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!integerValue()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean booleanValue() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!booleanValue()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String stringValue() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!stringValue()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number unlimitedValue() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!unlimitedValue()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNull() {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/ocl/2015/Pivot!ValueSpecification!isNull()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case 0:
				return allOwnedElements();
			case 1:
				return getValue((Type)arguments.get(0), (String)arguments.get(1));
			case 2:
				return CompatibleBody((ValueSpecification)arguments.get(0));
			case 3:
				return booleanValue();
			case 4:
				return integerValue();
			case 5:
				return isComputable();
			case 6:
				return isNull();
			case 7:
				return stringValue();
			case 8:
				return unlimitedValue();
		}
		return eDynamicInvoke(operationID, arguments);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitValueSpecification(this);
	}
} //ValueSpecificationImpl
