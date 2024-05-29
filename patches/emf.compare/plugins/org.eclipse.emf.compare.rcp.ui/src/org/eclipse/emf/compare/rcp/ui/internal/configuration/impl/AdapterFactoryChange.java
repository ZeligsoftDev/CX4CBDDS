/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.IAdapterFactoryChange;

public class AdapterFactoryChange extends CompareEvent<AdapterFactory> implements IAdapterFactoryChange {
	public AdapterFactoryChange(AdapterFactory oldValue, AdapterFactory newValue) {
		super(oldValue, newValue);
	}
}
