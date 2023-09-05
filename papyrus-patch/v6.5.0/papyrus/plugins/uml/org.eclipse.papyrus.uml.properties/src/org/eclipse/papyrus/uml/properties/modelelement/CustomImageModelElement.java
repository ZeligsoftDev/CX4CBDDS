/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import static org.eclipse.papyrus.uml.properties.databinding.ImageKindObservableValue.KIND_ICON;
import static org.eclipse.papyrus.uml.properties.databinding.ImageKindObservableValue.KIND_SHAPE;
import static org.eclipse.papyrus.uml.properties.databinding.ImageKindObservableValue.KIND_UNDEFINED;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.databinding.ImageExpressionObservableValue;
import org.eclipse.papyrus.uml.properties.databinding.ImageKindObservableValue;
import org.eclipse.papyrus.uml.properties.databinding.ImageNameObservableValue;
import org.eclipse.uml2.uml.Image;

/**
 * A Model Element for manipulating Stereotype icons in Papyrus
 *
 * @author Camille Letavernier
 */
public class CustomImageModelElement extends AbstractModelElement {

	/**
	 * The image represented by this model element
	 */
	protected Image image;

	/**
	 * The editing domain on which the commands will be executed
	 */
	protected EditingDomain editingDomain;

	/**
	 * The Image::kind property
	 */
	public static final String KIND = "kind"; //$NON-NLS-1$

	/**
	 * The Image::expression property
	 */
	public static final String EXPRESSION = "expression"; //$NON-NLS-1$

	/**
	 * The Image::name property
	 */
	public static final String NAME = "name"; //$NON-NLS-1$

	/**
	 *
	 * Constructor.
	 *
	 * @param umlSource
	 *            The image represented by this model element
	 * @param domain
	 *            The editing domain on which the commands will be executed
	 */
	public CustomImageModelElement(Image umlSource, EditingDomain domain) {
		this.image = umlSource;
		this.editingDomain = domain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IObservable doGetObservable(String propertyPath) {
		if (propertyPath.equals(KIND)) {
			return new ImageKindObservableValue(image, editingDomain);
		} else if (propertyPath.equals(EXPRESSION)) {
			return new ImageExpressionObservableValue(image, editingDomain);
		} else if (propertyPath.equals(NAME)) {
			return new ImageNameObservableValue(image, editingDomain);
		}

		Activator.log.warn("Unknown property : " + propertyPath); //$NON-NLS-1$

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if (propertyPath.equals(KIND)) {
			return new AbstractStaticContentProvider() {

				@Override
				public Object[] getElements() {
					return new String[] { KIND_UNDEFINED, KIND_ICON, KIND_SHAPE };
				}

			};
		}

		return EmptyContentProvider.instance;
	}

}
