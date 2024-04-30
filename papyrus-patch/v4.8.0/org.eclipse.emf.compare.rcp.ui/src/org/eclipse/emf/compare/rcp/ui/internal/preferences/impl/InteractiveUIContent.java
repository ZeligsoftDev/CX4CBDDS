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
package org.eclipse.emf.compare.rcp.ui.internal.preferences.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemUtil;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.AbstractConfigurationUI;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.IConfigurationUIFactory;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.DataHolder;
import org.eclipse.jface.databinding.viewers.IViewerObservableSet;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.Preferences;

/**
 * A User interface that holds a viewer and satellites elements.
 * <p>
 * This viewer can have a satellite configuration composite reacting on selection. It displays a configuration
 * UI for the current selection. It's requires a configuration UI registry.
 * </p>
 * <p>
 * This viewer can have a satellite text field holding the description of the current selection. This field
 * display the description for the current element.
 * </p>
 * <p>
 * This class allows a user to select and check elements.
 * </p>
 * <p>
 * It can also synchronize the state of checked element into a {@link DataHolder}
 * </p>
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public final class InteractiveUIContent {

	/** Width hint for configuration composite. */
	private static final int WIDTH_HINT_CONFIG_COMPOSITE = 400;

	/** Height hint for description composite. */
	private static final int DESCRIPTION_COMPOSITE_HEIGHT_HINT = 50;

	/** Width hint for description composite. */
	private static final int DESCRIPTION_COMPOSITE_WIDTH_HINT = 400;

	/** Text that will be updated with the description of the viewer. */
	private final Label descriptionText;

	/** Composite holding the viewer. */
	private final Composite viewerCompsite;

	/** Composite holding the configuration. This will react to the selection in the viewer. */
	private final Composite configurationComposite;

	/** Composite that is used when the selection has no registered configuration. */
	private final Composite defaultComposite;

	/** Viewer of {@link IItemDescriptor}. */
	private CheckboxTableViewer viewer;

	/** List of all {@link AbstractConfigurationUI} that are linked to this viewer. */
	private final Map<String, AbstractConfigurationUI> configurators = new HashMap<String, AbstractConfigurationUI>();

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            Composite parent holding this interactive content.
	 * @param hasDescription
	 *            Set to true if this has a description label that react to viewer selection.
	 * @param hasConfiguration
	 *            set to true if this has a configuration composite that react to viewer selection.
	 */
	private InteractiveUIContent(Composite parent, boolean hasDescription, boolean hasConfiguration) {
		super();
		Composite contentComposite = new Composite(parent, SWT.NONE);
		final int numberOfColumns;
		if (hasConfiguration) {
			numberOfColumns = 2;
		} else {
			numberOfColumns = 1;
		}
		GridLayoutFactory.fillDefaults().numColumns(numberOfColumns).applyTo(contentComposite);
		contentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// Engine chooser composite
		this.viewerCompsite = new Composite(contentComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(viewerCompsite);
		viewerCompsite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		if (hasConfiguration) {
			// Config composite
			this.configurationComposite = createConfigComposite(contentComposite);
			// Init default composite.
			defaultComposite = new Composite(configurationComposite, SWT.NONE);
			defaultComposite.setLayout(new GridLayout(1, true));
			Label text = new Label(defaultComposite, SWT.WRAP);
			text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
			text.setText(
					EMFCompareRCPUIMessages.getString("InteractiveUIContent.defaultConfiguration.label")); //$NON-NLS-1$
		} else {
			this.configurationComposite = null;
			this.defaultComposite = null;
		}
		if (hasDescription) {
			// Descriptor engine Text
			this.descriptionText = createDescriptionComposite(parent);
		} else {
			this.descriptionText = null;
		}
	}

	/**
	 * Adds a configuration to this Interactive content.
	 * 
	 * @param id
	 *            Id of the item to configure
	 * @param configuratorfactory
	 *            Factory for the configuration
	 * @param store
	 *            Preference store that will hold this {@link IConfigurationUIFactory} value.
	 */
	public void addConfigurator(String id, IConfigurationUIFactory configuratorfactory,
			IPreferenceStore store) {
		AbstractConfigurationUI configurator = configuratorfactory.createUI(configurationComposite, SWT.NONE,
				store);
		configurators.put(id, configurator);
	}

	/**
	 * Checks one element in the viewer.
	 * 
	 * @param descriptor
	 *            element to check.
	 */
	public void checkElement(IItemDescriptor<?> descriptor) {
		viewer.setCheckedElements(new Object[] {descriptor });
	}

	/**
	 * Checks multiple element in the viewer. (Only use if multiple selection is allowed)
	 * 
	 * @param descriptors
	 *            elements to check.
	 */
	public <T> void checkElements(Collection<IItemDescriptor<T>> descriptors) {
		viewer.setCheckedElements(descriptors.toArray());
	}

	/**
	 * Checks multiple element in the viewer. (Only use if multiple selection is allowed)
	 * 
	 * @param descriptors
	 *            elements to check.
	 */
	public <T> void checkElements(IItemDescriptor<T>[] descriptors) {
		viewer.setCheckedElements(descriptors);
	}

	/**
	 * Creates the composite that will hold all configurations for a tab.
	 * 
	 * @param composite
	 *            Main composite
	 * @return Group that will hold configurations in a stack layout.
	 */
	private Group createConfigComposite(Composite composite) {
		Group confComposite = new Group(composite, SWT.NONE);
		confComposite.setText(
				EMFCompareRCPUIMessages.getString("InteractiveUIContent.configurationComposite.label")); //$NON-NLS-1$
		StackLayout layout = new StackLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 5;
		confComposite.setLayout(layout);
		GridData layoutData = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
		layoutData.widthHint = WIDTH_HINT_CONFIG_COMPOSITE;
		confComposite.setLayoutData(layoutData);
		return confComposite;
	}

	/**
	 * Composite for description. This composite holds the text widget that will be updated with the current
	 * selection.
	 * 
	 * @param composite
	 *            Main composite.
	 * @return Label that will hold viewer selection description.
	 */
	private Label createDescriptionComposite(Composite composite) {
		Group descriptionComposite = new Group(composite, SWT.NONE);
		descriptionComposite.setText(
				EMFCompareRCPUIMessages.getString("InteractiveUIContent.descriptionComposite.label")); //$NON-NLS-1$
		descriptionComposite.setLayout(new GridLayout(1, false));
		descriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		Label engineDescriptionLabel = new Label(descriptionComposite, SWT.WRAP);
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		layoutData.heightHint = DESCRIPTION_COMPOSITE_HEIGHT_HINT;
		layoutData.widthHint = DESCRIPTION_COMPOSITE_WIDTH_HINT;
		engineDescriptionLabel.setLayoutData(layoutData);
		return engineDescriptionLabel;
	}

	/**
	 * @return A map of all configuration.
	 */
	public Map<String, AbstractConfigurationUI> getConfigurators() {
		return ImmutableMap.copyOf(configurators);
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return The viewer.
	 */
	public CheckboxTableViewer getViewer() {
		return viewer;
	}

	/**
	 * Returns the composite that will hold the viewer.
	 * 
	 * @return The composite holding the viewer.
	 */
	private Composite getViewerComposite() {
		return viewerCompsite;
	}

	/**
	 * Handles a selection in the viewer. Update related components.
	 * 
	 * @param descriptor
	 *            Item to select.
	 */
	public <T> void select(IItemDescriptor<T> descriptor) {
		selectAll(Collections.singleton(descriptor));
	}

	/**
	 * Handles a selection in the viewer. Update related components.
	 * 
	 * @param descriptor
	 *            Item to select.
	 */
	public <T> void selectAll(Collection<IItemDescriptor<T>> descriptors) {
		// Update viewer
		viewer.setSelection(new StructuredSelection(descriptors), true);
		updateLinkedElements(descriptors.iterator().next());
	}

	/**
	 * Sets the viewer in the interactive content.
	 * 
	 * @param inputViewer
	 *            A {@link StructuredViewer} of {@link IItemDescriptor}
	 */
	public void setViewer(CheckboxTableViewer inputViewer) {
		this.viewer = inputViewer;
		if (configurationComposite != null) {
			viewer.addSelectionChangedListener(new ConfigurationListener());
		}
		viewer.addSelectionChangedListener(new DescriptionListener());
	}

	/**
	 * Updates the linked element in this interactive content.
	 * 
	 * @param descriptor
	 *            Item used as input to get information for satellite elements.
	 */
	private void updateLinkedElements(IItemDescriptor<?> descriptor) {
		// Update description
		descriptionText.setText(descriptor.getDescription());
		if (configurationComposite != null) {
			updateConfigurationComposite(descriptor);
		}
	}

	/**
	 * Updates the configuration composite.
	 * 
	 * @param descriptor
	 *            New descriptor.
	 */
	private void updateConfigurationComposite(IItemDescriptor<?> descriptor) {
		StackLayout stackLayout = (StackLayout)configurationComposite.getLayout();
		if (configurators.containsKey(descriptor.getID())) {
			stackLayout.topControl = configurators.get(descriptor.getID());
		} else {
			stackLayout.topControl = defaultComposite;
		}
		configurationComposite.layout();
	}

	/**
	 * This listener updates the Data Holder.
	 * <p>
	 * With this listener, only one element can be checked at a time
	 * </p>
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 * @param <T>
	 *            Type of item.
	 */
	private static final class SingleCheckListener<T> implements ICheckStateListener {
		/** Data holder. */
		private final DataHolder<T> dataObject;

		/** Viewer. */
		private final CheckboxTableViewer descriptorViewer;

		/** Shell. */
		private final Shell shell;

		/**
		 * Constructor.
		 * 
		 * @param dataObject
		 *            Data holder.
		 * @param descriptorViewer
		 *            Viewer
		 * @param shell
		 *            Shell.
		 */
		private SingleCheckListener(DataHolder<T> dataObject, CheckboxTableViewer descriptorViewer,
				Shell shell) {
			this.dataObject = dataObject;
			this.descriptorViewer = descriptorViewer;
			this.shell = shell;
		}

		/**
		 * {@inheritDoc}
		 */
		public void checkStateChanged(CheckStateChangedEvent event) {
			Object element = event.getElement();
			if (event.getChecked()) {
				if (element instanceof IItemDescriptor<?>) {
					@SuppressWarnings("unchecked")
					IItemDescriptor<T> descriptor = (IItemDescriptor<T>)element;
					dataObject.setData(Collections.singleton(descriptor));
				}
				descriptorViewer.setCheckedElements(new Object[] {element });
			} else {
				// Prevent from nothing checked
				if (descriptorViewer.getCheckedElements().length == 0) {
					descriptorViewer.setCheckedElements(new Object[] {element });
					MessageDialog.openWarning(shell,
							EMFCompareRCPUIMessages
									.getString("InteractiveUIContent.incorrectSelection.title"), //$NON-NLS-1$
							EMFCompareRCPUIMessages
									.getString("InteractiveUIContent.incorrectSelection.message")); //$NON-NLS-1$
				}
			}

		}
	}

	/**
	 * Listener in charge of updating the configuration composite.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private final class ConfigurationListener implements ISelectionChangedListener {
		/**
		 * {@inheritDoc}
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structSelection = (IStructuredSelection)selection;
				Object selected = structSelection.getFirstElement();
				if (selected instanceof IItemDescriptor<?>) {
					updateLinkedElements((IItemDescriptor<?>)selected);
				}
			}
		}
	}

	/**
	 * Listener used to update description text.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 */
	private final class DescriptionListener implements ISelectionChangedListener {

		/**
		 * {@inheritDoc}
		 */
		public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structSelection = (IStructuredSelection)selection;
				Object selected = structSelection.getFirstElement();
				if (selected instanceof IItemDescriptor<?>) {
					IItemDescriptor<?> desc = (IItemDescriptor<?>)selected;
					String description = desc.getDescription();
					descriptionText.setText(description);
				}
			}

		}
	}

	/**
	 * Builder for an Interactive UI.
	 * 
	 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
	 * @param <T>
	 *            type of item in the viewer.
	 */
	public static class InteractiveUIBuilder<T> {

		/** Holding composite of all the structure. */
		private Composite parent;

		/** Item registry holding input of the viewer. */
		private IItemRegistry<T> registry;

		/** Key of the preference node where the configuration for an item is stored. */
		private String configurationNodeKey;

		/** Configuration UI registry. */
		private Map<String, IConfigurationUIFactory> configurationUIRegistry;

		/** Set of elements to check by default. */
		private Set<IItemDescriptor<T>> defaultCheck;

		/** Element to select by default. */
		private IItemDescriptor<T> defaultSelection;

		/** Object holding data representing the current status of the interactive content. */
		private DataHolder<T> dataHolder;

		/** Set to true if the interactive content has a description field. */
		private boolean hasDescription = true;

		/** Set to true if this interactive content is synchronized with only one element at a time. */
		private boolean isSimple = false;

		/**
		 * Constructor.
		 * 
		 * @param parent
		 *            Holding composite of all the structure.
		 * @param registry
		 *            Item registry holding input of the viewer.
		 */
		public InteractiveUIBuilder(Composite parent, IItemRegistry<T> registry) {
			super();
			this.parent = parent;
			this.registry = registry;
		}

		/**
		 * Sets a dataHolder that will be synchronized with the checked element.
		 * 
		 * @param newDataHolder
		 *            DataHolder.
		 * @return {@link InteractiveUIBuilder}
		 */
		public InteractiveUIBuilder<T> setHoldingData(DataHolder<T> newDataHolder) {
			this.dataHolder = newDataHolder;
			return this;
		}

		/**
		 * Node key used to get the {@link Preferences} to retrieve {@link IConfigurationUIFactory}. See
		 * {@link ItemUtil#getConfigurationPreferenceNode(String, String)} (needed if a
		 * ConfigurationUIRegistry has been provided)
		 * 
		 * @param key
		 *            .
		 * @return {@link InteractiveUIBuilder}
		 */
		public InteractiveUIBuilder<T> setConfigurationNodeKey(String key) {
			this.configurationNodeKey = key;
			return this;
		}

		/**
		 * Registry of {@link IConfigurationUIFactory} used to fill the configuration composite.
		 * 
		 * @param configuratorUIRegistry
		 *            .
		 * @return {@link InteractiveUIBuilder}
		 */
		public InteractiveUIBuilder<T> setConfiguratorUIRegistry(
				Map<String, IConfigurationUIFactory> configuratorUIRegistry) {
			this.configurationUIRegistry = configuratorUIRegistry;
			return this;
		}

		/**
		 * Sets the default element to check. (A singleton if "this" is set to simple
		 * {@link InteractiveUIBuilder#setSimple(boolean)}
		 * 
		 * @param newDefaultCheck
		 *            .
		 * @return InteractiveUIBuilder
		 */
		public InteractiveUIBuilder<T> setDefaultCheck(Set<IItemDescriptor<T>> newDefaultCheck) {
			this.defaultCheck = newDefaultCheck;
			return this;
		}

		/**
		 * Set the default element to select.
		 * 
		 * @param newDefaultSelection
		 *            .
		 * @return InteractiveUIBuilder
		 */
		public InteractiveUIBuilder<T> setDefaultSelection(IItemDescriptor<T> newDefaultSelection) {
			this.defaultSelection = newDefaultSelection;
			return this;
		}

		/**
		 * Set to true if "this" needs to create a description field.
		 * 
		 * @param newHasDescription
		 *            .
		 * @return {@link InteractiveUIBuilder}
		 */
		public InteractiveUIBuilder<T> setHasDescription(boolean newHasDescription) {
			this.hasDescription = newHasDescription;
			return this;
		}

		/**
		 * Set to true if the viewer can only have only one element checked at a time.
		 * 
		 * @param newIsSimple
		 *            .
		 * @return {@link InteractiveUIBuilder}
		 */
		public InteractiveUIBuilder<T> setSimple(boolean newIsSimple) {
			this.isSimple = newIsSimple;
			return this;
		}

		/**
		 * Build a new {@link InteractiveUI}.
		 * 
		 * @return InteractiveUIContent
		 */
		public InteractiveUIContent build() {
			// If simple only one element check at a time
			Preconditions.checkArgument(!isSimple || defaultCheck == null || defaultCheck.size() == 1);

			boolean hasConfiguration = configurationUIRegistry != null;
			// If has a configuration composite then the key to retrieve the preference must be set up.
			Preconditions.checkArgument(!hasConfiguration || configurationNodeKey != null);

			final InteractiveUIContent interactiveUI = new InteractiveUIContent(parent, hasDescription,
					hasConfiguration);

			CheckboxTableViewer descriptorViewer = createViewer(interactiveUI);

			if (hasConfiguration) {
				createConfigurationComposite(interactiveUI);
			}
			setViewerInput(descriptorViewer);
			// Init and bind data
			bindAndInit(interactiveUI, descriptorViewer);
			return interactiveUI;
		}

		/**
		 * Initializes the viewer.
		 * 
		 * @param interactiveUI
		 *            .
		 * @return CheckboxTableViewer
		 */
		private CheckboxTableViewer createViewer(final InteractiveUIContent interactiveUI) {
			int style = SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION;
			if (isSimple) {
				style = style | SWT.SINGLE;
			}
			CheckboxTableViewer descriptorViewer = CheckboxTableViewer
					.newCheckList(interactiveUI.getViewerComposite(), style);
			interactiveUI.setViewer(descriptorViewer);
			descriptorViewer.setContentProvider(ArrayContentProvider.getInstance());
			descriptorViewer.setLabelProvider(new ItemDescriptorLabelProvider());
			GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
			descriptorViewer.getControl().setLayoutData(gd);
			return descriptorViewer;
		}

		/**
		 * Creates the configuration composite.
		 * 
		 * @param interactiveUI
		 *            .
		 */
		private void createConfigurationComposite(final InteractiveUIContent interactiveUI) {
			// Init configuration elements
			for (IItemDescriptor<T> item : registry.getItemDescriptors()) {
				String itemId = item.getID();
				IConfigurationUIFactory configuratorFactory = configurationUIRegistry.get(itemId);
				if (configuratorFactory != null) {
					// Preferences pref = ItemUtil.getConfigurationPreferenceNode(configurationNodeKey,
					// itemId);
					ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
							EMFCompareRCPPlugin.PLUGIN_ID);
					store.setSearchContexts(
							new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
					interactiveUI.addConfigurator(itemId, configuratorFactory, store);
				}
			}
		}

		/**
		 * Initializes and binds interactive content with the data holder value.
		 * 
		 * @param interactiveUI
		 *            .
		 * @param descriptorViewer
		 *            .
		 */
		private void bindAndInit(final InteractiveUIContent interactiveUI,
				CheckboxTableViewer descriptorViewer) {
			if (defaultSelection != null) {
				interactiveUI.select(defaultSelection);
			}
			if (isSimple) {
				if (defaultCheck != null) {
					IItemDescriptor<T> defaultCheckedElement = defaultCheck.iterator().next();
					interactiveUI.checkElement(defaultCheckedElement);
					if (dataHolder != null) {
						dataHolder.setData(Collections.singleton(defaultCheckedElement));
					}
				}
				descriptorViewer.addCheckStateListener(new SingleCheckListener<T>(dataHolder,
						descriptorViewer, Display.getDefault().getActiveShell()));
			} else {
				if (dataHolder != null) {
					if (defaultCheck != null) {
						dataHolder.setData(defaultCheck);
					}
					// Bind data
					bindMultipleData(interactiveUI.getViewer(), dataHolder);
				}
			}
		}

		/**
		 * Sets the viewer input.
		 * 
		 * @param descriptorViewer
		 *            .
		 */
		private void setViewerInput(CheckboxTableViewer descriptorViewer) {
			List<IItemDescriptor<T>> itemDescriptors = registry.getItemDescriptors();
			Collections.sort(itemDescriptors);
			descriptorViewer.setInput(itemDescriptors);
		}

		/**
		 * Binds UI to data object.
		 * 
		 * @param descriptorViewer
		 *            .
		 * @param dataObject
		 *            The data holder.
		 */
		private void bindMultipleData(CheckboxTableViewer descriptorViewer, final DataHolder<T> dataObject) {
			DataBindingContext ctx = new DataBindingContext();
			// Bind the button with the corresponding field in data
			IViewerObservableSet target = ViewersObservables.observeCheckedElements(descriptorViewer,
					IItemDescriptor.class);
			IObservableSet model = PojoProperties.set(DataHolder.class, DataHolder.DATA_FIELD_NAME)
					.observe(dataObject);

			ctx.bindSet(target, model);
		}

	}

}
