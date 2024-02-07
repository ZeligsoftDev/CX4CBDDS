/*******************************************************************************
 * Copyright (c) 2010, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling
 *******************************************************************************/

package org.eclipse.ocl.pivot.internal.helper;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLDebugOptions;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.ocl.pivot.utilities.OCLHelper;

/**
 * Utility class in support of the implementation of the {@link OCLHelper}
 * API, also responsible for the creation of {@link OCLHelper}s.
 *
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
public class HelperUtil {

	static final int NONE = -1;

	static final String OCL_COMMENT = "--"; //$NON-NLS-1$

	static final String PATH_DELIMETER = "(=> "; //$NON-NLS-1$

	static final String PACKAGE = "package"; //$NON-NLS-1$

	static final String COLON = ":"; //$NON-NLS-1$

	static final String DOUBLE_COLON = "::"; //$NON-NLS-1$

	static final String DOT = "."; //$NON-NLS-1$

	static final String ARROW = "->"; //$NON-NLS-1$

	static final String CARET = "^"; //$NON-NLS-1$

	static final String DOUBLE_CARET = "^^"; //$NON-NLS-1$

	static final String EMPTY = ""; //$NON-NLS-1$

	static final String HTTP = "http://"; //$NON-NLS-1$

	/** Not instantiable by clients. */
	private HelperUtil() {
		super();
	}

	/**
	 * convenience method for serviceability support tracing exceptions thrown
	 * @param exception the exception to be thrown
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that threw the exception
	 */
	static void throwException(RuntimeException exception, Class<?> clazz,
			String methodName) {
		throwing(clazz, methodName, exception);
		throw exception;
	}

	/**
	 * convenience method for serviceability support tracing exceptions caught
	 * @param exception the exception to be caught
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that caught the exception
	 */
	static void catchException(Exception exception, Class<?> clazz,
			String methodName) {
		catching(clazz, methodName, exception);
	}

	public static final @NonNull String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final @NonNull String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	private static final @NonNull String SEPARATOR_SPACE = " "; //$NON-NLS-1$

	private static final @NonNull String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	private static final @NonNull String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	private static final @NonNull String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	private static final @NonNull String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	/**
	 * In stand-alone use, whether all tracing is turned on.
	 * This is compatible with the usage of 1.2 and earlier.
	 */
	private static boolean traceAll = Boolean
			.getBoolean("org.eclipse.ocl.debug"); //$NON-NLS-1$;

	/**
	 * Traces the catching of the specified throwable in the specified method of
	 * the specified class.
	 *
	 * @param clazz
	 *            The class in which the throwable is being caught.
	 * @param methodName
	 *            The name of the method in which the throwable is being caught.
	 * @param throwable
	 *            The throwable that is being caught.
	 *
	 */
	public static void catching(Class<?> clazz, String methodName,
			Throwable throwable) {
		if (shouldTrace(OCLDebugOptions.EXCEPTIONS_CATCHING)) {
			trace(PREFIX_CATCHING + throwable.getMessage() + SEPARATOR_SPACE
				+ PARENTHESIS_OPEN + clazz.getName() + SEPARATOR_METHOD
				+ methodName + PARENTHESIS_CLOSE);
			throwable.printStackTrace(System.err);
		}
	}

	public static void throwing(Class<?> clazz, String methodName,
			Throwable throwable) {
		if (shouldTrace(OCLDebugOptions.EXCEPTIONS_THROWING)) {
			trace(PREFIX_THROWING + throwable.getMessage() + SEPARATOR_SPACE
				+ PARENTHESIS_OPEN + clazz.getName() + SEPARATOR_METHOD
				+ methodName + PARENTHESIS_CLOSE);
			throwable.printStackTrace(System.err);
		}
	}

	public static boolean shouldTrace(String option) {
		if (PivotPlugin.getPlugin() != null) {
			if (PivotPlugin.getPlugin().isDebugging()) {
				return Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(option));
			}

			return false;
		}

		return traceAll || Boolean.getBoolean(option);
	}

	/**
	 * Emits the specified message to the trace log.  It is the caller's
	 * responsibility to ensure that the appropriate tracing option
	 * is enabled.
	 *
	 * @param message a message
	 *
	 * @see #shouldTrace(String)
	 */
	public static void trace(String message) {
		System.out.println("[OCL] " + message); //$NON-NLS-1$
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *
	 */
	public static void error(int code, String message) {
		error(code, message, null);
	}

	/**
	 * Generates an error log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *
	 */
	public static void error(int code, String message, Throwable throwable) {
		log(Diagnostic.ERROR, code, message, throwable);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified message. Uses OK as status code.
	 *
	 * @param message
	 *            The message for the log.
	 *
	 */
	public static void info(String message) {
		info(StatusCodes.INFO, message);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified status code, message.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *
	 */
	public static void info(int code, String message) {
		info(code, message, null);
	}

	/**
	 * Generates an information log for the specified plug-in, with the
	 * specified status code, message, and throwable.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *
	 */
	public static void info(int code, String message, Throwable throwable) {
		log(Diagnostic.INFO, code, message, throwable);
	}

	/**
	 * Generates a warning log for the specified plug-in, with the specified
	 * status code, message.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 *
	 */
	public static void warning(int code, String message) {
		warning(code, message, null);
	}

	/**
	 * Generates a warning log for the specified plug-in, with the specified
	 * status code, message, and throwable.
	 *
	 * @param code
	 *            The status code for the log.
	 * @param message
	 *            The message for the log.
	 * @param throwable
	 *            The throwable for the log.
	 *
	 */
	public static void warning(int code, String message, Throwable throwable) {
		log(Diagnostic.WARNING, code, message, throwable);
	}

	public static void log(int severity, int code, String message,
			Throwable throwable) {
		//
		// Status ctor requires a non-null message
		String msg = message == null
				? "" //$NON-NLS-1$
					: message;

		try {
			if (PivotPlugin.getPlugin() != null) {
				// Eclipse environment
				PivotPlugin.getPlugin().log(
					new Status(severity, PivotPlugin.PLUGIN_ID, code, msg, throwable));
			} else {
				// not in the Eclipse environment
				if (shouldTrace(OCLDebugOptions.DEBUG)) {
					switch (code) {
						case Diagnostic.WARNING :
							System.err.print("WARNING "); //$NON-NLS-1$
							break;
						case Diagnostic.ERROR :
						case Diagnostic.CANCEL :
							System.err.print("ERROR "); //$NON-NLS-1$
							break;
						default :
							// don't output INFO or OK messages
							return;
					}

					System.err.print(code);
					System.err.print(": "); //$NON-NLS-1$
					System.err.println(message);

					if (throwable != null) {
						throwable.printStackTrace(System.err);
					}
				}
			}
		} catch (IllegalArgumentException iae) {
			catching(HelperUtil.class, "log", iae);//$NON-NLS-1$
		}
	}

}