/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.logging;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.spi.StandardLevel;

import java.io.Serializable;
import java.util.Objects;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Knut Wannheden - Refactored handling when used in non OSGi environment
 * @author Ernesto Posse - Upgraded to log4j 2
 */
@Plugin(name = "EclipseLogAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class EclipseLogAppender extends AbstractAppender {

	private static final String LOG4J_BUNDLE_NAME = "org.apache.logging.log4j";

	// this logger will NOT log to this appender (see log4j.properties)
	private static final Logger LOGGER = LogManager.getLogger(EclipseLogAppender.class);

	private boolean initialized;
	private ILog log;

	protected EclipseLogAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
		super(name, filter, layout);
		// TODO Auto-generated constructor stub
	}

	protected EclipseLogAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout,
			final boolean ignoreExceptions) {
		super(name, filter, layout, ignoreExceptions, Property.EMPTY_ARRAY);
	}

	protected EclipseLogAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout,
			final boolean ignoreExceptions, final Property[] properties) {
		super(name, filter, layout, ignoreExceptions, properties);
	}

	@PluginFactory
	public static EclipseLogAppender createAppender(@PluginAttribute("name") String name, 
			@PluginElement("Layout") Layout<? extends Serializable> layout,
			@PluginElement("Filter") Filter filter) {
		return new EclipseLogAppender(name, filter, layout);
	}

	private synchronized void ensureInitialized() {
		if (!initialized) {
			if (!Platform.isRunning()) {
				LOGGER.warn(
						"You appear to be running outside Eclipse; you might want to remove the jar org.eclipse.xtext.logging*.jar from your classpath and supply your own log4j.properties.");
			} else {
				log = Platform.getLog(FrameworkUtil.getBundle(Logger.class));
			}
			initialized = true;
		}
	}

	private ILog getLog() {
		ensureInitialized();
		return log;
	}

	@Override
	public void append(LogEvent event) {
		if (isDoLog(event.getLevel())) {
			String logString = (String) getLayout().toSerializable(event);

			ILog myLog = getLog();
			if (myLog != null) {
				String loggerName = event.getLoggerName();
				int severity = mapLevel(event.getLevel());
				final Throwable throwable = event.getThrown();
				IStatus status = createStatus(severity, loggerName, logString, throwable);
				getLog().log(status);
			} else {
				// nothing to do (message should be logged to stdout by default appender)
			}
		}
	}

	private boolean isDoLog(Level level) {
		return level.intLevel() >= StandardLevel.WARN.intLevel();
	}

	private int mapLevel(Level level) {
		switch (level.getStandardLevel()) {
			case DEBUG:
			case TRACE:
			case INFO:
				return IStatus.INFO;

			case WARN:
				return IStatus.WARNING;

			case ERROR:
			case FATAL:
				return IStatus.ERROR;

			default:
				return IStatus.INFO;
		}
	}

	private IStatus createStatus(int severity, String loggerName, String message, Throwable throwable) {
		return new Status(severity, LOG4J_BUNDLE_NAME, message, throwable);
	}

}
