/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.validation.provider.java;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.zeligsoft.base.validation.l10n.Messages;

/**
 * Implementation of a Java constraint from a ZDL model.
 * 
 * @author Christian W. Damus (cdamus)
 */
class JavaConstraint
		extends ModelConstraint {

	private String host;

	private String className;

	private AbstractModelConstraint delegate;

	/**
	 * Initializes me with the name of the Java class that I load and the bundle
	 * from which I load it, as well as my constraint-descriptor.
	 * 
	 * @param className
	 *            my Java class name
	 * @param host
	 *            my host bundle symbolic name
	 * @param descriptor
	 *            my constraint descriptor
	 */
	public JavaConstraint(String className, String host,
			IConstraintDescriptor descriptor) {
		super(descriptor);

		this.className = className;
		this.host = host;
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		return getDelegate().validate(ctx);
	}

	private AbstractModelConstraint getDelegate() {
		if (delegate == null) {
			Bundle bundle = Platform.getBundle(host);

			if (bundle == null) {
				// results in the constraint being disabled with a log message
				throw new IllegalArgumentException(
					NLS.bind(Messages.JavaConstraint_noBundle, host));
			}

			try {
				@SuppressWarnings("unchecked")
				Class<AbstractModelConstraint> clazz = (Class<AbstractModelConstraint>) bundle
					.loadClass(className);
				delegate = clazz.newInstance();
			} catch (ClassNotFoundException e) {
				// results in the constraint being disabled with a log message
				throw new IllegalArgumentException(NLS.bind(
					Messages.JavaConstraint_noSuchClass, className, host), e);
			} catch (IllegalAccessException e) {
				// results in the constraint being disabled with a log message
				throw new RuntimeException(NLS.bind(
					Messages.JavaConstraint_classAccess, className, host), e);
			} catch (InstantiationException e) {
				// results in the constraint being disabled with a log message
				throw new RuntimeException(NLS.bind(
					Messages.JavaConstraint_instantiation, className, host), e);
			}
		}

		return delegate;
	}
}
