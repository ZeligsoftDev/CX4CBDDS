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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.util.PivotPlugin;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#INSTANCE
 * global} resource factory's
 * {@link org.eclipse.emf.ecore.resource.Resource.Factory.Registry#getProtocolToFactoryMap()
 * protocol} map. Clients are not expected to use this class directly.
 */
public class StandardLibraryRegistryReader extends RegistryReader
{
	static final @NonNull String TAG_LIBRARY = "library";
	static final @NonNull String ATT_URI = "uri";
	static final @NonNull String ATT_CLASS = "class";

	public StandardLibraryRegistryReader() {
		super(Platform.getExtensionRegistry(), PivotPlugin.getPlugin()
			.getBundle().getSymbolicName(), PivotPlugin.STANDARD_LIBRARY_PPID);
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals(TAG_LIBRARY)) {
			String uri = element.getAttribute(ATT_URI);
			if (uri == null) {
				logMissingAttribute(element, ATT_URI);
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				StandardLibraryContribution.Descriptor contribution = new StandardLibraryContribution.Descriptor(element, ATT_CLASS);
				Object previous = StandardLibraryContribution.REGISTRY.put(uri, contribution);
				OCLASResourceFactory.REGISTRY.put(PivotUtilInternal.getASURI(URI.createURI(uri)), contribution);
				if (previous instanceof StandardLibraryContribution.Descriptor) {
					StandardLibraryContribution.Descriptor descriptor = (StandardLibraryContribution.Descriptor) previous;
					EcorePlugin.INSTANCE.log("Both '"
							+ descriptor.getElement().getContributor().getName()
							+ "' and '" + element.getContributor().getName()
							+ "' register a setting delegate factory for '" + uri
							+ "'");
				}

				return true;
			} else {
				StandardLibraryContribution.REGISTRY.remove(uri);
				return true;
			}
		}
		return false;
	}
}
