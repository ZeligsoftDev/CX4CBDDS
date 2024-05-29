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
package org.eclipse.emf.compare.rcp.ui.internal.configuration.impl;

import org.eclipse.emf.compare.merge.IDiffRelationshipComputer;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IDiffRelationshipComputerChange;

/**
 * A change for {@link IDiffRelationshipComputer}.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
public class DiffRelationshipComputerChange extends CompareEvent<IDiffRelationshipComputer> implements IDiffRelationshipComputerChange {
	public DiffRelationshipComputerChange(IDiffRelationshipComputer oldValue,
			IDiffRelationshipComputer newValue) {
		super(oldValue, newValue);
	}
}
