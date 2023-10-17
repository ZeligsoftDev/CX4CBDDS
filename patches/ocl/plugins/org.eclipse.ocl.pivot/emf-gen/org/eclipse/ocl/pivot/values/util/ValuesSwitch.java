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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.pivot.values.ValuesPackage
 * @generated
 */
public class ValuesSwitch<@Nullable T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValuesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuesSwitch() {
		if (modelPackage == null) {
			modelPackage = ValuesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case 0: {
				BagValue bagValue = (BagValue)theEObject;
				T1 result = caseBagValue(bagValue);
				if (result == null) result = caseCollectionValue(bagValue);
				if (result == null) result = caseIterableValue(bagValue);
				if (result == null) result = caseValue(bagValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				CollectionValue collectionValue = (CollectionValue)theEObject;
				T1 result = caseCollectionValue(collectionValue);
				if (result == null) result = caseIterableValue(collectionValue);
				if (result == null) result = caseValue(collectionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				ComparableValue<?> comparableValue = (ComparableValue<?>)theEObject;
				T1 result = caseComparableValue(comparableValue);
				if (result == null) result = caseValue(comparableValue);
				if (result == null) result = caseOCLValue(comparableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				IntegerValue integerValue = (IntegerValue)theEObject;
				T1 result = caseIntegerValue(integerValue);
				if (result == null) result = caseRealValue(integerValue);
				if (result == null) result = caseNumberValue(integerValue);
				if (result == null) result = caseComparableValue(integerValue);
				if (result == null) result = caseValue(integerValue);
				if (result == null) result = caseOCLValue(integerValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				InvalidValue invalidValue = (InvalidValue)theEObject;
				T1 result = caseInvalidValue(invalidValue);
				if (result == null) result = caseNullValue(invalidValue);
				if (result == null) result = caseObjectValue(invalidValue);
				if (result == null) result = caseIntegerValue(invalidValue);
				if (result == null) result = caseUnlimitedValue(invalidValue);
				if (result == null) result = caseBagValue(invalidValue);
				if (result == null) result = caseOrderedSetValue(invalidValue);
				if (result == null) result = caseSequenceValue(invalidValue);
				if (result == null) result = caseSetValue(invalidValue);
				if (result == null) result = caseTupleValue(invalidValue);
				if (result == null) result = caseRealValue(invalidValue);
				if (result == null) result = caseUnlimitedNaturalValue(invalidValue);
				if (result == null) result = caseOrderedCollectionValue(invalidValue);
				if (result == null) result = caseUniqueCollectionValue(invalidValue);
				if (result == null) result = caseNumberValue(invalidValue);
				if (result == null) result = caseCollectionValue(invalidValue);
				if (result == null) result = caseIterableValue(invalidValue);
				if (result == null) result = caseComparableValue(invalidValue);
				if (result == null) result = caseValue(invalidValue);
				if (result == null) result = caseOCLValue(invalidValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				IterableValue iterableValue = (IterableValue)theEObject;
				T1 result = caseIterableValue(iterableValue);
				if (result == null) result = caseValue(iterableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				MapValue mapValue = (MapValue)theEObject;
				T1 result = caseMapValue(mapValue);
				if (result == null) result = caseIterableValue(mapValue);
				if (result == null) result = caseValue(mapValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				NullValue nullValue = (NullValue)theEObject;
				T1 result = caseNullValue(nullValue);
				if (result == null) result = caseObjectValue(nullValue);
				if (result == null) result = caseIntegerValue(nullValue);
				if (result == null) result = caseUnlimitedValue(nullValue);
				if (result == null) result = caseBagValue(nullValue);
				if (result == null) result = caseOrderedSetValue(nullValue);
				if (result == null) result = caseSequenceValue(nullValue);
				if (result == null) result = caseSetValue(nullValue);
				if (result == null) result = caseTupleValue(nullValue);
				if (result == null) result = caseRealValue(nullValue);
				if (result == null) result = caseUnlimitedNaturalValue(nullValue);
				if (result == null) result = caseOrderedCollectionValue(nullValue);
				if (result == null) result = caseUniqueCollectionValue(nullValue);
				if (result == null) result = caseNumberValue(nullValue);
				if (result == null) result = caseCollectionValue(nullValue);
				if (result == null) result = caseIterableValue(nullValue);
				if (result == null) result = caseComparableValue(nullValue);
				if (result == null) result = caseValue(nullValue);
				if (result == null) result = caseOCLValue(nullValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				NumberValue numberValue = (NumberValue)theEObject;
				T1 result = caseNumberValue(numberValue);
				if (result == null) result = caseComparableValue(numberValue);
				if (result == null) result = caseValue(numberValue);
				if (result == null) result = caseOCLValue(numberValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				OCLValue oclValue = (OCLValue)theEObject;
				T1 result = caseOCLValue(oclValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10: {
				ObjectValue objectValue = (ObjectValue)theEObject;
				T1 result = caseObjectValue(objectValue);
				if (result == null) result = caseValue(objectValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11: {
				OrderedCollectionValue orderedCollectionValue = (OrderedCollectionValue)theEObject;
				T1 result = caseOrderedCollectionValue(orderedCollectionValue);
				if (result == null) result = caseCollectionValue(orderedCollectionValue);
				if (result == null) result = caseIterableValue(orderedCollectionValue);
				if (result == null) result = caseValue(orderedCollectionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12: {
				OrderedSetValue orderedSetValue = (OrderedSetValue)theEObject;
				T1 result = caseOrderedSetValue(orderedSetValue);
				if (result == null) result = caseOrderedCollectionValue(orderedSetValue);
				if (result == null) result = caseUniqueCollectionValue(orderedSetValue);
				if (result == null) result = caseCollectionValue(orderedSetValue);
				if (result == null) result = caseIterableValue(orderedSetValue);
				if (result == null) result = caseValue(orderedSetValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13: {
				RealValue realValue = (RealValue)theEObject;
				T1 result = caseRealValue(realValue);
				if (result == null) result = caseNumberValue(realValue);
				if (result == null) result = caseComparableValue(realValue);
				if (result == null) result = caseValue(realValue);
				if (result == null) result = caseOCLValue(realValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14: {
				SequenceValue sequenceValue = (SequenceValue)theEObject;
				T1 result = caseSequenceValue(sequenceValue);
				if (result == null) result = caseOrderedCollectionValue(sequenceValue);
				if (result == null) result = caseCollectionValue(sequenceValue);
				if (result == null) result = caseIterableValue(sequenceValue);
				if (result == null) result = caseValue(sequenceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 15: {
				SetValue setValue = (SetValue)theEObject;
				T1 result = caseSetValue(setValue);
				if (result == null) result = caseUniqueCollectionValue(setValue);
				if (result == null) result = caseCollectionValue(setValue);
				if (result == null) result = caseIterableValue(setValue);
				if (result == null) result = caseValue(setValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 16: {
				TupleValue tupleValue = (TupleValue)theEObject;
				T1 result = caseTupleValue(tupleValue);
				if (result == null) result = caseValue(tupleValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 17: {
				UniqueCollectionValue uniqueCollectionValue = (UniqueCollectionValue)theEObject;
				T1 result = caseUniqueCollectionValue(uniqueCollectionValue);
				if (result == null) result = caseCollectionValue(uniqueCollectionValue);
				if (result == null) result = caseIterableValue(uniqueCollectionValue);
				if (result == null) result = caseValue(uniqueCollectionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 18: {
				UnlimitedNaturalValue unlimitedNaturalValue = (UnlimitedNaturalValue)theEObject;
				T1 result = caseUnlimitedNaturalValue(unlimitedNaturalValue);
				if (result == null) result = caseNumberValue(unlimitedNaturalValue);
				if (result == null) result = caseComparableValue(unlimitedNaturalValue);
				if (result == null) result = caseValue(unlimitedNaturalValue);
				if (result == null) result = caseOCLValue(unlimitedNaturalValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 19: {
				UnlimitedValue unlimitedValue = (UnlimitedValue)theEObject;
				T1 result = caseUnlimitedValue(unlimitedValue);
				if (result == null) result = caseUnlimitedNaturalValue(unlimitedValue);
				if (result == null) result = caseNumberValue(unlimitedValue);
				if (result == null) result = caseComparableValue(unlimitedValue);
				if (result == null) result = caseValue(unlimitedValue);
				if (result == null) result = caseOCLValue(unlimitedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 20: {
				Value value = (Value)theEObject;
				T1 result = caseValue(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBagValue(BagValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCollectionValue(CollectionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparableValue(ComparableValue<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntegerValue(IntegerValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInvalidValue(InvalidValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIterableValue(IterableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMapValue(MapValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNullValue(NullValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNumberValue(NumberValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOCLValue(OCLValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseObjectValue(ObjectValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Collection Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Collection Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrderedCollectionValue(OrderedCollectionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOrderedSetValue(OrderedSetValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRealValue(RealValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSequenceValue(SequenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSetValue(SetValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTupleValue(TupleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Collection Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Collection Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUniqueCollectionValue(UniqueCollectionValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnlimitedNaturalValue(UnlimitedNaturalValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnlimitedValue(UnlimitedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //ValuesSwitch
