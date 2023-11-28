/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Alexandra Buzila - bug 483798
 *     Christian W. Damus - bug 529253
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.edit;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.compare.uml2.edit"; //$NON-NLS-1$

	/** The shared instance. */
	private static Activator plugin;

	/** The label provider service. */
	private LabelProviderService labelProviderService;

	private ResourceLocator resourceLocator;

	/**
	 * The constructor.
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (labelProviderService != null) {
			try {
				labelProviderService.disposeService();
			} catch (ServiceException ex) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID,
						"Unable to dispose Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the Papyrus {@link LabelProviderService}.
	 * 
	 * @return the label provider service or <code>null</code> if the service could not be started
	 */
	public LabelProviderService getLabelProviderService() {
		if (labelProviderService == null) {
			labelProviderService = new LabelProviderServiceImpl();
			try {
				labelProviderService.startService();
			} catch (ServiceException ex) {
				// prevent service from being used if it could not be started
				labelProviderService = null;
				getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID,
						"Unable to start Papyrus Label Provider Service", ex)); //$NON-NLS-1$
			}
		}
		return labelProviderService;
	}

	/**
	 * Obtain a resource locator for this plug-in.
	 * 
	 * @return my resource locator
	 */
	public ResourceLocator getResourceLocator() {
		if (resourceLocator == null) {
			resourceLocator = new EMFPlugin.EclipsePlugin() {
				// Pass
			};
		}
		return resourceLocator;
	}
}
