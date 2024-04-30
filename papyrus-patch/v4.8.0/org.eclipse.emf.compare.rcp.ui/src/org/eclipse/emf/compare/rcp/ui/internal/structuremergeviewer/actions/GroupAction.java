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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.GroupsPreferencePage;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.actions.ui.SynchronizerDialog;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.StructureMergeViewerGrouper;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupManager;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

/**
 * This action will allow us to group differences by their kind.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @since 4.0
 */
public class GroupAction extends Action {
	/** The viewer grouper that will be affected by this action. */
	private final StructureMergeViewerGrouper structureMergeViewerGrouper;

	/** The actual instance that will provide groups if this action is used. */
	private final IDifferenceGroupProvider provider;

	/** The group descriptor for this action. */
	private final IDifferenceGroupProvider.Descriptor descriptorGroupProvider;

	/** Holds true if the current comparison is a Three way comparison. */
	private final boolean isThreeWay;

	/** {@link DifferenceGroupManager}. */
	private final DifferenceGroupManager groupManager;

	/** Preferences holding synchronization behavior value. */
	private final IPreferenceStore preferences;

	/**
	 * Instantiates our action given its target grouper.
	 * 
	 * @param structureMergeViewerGrouper
	 * @param dgp
	 *            The group provider descriptor.
	 * @param gp
	 *            The group provider created by the group provider descriptor.
	 * @param groupManager
	 *            {@link DifferenceGroupManager}
	 * @param isThreeWay
	 *            Set to true if the current comparison is a Three way comparison.
	 */
	public GroupAction(StructureMergeViewerGrouper structureMergeViewerGrouper,
			IDifferenceGroupProvider.Descriptor dgp, IDifferenceGroupProvider gp,
			DifferenceGroupManager groupManager, boolean isThreeWay) {
		super(dgp.getLabel(), IAction.AS_RADIO_BUTTON);
		this.structureMergeViewerGrouper = structureMergeViewerGrouper;
		this.descriptorGroupProvider = dgp;
		this.groupManager = groupManager;
		this.isThreeWay = isThreeWay;
		this.provider = gp;
		this.preferences = EMFCompareRCPUIPlugin.getDefault().getPreferenceStore();
	}

	@Override
	public boolean isEnabled() {
		return provider != null;
	}

	public Descriptor getDescriptorGroupProvider() {
		return descriptorGroupProvider;
	}

	@Override
	public void runWithEvent(Event event) {
		if (isChecked()) {
			handleSynchronization(event);
			structureMergeViewerGrouper.setProvider(provider);
		}
	}

	/**
	 * Handles the synchronization after a run.
	 * 
	 * @param event
	 *            Event of the action.
	 */
	private void handleSynchronization(Event event) {
		final Shell shell = event.display.getActiveShell();
		String preferenceValue = preferences
				.getString(GroupsPreferencePage.getGroupSynchronizationPreferenceKey(isThreeWay));
		if ("".equals(preferenceValue)) { //$NON-NLS-1$
			preferenceValue = MessageDialogWithToggle.PROMPT;
		}
		if (MessageDialogWithToggle.PROMPT.equals(preferenceValue)) {
			shell.getDisplay().asyncExec(new SynchronizationRunnable(shell));
		} else if (MessageDialogWithToggle.ALWAYS.equals(preferenceValue)) {
			setSelectedGroupAsDefault();
		}
	}

	/**
	 * Sets the selected group as default group.
	 */
	private void setSelectedGroupAsDefault() {
		List<IItemDescriptor<Descriptor>> currentState = groupManager.getCurrentGroupRanking(isThreeWay);
		IItemDescriptor<Descriptor> matchingItem = null;
		Iterator<IItemDescriptor<Descriptor>> itemsIterator = currentState.iterator();
		while (itemsIterator.hasNext() && matchingItem == null) {
			IItemDescriptor<Descriptor> currentItem = itemsIterator.next();
			if (currentItem.getItem().equals(descriptorGroupProvider)) {
				matchingItem = currentItem;
			}
		}
		if (matchingItem != null) {
			currentState.remove(matchingItem);
			currentState.add(0, matchingItem);
			groupManager.setCurrentGroupRanking(currentState, isThreeWay);
		} else {
			/*
			 * If not found then the group provider may have been removed from the registry. Just log warning.
			 */
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.WARNING,
					"Enable to set selected difference group provider as default group provider. The selected group provider is not in the registry anymore"); //$NON-NLS-1$
		}
	}

	/**
	 * Runnable responsible for synchronizing the group with the {@link DifferenceGroupManager}.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private final class SynchronizationRunnable implements Runnable {
		/** Parent {@link Shell}. */
		private final Shell shell;

		/**
		 * Constructor.
		 * 
		 * @param shell
		 *            Parent shell.
		 */
		private SynchronizationRunnable(Shell shell) {
			this.shell = shell;
		}

		/**
		 * {@inheritDoc}
		 */
		public void run() {
			MessageDialogWithToggle dialog = new SynchronizerDialog(shell,
					EMFCompareRCPUIMessages.getString("GroupAction.synchronization.dialog.title"), //$NON-NLS-1$
					EMFCompareRCPUIMessages.getString("GroupAction.synchronization.dialog.message"), //$NON-NLS-1$
					GroupsPreferencePage.PAGE_ID);

			dialog.setPrefKey(GroupsPreferencePage.getGroupSynchronizationPreferenceKey(isThreeWay));
			dialog.setPrefStore(EMFCompareRCPUIPlugin.getDefault().getPreferenceStore());
			if (dialog.open() == IDialogConstants.YES_ID) {
				setSelectedGroupAsDefault();
			}
		}

	}
}
