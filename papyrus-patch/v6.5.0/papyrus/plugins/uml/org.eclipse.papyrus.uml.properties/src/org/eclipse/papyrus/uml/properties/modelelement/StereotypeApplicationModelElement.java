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
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.databinding.ProfileApplicationObservableList;
import org.eclipse.papyrus.uml.properties.databinding.StereotypeApplicationObservableList;
import org.eclipse.papyrus.uml.tools.providers.ApplicableStereotypeContentProvider;
import org.eclipse.papyrus.uml.tools.providers.ProfileLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A ModelElement for handling stereotypes applied on a UML Element,
 * and profiles on a UML Package
 *
 * @author Camille Letavernier
 */
public class StereotypeApplicationModelElement extends EMFModelElement {

	protected Element umlSource;

	protected EditPart sourceElement;

	/**
	 * The "stereotypeApplication" pseudo-property for a UML Element
	 */
	public static final String STEREOTYPE_APPLICATION = "stereotypeApplication"; //$NON-NLS-1$

	/**
	 *
	 * Constructor.
	 *
	 * @param editPart
	 *            The selected GMF Edit Part, associated to a UML Element
	 * @param domain
	 *            The EditingDomain on which the commands will be executed
	 */
	public StereotypeApplicationModelElement(EditPart editPart, EditingDomain domain) {
		this(UMLUtil.resolveUMLElement(editPart), domain);
		this.sourceElement = editPart;
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param umlSource
	 *            The UML Element on which the stereotypes or profiles will be applied on unapplied
	 * @param domain
	 *            The EditingDomain on which the commands will be executed
	 */
	public StereotypeApplicationModelElement(Element umlSource, EditingDomain domain) {
		super(umlSource, domain);
		this.umlSource = umlSource;
	}

	protected void setEditingDomain(EditingDomain domain) {
		this.domain = domain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservable doGetObservable(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if (propertyPath.equals(STEREOTYPE_APPLICATION)) {
			return new StereotypeApplicationObservableList(umlSource, domain);
		} else if (feature == UMLPackage.eINSTANCE.getPackage_ProfileApplication()) {
			return new ProfileApplicationObservableList((Package) umlSource, domain);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if (feature == UMLPackage.eINSTANCE.getPackage_ProfileApplication() && umlSource instanceof Package) {
			return new ProfileLabelProvider((Package) umlSource);
		}
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(umlSource.eResource()).getService(LabelProviderService.class).getLabelProvider();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return new LabelProvider();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		return new ApplicableStereotypeContentProvider(umlSource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUnique(String propertyPath) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isOrdered(String propertyPath) {
		return false;
	}

	/**
	 * @return the GMF Notation element associated to this UML Element, or
	 *         null if the element hasn't been selected with an EditPart
	 */
	public EModelElement getGraphicalElement() {
		if (sourceElement == null) {
			return null;
		}

		return (EModelElement) sourceElement.getModel();
	}

	/**
	 * @return the Edit Part associated to this UML Element
	 */
	public EditPart getEditPart() {
		return sourceElement;
	}

	/**
	 * @return the UML Element represented by this ModelElement
	 */
	public Element getUMLElement() {
		return umlSource;
	}

}
