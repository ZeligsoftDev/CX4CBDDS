/*****************************************************************************
 * Copyright (c) 2013, 2017 CEA LIST.
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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Vincent Lorenzo (vincent.lorenzo@cea.fr) - bug 405442, bug 521861
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.papyrus.infra.ui.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.DataTypeUtil;
import org.eclipse.swt.graphics.Image;

/**
 * A generic Label Provider for EObjects which are instances of UML DataTypes (Defined as EClasses)
 *
 * @author Camille Letavernier
 *
 * @see {@link DataTypeUtil#isDataTypeDefinition(EClass)}
 */
public class GenericDataTypeLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	/**
	 * @since 3.0
	 */
	public static final String SEPARATOR = ","; //$NON-NLS-1$
	
	/**
	 * @since 3.0
	 */
	public static final String DATATYPE_START = "("; //$NON-NLS-1$
	
	/**
	 * @since 3.0
	 */
	public static final String DATATYPE_END = ")"; //$NON-NLS-1$
	
	/**
	 * @since 3.0
	 */
	public static final String COLLECTION_START = "{"; //$NON-NLS-1$
	
	/**
	 * @since 3.0
	 */
	public static final String COLLECTION_END = "}"; //$NON-NLS-1$
	
	/**
	 * @since 3.0
	 */
	public static final String EQUALS = "="; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public boolean accept(Object element) {
		if (element instanceof Collection<?>) {
			for (Object item : ((Collection<?>) element)) {
				if (!accept(item)) {
					return false;
				}
			}
			return !((Collection<?>) element).isEmpty();
		}

		EObject eObject = EMFHelper.getEObject(element);
		if (eObject == null) {
			return false;
		}

		return DataTypeUtil.isDataTypeInstance(eObject);
	}

	@Override
	public String getText(Object element) {
		// now we use the Marte VSL syntax : (propertyName=propertyValue, an otherProperty=value, (propertyFromAReferencedDataType=value) )
		LabelProviderService serv = null;
		if (element instanceof Collection<?> && !((Collection<?>) element).isEmpty()) {
			final Object first = ((Collection<?>) element).iterator().next();
			if (first instanceof EObject) {// always true due to the accept method
				serv = getLabelProviderService((EObject) first);
			}
		} else {
			// always true due to the accept method
			serv = getLabelProviderService((EObject) element);
		}
		if (null == serv) {
			Activator.log.error("LabelProviderService not found for " + element, null); //$NON-NLS-1$
		}

		// Initial implementation. TODO: Improve the label
		final StringBuilder builder = new StringBuilder(DATATYPE_START);
		if (element instanceof Collection<?> && !(((Collection<?>) element).isEmpty())) {
			builder.append(getLabel(serv, element)); // collection management is delegated to this method
		} else {
			final EObject dataTypeInstance = EMFHelper.getEObject(element);
			if (dataTypeInstance != null) {
				final EClass dataTypeDefinition = dataTypeInstance.eClass();
				final Iterator<EStructuralFeature> iter = dataTypeDefinition.getEAllStructuralFeatures().iterator();
				while (iter.hasNext()) {
					final EStructuralFeature feature = iter.next();
					builder.append(feature.getName());
					builder.append(EQUALS);
					final Object value = dataTypeInstance.eGet(feature);
					builder.append(getLabel(serv, value));
					if (iter.hasNext()) {
						builder.append(SEPARATOR);
						builder.append(" ");//$NON-NLS-1$
					}
				}

			}
		}
		builder.append(DATATYPE_END);
		return builder.toString();
	}

	/**
	 * 
	 * @param service
	 *            the label provider service
	 * @param current
	 *            the object for which we want the label
	 * @return
	 * 		the label for the given value
	 * @since 3.0
	 */
	protected String getLabel(final LabelProviderService service, final Object object) {
		final StringBuilder builder = new StringBuilder();
		if (object instanceof Collection<?>) {
			builder.append(COLLECTION_START);
			final Collection<?> coll = (Collection<?>) object;
			final Iterator<?> iter = coll.iterator();
			while (iter.hasNext()) {
				final Object current = iter.next();
				final String value = getLabel(service, current);
				if (value != null) {
					builder.append(value);
				} else {
					builder.append(" "); //$NON-NLS-1$
				}
				if (iter.hasNext()) {
					builder.append(SEPARATOR);
					builder.append(" "); //$NON-NLS-1$
				}
			}
			builder.append(COLLECTION_END);
		} else {
			if (null != service) {
				final String label = service.getLabelProvider(object).getText(object);
				if (label != null) {
					builder.append(label);
				}
			}
		}
		return builder.toString();

	}

	/**
	 * 
	 * @param dataTypeInstance
	 *            a datatype instance
	 * @return
	 * 		the label provider service found or <code>null</code> otherwise
	 * @since 3.0
	 */
	protected LabelProviderService getLabelProviderService(final EObject dataTypeInstance) {
		ServicesRegistry registry = null;
		LabelProviderService service = null;
		try {
			final EClass dataTypeDefinition = dataTypeInstance.eClass();
			if (null == dataTypeInstance.eResource() && null!=dataTypeDefinition.eResource()) {
				// the datatype is not always in a resource (when it just comes to be created, nevertheless, its EClass is always in a resource loaded in the ResourceSet
				registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(dataTypeDefinition);
			} else {
				registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(dataTypeInstance);
			}
			service = registry.getService(LabelProviderService.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return service;
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}
}
