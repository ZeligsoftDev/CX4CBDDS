/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.labels.BooleanLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ClassLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.DynamicEObjectImplLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.EAnnotationLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.EGenericTypeLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ENamedElementLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.EObjectLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.EcoreURILabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ElementIdLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ExpressionInOCLLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.FileLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ModelLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.NameableLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.NumberLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ResourceLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.StringLabelGenerator;
import org.eclipse.ocl.pivot.internal.labels.ValueLabelGenerator;
import org.eclipse.ocl.pivot.internal.plugin.LabelGeneratorRegistryReader;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Descriptor;

/**
 * DebugString supports generation of debug identification of objects, determining a name usuing
 * the following alternatives.
 * <br>The null object is identified as <null-Object>
 * <br>Implementers of IDebugString are identified by IDebugString.toDebugString();
 * <br>MethodCall registrations in DebugUtils are identified by MethodCall.invoke().
 * <br>Other objects are identified as <unknown-'class-name' 'object.toString()'>
 * <p>
 * MethodCall registrations may be made via registerInstanceMethod or registerStaticMethod.
 * <p>
 * A debug string may be obtained via DebugString.toDebug(object).
 * <p>
 * DebugString providers string formatters for simple classes such as String, Number, Boolean
 * and Ecore components such as EObject, Resource and ResourceSet.
 * <p>
 * User extensions should be registered prior to use. Beware that late registration can
 * give misleading results since in the absence of an exact MethodCall registration the
 * class hierarchy is search first for base classes then for instances for which there
 * is an exact MethodCall match. This result is then cached and so may occlude a late
 * registration.
 */
public class LabelGeneratorRegistry implements ILabelGenerator.Registry
{
	public static class Global extends LabelGeneratorRegistry
	{
		private boolean initialized = false;

		public Global() {}

		public void initialize() {
			initialized = true;
			if (EcorePlugin.IS_ECLIPSE_RUNNING) {
				new LabelGeneratorRegistryReader(this).readRegistry();
			}
			else {
				initialize(this);
			}
		}

		@Override
		public @Nullable ILabelGenerator<?> get(@NonNull Class<?> labelledClass) {
			if (!initialized) {
				initialize();
			}
			return super.get(labelledClass);
		}

		@Override
		public @Nullable Object install(@NonNull Class<?> labelledClass, @NonNull Descriptor labelDescriptor) {
			if (!initialized) {
				initialize();
			}
			return super.install(labelledClass, labelDescriptor);
		}

		@Override
		public @Nullable Object install(@NonNull Class<?> labelledClass, @NonNull ILabelGenerator<?> labelGenerator) {
			if (!initialized) {
				initialize();
			}
			return super.install(labelledClass, labelGenerator);
		}

		@Override
		public void uninstall(@NonNull Class<?> labelledClass) {
			if (!initialized) {
				initialize();
			}
			super.uninstall(labelledClass);
		}
	}

	public static @NonNull String debugLabelFor(@NonNull Object object) {
		Map<ILabelGenerator.Option<?>, Object> options = new HashMap<ILabelGenerator.Option<?>, Object>();
		options.put(ILabelGenerator.Builder.SHOW_CLASS_SIMPLE_NAME, Boolean.TRUE);
		ILabelGenerator.Builder result = new DefaultLabelGeneratorBuilder(INSTANCE, object, options);
		result.buildLabelFor(object);
		return result.toString();
	}

	public static @NonNull LabelGeneratorRegistry init() {
		return new LabelGeneratorRegistry.Global();
	}

	public static void initialize(ILabelGenerator.@NonNull Registry registry) {
		BooleanLabelGenerator.initialize(registry);
		ClassLabelGenerator.initialize(registry);
		DynamicEObjectImplLabelGenerator.initialize(registry);
		EAnnotationLabelGenerator.initialize(registry);
		EGenericTypeLabelGenerator.initialize(registry);
		ENamedElementLabelGenerator.initialize(registry);
		EObjectLabelGenerator.initialize(registry);
		EcoreURILabelGenerator.initialize(registry);
		ElementIdLabelGenerator.initialize(registry);
		ExpressionInOCLLabelGenerator.initialize(registry);
		FileLabelGenerator.initialize(registry);
		ModelLabelGenerator.initialize(registry);
		NameableLabelGenerator.initialize(registry);
		NumberLabelGenerator.initialize(registry);
		ResourceLabelGenerator.initialize(registry);
		StringLabelGenerator.initialize(registry);
		ValueLabelGenerator.initialize(registry);
	}

	protected final ILabelGenerator.@Nullable Registry delegate;
	private final @NonNull Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

	/**
	 * Construct a registry that resolves label generators locally.
	 */
	private LabelGeneratorRegistry() {
		this.delegate = null;
	}

	/**
	 * Construct a registry that resolves label generators locally when possible
	 * but which delegates to delegate otherwise.
	 */
	public LabelGeneratorRegistry(ILabelGenerator.@Nullable Registry delegate) {
		this.delegate = delegate;
	}

	@Override
	public <T> void buildLabelFor(ILabelGenerator.@NonNull Builder s, @Nullable T labelledObject) {
		if (labelledObject == null) {
			s.appendString("<null-Object>");
			return;
		}
		Boolean showClassName = s.getOption(ILabelGenerator.Builder.SHOW_CLASS_NAME);
		if ((showClassName != null) && (showClassName == Boolean.TRUE)) {
			s.appendString(labelledObject.getClass().getName());
			s.appendString(" ");
		}
		else {
			Boolean showClassSimpleName = s.getOption(ILabelGenerator.Builder.SHOW_CLASS_SIMPLE_NAME);
			if ((showClassSimpleName != null) && (showClassSimpleName == Boolean.TRUE)) {
				s.appendString(labelledObject.getClass().getSimpleName());
				s.appendString(" ");
			}
		}
		if (labelledObject instanceof EObject) {
			EObject eContainer = ((EObject)labelledObject).eContainer();
			if (eContainer != null) {
				String showQualifier = s.getOption(ILabelGenerator.Builder.SHOW_QUALIFIER);
				if (showQualifier != null) {
					buildLabelFor(s, eContainer);
					if (s.toString().length() > 0) {
						s.appendString(showQualifier);
					}
				}
			}
		}
		if (labelledObject instanceof ILabelGenerator.Self) {
			((ILabelGenerator.Self)labelledObject).buildLabel(s);
			return;
		}
		buildSubLabelFor(s, labelledObject);
	}

	@Override
	public <T> void buildSubLabelFor(ILabelGenerator.@NonNull Builder labelBuilder, @Nullable T labelledObject) {
		if (labelledObject == null) {
			labelBuilder.appendString("<null-Object>");
			return;
		}
		Class<? extends Object> labelledObjectClass = labelledObject.getClass();
		ILabelGenerator<?> labelGenerator = get(labelledObjectClass);
		if (labelGenerator == null) {
			labelGenerator = getLabelGenerator(labelledObjectClass);
			if (labelGenerator != null)
				install(labelledObjectClass, labelGenerator);
		}
		if (labelGenerator != null) {
			@SuppressWarnings("unchecked")
			ILabelGenerator<T> castLabelGenerator = (ILabelGenerator<T>) labelGenerator;
			castLabelGenerator.buildLabelFor(labelBuilder, labelledObject);
			return;
		}
		else {
			getLabelGenerator(labelledObjectClass);		// Debugging
		}
		labelBuilder.appendString("<unknown-");
		labelBuilder.appendString(labelledObjectClass.getSimpleName());
		labelBuilder.appendString(" ");
		labelBuilder.appendString(labelledObject.toString());
		labelBuilder.appendString(">");
	}

	public ILabelGenerator.@NonNull Builder createDefaultLabelBuilder(@Nullable Object labelledObject, @Nullable Map<ILabelGenerator.Option<?>, Object> options) {
		return new DefaultLabelGeneratorBuilder(this, labelledObject, options);
	}

	@Override
	public @Nullable ILabelGenerator<?> get(@NonNull Class<?> labelledClass) {
		Object object;
		synchronized(map) {
			object = map.get(labelledClass);
			if (object instanceof ILabelGenerator.Descriptor) {
				object = ((ILabelGenerator.Descriptor)object).getLabelGenerator();
				map.put(labelledClass, object);
			}
		}
		if (object != null) {
			return (ILabelGenerator<?>)object;
		}
		else if (delegate != null) {
			return delegate.get(labelledClass);
		}
		else {
			return null;
		}
	}

	protected @Nullable ILabelGenerator<?> getLabelGenerator(@NonNull Class<?> cls) {
		for (Class<?> sCls = cls; sCls != null; sCls = sCls.getSuperclass()) {
			ILabelGenerator<?> labelGenerator = get(sCls);
			if (labelGenerator != null)
				return labelGenerator;
		}
		for (@SuppressWarnings("null")@NonNull Class<?> iCls : cls.getInterfaces()) {
			ILabelGenerator<?> labelGenerator = get(iCls);
			if (labelGenerator != null)
				return labelGenerator;
		}
		for (@SuppressWarnings("null")@NonNull Class<?> iCls : cls.getInterfaces()) {
			ILabelGenerator<?> labelGenerator = getLabelGenerator(iCls);
			if (labelGenerator != null)
				return labelGenerator;
		}
		Class<?> sCls = cls.getSuperclass();
		if (sCls != null)
			return getLabelGenerator(sCls);
		return null;
	}

	@Override
	public @Nullable Object install(@NonNull Class<?> labelledClass, @NonNull Descriptor labelDescriptor) {
		synchronized(map) {
			return map.put(labelledClass, labelDescriptor);
		}
	}

	@Override
	public @Nullable Object install(@NonNull Class<?> labelledClass, @NonNull ILabelGenerator<?> labelGenerator) {
		synchronized(map) {
			return map.put(labelledClass, labelGenerator);
		}
	}

	@Override
	public @NonNull String labelFor(@Nullable Object labelledObject) {
		ILabelGenerator.Builder labelBuilder = createDefaultLabelBuilder(labelledObject, null);
		labelBuilder.buildLabelFor(labelledObject);
		return labelBuilder.toString();
	}

	@Override
	public @NonNull String labelFor(@Nullable Object labelledObject, @Nullable Map<ILabelGenerator.Option<?>, Object> options) {
		ILabelGenerator.Builder labelBuilder = createDefaultLabelBuilder(labelledObject, options);
		labelBuilder.buildLabelFor(labelledObject);
		return labelBuilder.toString();
	}

	@Override
	public void uninstall(@NonNull Class<?> labelledClass) {
		synchronized(map) {
			for (Class<?> aClass : new ArrayList<Class<?>>(map.keySet()))
			{
				if (labelledClass.isAssignableFrom(aClass)) {
					map.remove(aClass);
				}
			}
		}
	}
}