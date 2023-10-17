/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.pivot.internal.plugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
 * protocol} map. Clients are not expected to use this class directly.
 */
public class ASResourceFactoryRegistryReader extends RegistryReader
{
	static final @NonNull String TAG_FACTORY = "factory";
	static final @NonNull String ATT_CONTENT_TYPE = "contentType";
	static final @NonNull String ATT_EXTENSION = "extension";
	static final @NonNull String ATT_PRIORITY = "externalPriority";
	static final @NonNull String ATT_RESOURCE_CLASS = "resourceClass";
	static final @NonNull String ATT_CLASS = "class";

	public ASResourceFactoryRegistryReader() {
		super(Platform.getExtensionRegistry(), PivotPlugin.getPlugin()
			.getBundle().getSymbolicName(), PivotPlugin.AS_RESOURCE_FACTORY_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_FACTORY)) {
			String contentType = element.getAttribute(ATT_CONTENT_TYPE);
			String extension = element.getAttribute(ATT_EXTENSION);
			String resourceClass = element.getAttribute(ATT_RESOURCE_CLASS);
			String priorityString = element.getAttribute(ATT_PRIORITY);
			Integer priority = priorityString != null ? Integer.parseInt(priorityString) : null;
			if (contentType == null) {
				logMissingAttribute(element, ATT_CONTENT_TYPE);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				ASResourceFactoryContribution.Descriptor newDescriptor = new ASResourceFactoryContribution.Descriptor(element, priority, ATT_CLASS);
				Object previous = ASResourceFactoryRegistry.INSTANCE.addASResourceFactory(contentType, extension, resourceClass, newDescriptor);
				if (previous instanceof ASResourceFactoryContribution.Descriptor) {
					ASResourceFactoryContribution.Descriptor descriptor = (ASResourceFactoryContribution.Descriptor) previous;
					EcorePlugin.INSTANCE.log("Both '"
						+ descriptor.getElement().getContributor().getName()
						+ "' and '" + element.getContributor().getName()
						+ "' register an ASResourceFactory for '" + contentType
						+ "'");
				}
				return true;
			} else {
				ASResourceFactoryRegistry.INSTANCE.remove(contentType, extension, resourceClass);
				return true;
			}
		}
	    return false;
	}
}
