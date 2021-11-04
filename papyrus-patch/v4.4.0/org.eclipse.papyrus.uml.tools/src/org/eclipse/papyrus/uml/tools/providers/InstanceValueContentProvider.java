/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Type;

/**
 * A Content provider for the value of an InstanceValue
 *
 * The valid instance specifications are filtered according to the type of the
 * InstanceValue
 *
 * @author Camille Letavernier
 *
 * @see InstanceValue#getType()
 * @see InstanceValueViewerFilter
 */
public class InstanceValueContentProvider extends ServiceEditFilteredContentProvider {

	private InstanceValue source;

	/**
	 *
	 * Constructor.
	 *
	 * @param source
	 *            The InstanceValue being edited
	 * @param feature
	 *            The EStructuralFeature being edited
	 * @param root
	 *            The root ResourceSet for the Tree representing the model
	 */
	public InstanceValueContentProvider(InstanceValue source, EStructuralFeature feature, ResourceSet root) {
		super(source, feature, root);
		this.source = source;
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param source
	 *            The InstanceValue being edited
	 * @param feature
	 *            The EStructuralFeature being edited
	 * @param roots
	 *            The root EObjects for the Tree representing the model
	 */
	public InstanceValueContentProvider(InstanceValue source, EStructuralFeature feature, EObject[] roots) {
		super(source, feature, roots);
		this.source = source;
	}

	@Override
	public boolean isValidValue(Object element) {
		if (!super.isValidValue(element)) {
			return false;
		}

		if (source.getType() == null) {
			return true;
		}

		Type type = source.getType();

		InstanceSpecification instance = (InstanceSpecification) UMLUtil.resolveUMLElement(element);

		if (type instanceof Enumeration) {
			return ((Enumeration) type).getOwnedLiterals().contains(instance);
		} else if (type instanceof Classifier) {
			Classifier classifier = (Classifier) type;
			if (instance.getClassifiers().contains(classifier)) {
				return true;
			}

			for (Classifier implementedClassifier : instance.getClassifiers()) {
				if (implementedClassifier.conformsTo(classifier)) {
					return true;
				}
			}
			return false;
		}

		return true;
	}

}
