/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.compatibility;

import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.common.util.URI;

/**
 * EMF_2_9 provides backwards compatible implementations of functionality first available in EMF 2.9.
 *
 * See OCLGenModelUtil for more general EMF/UML2 compatibility support,
 */
@SuppressWarnings("deprecation")
public class EMF_2_9
{
	private static final Method ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD;

	static {
		Method ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method = null;

		try {
			Class<?> pluginEcorePluginClass = org.eclipse.emf.ecore.plugin.EcorePlugin.class; //CommonPlugin.loadClass("org.eclipse.emf.ecore","org.eclipse.emf.ecore.plugin.EcorePlugin");
			ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method = pluginEcorePluginClass.getMethod("getEPackageNsURIToGenModelLocationMap", boolean.class);
		} catch (Throwable exception) {
			// Ignore.
		}

		ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD = ecorePlugin_getEPackageNsURIToGenModelLocationMap_Method;
	}

	public static class EcorePlugin {

		/**
		 * EMF 2.9 deprecates EcorePlugin.getEPackageNsURIToGenModelLocationMap() in favor of
		 * EcorePlugin.getEPackageNsURIToGenModelLocationMap(boolean) so redirect the new call
		 * to the original method if the new method unavailable.
		 *
		 * FIXME Bug 576593 need a tracking cache if targetPlatform true
		 */
		@SuppressWarnings("unchecked")
		public static Map<String, URI> getEPackageNsURIToGenModelLocationMap(boolean targetPlatform) {
			if (GenRuntimeVersion.get("2.14") == null) {			// less than Photon
				targetPlatform = false;								// Bug 576986 22 tests fail on Oxygen using a target platform
			}
		//	assert targetPlatform : "Running Platform is very unlikely to be appropriate"; // See Bug 576546/576593
			if (ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD != null) {
				try {
					return (Map<String, URI>) ECORE_PLUGIN_GET_EPACKAGE_NSURI_TO_GEN_MODEL_LOCATION_MAP_METHOD.invoke(null, targetPlatform);
				} catch (Exception e) {
				}
			}
			return org.eclipse.emf.ecore.plugin.EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		}
	}
}
