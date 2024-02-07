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
package org.eclipse.papyrus.compare.diagram.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.diagram.ComparePapyrusMessages;
import org.eclipse.papyrus.compare.diagram.internal.CompareDiagramPapyrusPlugin;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;

/**
 * This class can be used to handle the model extension point of Papyrus.
 * 
 * @author Stefan Dirix <sdirix@eclipsesource.com>
 * @since 1.2
 */
public final class ModelExtensionUtil {

	/**
	 * Defined because the corresponding field in ModelsReader is private.
	 */
	private static final String FILE_EXTENSION_ATTRIBUTE = "fileExtension"; //$NON-NLS-1$

	/**
	 * Defined because the corresponding field in ModelsReader is private.
	 */
	private static final String CLASSNAME_ATTRIBUTE = "classname"; //$NON-NLS-1$

	/**
	 * Method name to request save parameters.
	 */
	private static final String SAVE_PARAMETERS_METHOD = "getSaveOptions"; //$NON-NLS-1$

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
	 */
	public static IConfigurationElement[] getModelExtensions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(
				org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID, ModelsReader.EXTENSION_POINT_NAME);
	}

	/**
	 * Determines all file extensions directly registered with the model extension point of Papyrus.
	 * 
	 * @return A possibly empty collection of registered file extensions. Does not contain {@code null} values
	 *         or duplicates.
	 */
	public static Collection<String> getRegisteredFileExtensions() {
		Set<String> fileExtensions = new LinkedHashSet<String>();
		IConfigurationElement[] modelExtensions = getModelExtensions();

		for (IConfigurationElement element : modelExtensions) {
			if (ModelsReader.MODEL_ELEMENT_NAME.equals(element.getName())) {
				String fileExtension = element.getAttribute(FILE_EXTENSION_ATTRIBUTE);
				if (fileExtension != null) {
					fileExtensions.add(fileExtension);
				}
			}
		}
		return fileExtensions;
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
	 */
	public static Map<?, ?> getSaveParameters(String resourceExtension) {
		IConfigurationElement[] modelExtensions = getModelExtensions();

		Map<?, ?> saveOptions = Collections.EMPTY_MAP;

		for (IConfigurationElement element : modelExtensions) {
			if (ModelsReader.MODEL_ELEMENT_NAME.equals(element.getName())) {
				String fileExtension = element.getAttribute(FILE_EXTENSION_ATTRIBUTE);
				if (fileExtension != null && fileExtension.equals(resourceExtension)) {

					// Try to load the IModel class and request save parameters if the IModel class extends
					// the AbstractBaseModel. This should not fail but maybe does anyway since the IModel
					// class can't be initialized here. If this is the case return the default Papyrus save
					// parameters.
					try {
						IModel imodel = (IModel)element.createExecutableExtension(CLASSNAME_ATTRIBUTE);

						if (imodel instanceof AbstractBaseModel) {
							try {
								AbstractBaseModel model = (AbstractBaseModel)imodel;

								// use reflection since there is no good reason why this method is protected
								// instead of public (like the static default version since version 1.1.0).
								// Also
								// protected means it is part of the API and will not change.
								Method getSaveParametersMethod = model.getClass()
										.getDeclaredMethod(SAVE_PARAMETERS_METHOD, new Class[0]);
								getSaveParametersMethod.setAccessible(true);
								saveOptions = (Map<?, ?>)getSaveParametersMethod.invoke(model, new Object[0]);
								// CHECKSTYLE:OFF We do want to catch any exception
							} catch (Exception e) {
								// CHECKSTYLE:ON
								return getDefaultSaveOptions();
							}
						}
					} catch (CoreException e) {
						// Configuration problem
						CompareDiagramPapyrusPlugin.getDefault().getLog()
								.log(new Status(IStatus.ERROR, CompareDiagramPapyrusPlugin.PLUGIN_ID,
										ComparePapyrusMessages.getString("ModelExtensionUtil.InvalidConfig", //$NON-NLS-1$
												fileExtension)));
					}
					break; // We have found the extension, no need to continue iterating
				}
			}
		}

		if (saveOptions == null) {
			saveOptions = Collections.EMPTY_MAP;
		}

		return saveOptions;
	}

	/**
	 * This method returns the default save options of {@link AbstractBaseModel}.
	 * 
	 * @return The default save options of {@link AbstractBaseModel}.
	 */
	private static Map<?, ?> getDefaultSaveOptions() {
		DefaultSaveOptionsClass saveOptions = new DefaultSaveOptionsClass();
		return saveOptions.getMyDefaultSaveOptions();
	}

	/**
	 * Workaround class to access the default save options which are hidden behind a "protected" barrier
	 * before version 1.1.0.
	 */
	private static class DefaultSaveOptionsClass extends AbstractBaseModel {

		public Map<?, ?> getMyDefaultSaveOptions() {
			return getSaveOptions();
		}

		@Override
		protected String getModelFileExtension() {
			return null;
		}

		@Override
		public String getIdentifier() {
			return null;
		}

		/**
		 * Stub implementation, which always returns <code>false</code>.
		 * <p>
		 * Since Papyrus 2.0, {@link AbstractBaseModel} forces us to implement
		 * {@link AbstractBaseModel#canPersist(EObject)}. We omit <code>@Override</code> on purpose to be
		 * backward compatible.
		 * </p>
		 * 
		 * @param eObject
		 *            This parameter will be ignored.
		 * @return <code>false</code>.
		 */
		@SuppressWarnings("all")
		public boolean canPersist(EObject eObject) {
			return false;
		}

		/**
		 * Stub implementation, which does nothing.
		 * <p>
		 * Since Papyrus 2.0, {@link AbstractBaseModel} forces us to implement
		 * {@link AbstractBaseModel#persist(EObject)}. We omit <code>@Override</code> on purpose to be
		 * backward compatible.
		 * </p>
		 * 
		 * @param eObject
		 *            This parameter will be ignored.
		 */
		@SuppressWarnings("all")
		public void persist(EObject eObject) {
			// no implementation
		}
	}
}
