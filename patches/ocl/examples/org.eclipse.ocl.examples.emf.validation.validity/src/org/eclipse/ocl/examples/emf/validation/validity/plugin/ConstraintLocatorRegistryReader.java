/*******************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	E.D.Willink (CEA LIST) - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.emf.validation.validity.plugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.emf.validation.validity.locator.ConstraintLocator;
import org.eclipse.ocl.examples.emf.validation.validity.manager.ValidityManager;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getContentTypeToFactoryMap()
 * content type} map. Clients are not expected to use this class directly.
 */
class ConstraintLocatorRegistryReader extends RegistryReader
{
	static final @NonNull String TAG_LOCATOR = "locator";
	static final @NonNull String ATT_METACLASS = "metaclass";
	static final @NonNull String ATT_CLASS = "class";

	static class ConstraintLocatorDescriptor extends PluginClassDescriptor implements ConstraintLocator.Descriptor
	{
		protected final @Nullable String uri;
		protected /*@LazyNonNull*/ ConstraintLocator constraintLocator = null;
		protected boolean failed = false;

		public ConstraintLocatorDescriptor(@NonNull IConfigurationElement e, @Nullable String uri, @NonNull String className) {
			super(e, className);
			this.uri = uri;
		}

		public @NonNull ConstraintLocator getConstraintLocator() {
			ConstraintLocator constraintLocator2 = constraintLocator;
			if (constraintLocator2 == null) {
				if (failed) {
					throw new IllegalStateException();
				}
				try {
					constraintLocator2 = (ConstraintLocator) createInstance();
					assert constraintLocator2 != null;
					constraintLocator = constraintLocator2;
				}
				catch (Throwable e) {
					throw new IllegalStateException(e);
				}
			}
			return constraintLocator2;
		}

		@Override
		public @Nullable String toString() {
			return uri;
		}
	}

	public ConstraintLocatorRegistryReader() {
		super(RegistryFactory.getRegistry(), ValidityPlugin.INSTANCE.getSymbolicName(), ValidityPlugin.CONSTRAINT_LOCATOR_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_LOCATOR)) {
			String metaclass = element.getAttribute(ATT_METACLASS);
			if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else {
				if (add) {
					ConstraintLocatorDescriptor descriptor = new ConstraintLocatorDescriptor(element, metaclass, ATT_CLASS);
					ValidityManager.addConstraintLocator(metaclass, descriptor);
				} else {
//					ValidityManager.removeConstraintLocator(metaclass);
				}
				return true;
			}
		}

		return false;
	}
}
