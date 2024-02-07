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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.ComparableValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RealValueImpl extends NumberValueImpl implements RealValue {
	private static final long serialVersionUID = -6016171050097266652L;

	private static final int MINIMUM_SCALE = Double.SIZE/2;		// Gives nearly twice the precision of Double

	protected static @NonNull RealValue divideBigDecimal(@NonNull BigDecimal left, @NonNull BigDecimal right) {
		try {
			if (right.signum() == 0) {
				throw new InvalidValueException("divide by zero");
			}
			int scale = Math.max(left.scale() - right.scale(), MINIMUM_SCALE);
			@SuppressWarnings("null") @NonNull BigDecimal result = left.divide(right, scale, RoundingMode.HALF_EVEN);
			return ValueUtil.realValueOf(result);
		} catch (ArithmeticException e) {
			throw new InvalidValueException(e, "divideBigDecimal");
		}
	}

	/**
	 * A simple public static method that may be used to force class initialization.
	 */
	public static void initStatics() {}

	/**
	 * The number of structural features of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REAL_VALUE_FEATURE_COUNT = NumberValueImpl.NUMBER_VALUE_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.REAL_VALUE;
	}

	private final @NonNull BigDecimal value;
	private Object integerValue = null;	// Lazily computed exact IntegerValue or Exception

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RealValueImpl() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("null")
	public RealValueImpl(double value) {
		this(BigDecimal.valueOf(value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RealValueImpl(@NonNull BigDecimal value) {
		this.value = value;
		assert value != null;
	}

	@Override
	public @NonNull RealValue abs() {
		@SuppressWarnings("null") @NonNull BigDecimal result = value.abs();
		return ValueUtil.realValueOf(result);
	}

	@Override
	public @NonNull RealValue addInteger(@NonNull IntegerValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.add(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue addReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.add(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull Double asDouble() {
		return value.doubleValue();
	}

	@Override
	public Object asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		if (instanceClass == BigDecimal.class) {
			return value;
		}
		else {
			Object ecoreValue = super.asEcoreObject(idResolver, instanceClass);
			return ecoreValue != null ? ecoreValue : doubleValue();
		}
	}

	@Override
	public @NonNull Number asNumber() {
		return value;
	}

	@Override
	public @NonNull Object asObject() {
		return value;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		return this;
	}

	@Override
	public @NonNull Object asUnboxedObject(@NonNull IdResolver idResolver) {
		return value;
	}

	@Override
	public @NonNull BigDecimal bigDecimalValue() {
		return value;
	}

	@Override
	public @NonNull BigInteger bigIntegerValue() {
		Object intValue = getIntegerValue();
		if (intValue instanceof Exception) {
			throw new InvalidValueException((Exception) intValue, "bigIntegerValue");
		}
		else {
			return ((IntegerValue) intValue).bigIntegerValue();
		}
	}

	@Override
	public @NonNull RealValue commutatedAdd(@NonNull RealValue left) {
		return left.addReal(this);
	}

	@Override
	public int commutatedCompareTo(@NonNull ComparableValue<?> left) {
		if (left instanceof NumberValue) {
			return ((NumberValue)left).commutatedCompareToReal(this);
		}
		else {
			return ValueUtil.throwUnsupportedCompareTo(left, this);
		}
	}

	@Override
	public int commutatedCompareToInteger(@NonNull IntegerValue left) {
		return value.compareTo(left.bigDecimalValue());
	}

	@Override
	public int commutatedCompareToReal(@NonNull RealValue left) {
		return value.compareTo(left.bigDecimalValue());
	}

	@Override
	public @NonNull RealValue commutatedDivide(@NonNull RealValue left) {
		return left.divideReal(this);
	}

	@Override
	public @NonNull RealValue commutatedMultiply(@NonNull RealValue left) {
		return left.multiplyReal(this);
	}

	@Override
	public @NonNull RealValue commutatedSubtract(@NonNull RealValue left) {
		return left.subtractReal(this);
	}

	@Override
	public int compareTo(@Nullable NumberValue right) {
		if (right != null) {
			return -right.commutatedCompareToReal(this);
		}
		else {
			return ValueUtil.throwUnsupportedCompareTo(this, right);
		}
	}

	@Override
	public @NonNull LiteralExp createLiteralExp() {
		RealLiteralExp literalExp = PivotFactory.eINSTANCE.createRealLiteralExp();
		literalExp.setRealSymbol(asNumber());
		return literalExp;
	}

	@Override
	public @NonNull RealValue divideInteger(@NonNull IntegerValue right) {
		return divideBigDecimal(value, right.bigDecimalValue());
	}

	@Override
	public @NonNull RealValue divideReal(@NonNull RealValue right) {
		return divideBigDecimal(value, right.bigDecimalValue());
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof RealValue) {
				BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
				return value.compareTo(bigDecimalValue) == 0;
			}
			if (obj instanceof IntegerValue) {
				BigDecimal bigDecimalValue = ((IntegerValue)obj).bigDecimalValue();
				return value.compareTo(bigDecimalValue) == 0;
			}
		} catch (InvalidValueException e) {
		}
		return this == obj;
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public @NonNull IntegerValue floor() {
		@SuppressWarnings("null") @NonNull BigInteger result = value.setScale(0, RoundingMode.FLOOR).toBigInteger();
		return ValueUtil.integerValueOf(result);
	}

	protected Object getIntegerValue() {
		if (integerValue == null) {
			try {
				@SuppressWarnings("null") @NonNull BigInteger intValue = value.toBigIntegerExact();
				integerValue = ValueUtil.integerValueOf(intValue);
			}
			catch (ArithmeticException e) {
				integerValue = e;
			}
		}
		return integerValue;
	}

	public @NonNull Type getType(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getRealType();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.REAL;
	}

	@Override
	public int hashCode() {
		Object intValue = getIntegerValue();
		if (intValue instanceof IntegerValue) {
			return intValue.hashCode();
		}
		else {
			return value.hashCode();
		}
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public @Nullable IntegerValue isIntegerValue() {
		return null;
	}

	@Override
	public @Nullable UnlimitedNaturalValue isUnlimitedNaturalValue() {
		return null;
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public @NonNull RealValue max(@NonNull RealValue rightValue) {
		return rightValue.maxReal(this);
	}

	@Override
	public @NonNull RealValue maxInteger(@NonNull IntegerValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.max(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue maxReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.max(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue min(@NonNull RealValue rightValue) {
		return rightValue.minReal(this);
	}

	@Override
	public @NonNull RealValue minInteger(@NonNull IntegerValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.min(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue minReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.min(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue multiplyInteger(@NonNull IntegerValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.multiply(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue multiplyReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.multiply(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue negate() {
		@SuppressWarnings("null") @NonNull BigDecimal result = value.negate();
		return ValueUtil.realValueOf(result);
	}

	@Override
	public @NonNull IntegerValue round() {
		BigDecimal rounded;
		if (value.signum() >= 0) {
			rounded = value.setScale(0, RoundingMode.HALF_UP);		// functions as HALF_AWAY
		}
		else {
			rounded = value.negate().setScale(0, RoundingMode.HALF_DOWN).negate();
		}
		@SuppressWarnings("null") @NonNull BigInteger result = rounded.toBigInteger();
		return ValueUtil.integerValueOf(result);
	}

	@Override
	public int signum() {
		return value.signum();
	}

	@Override
	public @NonNull RealValue subtractInteger(@NonNull IntegerValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.subtract(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public @NonNull RealValue subtractReal(@NonNull RealValue rightValue) {
		try {
			@SuppressWarnings("null") @NonNull BigDecimal result = value.subtract(rightValue.bigDecimalValue());
			return ValueUtil.realValueOf(result);
		} catch (InvalidValueException e) {
			throw new InvalidValueException(PivotMessages.InvalidReal, e, null, rightValue);
		}
	}

	@Override
	public String toString() {
		return value.toString();
	}
} //RealValueImpl
