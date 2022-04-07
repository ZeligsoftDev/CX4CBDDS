package com.zeligsoft.domain.dds4ccm.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.compare.ide.ui.internal.logical.resolver.CrossReferenceResolutionScope;
import org.eclipse.emf.compare.ide.ui.internal.preferences.EMFCompareUIPreferences;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainPreferences;
import org.eclipse.papyrus.infra.ui.preferences.RichtextPreferencePage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;
import com.zeligsoft.domain.dds4ccm.ui.internal.MigrationChecker;
import com.zeligsoft.domain.dds4ccm.ui.listeners.DDS4CCMOperationHistoryListener;
import com.zeligsoft.domain.dds4ccm.ui.listeners.EditorPartListener;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
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
		customNamesToRemove.add("SimpleUML"); //$NON-NLS-1$
		customNamesToRemove.add("StereotypeDisplay"); //$NON-NLS-1$
		List<Customization> customsToRemove = new ArrayList<Customization>();
		for (Customization c : customizationManager.getManagedCustomizations()) {
			if (customNamesToRemove.contains(c.getName())) {
				customsToRemove.add(c);
			}
		}
		final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet()).getRegisteredCustomizations();
		Optional<Customization> customToAdd = registeredCustomizations.stream().filter(c -> "SimpleDependencyUML".equals(c.getName())).findFirst(); //$NON-NLS-1$
		if(customToAdd.isPresent()) {
			if (!customizationManager.getManagedCustomizations().contains(customToAdd.get())) {
				customizationManager.getManagedCustomizations().add(customToAdd.get());
			}
			customizationManager.getManagedCustomizations().removeAll(customsToRemove);
		}
		
		
		// Set default architecture
		IEclipsePreferences pref = InstanceScope.INSTANCE
				.getNode(org.eclipse.papyrus.infra.architecture.Activator.PLUGIN_ID);
		String defaultArch = pref.get(ArchitectureDomainPreferences.DEFAULT_CONTEXT, ""); //$NON-NLS-1$
		if (defaultArch != com.zeligsoft.domain.cbdds.architecture.Activator.AXIOMA_ARCHITECTURE_ID) {
			pref.put(ArchitectureDomainPreferences.DEFAULT_CONTEXT,
					com.zeligsoft.domain.cbdds.architecture.Activator.AXIOMA_ARCHITECTURE_ID);
			try {
				pref.flush();
			} catch (BackingStoreException e) {
				// do nothing
			}
		}
		
		// Set default properties text editor
		IEclipsePreferences editorPref = InstanceScope.INSTANCE
				.getNode(org.eclipse.papyrus.infra.ui.Activator.PLUGIN_ID);
		Boolean useRichText = editorPref.getBoolean(RichtextPreferencePage.USE_CK_EDITOR, false);
		if(!useRichText) {
			editorPref.putBoolean(RichtextPreferencePage.USE_CK_EDITOR, true);
			try {
				editorPref.flush();
			} catch (BackingStoreException e) {
				// do nothing
			}
		}
		
		// Set EMF default resolution scope to project Issue #311
		IEclipsePreferences emfPref = InstanceScope.INSTANCE.getNode("org.eclipse.emf.compare.ide.ui"); //$NON-NLS-1$
		String scope = emfPref.get(EMFCompareUIPreferences.RESOLUTION_SCOPE_PREFERENCE,
				CrossReferenceResolutionScope.WORKSPACE.name());
		
		// Don't allow users to set resolution scope to workspace.
		// If the scope is Workspace then change it to Project.
		if (CrossReferenceResolutionScope.WORKSPACE.name().equals(scope)) {
			emfPref.put(EMFCompareUIPreferences.RESOLUTION_SCOPE_PREFERENCE,
					CrossReferenceResolutionScope.PROJECT.name());
			try {
				emfPref.flush();
			} catch (BackingStoreException e) {
				// do nothing
			}
		}
		
		
		// Add part listener in order to add double click listener to model explorer
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.addPartListener(new EditorPartListener());
		page.addPartListener(new MigrationChecker.PapyrusEditorListener());
		
		 PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().addOperationHistoryListener(new DDS4CCMOperationHistoryListener());
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
