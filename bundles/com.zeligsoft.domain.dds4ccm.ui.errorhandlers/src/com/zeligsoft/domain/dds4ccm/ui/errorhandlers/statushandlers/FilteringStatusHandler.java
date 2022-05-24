/**
 * 
 */
package com.zeligsoft.domain.dds4ccm.ui.errorhandlers.statushandlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.internal.ide.IDEWorkbenchErrorHandler;
import org.eclipse.ui.statushandlers.StatusAdapter;

import com.zeligsoft.domain.dds4ccm.ui.errorhandlers.Activator;

/**
 * @author eposse
 *
 */
public class FilteringStatusHandler extends IDEWorkbenchErrorHandler {

	public class UndesirableException {
		private Class<Throwable> exceptionClass;
		private Pattern originClassNamePattern;
		private Pattern originMethodNamePattern;
		private Integer maximumDepth;

		public <T extends Throwable> UndesirableException(Class<T> exceptionClass, String originClassNamePattern,
				String originMethodNamePattern, Integer maximumDepth) {
			init(exceptionClass, originClassNamePattern, originMethodNamePattern, maximumDepth);
		}

		public <T extends Throwable> UndesirableException(Class<T> exceptionClass, String originClassNamePattern,
				String originMethodNamePattern) {
			init(exceptionClass, originClassNamePattern, originMethodNamePattern, null);
		}

		public <T extends Throwable> UndesirableException(Class<T> exceptionClass,
				String originFullyQualifiedMethodNamePattern, Integer maximumDepth) {
			String originClassNamePattern = "";
			String originMethodNamePattern = "";
			if (originFullyQualifiedMethodNamePattern != null) {
				int lastDotIndex = originFullyQualifiedMethodNamePattern.lastIndexOf(Character.getNumericValue('.'));
				originClassNamePattern = originFullyQualifiedMethodNamePattern.substring(0, lastDotIndex);
				originMethodNamePattern = originFullyQualifiedMethodNamePattern.substring(lastDotIndex);
			}
			init(exceptionClass, originClassNamePattern, originMethodNamePattern, maximumDepth);
		}

		public <T extends Throwable> UndesirableException(Class<T> exceptionClass,
				String originFullyQualifiedMethodNamePattern) {
			this(exceptionClass, originFullyQualifiedMethodNamePattern, (Integer) null);
		}

		private <T extends Throwable> void init(Class<T> exceptionClass, String originClassNamePattern,
				String originMethodNamePattern, Integer maximumDepth) {
			this.exceptionClass = (Class<Throwable>) exceptionClass;
			if (originClassNamePattern == null || originClassNamePattern.isBlank()) {
				originClassNamePattern = ".*";
			}
			if (originMethodNamePattern == null || originMethodNamePattern.isBlank()) {
				originMethodNamePattern = ".*";
			}
			this.originClassNamePattern = Pattern.compile(originClassNamePattern);
			this.originMethodNamePattern = Pattern.compile(originMethodNamePattern);
			this.maximumDepth = maximumDepth;
		}

		public Class<Throwable> getExceptionClass() {
			return exceptionClass;
		}

		public Pattern getOriginClassNamePattern() {
			return originClassNamePattern;
		}

		public Pattern getOriginMethodNamePattern() {
			return originMethodNamePattern;
		}

		public Integer getMaximumDepth() {
			return maximumDepth;
		}
	}

	public final String UNDESIRABLE_EXCEPTIONS_EXTENSION_POINT_ID = "undesirableExceptions";
	public final String ATTR_NAME_EXCEPTION_CLASS = "exceptionClass";
	public final String ATTR_NAME_ORIGIN_CLASS_NAME_PATTERN = "originClassNamePattern";
	public final String ATTR_NAME_ORIGIN_METHOD_NAME_PATTERN = "originMethodNamePattern";
	public final String ATTR_NAME_MAXIMUM_DEPTH = "maximumDepth";

	private List<UndesirableException> undesirableExceptions = null;
	private Set<Throwable> filteredExceptions = new HashSet<Throwable>();

	public FilteringStatusHandler() {
		this(null);
	}

	public FilteringStatusHandler(IWorkbenchConfigurer configurer) {
		super(configurer);
	}

	public List<UndesirableException> getUndesirableExceptions() {
		if (undesirableExceptions == null) {
			undesirableExceptions = new ArrayList<>();
			loadExtensionPoint();
		}
		return undesirableExceptions;
	}

	private void loadExtensionPoint() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		final IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(Activator.PLUGIN_ID,
				UNDESIRABLE_EXCEPTIONS_EXTENSION_POINT_ID);
		IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();

		for (IConfigurationElement configurationElement : configurationElements) {
			addUndesirableException(configurationElement);
		}
	}

	private void addUndesirableException(IConfigurationElement configurationElement) {
		String exceptionClassName = configurationElement.getAttribute(ATTR_NAME_EXCEPTION_CLASS);
		if (exceptionClassName == null || exceptionClassName.isBlank()) {
			Activator.getDefault().warning("Ignoring invalid undesirable exception: no exceptionClass provided; id = "
					+ configurationElement.getHandleId() + "; name = " + configurationElement.getName());
			return;
		}
		Object instance;
		try {
			instance = configurationElement.createExecutableExtension(ATTR_NAME_EXCEPTION_CLASS);
		} catch (CoreException e) {
			Activator.getDefault().warning(
					"Ignoring invalid undesirable exception: unable to create executable extension for exceptionClass; id = "
							+ configurationElement.getHandleId() + "; name = " + configurationElement.getName()
							+ "; exceptionClass = " + exceptionClassName);
			return;
		}
		Class<?> klass = instance.getClass();
		Class<? extends Throwable> exceptionClass;
		try {
			exceptionClass = klass.asSubclass(Throwable.class);
		} catch (ClassCastException e) {
			Activator.getDefault().warning(
					"Ignoring invalid undesirable exception: class provided is not a subclass of java.lang.Throwable; id = "
							+ configurationElement.getHandleId() + "; name = " + configurationElement.getName()
							+ "; exceptionClass = " + exceptionClassName);
			return;
		}
		String originClassNamePattern = configurationElement.getAttribute(ATTR_NAME_ORIGIN_CLASS_NAME_PATTERN);
		String originMethodNamePattern = configurationElement.getAttribute(ATTR_NAME_ORIGIN_METHOD_NAME_PATTERN);
		String maximumDepthStr = configurationElement.getAttribute(ATTR_NAME_MAXIMUM_DEPTH);
		Integer maximumDepth = null;
		try {
			maximumDepth = Integer.parseInt(maximumDepthStr);
		} catch (NumberFormatException e) {
			Activator.getDefault().warning(
					"Ignoring invalid maximum depth in undesirable exception: maximumDepth is not an integer; id = "
							+ configurationElement.getHandleId() + "; name = " + configurationElement.getName()
							+ "; maximumDepth = " + maximumDepthStr);
		}
		UndesirableException undesirableException = new UndesirableException(exceptionClass, originClassNamePattern,
				originMethodNamePattern, maximumDepth);
		undesirableExceptions.add(undesirableException);
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

	private boolean filter(Throwable exception) {
		// For each undesirable exception...
		for (UndesirableException undesirableException : getUndesirableExceptions()) {
			// If the given exception is an instance of the undesirable exception
			if (undesirableException.getExceptionClass().isInstance(exception)) {
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

}
