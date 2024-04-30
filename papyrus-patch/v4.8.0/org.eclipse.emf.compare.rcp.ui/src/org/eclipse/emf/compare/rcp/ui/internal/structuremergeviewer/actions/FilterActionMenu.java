/*******************************************************************************
 * Copyright (c) 2012, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.actions;

import java.util.Collection;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.StructureMergeViewerFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter.Registry;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This will be displayed atop the structure viewer as the "filters" menu.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class FilterActionMenu extends Action implements IMenuCreator {
	/** The viewer filter that will be modified by this menu's actions. */
	private final StructureMergeViewerFilter structureMergeViewerFilter;

	/** Menu Manager that will contain our menu. */
	private final MenuManager menuManager;

	/** The registry that will be used to retrieve available filters. */
	private final Registry registry;

	/**
	 * Constructs our filtering menu.
	 * 
	 * @param structureMergeViewerFilter
	 *            The viewer filter for which we'll create actions.
	 * @param registry
	 *            The registry that contains the filters.
	 */
	public FilterActionMenu(StructureMergeViewerFilter structureMergeViewerFilter,
			IDifferenceFilter.Registry registry) {
		super("", IAction.AS_DROP_DOWN_MENU); //$NON-NLS-1$
		this.structureMergeViewerFilter = structureMergeViewerFilter;
		this.registry = registry;
		this.menuManager = new MenuManager();
		setMenuCreator(this);
		setToolTipText(EMFCompareRCPUIMessages.getString("FilterActionMenu.tooltip")); //$NON-NLS-1$
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(EMFCompareRCPUIPlugin.PLUGIN_ID,
				"icons/full/toolb16/filter.gif")); //$NON-NLS-1$
	}

	/**
	 * Create all of our filtering actions into the given menu.
	 * 
	 * @param newScope
	 *            The scope on which the filters will be applied.
	 * @param newComparison
	 *            The comparison on which the filters will be applied.
	 */
	public void updateMenu(IComparisonScope newScope, Comparison newComparison) {
		menuManager.removeAll();
		Collection<IDifferenceFilter> filters = registry.getFilters(newScope, newComparison);
		for (IDifferenceFilter filter : filters) {
			if (structureMergeViewerFilter.getActiveDifferenceFilters().contains(filter)) {
				FilterAction action = new FilterAction(filter.getLabel(), structureMergeViewerFilter, filter);
				boolean selected = structureMergeViewerFilter.getSelectedDifferenceFilters().contains(filter);
				action.setChecked(selected);
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
