/*******************************************************************************
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fleck - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.compare.uml2.internal.hook.migration;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;

/**
 * Label provider service that always returns the {@link UMLLabelProvider}.
 * 
 * @author Martin Fleck <mfleck@eclipsesource.com>
 */
class UMLLabelProviderService implements LabelProviderService {
	/**
	 * Label provider instance.
	 */
	protected ILabelProvider labelProvider;

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
		if (labelProvider != null) {
			labelProvider.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry serviceRegistry) throws ServiceException {
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
		labelProvider = new UMLLabelProvider();
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(String context) {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(Object element) {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(String context, Object element) {
		return labelProvider;
	}

}
