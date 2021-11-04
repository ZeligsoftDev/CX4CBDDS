/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.providers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.emf.utils.EClassNameComparator;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This contents provider provides all UML EClass from UMLPackage
 * 
 * @since 3.0
 *
 */
public class UMLEClassContentProvider implements IStaticContentProvider {

	/**
	 * provided EClass
	 */
	private List<EClass> umlEClass;

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 * @return
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		return getElements();

	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 *
	 * @return
	 */
	@Override
	public Object[] getElements() {
		if (null == umlEClass) {
			umlEClass = UMLPackage.eINSTANCE.eContents().stream().filter(EClass.class::isInstance).map(EClass.class::cast).collect(Collectors.toList());
			umlEClass.sort(new EClassNameComparator());
		}
		return umlEClass.toArray();
	}

}
