/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.ocl.xtext.oclinecore.ui.internal.OCLinEcoreActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class OCLinEcoreExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return OCLinEcoreActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return OCLinEcoreActivator.getInstance().getInjector(OCLinEcoreActivator.ORG_ECLIPSE_OCL_XTEXT_OCLINECORE_OCLINECORE);
	}

}
