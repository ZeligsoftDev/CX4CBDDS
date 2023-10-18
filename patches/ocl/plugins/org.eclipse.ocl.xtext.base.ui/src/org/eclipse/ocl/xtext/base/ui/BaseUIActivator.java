/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.ui.builder.MultiValidationJob;
import org.eclipse.ocl.xtext.base.ui.internal.BaseActivator;
import org.osgi.framework.BundleContext;

public class BaseUIActivator extends BaseActivator
{
	private static @Nullable MultiValidationJob multiValidationJob = null;

	/* For test purposes only */
	public static @Nullable MultiValidationJob basicGetMultiValidationJob() {
		return multiValidationJob;
	}

	public static synchronized void cancelMultiValidationJob() {
		MultiValidationJob multiValidationJob2 = multiValidationJob;
		if (multiValidationJob2 != null) {
			multiValidationJob2.cancel();
			multiValidationJob = null;
		}
	}

	/**
	 * Return the MultiValidationJob, creating one if none curremtly exists.
	 * Returns null if this plugin has been shutdown.
	 */
	public static synchronized @Nullable MultiValidationJob getMultiValidationJob() {
		if ((multiValidationJob == null) && (getInstance() != null)) {
			multiValidationJob = new MultiValidationJob();
		}
		return multiValidationJob;
	}

	public BaseUIActivator() {
		super();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		cancelMultiValidationJob();
	}
}
