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

import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * An Interface to create a model in a model set
 * 
 * @since 1.0
 */
public interface IModelCreationCommand {

	/**
	 * Creates the model in the given model set
	 *
	 * @param modelSet the model set
	 */
	void createModel(final ModelSet modelSet);

}
