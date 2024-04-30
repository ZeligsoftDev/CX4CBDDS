/*******************************************************************************
 * Copyright (c) 2014, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Simon Delisle - bug 495753
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import static org.eclipse.jface.dialogs.MessageDialogWithToggle.ALWAYS;
import static org.eclipse.jface.dialogs.MessageDialogWithToggle.NEVER;
import static org.eclipse.jface.dialogs.MessageDialogWithToggle.PROMPT;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.tracer.TracingConstant;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.GroupsInteractiveContent;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.ItemDescriptorLabelProvider;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupManager;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider.Descriptor;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for group providers.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class GroupsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/** Id of the preference page. */
	public static final String PAGE_ID = "org.eclipse.emf.compare.rcp.ui.preferencePage.groups"; //$NON-NLS-1$

	/** Default value for the synchronization behavior for 2-way and 3-way comparison. */
	private static final String SYNC_DEFAULT_VALUE = MessageDialogWithToggle.PROMPT;

	/** List of all available values possible for synchronization behavior. */
	private static final List<String> SYNC_VALUES = ImmutableList.of(ALWAYS, NEVER, PROMPT);

	/** Synchronization behavior for group 2 way comparison capable. */
	private static final String TWO_WAY_COMPARISON_SYNC_BEHAVIOR = "org.eclipse.emf.compare.rcp.ui.groups.2way.syncbehavior"; //$NON-NLS-1$

	/** Synchronization behavior for group 3 way comparison capable. */
	private static final String THREE_WAY_COMPARISON_SYNC_BEHAVIOR = "org.eclipse.emf.compare.rcp.ui.groups.3ways.syncbehavior"; //$NON-NLS-1$

	/** Combo holding syncrhonization behavior preferences. */
	private Combo combo;

	/** Field holding the synchronization behavior chosen by the user. */
	private String synchronizationBehaviorValue;

	/** UI content for two way comparison tab. */
	private GroupsInteractiveContent twoWayComparisonContent;

	/** UI content for three way comparison tab. */
	private GroupsInteractiveContent threeWayComparisonContent;

	/** {@link DifferenceGroupManager}. */
	private DifferenceGroupManager groupManager = new DifferenceGroupManager(
			EMFCompareRCPUIPlugin.getDefault().getItemDifferenceGroupProviderRegistry(),
			EMFCompareRCPUIPlugin.getDefault().getPreferenceStore());

	/**
	 * Gets the preference key for synchronization behavior.
	 * 
	 * @param isThreeWay
	 *            True if three way comparison.
	 * @return The key of the synchronization behavior for this type of comparison.
	 */
	public static String getGroupSynchronizationPreferenceKey(boolean isThreeWay) {
		if (isThreeWay) {
			return THREE_WAY_COMPARISON_SYNC_BEHAVIOR;
		} else {
			return TWO_WAY_COMPARISON_SYNC_BEHAVIOR;
		}
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(EMFCompareRCPUIPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayoutFactory.fillDefaults().applyTo(container);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createSynchronizationBehaviorContent(container);

		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		fillTwoWayComparisonTab(tabFolder);
		fillThreeWayComparisonTab(tabFolder);
		return container;
	}

	/**
	 * Fills the tab for two way comparison.
	 * 
	 * @param tabFolder
	 *            Holding tab folder.
	 */
	private void fillTwoWayComparisonTab(TabFolder tabFolder) {
		Composite tabSkeletonComposite = createTabSkeleton(tabFolder,
				EMFCompareRCPUIMessages.getString("GroupsPreferencePage.twoWayComparisonTab.label"), //$NON-NLS-1$
				EMFCompareRCPUIMessages.getString("GroupsPreferencePage.viewerDescription.label")); //$NON-NLS-1$

		List<IItemDescriptor<Descriptor>> currentGroupRanking = groupManager.getCurrentGroupRanking(false);

		twoWayComparisonContent = createInteractiveContent(tabSkeletonComposite, currentGroupRanking,
				currentGroupRanking.get(0));
		setComboInput(getCurrentSynchronizationBehavior(false));
	}

	/**
	 * Fills the tab for three way comparison.
	 * 
	 * @param tabFolder
	 *            Holding tab folder.
	 */
	private void fillThreeWayComparisonTab(TabFolder tabFolder) {
		Composite tabSkeletonComposite = createTabSkeleton(tabFolder,
				EMFCompareRCPUIMessages.getString("GroupsPreferencePage.threeWayComparisonTab.label"), //$NON-NLS-1$
				EMFCompareRCPUIMessages.getString("GroupsPreferencePage.viewerDescription.label")); //$NON-NLS-1$

		List<IItemDescriptor<Descriptor>> currentGroupRanking = groupManager.getCurrentGroupRanking(true);
		threeWayComparisonContent = createInteractiveContent(tabSkeletonComposite, currentGroupRanking,
				currentGroupRanking.get(0));
		setComboInput(getCurrentSynchronizationBehavior(true));
	}

	/**
	 * Creates an interactive content.
	 * <p>
	 * Interactive content aims at handling all ui that is modified with user interaction.
	 * </p>
	 * 
	 * @param parent
	 *            Parent Composite.
	 * @param input
	 *            Input of the viewer.
	 * @param defaultSelection
	 *            Default element that need to be selected.
	 * @return A {@link GroupsInteractiveContent}
	 */
	private GroupsInteractiveContent createInteractiveContent(Composite parent,
			List<IItemDescriptor<IDifferenceGroupProvider.Descriptor>> input,
			IItemDescriptor<IDifferenceGroupProvider.Descriptor> defaultSelection) {

		final GroupsInteractiveContent interactiveUI = new GroupsInteractiveContent(parent);
		createViewer(interactiveUI);
		interactiveUI.setViewerInput(input);
		interactiveUI.select(defaultSelection);

		return interactiveUI;
	}

	/**
	 * Creates skeleton of a tab.
	 * 
	 * @param tabFolder
	 *            Holding tab folder.
	 * @param tabLabel
	 *            Label of the tab.
	 * @param introText
	 *            Text use as description a tab
	 * @return Main composite of the tab
	 */
	private Composite createTabSkeleton(TabFolder tabFolder, String tabLabel, String introText) {
		TabItem tbtmMain = new TabItem(tabFolder, SWT.NONE);
		tbtmMain.setText(tabLabel);
		Composite tabComposite = new Composite(tabFolder, SWT.NONE);
		tbtmMain.setControl(tabComposite);
		tabComposite.setLayout(new GridLayout(1, true));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		tabComposite.setLayoutData(layoutData);
		return tabComposite;
	}

	/**
	 * Creates the list viewer holding items.
	 * 
	 * @param interactiveUI
	 *            {@link GroupsInteractiveContent} in which the viewer need to be set up.
	 */
	private void createViewer(final GroupsInteractiveContent interactiveUI) {
		int style = SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.SINGLE;
		ListViewer descriptorViewer = new ListViewer(interactiveUI.getViewerComposite(), style);
		interactiveUI.setViewer(descriptorViewer);
		descriptorViewer.setContentProvider(ArrayContentProvider.getInstance());
		descriptorViewer.setLabelProvider(new ItemDescriptorLabelProvider());
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		descriptorViewer.getControl().setLayoutData(gd);
	}

	/**
	 * Content for synchronization behavior preferences.
	 * 
	 * @param parent
	 *            Main composite.
	 */
	private void createSynchronizationBehaviorContent(Composite parent) {
		Composite synchronizationComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(synchronizationComposite);
		Label label = new Label(synchronizationComposite, SWT.WRAP);
		label.setText(EMFCompareRCPUIMessages.getString("GroupsInteractiveContent.SYNC_BEHAVIOR_LABEL")); //$NON-NLS-1$
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		combo = new Combo(synchronizationComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
		for (String comboLabel : SYNC_VALUES) {
			combo.add(comboLabel);
		}
		combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
		combo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (combo.equals(e.getSource())) {
					synchronizationBehaviorValue = SYNC_VALUES.get(combo.getSelectionIndex());
				}
			}

		});
	}

	/**
	 * Sets the combo to the given synchronization behavior.
	 * 
	 * @param behavior
	 *            Input.
	 */
	public void setComboInput(String behavior) {
		int index = SYNC_VALUES.indexOf(behavior);
		if (index != -1) {
			combo.select(index);
			synchronizationBehaviorValue = behavior;
		}
	}

	@Override
	public boolean performOk() {
		groupManager.setCurrentGroupRanking(twoWayComparisonContent.getOrderedItems(), false);
		setCurrentSynchronizationBehavior(synchronizationBehaviorValue, false);

		groupManager.setCurrentGroupRanking(threeWayComparisonContent.getOrderedItems(), true);
		setCurrentSynchronizationBehavior(synchronizationBehaviorValue, true);
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		resetGroupPreference(false, twoWayComparisonContent);
		resetGroupPreference(true, threeWayComparisonContent);
		super.performDefaults();
	}

	/**
	 * Resets preferences for group.
	 * <p>
	 * Resets group ranking to default.
	 * </p>
	 * <p>
	 * Resets synchronization behavior to its default value.
	 * </p>
	 * 
	 * @param isThreeWay
	 *            Type of comparison.
	 * @param interactiveContent
	 *            {@link GroupsInteractiveContent}
	 */
	private void resetGroupPreference(boolean isThreeWay, GroupsInteractiveContent interactiveContent) {
		interactiveContent.setViewerInput(groupManager.getDefaultRankingConfiguration(isThreeWay));
		setComboInput(SYNC_DEFAULT_VALUE);
	}

	/**
	 * Sets the current synchronization behavior value.
	 * 
	 * @param newBehavior
	 *            <p>
	 *            Should be one of the following value.
	 *            </p>
	 *            <ul>
	 *            <li>{@link MessageDialogWithToggle#PROMPT}</li>
	 *            <li>{@link MessageDialogWithToggle#ALWAYS}</li>
	 *            <li>{@link MessageDialogWithToggle#NEVER}</li>
	 *            </ul>
	 * @param isThreeWay
	 *            True if three way comparison.
	 */
	public void setCurrentSynchronizationBehavior(String newBehavior, boolean isThreeWay) {
		Preconditions.checkArgument(SYNC_VALUES.contains(newBehavior));
		if (!SYNC_DEFAULT_VALUE.equals(newBehavior)) {
			getPreferenceStore().putValue(getGroupSynchronizationPreferenceKey(isThreeWay), newBehavior);
		} else {
			getPreferenceStore().setToDefault(getGroupSynchronizationPreferenceKey(isThreeWay));
		}
		// Trace preferences values
		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder builder = new StringBuilder();
			// Print each preferences
			builder.append("Preference ").append(getGroupSynchronizationPreferenceKey(isThreeWay)) //$NON-NLS-1$
					.append(":\n"); //$NON-NLS-1$
			String preferenceValue = getPreferenceStore()
					.getString(getGroupSynchronizationPreferenceKey(isThreeWay));
			builder.append(preferenceValue);
			EMFCompareRCPUIPlugin.getDefault().log(IStatus.INFO, builder.toString());
		}
	}

	/**
	 * Gets the state of the the group synchronization behavior.
	 * 
	 * @param isThreeWay
	 *            True if three way comparison.
	 * @return Returns one of the following value.
	 *         <ul>
	 *         <li>{@link MessageDialogWithToggle#PROMPT}</li>
	 *         <li>{@link MessageDialogWithToggle#ALWAYS}</li>
	 *         <li>{@link MessageDialogWithToggle#NEVER}</li>
	 *         </ul>
	 */
	public String getCurrentSynchronizationBehavior(boolean isThreeWay) {
		String prefValue = getPreferenceStore().getString(getGroupSynchronizationPreferenceKey(isThreeWay));
		if (SYNC_VALUES.contains(prefValue)) {
			return prefValue;
		} else {
			return SYNC_DEFAULT_VALUE;
		}

	}
}
