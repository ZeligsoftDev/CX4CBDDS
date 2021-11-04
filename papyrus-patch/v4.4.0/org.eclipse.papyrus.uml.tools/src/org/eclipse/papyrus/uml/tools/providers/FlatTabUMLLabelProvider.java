/*****************************************************************************
 * Copyright (c) 2016 CEA LIST, ALL4TEC and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) - mickael.adam@all4tec.net -  Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.providers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.papyrus.infra.widgets.providers.IDependableLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalLabelProvider;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.messages.Messages;
import org.eclipse.papyrus.uml.tools.profile.definition.LabelStylersEnum;
import org.eclipse.papyrus.uml.tools.profile.definition.LabelTypesEnum;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.uml2.uml.Element;

/**
 * The label provider used for the flat tab of treeSelectorDialalog in uml context. It's provide a button to display qualify name.
 * @since 3.0
 */
public class FlatTabUMLLabelProvider implements IGraphicalLabelProvider, IStyledLabelProvider, IDependableLabelProvider {


	/** The customized styles preference key. Used to gets in preferences store the list of styles */
	private static final String CUSTOMIZED_STYLES_PREF_KEY = "CustomizedStyles"; //$NON-NLS-1$

	/** The customized types preference key. Used to gets in preferences store the list of types */
	private static final String CUSTOMIZED_TYPES_PREF_KEY = "CustomizedTypes"; //$NON-NLS-1$

	/** The modele explorer bundle name, which is used to store preferences of styles and types. */
	private static final String MODELEXPLORER_BUNDLE_NAME = "org.eclipse.papyrus.uml.modelexplorer"; //$NON-NLS-1$

	/** Icon for the qualified name display. */
	private static final String ICON_QUALIFIED_NAME = "/icons/QualifiedName.png";//$NON-NLS-1$

	/** the UML label provider */
	private static final CustomizableDelegatingItemLabelProvider umllabelProvider = new CustomizableDelegatingItemLabelProvider();

	/** the list of listener. */
	private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

	/** true if the qualify name is display. */
	private boolean displayQualifiedName = false;

	/** the list of types */
	private List<String> types = new ArrayList<String>();

	/** the list of style */
	private List<StyledString.Styler> stylers = new ArrayList<StyledString.Styler>();

	/** The related label provider */
	private ILabelProvider provider;

	private ToolBar Toolbar;

	/** The dialog settings key for this class. */
	protected static final String DIALOG_SETTINGS_KEY = FlatTabUMLLabelProvider.class.getName();

	/** The preference key for display qualified name. */
	private static final String DISPLAY_QUALIFIED_NAME_PREF_KEY = "displayQualifiedName";//$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public FlatTabUMLLabelProvider() {
		initializeDialogsSettings();
	}

	/**
	 * initialize settings.
	 */
	protected void initializeDialogsSettings() {
		displayQualifiedName = getDialogSettings().getBoolean(DISPLAY_QUALIFIED_NAME_PREF_KEY);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(final ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	@Override
	public StyledString getStyledText(final Object object) {
		Object element = null;
		EObject eObject = null;
		StyledString styledString = null;
		if (object instanceof IAdaptable) {
			eObject = ((IAdaptable) object).getAdapter(EObject.class);
		}

		if (null != eObject) {
			element = eObject;
		} else {
			element = object;
		}

		if (element instanceof Element) {
			styledString = umllabelProvider.getStyledText(element);
		} else {
			if (null != provider) {
				if (provider instanceof IStyledLabelProvider) {
					styledString = ((IStyledLabelProvider) provider).getStyledText(element);
				} else {
					styledString = new StyledString(provider.getText(element));
				}
			} else {
				styledString = new StyledString(element.toString());
			}
			setDisplayQualifiedNameButton(false);
		}
		return styledString;
	}

	/**
	 * Hide the qualified name button if object are not uml {@link Element}.
	 */
	protected void setDisplayQualifiedNameButton(final boolean visible) {
		if (null != Toolbar && !Toolbar.isDisposed() && visible != Toolbar.getVisible()) {
			Composite parent = Toolbar.getParent();
			Toolbar.dispose();
			parent.pack();

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object element) {
		Image image = null;
		if (element instanceof Element) {
			Object image2 = umllabelProvider.getImage(element);
			if (image2 instanceof Image) {
				image = (Image) image2;
			} else if (image2 instanceof ComposedImage) {
				if (((ComposedImage) image2).getImages().get(0) instanceof URL) {
					ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL((URL) ((ComposedImage) image2).getImages().get(0));
					image = imageDescriptor.createImage();
				}
			}
		} else if (null != provider) {
			image = provider.getImage(element);
		}
		return image;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(final Object element) {
		return getStyledText(element).toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(final ILabelProviderListener listener) {
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/**
	 * Create the display Qualify name button.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IGraphicalLabelProvider#createViewerToolbar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createViewerToolbar(final Composite parent) {
		Toolbar = new ToolBar(parent, SWT.NONE);
		ToolItem qualifiedName = new ToolItem(Toolbar, SWT.CHECK);
		qualifiedName.setImage(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ICON_QUALIFIED_NAME).createImage());
		qualifiedName.setToolTipText(Messages.FlatTabUMLLabelProvider_QualifyNameButtonTooltip);
		qualifiedName.setSelection(displayQualifiedName);
		qualifiedName.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean newValue = ((ToolItem) event.getSource()).getSelection();
				if (newValue != displayQualifiedName) {
					displayQualifiedName = newValue;
					getDialogSettings().put(DISPLAY_QUALIFIED_NAME_PREF_KEY, displayQualifiedName);
					refreshLabelProvider();
				}
			}
		});
		refreshLabelProvider();
	}


	/**
	 * Refresh the label provider.
	 */
	protected void refreshLabelProvider() {
		types.clear();
		stylers.clear();
		types.addAll(getTypes());
		stylers.addAll(getStylers());

		if (displayQualifiedName) {
			int index = types.indexOf(LabelTypesEnum.LABEL.toString());
			if (0 < index) {
				types.remove(index);
				types.add(index, LabelTypesEnum.QUALIFIED_NAME.toString());
			}
		} else {
			int index = types.indexOf(LabelTypesEnum.QUALIFIED_NAME.toString());
			if (0 < index) {
				types.remove(index);
				types.add(index, LabelTypesEnum.LABEL.toString());
			}
		}

		umllabelProvider.setStylesList(types, stylers);
		notifyChange();
	}

	/**
	 * Notify the change.
	 */
	protected void notifyChange() {
		for (ILabelProviderListener labelProviderListener : listeners) {
			labelProviderListener.labelProviderChanged(new LabelProviderChangedEvent(this));
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IDependableLabelProvider#getLabelProvider()
	 */
	@Override
	public ILabelProvider getLabelProvider() {
		return provider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IDependableLabelProvider#setLabelProvider(org.eclipse.jface.viewers.ILabelProvider)
	 */
	@Override
	public void setLabelProvider(final ILabelProvider provider) {
		this.provider = provider;
	}

	/**
	 * @return the types list to display from the preference store.
	 */
	protected List<String> getTypes() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, MODELEXPLORER_BUNDLE_NAME);
		String[] types = scopedPreferenceStore.getString(CUSTOMIZED_TYPES_PREF_KEY).split(" ");//$NON-NLS-1$
		List<String> typesList = Arrays.asList(types);
		return typesList;
	}

	/**
	 * @return the stylers list to display from the preference store.
	 */
	protected List<Styler> getStylers() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, MODELEXPLORER_BUNDLE_NAME);
		String[] styles = scopedPreferenceStore.getString(CUSTOMIZED_STYLES_PREF_KEY).split(" ");//$NON-NLS-1$
		List<Styler> stylesList = new ArrayList<>();
		for (int i = 0; i < styles.length; i++) {
			stylesList.add(LabelStylersEnum.getByLiteral(styles[i]).getStyler());
		}
		return stylesList;
	}

	/**
	 * Returns the dialog settings. Returned object can't be null.
	 *
	 * @return dialog settings for this dialog
	 */
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS_KEY);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS_KEY);
		}
		return settings;
	}

}
