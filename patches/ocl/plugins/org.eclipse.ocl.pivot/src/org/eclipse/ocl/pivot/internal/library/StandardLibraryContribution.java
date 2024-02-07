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
package org.eclipse.ocl.pivot.internal.library;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;

public interface StandardLibraryContribution extends RegisteredContribution<@NonNull StandardLibraryContribution>
{
	/**
	 * @since 1.17
	 */
	public static final @NonNull TracingOption STANDARD_LIBRARY_CONTRIBUTION = new TracingOption(PivotPlugin.PLUGIN_ID, "standardLibraryContribution");

	static @NonNull Registry<@NonNull StandardLibraryContribution> REGISTRY = new AbstractRegistry<@NonNull StandardLibraryContribution>()
	{

		@Override
		public @Nullable StandardLibraryContribution put(@NonNull String key, @NonNull StandardLibraryContribution contribution) {
			if (STANDARD_LIBRARY_CONTRIBUTION.isActive()) {
				STANDARD_LIBRARY_CONTRIBUTION.println(NameUtil.debugSimpleName(this) +  ": put " + key + " => " + contribution);
			}
			return super.put(key, contribution);
		}

		@Override
		public @Nullable StandardLibraryContribution remove(@NonNull String key) {
			if (STANDARD_LIBRARY_CONTRIBUTION.isActive()) {
				STANDARD_LIBRARY_CONTRIBUTION.println(NameUtil.debugSimpleName(this) +  ": remove " + key);
			}
			return super.remove(key);
		}

	};

	static class Descriptor extends AbstractDescriptor<@NonNull StandardLibraryContribution> implements StandardLibraryContribution
	{
		protected StandardLibraryContribution contribution;

		public Descriptor(@NonNull IConfigurationElement e, @NonNull String attrName) {
			super(e, attrName);
		}

		@Override
		protected @NonNull StandardLibraryContribution createContribution() {
			Object createInstance = createInstance();
			assert createInstance != null;
			return (StandardLibraryContribution) createInstance;
		}

		@Override
		public @NonNull Resource getResource() {
			return getContribution().getResource();
		}
	}

/*	static final class Null implements StandardLibraryContribution
	{
		public StandardLibraryContribution getContribution() {
			return this;
		}

		public Resource getResource() {
			return null;
		}
	} */

	/**
	 * A Null contribution may be installed to exploit the manually loaded content
	 * as the standard library.
	 */
//	static StandardLibraryContribution NULL = new Null();

	/**
	 * Return the resource containing the contribution to the standard library.
	 *
	 * @return the contributing resource.
	 */
	@NonNull Resource getResource();
}
