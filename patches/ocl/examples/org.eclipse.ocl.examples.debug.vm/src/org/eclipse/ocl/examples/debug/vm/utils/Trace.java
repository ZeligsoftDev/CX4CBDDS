/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.ocl.examples.debug.vm.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.annotation.NonNull;


public class Trace {	
	
	/**
	 * String containing an open parenthesis.
	 * 
	 */
	protected static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	/**
	 * String containing a close parenthesis.
	 * 
	 */
	protected static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	/**
	 * Prefix for tracing the changing of values.
	 * 
	 */
	protected static final String PREFIX_CHANGING = "CHANGING "; //$NON-NLS-1$
	
	/**
	 * Prefix for tracing the catching of throwables.
	 * 
	 */
	protected static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the throwing of throwables.
	 * 
	 */
	protected static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the entering of methods.
	 * 
	 */
	protected static final String PREFIX_ENTERING = "ENTERING "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the exiting of methods.
	 * 
	 */
	protected static final String PREFIX_EXITING = "EXITING "; //$NON-NLS-1$

	/**
	 * Separator for methods.
	 * 
	 */
	protected static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	/**
	 * Separator for parameters.
	 * 
	 */
	protected static final String SEPARATOR_PARAMETER = ", "; //$NON-NLS-1$

	/**
	 * Separator for return values.
	 * 
	 */
	protected static final String SEPARATOR_RETURN = ":"; //$NON-NLS-1$

	/**
	 * Separator containing a space.
	 * 
	 */
	protected static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$
	
	/**
	 * Label indicating old value.
	 * 
	 */
	protected static final String LABEL_OLD_VALUE = "old="; //$NON-NLS-1$

	/**
	 * Label indicating new value.
	 * 
	 */
	protected static final String LABEL_NEW_VALUE = "new="; //$NON-NLS-1$
			
	protected final @NonNull String exceptionsCatchingOption;
	protected final @NonNull String exceptionsThrowingOption;
	protected final @NonNull String methodsEnteringOption;
	protected final @NonNull String methodsExitingOption;	
	private Tracing fTracing;
	
	
	public Trace(@NonNull String exceptionsCatchingOption, @NonNull String exceptionsThrowingOption,
			@NonNull String methodsEnteringOption, @NonNull String methodsExitingOption) {
		this.exceptionsCatchingOption = exceptionsCatchingOption;
		this.exceptionsThrowingOption = exceptionsThrowingOption;
		this.methodsEnteringOption = methodsEnteringOption;
		this.methodsExitingOption = methodsExitingOption;
		fTracing = new Tracing();
	}
	
	protected void start(Plugin plugin) {
		fTracing.start(plugin);
	}
	
	protected void stop() {
		fTracing.stop();
	}
		
	/**
	 * Queries whether method entry tracing is enabled.
	 * 
	 * @return whether method entry tracing is enabled
	 */
	public boolean shouldTraceEntering() {
		return shouldTrace(methodsEnteringOption);
	}

	/**
	 * Queries whether method entry tracing is enabled for the specified
	 * debug option.
	 * 
	 * @param option the debug option to test
	 * @return whether method entry tracing is enabled for the option
	 */
	public boolean shouldTraceEntering(String option) {
		return shouldTraceEntering() && shouldTrace(option);
	}

	/**
	 * Queries whether method exit tracing is enabled.
	 * 
	 * @return whether method exit tracing is enabled
	 */
	public boolean shouldTraceExiting() {
		return fTracing.shouldTrace(methodsExitingOption);
	}

	/**
	 * Queries whether method exit tracing is enabled for the specified
	 * debug option.
	 * 
	 * @param option the debug option to test
	 * @return whether method exit tracing is enabled for the option
	 */
	public boolean shouldTraceExiting(String option) {
		return shouldTraceExiting() && fTracing.shouldTrace(option);
	}

	/**
	 * Queries whether exception catch tracing is enabled.
	 * 
	 * @return whether exception catch tracing is enabled
	 */
	public boolean shouldTraceCatching() {
		return fTracing.shouldTrace(exceptionsCatchingOption);
	}

	/**
	 * Queries whether exception throw tracing is enabled.
	 * 
	 * @return whether exception throw tracing is enabled
	 */
	public boolean shouldTraceThrowing() {
		return fTracing.shouldTrace(exceptionsThrowingOption);
	}

	/**
	 * Queries whether tracing is enabled for the
	 * specified debug option of this plug-in.
	 * 
	 * @param option The debug option for which to determine trace enablement.
	 * @return Whether tracing is enabled for the debug option of the plug-in.
	 */
	public boolean shouldTrace(String option) {
		return fTracing.shouldTrace(
				option);
	}

	/**
	 * Traces the specified message from this plug-in.
	 * 
	 * @param message The message to be traced.
	 */
	public void trace(String message) {
		fTracing.trace(message);
	}

	/**
	 * Traces the specified message from this plug-in for the specified
	 * debug option.
	 * 
	 * @param option The debug option for which to trace.
	 * @param message The message to be traced.
	 */
	public void trace(String option, String message) {
		fTracing.trace(
				option,
				message);
	}

	/**
	 * Traces an entry into the specified method of the specified class.
	 * 
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 */
	public void entering(
		Class<?> clazz,
		String methodName) {
	
		fTracing.entering(
				methodsEnteringOption,
				clazz,
				methodName);
	}

	/**
	 * Traces an entry into the specified method of the specified class,
	 * with the specified parameter.
	 * 
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 * @param parameter The parameter to the method being entered.
	 */
	public void entering(
		Class<?> clazz,
		String methodName,
		Object parameter) {
	
		fTracing.entering(
				methodsEnteringOption,
				clazz,
				methodName,
				parameter);
	}

	/**
	 * Traces an entry into the specified method of the specified class,
	 * with the specified parameters.
	 * 
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 * @param parameters The parameters to the method being entered.
	 */
	public void entering(
		Class<?> clazz,
		String methodName,
		Object[] parameters) {
	
		fTracing.entering(
				methodsEnteringOption,
				clazz,
				methodName,
				parameters);
	}

	/**
	 * Traces an entry into the specified method of the specified class.
	 * 
	 * @param option only trace entering if this option is enabled (in addition
	 *    to the generic method-entry option)
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 */
	public void entering(
		String option,
		Class<?> clazz,
		String methodName) {
	
		if (shouldTraceEntering()) {
			fTracing.entering(
					option,
					clazz,
					methodName);
		}
	}

	/**
	 * Traces an entry into the specified method of the specified class,
	 * with the specified parameter.
	 * 
	 * @param option only trace entering if this option is enabled (in addition
	 *    to the generic method-entry option)
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 * @param parameter The parameter to the method being entered.
	 */
	public void entering(
		String option,
		Class<?> clazz,
		String methodName,
		Object parameter) {
	
		if (shouldTraceEntering()) {
			fTracing.entering(
					option,
					clazz,
					methodName,
					parameter);
		}
	}

	/**
	 * Traces an entry into the specified method of the specified class,
	 * with the specified parameters.
	 * 
	 * @param option only trace entering if this option is enabled (in addition
	 *    to the generic method-entry option)
	 * @param clazz The class whose method is being entered.
	 * @param methodName The name of method that is being entered.
	 * @param parameters The parameters to the method being entered.
	 */
	public void entering(
		String option,
		Class<?> clazz,
		String methodName,
		Object[] parameters) {
	
		if (shouldTraceEntering()) {
			fTracing.entering(
					option,
					clazz,
					methodName,
					parameters);
		}
	}

	/**
	 * Traces an exit from the specified method of the specified class.
	 * 
	 * @param clazz The class whose method is being exited.
	 * @param methodName The name of method that is being exited.
	 */
	public void exiting(
		Class<?> clazz,
		String methodName) {
	
		fTracing.exiting(
				methodsExitingOption,
				clazz,
				methodName);
	}

	/**
	 * Traces an exit from the specified method of the specified class,
	 * with the specified return value.
	 * 
	 * @param clazz The class whose method is being exited.
	 * @param methodName The name of method that is being exited.
	 * @param returnValue The return value of the method being exited.
	 */
	public void exiting(
		Class<?> clazz,
		String methodName,
		Object returnValue) {
	
		fTracing.exiting(
				methodsExitingOption,
				clazz,
				methodName,
				returnValue);
	}

	/**
	 * Traces an exit from the specified method of the specified class.
	 * 
	 * @param option only trace entering if this option is enabled (in addition
	 *    to the generic method-exit option)
	 * @param clazz The class whose method is being exited.
	 * @param methodName The name of method that is being exited.
	 */
	public void exiting(
		String option,
		Class<?> clazz,
		String methodName) {
	
		if (shouldTraceExiting()) {
			fTracing.exiting(
					option,
					clazz,
					methodName);
		}
	}

	/**
	 * Traces an exit from the specified method of the specified class,
	 * with the specified return value.
	 * 
	 * @param option only trace entering if this option is enabled (in addition
	 *    to the generic method-exit option)
	 * @param clazz The class whose method is being exited.
	 * @param methodName The name of method that is being exited.
	 * @param returnValue The return value of the method being exited.
	 */
	public void exiting(
		String option,
		Class<?> clazz,
		String methodName,
		Object returnValue) {
	
		if (shouldTraceExiting()) {
			fTracing.exiting(
					option,
					clazz,
					methodName,
					returnValue);
		}
	}

	/**
	 * Traces the catching of the specified throwable in the specified method of
	 * the specified class.
	 * 
	 * @param clazz The class in which the throwable is being caught.
	 * @param methodName The name of the method in which the throwable is being
	 *                    caught.
	 * @param throwable The throwable that is being caught.
	 */
	public void catching(
		Class<?> clazz,
		String methodName,
		Throwable throwable) {
	
		fTracing.catching(
				exceptionsCatchingOption,
				clazz,
				methodName,
				throwable);
	}

	/**
	 * Traces the throwing of the specified throwable from the specified method
	 * of the specified class.
	 * 
	 * @param clazz The class from which the throwable is being thrown.
	 * @param methodName The name of the method from which the throwable is
	 *                    being thrown.
	 * @param throwable The throwable that is being thrown.
	 */
	public void throwing(
		Class<?> clazz,
		String methodName,
		Throwable throwable) {
	
		fTracing.throwing(
				exceptionsThrowingOption,
				clazz,
				methodName,
				throwable);
	}
	
	/**
	 * Converts an array of objects to a string for trace output.
	 * 
	 * @param array the array to convert to a string
	 * @return the string
	 */
	public static String toString(Object[] array) {
		StringBuffer result = new StringBuffer(64);
		
		result.append('[');
		
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				result.append(", "); //$NON-NLS-1$
			}
			
			result.append(array[i]);
		}
		
		result.append(']');
		
		return result.toString();
	}
	
	
    private class Tracing {
    	
		private Plugin fPlugin;

		Tracing() {
			super();
		}
		
		synchronized void start(Plugin plugin) {
			fPlugin = plugin;
		}
		
		synchronized void stop() {
			fPlugin = null;
		}
    	
    	/**
    	 * The cached debug options (for optimization).
    	 */
    	private final Map<String, Boolean> cachedOptions = new HashMap<String, Boolean>();

    	/**
    	 * Retrieves a Boolean value indicating whether tracing is enabled.
    	 * 
    	 * @return Whether tracing is enabled for the plug-in.
    	 * 
    	 */
    	protected synchronized boolean shouldTrace() {
    		return fPlugin != null && fPlugin.isDebugging();
    	}

    	/**
    	 * Retrieves a Boolean value indicating whether tracing is enabled for the
    	 * specified debug option.
    	 * 
    	 * @return Whether tracing is enabled for the debug option of the plug-in.
    	 * @param option The debug option for which to determine trace enablement.
    	 * 
    	 */
    	public boolean shouldTrace(String option) {
    		if (shouldTrace()) {
    			Boolean value = null;
    			
    			synchronized (cachedOptions) {
    				value = cachedOptions.get(option);
    	
    				if (null == value) {
    					value =
    						Boolean.valueOf(
    								org.eclipse.core.runtime.Platform.getDebugOption(option));
    	
    					cachedOptions.put(option, value);
    				}
    			}
    			
    			return value.booleanValue();
    		}

    		return false;
    	}

    	/**
    	 * Retrieves a textual representation of the specified argument.
    	 * 
    	 * @return A textual representation of the specified argument.
    	 * @param argument The argument for which to retrieve a textual
    	 *                  representation.
    	 * 
    	 */
    	protected String getArgumentString(Object argument) {
    		return String.valueOf(argument);
    	}

    	/**
    	 * Retrieves a textual representation of the specified arguments.
    	 * 
    	 * @return A textual representation of the specified arguments.
    	 * @param arguments The arguments for which to retrieve a textual
    	 *                   representation.
    	 * 
    	 */
    	protected String getArgumentsString(Object[] arguments) {
    		StringBuffer buffer = new StringBuffer();

    		for (int i = 0; i < arguments.length; i++) {
    			buffer.append(getArgumentString(arguments[i]));

    			if (i < arguments.length - 1) {
    				buffer.append(SEPARATOR_PARAMETER);
    			}
    		}

    		return buffer.toString();
    	}

    	/**
    	 * Traces the specified message.
    	 * 
    	 * @param message The message to be traced.
    	 * 
    	 */
    	public void trace(String message) {
    		if (shouldTrace()) {
    			System.out.println(message);
    		}
    	}

    	/**
    	 * Traces the specified message for the specified
    	 * debug option.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param message The message to be traced.
    	 * 
    	 */
    	public void trace(String option, String message) {
    		if (shouldTrace(option)) {
    			trace(message);
    		}
    	}
    	
    	/**
    	 * Traces the catching of the specified throwable in the specified method of
    	 * the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class in which the throwable is being caught.
    	 * @param methodName The name of the method in which the throwable is being
    	 *                    caught.
    	 * @param throwable The throwable that is being caught.
    	 * 
    	 */
    	public void catching(
    		String option,
    		Class<?> clazz,
    		String methodName,
    		Throwable throwable) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_CATCHING
    					+ throwable.getMessage()
    					+ SEPARATOR_SPACE
    					+ PARENTHESIS_OPEN
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_CLOSE);

    			throwable.printStackTrace(System.err);
    		}
    	}

    	/**
    	 * Traces the throwing of the specified throwable from the specified method
    	 * of the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class from which the throwable is being thrown.
    	 * @param methodName The name of the method from which the throwable is
    	 *                    being thrown.
    	 * @param throwable The throwable that is being thrown.
    	 * 
    	 */
    	public void throwing(
    		String option,
    		Class<?> clazz,
    		String methodName,
    		Throwable throwable) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_THROWING
    					+ throwable.getMessage()
    					+ SEPARATOR_SPACE
    					+ PARENTHESIS_OPEN
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_CLOSE);

    			throwable.printStackTrace(System.err);
    		}
    	}

    	/**
    	 * Traces the entering into the specified method of the specified class,
    	 * with the specified parameters.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being entered.
    	 * @param methodName The name of method that is being entered.
    	 * @param parameters The parameters to the method being entered.
    	 * 
    	 */
    	public void entering(
    		String option,
    		Class<?> clazz,
    		String methodName,
    		Object... parameters) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_ENTERING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_OPEN
    					+ getArgumentsString(parameters)
    					+ PARENTHESIS_CLOSE);
    		}
    	}

    	/**
    	 * Traces the exiting from the specified method of the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being exited.
    	 * @param methodName The name of method that is being exited.
    	 * 
    	 */
    	public void exiting(
    		String option,
    		Class<?> clazz,
    		String methodName) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_EXITING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName);
    		}
    	}

    	/**
    	 * Traces the exiting from the specified method of the specified class,
    	 * with the specified return value.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being exited.
    	 * @param methodName The name of method that is being exited.
    	 * @param returnValue The return value of the method being exited.
    	 * 
    	 */
    	public void exiting(
    		String option,
    		Class<?> clazz,
    		String methodName,
    		Object returnValue) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_EXITING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ SEPARATOR_RETURN
    					+ getArgumentString(returnValue));
    		}
    	}
    }
	
}
