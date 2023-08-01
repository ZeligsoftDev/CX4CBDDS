/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.Hashtable;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.command.AbstractPapyrusHandler;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers;

/**
 * This handler allows to Close Diagrams and Tables
 *
 *
 *
 */
public class CloseHandler extends AbstractPapyrusHandler implements IExecutableExtension {

	/** parameters for this action */
	/**
	 * close all open elements
	 */
	public static final String PARAMETER_ALL = "all"; //$NON-NLS-1$

	/**
	 * Close only the selected elements
	 */
	public static final String PARAMETER_SELECTION = "selection"; //$NON-NLS-1$

	/** parameter for this handler */
	protected String parameter = null;

	/** parameter ID */
	protected String parameterID = "close_parameter"; //$NON-NLS-1$

	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IPageManager pageMngr;

		try {
			ServicesRegistry registry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
			pageMngr = registry.getService(IPageManager.class);
		} catch (ServiceException ex) {
			throw new ExecutionException(ex.getMessage(), ex);
		}

		// What kind of command ?
		if (PARAMETER_ALL.equals(parameter)) {
			pageMngr.closeAllOpenedPages();

			return null;
		}

		// Try to close each selected editor.
		// There is no common type for object representing an editor. So,
		// We try to get the EObject, and try to close it as an Editor.
		List<EObject> selectedProperties = getCurrentSelectionAdaptedToType(event, EObject.class);
		if (selectedProperties == null) {
			// nothing to do
			return null;
		}

		// Check each selected object
		for (EObject selected : selectedProperties) {
			if (pageMngr.isOpen(selected)) {
				pageMngr.closePage(selected);
			}
		}

		return null;
	}

	/**
	 *
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 *
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if (data instanceof Hashtable && this.parameterID != null) {
			this.parameter = (String) ((Hashtable) data).get(this.parameterID);
		}
	}

}
