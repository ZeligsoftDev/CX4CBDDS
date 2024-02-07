/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * Activator Plugin for UML Papyrus Compare.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class UMLPapyrusComparePlugin extends Plugin {

	/** The plugin ID. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.compare.uml2"; //$NON-NLS-1$

	/** This plug-in's shared instance. */
	private static UMLPapyrusComparePlugin plugin;

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static UMLPapyrusComparePlugin getDefault() {
		return plugin;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
}
