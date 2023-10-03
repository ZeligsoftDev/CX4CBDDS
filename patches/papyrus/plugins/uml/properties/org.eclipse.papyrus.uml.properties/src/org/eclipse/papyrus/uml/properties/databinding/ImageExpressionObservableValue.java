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
package org.eclipse.papyrus.uml.properties.databinding;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Image;

/**
 * An IObservableValue for editing Images
 *
 * @author Camille Letavernier
 * @since 3.3
 */
public class ImageExpressionObservableValue extends AbstractObservableValue implements IObserving {

	private Image image;

	private EditingDomain domain;

	/**
	 *
	 * Constructor.
	 *
	 * @param image
	 *            The UML Image element to edit
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 */
	public ImageExpressionObservableValue(Image image, EditingDomain domain) {
		this.image = image;
		this.domain = domain;
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		return ImageUtil.getExpression(image);
	}

	@Override
	protected void doSetValue(Object value) {
		if (value instanceof String) {
			final String expression = (String) value;

			Runnable runnable = new Runnable() {

				@Override
				public void run() {

					ImageUtil.setExpression(image, expression);
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
