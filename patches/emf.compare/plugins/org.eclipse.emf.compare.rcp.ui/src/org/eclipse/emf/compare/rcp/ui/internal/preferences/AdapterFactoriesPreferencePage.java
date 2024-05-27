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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.internal.adapterfactory.RankedAdapterFactoryDescriptor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Preferences page used to enable/disable adapter factories that have been contributed to EMF Compare.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class AdapterFactoriesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/** Height hint for the description label. */
	private static final int DESCRIPTION_LABEL_HEIGHT_HINT = 50;

	/** Width hint for configuration composite. */
	private static final int DESCRIPTION_LABEL_WIDTH_HINT = 400;

	private CheckboxTableViewer adapterFactoryDescriptorViewer;

	public void init(IWorkbench workbench) {
		ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				EMFCompareRCPPlugin.PLUGIN_ID);
		store.setSearchContexts(new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
		setPreferenceStore(store);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite containerComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(containerComposite);
		containerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		Label introductionLabel = new Label(containerComposite, SWT.WRAP);
		introductionLabel.setText(
				EMFCompareRCPUIMessages.getString("AdapterFactoryPreferencePage.preferencePage.description")); //$NON-NLS-1$

		createViewer(containerComposite);

		createDescriptionText(containerComposite);

		fillViewer();

		return containerComposite;
	}

	private void fillViewer() {
		List<RankedAdapterFactoryDescriptor> descriptors = Lists
				.newArrayList(EMFCompareRCPPlugin.getDefault().getAdapterFactoryRegistry().getDescriptors());
		Collections.sort(descriptors, new Comparator<RankedAdapterFactoryDescriptor>() {

			public int compare(RankedAdapterFactoryDescriptor o1, RankedAdapterFactoryDescriptor o2) {
				return ComparisonChain.start().compare(o1.getId(), o2.getId()).result();
			}
		});

		adapterFactoryDescriptorViewer.setInput(descriptors);
		if (!descriptors.isEmpty()) {
			adapterFactoryDescriptorViewer.setSelection(new StructuredSelection(descriptors.get(0)), true);
		}

		List<String> disabledDescriptors = EMFComparePreferences.getDisabledAdapterFactoryDescriptorIds();

		initViewer(disabledDescriptors);
	}

	private void createDescriptionText(Composite parent) {
		Group descriptionComposite = new Group(parent, SWT.NONE);
		descriptionComposite.setText(
				EMFCompareRCPUIMessages.getString("AdapterFactoryPreferencePage.descriptionGroup.text")); //$NON-NLS-1$
		descriptionComposite.setLayout(new GridLayout(1, false));
		descriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		final Label engineDescriptionLabel = new Label(descriptionComposite, SWT.WRAP);
		engineDescriptionLabel
				.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		layoutData.heightHint = DESCRIPTION_LABEL_HEIGHT_HINT;
		layoutData.widthHint = DESCRIPTION_LABEL_WIDTH_HINT;
		engineDescriptionLabel.setLayoutData(layoutData);

		// Updates description text with selection
		adapterFactoryDescriptorViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (adapterFactoryDescriptorViewer.equals(event.getSource())) {
					ISelection selection = event.getSelection();
					if (selection instanceof IStructuredSelection) {
						IStructuredSelection structSelection = (IStructuredSelection)selection;
						Object first = structSelection.getFirstElement();
						if (first instanceof RankedAdapterFactoryDescriptor) {
							String description = ((RankedAdapterFactoryDescriptor)first).getDescription();
							if (description != null) {
								engineDescriptionLabel.setText(description);
							} else {
								engineDescriptionLabel.setText(""); //$NON-NLS-1$
							}
						}
					}
				}

			}
		});
	}

	private void createViewer(Composite containerComposite) {
		adapterFactoryDescriptorViewer = CheckboxTableViewer.newCheckList(containerComposite,
				SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION);

		adapterFactoryDescriptorViewer.setContentProvider(ArrayContentProvider.getInstance());
		adapterFactoryDescriptorViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof RankedAdapterFactoryDescriptor) {
					return ((RankedAdapterFactoryDescriptor)element).getLabel();

				}
				return super.getText(element);
			}
		});

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		adapterFactoryDescriptorViewer.getControl().setLayoutData(gd);

		// Prevents unselecting non optional providers
		adapterFactoryDescriptorViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if (element instanceof RankedAdapterFactoryDescriptor) {
					RankedAdapterFactoryDescriptor provider = (RankedAdapterFactoryDescriptor)element;
					if (!provider.isOptional()) {
						event.getCheckable().setChecked(element, true);
					}
				}

			}
		});
	}

	private void initViewer(List<String> disabledDescriptors) {
		for (TableItem item : adapterFactoryDescriptorViewer.getTable().getItems()) {
			RankedAdapterFactoryDescriptor descriptor = (RankedAdapterFactoryDescriptor)item.getData();
			if (!descriptor.isOptional()) {
				item.setForeground(item.getDisplay().getSystemColor(SWT.COLOR_GRAY));
				item.setChecked(true);
			} else {
				item.setChecked(!disabledDescriptors.contains(descriptor.getId()));
			}
		}
	}

	@Override
	protected void performDefaults() {
		initViewer(Collections.<String> emptyList());
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		Object[] checkedDescriptors = adapterFactoryDescriptorViewer.getCheckedElements();

		SetView<RankedAdapterFactoryDescriptor> descriptorsToDisable = Sets.difference(
				Sets.newHashSet(
						EMFCompareRCPPlugin.getDefault().getAdapterFactoryRegistry().getDescriptors()),
				Sets.newHashSet(checkedDescriptors));

		Iterable<String> descriptorsToDisableIds = Iterables.transform(
				Iterables.filter(descriptorsToDisable, RankedAdapterFactoryDescriptor.class),
				new Function<Object, String>() {

					public String apply(Object input) {
						return ((RankedAdapterFactoryDescriptor)input).getId();
					}
				});

		getPreferenceStore().putValue(EMFComparePreferences.DISABLED_ADAPTER_FACTORY,
				Joiner.on(';').join(descriptorsToDisableIds));

		return super.performOk();
	}
}
