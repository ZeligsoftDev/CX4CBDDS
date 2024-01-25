/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.papyrus.infra.architecture.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * A registry for architecture model command providers registered in extensions
 * 
 * @since 1.0
 */
public class ModelCommandProviderRegistry implements IModelCommandProvider {

	/**
	 * The extension point id
	 */
	private static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".commandProviders";

	/**
	 * The name of the class attribute
	 */
	private static final String PROVIDER_CLASS = "class";

	/**
	 * The singleton instance of this class
	 */
	private static ModelCommandProviderRegistry registry;

	/**
	 * A collection of registerd command providers
	 */
	private Collection<IModelCommandProvider> providers;

	/**
	 * Gets the singleton instance of this class
	 * 
	 * @return the singleton instance
	 */
	public static synchronized ModelCommandProviderRegistry getInstance() {
		if (registry == null) {
			registry = new ModelCommandProviderRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Gets a model creation command that aggregates the contributions of the command providers
	 * The model is created in the given model set based on the given context id
	 * 
	 * @param modelSet the model set to create the model in
	 * @param contextId context id for which a model is created
	 * @return a command to create a model
	 */
	@Override
	public Command getModelCreationCommand(ModelSet modelSet, String contextId) {
		CompoundCommand cc = new CompoundCommand("Contributions to Model Creation");
		for (IModelCommandProvider provider : providers) {
			cc.append(provider.getModelCreationCommand(modelSet, contextId));
		}
		return cc.isEmpty() ? null : cc;
	}

	/**
	 * Gets a model conversion command that aggregates the contributions of the command providers
	 * The model is converted in the given model set based on the given new context id
	 * 
	 * @param modelSet the model set that contains the model to be converted
	 * @param contextId the context id for which a model is converted
	 * @return a command to convert a model to the given context id
	 */
	@Override
	public Command getModelConversionCommand(ModelSet modelSet, String contextId) {
		CompoundCommand cc = new CompoundCommand("Contributions to Model Conversion");
		for (IModelCommandProvider provider : providers) {
			cc.append(provider.getModelConversionCommand(modelSet, contextId));
		}
		return cc.isEmpty() ? null : cc;
	}

	/*
	 * initializes the registry from extensions
	 */
	private void init() {
		providers = new ArrayList<>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		for (IConfigurationElement configurationElement : elements) {
			try {
				Object providerClass = configurationElement.createExecutableExtension(PROVIDER_CLASS);
				if (providerClass instanceof IModelCommandProvider) {
					providers.add((IModelCommandProvider) providerClass);
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}
}
