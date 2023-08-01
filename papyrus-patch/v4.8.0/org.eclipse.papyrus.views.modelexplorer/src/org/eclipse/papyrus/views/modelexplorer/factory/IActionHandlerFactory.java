/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) @deprecated
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.factory;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * A factory for creating Action objects from org.eclipse.jface.action
 *
 * @deprecated The actions should be written using the Eclipse Framework (org.eclipse.ui.menu, org.eclipse.ui.handler, org.eclipse.ui.command)
 */
@Deprecated
public interface IActionHandlerFactory {

	/**
	 * Creates a new IActionHandler object.
	 *
	 * @param editingDomain
	 *            the editing domain
	 *
	 * @return the list of created actions
	 */
	List<Action> createActions(EditingDomain editingDomain);

	/**
	 * Gets the actions.
	 *
	 * @return the actions list
	 */
	List<Action> getActions();

	/**
	 * Activate the action.
	 *
	 * @param activeViewPart
	 *            the active view part
	 */
	void activate(CommonNavigator activeViewPart);

	/**
	 * Deactivate the action.
	 *
	 * @param activeViewPart
	 *            the active view part
	 */
	void deactivate(CommonNavigator activeViewPart);

	/**
	 * Update action from the selection
	 *
	 * @param structuredSelection
	 *            the structured selection
	 */
	void update(IStructuredSelection structuredSelection);

	/**
	 * Adds the applicable actions to a part's action bars, including setting
	 * any global action handlers.
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 *
	 * @param actionBars
	 *            the part's action bars
	 */
	void fillActionBars(IActionBars actionBars);

}
