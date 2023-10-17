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

package org.eclipse.ocl.pivot.internal.evaluation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Adaptable;
import org.eclipse.ocl.pivot.utilities.Customizable;
import org.eclipse.ocl.pivot.utilities.Option;

/**
 * A partial implementation of the {@link Adaptable} and {@link Customizable} interfaces,
 * providing some useful common behaviors.  Implementors of metamodel-specific
 * environments are encourage to extend this class rather than implement
 * an evaluation environment "from scratch."
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractCustomizable implements Adaptable, Customizable
{
	private final @NonNull Map<Option<?>, Object> options = new java.util.HashMap<Option<?>, Object>();

	protected final @NonNull Map<Option<?>, Object> basicGetOptions() {
	    return options;
	}

	@Override
	public @NonNull Map<Option<?>, Object> clearOptions() {
		Map<Option<?>, Object> myOptions = options;
		
		Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
				myOptions);
		
		myOptions.clear();
		
		return result;
	}

	/**
	 * Implements the interface method by testing whether I am an instance of
	 * the requested adapter type.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> @Nullable T getAdapter(java.lang.Class<T> adapterType) {
		if (adapterType.isInstance(this)) {
			return (T) this;
		} 
		return null;
	}
	
	@Override
	public Map<Option<?>, Object> getOptions() {
		Customizable parent2 = getParent();
		Map<Option<?>, Object> result = (parent2 != null)
			? new HashMap<Option<?>, Object>(parent2.getOptions())
		    : new HashMap<Option<?>, Object>();
		
		result.putAll(options);
		
		return result;
	}

	protected abstract @Nullable Customizable getParent();
	
	@Override
	public <@Nullable T> T getValue(@NonNull Option<T> option) {
		@SuppressWarnings("unchecked") T result = (T) getOptions().get(option);
		if (result != null) {
			return result;
		}
		Customizable parent2 = getParent();
		if (parent2 != null) {
			return parent2.getValue(option);
		}
		return option.getDefaultValue();
	}

    @Override
	public boolean isEnabled(@NonNull Option<@Nullable Boolean> option) {
		Boolean result = getValue(option);
		return (result == null)? false : result.booleanValue();
	}

	@Override
	public <@Nullable T> void putOptions(@NonNull Map<? extends Option<T>, ? extends T> newOptions) {
		Map<Option<?>, Object> myOptions = options;	
		myOptions.clear();
		myOptions.putAll(newOptions);
	}

	@Override
	public <@Nullable T> @Nullable T removeOption(@NonNull Option<T> option) {
		@Nullable T result = getValue(option);	
		options.remove(option);	
		return result;
	}
	
	@Override
	public <@Nullable T> @NonNull Map<Option<T>, T> removeOptions(@NonNull Collection<Option<T>> unwantedOptions) {
		Map<Option<T>, T> result = new HashMap<Option<T>, T>();	
		Map<Option<?>, Object> myOptions = options;		
		for (Option<T> next : unwantedOptions) {
			if (next != null) {
				result.put(next, getValue(next));
				myOptions.remove(next);
			}
		}		
		return result;
	}

	@Override
	public <T> void setOption(@NonNull Option<T> option, @Nullable T value) {
		options.put(option, value);
	}
}
