/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 508526
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.IStreamContentAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.impl.AbstractTypedElementAdapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * A specific {@link org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.IStreamContentAccessor}
 * for resources.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class ResourceStreamAccessorImpl extends AbstractTypedElementAdapter implements IStreamContentAccessor {

	/** The default size of the input stream resource contents. */
	private static final int INPUT_STREAM_DEFAULT_SIZE = 10240;

	/** The resource associated to this accessor. */
	private final Resource fResource;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            the adapater factory used to create the accessor.
	 * @param resource
	 *            the Resource to associate with the accessor.
	 */
	public ResourceStreamAccessorImpl(AdapterFactory adapterFactory, Resource resource) {
		super(adapterFactory);
		this.fResource = resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getName()
	 */
	public String getName() {
		return this.getClass().getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getImage()
	 */
	public Image getImage() {
		Object image = getItemDelegator().getImage(fResource);
		return ExtendedImageRegistry.getInstance().getImage(image);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		return "org.eclipse.emf.compare.rcp.ui.fallbackText"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.IStreamContentAccessor#getContents()
	 */
	public InputStream getContents() throws CoreException {
		ByteArrayOutputStream os = new ByteArrayOutputStream(INPUT_STREAM_DEFAULT_SIZE);
		try {
			fResource.save(os, new LinkedHashMap<>());
		} catch (IOException e) {
			EMFCompareRCPUIPlugin.getDefault().log(e);
		}
		return new ByteArrayInputStream(os.toByteArray());
	}
}
