/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.library.executor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


public class DomainProperties
{
	protected final @NonNull CompleteInheritance inheritance;
	protected final @NonNull Map<String, Property> name2property = new HashMap<String, Property>();

	public DomainProperties(@NonNull CompleteInheritance inheritance) {
		this.inheritance = inheritance;
		InheritanceFragment selfFragment = inheritance.getSelfFragment();
		for (@NonNull Property property : selfFragment.getLocalProperties()) {
			name2property.put(property.getName(), property);
		}
	}

	public @NonNull Iterable<? extends Property> getAllProperties(final @Nullable FeatureFilter featureFilter) {
		@NonNull Collection<Property> values = name2property.values();
		if (featureFilter == null) {
			return values;
		}
		@NonNull Iterable<Property> subItOps = Iterables.filter(values,
			new Predicate<Property>()
		{
			@Override
			public boolean apply(Property domainProperty) {
				return (domainProperty != null) && featureFilter.accept(domainProperty);
			}
		});
		return subItOps;
	}

	public @Nullable Property getMemberProperty(@NonNull String name) {
		return name2property.get(name);
	}
}
