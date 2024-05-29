/*******************************************************************************
 * Copyright (c) 2015 EclipseSource Muenchen GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Philip Langer - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer;

/**
 * Provider for {@link IModelUpdateStrategy model update strategies}.
 * 
 * @author Philip Langer <planger@eclipsesource.com>
 */
public interface IModelUpdateStrategyProvider {

	/**
	 * Returns the model update strategy to be used for updating the model.
	 * 
	 * @return the model update strategy to be used for updating the model.
	 */
	public IModelUpdateStrategy getModelUpdateStrategy();

}
