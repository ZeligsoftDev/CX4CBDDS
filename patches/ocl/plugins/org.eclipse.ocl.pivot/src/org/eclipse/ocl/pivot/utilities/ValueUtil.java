/*******************************************************************************
 * Copyright (c) 2012, 2021 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ElementExtension;
import org.eclipse.ocl.pivot.ElementLiteralExp;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Stereotype;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.ModelManager;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.MapTypeId;
import org.eclipse.ocl.pivot.ids.TemplateableId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal.EnvironmentFactoryInternalExtension;
import org.eclipse.ocl.pivot.internal.values.BagImpl;
import org.eclipse.ocl.pivot.internal.values.BagValueImpl;
import org.eclipse.ocl.pivot.internal.values.BigIntegerValueImpl;
import org.eclipse.ocl.pivot.internal.values.CollectionValueImpl;
import org.eclipse.ocl.pivot.internal.values.IntIntegerValueImpl;
import org.eclipse.ocl.pivot.internal.values.IntegerRangeImpl;
import org.eclipse.ocl.pivot.internal.values.JavaObjectValueImpl;
import org.eclipse.ocl.pivot.internal.values.LongIntegerValueImpl;
import org.eclipse.ocl.pivot.internal.values.MapEntryImpl;
import org.eclipse.ocl.pivot.internal.values.MapValueImpl;
import org.eclipse.ocl.pivot.internal.values.NullValueImpl;
import org.eclipse.ocl.pivot.internal.values.OrderedSetImpl;
import org.eclipse.ocl.pivot.internal.values.RangeSequenceValueImpl;
import org.eclipse.ocl.pivot.internal.values.RealValueImpl;
import org.eclipse.ocl.pivot.internal.values.SetValueImpl;
import org.eclipse.ocl.pivot.internal.values.SparseOrderedSetValueImpl;
import org.eclipse.ocl.pivot.internal.values.SparseSequenceValueImpl;
import org.eclipse.ocl.pivot.internal.values.TupleValueImpl;
import org.eclipse.ocl.pivot.internal.values.UnlimitedValueImpl;
import org.eclipse.ocl.pivot.library.UnsupportedOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.types.AbstractInheritance;
import org.eclipse.ocl.pivot.types.ParameterTypesImpl;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.ocl.pivot.values.Bag;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerRange;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.IterableValue;
import org.eclipse.ocl.pivot.values.MapEntry;
import org.eclipse.ocl.pivot.values.MapValue;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.ObjectValue;
import org.eclipse.ocl.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.ocl.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.UnlimitedValue;
import org.eclipse.ocl.pivot.values.Value;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * @since 1.1
 */
public abstract class ValueUtil
{
	private static final @NonNull String METAMODEL_NAME_PREFIX = PivotConstants.METAMODEL_NAME + "::";

	public static final @NonNull String NULL_STRING = "null";

	private static final int NEGATIVE_INTEGERS = 256;
	private static final int POSITIVE_INTEGERS = 1025;
	private static final @Nullable IntegerValue @NonNull [] INTEGER_VALUES = new @Nullable IntegerValue[NEGATIVE_INTEGERS + POSITIVE_INTEGERS];

	public static @NonNull Bag<?> EMPTY_BAG = new BagImpl<Object>();
	public static final @NonNull Set<Object> EMPTY_SET = Collections.emptySet();

	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger INTEGER_MIN_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	@SuppressWarnings("null")
	public static final @NonNull BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();

	public static final @NonNull Boolean FALSE_VALUE = Boolean.FALSE;
	public static final @NonNull InvalidValueException INVALID_VALUE = new InvalidValueException("invalid");
	public static final @NonNull NullValue NULL_VALUE = new NullValueImpl();
	public static final @NonNull IntegerValue ONE_VALUE = integerValueOf(1);
	public static final @NonNull Boolean TRUE_VALUE = Boolean.TRUE;
	public static final @NonNull IntegerValue ZERO_VALUE = integerValueOf(0);

	public static final @NonNull UnlimitedNaturalValue UNLIMITED_ONE_VALUE = (UnlimitedNaturalValue)ONE_VALUE;
	public static final @NonNull UnlimitedValue UNLIMITED_VALUE = new UnlimitedValueImpl();
	/**
	 * @since 1.18
	 */
	public static final @NonNull UnlimitedNaturalValue UNLIMITED_ZERO_VALUE = (UnlimitedNaturalValue)ZERO_VALUE;

	private static boolean allStaticsInitialized = false;

	public static @NonNull BagValue asBagValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asBagValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BAG_NAME, getTypeName(value));
		}
	}

	public static @NonNull Boolean asBoolean(@Nullable Object value) {
		if (value == Boolean.TRUE) {
			return TRUE_VALUE;
		}
		else if (value == Boolean.FALSE) {
			return FALSE_VALUE;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.BOOLEAN_NAME, getTypeName(value));
		}
	}

	public static org.eclipse.ocl.pivot.@NonNull Class asClass(@Nullable Object value) {
		if (value instanceof org.eclipse.ocl.pivot.Class) {
			return (org.eclipse.ocl.pivot.Class)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "Class", getTypeName(value));
		}
	}

	public static @NonNull CollectionType asCollectionType(@Nullable Object value) {
		if (value instanceof CollectionType) {
			return (CollectionType)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.COLLECTION_TYPE_NAME, getTypeName(value));
		}
	}

	public static @NonNull CollectionValue asCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asCollectionValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.COLLECTION_NAME, getTypeName(value));
		}
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull ElementExtension asElementExtension(@Nullable Object value) {
		if (value instanceof ElementExtension) {
			return (ElementExtension)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "ElementExtension", getTypeName(value));
		}
	}

	public static @NonNull Integer asInteger(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asInteger();
		}
		else if (value instanceof Number) {
			return ((Number)value).intValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	public static @NonNull IntegerValue asIntegerValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asIntegerValue();
		}
		else if (value instanceof Number) {
			if (value instanceof BigInteger) {
				return integerValueOf((BigInteger)value);
			}
			else {
				return integerValueOf(((Number)value).longValue());
			}
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.INTEGER_NAME, getTypeName(value));
		}
	}

	/**
	 * @since 1.6
	 */
	public static @NonNull IterableValue asIterableValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asIterableValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ITERABLE_NAME, getTypeName(value));
		}
	}

	public static @NonNull MapType asMapType(@Nullable Object value) {
		if (value instanceof MapType) {
			return (MapType)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.MAP_TYPE_NAME, getTypeName(value));
		}
	}

	public static @NonNull MapValue asMapValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asMapValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.MAP_NAME, getTypeName(value));
		}
	}

	/** @deprecated use Executor */
	@Deprecated
	public static @NonNull EObject asNavigableObject(@Nullable Object value, @NonNull Object navigation, @Nullable Evaluator evaluator) {
		return asNavigableObject(value, navigation, evaluator != null ? getExecutor(evaluator) : null);
	}

	/**
	 * @since 1.1
	 */
	public static @NonNull EObject asNavigableObject(@Nullable Object value, @NonNull Object navigation, @Nullable Executor executor) {

		if (value instanceof Value) {
			return ((Value)value).asNavigableObject();
		}
		else if (value instanceof EObject) {
			return (EObject)value;
		}
		else if (value == null) {
			if (navigation instanceof ElementId) {
				throw new InvalidValueException(PivotMessages.NullNavigation, "source", getElementIdName((ElementId)navigation));
			}
			else {
				String qualifiedName = NameUtil.qualifiedNameFor(navigation);
				int index = qualifiedName.indexOf("::");
				if (index > 0) {
					qualifiedName = qualifiedName.substring(index+2);	// Strip metamodel name to match CG naming
				}
				throw new InvalidValueException(PivotMessages.NullNavigation, "source", qualifiedName/*).replace("'", "''")*/);
			}
		}
		else if ((executor != null) && (value instanceof ElementId)) {
			Object unboxedValue = executor.getIdResolver().unboxedValueOf(value);		// Primarily to unbox and so allow navigation of UML EnumerationLiterals
			if (unboxedValue instanceof EObject) {
				return (EObject) unboxedValue;
			}
		}
		throw new InvalidValueException(PivotMessages.TypedValueRequired, "NavigableObject", getTypeName(value));
	}

	public static @Nullable Object asObject(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asObject();
		}
		else {
			return value;
		}
	}

	public static @NonNull OrderedCollectionValue asOrderedCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asOrderedCollectionValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ORDERED_COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull OrderedSetValue asOrderedSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asOrderedSetValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.ORDERED_SET_NAME, getTypeName(value));
		}
	}

	public static @NonNull RealValue asRealValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asRealValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.REAL_NAME, getTypeName(value));
		}
	}

	public static @NonNull SequenceValue asSequenceValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSequenceValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.SEQUENCE_NAME, getTypeName(value));
		}
	}

	public static @NonNull SetValue asSetValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asSetValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.SET_NAME, getTypeName(value));
		}
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull Stereotype asStereotype(@Nullable Object value) {
		if (value instanceof Stereotype) {
			return (Stereotype)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.STEREOTYPE_NAME, getTypeName(value));
		}
	}

	public static @NonNull String asString(@Nullable Object value) {
		if (value instanceof String) {
			return (String)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.STRING_NAME, getTypeName(value));
		}
	}

	public static @NonNull TupleValue asTupleValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asTupleValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.TUPLE_NAME, getTypeName(value));
		}
	}

	public static @NonNull Type asType(@Nullable Object value) {
		if (value instanceof Type) {
			return (Type)value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, "Type", getTypeName(value));
		}
	}

	public static @NonNull UniqueCollectionValue asUniqueCollectionValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUniqueCollectionValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.UNIQUE_COLLECTION_NAME, getTypeName(value));
		}
	}

	public static @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue(@Nullable Object value) {
		if (value instanceof Value) {
			return ((Value)value).asUnlimitedNaturalValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.UNLIMITED_NATURAL_NAME, getTypeName(value));
		}
	}

	public static Object asValue(Object value) {
		if (value != null) {
			return value;
		}
		else {
			throw new InvalidValueException(PivotMessages.TypedValueRequired, TypeId.OCL_ANY_NAME, getTypeName(value));
		}
	}

	@SuppressWarnings("null")
	public static @NonNull BigDecimal bigDecimalValueOf(@NonNull Object anObject) {
		if (anObject instanceof BigDecimal) {
			return (BigDecimal)anObject;
		}
		//		else if (anObject instanceof Unlimited) {
		//			return BigDecimal.valueOf(Double.POSITIVE_INFINITY);
		//		}
		else if (anObject instanceof Number) {
			return BigDecimal.valueOf(((Number)anObject).doubleValue());
		}
		else if (anObject instanceof Character) {
			return BigDecimal.valueOf(((Character)anObject).charValue());
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidReal, anObject);
		}
	}

	@SuppressWarnings("null")
	public static @NonNull BigInteger bigIntegerValueOf(@NonNull Object anObject) {
		if (anObject instanceof BigInteger) {
			return (BigInteger)anObject;
		}
		//		else if (anObject instanceof Unlimited) {
		//			return UNLIMITED_VALUE;
		//		}
		else if (anObject instanceof Number) {
			return BigInteger.valueOf(((Number)anObject).longValue());
		}
		else if (anObject instanceof Character) {
			return BigInteger.valueOf(((Character)anObject).charValue());
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	/**
	 * @since 1.1
	 */
	public static byte byteValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).byteValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	/**
	 * @since 1.14
	 */
	public static char charValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return (char)((Number)anObject).intValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	@SuppressWarnings("null")
	public static @NonNull Character characterValueOf(@NonNull Object anObject) {
		if (anObject instanceof Character) {
			return (Character)anObject;
		}
		//		else if (anObject instanceof Unlimited) {
		//			return UNLIMITED_VALUE;
		//		}
		else if (anObject instanceof Number) {
			return Character.valueOf((char)((Number)anObject).longValue());
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidCharacter, anObject);
		}
	}

	/**
	 * @since 1.1
	 */
	public static int computeCollectionHashCode(boolean isOrdered, boolean isUnique, @NonNull Iterable<?> elements) {
		long hash = isUnique ? 0x5555555555555555L : 0x7777777777777777L;
		if (isOrdered) {
			for (Object element : elements) {
				hash *= 5;
				if (element != null) {
					hash += element.hashCode();
				}
			}
		}
		else {
			for (Object element : elements) {
				if (element != null) {
					hash += element.hashCode();
				}
			}
		}
		int hashCode = (int) hash;
		if (hashCode == 0) {
			hashCode = (int) (hash >> 32);
			if (hashCode == 0) {
				hashCode = 0x98765432;
			}
		}
		return hashCode;
	}

	public static BagValue.@NonNull Accumulator createBagAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new BagValueImpl.Accumulator(collectedId);
	}

	public static @NonNull BagValue createBagOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... boxedValues) {
		return new BagValueImpl(typeId, BagValueImpl.createBagOfEach(boxedValues));
	}

	public static @NonNull BagValue createBagRange(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... values) {
		Bag<Object> allValues = new BagImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new BagValueImpl(typeId, allValues);
	}

	public static @NonNull BagValue createBagValue(@NonNull CollectionTypeId typeId, @NonNull Bag<? extends Object> boxedValues) {
		return new BagValueImpl(typeId, boxedValues);
	}

	public static CollectionValue.@NonNull Accumulator createCollectionAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		CollectionTypeId collectionId = collectedId.getGeneralizedId();
		if (collectionId == TypeId.BAG) {
			return new BagValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.ORDERED_SET) {
			return new SparseOrderedSetValueImpl.Accumulator(collectedId);
		}
		else if (collectionId == TypeId.SEQUENCE) {
			return new SparseSequenceValueImpl.Accumulator(collectedId);
		}
		else /*if (collectionId == TypeId.SET)*/ {
			return new SetValueImpl.Accumulator(collectedId);
		}
	}

	/**
	 * @since 1.5
	 */
	public static @NonNull InvalidValueException createInvalidValue(@NonNull Throwable e) {
		if (e instanceof InvalidValueException) {
			return (InvalidValueException)e;
		}
		else {
			return new InvalidValueException(e);
		}
	}
	public static @NonNull InvalidValueException createInvalidValue(@NonNull Exception e) {	// FIXME REmove obsolete signature
		if (e instanceof InvalidValueException) {
			return (InvalidValueException)e;
		}
		else {
			return new InvalidValueException(e);
		}
	}

	/**
	 * Return a LiteralExp whose evaluation is a value.
	 *
	 * @since 1.18
	 */
	public static @NonNull OCLExpression createLiteralExp(Object value) {	// FIXME TypeExp / ShadowExp are not LiteralExp
		if (value == null) {
			return PivotFactory.eINSTANCE.createNullLiteralExp();
		}
		else if (value instanceof Value) {
			return ((Value)value).createLiteralExp();
		}
		else if (value instanceof Boolean) {
			BooleanLiteralExp literalExp = PivotFactory.eINSTANCE.createBooleanLiteralExp();
			literalExp.setBooleanSymbol(((Boolean)value).booleanValue());
			return literalExp;
		}
		else if (value instanceof String) {
			StringLiteralExp literalExp = PivotFactory.eINSTANCE.createStringLiteralExp();
			literalExp.setStringSymbol((String)value);
			return literalExp;
		}
		else if (value instanceof EnumerationLiteral) {
			EnumLiteralExp literalExp = PivotFactory.eINSTANCE.createEnumLiteralExp();
			literalExp.setReferredLiteral((EnumerationLiteral)value);
			return literalExp;
		}
		else if (value instanceof Type) {
			TypeExp literalExp = PivotFactory.eINSTANCE.createTypeExp();		// TypeExp is not a LiteralExp
			literalExp.setReferredType((Type)value);
			return literalExp;
		}
		else if (value instanceof EObject) {
			EObject eObject = (EObject) value;
			if (eObject.eResource() != null) {
				ElementLiteralExp literalExp = PivotFactory.eINSTANCE.createElementLiteralExp();
				literalExp.setReferredElement(eObject);
				return literalExp;
			}
			else {
				throw new UnsupportedOperationException("Missing createShadowExp support in ValueUtil.createLiteralExp");	// TODO FIXME
			}
		}
		else {
			InvalidLiteralExp literalExp = PivotFactory.eINSTANCE.createInvalidLiteralExp();
			literalExp.setName("Unsupported createLiteralExp for " + value.getClass().getSimpleName());
			return literalExp;
		}
	}

	/**
	 * @since 1.6
	 */
	public static MapValue.@NonNull Accumulator createMapAccumulatorValue(@NonNull MapTypeId typeId) {
		return new MapValueImpl.Accumulator(typeId);
	}

	public static @NonNull MapValue createMapOfEach(@NonNull MapTypeId mapTypeId, @NonNull MapEntry @NonNull ... mapEntries) {
		return MapValueImpl.createMapValueOfEach(mapTypeId, mapEntries);
	}

	public static @NonNull MapEntry createMapEntry(@Nullable Object key, @Nullable Object value) {
		return new MapEntryImpl(key, value);
	}

	@Deprecated /* @deprecated not used */
	public static @NonNull MapValue createMapValue(@NonNull TypeId keyTypeId, @NonNull TypeId valueTypeId, @NonNull Map<Object, Object> boxedValues) {
	//	BindingsId bindingsId = IdManager.getBindingsId(keyTypeId, valueTypeId, false, false);
		return createMapValue(TypeId.MAP.getSpecializedId(keyTypeId, valueTypeId, false, false), boxedValues);
	}

	/**
	 * @since 1.18
	 */
	public static @NonNull MapValue createMapValue(@NonNull MapTypeId mapTypeId, @NonNull Map<Object, Object> boxedValues) {
		return new MapValueImpl(mapTypeId, boxedValues);
	}

	public static @NonNull ObjectValue createObjectValue(@NonNull TypeId typeId, @NonNull Object object) {
		return new JavaObjectValueImpl(typeId, object);
	}

	public static OrderedSetValue.@NonNull Accumulator createOrderedSetAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SparseOrderedSetValueImpl.Accumulator(collectedId);
	}

	//	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
	//		return new RangeOrderedSetValueImpl(typeId, range);
	//	}

	public static @NonNull OrderedSetValue createOrderedSetOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... boxedValues) {
		return new SparseOrderedSetValueImpl(typeId, SparseOrderedSetValueImpl.createOrderedSetOfEach(boxedValues));
	}

	public static @NonNull OrderedSetValue createOrderedSetRange(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... values) {
		OrderedSet<Object> allValues = new OrderedSetImpl<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseOrderedSetValueImpl(typeId, allValues);
	}

	public static @NonNull OrderedSetValue createOrderedSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> boxedValues) {
		return new SparseOrderedSetValueImpl(typeId, boxedValues);
	}

	public static @NonNull IntegerRange createRange(@NonNull IntegerValue firstInteger, @NonNull IntegerValue lastInteger) {
		return new IntegerRangeImpl(firstInteger, lastInteger);
	}

	public static SequenceValue.@NonNull Accumulator createSequenceAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SparseSequenceValueImpl.Accumulator(collectedId);
	}

	public static @NonNull SequenceValue createSequenceOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... boxedValues) {
		return new SparseSequenceValueImpl(typeId, SparseSequenceValueImpl.createSequenceOfEach(boxedValues));
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @NonNull IntegerRange range) {
		return new RangeSequenceValueImpl(typeId, range);
	}

	public static @NonNull SequenceValue createSequenceRange(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... values) {
		List<Object> allValues = new ArrayList<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SparseSequenceValueImpl(typeId, allValues);
	}

	public static @NonNull SequenceValue createSequenceValue(@NonNull CollectionTypeId typeId, @NonNull List<? extends Object> boxedValues) {
		return new SparseSequenceValueImpl(typeId, boxedValues);
	}

	public static SetValue.@NonNull Accumulator createSetAccumulatorValue(@NonNull CollectionTypeId collectedId) {
		return new SetValueImpl.Accumulator(collectedId);
	}

	/**
	 * @since 1.6
	 */
	public static SetValue.@NonNull Accumulator createSetAccumulatorValue(@NonNull MapTypeId mapId) {
		return new SetValueImpl.Accumulator(TypeId.SET.getSpecializedId(mapId.getKeyTypeId()));
	}

	public static @NonNull SetValue createSetOfEach(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... boxedValues) {
		return new SetValueImpl(typeId, SetValueImpl.createSetOfEach(boxedValues));
	}

	public static @NonNull SetValue createSetRange(@NonNull CollectionTypeId typeId, @Nullable Object @NonNull ... values) {
		Set<Object> allValues = new HashSet<Object>();
		for (Object value : values) {
			if (value instanceof IntegerRange) {
				allValues.addAll((IntegerRange)value);
			}
			else {
				allValues.add(value);
			}
		}
		return new SetValueImpl(typeId, allValues);
	}

	public static @NonNull SetValue createSetValue(@NonNull CollectionTypeId typeId, @NonNull Collection<? extends Object> boxedValues) {
		return new SetValueImpl(typeId, boxedValues);
	}

	public static @NonNull TupleValue createTupleValue(@NonNull TupleTypeId typeId, @NonNull Map<@NonNull ? extends TuplePartId, @Nullable Object> values) {
		return new TupleValueImpl(typeId, values);
	}

	public static @NonNull TupleValue createTupleOfEach(@NonNull TupleTypeId typeId, @Nullable Object... values) {
		return new TupleValueImpl(typeId, values);
	}

	/**
	 * @since 1.1
	 */
	public static double doubleValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).doubleValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidReal, anObject);
		}
	}

	/**
	 * @since 1.1
	 */
	public static float floatValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).floatValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidReal, anObject);
		}
	}

	/**
	 * If value is a jClass AS value return it as is, else return the jClass counterpart of the ES value.
	 *
	 * @since 1.18
	 */
	public static <T extends Element> @NonNull T getASorASofES(@NonNull Executor executor, @NonNull Class<T> jClass, @NonNull Object value) {
		/* if (value == null) {
			return null;
		}
		else */ if (jClass.isAssignableFrom(value.getClass())) {
			@SuppressWarnings("unchecked")
			T castValue = (T)value;
			return castValue;
		}
		else {
			try {
				EnvironmentFactoryInternalExtension environmentFactory = (EnvironmentFactoryInternalExtension)executor.getEnvironmentFactory();
				return ClassUtil.nonNullState(environmentFactory.getASOf(jClass, (EObject)value));
			} catch (Throwable e) {
				throw new InvalidValueException(e, "Failed to access AS of " + value);
			}
		}
	}

	public static @NonNull String getElementIdName(@NonNull ElementId elementId) {
		String name = elementId.toString();
		if (name.startsWith(METAMODEL_NAME_PREFIX)) {
			name = name.substring(METAMODEL_NAME_PREFIX.length());
		}
		return name;
	}

	/** @deprecated only used to support deprecated code
	 * @since 1.1*/
	@Deprecated
	public static @NonNull Executor getExecutor(@NonNull Evaluator evaluator) {
		if (evaluator instanceof Executor) {
			return (Executor)evaluator;
		}
		return ((EvaluationVisitor.EvaluationVisitorExtension)evaluator).getExecutor();
	}

	public static String getTypeName(@Nullable Object value) {
		if (value instanceof Boolean) {
			return TypeId.BOOLEAN_NAME;
		}
		else if (value instanceof String) {
			return TypeId.STRING_NAME;
		}
		else if (value instanceof Value) {
			return ((Value) value).getTypeId().getDisplayName();
		}
		else if (value == null) {
			return TypeId.OCL_VOID_NAME;
		}
		return "Object";
	}

	/**
	 * Initialize all static variables in this package to avoid thread contention between conflicting initializations.
	 * <p>
	 * Returns true if this invocation performed the initialization.
	 */
	public static boolean initAllStatics() {
		if (!allStaticsInitialized) {
			synchronized (ValueUtil.class) {
				if (!allStaticsInitialized) {
					allStaticsInitialized = true;
					// org.eclipse.ocl.domain.elements
					ParameterTypesImpl.EMPTY_LIST.getClass();
					TemplateParameters.EMPTY_LIST.getClass();
					// org.eclipse.ocl.domain.evaluation
					ModelManager.NULL.getClass();
					// org.eclipse.ocl.domain.ids
					//					IdManager.getClass();
					TemplateableId.NULL_TEMPLATEABLE_ID_ARRAY.getClass();
					//					BindingsId.EMPTY_LIST.getClass();
					//					TemplateParameterId.NULL_TEMPLATE_PARAMETER_ID_ARRAY.getClass();
					TypeId.INTEGER.getClass();
					// org.eclipse.ocl.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.domain.library
					UnsupportedOperation.INSTANCE.getClass();
					// org.eclipse.ocl.domain.messages
					PivotMessages.InvalidOperation.getClass();
					new StatusCodes();
					// org.eclipse.ocl.domain.types
					AbstractInheritance.initStatics();
					// org.eclipse.ocl.domain.utilities
					StringUtil.createNumberFromString("0");
					StandaloneProjectMap.initStatics();
					// org.eclipse.ocl.domain.validation
					LabelUtil.SUBSTITUTION_LABEL_PROVIDER.getClass();
					// org.eclipse.ocl.domain.values
					ValuesPackage.eINSTANCE.getClass();
					// org.eclipse.ocl.domain.values.impl
					CollectionValueImpl.initStatics();
					RealValueImpl.initStatics();
					// org.eclipse.ocl.domain.values.util
					//					new ValuesAdapterFactory();
					//					new ValuesSwitch<Object>();
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @since 1.1
	 */
	public static int intValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).intValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	public static @NonNull IntegerValue integerValueOf(int value) {
		if (value > -NEGATIVE_INTEGERS) {
			if (value < POSITIVE_INTEGERS) {
				int index = value + NEGATIVE_INTEGERS;
				IntegerValue integerValue = INTEGER_VALUES[index];
				if (integerValue != null) {
					return integerValue;
				}
				synchronized (INTEGER_VALUES) {
					integerValue = INTEGER_VALUES[index];
					if (integerValue != null) {
						return integerValue;
					}
					return INTEGER_VALUES[index] = new IntIntegerValueImpl(value);
				}
			}
		}
		return new IntIntegerValueImpl(value);
	}

	public static @NonNull IntegerValue integerValueOf(long value) {
		if ((Integer.MIN_VALUE <= value) && (value <= Integer.MAX_VALUE)) {
			return integerValueOf((int) value);
		}
		else {
			return new LongIntegerValueImpl(value);
		}
	}

	public static @NonNull IntegerValue integerValueOf(@Nullable BigInteger value) {
		if (value == null) {
			throw new InvalidValueException(PivotMessages.InvalidInteger, value);
		}
		else if (value.signum() >= 0) {
			if (value.compareTo(INTEGER_MAX_VALUE) <= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MAX_VALUE) <= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		else {
			if (value.compareTo(INTEGER_MIN_VALUE) >= 0) {
				return new IntIntegerValueImpl(value.intValue());
			}
			if (value.compareTo(LONG_MIN_VALUE) >= 0) {
				return new LongIntegerValueImpl(value.longValue());
			}
		}
		return new BigIntegerValueImpl(value);
	}

	public static @NonNull IntegerValue integerValueOf(@Nullable Object aValue) {
		if (aValue instanceof BigInteger) {
			return integerValueOf((BigInteger)aValue);
		}
		//		else if (aValue instanceof Unlimited) {
		//			return UNLIMITED_VALUE;
		//		}
		else if (aValue instanceof Number) {
			return integerValueOf(((Number)aValue).longValue());
		}
		else if (aValue instanceof Character) {
			return integerValueOf(((Character)aValue).charValue());
		}
		else if (aValue instanceof IntegerValue) {
			return (IntegerValue)aValue;					// Never happens
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, aValue);
		}
	}

	/**
	 * Creates an IntegerValue representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 */
	public static @NonNull IntegerValue integerValueOf(@NonNull String aValue) {
		try {
			int len = aValue.length();
			if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
				@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.valueOf(Long.parseLong(aValue));
				return integerValueOf(result);
			}
			else {
				return integerValueOf(new BigInteger(aValue));
			}
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, PivotMessages.InvalidInteger, aValue);
		}
	}

	public static boolean isBoxed(@Nullable Object object) {
		if (object instanceof NullValue) {
			return false;
		}
		if (object instanceof EnumerationLiteral) {
			return false;
		}
		if (object instanceof EEnumLiteral) {
			return false;
		}
		if (object instanceof Enumerator) {
			return false;
		}
		if ((object instanceof Number) && !(object instanceof RealValue) && !(object instanceof UnlimitedNaturalValue)) {
			return false;
		}
		if ((object instanceof Iterable<?>) && !(object instanceof IterableValue)) {
			return false;
		}
		return true;
	}

	public static @Nullable CollectionValue isCollectionValue(@Nullable Object value) {
		if ((value instanceof CollectionValue) && !(value instanceof NullValue)) {
			return (CollectionValue)value;
		}
		else {
			return null;
		}
	}

	public static boolean isEcore(Object object) {
		if (object instanceof NullValue) {
			return false;
		}
		if (object instanceof ElementId) {
			return false;
		}
		if (object instanceof RealValue) {
			return false;
		}
		if (object instanceof IterableValue) {
			return false;
		}
		if ((object instanceof Collection) && !(object instanceof List)) {
			return false;
		}
		return true;
	}

	/**
	 * Return true if aNumber is a known integer representation that can be converted to an IntegerValue.
	 * Returns false for other types including IntegerValue.
	 */
	public static boolean isIntegerNumber(@NonNull Number aNumber) {
		return (aNumber instanceof BigInteger) || (aNumber instanceof Long) || (aNumber instanceof Integer) || (aNumber instanceof Short) || (aNumber instanceof Byte);
	}

	public static IntegerValue isIntegerValue(@Nullable Object value) {
		if ((value instanceof IntegerValue) && !(value instanceof NullValue)) {
			return (IntegerValue)value;
		}
		else {
			return null;
		}
	}

	/**
	 * @since 1.6
	 */
	public static @Nullable IterableValue isIterableValue(@Nullable Object value) {
		if ((value instanceof IterableValue) && !(value instanceof NullValue)) {
			return (IterableValue)value;
		}
		else {
			return null;
		}
	}

	/**
	 * Return true if aNumber is a known floating point representation that can be converted to a RealValue.
	 * Returns false for other types including RealValue.
	 */
	public static boolean isRealNumber(@NonNull Number aNumber) {
		return (aNumber instanceof BigDecimal) || (aNumber instanceof Double) || (aNumber instanceof Float);
	}

	public static boolean isUnboxed(Object object) {
		if (object instanceof NullValue) {
			return false;
		}
		if (object instanceof ElementId) {
			return false;
		}
		if (object instanceof RealValue) {
			return false;
		}
		if (object instanceof IterableValue) {
			return false;
		}
		return true;
	}

	public static boolean isUnlimited(@Nullable Object value) {
		// FIXME Unify the two Unlimited classes
		// return (value instanceof UnlimitedValue) && !(value instanceof NullValue);
		return (value instanceof UnlimitedValue) && !(value instanceof NullValue);
	}

	/**
	 * @since 1.1
	 */
	public static long longValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).intValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	/**
	 * @since 1.1
	 */
	public static @NonNull NumberValue numberValueOf(@NonNull Number aNumber) {
		if (aNumber instanceof RealValue) {
			return (RealValue)aNumber;
		}
		else if (aNumber instanceof BigDecimal) {
			return new RealValueImpl((BigDecimal)aNumber);
		}
		else  {
			return integerValueOf(aNumber);
		}
	}

	public static @NonNull String oclToString(@NonNull Object value) {
		@SuppressWarnings("null") @NonNull String result = value.toString();
		return result;
	}

	public static @NonNull RealValue realValueOf(double value) {
		return new RealValueImpl(value);
	}

	public static @NonNull RealValue realValueOf(@Nullable BigDecimal value) {
		if (value != null) {
			return new RealValueImpl(value);
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidReal, value);
		}
	}

	public static @NonNull RealValue realValueOf(@Nullable IntegerValue integerValue) {
		if (integerValue == null) {
			throw new InvalidValueException(PivotMessages.InvalidInteger, integerValue);
		}
		try {
			return realValueOf(integerValue.bigDecimalValue());
		} catch (InvalidValueException e) {
			throw new InvalidValueException(e, PivotMessages.InvalidInteger, integerValue);
		}
	}

	public static @NonNull RealValue realValueOf(@Nullable Number aNumber) {
		if (aNumber instanceof RealValue) {
			return (RealValue)aNumber;
		}
		else if (aNumber instanceof BigDecimal) {
			return new RealValueImpl((BigDecimal)aNumber);
		}
		else if (aNumber instanceof BigInteger) {
			return new RealValueImpl(new BigDecimal((BigInteger)aNumber));
		}
		//		else if (aNumber instanceof Unlimited) {
		//			return new RealValueImpl(Double.POSITIVE_INFINITY);
		//		}
		else if (aNumber != null) {
			return new RealValueImpl(aNumber.doubleValue());
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidReal, aNumber);
		}
	}

	public static @NonNull RealValue realValueOf(@NonNull String aValue) {
		try {
			return new RealValueImpl(new BigDecimal(aValue.trim()));
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, PivotMessages.InvalidReal, aValue);
		}
	}

	/**
	 * @since 1.1
	 */
	public static short shortValueOf(@Nullable Object anObject) {
		if (anObject instanceof Number) {
			return ((Number)anObject).shortValue();
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, anObject);
		}
	}

	public static @NonNull String stringValueOf(@Nullable Object aValue) {
		String stringValue = null;
		if (aValue == null) {
			stringValue = NULL_STRING;
		}
		else if (aValue instanceof Value) {							// Needed for Iterable Values such as CollectionValue
			stringValue = ((Value)aValue).toString();
		}
		else if (aValue instanceof String) {
			stringValue = "'" + StringUtil.convertToOCLString((String)aValue) + "'";
		}
		//		else if (aValue instanceof DomainType) {
		//			return String.valueOf(aValue);
		//		}
		//		else if (aValue instanceof DomainEnumerationLiteral) {
		//			return String.valueOf(aValue);
		//		}
		//		else if (aValue instanceof EEnumLiteral) {
		//			return String.valueOf(aValue);
		//		}
		else if ((aValue instanceof EObject) &&
				!((aValue instanceof Element) || (aValue instanceof EEnumLiteral))) {
			stringValue = LabelUtil.getLabel(aValue);
		}
		else if (aValue.getClass().isArray()) {
			throw new UnsupportedOperationException();			// Must invoke IdResolver.boxedValueOf() for aggregates
		}
		else if (aValue instanceof Iterable<?>) {
			throw new UnsupportedOperationException();			// Must invoke IdResolver.boxedValueOf() for aggregates
		}
		else {
			stringValue = String.valueOf(aValue);
		}
		return stringValue != null ? stringValue : "<<null>>";
	}

	public static boolean throwBooleanInvalidValueException(@NonNull String string) {
		throw new InvalidValueException(string);
	}

	/**
	 * Throw an InvalidValueException without subsequent code appearing to be unreachable.
	 */
	public static @NonNull Object throwInvalidValueException() {
		throw new InvalidValueException("invalid");
	}

	public static int throwUnsupportedCompareTo(@Nullable Object left, @Nullable Object right) {
		throw new InvalidValueException(PivotMessages.UnsupportedCompareTo,
			left != null ? left.getClass().getName() : "null", //$NON-NLS-1$
				right != null ? right.getClass().getName() : "null"); //$NON-NLS-1$
	}

	public static void toString(@Nullable Object value, @NonNull StringBuilder s, int sizeLimit) {
		if (value instanceof Value) {
			((Value)value).toString(s, sizeLimit);
		}
		else if (value instanceof String) {
			s.append("'");
			toStringWithLimit(s, (String)value, sizeLimit);
			s.append("'");
		}
		else if (value != null) {
			toStringWithLimit(s, value.toString(), sizeLimit);
		}
		else {
			toStringWithLimit(s, NULL_STRING, sizeLimit);
		}
	}

	private static void toStringWithLimit(@NonNull StringBuilder s, String string, int sizeLimit) {
		if (sizeLimit < 0) {
			s.append(string);
		}
		else {
			int length = string.length();
			int available = sizeLimit - (length + 1);
			if (length <= available) {
				s.append(string);
			}
			else {
				if (available > 0) {
					s.append(string.substring(0, available));
				}
				s.append("...");
			}
		}
	}

	/**
	 * @since 1.1
	 * @deprecated use IterableValue
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static @NonNull <T> Iterable<T> typedIterable(Class<T> elementClass, @NonNull CollectionValue collectionValue) {
		return (Iterable<T>)collectionValue;
	}

	/**
	 * @since 1.6
	 */
	@SuppressWarnings("unchecked")
	public static @NonNull <T> Iterable<T> typedIterable(Class<T> elementClass, @NonNull IterableValue iterableValue) {
		return (Iterable<T>)iterableValue;
	}

	public static @NonNull UnlimitedNaturalValue unlimitedNaturalValueOf(@Nullable BigInteger value) {
		return (UnlimitedNaturalValue)integerValueOf(value);
	}

	public static @NonNull UnlimitedNaturalValue unlimitedNaturalValueOf(int value) {
		return (UnlimitedNaturalValue)integerValueOf(value);
	}

	public static @NonNull UnlimitedNaturalValue unlimitedNaturalValueOf(long value) {
		return (UnlimitedNaturalValue)integerValueOf(value);
	}

	public static @NonNull UnlimitedNaturalValue unlimitedNaturalValueOf(@Nullable Object aValue) {
		if (aValue instanceof BigInteger) {
			return new BigIntegerValueImpl((BigInteger)aValue);
		}
		else if (aValue instanceof Unlimited) {
			return UNLIMITED_VALUE;
		}
		else if (aValue instanceof Number) {
			return unlimitedNaturalValueOf(((Number)aValue).longValue());
		}
		else if (aValue instanceof Character) {
			return unlimitedNaturalValueOf(((Character)aValue).charValue());
		}
		else if (aValue instanceof UnlimitedNaturalValue) {
			return (UnlimitedNaturalValue)aValue;					// Never happens
		}
		else {
			throw new InvalidValueException(PivotMessages.InvalidInteger, aValue);
		}
	}

	/**
	 * Creates an IntegerValue representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 */
	public static @NonNull UnlimitedNaturalValue unlimitedNaturalValueOf(@NonNull String aValue) {
		try {
			int len = aValue.length();
			if ((len == 1) && "*".equals(aValue)) {
				return UNLIMITED_VALUE;
			}
			if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
				@SuppressWarnings("null") @NonNull BigInteger result = BigInteger.valueOf(Long.parseLong(aValue));
				return unlimitedNaturalValueOf(result);
			}
			else {
				return unlimitedNaturalValueOf(new BigInteger(aValue));
			}
		}
		catch (NumberFormatException e) {
			throw new InvalidValueException(e, PivotMessages.InvalidInteger, aValue);
		}
	}

	/**
	 * Add a validation failed diagnostic to the diagnostics in a context. The e failure occurs for the constraintName check of object.
	 *
	 * (See Bug 543178.)
	 * @since 1.7
	 */
	public static boolean validationFailedDiagnostic(@NonNull Object constraintName, @NonNull Object object, @Nullable Object diagnostics, @Nullable Object context, @NonNull Throwable e) {
		if (diagnostics != null) {
			String emfMessage = StringUtil.bind(PivotMessages.ValidationEvaluationFailed_ERROR_, new Object[]{constraintName, e.getMessage()});
			Object emfData[] = new Object [] { object, e };
			((DiagnosticChain) diagnostics).add(new BasicDiagnostic(Diagnostic.ERROR, PivotValidator.DIAGNOSTIC_SOURCE, 0, emfMessage, emfData));
		}
		return false;
	}
}
