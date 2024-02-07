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
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.DISPLAY_PLACE;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.HORIZONTAL;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.ICON;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.SHAPE;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.STEREOTYPE_DISPLAY;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT_ALIGNMENT;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.TEXT_AND_ICON;
import static org.eclipse.papyrus.uml.properties.util.StereotypeAppearanceConstants.VERTICAL;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElement;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.databinding.StereotypeAppearanceObservableValue;
import org.eclipse.uml2.uml.Element;

/**
 * A ModelElement for manipulating the stereotype appearance properties :
 * - stereotypeDisplay
 * - textAlignment
 * - displayPlace
 *
 * @author Camille Letavernier
 *
 */
public class StereotypeAppearanceModelElement extends AbstractModelElement {

	/**
	 * The current UML Element
	 */
	protected Element umlSource;

	/**
	 * The editing domain on which the commands will be called
	 */
	protected EditingDomain domain;

	/**
	 * The GMF EModelElement
	 */
	protected EModelElement diagramElement;

	/**
	 *
	 * Constructor.
	 *
	 * @param umlSource
	 *            The UML Element on which the stereotypes are applied
	 * @param domain
	 *            The Editing Domain on which the commands will be executed
	 * @param diagramElement
	 *            The GMF EModelElement
	 */
	public StereotypeAppearanceModelElement(Element umlSource, EditingDomain domain, EModelElement diagramElement) {
		this.umlSource = umlSource;
		this.domain = domain;
		this.diagramElement = diagramElement;
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		if (propertyPath.equals(STEREOTYPE_DISPLAY) || propertyPath.equals(TEXT_ALIGNMENT) || propertyPath.equals(DISPLAY_PLACE)) {
			return new StereotypeAppearanceObservableValue(diagramElement, umlSource, propertyPath, domain);
		}

		Activator.log.warn("Unknown property : " + propertyPath); //$NON-NLS-1$
		return null;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if (propertyPath.equals(STEREOTYPE_DISPLAY)) {
			return new StaticContentProvider(new String[] { TEXT, ICON, TEXT_AND_ICON, SHAPE });
		} else if (propertyPath.equals(TEXT_ALIGNMENT)) {
			return new StaticContentProvider(new String[] { HORIZONTAL, VERTICAL });
		} else if (propertyPath.equals(DISPLAY_PLACE)) {
			return new StaticContentProvider(new String[] { UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION, UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION });

		}

		return EmptyContentProvider.instance;
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		return true;
	}

	@Override
	public boolean isEditable(String propertyPath) {
		return !EMFHelper.isReadOnly(diagramElement);
	}
}
