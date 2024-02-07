/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.ocl.pivot.values;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.values.ValuesFactory
 * @generated
 */
public interface ValuesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "values";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2015/Values";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "values";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValuesPackage eINSTANCE = org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.BagValue <em>Bag Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.BagValue
	 * @generated
	 */
	EClass getBagValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.CollectionValue <em>Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.CollectionValue
	 * @generated
	 */
	EClass getCollectionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.ComparableValue <em>Comparable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparable Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.ComparableValue
	 * @generated
	 */
	EClass getComparableValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.InvalidValue <em>Invalid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.InvalidValue
	 * @generated
	 */
	EClass getInvalidValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.IterableValue <em>Iterable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterable Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.IterableValue
	 * @generated
	 */
	EClass getIterableValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.MapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.MapValue
	 * @generated
	 */
	EClass getMapValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.NullValue
	 * @generated
	 */
	EClass getNullValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.NumberValue <em>Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.NumberValue
	 * @generated
	 */
	EClass getNumberValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.OCLValue <em>OCL Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.OCLValue
	 * @generated
	 */
	EClass getOCLValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.ObjectValue <em>Object Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.ObjectValue
	 * @generated
	 */
	EClass getObjectValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.OrderedCollectionValue <em>Ordered Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Collection Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.OrderedCollectionValue
	 * @generated
	 */
	EClass getOrderedCollectionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.OrderedSetValue <em>Ordered Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.OrderedSetValue
	 * @generated
	 */
	EClass getOrderedSetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.RealValue
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.SequenceValue <em>Sequence Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.SequenceValue
	 * @generated
	 */
	EClass getSequenceValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.SetValue <em>Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.SetValue
	 * @generated
	 */
	EClass getSetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.TupleValue <em>Tuple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.TupleValue
	 * @generated
	 */
	EClass getTupleValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.UniqueCollectionValue <em>Unique Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Collection Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.UniqueCollectionValue
	 * @generated
	 */
	EClass getUniqueCollectionValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.UnlimitedNaturalValue <em>Unlimited Natural Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.UnlimitedNaturalValue
	 * @generated
	 */
	EClass getUnlimitedNaturalValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.UnlimitedValue <em>Unlimited Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.UnlimitedValue
	 * @generated
	 */
	EClass getUnlimitedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.values.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.eclipse.ocl.pivot.values.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ValuesFactory getValuesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.BagValueImpl <em>Bag Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.BagValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getBagValue()
		 * @generated
		 */
		EClass BAG_VALUE = eINSTANCE.getBagValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.CollectionValueImpl <em>Collection Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.CollectionValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getCollectionValue()
		 * @generated
		 */
		EClass COLLECTION_VALUE = eINSTANCE.getCollectionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.ComparableValue <em>Comparable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.ComparableValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getComparableValue()
		 * @generated
		 */
		EClass COMPARABLE_VALUE = eINSTANCE.getComparableValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.IntegerValueImpl <em>Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.IntegerValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getIntegerValue()
		 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.InvalidValue <em>Invalid Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.InvalidValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getInvalidValue()
		 * @generated
		 */
		EClass INVALID_VALUE = eINSTANCE.getInvalidValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.IterableValue <em>Iterable Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.IterableValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getIterableValue()
		 * @generated
		 */
		EClass ITERABLE_VALUE = eINSTANCE.getIterableValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.MapValueImpl <em>Map Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.MapValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getMapValue()
		 * @generated
		 */
		EClass MAP_VALUE = eINSTANCE.getMapValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.NullValueImpl <em>Null Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.NullValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getNullValue()
		 * @generated
		 */
		EClass NULL_VALUE = eINSTANCE.getNullValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.NumberValueImpl <em>Number Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.NumberValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getNumberValue()
		 * @generated
		 */
		EClass NUMBER_VALUE = eINSTANCE.getNumberValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.OCLValue <em>OCL Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.OCLValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getOCLValue()
		 * @generated
		 */
		EClass OCL_VALUE = eINSTANCE.getOCLValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.ObjectValueImpl <em>Object Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.ObjectValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getObjectValue()
		 * @generated
		 */
		EClass OBJECT_VALUE = eINSTANCE.getObjectValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.OrderedCollectionValue <em>Ordered Collection Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.OrderedCollectionValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getOrderedCollectionValue()
		 * @generated
		 */
		EClass ORDERED_COLLECTION_VALUE = eINSTANCE.getOrderedCollectionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.OrderedSetValueImpl <em>Ordered Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.OrderedSetValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getOrderedSetValue()
		 * @generated
		 */
		EClass ORDERED_SET_VALUE = eINSTANCE.getOrderedSetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.RealValueImpl <em>Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.RealValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getRealValue()
		 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.SequenceValueImpl <em>Sequence Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.SequenceValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getSequenceValue()
		 * @generated
		 */
		EClass SEQUENCE_VALUE = eINSTANCE.getSequenceValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.SetValueImpl <em>Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.SetValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getSetValue()
		 * @generated
		 */
		EClass SET_VALUE = eINSTANCE.getSetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.TupleValueImpl <em>Tuple Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.TupleValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getTupleValue()
		 * @generated
		 */
		EClass TUPLE_VALUE = eINSTANCE.getTupleValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.UniqueCollectionValue <em>Unique Collection Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.UniqueCollectionValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getUniqueCollectionValue()
		 * @generated
		 */
		EClass UNIQUE_COLLECTION_VALUE = eINSTANCE.getUniqueCollectionValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.values.UnlimitedNaturalValue <em>Unlimited Natural Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.values.UnlimitedNaturalValue
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getUnlimitedNaturalValue()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_VALUE = eINSTANCE.getUnlimitedNaturalValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.UnlimitedValueImpl <em>Unlimited Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.UnlimitedValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getUnlimitedValue()
		 * @generated
		 */
		EClass UNLIMITED_VALUE = eINSTANCE.getUnlimitedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.internal.values.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.internal.values.ValueImpl
		 * @see org.eclipse.ocl.pivot.internal.values.ValuesPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

	}

} //ValuesPackage
