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
package org.eclipse.papyrus.uml.tools.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 *
 * This content providers is used to get the properties of stereotypes
 *
 */
public class UMLStereotypePropertyContentProvider implements IHierarchicContentProvider, IInheritedElementContentProvider, IIgnoreStereotypeBasePropertyContentProvider {

	/**
	 * the profiles
	 */
	protected List<Profile> profiles;

	/**
	 * this boolean is used to know if we should returns the Property base_EXTENDED_METACLASS or not
	 */
	private boolean ignoreBaseProperty;


	/**
	 * if <code>true</code> we don't return the inherited properties
	 */
	private boolean ignoreInheritedProperties;


	/**
	 *
	 * Constructor.
	 *
	 * @param profiles
	 *            the profiles to navigate
	 *
	 *            the boolean fields are initialized to false
	 */
	public UMLStereotypePropertyContentProvider(final List<Profile> profiles) {
		this.profiles = profiles;
		this.ignoreBaseProperty = false;
		this.ignoreInheritedProperties = false;
	}

	/**
	 *
	 * Constructor.
	 *
	 */
	public UMLStereotypePropertyContentProvider() {
		this(null);
	}


	/**
	 *
	 * @return
	 */
	public Object[] getElements() {
		return this.profiles.toArray();
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		return getElements();
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 *
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(Object parentElement) {
		List<Object> children = new ArrayList<Object>();
		if (hasChildren(parentElement)) {
			if (parentElement instanceof Package) {
				for (final EObject current : ((Package) parentElement).getOwnedMembers()) {
					if (hasChildren(current)) {
						children.add(current);
					}
				}
			} else if (parentElement instanceof Stereotype) {
				if (ignoreInheritedProperties) {
					if (this.ignoreBaseProperty) {
						children.addAll(StereotypeUtil.getStereotypePropertiesWithoutBaseProperties((Stereotype) parentElement));
					} else {
						children.addAll((((Stereotype) parentElement).getOwnedAttributes()));
					}

				} else {
					if (this.ignoreBaseProperty) {
						children.addAll(StereotypeUtil.getAllStereotypePropertiesWithoutBaseProperties((Stereotype) parentElement));

					} else {
						children.addAll((((Stereotype) parentElement).getAllAttributes()));
					}
				}
			}
		}
		return children.toArray();
	}



	/**
	 *
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof Element) {
			final TreeIterator<EObject> iter = ((EObject) element).eAllContents();
			while (iter.hasNext()) {
				if (isValidValue(iter.next())) {
					return true;
				}
			}
		}
		return false;
	}

	public void dispose() {
		profiles.clear();
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 *
	 * @param element
	 *            an element
	 * @return
	 *         <code>true</code> if the element is a Property owned by a Stereotype
	 */
	public boolean isValidValue(Object element) {
		if (element instanceof Element) {
			boolean result = element instanceof Property && ((Element) element).eContainer() instanceof Stereotype;
			if (result) {
				return StereotypeUtil.isValidStereotypeProperty((Property) element);
			}
			return result;
		}
		return false;
	}

	/**
	 *
	 * @param profiles
	 *            the list of the profiles to navigate
	 */
	public void setProfiles(final List<Profile> profiles) {
		this.profiles = profiles;
	}

	/**
	 * Setter for {@link #ignoreBaseProperty}
	 *
	 * @param ignoreBaseProperty
	 */
	public void setIgnoreBaseProperty(boolean ignoreBaseProperty) {
		this.ignoreBaseProperty = ignoreBaseProperty;
	}


	/**
	 *
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#setIgnoreInheritedElements(boolean)
	 *
	 * @param ignoreInheritedElements
	 */
	public void setIgnoreInheritedElements(final boolean ignoreInheritedElements) {
		this.ignoreInheritedProperties = ignoreInheritedElements;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#isIgnoringInheritedElements()
	 *
	 * @return
	 */
	public boolean isIgnoringInheritedElements() {
		return this.ignoreInheritedProperties;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.tools.providers.IIgnoreStereotypeBasePropertyContentProvider#isIgnoringBaseProperty()
	 *
	 * @return
	 */
	public boolean isIgnoringBaseProperty() {
		return this.ignoreBaseProperty;
	}
}
