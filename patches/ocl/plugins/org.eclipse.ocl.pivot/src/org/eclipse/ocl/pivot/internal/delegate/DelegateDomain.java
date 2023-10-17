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
package org.eclipse.ocl.pivot.internal.delegate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A pluggable, dynamic implementation of a delegate domain supervising
 * delegated behavior.
 */
public interface DelegateDomain {

	/**
	 * A factory for creating delegate domains.
	 */
	interface Factory {
		/**
		 * The global instance used when no factory is registered.
		 */
		Factory INSTANCE = new OCLDelegateDomainFactory();

		/**
		 * Creates the delegate domain for the specified <tt>ePackage</tt>.
		 * 
		 * @param ePackage
		 *            the package
		 * @return its delegate domain
		 */
		@NonNull DelegateDomain createDelegateDomain(@NonNull String delegateURI, @NonNull EPackage ePackage);

		/**
		 * A <code>Factory</code> wrapper that is used by the
		 * {@link Factory.Registry}.
		 */
		interface Descriptor {

			DelegateDomain.Factory getFactory();
		}

		/**
		 * A registry of delegate domain factories.
		 */
		interface Registry
				extends Map<String, Object> {

			Factory.@NonNull Registry INSTANCE = new Impl();

			DelegateDomain.Factory getFactory(@NonNull String uri);

			class Impl
					extends HashMap<String, Object>
					implements Factory.Registry {

				private static final long serialVersionUID = 1L;

				@Override
				public Object get(Object key) {
					Object factory = super.get(key);
					if (factory instanceof Factory.Descriptor) {
						Factory.Descriptor factoryDescriptor = (Factory.Descriptor) factory;
						factory = factoryDescriptor.getFactory();
						put((String) key, factory);
						return factory;
					} else {
						return factory;
					}
				}

				@Override
				public DelegateDomain.Factory getFactory(@NonNull String uri) {
					return (DelegateDomain.Factory) get(uri);
				}
			}
		}
	}

	static final @NonNull List<DelegateDomain> EMPTY_LIST = Collections.emptyList();

	/**
	 * Get the delegate domain name.
	 * 
	 * @return the delegate URI
	 */
	@NonNull String getURI();

	/**
	 * Reset this delegate domain releasing any resources cached to support
	 * delegated behaviour for the associated package. They can be lazily recreated.
	 */
	void reset();
}