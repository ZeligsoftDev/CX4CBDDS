/**
 * Copyright (c) 2014, 2018 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Obeo - initial API and implementation 
 */
package org.eclipse.ocl.pivot.internal.plugin;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.registry.CompleteOCLRegistry;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the Complete OCL resource registry.
 * 
 * @author <a href="mailto:marwa.rostren@obeo.fr">Marwa Rostren</a>
 */
public class CompleteOCLRegistryReader extends RegistryReader
{
	private static final @NonNull String TAG_DOCUMENT = "document";
	private static final @NonNull String TAG_FOR = "for";
	private static final @NonNull String ATTRIBUTE_RESOURCE = "resource";
	private static final @NonNull String ATTRIBUTE_URI = "uri";
	
	protected final @NonNull CompleteOCLRegistry registry;

	public CompleteOCLRegistryReader(@NonNull CompleteOCLRegistry registry) {
		super(Platform.getExtensionRegistry(), PivotPlugin.PLUGIN_ID, PivotPlugin.COMPLETE_OCL_REGISTRY_PID);
		this.registry = registry;
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		String tagName = element.getName();
		if (TAG_FOR.equals(tagName)) {
			return true;
		}
		if (!TAG_DOCUMENT.equals(tagName)) {
			return false;
		}
		final String filePath = element.getAttribute(ATTRIBUTE_RESOURCE);
		boolean recognized = true;
		if (filePath == null) {
			logMissingAttribute(element, ATTRIBUTE_RESOURCE);
			recognized = false;
		} else {
			Set<String> nsURIs = new HashSet<String>();
			for (IConfigurationElement childElement : element.getChildren(TAG_FOR)) {
				final String nsURI = childElement.getAttribute(ATTRIBUTE_URI);
				if (nsURI == null) {
					logMissingAttribute(childElement, ATTRIBUTE_URI);
					recognized = false;
				}
				else {
					nsURIs.add(nsURI);
				}
			}
			URI declaredURI = URI.createURI(filePath);
			String bundleName = "/" + element.getDeclaringExtension().getContributor().getName() + "/";
			URI bundleURI = URI.createPlatformPluginURI(bundleName, true);
			@NonNull URI resourceURI = declaredURI.resolve(bundleURI);
			CompleteOCLRegistry.Registration registration = new CompleteOCLRegistry.Registration(resourceURI, nsURIs);
			if (add) {
				registry.addRegistration(registration);
			} else {
				registry.removeRegistration(registration);
			}
		}
		return recognized;
	}
}
