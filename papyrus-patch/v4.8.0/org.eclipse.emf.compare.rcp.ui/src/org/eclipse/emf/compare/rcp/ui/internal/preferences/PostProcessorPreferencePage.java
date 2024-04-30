/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.preferences;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.postprocessor.IPostProcessor.Descriptor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.internal.extension.IItemDescriptor;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemUtil;
import org.eclipse.emf.compare.rcp.internal.preferences.EMFComparePreferences;
import org.eclipse.emf.compare.rcp.internal.tracer.TracingConstant;
import org.eclipse.emf.compare.rcp.ui.internal.EMFCompareRCPUIMessages;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.InteractiveUIContent;
import org.eclipse.emf.compare.rcp.ui.internal.preferences.impl.InteractiveUIContent.InteractiveUIBuilder;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Preference page used to enable/disable post processor.
 * 
 * @author <a href="mailto:arthur.daussy@obeo.fr">Arthur Daussy</a>
 */
public class PostProcessorPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/** Data holder. */
	private DataHolder<IPostProcessor.Descriptor> dataHolder = new DataHolder<IPostProcessor.Descriptor>();

	/** {@link InteractiveUIContent}. */
	private InteractiveUIContent interactiveUI;

	/**
	 * Constructor.
	 */
	public PostProcessorPreferencePage() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            .
	 * @param image
	 *            .
	 */
	public PostProcessorPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	/**
	 * Constructor.
	 * 
	 * @param title
	 *            .
	 */
	public PostProcessorPreferencePage(String title) {
		super(title);
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IWorkbench workbench) {
		ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				EMFCompareRCPPlugin.PLUGIN_ID);
		store.setSearchContexts(new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
		setPreferenceStore(store);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().equalWidth(true).applyTo(container);
		// container.setLayout(new GridLayout(1, true));
		Label introductionText = new Label(container, SWT.WRAP);
		introductionText.setText(
				EMFCompareRCPUIMessages.getString("PostProcessorPreferencePage.preferencePage.description")); //$NON-NLS-1$

		IItemRegistry<IPostProcessor.Descriptor> postProcessorRegistryDescriptor = EMFCompareRCPPlugin
				.getDefault().getPostProcessorDescriptorRegistry();
		Set<IItemDescriptor<Descriptor>> activesPostProcessor = ItemUtil.getActiveItems(
				postProcessorRegistryDescriptor, EMFCompareRCPPlugin.PLUGIN_ID,
				EMFComparePreferences.DISABLED_POST_PROCESSOR);
		InteractiveUIBuilder<Descriptor> postProcessorUIBuilder = new InteractiveUIBuilder<IPostProcessor.Descriptor>(
				container, postProcessorRegistryDescriptor);
		Set<IItemDescriptor<Descriptor>> descriptors = Sets
				.newLinkedHashSet(postProcessorRegistryDescriptor.getItemDescriptors());
		postProcessorUIBuilder.setConfigurationNodeKey(EMFComparePreferences.DISABLED_POST_PROCESSOR)
				.setDefaultCheck(descriptors)
				.setDefaultSelection(postProcessorRegistryDescriptor.getHighestRankingDescriptor())
				.setHoldingData(dataHolder).setDefaultCheck(activesPostProcessor);
		interactiveUI = postProcessorUIBuilder.build();

		return container;
	}

	@Override
	public boolean performOk() {
		Set<IItemDescriptor<Descriptor>> postProcessorDescriptors = Sets.newLinkedHashSet(
				EMFCompareRCPPlugin.getDefault().getPostProcessorDescriptorRegistry().getItemDescriptors());
		SetView<IItemDescriptor<Descriptor>> postProcessorToDisable = Sets
				.difference(postProcessorDescriptors, dataHolder.getData());
		setEnginePreferences(EMFComparePreferences.DISABLED_POST_PROCESSOR, postProcessorToDisable);

		if (TracingConstant.CONFIGURATION_TRACING_ACTIVATED) {
			StringBuilder traceMessage = new StringBuilder("Post processor preference serialization:\n"); //$NON-NLS-1$
			String prefDelimiter = " :\n"; //$NON-NLS-1$
			String newLine = "\n"; //$NON-NLS-1$
			traceMessage.append(EMFComparePreferences.DISABLED_POST_PROCESSOR).append(prefDelimiter)
					.append(getPreferenceStore().getString(EMFComparePreferences.DISABLED_POST_PROCESSOR))
					.append(newLine);
			EMFCompareRCPPlugin.getDefault().log(IStatus.INFO, traceMessage.toString());
		}

		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		Set<IItemDescriptor<Descriptor>> descriptors = Sets.newLinkedHashSet(
				EMFCompareRCPPlugin.getDefault().getPostProcessorDescriptorRegistry().getItemDescriptors());
		interactiveUI.checkElements(descriptors.toArray(new IItemDescriptor[descriptors.size()]));
		dataHolder.setData(descriptors);
		super.performDefaults();
	}

	/**
	 * Store engines preferences into the preference store.
	 * 
	 * @param preferenceKey
	 *            Key used in the preference store.
	 * @param currentSelectedEngines
	 *            Engines to store.
	 */
	private void setEnginePreferences(String preferenceKey,
			Set<IItemDescriptor<IPostProcessor.Descriptor>> currentSelectedEngines) {
		if (currentSelectedEngines != null && currentSelectedEngines.size() > 0) {
			Iterable<String> identifiers = Iterables.transform(currentSelectedEngines,
					new Function<IItemDescriptor<?>, String>() {
						public String apply(IItemDescriptor<?> desc) {
							return desc.getID();
						}
					});
			String descriptorsKey = Joiner.on(ItemUtil.PREFERENCE_DELIMITER).join(identifiers);
			getPreferenceStore().setValue(preferenceKey, descriptorsKey);
		} else {
			getPreferenceStore().setToDefault(preferenceKey);
		}
	}

}
