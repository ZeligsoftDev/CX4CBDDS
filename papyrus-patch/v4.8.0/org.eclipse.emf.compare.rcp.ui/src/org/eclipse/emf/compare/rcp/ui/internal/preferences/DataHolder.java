/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;

/**
 * POJO used to hold data from preference page.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 * @param <T>
 *            Type of the item descriptor.
 */
public class DataHolder<T> {

	/** Field name (used for databinding). */
	public static final String DATA_FIELD_NAME = "data"; //$NON-NLS-1$

	/** Filed holding multiple data. */
	private Set<IItemDescriptor<T>> data = new LinkedHashSet<IItemDescriptor<T>>();

	/**
	 * Get data.
	 * 
	 * @return Set<IItemDescriptor<T>>
	 */
	public Set<IItemDescriptor<T>> getData() {
		return data;
	}

	/**
	 * Set data.
	 * 
	 * @param currentSelection
	 *            .
	 */
	public void setData(Set<IItemDescriptor<T>> currentSelection) {
		this.data = currentSelection;
	}

}
