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

import com.google.common.collect.Sets;

import java.util.Set;

import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.FiltersPreferencePage;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.actions.ui.SynchronizerDialog;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.StructureMergeViewerFilter;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.DifferenceFilterManager;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

/**
 * These will be the actual actions displayed in the filter menu. Their sole purpose is to provide a Predicate
 * to the structure viewer's filter.
 * <p>
 * Do note that each distinct {@link FilterAction} in the {@link FilterActionMenu filter menu} is considered
 * as an "exclude" filter, and that they are OR'ed together (thus, any element must <b>not</b> meet the
 * selected filters' criteria in order to be displayed).
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class FilterAction extends Action {

	/** The filter associated with this action. */
	private final IDifferenceFilter filter;

	/** The Filter that will be modified by the action. */
	private final StructureMergeViewerFilter structureMergeViewerFilter;

	/** Preferences holding the value of the synchronization behavior of filters. */
	private final IPreferenceStore preferences;

	/** {@link DifferenceFilterManager}. */
	private final DifferenceFilterManager filterManager;

	/**
	 * The "default" constructor for this action.
	 * 
	 * @param text
	 *            Will be used as the action's tooltip.
	 * @param structureMergeViewerFilter
	 *            The viewer filter that this action will need to update.
	 * @param filter
	 *            The filter associated with this action.
	 */
	public FilterAction(String text, StructureMergeViewerFilter structureMergeViewerFilter,
			IDifferenceFilter filter) {
		super(text, IAction.AS_CHECK_BOX);
		this.structureMergeViewerFilter = structureMergeViewerFilter;
		this.filter = filter;
		this.preferences = EMFCompareRCPUIPlugin.getDefault().getPreferenceStore();
		this.filterManager = EMFCompareRCPUIPlugin.getDefault().getDifferenceFilterManager();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void runWithEvent(Event event) {
		if (isChecked()) {
			structureMergeViewerFilter.addFilter(filter);
		} else {
			structureMergeViewerFilter.removeFilter(filter);
		}
		handleSynchronization(event);
	}

	/**
	 * Handle synchronization with {@link DifferenceFilterManager}.
	 * 
	 * @param event
	 *            Event.
	 */
	private void handleSynchronization(Event event) {
		String sync = preferences.getString(FiltersPreferencePage.SYNCHRONIZATION_BEHAVIOR);
		if ("".equals(sync)) { //$NON-NLS-1$
			sync = MessageDialogWithToggle.PROMPT;
		}
		final Shell shell = event.display.getActiveShell();
		if (MessageDialogWithToggle.PROMPT.equals(sync) && shell != null) {
			shell.getDisplay().asyncExec(new SynchronizationBehaviorRunnable(shell));
		} else if (MessageDialogWithToggle.ALWAYS.equals(sync)) {
			synchonizeFilters();
		}
	}

	/**
	 * Synchronizes UI filter selection with the preferences.
	 */
	private void synchonizeFilters() {
		Set<IDifferenceFilter> byDefaultFilters = Sets
				.newLinkedHashSet(filterManager.getCurrentByDefaultFilters());
		// Add newly activated filters
		for (IDifferenceFilter activeFilter : structureMergeViewerFilter.getSelectedDifferenceFilters()) {
			byDefaultFilters.add(activeFilter);
		}
		// Remove deactivated filters
		for (IDifferenceFilter toDeactivateFilter : structureMergeViewerFilter
				.getUnSelectedDifferenceFilters()) {
			byDefaultFilters.remove(toDeactivateFilter);
		}
		filterManager.setCurrentByDefaultFilters(byDefaultFilters);

	}

	/**
	 * Runnable in charge of synchronizing selection in UI with the {@link DifferenceFilterManager}.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private final class SynchronizationBehaviorRunnable implements Runnable {
		/** Shell of this runnable. */
		private final Shell shell;

		/**
		 * Constructor.
		 * 
		 * @param shell
		 *            Shell for this runnable.
		 */
		private SynchronizationBehaviorRunnable(Shell shell) {
			this.shell = shell;
		}

		/**
		 * {@inheritDoc}
		 */
		public void run() {
			MessageDialogWithToggle dialog = new SynchronizerDialog(shell,
					EMFCompareRCPUIMessages.getString("FilterAction.synchronization.dialog.title"), //$NON-NLS-1$
					EMFCompareRCPUIMessages.getString("FilterAction.synchronization.dialog.message"), //$NON-NLS-1$
					FiltersPreferencePage.PAGE_ID);

			dialog.setPrefKey(FiltersPreferencePage.SYNCHRONIZATION_BEHAVIOR);
			dialog.setPrefStore(EMFCompareRCPUIPlugin.getDefault().getPreferenceStore());
			if (dialog.open() == IDialogConstants.YES_ID) {
				synchonizeFilters();
			}
		}

	}
}
