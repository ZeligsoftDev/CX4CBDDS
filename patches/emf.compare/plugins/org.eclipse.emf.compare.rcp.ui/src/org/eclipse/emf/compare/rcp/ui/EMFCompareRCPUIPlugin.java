/******************************************************************************
 * Copyright (c) 2012, 2016 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Mathias Schaefer - preferences refactoring
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.rcp.extension.AbstractRegistryEventListener;
import org.eclipse.emf.compare.rcp.internal.extension.IItemRegistry;
import org.eclipse.emf.compare.rcp.internal.extension.impl.ItemRegistry;
import org.eclipse.emf.compare.rcp.ui.contentmergeviewer.accessor.factory.IAccessorFactory;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.ConfigurationUIRegistryEventListener;
import org.eclipse.emf.compare.rcp.ui.internal.configuration.ui.IConfigurationUIFactory;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl.AccessorFactoryExtensionRegistryListener;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.accessor.factory.impl.AccessorFactoryRegistryImpl;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.customization.ContentMergeViewerCustomizationRegistry;
import org.eclipse.emf.compare.rcp.ui.internal.contentmergeviewer.customization.ContentMergeViewerCustomizationRegistryListener;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.DifferenceFilterExtensionRegistryListener;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.DifferenceFilterManager;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.impl.DifferenceFilterRegistryImpl;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.extender.DifferenceGroupExtenderRegistryImpl;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.extender.DifferenceGroupExtenderRegistryListener;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupManager;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupProviderExtensionRegistryListener;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.impl.DifferenceGroupRegistryImpl;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.rcp.ui.structuremergeviewer.groups.extender.IDifferenceGroupExtender;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @since 3.0
 */
public class EMFCompareRCPUIPlugin extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.emf.compare.rcp.ui"; //$NON-NLS-1$

	public static final String GROUP_PROVIDER_PPID = "groups"; //$NON-NLS-1$

	public static final String FILTER_PROVIDER_PPID = "filters"; //$NON-NLS-1$

	public static final String ACCESSOR_FACTORY_PPID = "accessorFactory"; //$NON-NLS-1$

	/**
	 * @since 4.0
	 */
	public static final String DIFFERENCE_GROUP_EXTENDER_PPID = "differenceGroupExtender"; //$NON-NLS-1$

	/**
	 * @since 4.0
	 */
	private static final String MATCH_ENGINE_FACTORY_CONFIGURATION_UI_PPID = "matchEngineFactoryConfigurationUI";//$NON-NLS-1$

	/**
	 * @since 4.4
	 */
	private static final String CONTENT_CUSTOMIZATION_PPID = "contentMergeViewerCustomization"; //$NON-NLS-1$

	/**
	 * the shared instance.
	 */
	private static EMFCompareRCPUIPlugin plugin;

	/** keep track of resources that should be freed when exiting. */
	private static Map<String, Image> resourcesMapper = new HashMap<String, Image>();

	private AbstractRegistryEventListener groupProviderRegistryListener;

	private IItemRegistry<IDifferenceGroupProvider.Descriptor> groupItemRegistry;

	private IDifferenceGroupProvider.Descriptor.Registry groupProviderRegistry;

	private AbstractRegistryEventListener filterRegistryListener;

	private IDifferenceFilter.Registry filterRegistry;

	private DifferenceFilterManager filterManager;

	private AbstractRegistryEventListener accessorFactoryRegistryListener;

	private IAccessorFactory.Registry accessorFactoryRegistry;

	private AbstractRegistryEventListener differenceGroupExtenderRegistryListener;

	private IDifferenceGroupExtender.Registry differenceGroupExtenderRegistry;

	private Map<String, IConfigurationUIFactory> matchEngineConfiguratorRegistry;

	private ConfigurationUIRegistryEventListener matchEngineConfiguratorRegistryListener;

	private AbstractRegistryEventListener contentMergeViewerCustomizationRegistryListener;

	private ContentMergeViewerCustomizationRegistry contentMergeViewerCustomizationRegistry;

	/**
	 * The constructor.
	 */
	public EMFCompareRCPUIPlugin() {

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();

		groupItemRegistry = new ItemRegistry<IDifferenceGroupProvider.Descriptor>();
		DifferenceGroupManager groupManager = new DifferenceGroupManager(groupItemRegistry,
				getPreferenceStore());
		groupProviderRegistry = new DifferenceGroupRegistryImpl(groupManager, groupItemRegistry);
		groupProviderRegistryListener = new DifferenceGroupProviderExtensionRegistryListener(PLUGIN_ID,
				GROUP_PROVIDER_PPID, getLog(), groupItemRegistry);

		extensionRegistry.addListener(groupProviderRegistryListener, PLUGIN_ID + "." + GROUP_PROVIDER_PPID); //$NON-NLS-1$
		groupProviderRegistryListener.readRegistry(extensionRegistry);

		filterManager = new DifferenceFilterManager(getPreferenceStore());
		filterRegistry = new DifferenceFilterRegistryImpl(filterManager);
		filterRegistryListener = new DifferenceFilterExtensionRegistryListener(PLUGIN_ID,
				FILTER_PROVIDER_PPID, getLog(), filterManager);
		extensionRegistry.addListener(filterRegistryListener, PLUGIN_ID + "." + FILTER_PROVIDER_PPID); //$NON-NLS-1$
		filterRegistryListener.readRegistry(extensionRegistry);

		accessorFactoryRegistry = new AccessorFactoryRegistryImpl();
		accessorFactoryRegistryListener = new AccessorFactoryExtensionRegistryListener(PLUGIN_ID,
				ACCESSOR_FACTORY_PPID, getLog(), accessorFactoryRegistry);
		extensionRegistry.addListener(accessorFactoryRegistryListener,
				PLUGIN_ID + "." + ACCESSOR_FACTORY_PPID); //$NON-NLS-1$
		accessorFactoryRegistryListener.readRegistry(extensionRegistry);

		differenceGroupExtenderRegistry = new DifferenceGroupExtenderRegistryImpl();
		differenceGroupExtenderRegistryListener = new DifferenceGroupExtenderRegistryListener(PLUGIN_ID,
				DIFFERENCE_GROUP_EXTENDER_PPID, getLog(), differenceGroupExtenderRegistry);
		extensionRegistry.addListener(differenceGroupExtenderRegistryListener,
				PLUGIN_ID + "." + DIFFERENCE_GROUP_EXTENDER_PPID); //$NON-NLS-1$
		differenceGroupExtenderRegistryListener.readRegistry(extensionRegistry);

		matchEngineConfiguratorRegistry = new ConcurrentHashMap<String, IConfigurationUIFactory>();
		matchEngineConfiguratorRegistryListener = new ConfigurationUIRegistryEventListener(PLUGIN_ID,
				MATCH_ENGINE_FACTORY_CONFIGURATION_UI_PPID, getLog(), matchEngineConfiguratorRegistry,
				EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryDescriptorRegistry());
		extensionRegistry.addListener(matchEngineConfiguratorRegistryListener,
				PLUGIN_ID + '.' + MATCH_ENGINE_FACTORY_CONFIGURATION_UI_PPID);
		matchEngineConfiguratorRegistryListener.readRegistry(extensionRegistry);

		contentMergeViewerCustomizationRegistry = new ContentMergeViewerCustomizationRegistry();
		contentMergeViewerCustomizationRegistryListener = new ContentMergeViewerCustomizationRegistryListener(
				PLUGIN_ID, CONTENT_CUSTOMIZATION_PPID, getLog(), contentMergeViewerCustomizationRegistry);
		extensionRegistry.addListener(contentMergeViewerCustomizationRegistryListener,
				PLUGIN_ID + '.' + CONTENT_CUSTOMIZATION_PPID);
		contentMergeViewerCustomizationRegistryListener.readRegistry(extensionRegistry);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();

		extensionRegistry.removeListener(matchEngineConfiguratorRegistryListener);
		matchEngineConfiguratorRegistry = null;
		matchEngineConfiguratorRegistryListener = null;

		extensionRegistry.removeListener(differenceGroupExtenderRegistryListener);
		differenceGroupExtenderRegistryListener = null;
		differenceGroupExtenderRegistry = null;

		extensionRegistry.removeListener(accessorFactoryRegistryListener);
		accessorFactoryRegistryListener = null;
		accessorFactoryRegistry = null;

		extensionRegistry.removeListener(filterRegistryListener);
		filterRegistryListener = null;
		filterRegistry = null;
		filterManager = null;

		extensionRegistry.removeListener(groupProviderRegistryListener);
		groupProviderRegistryListener = null;
		groupItemRegistry = null;
		groupProviderRegistry = null;

		plugin = null;
		disposeCachedImages();
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static EMFCompareRCPUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Log an {@link Exception} in the {@link #getLog() current logger}.
	 * 
	 * @param e
	 *            the exception to be logged.
	 */
	public void log(Throwable e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
	}

	/**
	 * Log the given message with the give severity level. Severity is one of {@link IStatus#INFO},
	 * {@link IStatus#WARNING} and {@link IStatus#ERROR}.
	 * 
	 * @param severity
	 *            the severity of the message
	 * @param message
	 *            the message
	 */
	public void log(int severity, String message) {
		getLog().log(new Status(severity, PLUGIN_ID, message));
	}

	/**
	 * @return the groupProviderRegistry
	 * @since 4.0
	 */
	public IDifferenceGroupProvider.Descriptor.Registry getDifferenceGroupProviderRegistry() {
		return groupProviderRegistry;
	}

	/**
	 * @return the item registry for group providers.
	 * @since 4.0
	 */
	public IItemRegistry<IDifferenceGroupProvider.Descriptor> getItemDifferenceGroupProviderRegistry() {
		return groupItemRegistry;
	}

	/**
	 * @since 4.0
	 */
	public IDifferenceFilter.Registry getDifferenceFilterRegistry() {
		return filterRegistry;
	}

	/**
	 * @return The Difference Filter manager.
	 * @since 4.0
	 */
	public DifferenceFilterManager getDifferenceFilterManager() {
		return filterManager;
	}

	/**
	 * @return the registry
	 */
	public IAccessorFactory.Registry getAccessorFactoryRegistry() {
		return accessorFactoryRegistry;
	}

	/**
	 * @return the sub tree registry
	 * @since 4.0
	 */
	public IDifferenceGroupExtender.Registry getDifferenceGroupExtenderRegistry() {
		return differenceGroupExtenderRegistry;
	}

	/**
	 * Returns the registry containing all known content merge viewer customizations.
	 * 
	 * @return the {@link ContentMergeViewerCustomizationRegistry} containing all known content merge viewer
	 *         customizations.
	 * @since 4.4
	 */
	public ContentMergeViewerCustomizationRegistry getContentMergeViewerCustomizationRegistry() {
		return contentMergeViewerCustomizationRegistry;
	}

	/**
	 * <p>
	 * returns a plugin image. The returned image does not need to be explicitly disposed.
	 * </p>
	 * 
	 * @param imagePath
	 *            : plugin relative path to the image
	 * @return Image : plugin hosted image
	 */
	public static Image getImage(String imagePath) {
		Image image = resourcesMapper.get(imagePath);
		if (image == null) {
			ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, imagePath);
			image = imageDescriptor.createImage();
			resourcesMapper.put(imagePath, image);
		}
		return image;
	}

	/**
	 * <p>
	 * returns a plugin image descriptor.
	 * </p>
	 * 
	 * @param imagePath
	 *            : plugin relative path to the image
	 * @return ImageDescriptor : image descriptor.
	 */
	public static ImageDescriptor getImageDescriptor(String imagePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, imagePath);
	}

	/**
	 * Dispose image with the given id.
	 * 
	 * @param id
	 *            : dispose system resources associated with the image with the given id.
	 */
	public static void disposeImage(String id) {
		Image image = resourcesMapper.remove(id);
		if (image != null) {
			image.dispose();
		}
	}

	/**
	 * dispose system resources associated with cached images.
	 */
	public static void disposeCachedImages() {
		Iterator<Image> iterator = resourcesMapper.values().iterator();
		while (iterator.hasNext()) {
			iterator.next().dispose();
		}
		resourcesMapper.clear();
	}

	/**
	 * Get the Match Engine Configurator Registry
	 * 
	 * @return Map<String, IConfigurationUIFactory>
	 * @since 4.0
	 */
	public Map<String, IConfigurationUIFactory> getMatchEngineConfiguratorRegistry() {
		return matchEngineConfiguratorRegistry;
	}

	/**
	 * Provide this plug-in's preference store, which searches values in {@link InstanceScope}, then
	 * {@link ConfigurationScope}, and then {@link DefaultScope}.
	 */
	@Override
	public IPreferenceStore getPreferenceStore() {
		ScopedPreferenceStore store = (ScopedPreferenceStore)super.getPreferenceStore();
		store.setSearchContexts(new IScopeContext[] {InstanceScope.INSTANCE, ConfigurationScope.INSTANCE });
		return store;
	}
}
