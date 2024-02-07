/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.context;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

/**
 * PropertyContext supports parsing OCL expressions in the context of a Property.
 */
public class PropertyContext extends ClassContext
{
	protected final @NonNull Property property;

	public PropertyContext(@NonNull EnvironmentFactory environmentFactory, @Nullable URI uri, @NonNull Property property) {
		super(environmentFactory, uri, ClassUtil.nonNullModel(property.getOwningClass()), null);
		this.property = property;
	}

	@Override
	public @Nullable Element getElementContext() {
		return property;
	}

	/**
	 * @since 1.4
	 */
	@Override
	protected Element getMessageContext() {
		return getProperty();
	}

	public @NonNull Property getProperty() {
		return property;
	}
}
