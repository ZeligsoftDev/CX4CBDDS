/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana, Obeo. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Francisco Javier Cano Muñoz (Prodevelop) – Initial API implementation.
 *  Obeo
 *
 ******************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.actionprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.MenuManager;

/**
 * Specialization of <AbstractCommonActionProvider> to be used in menu and
 * submenu contributions.
 *
 * @author fjcano
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractSubmenuActionProvider extends
		AbstractCommonActionProvider {

	/**
	 * Organizes the given <Collection> of <IActions>.
	 *
	 * @param createActions
	 *            <Collection> of <IActions> to organize
	 * @param token
	 *            <String> that the <StringTokenizer> will use to trim each
	 *            <IAction>'s text.
	 *
	 * @return a <Map> associating <String>s to <Collection>s of <IAction>s.
	 */
	protected Map<String, Collection<IAction>> extractSubmenuActions(
			Collection<IAction> createActions, String token) {
		Map<String, Collection<IAction>> createSubmenuActions = new LinkedHashMap<String, Collection<IAction>>();
		if (createActions != null) {
			for (Iterator<IAction> actions = createActions.iterator(); actions
					.hasNext();) {
				IAction action = actions.next();
				StringTokenizer st = new StringTokenizer(action.getText(),
						token);
				if (st.countTokens() == 2) {
					String text = st.nextToken().trim();
					Collection<IAction> submenuActions = createSubmenuActions
							.get(text);
					if (submenuActions == null) {
						createSubmenuActions.put(text,
								submenuActions = new ArrayList<IAction>());
					}
					action.setText(st.nextToken().trim());
					submenuActions.add(action);
					actions.remove();
				}
			}
		}
		return createSubmenuActions;
	}

	/**
	 * Fills a <IContributionManager> with the given <Collection> of <IActions>.
	 *
	 * @param manager
	 *            the manager
	 * @param actions
	 *            the actions
	 * @param contributionID
	 *            the contribution id
	 */
	protected void populateManager(IContributionManager manager,
			Collection<? extends IAction> actions, String contributionID) {
		if (actions != null) {
			for (IAction action : actions) {
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				} else {
					manager.add(action);
				}
			}
		}
	}

	/**
	 * Fills a <IContributionManager> with two levels of menus, as specified by
	 * the <Map> of <String>s to <Collection>s of <IAction>s.
	 *
	 * @param manager
	 *            the manager
	 * @param submenuActions
	 *            the submenu actions
	 * @param contributionID
	 *            the contribution id
	 */
	protected void populateManager(IContributionManager manager,
			Map<String, Collection<IAction>> submenuActions,
			String contributionID) {
		if (submenuActions != null) {
			for (Map.Entry<String, Collection<IAction>> entry : submenuActions
					.entrySet()) {
				MenuManager submenuManager = new MenuManager(entry.getKey());
				if (contributionID != null) {
					manager.insertBefore(contributionID, submenuManager);
				} else {
					manager.add(submenuManager);
				}
				populateManager(submenuManager, entry.getValue(), null);
			}
		}
	}

}
