/*****************************************************************************
 * Copyright (c) 2010, 2018 CEA LIST.
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
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Bug 531802
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.TypeUtil;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;

/**
 *
 * This class provides method to manipulate {@link CollaborationUse}
 *
 */
public class UMLCollaborationUseEditorUtil {

	/**
	 * Returns a String representing the {@link CollaborationUse}
	 *
	 * @param collaborationUse
	 *            the {@link CollaborationUse}
	 * @return
	 * 		A String representing the {@link CollaborationUse}
	 */
	public static String getLabel(CollaborationUse collaborationUse) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(NamedElementUtil.getVisibilityAsSign(collaborationUse));

		// name
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(getName(collaborationUse));

		// type
		if (collaborationUse.getType() != null) {
			final List<Namespace> namespaces = collaborationUse.allNamespaces();
			final Namespace lastNamespace = (namespaces.size() - 1) >= 0 ? namespaces.get(namespaces.size() - 1) : null;
			buffer.append(" : " + getTypeLabel(collaborationUse.getType(), lastNamespace)); //$NON-NLS-1$
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME); //$NON-NLS-1$
		}
		return buffer.toString();
	}

	/**
	 * Returns the name of the {@link CollaborationUse}
	 *
	 * @param collaborationUse
	 *            the {@link CollaborationUse}
	 * @return
	 * 		The name of the {@link CollaborationUse}
	 */
	public static String getName(CollaborationUse collaborationUse) {
		if (collaborationUse.getName() != null) {
			return UMLLabelInternationalization.getInstance().getLabel(collaborationUse);
		} else {
			return (NamedElementUtil.getDefaultNameWithIncrement(collaborationUse));
		}
	}

	/**
	 * Returns a string representing the Type of the {@link CollaborationUse}
	 *
	 * @param type
	 *            the type of the CollaborationUse
	 * @return
	 * 		A string representing the Type of the {@link CollaborationUse}
	 */
	public static String getTypeLabel(Type type, Namespace model) {
		String label = ""; //$NON-NLS-1$

		if (null != model) {
			List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages());

			List<Package> visitedPackages = new ArrayList<Package>();
			Package currentPackage = type.getNearestPackage();

			boolean rootFound = false;

			while (currentPackage != null && !rootFound) {
				visitedPackages.add(currentPackage);
				if (importedPackages.contains(currentPackage) || currentPackage == model) {
					rootFound = true;
				}
				Element owner = currentPackage.getOwner();
				while (owner != null && !(owner instanceof Package)) {
					owner = owner.getOwner();
				}

				currentPackage = owner != null ? (Package) owner : null;
			}

			for (int i = visitedPackages.size() - 1; i >= 0; i--) {
				label += visitedPackages.get(i).getName() + "::"; //$NON-NLS-1$
			}
		}
		return label + type.getName();
	}
}
