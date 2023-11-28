/*****************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Philip Langer (EclipseSource) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.compare.diagram.ide.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * This hook initializes the ElementTypeSetConfigurationRegistry before a Papyrus resource is loaded.
 * <p>
 * The class
 * {@link org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry.ElementTypeSetConfigurationRegistry
 * ElementTypeSetConfigurationRegistry} is not available in Luna and in different bundles in Mars and Neon, so
 * we have to use reflection to be backwards compatible with all versions of Papyrus
 * </p>
 * 
 * @author Philip Langer <planger@eclipsesource.com>
 * @since 2.5
 */
public class ElementTypeSetConfigurationRegistryInitializingHook extends AbstractPapyrusResourceSetHook {

	/** The id of the bundle containing the class ElementTypeSetConfigurationRegistry in Mars. */
	private static final String BUNDLE_ID_MARS = "org.eclipse.papyrus.infra.elementtypesconfigurations"; //$NON-NLS-1$

	/** The id of the bundle containing the class ElementTypeSetConfigurationRegistry in Neon. */
	private static final String BUNDLE_ID_NEON = "org.eclipse.papyrus.infra.types.core"; //$NON-NLS-1$

	/** The method to be invoked in ElementTypeSetConfigurationRegistry. */
	private static final String GET_INSTANCE = "getInstance"; //$NON-NLS-1$

	/** The qualified class name of ElementTypeSetConfigurationRegistry in Mars. */
	private static final String ELEMENTTYPESETCONFIGREG_CLASS_NAME_MARS = "org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry"; //$NON-NLS-1$

	/** The qualified class name of ElementTypeSetConfigurationRegistry in Neon. */
	private static final String ELEMENTTYPESETCONFIGREG_CLASS_NAME_NEON = "org.eclipse.papyrus.infra.types.core.registries.ElementTypeSetConfigurationRegistry"; //$NON-NLS-1$

	@Override
	public void preLoadingHook(ResourceSet resourceSet, Collection<? extends URI> uris) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					// ElementTypeSetConfigurationRegistry is not available in Luna and in different bundles
					// in Mars and Neon, so we have to use reflection to be backwards compatible with all
					// versions of Papyrus
					Class<?> registryClass;
					Bundle bundle = Platform.getBundle(BUNDLE_ID_NEON);
					if (bundle != null) {
						registryClass = bundle.loadClass(ELEMENTTYPESETCONFIGREG_CLASS_NAME_NEON);
					} else {
						// neon bundle is not available, try mars bundle
						bundle = Platform.getBundle(BUNDLE_ID_MARS);
						registryClass = bundle.loadClass(ELEMENTTYPESETCONFIGREG_CLASS_NAME_MARS);
					}
					Method getInstanceMethod = registryClass.getDeclaredMethod(GET_INSTANCE);
					getInstanceMethod.invoke(null);
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NullPointerException e) {
					logException(e);
				}
			}
		});
	}

	/**
	 * Logs the specified exception <code>e</code>.
	 * 
	 * @param e
	 *            The exception to be logged.
	 */
	private void logException(Exception e) {
		CompareDiagramIDEUIPapyrusPlugin.getDefault().getLog()
				.log(new Status(IStatus.WARNING, CompareDiagramIDEUIPapyrusPlugin.PLUGIN_ID,
						"Could not initialize ElementTypeSetConfigurationRegistry before comparison", e)); //$NON-NLS-1$
	}
}
