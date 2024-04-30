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
package org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.IStreamContentAccessor;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.TypeConstants;
import org.eclipse.emf.compare.utils.ReferenceUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * A {@link ITypedElement} that can be used as input of TextMergeViewer. The returned content is the value of
 * the given {@link EAttribute} on the given {@link EObject}.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 * @since 4.0
 */
public class StringAttributeChangeAccessor implements ITypedElement, IStreamContentAccessor {

	/**
	 * The EObject to get the value of the EAttribute from.
	 */
	private final EObject fEObject;

	/**
	 * The EAttribute to retrieve from the wrapped EObject.
	 */
	private final EAttribute fAttribute;

	/**
	 * Creates a new accessor for the given <code>eObject</code> and <code>eAttribute</code>.
	 * 
	 * @param eObject
	 *            The EObject to get the value of the EAttribute from.
	 * @param attributeChange
	 *            The attribute change to get the attribute Eattribute from.
	 */
	public StringAttributeChangeAccessor(EObject eObject, AttributeChange attributeChange) {
		this.fEObject = eObject;
		this.fAttribute = attributeChange.getAttribute();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.IStreamContentAccessor#getContents()
	 */
	public InputStream getContents() throws CoreException {
		Object value = ReferenceUtil.safeEGet(getEObject(), getEAtribute());
		String stringValue = EcoreUtil.convertToString(getEAtribute().getEAttributeType(), value);
		// Assume that the platform locale is appropriate.
		if (stringValue != null) {
			return new ByteArrayInputStream(stringValue.getBytes());
		} else {
			return new ByteArrayInputStream(new byte[0]);
		}
	}

	/**
	 * Returns the EObject to get the value of the EAttribute from.
	 * 
	 * @return the EObject to get the value of the EAttribute from.
	 */
	protected final EObject getEObject() {
		return fEObject;
	}

	/**
	 * Returns the EAttribute to retrieve from the wrapped EObject.
	 * 
	 * @return the EAttribute to retrieve from the wrapped EObject.
	 */
	protected final EAttribute getEAtribute() {
		return fAttribute;
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
		return ExtendedImageRegistry.getInstance()
				.getImage(EcoreEditPlugin.getPlugin().getImage("full/obj16/EAttribute")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.legacy.ITypedElement#getType()
	 */
	public String getType() {
		return TypeConstants.TYPE_ETEXT_DIFF;
	}

}
