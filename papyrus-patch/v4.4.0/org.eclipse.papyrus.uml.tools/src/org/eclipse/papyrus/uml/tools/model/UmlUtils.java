/*****************************************************************************
 * Copyright (c) 2011, 2015 LIFL, CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  LIFL - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431618
 *  Christian W. Damus - bug 467016
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.tools.Activator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Set of utility methods linked to Trace for ControlMode
 *
 * @author cedric dumoulin
 *
 */
public class UmlUtils {
	private static final String ANNOTATION_SUBSETS = "subsets"; //$NON-NLS-1$

	/**
	 * Gets the UmlModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 *
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 *
	 *
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 */
	public static UmlModel getUmlModel() {

		try {
			return (UmlModel) ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(UmlModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the UmlModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor
	 * initialization.
	 *
	 *
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 * @throws ServiceException
	 *             If an error occurs while getting or starting the service.
	 */
	public static UmlModel getUmlModelChecked() throws ServiceException {

		return (UmlModel) ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Gets the UmlModel from the {@link ModelSet}. <br>
	 *
	 * @param modelSet
	 *            The modelManager containing the requested model.
	 *
	 * @return The {@link SashModel} registered in modelManager, or null if not
	 *         found.
	 */
	public static UmlModel getUmlModel(ModelSet modelSet) {

		return (UmlModel) modelSet.getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Gets the UmlModel from the {@link ServiceRegistry}.
	 *
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 */
	public static UmlModel getUmlModel(ServicesRegistry servicesRegistry) {

		try {
			return getUmlModelChecked(servicesRegistry);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the UmlModel from the {@link ServiceRegistry}.
	 *
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 * @throws ServiceException
	 *             If the service can't be returned.
	 */
	public static UmlModel getUmlModelChecked(ServicesRegistry servicesRegistry) throws ServiceException {
		return (UmlModel) ModelUtils.getModelSetChecked(servicesRegistry).getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Return the UML Resource associated to the Services Registry. May be null.
	 *
	 * @param modelSet
	 * @return
	 */
	public static Resource getUmlResource(ServicesRegistry registry) {
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(registry);
			return getUmlResource(modelSet);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * Return the UML Resource associated to the ModelSet. May be null.
	 *
	 * @param modelSet
	 * @return
	 */
	public static Resource getUmlResource(ModelSet modelSet) {
		UmlModel umlModel = getUmlModel(modelSet);
		if (umlModel != null) {
			return umlModel.getResource();
		}
		return null;
	}

	public static Collection<EReference> getAllChangeableSupersets(EReference subset) {
		Collection<EReference> result = null;

		// null has no supersets
		EAnnotation supersets = (subset == null) ? null : subset.getEAnnotation(ANNOTATION_SUBSETS);
		if (supersets != null) {
			result = collectChangeableSupersets(supersets.getReferences(), new HashSet<EReference>());
		}

		return (result == null) ? Collections.<EReference> emptyList() : result;
	}

	private static Collection<EReference> collectChangeableSupersets(Collection<EObject> supersets, Set<EReference> result) {
		for (EObject next : supersets) {
			if (next instanceof EReference) {
				EReference superset = (EReference) next;
				if (superset.isChangeable() && result.add(superset)) {
					EAnnotation recursive = superset.getEAnnotation(ANNOTATION_SUBSETS);
					if (recursive != null) {
						collectChangeableSupersets(recursive.getReferences(), result);
					}
				}
			}
		}

		return result;
	}

	public static boolean isSubset(EReference subset) {
		boolean result = false;

		// null is not a subset of anything
		EAnnotation supersets = (subset == null) ? null : subset.getEAnnotation(ANNOTATION_SUBSETS);
		if (supersets != null) {
			result = !supersets.getReferences().isEmpty();
		}

		return result;
	}

	public static boolean isSubsetOf(EReference subset, EReference superset) {
		boolean result = false;

		// null is not a subset of anything
		EAnnotation supersets = (subset == null) ? null : subset.getEAnnotation(ANNOTATION_SUBSETS);
		if (supersets != null) {
			result = supersets.getReferences().contains(superset);
			if (!result) {
				// Look for transitive subset, which is at least plausible
				// considering that we do have some superset
				for (Iterator<EObject> iter = supersets.getReferences().iterator(); !result && iter.hasNext();) {
					EObject next = iter.next();
					if (next instanceof EReference) {
						result = isSubsetOf((EReference) next, superset);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Obtains all supersets, including transitive supersets-of-supersets, of the specified {@code subset}.
	 *
	 * @param subset
	 *            a subset reference
	 * @return its supersets, or an empty iterable if it is not actually a subset of anything
	 */
	public static Iterable<EReference> getSupersets(EReference subset) {
		List<EReference> result;

		EAnnotation supersets = (subset == null) ? null : subset.getEAnnotation(ANNOTATION_SUBSETS);
		if (supersets == null) {
			result = Collections.emptyList();
		} else {
			result = Lists.newArrayListWithCapacity(supersets.getReferences().size());
			for (EObject next : supersets.getReferences()) {
				if (next instanceof EReference) {
					EReference superset = (EReference) next;
					result.add(superset);
					if (isSubset(superset)) {
						// Look for transitive supersets
						Iterables.addAll(result, getSupersets(superset));
					}
				}
			}
		}

		return result;
	}
}
