/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Image;

/**
 *
 * An IObservableValue to handle the way the image is displayed
 *
 * @author Camille Letavernier
 *
 * @deprecated since 4.3
 *             use {@link org.eclipe.papyrus.uml.properties.databinding.ImageKindObservableValue} API, instead
 *
 *             This class Will be removed in Papyrus 5.0, see bug 540829
 *
 */
@Deprecated
public class ImageKindObservableValue extends AbstractObservableValue implements IObserving {

	/**
	 * The kind of image display
	 * Undefined
	 */
	public static final String KIND_UNDEFINED = "undefined"; //$NON-NLS-1$

	/**
	 * The kind of image display
	 * Displays the image as an Icon in the element edit part
	 */
	public static final String KIND_ICON = "icon"; //$NON-NLS-1$

	/**
	 * The kind of image display
	 * The image replaces the element edit part
	 */
	public static final String KIND_SHAPE = "shape"; //$NON-NLS-1$

	private Image image;

	private EditingDomain domain;

	/**
	 *
	 * Constructor.
	 *
	 * @param image
	 *            The UML Image element
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 */
	public ImageKindObservableValue(Image image, EditingDomain domain) {
		this.image = image;
		this.domain = domain;
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String doGetValue() {
		return ImageUtil.getKind(image);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSetValue(Object value) {
		if (value instanceof String) {
			final String kind = (String) value;

			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					ImageUtil.setKind(image, kind);
				}
			};

			Command emfCommand = new ChangeCommand(domain, runnable);
			domain.getCommandStack().execute(emfCommand);
		}
	}

	@Override
	public Object getObserved() {
		return image;
	}
}
