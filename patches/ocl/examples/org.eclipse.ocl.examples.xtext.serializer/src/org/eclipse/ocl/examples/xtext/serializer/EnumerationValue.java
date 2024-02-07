/*******************************************************************************
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.Strings;

/**
 * An EnumerationValue defines zero/one/many values that enumerate a String EAttribute.
 */
public abstract class EnumerationValue implements Nameable
{
	public static final @NonNull EnumerationValue @NonNull [] NO_ENUMERATION_VALUES = new @NonNull EnumerationValue[0];

	/**
	 * The EnumerationValueAny provides a reserved EnumerationValue to key the usage of any enumeration values.
	 */
	public static class EnumerationValueAny extends EnumerationValue
	{
		public static final @NonNull EnumerationValueAny INSTANCE = new EnumerationValueAny();

		private EnumerationValueAny() {}

		@Override
		public boolean equals(Object obj) {
			return obj == this;
		}

		@Override
		public @NonNull String getName() {
			return "«any»";
		}

		@Override
		public boolean isAny() {
			return true;
		}

		@Override
		public boolean isElement(@NonNull String string) {
			return false;
		}

		@Override
		public @NonNull String toString() {
			return getName();
		}
	}

	public static class EnumerationValueMultiple extends EnumerationValue
	{
		protected final @NonNull String @NonNull [] values;
		protected final @NonNull String name;

		@SuppressWarnings("null")
		public EnumerationValueMultiple(@NonNull List<@NonNull String> values) {
			this(values.toArray(new @NonNull String [values.size()]));
		}

		public EnumerationValueMultiple(@NonNull String @NonNull [] values) {
			this.values = values;
			assert values.length > 0;
			Arrays.sort(this.values);
		//	this.name = this.values.get(0) + "...";
			StringBuilder s = new StringBuilder();
			boolean isFirst = true;
			for (@NonNull String value : this.values) {
				if (!isFirst) {
					s.append("|");
				}
				s.append(Strings.convertToJavaString(value));
				isFirst = false;
			}
			@SuppressWarnings("null")
			@NonNull String castString = (@NonNull String)s.toString();
			this.name = castString;
		}

		@Override
		public int computeHashCode() {
			int hash = super.computeHashCode();
			for (@NonNull String value : values) {
				hash += value.hashCode();
			}
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof EnumerationValueMultiple)) {
				return false;
			}
			EnumerationValueMultiple that = (EnumerationValueMultiple)obj;
			if (this.values.length != that.values.length) {
				return false;
			}
			for (int i = 0; i < this.values.length; i++) {
				if (!this.values[i].equals(that.values[i])) {
					return false;
				}
			}
			return true;
		}

		@Override
		public @NonNull String getName() {
			return name;
		}

		public @NonNull String @NonNull [] getValues() {
			return values;
		}

		@Override
		public boolean isElement(@NonNull String string) {
			for (@NonNull String value : values) {
				if (value.equals(string)) {
					return true;
				}
			}
			return false;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append("'");
			boolean isFirst = true;
			for (@NonNull String value : values) {
				if (!isFirst) {
					s.append("|");
				}
				s.append(Strings.convertToJavaString(value));
				isFirst = false;
			}
			s.append("'");
			@SuppressWarnings("null")
			@NonNull String castString = (@NonNull String)s.toString();
			return castString;
		}
	}

	/**
	 * The EnumerationValueNull provides a reserved EnumerationValue to key the usage of no enumeration values.
	 */
	public static class EnumerationValueNull extends EnumerationValue
	{
		public static final @NonNull EnumerationValueNull INSTANCE = new EnumerationValueNull();

		private EnumerationValueNull() {}

		@Override
		public boolean equals(Object obj) {
			return obj == this;
		}

		@Override
		public @NonNull String getName() {
			return "«null»";
		}

		@Override
		public boolean isElement(@NonNull String string) {
			return false;
		}

		@Override
		public boolean isNull() {
			return true;
		}

		@Override
		public @NonNull String toString() {
			return getName();
		}
	}

	/**
	 * The EnumerationValueOthers provides a reserved EnumerationValue to key the usage of unknown enumeration values.
	 */
	public static class EnumerationValueOthers extends EnumerationValue
	{
		public static final @NonNull EnumerationValueOthers INSTANCE = new EnumerationValueOthers();

		private EnumerationValueOthers() {}

		@Override
		public boolean equals(Object obj) {
			return obj == this;
		}

		@Override
		public @NonNull String getName() {
			return "«others»";
		}

		@Override
		public boolean isElement(@NonNull String string) {
			return false;
		}

		@Override
		public boolean isOthers() {
			return true;
		}

		@Override
		public @NonNull String toString() {
			return getName();
		}
	}

	public static class EnumerationValueSingle extends EnumerationValue
	{
		protected final @NonNull String value;

		public EnumerationValueSingle(@NonNull String value) {
			this.value = value;
		}

		@Override
		public int computeHashCode() {
			return super.computeHashCode() + value.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof EnumerationValueSingle)) {
				return false;
			}
			return value.equals(((EnumerationValueSingle)obj).value);
		}

		@Override
		public @NonNull String getName() {
			return value;
		}

		@Override
		public boolean isElement(@NonNull String string) {
			return value.equals(string);
		}

		@Override
		public @NonNull String toString() {
			return "'" + Strings.convertToJavaString(value) + "'";
		}
	}

	private @Nullable Integer hashCode = null;

	protected int computeHashCode() {
		return getClass().hashCode();
	}

	@Override
	public abstract @NonNull String getName();

	@Override
	public final int hashCode() {
		Integer hashCode2 = hashCode;
		if (hashCode2 == null) {
			hashCode = hashCode2 = computeHashCode();
		}
		return hashCode2.intValue();
	}

	public boolean isAny() {
		return false;
	}

	public abstract boolean isElement(@NonNull String string);

	public boolean isNull() {
		return false;
	}

	public boolean isOthers() {
		return false;
	}
}