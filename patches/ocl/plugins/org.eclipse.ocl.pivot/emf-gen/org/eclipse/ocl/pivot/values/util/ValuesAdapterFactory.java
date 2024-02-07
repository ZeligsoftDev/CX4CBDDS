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
package org.eclipse.ocl.pivot.values.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.ComparableValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValue;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.OCLValue;
import org.eclipse.ocl.pivot.values.ObjectValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.UnlimitedValue;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.values.ValuesPackage
 * @generated
 */
public class ValuesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValuesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ValuesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuesSwitch<@Nullable Adapter> modelSwitch =
		new ValuesSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseBagValue(BagValue object) {
				return createBagValueAdapter();
			}
			@Override
			public Adapter caseCollectionValue(CollectionValue object) {
				return createCollectionValueAdapter();
			}
			@Override
			public <T> Adapter caseComparableValue(ComparableValue<T> object) {
				return createComparableValueAdapter();
			}
			@Override
			public Adapter caseIntegerValue(IntegerValue object) {
				return createIntegerValueAdapter();
			}
			@Override
			public Adapter caseInvalidValue(InvalidValue object) {
				return createInvalidValueAdapter();
			}
			@Override
			public Adapter caseIterableValue(IterableValue object) {
				return createIterableValueAdapter();
			}
			@Override
			public Adapter caseMapValue(MapValue object) {
				return createMapValueAdapter();
			}
			@Override
			public Adapter caseNullValue(NullValue object) {
				return createNullValueAdapter();
			}
			@Override
			public Adapter caseNumberValue(NumberValue object) {
				return createNumberValueAdapter();
			}
			@Override
			public Adapter caseOCLValue(OCLValue object) {
				return createOCLValueAdapter();
			}
			@Override
			public Adapter caseObjectValue(ObjectValue object) {
				return createObjectValueAdapter();
			}
			@Override
			public Adapter caseOrderedCollectionValue(OrderedCollectionValue object) {
				return createOrderedCollectionValueAdapter();
			}
			@Override
			public Adapter caseOrderedSetValue(OrderedSetValue object) {
				return createOrderedSetValueAdapter();
			}
			@Override
			public Adapter caseRealValue(RealValue object) {
				return createRealValueAdapter();
			}
			@Override
			public Adapter caseSequenceValue(SequenceValue object) {
				return createSequenceValueAdapter();
			}
			@Override
			public Adapter caseSetValue(SetValue object) {
				return createSetValueAdapter();
			}
			@Override
			public Adapter caseTupleValue(TupleValue object) {
				return createTupleValueAdapter();
			}
			@Override
			public Adapter caseUniqueCollectionValue(UniqueCollectionValue object) {
				return createUniqueCollectionValueAdapter();
			}
			@Override
			public Adapter caseUnlimitedNaturalValue(UnlimitedNaturalValue object) {
				return createUnlimitedNaturalValueAdapter();
			}
			@Override
			public Adapter caseUnlimitedValue(UnlimitedValue object) {
				return createUnlimitedValueAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.BagValue <em>Bag Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.BagValue
	 * @generated
	 */
	public Adapter createBagValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.CollectionValue <em>Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.CollectionValue
	 * @generated
	 */
	public Adapter createCollectionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.ComparableValue <em>Comparable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.ComparableValue
	 * @generated
	 */
	public Adapter createComparableValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.IntegerValue
	 * @generated
	 */
	public Adapter createIntegerValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.InvalidValue <em>Invalid Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.InvalidValue
	 * @generated
	 */
	public Adapter createInvalidValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.IterableValue <em>Iterable Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.IterableValue
	 * @generated
	 */
	public Adapter createIterableValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.MapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.MapValue
	 * @generated
	 */
	public Adapter createMapValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.NullValue
	 * @generated
	 */
	public Adapter createNullValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.NumberValue <em>Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.NumberValue
	 * @generated
	 */
	public Adapter createNumberValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.OCLValue <em>OCL Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.OCLValue
	 * @generated
	 */
	public Adapter createOCLValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.ObjectValue <em>Object Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.ObjectValue
	 * @generated
	 */
	public Adapter createObjectValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.OrderedCollectionValue <em>Ordered Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.OrderedCollectionValue
	 * @generated
	 */
	public Adapter createOrderedCollectionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.OrderedSetValue <em>Ordered Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.OrderedSetValue
	 * @generated
	 */
	public Adapter createOrderedSetValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.RealValue
	 * @generated
	 */
	public Adapter createRealValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.SequenceValue <em>Sequence Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.SequenceValue
	 * @generated
	 */
	public Adapter createSequenceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.SetValue <em>Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.SetValue
	 * @generated
	 */
	public Adapter createSetValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.TupleValue <em>Tuple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.TupleValue
	 * @generated
	 */
	public Adapter createTupleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.UniqueCollectionValue <em>Unique Collection Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.UniqueCollectionValue
	 * @generated
	 */
	public Adapter createUniqueCollectionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.UnlimitedNaturalValue <em>Unlimited Natural Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.UnlimitedNaturalValue
	 * @generated
	 */
	public Adapter createUnlimitedNaturalValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.UnlimitedValue <em>Unlimited Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.UnlimitedValue
	 * @generated
	 */
	public Adapter createUnlimitedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.values.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.values.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ValuesAdapterFactory
