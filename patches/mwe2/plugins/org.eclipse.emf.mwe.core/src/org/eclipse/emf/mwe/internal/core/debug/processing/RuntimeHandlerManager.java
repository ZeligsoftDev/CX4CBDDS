/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.internal.core.debug.processing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.eclipse.emf.mwe.core.debug.processing.ElementAdapter;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.internal.core.debug.communication.Connection;
import org.eclipse.emf.mwe.internal.core.debug.communication.packages.RegisterPackage;

/**
 * This manager class listens for requests from the debug server to instantiate
 * handlers or adapters.<br>
 * It initiates the handlers and registers adapters at the
 * <code>DebugMonitor</code> instance.
 */
public class RuntimeHandlerManager implements Runnable {

	private Connection connection;

	private final DebugMonitor monitor;

	private static final Logger logger = LogManager.getLogger(RuntimeHandlerManager.class);

	// -------------------------------------------------------------------------

	public RuntimeHandlerManager(final DebugMonitor monitor) {
		this.monitor = monitor;
	}

	// -------------------------------------------------------------------------

	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * start listener thread.
	 */
	public void startListener() {
		Thread thread = new Thread(this, getClass().getSimpleName());
		thread.setDaemon(true);
		thread.start();
	}

	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				listenAndRegisterClasses();
			}
		}
		catch (Exception e) {
			if (!(e instanceof IOException)) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void listenAndRegisterClasses() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		RegisterPackage packet = (RegisterPackage) connection.listenForPackage(RegisterPackage.class);

		String msg = null;

		if (packet.type == RegisterPackage.HANDLERS) {
			RuntimeHandler handler = null;
			for (String className : packet.classNames) {
				final Class<?> clazz = ResourceLoaderFactory.createResourceLoader().loadClass(className);
				if (clazz == null) {
					msg = "Couldn't find " + className + " in the class path.";
					System.err.println(msg);
					throw new ClassNotFoundException(msg);
				}
				handler = (RuntimeHandler) clazz.getDeclaredConstructor().newInstance();
				handler.init(monitor, connection);
				handler.startListener();
			}
		}
		else {
			ElementAdapter adapter = null;
			for (String className : packet.classNames) {
				final Class<?> clazz = ResourceLoaderFactory.createResourceLoader().loadClass(className);
				if (clazz == null) {
					msg = "Couldn't find " + className + " in the class path.";
					System.err.println(msg);
					throw new ClassNotFoundException(msg);
				}
				adapter = (ElementAdapter) clazz.getDeclaredConstructor().newInstance();
				monitor.addAdapter(adapter);
			}
		}
	}

}
