/*******************************************************************************
 * Copyright (c) 2014, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui;

import java.text.MessageFormat;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.xtext.base.ui.internal.BaseActivator;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class BaseUiPluginHelper extends EMFPlugin.InternalHelper
{
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.ocl.xtext.base.ui"; //$NON-NLS-1$

	public static final BaseUiPluginHelper INSTANCE = new BaseUiPluginHelper(BaseActivator.getInstance());

	private BaseUiPluginHelper(Plugin plugin) {
		super(plugin);
	}

	public Status createErrorStatus(Exception e) {
		return new Status(Status.ERROR, getSymbolicName(), e.getMessage(), e);
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 *
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Logs the given message and throwable to the platform log.
	 *
	 * If you have a status object in hand call log(String, IStatus) instead.
	 *
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 *
	 * @param message
	 *            A high level UI message describing when the problem happened.
	 * @param t
	 *            The throwable from where the problem actually occurred.
	 */
	public static void log(String message, Throwable t) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, t);
		log(message, status);
	}

	/**
	 * Logs the given message and status to the platform log.
	 *
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 *
	 * @param message
	 *            A high level UI message describing when the problem happened.
	 *            May be <code>null</code>.
	 * @param status
	 *            The status describing the problem. Must not be null.
	 */
	public static void log(String message, IStatus status) {
		BaseActivator defaultPlugin = BaseActivator.getInstance();
		if (message != null) {
			defaultPlugin.getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, null));
		}

		defaultPlugin.getLog().log(status);
	}

	/**
	 * Logs the given throwable to the platform log, indicating the class and
	 * method from where it is being logged (this is not necessarily where it
	 * occurred).
	 *
	 * This convenience method is for internal use by the IDE Workbench only and
	 * must not be called outside the IDE Workbench.
	 *
	 * @param clazz
	 *            The calling class.
	 * @param methodName
	 *            The calling method name.
	 * @param t
	 *            The throwable from where the problem actually occurred.
	 */
	public static void log(@SuppressWarnings("rawtypes") Class clazz, String methodName, Throwable t) {
		String msg = MessageFormat.format("Exception in {0}.{1}: {2}", //$NON-NLS-1$
			new Object[]{clazz.getName(), methodName, t});
		log(msg, t);
	}

	/**
	 * Logs a message with given level into the Eclipse log file
	 */
	public static void log(Exception e) {
		log(e.getMessage(), IStatus.ERROR, e);
	}

	/**
	 * Logs a message with given level into the Eclipse log file
	 *
	 * @param message
	 *            the message to log
	 * @param severity
	 *            the message priority
	 * @param e
	 *            exception to log
	 */
	public static void log(String message, int severity, Exception e) {
		BaseActivator defaultPlugin = BaseActivator.getInstance();
		IStatus status = new Status(severity, defaultPlugin.getBundle().getSymbolicName(), severity, message, e);
		defaultPlugin.getLog().log(status);
	}
}
