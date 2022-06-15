/**
 * Copyright 2022 Zeligsoft (2009) Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.domain.dds4ccm.ui.errorhandlers.statushandlers;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.internal.ide.IDEWorkbenchErrorHandler;
import org.eclipse.ui.statushandlers.StatusAdapter;

import com.zeligsoft.base.util.JavaReflectionUtil;
import com.zeligsoft.domain.dds4ccm.ui.errorhandlers.Activator;

/**
 * This status handler detects and filters "undesirable" exceptions that have been registered via the
 * "undesirableExceptions" extension point.
 * 
 *  @see {@link UndesirableException}
 * 
 * @author Ernesto Posse
 */
public class FilteringStatusHandler extends IDEWorkbenchErrorHandler {

	private UndesirableExceptionRegistry undesirableExceptionRegistry = new UndesirableExceptionRegistry();
	
	private Set<Throwable> filteredExceptions = new HashSet<Throwable>();

	public FilteringStatusHandler() {
		this(null);
	}

	public FilteringStatusHandler(IWorkbenchConfigurer configurer) {
		super(configurer);
	}

	@Override
	public void handle(StatusAdapter statusAdapter, int style) {
		IStatus status = statusAdapter.getStatus();
		Throwable exception = status.getException();
		// Go through the exception's "caused by" list,
		// while we have not previously filtered the exception.
		// We need to cache exceptions as we filter them, because logging them
		// causes the status handler to be invoked, so this method is reentrant, and if
		// we don't cache them, we end up in an infinite loop.
		while (exception != null && !filteredExceptions.contains(exception)) {
			if (filter(exception)) {
				filteredExceptions.add(exception);
				log(status);
				return;
			}
			exception = exception.getCause();
		}
		// If the exception was not filtered, delegate to the standard error handler.
		// We must check again if the exception has been filtered because the loop above
		// may have ended is the exception had been previously filtered, and so in that case
		// we should not delegate to the standard error handler.
		if (!filteredExceptions.contains(exception)) {
			super.handle(statusAdapter, style);
		}
	}

	private void log(IStatus status) {
		Activator.getDefault().getLog().log(status);
	}

	/**
	 * Returns true if the given exception matches any of the undesirable exceptions in the {@link UndesirableExceptionRegistry}
	 * and should be filtered.
	 * 
	 * @param exception - a {@link Throwable}
	 * @return A boolean.
	 */
	private boolean filter(Throwable exception) {
		// For each undesirable exception...
		for (UndesirableException undesirableException : undesirableExceptionRegistry.getUndesirableExceptions()) {
			// If the given exception is an instance of the undesirable exception
			if (isSubClassOrImplements(exception.getClass(), undesirableException.getExceptionClassName())) {
				// Get the exception's stack trace
				StackTraceElement[] stackTrace = exception.getStackTrace();
				if (stackTrace != null) {
					// Determine the maximum depth to go to in the stack trace.
					// It is the smallest between the current trace's length, and the
					// maximum defined for the undesirable exception, if provided,
					// otherwise, it is the trace's length.
					int limit = stackTrace.length;
					Integer maxDepth = undesirableException.getMaximumDepth();
					if (maxDepth != null) {
						limit = Integer.min(limit, maxDepth.intValue());
					}
					// Go through each stack trace element, up to the limit determined above
					for (int depth = 0; depth < limit; depth++) {
						StackTraceElement stackTraceElement = stackTrace[depth];
						Matcher classNameMatcher = undesirableException.getOriginClassNamePattern()
								.matcher(stackTraceElement.getClassName());
						Matcher methodNameMatcher = undesirableException.getOriginMethodNamePattern()
								.matcher(stackTraceElement.getMethodName());
						if (classNameMatcher.matches() && methodNameMatcher.matches()) {
							// If the stack trace element's class name and method name match the
							// respective patterns from the undesirable exception, then we
							// must filter-out this exception
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean isSubClassOrImplements(Class<? extends Throwable> throwableClass, String exceptionClassName) {
		return JavaReflectionUtil.isEqualOrSubclassOf(throwableClass, exceptionClassName)
				|| JavaReflectionUtil.isEqualOrImplementsInterface(throwableClass, exceptionClassName);
	}

}
