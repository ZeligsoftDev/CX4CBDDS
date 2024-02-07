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
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.providers;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

public class CommentContentProvider implements IHierarchicContentProvider {

	public Object[] getElements(Object inputElement) {
		// Roots
		if (inputElement instanceof Collection) {
			return ((Collection<?>) inputElement).toArray();
		} else if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		}

		return new Object[] {};
	}

	public Object[] getChildren(Object parentElement) {
		// Comment's children

		List<Comment> result = new LinkedList<Comment>();

		Iterator<Setting> it = UML2Util.getNonNavigableInverseReferences((Element) parentElement).iterator();
		while (it.hasNext()) {
			Setting setting = it.next();
			if (setting.getEStructuralFeature() == UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT) {
				if (setting.getEObject() instanceof Comment) {
					Comment comment = (Comment) setting.getEObject();

					// small bugfix...
					// UML2Util.getNonNavigableInverseReferences returns more element than
					// needed, especially elements that are not real ones
					// so we must check if they are contained by the current resource or
					// not...
					boolean isProxy = false;
					for (Element annotatedElement : comment.getAnnotatedElements()) {
						if (annotatedElement.eResource() == null) {
							isProxy = true;
						}
					}

					// this is the real element, not a ghost one. display it in the list
					if (!isProxy) {
						if (comment.getAnnotatedElements().contains(parentElement)) {
							result.add(comment);
						}
					}

				}
			}
		}

		return result.toArray();
	}

	public Object getParent(Object element) {
		// useful ?
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public void dispose() {
		// Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing
	}

	public boolean isValidValue(Object element) {
		return true;
	}

}
