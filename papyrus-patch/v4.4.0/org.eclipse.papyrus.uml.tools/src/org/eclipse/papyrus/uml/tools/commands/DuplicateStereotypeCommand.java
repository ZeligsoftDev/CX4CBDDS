/*****************************************************************************
 * Copyright (c) 2014, 2017, 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Gaabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 438511
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - bug 511045
 *  Ansgar Radermacher (CEA LIST), ansgar.radermacher@cea.fr - bug 521279 (copy/paste between models)
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - bug 552410
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * A Command to apply a Stereotype and its data to an UML Element
 *
 * @author Benoit Maggi
 */
public class DuplicateStereotypeCommand extends RecordingCommand {

	protected Element element;

	protected EObject stereotypeApplication;

	protected Stereotype stereotypeInTargetContext;

	/**
	 *
	 * Constructor.
	 *
	 * @param domain
	 *            The editing domain
	 * @param element
	 *            The UML Element on which the stereotype will be applied
	 * @param stereotypeApplication
	 *            The stereotype to apply
	 */
	public DuplicateStereotypeCommand(TransactionalEditingDomain domain, Element element, EObject stereotypeApplication) {
		this(domain, element, element, stereotypeApplication);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param domain
	 *            The editing domain
	 * @param element
	 *            The UML Element on which the stereotype will be applied
	 * @param targetContainer
	 *            target container for the element. This information is required to reload the stereotype to the target context.
	 *            It can not be deduced from the element, since the latter has not been added to the target container yet.
	 * @param stereotypeApplication
	 *            The stereotype to apply
	 */
	public DuplicateStereotypeCommand(TransactionalEditingDomain domain, Element element, Element targetContainer, EObject stereotypeApplication) {
		super(domain);
		this.element = element;
		this.stereotypeApplication = stereotypeApplication;
		// reload the stereotype in the new Context-ResourceSet (Required because in org.eclipse.uml2.uml.internal.operations.PackageOperations
		// L960 in getProfileApplication the test is using == instead of equals)
		Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
		Stereotype stereotypeInTargetContext = EMFHelper.reloadIntoContext(stereotype, targetContainer);
		this.stereotypeInTargetContext = stereotypeInTargetContext;
	}

	public Stereotype getStereotypeInTargetContext() {
		return stereotypeInTargetContext;
	}

	@Override
	protected void doExecute() {
		// Retrieve the stereotype application for the element
		EObject applyStereotype = element.getStereotypeApplication(stereotypeInTargetContext);
		// If the stereotype is not applied yet
		if (null == applyStereotype && null != element.eContainer()) {
			// Then apply it safely without triggering the exception when applying an already applied stereotype (bug 511045)
			applyStereotype = element.applyStereotype(stereotypeInTargetContext);
		}

		EList<EStructuralFeature> eStructuralFeatures = applyStereotype.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
			String name = eStructuralFeature.getName();
			if (!name.startsWith(Extension.METACLASS_ROLE_PREFIX) && eStructuralFeature.isChangeable()) {
				if (eStructuralFeature instanceof EReference && ((EReference) eStructuralFeature).isContainment()) {
					// In case that the structural feature is containment then we should copy the value not only change the reference
					Object value = stereotypeApplication.eGet(eStructuralFeature);
					if (value instanceof EObject) {
						EObject valueCopy = EcoreUtil.copy((EObject) value);
						applyStereotype.eSet(eStructuralFeature, valueCopy);
					} else if (value instanceof Collection<?>) {
						Collection<?> listValue = (Collection<?>) value;
						if (listValue.stream().allMatch(v -> v instanceof EObject)) {
							Collection<?> valueCopy = EcoreUtil.copyAll(listValue);
							applyStereotype.eSet(eStructuralFeature, valueCopy);
						}
					}
				} else {
					applyStereotype.eSet(eStructuralFeature, stereotypeApplication.eGet(eStructuralFeature));
				}
			}
		}
	}
}
