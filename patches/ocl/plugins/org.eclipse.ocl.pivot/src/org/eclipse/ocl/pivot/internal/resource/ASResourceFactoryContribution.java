/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.resource;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.library.RegisteredContribution;

public interface ASResourceFactoryContribution extends RegisteredContribution<@NonNull ASResourceFactory>
{
	public static class Descriptor extends AbstractDescriptor<@NonNull ASResourceFactory> implements ASResourceFactoryContribution
	{
		protected final @Nullable Integer priority;

		public Descriptor(@NonNull IConfigurationElement e, @Nullable Integer priority, @NonNull String attrName) {
			super(e, attrName);
			this.priority = priority;
		}

		@Override
		public @Nullable ASResourceFactory basicGetASResourceFactory() {
			return contribution;
		}

		@Override
		public @NonNull ASResourceFactory createContribution() {
			Object createInstance = createInstance();
			return ((ASResourceFactory) createInstance).getASResourceFactory();
		}

		@Override
		public @NonNull ASResourceFactory getASResourceFactory() {
			return getContribution().getASResourceFactory();
		}
		
		@Override
		public @Nullable Integer getPriority() {
			return priority;
		}
	}

	@Nullable ASResourceFactory basicGetASResourceFactory();
	
	@NonNull ASResourceFactory getASResourceFactory();
	
	@Nullable Integer getPriority();
}
