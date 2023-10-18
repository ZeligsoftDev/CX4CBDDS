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
package org.eclipse.ocl.xtext.oclstdlib.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.ocl.xtext.oclstdlib.ui.internal.OCLstdlibActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class OCLstdlibExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return OCLstdlibActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return OCLstdlibActivator.getInstance().getInjector(OCLstdlibActivator.ORG_ECLIPSE_OCL_XTEXT_OCLSTDLIB_OCLSTDLIB);
	}

}
