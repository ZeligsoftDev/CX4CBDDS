/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.adapters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLDerivedUnionAdapter;

/**
 * @see for generation see {@link PapyrusUMLDerivedSubsetAdapter} This adapter allows to receive notifications for changes on feature :
 *      *
 *      <ul>
 *      <li>UMLPackage.Literals.PACKAGE__NESTED_PACKAGE</li>
 *      <li>UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE</li>
 *      <li>UMLPackage.Literals.PACKAGE__OWNED_TYPE</li>
 *      </ul>
 *
 * @author Vincent Lorenzo
 *
 */
public class PackageDerivedSubsetAdapter extends UMLDerivedUnionAdapter {

	@Override
	protected void notifyPackageChanged(Notification notification, EClass eClass) {
		super.notifyPackageChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Package.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyProfileChanged(Notification notification, EClass eClass) {
		super.notifyProfileChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Profile.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void notifyModelChanged(Notification notification, EClass eClass) {
		super.notifyModelChanged(notification, eClass);
		switch (notification.getFeatureID(org.eclipse.uml2.uml.Model.class)) {
		case UMLPackage.PACKAGE__PACKAGED_ELEMENT:
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__NESTED_PACKAGE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_STEREOTYPE);
			notifyChanged(notification, eClass, UMLPackage.Literals.PACKAGE__OWNED_TYPE);
			break;
		default:
			break;
		}
	}

}
