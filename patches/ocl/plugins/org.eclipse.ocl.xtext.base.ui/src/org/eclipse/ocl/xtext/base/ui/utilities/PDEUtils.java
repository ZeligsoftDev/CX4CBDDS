/*******************************************************************************
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink (Obeo) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.xtext.base.ui.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.registry.CompleteOCLRegistry;
import org.eclipse.ocl.pivot.util.PivotPlugin;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * PDEUtils provides functionality exploiting PDE usage of the trget extension points..
 */
public class PDEUtils
{
	/**
	 * Create a new Complete OCL Registry from the workspace and plugin extension point registrations.
	 */
	public static @NonNull CompleteOCLRegistry createCompleteOCLRegistry() {
		CompleteOCLRegistry registry = new CompleteOCLRegistry();
		IPluginModelBase[] activeModels = PluginRegistry.getActiveModels(false);
		for (IPluginModelBase activeModel : activeModels) {
			if (activeModel != null) {
				for (IPluginExtension pluginExtension : activeModel.getExtensions().getExtensions()) {
					String point = pluginExtension.getPoint();
					if (PivotPlugin.COMPLETE_OCL_REGISTRY_QPID.equals(point)) {
						URI location = getLocation(activeModel);
						readCompleteOCLRegistryExtensionPoints(registry, location, pluginExtension);
					}
				}
			}
		}
		return registry;
	}

	private static @NonNull URI getLocation(@NonNull IPluginModelBase activeModel) {
		IResource underlyingResource = activeModel.getUnderlyingResource();
		if (underlyingResource != null) {
			String projectPath = underlyingResource.getProject().getFullPath().toString() + "/";
			URI projectURI = URI.createPlatformResourceURI(projectPath, true);
			return projectURI;
		}
		else {
			BundleDescription bundleDescription = activeModel.getBundleDescription();
			String bundlePath = bundleDescription.getSymbolicName() + "/";
			URI bundleURI = URI.createPlatformPluginURI(bundlePath, true);
			return bundleURI;
		}
	}

	private static void readCompleteOCLRegistryExtensionPoints(@NonNull CompleteOCLRegistry registry,
			@NonNull URI location, @NonNull IPluginExtension pluginExtension) {
		for (IPluginObject child1 : pluginExtension.getChildren()) {
			if (child1 instanceof IPluginElement) {
				CompleteOCLRegistry.Registration registration = readCompleteOCLRegistryExtensionPoint(location, (IPluginElement) child1);
				if (registration != null) {
					registry.addRegistration(registration);
				}
			}
		}
	}

	private static CompleteOCLRegistry.@Nullable Registration readCompleteOCLRegistryExtensionPoint(
			@NonNull URI location, @NonNull IPluginElement documentElement) {
		IPluginAttribute resourceAttribute = documentElement.getAttribute("resource");
		if (resourceAttribute == null) {
			return null;
		}
		List<String> nsURIs = new ArrayList<String>();
		for (IPluginObject child2 : documentElement.getChildren()) {
			if (child2 instanceof IPluginElement) {
				IPluginElement forElement = (IPluginElement) child2;
				IPluginAttribute uriAttribute = forElement.getAttribute("uri");
				if (uriAttribute == null) {
					return null;
				}
				String uriString = uriAttribute.getValue();
				if (uriString == null) {
					return null;
				}
				nsURIs.add(uriString);
			}
		}
		URI resourceURI = URI.createURI(resourceAttribute.getValue());
		@NonNull URI resolvedResourceURI = resourceURI.resolve(location);
		return new CompleteOCLRegistry.Registration(resolvedResourceURI, nsURIs);
	}
}
