/*******************************************************************************
 * Copyright (c) 2017 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration;

import org.eclipse.emf.compare.merge.IDiffRelationshipComputer;
import org.eclipse.emf.compare.rcp.ui.configuration.ICompareEvent;

/**
 * Event indicating a change in {@link IDiffRelationshipComputer}.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public interface IDiffRelationshipComputerChange extends ICompareEvent {

	/**
	 * Previous value of the {@link IDiffRelationshipComputer}.
	 * 
	 * @return previous value of the {@link IDiffRelationshipComputer}.
	 */
	IDiffRelationshipComputer getOldValue();

	/**
	 * New value of the {@link IDiffRelationshipComputer}.
	 * 
	 * @return new value of the {@link IDiffRelationshipComputer}.
	 */
	IDiffRelationshipComputer getNewValue();
}
