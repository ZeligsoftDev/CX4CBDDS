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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.plugin.RegistryReader.PluginClassDescriptor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface RegisteredContribution<@NonNull C extends RegisteredContribution<C>> {

	/**
	 * A registry of contributions.
	 */
	interface Registry<@NonNull C extends RegisteredContribution<C>> {
		@Nullable C get(@NonNull String key);
		@Nullable C put(@NonNull String key, @NonNull C contribution);
		@Nullable C remove(@NonNull String key);
		int size();
	}
	/**
	 * A <code>Factory</code> wrapper that is used by the
	 * {@link Registry}.
	 */
	interface Descriptor<@NonNull C extends RegisteredContribution<C>> extends RegisteredContribution<C> {

		IConfigurationElement getElement();
	}

	abstract class AbstractDescriptor<@NonNull C extends RegisteredContribution<C>> extends PluginClassDescriptor implements Descriptor<C>
	{
		protected @Nullable C contribution;

		public AbstractDescriptor(IConfigurationElement e, String attrName) {
			super(e, attrName);
		}

		protected abstract C createContribution();

		@Override
		public IConfigurationElement getElement() {
			return element;
		}
		
		@Override
		public C getContribution() {
			@Nullable
			C contribution2 = contribution;
			if (contribution2 == null) {
				contribution2 = contribution = createContribution();
			}
			return contribution2;
		}
	}	

	class AbstractRegistry<@NonNull C extends RegisteredContribution<C>> implements Registry<C>
	{
		private final @NonNull Map<String, C>  map = new HashMap<String, C>();

		@Override
		public @Nullable C get(@NonNull String key) {
			@Nullable C contribution = map.get(key);
			return contribution != null ? contribution.getContribution() : null;
		}

		@Override
		public @Nullable C put(@NonNull String key, @NonNull C contribution) {
			return map.put(key, contribution);
		}

		@Override
		public @Nullable C remove(@NonNull String key) {
			return map.remove(key);
		}

		@Override
		public int size() {
			return map.size();
		}
	}

	C getContribution();
}
