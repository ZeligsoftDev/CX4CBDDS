/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.oclinecore.ui;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.ocl.xtext.oclinecore.ui.internal.OCLinEcoreActivator;

public class OCLinEcoreUiPluginHelper extends EMFPlugin.InternalHelper
{
	public static final OCLinEcoreUiPluginHelper INSTANCE = new OCLinEcoreUiPluginHelper(OCLinEcoreActivator.getInstance());

	private OCLinEcoreUiPluginHelper(Plugin plugin) {
		super(plugin);
	}

	public Status createErrorStatus(Exception e) {
		return new Status(Status.ERROR, getSymbolicName(), e.getMessage(), e);
	}
}
