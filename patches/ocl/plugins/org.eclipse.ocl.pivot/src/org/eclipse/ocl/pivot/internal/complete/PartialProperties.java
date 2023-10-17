/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.complete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView.Disambiguator;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

import com.google.common.collect.Iterators;

public class PartialProperties implements Iterable<@NonNull Property>
{
	//resolution = null, partials = null or empty => empty
	// resolution = X, partials = null or empty or [X} => X
	// resolution = null, partials not empty => lazy unresolved 'ambiguity'
	private boolean isResolved = false;
	private @Nullable Property resolution = null;
	private @Nullable List<@NonNull Property> partials = null;
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;

	public PartialProperties(@NonNull EnvironmentFactoryInternal environmentFactory) {
		this.environmentFactory = environmentFactory;
	}

	public synchronized void didAddProperty(@NonNull Property pivotProperty) {
		List<@NonNull Property> partials2 = partials;
		@Nullable
		Property resolution2 = resolution;
		if (partials2 == null) {
			if (resolution2 == null) {
				resolution2 = resolution = pivotProperty;
				isResolved = true;
			}
			else {
				partials = partials2 = new ArrayList<@NonNull Property>();
				partials2.add(resolution2);
				if (resolution2 != pivotProperty) {
					partials2.add(pivotProperty);
				}
				resolution2 = resolution = null;
				isResolved = false;
			}
		}
		else if (partials2.isEmpty()) {
			if (resolution2 == null) {
				resolution2 = resolution = pivotProperty;
				isResolved = true;
			}
			else {
				partials2.add(resolution2);
				if (resolution2 != pivotProperty) {
					partials2.add(pivotProperty);
				}
				resolution2 = resolution = null;
				isResolved = false;
			}
		}
		else {
			if (!partials2.contains(pivotProperty)) {
				partials2.add(pivotProperty);
			}
			resolution2 = resolution = null;
			isResolved = false;
		}
	}

	public boolean didRemoveProperty(@NonNull Property pivotProperty) {
		remove(pivotProperty);
		return isEmpty();
	}

	public synchronized @Nullable Property get() {
		if (isResolved) {
			return resolution;
		}
		resolve();
		if (isResolved) {
			return resolution;
		}
		List<@NonNull Property> values = new ArrayList<@NonNull Property>(partials);
		Map<@NonNull Type, @NonNull Property> primaryProperties = new HashMap<@NonNull Type, @NonNull Property>();
		for (@NonNull Property property : values) {
			org.eclipse.ocl.pivot.Class owningType = property.getOwningClass();
			if (owningType != null) {
				Type domainType = environmentFactory.getMetamodelManager().getPrimaryType(owningType);
				if (!primaryProperties.containsKey(domainType)) {
					primaryProperties.put(domainType, property);	// FIXME something more deterministic than first
				}
			}
		}
		if (primaryProperties.size() == 1) {
			resolution = primaryProperties.values().iterator().next();
			isResolved = true;
			return resolution;
		}
		isResolved = true;
		resolution = null;
		return resolution;
	}

	/**
	 * @since 1.5
	 */
	public @Nullable Iterable<@NonNull Property> getPartials() {
		return partials != null ? partials : null;
	}

	public synchronized boolean isEmpty() {
		if (resolution != null) {
			return false;
		}
		List<Property> partials2 = partials;
		if (partials2 == null) {
			return true;
		}
		return partials2.size() <= 0;
	}

	@Override
	public @NonNull Iterator<@NonNull Property> iterator() {
		if (!isResolved) {
			resolve();
		}
		if (resolution != null) {
			return Iterators.singletonIterator(resolution);
		}
		else if (partials != null) {
			return partials.iterator();
		}
		else {
			return ClassUtil.emptyIterator();
		}
	}

	public synchronized void remove(@NonNull Property pivotProperty) {
		if (pivotProperty == resolution) {
			resolution = null;
		}
		if (partials != null) {
			partials.remove(pivotProperty);
		}
	}

	private void resolve() {
		assert !isResolved;
		List<Property> partials2 = partials;
		if (partials2 == null) {
			return;
		}
		int size = partials2.size();
		if (size <= 0) {
			return;
		}
		if (size == 1) {
			isResolved = true;
			resolution = partials2.get(0);
		}
		List<Property> values = new ArrayList<Property>(partials);
		for (int i = 0; i < values.size()-1;) {
			boolean iRemoved = false;
			@SuppressWarnings("null") @NonNull Property iValue = values.get(i);
			for (int j = i + 1; j < values.size();) {
				Class<? extends Property> iClass = iValue.getClass();
				@SuppressWarnings("null") @NonNull Property jValue = values.get(j);
				Class<? extends Property> jClass = jValue.getClass();
				int verdict = 0;
				for (Class<?> key : EnvironmentView.getDisambiguatorKeys()) {
					if (key.isAssignableFrom(iClass) && key.isAssignableFrom(jClass)) {
						List<Comparator<Object>> disambiguators = EnvironmentView.getDisambiguators(key);
						if (disambiguators != null) {
							for (Comparator<Object> comparator : disambiguators) {
								if (comparator instanceof Disambiguator<?>) {
									verdict = ((Disambiguator<@NonNull Object>)comparator).compare(environmentFactory, iValue, jValue);
								}
								else {
									verdict = comparator.compare(iValue, jValue);
								}
								if (verdict != 0) {
									break;
								}
							}
						}
						if (verdict != 0) {
							break;
						}
					}
				}
				if (verdict == 0) {
					j++;
				} else if (verdict < 0) {
					values.remove(i);
					iRemoved = true;
					break;
				} else {
					values.remove(j);
				}
			}
			if (!iRemoved) {
				i++;
			}
		}
		if (values.size() == 1) {
			resolution = values.get(0);
			isResolved = true;
			return;
		}
	}

	@Override
	public String toString() {
		if (resolution != null) {
			return resolution.toString();
		}
		List<Property> partials2 = partials;
		if (partials2 == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (Property dProperty : partials2) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(dProperty.toString());
		}
		return s.toString();
	}
}