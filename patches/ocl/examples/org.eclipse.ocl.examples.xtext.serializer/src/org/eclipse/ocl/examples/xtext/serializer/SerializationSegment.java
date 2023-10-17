/**
 * Copyright (c) 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.ocl.examples.xtext.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Lists;

public interface SerializationSegment
{
	public static final @NonNull SerializationSegment HALF_NEW_LINE = new StringSerializationSegment(SerializationBuilder.HALF_NEW_LINE);
	public static final @NonNull SerializationSegment NEW_LINE = new StringSerializationSegment(SerializationBuilder.NEW_LINE);
	public static final @NonNull SerializationSegment NO_SPACE = new StringSerializationSegment(SerializationBuilder.NO_SPACE);
	public static final @NonNull SerializationSegment POP = new ControlSerializationSegment(SerializationBuilder.POP);
	public static final @NonNull SerializationSegment POST_COMMENT = new PostCommentSerializationSegment();
	public static final @NonNull SerializationSegment PRE_COMMENT = new PreCommentSerializationSegment();
	public static final @NonNull SerializationSegment PUSH = new ControlSerializationSegment(SerializationBuilder.PUSH);
	public static final @NonNull SerializationSegment PUSH_NEXT = new ControlSerializationSegment(SerializationBuilder.PUSH_NEXT);
	public static final @NonNull SerializationSegment SOFT_NEW_LINE = new StringSerializationSegment(SerializationBuilder.SOFT_NEW_LINE);
	public static final @NonNull SerializationSegment SOFT_SPACE = new StringSerializationSegment(SerializationBuilder.SOFT_SPACE);
	public static final @NonNull SerializationSegment VALUE = new ValueSerializationSegment();
	public static final @NonNull SerializationSegment WRAP_ANCHOR = new ControlSerializationSegment(SerializationBuilder.WRAP_ANCHOR);
	public static final @NonNull SerializationSegment WRAP_BEGIN_ALL = new ControlSerializationSegment(SerializationBuilder.WRAP_BEGIN_ALL);
	public static final @NonNull SerializationSegment WRAP_BEGIN_SOME = new ControlSerializationSegment(SerializationBuilder.WRAP_BEGIN_SOME);
	public static final @NonNull SerializationSegment WRAP_END = new ControlSerializationSegment(SerializationBuilder.WRAP_END);
	public static final @NonNull SerializationSegment WRAP_HERE = new ControlSerializationSegment(SerializationBuilder.WRAP_HERE);

	public static final @NonNull SerializationSegment @NonNull [] VALUE_SEGMENTS_ARRAY = new @NonNull SerializationSegment[] { VALUE };
	@SuppressWarnings("null")
	public static final @NonNull List<@NonNull SerializationSegment> VALUE_SEGMENTS_LIST = Lists.newArrayList(VALUE);

	void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder);

	/**
	 * A control segment such as push or pop is serialized while fomattimg the unselectdd prefix of a formatted
	 * region inmorder to ensure that the indentation is globally correct.
	 */
	boolean isControl();

	/**
	 * A value segment contributes the non-whitespace value of its client element.
	 */
	boolean isValue();

	void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder);

	public static abstract class AbstractSerializationSegment implements SerializationSegment
	{
		@Override
		public boolean isControl() {
			return false;
		}

		@Override
		public boolean isValue() {
			return false;
		}
	}

	public static class ControlSerializationSegment extends StringSerializationSegment
	{
		public ControlSerializationSegment(@NonNull String string) {
			super(string);
		}

		@Override
		public boolean isControl() {
			return true;
		}
	}

	public static class CustomSerializationSegment extends AbstractSerializationSegment
	{
		private @Nullable String supportClassName;
		private @Nullable Class<?> supportClass;
		private @Nullable CustomSegmentSupport supportInstance = null;

		public CustomSerializationSegment(@NonNull String supportClassName) {
			this.supportClassName = supportClassName;
			this.supportClass = null;
			this.supportInstance = null;
		}

		public CustomSerializationSegment(@NonNull Class<?> supportClass) {
			this.supportClassName = null;
			this.supportClass = supportClass;
			this.supportInstance = null;
		}

		public @NonNull String getSupportClassName() {
			if (supportClassName != null) {
				return supportClassName;
			}
			assert supportClass != null;
			@SuppressWarnings("null")
			@NonNull String castName = (@NonNull String)supportClass.getName();
			return castName;
		}

		@Override
		public void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder) {
			CustomSegmentSupport supportInstance2 = getSupportInstance(formatter.getElement());
			if (supportInstance2 == null) {
				serializationBuilder.appendError("\n\n«missing " + getSupportClassName() + "»\n\n");
			}
			else {
				supportInstance2.format(formatter, serializationBuilder);
			}
		}

		protected CustomSegmentSupport getSupportInstance(@NonNull EObject eObject) {
			CustomSegmentSupport supportInstance2 = supportInstance;
			if (supportInstance2 == null) {
				if ((supportClass == null) && (supportClassName != null)) {
					ClassLoader classLoader = eObject.getClass().getClassLoader();
					try {
						supportClass = classLoader.loadClass(supportClassName);
					} catch (ClassNotFoundException e) {
					//	return null;
					}
				}
				if (supportClass != null) {
					try {
						supportInstance = supportInstance2 = (CustomSegmentSupport) supportClass.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
					//	return null;
					}
				}
			}
			return supportInstance2;
		}

		@Override
		public void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
			CustomSegmentSupport supportInstance2 = getSupportInstance(serializer.getElement());
			if (supportInstance2 == null) {
				serializationBuilder.appendError("\n\n«missing " + getSupportClassName() + "»\n\n");
			}
			else {
				supportInstance2.serialize(serializationStepIndex, serializer, serializationBuilder);
			}
		}

		@Override
		public @NonNull String toString() {
			if (supportClass == PreCommentSerializationSegment.class) {
				return "pre-comment";
			}
			if (supportClass == PostCommentSerializationSegment.class) {
				return "post-comment";
			}
			return getSupportClassName();
		}
	}

	public static class StringSerializationSegment extends AbstractSerializationSegment
	{
		protected final @NonNull String string;

		public StringSerializationSegment(@NonNull String string) {
			this.string = string;
		}

		public @NonNull String getString() {
			return string;
		}

		@Override
		public void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder) {
			serializationBuilder.append(string);
		}

		@Override
		public void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
			serializationBuilder.append(string);
		}

		@Override
		public @NonNull String toString() {
			return string;
		}
	}

	public static class ValueSerializationSegment extends AbstractSerializationSegment
	{
		@Override
		public void format(@NonNull UserElementFormatter formatter, @NonNull SerializationBuilder serializationBuilder) {
			INode node = formatter.getNode();
		//	assert node instanceof ILeafNode;
			String text = node.getText();
			serializationBuilder.append(text);
		}

		@Override
		public boolean isValue() {
			return true;
		}

		@Override
		public void serialize(int serializationStepIndex, @NonNull UserElementSerializer serializer, @NonNull SerializationBuilder serializationBuilder) {
			SerializationRule serializationRule = serializer.getSerializationRule();
			SerializationStep serializationStep = serializationRule.getSerializationSteps()[serializationStepIndex];
			serializationStep.serializeInnerValue(serializationStepIndex, serializer, serializationBuilder);
		}

		@Override
		public @NonNull String toString() {
			return SerializationBuilder.VALUE;
		}
	}

	@Override
	public abstract @NonNull String toString();
}
