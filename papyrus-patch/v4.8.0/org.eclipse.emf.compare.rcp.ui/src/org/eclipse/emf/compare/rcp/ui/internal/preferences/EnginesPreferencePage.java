/*******************************************************************************
 * Copyright (c) 2014, 2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Philip Langer - bug 499986, refactorings
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.CONFLICTS_DETECTOR;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.DIFF_ENGINES;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.EQUI_ENGINES;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.MATCH_ENGINE_DISABLE_ENGINES;
import static org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences.REQ_ENGINES;
import static org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages.getString;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.conflict.IConflictDetector;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.equi.IEquiEngine;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.IMatchEngine.Factory;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemUtil;
import org.eclipse.emf.compare.rcp.internal.tracer.TracingConstant;
import org.eclipse.emf.compare.rcp.ui.EMFCompareRCPUIPlugin;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.AbstractConfigurationUI;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.IConfigurationUIFactory;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.InteractiveUIContent;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.InteractiveUIContent.InteractiveUIBuilder;
import org.eclipse.emf.compare.req.IReqEngine;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Preference page for engines preferences
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class EnginesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/** The match engine registry. */
	private static final IItemRegistry<Factory> MATCH_ENGINE_REGISTRY = EMFCompareRCPPlugin.getDefault()
			.getMatchEngineFactoryDescriptorRegistry();

	/** The req engine registry. */
	private static final IItemRegistry<IReqEngine> REQ_ENGINE_REGISTRY = EMFCompareRCPPlugin.getDefault()
			.getReqEngineDescriptorRegistry();

	/** The diff engine registry. */
	private static final IItemRegistry<IDiffEngine> DIFF_ENGINE_REGISTRY = EMFCompareRCPPlugin.getDefault()
			.getDiffEngineDescriptorRegistry();

	/** The equi engine registry. */
	private static final IItemRegistry<IEquiEngine> EQUI_ENGINE_REGISTRY = EMFCompareRCPPlugin.getDefault()
			.getEquiEngineDescriptorRegistry();

	/** The conflict engine registry. */
	private static final IItemRegistry<IConflictDetector> CONFLICT_DETECTOR_REGISTRY = EMFCompareRCPPlugin
			.getDefault().getConflictDetectorDescriptorRegistry();

	/** Option to specify what is the default, if no preference or default preference is available. */
	private enum DefaultOption {
		/** The highest ranked is the default. */
		HIGHEST_RANKED,
		/** All registered engines should be the default. */
		ALL;
	}

	/** An option to specify what should be stored in the preferences. */
	private enum StoreOption {
		/** The enabled items. */
		ENABLED_ITEMS,
		/** The disabled items. */
		DISABLED_ITEMS;
	}

	/** Pointer to all {@link InteractiveUIContent} of each tab */
	private final Map<String, InteractiveUIContent> interactiveUis = new HashMap<String, InteractiveUIContent>();

	/** Data regarding the Difference selected engine */
	private final DataHolder<IDiffEngine> diffEngineData = new DataHolder<IDiffEngine>();

	/** Data regarding the Equivalence selected engine */
	private final DataHolder<IEquiEngine> equiEngineData = new DataHolder<IEquiEngine>();

	/** Data regarding the Requirement selected engine */
	private final DataHolder<IReqEngine> reqEngineData = new DataHolder<IReqEngine>();

	/** Data regarding the Conflicts detector selected engine */
	private final DataHolder<IConflictDetector> conflictsDetectorData = new DataHolder<IConflictDetector>();

	/** Data regarding the selected match engine factories. */
	private final DataHolder<IMatchEngine.Factory> matchEnginesData = new DataHolder<IMatchEngine.Factory>();

	public EnginesPreferencePage() {
		super();
	}

	public EnginesPreferencePage(String title) {
		super(title);
	}

	public EnginesPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	public void init(IWorkbench workbench) {
		ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				EMFCompareRCPPlugin.PLUGIN_ID);
		store.setSearchContexts(new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
		setPreferenceStore(store);
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		TabFolder tabFolder = new TabFolder(container, SWT.NONE);

		createMatchEngineTab(tabFolder);
		createDiffEngineTab(tabFolder);
		createEquiEngineTab(tabFolder);
		createReqEngineTab(tabFolder);
		createConflictDetectorTab(tabFolder);

		return container;
	}

	/**
	 * Create an {@link InteractiveUIContent} object of a specific type of engine.
	 * 
	 * @param registry
	 *            Registry holding engines.
	 * @param tabComposite
	 *            Holding composite.
	 * @param dataHolder
	 *            Data that will be synchronized with the UI.
	 * @param <T>
	 *            type of engine.
	 * @return {@link InteractiveUIContent} for a specific type of engine.
	 */
	private <T> InteractiveUIContent createEngineUIBuilder(IItemRegistry<T> registry, Composite tabComposite,
			DataHolder<T> dataHolder) {
		String preferenceKey = preferenceKey(registry);
		IItemDescriptor<T> defaultEngine = ItemUtil.getDefaultItemDescriptor(registry, preferenceKey);
		InteractiveUIBuilder<T> uiBuilder = new InteractiveUIBuilder<T>(tabComposite, registry);
		uiBuilder.setSimple(true).setDefaultCheck(Collections.singleton(defaultEngine))
				.setDefaultSelection(defaultEngine).setHoldingData(dataHolder);
		return uiBuilder.build();
	}

	/**
	 * Returns the preference key for the given registry.
	 * 
	 * @param registry
	 *            The registry to get the preference key for.
	 * @return The preference key.
	 */
	private String preferenceKey(IItemRegistry<?> registry) {
		if (registry == MATCH_ENGINE_REGISTRY) {
			return MATCH_ENGINE_DISABLE_ENGINES;
		} else if (registry == DIFF_ENGINE_REGISTRY) {
			return DIFF_ENGINES;
		} else if (registry == REQ_ENGINE_REGISTRY) {
			return REQ_ENGINES;
		} else if (registry == EQUI_ENGINE_REGISTRY) {
			return EQUI_ENGINES;
		} else if (registry == CONFLICT_DETECTOR_REGISTRY) {
			return CONFLICTS_DETECTOR;
		}
		throw new IllegalArgumentException("Unknown registry."); //$NON-NLS-1$
	}

	/**
	 * Create a tab to select one Conflict Detector.
	 * 
	 * @param tabFolder
	 */
	private void createConflictDetectorTab(TabFolder tabFolder) {
		Composite tabComposite = createTabSkeleton(tabFolder,
				getString("EnginesPreferencePage.conflictDetector.tab.label"), //$NON-NLS-1$
				getString("EnginesPreferencePage.conflictDetectorIntro.text"));//$NON-NLS-1$

		InteractiveUIContent interactiveContent = createEngineUIBuilder(CONFLICT_DETECTOR_REGISTRY,
				tabComposite, conflictsDetectorData);

		interactiveUis.put(preferenceKey(CONFLICT_DETECTOR_REGISTRY), interactiveContent);
	}

	/**
	 * Create a tab to select one Requirement Engine.
	 * 
	 * @param tabFolder
	 */
	private void createReqEngineTab(TabFolder tabFolder) {
		Composite tabComposite = createTabSkeleton(tabFolder,
				getString("EnginesPreferencePage.requirementEngine.tab.label"), //$NON-NLS-1$
				getString("EnginesPreferencePage.reqEngineIntro.text")); //$NON-NLS-1$

		InteractiveUIContent interactiveContent = createEngineUIBuilder(REQ_ENGINE_REGISTRY, tabComposite,
				reqEngineData);

		interactiveUis.put(preferenceKey(REQ_ENGINE_REGISTRY), interactiveContent);
	}

	/**
	 * Create a tab to select one Equivalence Engine.
	 * 
	 * @param tabFolder
	 */
	private void createEquiEngineTab(TabFolder tabFolder) {
		Composite tabComposite = createTabSkeleton(tabFolder,
				getString("EnginesPreferencePage.equivalenceEngine.tab.label"), //$NON-NLS-1$
				getString("EnginesPreferencePage.equiEngineIntro.text")); //$NON-NLS-1$

		InteractiveUIContent interactiveContent = createEngineUIBuilder(EQUI_ENGINE_REGISTRY, tabComposite,
				equiEngineData);

		interactiveUis.put(preferenceKey(EQUI_ENGINE_REGISTRY), interactiveContent);
	}

	/**
	 * Create a tab to select one Difference Engine.
	 * 
	 * @param tabFolder
	 */
	private void createDiffEngineTab(TabFolder tabFolder) {
		Composite tabComposite = createTabSkeleton(tabFolder,
				getString("EnginesPreferencePage.differenceEngine.tab.label"), //$NON-NLS-1$
				getString("EnginesPreferencePage.diffEngineIntro.text")); //$NON-NLS-1$

		InteractiveUIContent interactiveContent = createEngineUIBuilder(DIFF_ENGINE_REGISTRY, tabComposite,
				diffEngineData);

		interactiveUis.put(preferenceKey(DIFF_ENGINE_REGISTRY), interactiveContent);
	}

	/**
	 * Create a tab to disable/enable Match Engines.
	 * 
	 * @param tabFolder
	 */
	private void createMatchEngineTab(TabFolder tabFolder) {
		Composite tabComposite = createTabSkeleton(tabFolder,
				getString("EnginesPreferencePage.matchEngine.tab.label"), //$NON-NLS-1$
				getString("EnginesPreferencePage.matchEngineIntro.text")); //$NON-NLS-1$

		Map<String, IConfigurationUIFactory> configuratorUIRegistry = EMFCompareRCPUIPlugin.getDefault()
				.getMatchEngineConfiguratorRegistry();
		Set<IItemDescriptor<Factory>> activeItems = ItemUtil.getActiveItems(MATCH_ENGINE_REGISTRY,
				EMFCompareRCPPlugin.PLUGIN_ID, MATCH_ENGINE_DISABLE_ENGINES);

		InteractiveUIBuilder<IMatchEngine.Factory> builder = new InteractiveUIBuilder<IMatchEngine.Factory>(
				tabComposite, MATCH_ENGINE_REGISTRY);
		builder.setConfiguratorUIRegistry(configuratorUIRegistry).setDefaultCheck(activeItems)
				.setConfigurationNodeKey(MATCH_ENGINE_DISABLE_ENGINES).setHoldingData(matchEnginesData);
		// Forbid unchecking all match engines
		InteractiveUIContent uiContent = builder.build();
		uiContent.getViewer().addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if (!event.getChecked()) {
					// Prevent from nothing checked
					if (((CheckboxTableViewer)event.getSource()).getCheckedElements().length == 0) {
						((CheckboxTableViewer)event.getSource()).setCheckedElements(new Object[] {element });
						MessageDialog.openWarning(getShell(),
								EMFCompareRCPUIMessages
										.getString("InteractiveUIContent.incorrectSelection.title"), //$NON-NLS-1$
								EMFCompareRCPUIMessages
										.getString("InteractiveUIContent.incorrectSelection.message")); //$NON-NLS-1$
					}
				}

			}
		});
		// Save for reset default
		interactiveUis.put(MATCH_ENGINE_DISABLE_ENGINES, uiContent);
	}

	/**
	 * Create skeleton of a tab.
	 * 
	 * @param tabFolder
	 * @param tabLabel
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
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		tabComposite.setLayoutData(layoutData);
		Label descriptionText = new Label(tabComposite, SWT.WRAP);
		descriptionText.setText(introText);
		return tabComposite;
	}

	@Override
	public boolean performOk() {
		setEnginesPreferences();
		storeConfigurations();
		return super.performOk();
	}

	/**
	 * Set all engines preferences.
	 */
	private void setEnginesPreferences() {
		setEnginePreferences(DIFF_ENGINE_REGISTRY, diffEngineData);
		setEnginePreferences(EQUI_ENGINE_REGISTRY, equiEngineData);
		setEnginePreferences(REQ_ENGINE_REGISTRY, reqEngineData);
		setEnginePreferences(CONFLICT_DETECTOR_REGISTRY, conflictsDetectorData);
		setEnginePreferences(MATCH_ENGINE_REGISTRY, matchEnginesData, DefaultOption.ALL,
				StoreOption.DISABLED_ITEMS);
	}

	/**
	 * Store the value of the configuration of each engine into preferences.
	 */
	private void storeConfigurations() {
		for (Entry<String, InteractiveUIContent> interactiveContentEntry : interactiveUis.entrySet()) {
			for (Entry<String, AbstractConfigurationUI> configuratorEntry : interactiveContentEntry.getValue()
					.getConfigurators().entrySet()) {
				AbstractConfigurationUI configurator = configuratorEntry.getValue();
				configurator.storeConfiguration();
			}
		}
		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder traceMessage = new StringBuilder("Engines preference serialization:\n"); //$NON-NLS-1$
			String prefDelimiter = " :\n"; //$NON-NLS-1$
			String newLine = "\n"; //$NON-NLS-1$
			traceMessage.append(DIFF_ENGINES).append(prefDelimiter)
					.append(getPreferenceStore().getString(DIFF_ENGINES)).append(newLine);
			traceMessage.append(EQUI_ENGINES).append(prefDelimiter)
					.append(getPreferenceStore().getString(EQUI_ENGINES)).append(newLine);
			traceMessage.append(REQ_ENGINES).append(prefDelimiter)
					.append(getPreferenceStore().getString(REQ_ENGINES)).append(newLine);
			traceMessage.append(CONFLICTS_DETECTOR).append(prefDelimiter)
					.append(getPreferenceStore().getString(CONFLICTS_DETECTOR)).append(newLine);
			traceMessage.append(MATCH_ENGINE_DISABLE_ENGINES).append(prefDelimiter)
					.append(getPreferenceStore().getString(MATCH_ENGINE_DISABLE_ENGINES)).append(newLine);
			EMFCompareRCPPlugin.getDefault().log(IStatus.INFO, traceMessage.toString());
		}
	}

	@Override
	protected void performDefaults() {
		resetDefaultPreferences(DIFF_ENGINE_REGISTRY, diffEngineData);
		resetDefaultPreferences(REQ_ENGINE_REGISTRY, reqEngineData);
		resetDefaultPreferences(EQUI_ENGINE_REGISTRY, equiEngineData);
		resetDefaultPreferences(CONFLICT_DETECTOR_REGISTRY, conflictsDetectorData);
		resetDefaultPreferences(MATCH_ENGINE_REGISTRY, matchEnginesData, DefaultOption.ALL,
				StoreOption.DISABLED_ITEMS);
		resetConfigurations();
		super.performDefaults();
	}

	/**
	 * Reset all configuration of each engine to its default value.
	 */
	private void resetConfigurations() {
		for (Entry<String, InteractiveUIContent> interactiveContentEntry : interactiveUis.entrySet()) {
			for (AbstractConfigurationUI configurator : interactiveContentEntry.getValue().getConfigurators()
					.values()) {
				configurator.resetDefault();
			}
		}
	}

	/**
	 * Reset engine preference to default using highest rank strategy.
	 * 
	 * @param registry
	 * @param preferenceKey
	 */
	private <T> void resetDefaultPreferences(IItemRegistry<T> registry, DataHolder<T> dataObject) {
		resetDefaultPreferences(registry, dataObject, DefaultOption.HIGHEST_RANKED,
				StoreOption.ENABLED_ITEMS);
	}

	/**
	 * Reset engine preference to default using the specified <code>defaultOption</code>.
	 * 
	 * @param registry
	 * @param dataObject
	 * @param defaultOption
	 */
	private <T> void resetDefaultPreferences(IItemRegistry<T> registry, DataHolder<T> dataObject,
			DefaultOption defaultOption, StoreOption storeOption) {
		InteractiveUIContent interactiveContent = interactiveUis.get(preferenceKey(registry));
		if (interactiveContent != null) {
			Set<IItemDescriptor<T>> defaultEngines = getDefaultDescriptors(registry, defaultOption);
			Set<IItemDescriptor<T>> defaultEnginesToSelect = getItemsToSelect(defaultEngines, registry,
					storeOption);
			interactiveContent.selectAll(defaultEnginesToSelect);
			interactiveContent.checkElements(defaultEnginesToSelect);
			dataObject.setData(defaultEnginesToSelect);
		}
	}

	/**
	 * Returns the items to select in the UI.
	 * <p>
	 * This is equal to {@link #getItemsToStore(Set, IItemRegistry, StoreOption)}, which considers whether the
	 * {@link StoreOption#ENABLED_ITEMS} or {@link StoreOption#DISABLED_ITEMS} are stored, except that it
	 * returns <em>all</em> registered engines from the <code>registry</code> are returned, if
	 * <code>engines</code> is empty.
	 * </p>
	 * 
	 * @param engines
	 * @param registry
	 * @param storeOption
	 * @return
	 */
	private <T> Set<IItemDescriptor<T>> getItemsToSelect(Set<IItemDescriptor<T>> engines,
			IItemRegistry<T> registry, StoreOption storeOption) {
		Set<IItemDescriptor<T>> itemsToStore = getItemsToStore(engines, registry, storeOption);
		if (StoreOption.DISABLED_ITEMS.equals(storeOption) && itemsToStore.isEmpty()) {
			return Sets.newHashSet(registry.getItemDescriptors());
		}
		return itemsToStore;
	}

	/**
	 * Returns the configured default item descriptors or the highest ranked item descriptor if there is no
	 * default.
	 * 
	 * @param registry
	 *            The registry to obtain item descriptors from.
	 * @param defaultOption
	 *            Option specifying what is the default if no other default is pre-configured (all or
	 *            highest-ranked).
	 * @return The default item descriptors.
	 */
	private <T> Set<IItemDescriptor<T>> getDefaultDescriptors(IItemRegistry<T> registry,
			DefaultOption defaultOption) {
		final String defaultValue = getPreferenceStore().getDefaultString(preferenceKey(registry));
		final Set<IItemDescriptor<T>> defaultDescriptors = new LinkedHashSet<>();
		if (!Strings.isNullOrEmpty(defaultValue)) {
			for (String engineId : defaultValue.split(ItemUtil.PREFERENCE_DELIMITER)) {
				final IItemDescriptor<T> itemDescriptor = registry.getItemDescriptor(engineId);
				if (itemDescriptor != null) {
					defaultDescriptors.add(itemDescriptor);
				}
			}
		}
		if (defaultDescriptors.isEmpty()) {
			switch (defaultOption) {
				case ALL:
					defaultDescriptors.addAll(registry.getItemDescriptors());
					break;
				case HIGHEST_RANKED:
					// fall through
				default:
					defaultDescriptors.add(registry.getHighestRankingDescriptor());
					break;
			}
		}
		return defaultDescriptors;
	}

	/**
	 * Stores the engines specified in <code>data</code> for the items in the given <code>registry</code>.
	 * <p>
	 * This method will store the enabled items considering the highest ranked item as the default.
	 * </p>
	 * 
	 * @param registry
	 *            The registry.
	 * @param data
	 *            The data holding the selected items.
	 */
	private <T> void setEnginePreferences(IItemRegistry<T> registry, DataHolder<T> data) {
		setEnginePreferences(registry, data, DefaultOption.HIGHEST_RANKED, StoreOption.ENABLED_ITEMS);
	}

	/**
	 * Stores the engines specified in <code>data</code> for the items in the given <code>registry</code>.
	 * 
	 * @param registry
	 *            The registry.
	 * @param data
	 *            The data holding the selected items.
	 * @param defaultOption
	 *            The default option to consider when storing the preferences.
	 * @param storeOption
	 *            The store option to consider when storing the preferences.
	 */
	private <T> void setEnginePreferences(IItemRegistry<T> registry, DataHolder<T> data,
			DefaultOption defaultOption, StoreOption storeOption) {
		Set<IItemDescriptor<T>> selectedEngines = data.getData();
		Set<IItemDescriptor<T>> toStore = getItemsToStore(selectedEngines, registry, storeOption);
		if (deviatesFromDefaults(toStore, registry, defaultOption, storeOption)) {
			StringBuilder descriptorsKey = new StringBuilder();
			for (Iterator<IItemDescriptor<T>> iterator = toStore.iterator(); iterator.hasNext();) {
				IItemDescriptor<T> iItemDescriptor = iterator.next();
				descriptorsKey.append(iItemDescriptor.getID());
				if (iterator.hasNext()) {
					descriptorsKey.append(ItemUtil.PREFERENCE_DELIMITER);
				}
			}
			getPreferenceStore().setValue(preferenceKey(registry), descriptorsKey.toString());
		} else {
			getPreferenceStore().setToDefault(preferenceKey(registry));
		}
	}

	/**
	 * Returns the items to be stored to store <code>selectedEngines</code> considering the given
	 * <code>storeOption</code>.
	 * 
	 * @param selectedEngines
	 * @param registry
	 * @param storeOption
	 * @return The items to be stored.
	 */
	private <T> Set<IItemDescriptor<T>> getItemsToStore(Set<IItemDescriptor<T>> selectedEngines,
			IItemRegistry<T> registry, StoreOption storeOption) {
		switch (storeOption) {
			case DISABLED_ITEMS:
				return Sets.difference(Sets.newHashSet(registry.getItemDescriptors()), selectedEngines);
			case ENABLED_ITEMS:
				// fall through
			default:
				return selectedEngines;
		}
	}

	/**
	 * Specifies whether the list <code>itemsToStore</code> are different from the defaults.
	 * <p>
	 * This takes into account how the items should be stored, as specified by the <code>storeOptions</code>,
	 * as well as what the defaults are, as specified by the <code>defaultOptions</code>.
	 * 
	 * @param itemsToStore
	 * @param registry
	 * @param defaultOption
	 * @param storeOption
	 * @return <code>true</code> if the items to store are different from the defaults and thus shall be
	 *         stored, or <code>false</code> otherwise.
	 */
	private <T> boolean deviatesFromDefaults(Set<IItemDescriptor<T>> itemsToStore, IItemRegistry<T> registry,
			DefaultOption defaultOption, StoreOption storeOption) {
		Set<IItemDescriptor<T>> defaults = getDefaultDescriptors(registry, defaultOption);
		return itemsToStore != null && !Sets.symmetricDifference(defaults, itemsToStore).isEmpty();
	}
}
