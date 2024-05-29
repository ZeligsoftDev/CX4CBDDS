/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.legacy.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * A specific implementation of {@link AbstractTypedElementAdapter} for notifiers.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class TypedNotifier extends AbstractTypedElementAdapter {

	/** EMF ResourceSet type. */
	public static final String NODE_TYPE_EMF_RESOURCESET = "NODE_TYPE__EMF_RESOURCESET"; //$NON-NLS-1$

	/** EMF Resource type. */
	public static final String NODE_TYPE_EMF_RESOURCE = "NODE_TYPE__EMF_RESOURCE"; //$NON-NLS-1$

	/** EMF EObject type. */
	public static final String NODE_TYPE_EMF_EOBJECT = "NODE_TYPE__EMF_EOBJECT"; //$NON-NLS-1$

	/** EMF Comparison type. */
	public static final String NODE_TYPE_EMF_COMPARISON = "NODE_TYPE__EMF_COMPARISON"; //$NON-NLS-1$

	/** The notifier to use to retrieve the type. */
	private final Notifier fNotifier;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapter factory to use to retrieve item.
	 * @param notifier
	 *            the notifier to use to retrieve the type.
	 */
	public TypedNotifier(AdapterFactory adapterFactory, Notifier notifier) {
		super(adapterFactory);
		fNotifier = notifier;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getName()
	 */
	public String getName() {
		return getItemDelegator().getText(fNotifier);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getImage()
	 */
	public Image getImage() {
		Object imageObject = getItemDelegator().getImage(fNotifier);
		return ExtendedImageRegistry.getInstance().getImage(imageObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		final String type;
		if (fNotifier instanceof ResourceSet) {
			type = NODE_TYPE_EMF_RESOURCESET;
		} else if (fNotifier instanceof Resource) {
			type = NODE_TYPE_EMF_RESOURCE;
		} else if (fNotifier instanceof Comparison) {
			type = NODE_TYPE_EMF_COMPARISON;
		} else if (fNotifier instanceof EObject) {
			type = NODE_TYPE_EMF_EOBJECT;
		} else {
			type = ITypedElement.UNKNOWN_TYPE;
		}
		return type;
	}
}
