/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


/**
 * A semantic Hierarchic Content Provider, which only browses the UML Containment tree.
 * Standard references are ignored
 *
 * @author Camille Letavernier
 *
 */
public class UMLContainerContentProvider extends SemanticUMLContentProvider {

	protected EClass type;

	protected Object input;

	public UMLContainerContentProvider(EObject editedEObject, EReference reference, EObject[] roots) {
		super(editedEObject, reference, roots);
		type = (EClass) reference.getEType();
	}

	public UMLContainerContentProvider(EObject editedEObject, EReference reference) {
		super(editedEObject, reference);
		type = (EClass) reference.getEType();
	}

	public UMLContainerContentProvider(EObject editedEObject, EReference reference, ResourceSet root) {
		super(editedEObject, reference, root);
		type = (EClass) reference.getEType();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		this.input = newInput;
		if (newInput instanceof EObject) {
			this.type = ((EObject) newInput).eClass();
		}
	}

	@Override
	public boolean isValidValue(Object value) {
		Object adaptedValue = getAdaptedValue(value);
		if (adaptedValue instanceof EObject) {
			// We cannot create objects in a read-only object
			if (EMFHelper.isReadOnly((EObject) adaptedValue)) {
				return false;
			}

			// We need at least one valid containment reference to store this
			// type of object
			for (EReference reference : ((EObject) adaptedValue).eClass().getEAllReferences()) {
				if (reference.isContainment() && EMFHelper.isSubclass(this.type, reference.getEReferenceType())) {
					return true;
				}
			}
		}
		return false;
	}

}
