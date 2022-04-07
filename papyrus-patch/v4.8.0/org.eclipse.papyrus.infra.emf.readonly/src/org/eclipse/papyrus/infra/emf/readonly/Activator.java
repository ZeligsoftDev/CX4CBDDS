/*****************************************************************************
 * Copyright (c) 2011, 2016 Atos Origin, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus - bug 463564
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executor;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.emf.readonly.spi.IReadOnlyManagerProcessor;
import org.eclipse.papyrus.infra.tools.util.CoreExecutors;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf.readonly"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	public static LogHelper log;

	private static final IReadOnlyManagerProcessor[] NO_PROCESSORS = {};

	private Executor readOnlyCacheExecutor;

	private ServiceTracker<IReadOnlyManagerProcessor, IReadOnlyManagerProcessor> roManagerProcessorTracker;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		roManagerProcessorTracker = new ServiceTracker<>(context, IReadOnlyManagerProcessor.class, null);
		roManagerProcessorTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		roManagerProcessorTracker.close();
		roManagerProcessorTracker = null;

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Queries the executor to use in the initialization of a {@link ReadOnlyManager}'s
	 * {@linkplain AbstractReadOnlyHandler.ResourceReadOnlyCache read-only caches}.
	 * 
	 * @return the executor to use in initialization of read-only resource caches. never {@code null}
	 */
	public synchronized Executor getReadOnlyCacheExecutor() {
		if (readOnlyCacheExecutor == null) {
			// The default executor is one that runs tasks on the display's event queue
			readOnlyCacheExecutor = CoreExecutors.getUIExecutorService();
		}
		return readOnlyCacheExecutor;
	}

	/**
	 * Assigns the executor to use in the initialization of a {@link ReadOnlyManager}'s
	 * {@linkplain AbstractReadOnlyHandler.ResourceReadOnlyCache read-only caches}.
	 * 
	 * @param executor
	 *            the executor to use in initialization of read-only resource caches.
	 *            May be {@code null} to use a default executor
	 * @return the executor previously in use (so that, for example, it could be restored)
	 */
	public synchronized Executor setReadOnlyCacheExecutor(Executor executor) {
		Executor result = getReadOnlyCacheExecutor();

		this.readOnlyCacheExecutor = executor;

		return result;
	}

	Iterable<IReadOnlyManagerProcessor> getReadOnlyManagerProcessors() {
		IReadOnlyManagerProcessor[] processors = roManagerProcessorTracker.getServices(NO_PROCESSORS);

		return (processors == null) ? Collections.emptyList() : Arrays.asList(processors);
	}
}
