/*******************************************************************************
 * Copyright (c) 2013, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.provider.ExtendedAdapterFactoryItemDelegator;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;

/**
 * An abstract implementation of {@link ITypedElement}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public abstract class AbstractTypedElementAdapter implements ITypedElement {

	/** The adapter factory to use to retrieve item. */
	private final AdapterFactory fAdapterFactory;

	/** The item delegator to use to retrieve item. */
	private final ExtendedAdapterFactoryItemDelegator itemDelegator;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapter factory used to create accessor.
	 */
	public AbstractTypedElementAdapter(AdapterFactory adapterFactory) {
		fAdapterFactory = adapterFactory;
		itemDelegator = new ExtendedAdapterFactoryItemDelegator(getRootAdapterFactory());
	}

	/**
	 * Gets the root factory if this local adapter factory is composed, otherwise just the local one.
	 * 
	 * @return the root factory if this local adapter factory is composed, otherwise just the local one.
	 */
	protected AdapterFactory getRootAdapterFactory() {
		if (fAdapterFactory instanceof ComposeableAdapterFactory) {
			return ((ComposeableAdapterFactory)fAdapterFactory).getRootAdapterFactory();
		}

		return fAdapterFactory;
	}

	/**
	 * Returns the adapter factory to use to retrieve item.
	 * 
	 * @return the adapter factory to use to retrieve item.
	 */
	protected AdapterFactory getAdapterFactory() {
		return fAdapterFactory;
	}

	/**
	 * Returns the item delegator to use to retrieve item.
	 * 
	 * @return the item delegator to use to retrieve item..
	 */
	protected ExtendedAdapterFactoryItemDelegator getItemDelegator() {
		return itemDelegator;
	}
}
