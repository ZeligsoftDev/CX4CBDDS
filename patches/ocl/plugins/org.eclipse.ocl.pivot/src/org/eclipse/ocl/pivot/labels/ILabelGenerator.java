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

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * ILabelGenerator provides an extensible capability to derive a customized text string
 * for an object. This is typically used to provide debug or UI descriptions of objects.
 * <p>
 * Extensibility is provided by registering new label generators with the registry to
 * support additional classes. These may be registered automatically through use of the
 * <code>org.eclipse.ocl.domain.label_generator</code>
 * extension point. 
 * <p>
 * Minor customization can be achieved by using a modified Builder to build the label.
 * The builder can be parameterised by options.
 * <p>
 * Full customization can be achieved by using an alternate Registry with completely
 * different label generators..
 */
public interface ILabelGenerator<T>
{
	/**
	 * An ILabelGenerator.Builder may have options with an associated typed value.
	 */
	interface Option<T> {}
	
	/**
	 * An ILabelGenerator.Builder (typically realised by a StringBuilder)
	 * builds the generated label. The formatting may have options.
	 */
	interface Builder
	{
		
		/**
		 * If the SHOW_CLASS_NAME option is present and true, the value of object.getClass().getName()
		 * is prefixed to the formatted description of each object.
		 */
		static final @NonNull Option<Boolean> SHOW_CLASS_NAME = new Option<Boolean>() {};
		
		/**
		 * If the SHOW_CLASS_SIMPLE_NAME option is present and true, the value of object.getClass().getSimpleName()
		 * is prefixed to the formatted description of each object.
		 */
		static final @NonNull Option<Boolean> SHOW_CLASS_SIMPLE_NAME = new Option<Boolean>() {};
		
		/**
		 * If the SHOW_QUALIFIER option is present its value is used as a separator between a container name and a child name.
		 */
		static final @NonNull Option<String> SHOW_QUALIFIER = new Option<String>() {};
		
		/**
		 * Append the generated label of an object to the overall generated label.
		 * 
		 * @param object to be appended.
		 */
		void appendObject(@Nullable Object object);
		void appendString(@Nullable String string);
		void buildLabelFor(@Nullable Object labelledObject);
		@Nullable Object getLabelledObject();
		@Nullable <T> T getOption(@NonNull Option<T> option);
		<T> boolean hasOption(@NonNull Option<T> option);
		Registry getRegistry();
		<T> void setOption(@NonNull Option<T> option, @Nullable T value);
		@Override
		@NonNull String toString();
	}
	
    /**
     * An <code>ILabelGenerator.Descriptor</code> may be used by the {@link ILabelGenerator.Registry}
     * to defer loading of the labelled class until an instance needs a label.
     */
    interface Descriptor
    {
    	@NonNull ILabelGenerator<?> getLabelGenerator();
    }

    /**
     * An <code>ILabelGenerator.Registry</code> maintains a mapping from the
     * class name to be labelled and the label generator that can build its
     * label. The global <code>INSTANCE</code> is populated by the
     * <code>org.eclipse.ocl.domain.label_generator</code>
     * extension point.
     */
   interface Registry
    {
		@NonNull Registry INSTANCE = LabelGeneratorRegistry.init();

       	<T> void buildLabelFor(ILabelGenerator.@NonNull Builder labelBuilder, @Nullable T labelledObject);
    	<T> void buildSubLabelFor(ILabelGenerator.@NonNull Builder labelBuilder, @Nullable T labelledObject);
    	@Nullable ILabelGenerator<?> get(@NonNull Class<?> labelledClass);
    	@Nullable Object install(@NonNull Class<?> labelledClass, @NonNull ILabelGenerator<?> labelGenerator);
    	@Nullable Object install(@NonNull Class<?> labelledClass, ILabelGenerator.@NonNull Descriptor labelDescriptor);
        @NonNull String labelFor(@Nullable Object labelledObject);
       	@NonNull String labelFor(@Nullable Object labelledObject, @Nullable Map<ILabelGenerator.Option<?>, Object> options);
    	void uninstall(@NonNull Class<?> labelledClass);
    }

	/**
	 * Self defines the interface of an object able to label itself.
	 */
	public interface Self
	{
		public void buildLabel(ILabelGenerator.@NonNull Builder labelBuilder);
	}

    void buildLabelFor(@NonNull Builder labelBuilder, @NonNull T labelledObject);
}