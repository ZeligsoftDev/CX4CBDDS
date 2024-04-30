/*******************************************************************************
 * Copyright (c) 2012, 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.actions;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.StructureMergeViewerGrouper;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupManager;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This menu will display actions that will allow the user to group differences together.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class GroupActionMenu extends Action implements IMenuCreator {
	/** The viewer grouper that will be affected by this menu's actions. */
	private final StructureMergeViewerGrouper structureMergeViewerGrouper;

	/** Menu Manager that will contain our menu. */
	private final MenuManager menuManager;

	/** The registry that will be used to retrieve the displayed group providers. */
	private final IDifferenceGroupProvider.Descriptor.Registry registry;

	/**
	 * Constructs our grouping menu.
	 * 
	 * @param structureMergeViewerGrouper
	 *            The viewer grouper that will be affected by this menu's actions.
	 * @param registry
	 *            The registry that contains the group provider..
	 */
	public GroupActionMenu(StructureMergeViewerGrouper structureMergeViewerGrouper,
			IDifferenceGroupProvider.Descriptor.Registry registry) {
		super("", IAction.AS_DROP_DOWN_MENU); //$NON-NLS-1$
		this.registry = registry;
		this.menuManager = new MenuManager();
		this.structureMergeViewerGrouper = structureMergeViewerGrouper;
		setToolTipText(EMFCompareRCPUIMessages.getString("GroupActionMenu.tooltip")); //$NON-NLS-1$
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(EMFCompareRCPUIPlugin.PLUGIN_ID,
				"icons/full/toolb16/group.gif")); //$NON-NLS-1$
		setMenuCreator(this);
	}

	/**
	 * Create the grouping action in the given menu.
	 * 
	 * @param scope
	 *            The scope on which the groups will be applied.
	 * @param comparison
	 *            The comparison which differences are to be split into groups.
	 */
	public void updateMenu(IComparisonScope scope, Comparison comparison) {
		menuManager.removeAll();
		DifferenceGroupManager groupManager = new DifferenceGroupManager(
				EMFCompareRCPUIPlugin.getDefault().getItemDifferenceGroupProviderRegistry(),
				EMFCompareRCPUIPlugin.getDefault().getPreferenceStore());
		for (IDifferenceGroupProvider.Descriptor dgp : registry.getGroupProviders(scope, comparison)) {
			IDifferenceGroupProvider gp = dgp.createGroupProvider();
			if (gp != null) {
				final IAction action;
				if (gp.getClass() == structureMergeViewerGrouper.getProvider().getClass()) {
					action = new GroupAction(structureMergeViewerGrouper, dgp,
							structureMergeViewerGrouper.getProvider(), groupManager, comparison.isThreeWay());
					action.setChecked(true);
				} else {
					action = new GroupAction(structureMergeViewerGrouper, dgp, gp, groupManager,
							comparison.isThreeWay());
				}
				menuManager.add(action);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see IMenuCreator#dispose()
	 */
	public void dispose() {
		menuManager.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see IMenuCreator#getMenu(Control)
	 */
	public Menu getMenu(Control parent) {
		return menuManager.createContextMenu(parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see IMenuCreator#getMenu(Menu)
	 */
	public Menu getMenu(Menu parent) {
		return null;
	}
}
