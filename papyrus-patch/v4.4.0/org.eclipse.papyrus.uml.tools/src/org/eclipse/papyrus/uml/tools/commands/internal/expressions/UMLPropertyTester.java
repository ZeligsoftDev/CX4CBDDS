/*
 * Copyright (c) 2014, 2015 CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 465416
 *
 */
package org.eclipse.papyrus.uml.tools.commands.internal.expressions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


/**
 * This is the UMLPropertyTester type. Enjoy.
 */
public class UMLPropertyTester extends PropertyTester {

	public static final String IS_ROOT = "isRoot";

	public static final String PROFILE = "profile";

	public static final String STEREOTYPE = "stereotype";

	public UMLPropertyTester() {
		super();
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (IS_ROOT.equals(property)) {
			return Boolean.valueOf(isRoot(receiver)).equals(asBoolean(expectedValue));
		} else if (PROFILE.equals(property)) {
			return profileIsApplied(receiver, asString(expectedValue));
		} else if (STEREOTYPE.equals(property)) {
			return stereotypeIsApplied(receiver, asString(expectedValue));
		}
		return false;
	}

	protected Boolean asBoolean(Object value) {
		// the implicit expected-value for boolean properties is true
		return (value == null) ? Boolean.TRUE : (value instanceof Boolean) ? (Boolean) value : Boolean.FALSE;
	}

	protected String asString(Object value) {
		// the implicit expected-value for string properties is the empty string
		return (value == null) ? "" : (value instanceof String) ? (String) value : String.valueOf(value);
	}

	protected boolean isRoot(Object object) {
		boolean result = false;

		EObject eObject = EMFHelper.getEObject(object);
		if (eObject != null) {
			try {
				ModelSet modelSet = ServiceUtilsForEObject.getInstance().getModelSet(eObject);
				UmlModel uml = (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);

				try {
					result = (uml != null) && (uml.lookupRoot() == eObject);
				} catch (NotFoundException e) {
					// obviously, then, this isn't the root
					result = false;
				}
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}

		return result;
	}

	protected boolean profileIsApplied(Object value, String profile) {
		boolean result = false;

		EObject eObject = EMFHelper.getEObject(value);
		if (eObject instanceof Element) {
			Package package_ = ((Element) eObject).getNearestPackage();
			if (package_ != null) {
				result = package_.getAppliedProfile(profile, true) != null;
			}
		}

		return result;
	}

	protected boolean stereotypeIsApplied(Object value, String stereotype) {
		boolean result = false;

		EObject eObject = EMFHelper.getEObject(value);
		if (eObject instanceof Element) {
			Element element = (Element) eObject;
			result = element.getAppliedStereotype(stereotype) != null;
		}

		return result;
	}
}
