/*******************************************************************************
 * Copyright (c) 2015, 2016 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Stefan Dirix - initial API and implementation
 *     Laurent Delaigue - Log invalid configuration
 *     Philip Langer - javadoc
 *******************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;

/**
 * This class can be used to handle the model extension point of Papyrus.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 2.4
 * @deprecated Use {@link org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil}
 */
@Deprecated
public final class ModelExtensionUtil {

	/**
	 * Disallow Constructor for Util classes.
	 */
	private ModelExtensionUtil() {
		// Disallow Constructor
	}

	/**
	 * Checks the platform registry for extensions registered on the model extension point of Papyrus.
	 * 
	 * @return A possibly empty array of {@link IConfigurationElement}s.
	 * @deprecated Use
	 *             {@link org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil#getModelExtensions()}
	 */
	@Deprecated
	public static IConfigurationElement[] getModelExtensions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(
				org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID, ModelsReader.EXTENSION_POINT_NAME);
	}

	/**
	 * Determines all file extensions directly registered with the model extension point of Papyrus.
	 * 
	 * @return A possibly empty collection of registered file extensions. Does not contain {@code null} values
	 *         or duplicates.
	 * @deprecated Use
	 *             {@link org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil#getRegisteredFileExtensions()}
	 */
	@Deprecated
	public static Collection<String> getRegisteredFileExtensions() {
		return org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil.getRegisteredFileExtensions();
	}

	/**
	 * <p>
	 * Returns the save parameters for the given {@code resourceExtension}. First a dynamic instance of the
	 * model registered to the extension point is created. If this model offers the option to determine its
	 * save options, they will be returned. If any error occurs during that process, the default save options
	 * for Papyrus models will be returned. If no dynamic instance can be created or the dynamic instance does
	 * not offer a way to determine its save options, an empty map will be returned.
	 * </p>
	 * <p>
	 * If multiple models are registered for the same file extension only the first model is looked at.
	 * </p>
	 * 
	 * @param resourceExtension
	 *            The file extension for which the save parameters are tried to be determined.
	 * @return A map with save options if they were successfully determined, an empty map otherwise.
	 * @deprecated Use
	 *             {@link org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil#getSaveParameters(String)}
	 */
	@Deprecated
	public static Map<?, ?> getSaveParameters(String resourceExtension) {
		return org.eclipse.papyrus.compare.diagram.util.ModelExtensionUtil
				.getSaveParameters(resourceExtension);
	}
}
