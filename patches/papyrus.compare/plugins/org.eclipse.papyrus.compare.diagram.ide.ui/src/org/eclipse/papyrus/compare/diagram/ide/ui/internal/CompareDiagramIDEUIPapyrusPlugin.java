/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Stefan Dirix - bug 487595
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:laurent.delaigue@obeo.fr">Laurent Delaigue</a>
 */
public class CompareDiagramIDEUIPapyrusPlugin extends AbstractUIPlugin {

	/** ID of this plug-in. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.compare.diagram.ide.ui"; //$NON-NLS-1$

	/** The shared instance. */
	private static CompareDiagramIDEUIPapyrusPlugin plugin;

	/** The Papyrus Label Provder. */
	private LabelProviderService labelProviderService;

	/**
	 * The constructor.
	 */
	public CompareDiagramIDEUIPapyrusPlugin() {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (labelProviderService != null) {
			try {
				labelProviderService.disposeService();
			} catch (ServiceException ex) {
				plugin.getLog().log(new Status(IStatus.WARNING, PLUGIN_ID,
						"Unable to dispose Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static CompareDiagramIDEUIPapyrusPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the Papyrus Label Provider service. If the service does not exist yet it will be created.
	 * 
	 * @return the Papyrus Label Provider service. Can be {@code null} if the service can not be started.
	 * @since 2.5
	 */
	public LabelProviderService getLabelProviderService() {
		if (labelProviderService == null) {
			labelProviderService = new LabelProviderServiceImpl();
			try {
				labelProviderService.startService();
			} catch (ServiceException ex) {
				// prevent service from being used if it could not be started
				labelProviderService = null;
				getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID,
						"Unable to start Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		return labelProviderService;
	}

}
