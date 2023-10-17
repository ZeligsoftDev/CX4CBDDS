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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.ValidationDelegateRegistryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A revised interface for delegating validation expression evaluation
 * adopting the same Factory, Registry, Descriptor architecture as the
 * invocation and setting delegates.
 */
public interface ValidationDelegate extends ValidationDelegateExtension // waiting for Bug 337792
{
    
	/**
	 * A factory for creating delegate domains.
	 */
	interface Factory extends EValidator.ValidationDelegate {

		/**
		 * A <code>Factory</code> wrapper that is used by the
		 * {@link Factory.Registry}.
		 */
		interface Descriptor extends EValidator.ValidationDelegate.Descriptor {

			@Override
			ValidationDelegate.@Nullable Factory getValidationDelegate();
		}

		/**
		 * A registry of delegate domain factories.
		 */
		interface Registry extends EValidator.ValidationDelegate.Registry {

			@Override
			ValidationDelegate.Factory getValidationDelegate(String uri);

			class Impl extends ValidationDelegateRegistryImpl implements Factory.Registry {

				private static final long serialVersionUID = 1L;

				@Override
				public ValidationDelegate.Factory getValidationDelegate(String uri) {
					return (ValidationDelegate.Factory) get(uri);
				}
			}
		}

		@Nullable ValidationDelegate createValidationDelegate(@NonNull EClassifier eClassifier);

		@NonNull String getURI();
	}
}