/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     Emilien Perico - use extension point to define dynamically registered actions
 *******************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.actionprovider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.papyrus.views.modelexplorer.factory.IActionHandlerFactory;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.osgi.framework.Bundle;

/**
 * Provider used to create actions applicable on semantic elements
 *
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author Emilien Perico - see extension point
 *         org.eclipse.papyrus.navigator.actionHandler to add specific action
 */
public class EditingDomainActionProvider extends AbstractSubmenuActionProvider {

	public static final String ACTION_HANDLER_EXTENSION_POINT_ID = "org.eclipse.papyrus.views.modelexplorer.actionHandler";

	protected CommonNavigator activeViewPart;

	protected Map<IActionHandlerFactory, ActionProperties> actionsFactoriesMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);

		this.activeViewPart = getCommonNavigator();
		this.actionsFactoriesMap = new HashMap<IActionHandlerFactory, ActionProperties>();
		TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		IConfigurationElement[] registry = Platform.getExtensionRegistry().getConfigurationElementsFor(ACTION_HANDLER_EXTENSION_POINT_ID);
		for (IConfigurationElement elt : registry) {
			try {
				final String actionId = elt.getAttribute("actionId");
				final String afterAction = elt.getAttribute("afterAction");
				boolean needSeparator = Boolean.valueOf(elt.getAttribute("needSeparator"));
				ActionProperties properties = new ActionProperties(actionId, afterAction, needSeparator);

				IActionHandlerFactory factory = (IActionHandlerFactory) createExtension(elt, elt.getAttribute("actionHandler"));
				// create registered actions
				factory.createActions(editingDomain);

				actionsFactoriesMap.put(factory, properties);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		for (IActionHandlerFactory factory : actionsFactoriesMap.keySet()) {
			factory.fillActionBars(actionBars);
		}
	}

	/**
	 * Load an instance of a class
	 *
	 * @param element
	 *            the extension point
	 * @param classAttribute
	 *            the name of the class to load
	 * @return the loaded Class
	 * @throws Exception
	 *             if the class is not loaded
	 */
	@SuppressWarnings("rawtypes")
	private static Object createExtension(final IConfigurationElement element, final String classAttribute) throws Exception {
		try {
			Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier());
			Class clazz = extensionBundle.loadClass(classAttribute);
			Object obj = clazz.newInstance();
			return obj;
			// return element.createExecutableExtension(classAttribute);
		} catch (Exception e) {
			throw new Exception("unable to create Extension " + e); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		update();
		// sort factories from "afterAction" property
		List<IActionHandlerFactory> sortedFactories = sortFactories(actionsFactoriesMap);

		// Add the edit menu actions
		for (IActionHandlerFactory factory : sortedFactories) {
			ActionProperties actionProperties = actionsFactoriesMap.get(factory);
			if (actionProperties != null && actionProperties.isNeedSeparator()) {
				menu.add(new Separator());
			}
			for (Action action : factory.getActions()) {
				menu.add(new ActionContributionItem(action));
			}
		}
		activate();
	}

	/**
	 * Update actions
	 */
	public void update() {
		ISelection selection = getCommonNavigator().getCommonViewer().getSelection();
		IStructuredSelection structuredSelection = StructuredSelection.EMPTY;
		if (selection instanceof IStructuredSelection) {
			structuredSelection = (IStructuredSelection) selection;
		}

		for (IActionHandlerFactory factory : actionsFactoriesMap.keySet()) {
			factory.update(structuredSelection);
		}
	}

	/**
	 * Activate actions
	 */
	public void activate() {
		for (IActionHandlerFactory factory : actionsFactoriesMap.keySet()) {
			factory.activate(activeViewPart);
		}
		update();
	}

	/**
	 * Deactivate actions
	 */
	// @unused
	public void deactivate() {
		for (IActionHandlerFactory factory : actionsFactoriesMap.keySet()) {
			factory.deactivate(activeViewPart);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateActionBars() {
		super.updateActionBars();
		activate();
		update();
	}

	/**
	 * Sort factories.
	 *
	 * @param actionsFactoriesMap
	 *            the actions factories map
	 *
	 * @return the sorted list of factories
	 */
	private List<IActionHandlerFactory> sortFactories(final Map<IActionHandlerFactory, ActionProperties> actionsFactoriesMap) {

		List<IActionHandlerFactory> factories = new ArrayList<IActionHandlerFactory>(actionsFactoriesMap.keySet());

		Collections.sort(factories, new Comparator<IActionHandlerFactory>() {

			public int compare(IActionHandlerFactory factory1, IActionHandlerFactory factory2) {

				ActionProperties properties1 = getDefaultForNull(actionsFactoriesMap.get(factory1));
				ActionProperties properties2 = getDefaultForNull(actionsFactoriesMap.get(factory2));
				String after1 = properties1.getAfterAction();
				String after2 = properties2.getAfterAction();

				if (properties1.getActionId().equals(properties2.getActionId())) {
					return 0;
				} else if (properties1.getActionId().equals(after2)) {
					return -1;
				} else if (properties2.getActionId().equals(after1)) {
					return 1;
				} else if (after1 == null) {
					return -1;
				} else if (after2 == null) {
					return 1;
				}
				return 0;
			}

			private ActionProperties getDefaultForNull(ActionProperties actionProperties) {
				if (actionProperties == null) {
					actionProperties = new ActionProperties("", "", false);
				}
				return actionProperties;
			}
		});

		return factories;
	}

	/**
	 * The Class ActionProperties to store properties for a registered action
	 * from extension point org.eclipse.papyrus.navigator.actionHandler
	 */
	private class ActionProperties {

		private final String actionId;

		private final String afterAction;

		private final boolean needSeparator;

		/**
		 * @param actionId
		 * @param afterAction
		 * @param needSeparator
		 */
		// @unused
		public ActionProperties(String actionId, String afterAction, boolean needSeparator) {
			super();
			this.actionId = actionId;
			this.afterAction = afterAction;
			this.needSeparator = needSeparator;
		}

		/**
		 * @return the actionId
		 */
		public String getActionId() {
			return actionId;
		}

		/**
		 * @return the afterAction
		 */
		public String getAfterAction() {
			return afterAction;
		}

		/**
		 * @return the needSeparator
		 */
		public boolean isNeedSeparator() {
			return needSeparator;
		}

	}

}
