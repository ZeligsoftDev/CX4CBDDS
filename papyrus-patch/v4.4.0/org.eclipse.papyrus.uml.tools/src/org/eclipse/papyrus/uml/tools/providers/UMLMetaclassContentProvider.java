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
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;

/**
 * The metaclass content provider
 *
 * @author Vincent Lorenzo
 *
 */
public class UMLMetaclassContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	/**
	 * the list of the avalaible metaclassse
	 */
	final private List<Class> possibleMetaclasses;

	/**
	 *
	 * Constructor.
	 *
	 * @param element
	 *            the element used to find the available metaclasses
	 */
	public UMLMetaclassContentProvider(final Element element) {
		this.possibleMetaclasses = ElementUtil.getPossibleMetaclasses(element);
		sortPossibleMetaClasses();
	}

	/**
	 * Handle MetaClasses list to sort it.
	 */
	private void sortPossibleMetaClasses() {
		Collections.sort(possibleMetaclasses, new Comparator<Class>() {

			public int compare(Class firstClass, Class secondClass) {

				// Use default lexicographically sorter of String based on Class name
				String firstName = UMLLabelInternationalization.getInstance().getLabel(firstClass);
				if (firstName == null) {
					return 0;
				}
				return firstName.compareTo(UMLLabelInternationalization.getInstance().getLabel(secondClass));

			}
		});
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 *
	 * @return
	 */
	public Object[] getElements() {
		return this.possibleMetaclasses.toArray();
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		return getElements();
	}
}
