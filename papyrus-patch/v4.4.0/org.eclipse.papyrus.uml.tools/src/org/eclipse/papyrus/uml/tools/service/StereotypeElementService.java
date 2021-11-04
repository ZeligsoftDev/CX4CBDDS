/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4te.net - Initial API and implementation
 *   Christian W. Damus - bug 458197
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.service;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.tools.listeners.ProfileApplicationListener;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener;

/**
 * Service to register Stereotype listener on Editing domain.
 * 
 * @author Gabriel Pascual
 *
 */
public class StereotypeElementService implements IService {

	/** The stereotype element listener. */
	private StereotypeElementListener stereotypeElementListener = null;

	/** A profile-application listener. */
	private ProfileApplicationListener profileApplicationListener = null;

	/** The editing domain. */
	private TransactionalEditingDomain editingDomain = null;

	/**
	 * Constructor.
	 *
	 */
	public StereotypeElementService() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		// Get editing domain from service registry
		editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);

		// Build a stereotype listener with editing domain
		stereotypeElementListener = new StereotypeElementListener(editingDomain);

		// And the profile-application listener
		profileApplicationListener = new ProfileApplicationListener();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	public void startService() throws ServiceException {
		editingDomain.addResourceSetListener(stereotypeElementListener);
		editingDomain.addResourceSetListener(profileApplicationListener);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	public void disposeService() throws ServiceException {
		editingDomain.removeResourceSetListener(stereotypeElementListener);
		stereotypeElementListener = null;
		editingDomain.removeResourceSetListener(profileApplicationListener);
		profileApplicationListener = null;
	}

}
