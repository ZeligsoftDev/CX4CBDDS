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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.zeligsoft.domain.dds4ccm.ui.errorhandlers.Activator;

/**
 * This class stores {@link UndesirableException}s that have been registered through the "undesirableExceptions"
 * extension point.
 * 
 * <p>The extension point is loaded lazily, when the {@link #getUndesirableExceptions()} method is first invoked.
 * 
 * @author Ernesto Posse
 */
public class UndesirableExceptionRegistry {

	public final String UNDESIRABLE_EXCEPTIONS_EXTENSION_POINT_ID = "undesirableExceptions";
	public final String ATTR_NAME_EXCEPTION_CLASS_NAME = "exceptionClassName";
	public final String ATTR_NAME_ORIGIN_CLASS_NAME_PATTERN = "originClassNamePattern";
	public final String ATTR_NAME_ORIGIN_METHOD_NAME_PATTERN = "originMethodNamePattern";
	public final String ATTR_NAME_MAXIMUM_DEPTH = "maximumDepth";

	private List<UndesirableException> undesirableExceptions = null;

	/**
	 * Get the list of all undesirable exceptions registered through the exception point.
	 * 
	 * @return A {@link List} of {@link UndesirableException}s.
	 */
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
		String exceptionClassName = configurationElement.getAttribute(ATTR_NAME_EXCEPTION_CLASS_NAME);
		if (exceptionClassName == null || exceptionClassName.isBlank()) {
			Activator.getDefault().warning("Ignoring invalid undesirable exception: no exceptionClassName provided; id = "
					+ configurationElement.getHandleId() + "; name = " + configurationElement.getName());
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
		UndesirableException undesirableException = new UndesirableException(exceptionClassName, originClassNamePattern,
				originMethodNamePattern, maximumDepth);
		undesirableExceptions.add(undesirableException);
	}


}
