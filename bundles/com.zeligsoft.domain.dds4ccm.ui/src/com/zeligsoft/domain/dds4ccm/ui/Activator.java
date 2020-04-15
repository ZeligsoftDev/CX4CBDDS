package com.zeligsoft.domain.dds4ccm.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends ZeligsoftAbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.domain.dds4ccm.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// Remove Simple UML customization that conflicts with CX UML customization
		ICustomizationManager customizationManager = org.eclipse.papyrus.views.modelexplorer.Activator.getDefault()
				.getCustomizationManager();
		List<String> customNamesToRemove = new ArrayList<String>();
		customNamesToRemove.add("SimpleUML");
		customNamesToRemove.add("StereotypeDisplay");
		List<Customization> customsToRemove = new ArrayList<Customization>();
		for (Customization c : customizationManager.getManagedCustomizations()) {
			if (customNamesToRemove.contains(c.getName())) {
				customsToRemove.add(c);
			}
		}
		final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet()).getRegisteredCustomizations();
		Optional<Customization> customToAdd = registeredCustomizations.stream().filter(c -> "SimpleDependencyUML".equals(c.getName())).findFirst();
		if(customToAdd.isPresent()) {
			if (!customizationManager.getManagedCustomizations().contains(customToAdd.get())) {
				customizationManager.getManagedCustomizations().add(customToAdd.get());
			}
			customizationManager.getManagedCustomizations().removeAll(customsToRemove);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
