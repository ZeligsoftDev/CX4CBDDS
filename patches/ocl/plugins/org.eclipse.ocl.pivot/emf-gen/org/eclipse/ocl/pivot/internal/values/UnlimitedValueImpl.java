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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.ComparableValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NumberValue;
import org.eclipse.ocl.pivot.values.RealValue;
import org.eclipse.ocl.pivot.values.Unlimited;
import org.eclipse.ocl.pivot.values.UnlimitedNaturalValue;
import org.eclipse.ocl.pivot.values.UnlimitedValue;
import org.eclipse.ocl.pivot.values.ValuesPackage;

/**
 * @generated NOT
 *
 * FIXME Unify with Unlimited
 */
public class UnlimitedValueImpl extends NumberValueImpl implements UnlimitedValue
{
	private static final long serialVersionUID = 8556985089778234910L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ValuesPackage.Literals.UNLIMITED_VALUE;
	}

	public UnlimitedValueImpl() {}

	@Override
	public Object asEcoreObject(@NonNull IdResolver idResolver, @Nullable Class<?> instanceClass) {
		return -1;
	}

	@Override
	public @NonNull Object asObject() {
		return Unlimited.INSTANCE;
	}

	@Override
	public @NonNull RealValue asRealValue() {
		throw new InvalidValueException(PivotMessages.InvalidOperation, "asRealValue", "UnlimitedValue");
	}

	@Override
	public @NonNull Object asUnboxedObject(@NonNull IdResolver idResolver) {
		return Unlimited.INSTANCE;
	}

	@Override
	public @NonNull UnlimitedNaturalValue asUnlimitedNaturalValue() {
		return this;
	}

	@Override
	public int commutatedCompareTo(@NonNull ComparableValue<?> left) {
		if (left instanceof UnlimitedNaturalValue) {
			if (((UnlimitedNaturalValue)left).isUnlimited()) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return ValueUtil.throwUnsupportedCompareTo(left, this);
		}
	}

	@Override
	public int commutatedCompareToInteger(@NonNull IntegerValue left) {
		return 1;
	}

	@Override
	public int commutatedCompareToReal(@NonNull RealValue left) {
		return 1;
	}

	@Override
	public int compareTo(@Nullable NumberValue right) {
		if (right instanceof UnlimitedNaturalValue) {
			if (((UnlimitedNaturalValue)right).isUnlimited()) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if (right != null) {
			return -right.commutatedCompareTo(this);
		}
		else {
			return ValueUtil.throwUnsupportedCompareTo(this, right);
		}
	}

	@Override
	public @NonNull LiteralExp createLiteralExp() {
		UnlimitedNaturalLiteralExp literalExp = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
		literalExp.setUnlimitedNaturalSymbol(-1);
		return literalExp;
	}

	@Override
	public double doubleValue() {
		throw new InvalidValueException(PivotMessages.InvalidReal, null, null, this);
	}

	@Override
	public float floatValue() {
		throw new InvalidValueException(PivotMessages.InvalidReal, null, null, this);
	}

	public @NonNull Type getType(@NonNull StandardLibrary standardLibrary) {
		return standardLibrary.getUnlimitedNaturalType();
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return TypeId.UNLIMITED_NATURAL;
	}

	@Override
	public int intValue() {
		throw new InvalidValueException(PivotMessages.InvalidInteger, null, null, this);
	}

	@Override
	public boolean isUnlimited() {
		return true;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return true;
	}

	@Override
	public @Nullable UnlimitedNaturalValue isUnlimitedNaturalValue() {
		return this;
	}

	@Override
	public long longValue() {
		throw new InvalidValueException(PivotMessages.InvalidInteger, null, null, this);
	}

	@Override
	public @NonNull UnlimitedNaturalValue max(@NonNull UnlimitedNaturalValue rightValue) {
		return this;
	}

	@Override
	public @NonNull UnlimitedNaturalValue maxUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return this;
	}

	@Override
	public @NonNull UnlimitedNaturalValue min(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue;
	}

	@Override
	public @NonNull UnlimitedNaturalValue minUnlimited(@NonNull UnlimitedNaturalValue rightValue) {
		return rightValue;
	}

	@Override
	public String toString() {
		return "*";
	}
}
