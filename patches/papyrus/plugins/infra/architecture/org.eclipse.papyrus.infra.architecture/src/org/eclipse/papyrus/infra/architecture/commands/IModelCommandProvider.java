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

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * An interface to provide architecture model creation and conversion commands by an extension
 * 
 * @since 1.0
 */
public interface IModelCommandProvider {

	/**
	 * Gets a model creation command that represents the contributions of a command provider
	 * The model is created in the given model set based on the given context id
	 * 
	 * @param modelSet the model set to create the model in
	 * @param contextId context id for which a model is created
	 * @return a command to create a model
	 */
	Command getModelCreationCommand(ModelSet modelSet, String contextId);

	/**
	 * Gets a model conversion command that represents the contributions of a command provider
	 * The model is converted in the given model set based on the given new context id
	 * 
	 * @param modelSet the model set that contains the model to be converted
	 * @param contextId the context id for which a model is converted
	 * @return a command to convert a model to the given context id
	 */
	Command getModelConversionCommand(ModelSet modelSet, String contextId);

}
