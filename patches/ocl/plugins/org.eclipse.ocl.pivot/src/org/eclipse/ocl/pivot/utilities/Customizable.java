/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *******************************************************************************/

package org.eclipse.ocl.pivot.utilities;

import java.util.Collection;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;


/**
 * An {@linkplain Adaptable optional adapter interface} for entities whose
 * behaviour can be customized by clients by the application of {@link Option}s.
 * The primary customizable entities are parsing {@link EnvironmentFactory}s and
 * {@link EvaluationEnvironment}s.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface Customizable {
    /**
     * Obtains a copy of my map of options.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @return the map of options
     */
    Map<Option<?>, Object> getOptions();
    
    /**
     * Obtains the value of the specified option's setting in the my
     * options map.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @param option the option to query
     * 
     * @return value of the option
     */
    <@Nullable T> T getValue(@NonNull Option<T> option);
    
    /**
     * Queries whether the specified boolean-valued option is enabled.
     * This method essentially just puts a nice "is" name on boolean options.
     * Options not explicitly set in an environment are inherited from the
     * parent environment, if any, otherwise they are at their
     * {@linkplain Option#getDefaultValue() default values}.
     * 
     * @param option an option
     * 
     * @return whether the option is enabled
     */
    boolean isEnabled(@NonNull Option<@Nullable Boolean> option);
    
    /**
     * Add an option to apply to my behaviour.
     * 
     * @param option the option
     * @param value the option's value
     */
    <T> void setOption(@NonNull Option<T> option, @Nullable T value);
    
    /**
     * Adds options to apply to my behaviour.
     * 
     * @param options the options
     */
    <@Nullable T> void putOptions(@NonNull Map<? extends Option<T>, ? extends T> options);
    
    /**
     * Removes the specified option.
     * 
     * @param option the option to remove
     * 
     * @return the former value of the option
     */
    <@Nullable T> @Nullable T removeOption(@NonNull Option<T> option);
    
    /**
     * Removes the specified options.
     * 
     * @param options the options to remove
     * 
     * @return the former values of the options
     */
    <@Nullable T> @NonNull Map<Option<T>, T> removeOptions(@NonNull Collection<Option<T>> options);
    
    /**
     * Clears all options.
     * 
     * @return the former values of the options
     */
    @NonNull Map<Option<?>, Object> clearOptions();

}
