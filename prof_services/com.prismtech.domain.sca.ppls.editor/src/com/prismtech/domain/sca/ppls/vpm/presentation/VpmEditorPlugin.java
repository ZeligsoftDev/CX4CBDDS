/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.prismtech.domain.sca.ppls.vpm.presentation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.osgi.framework.BundleContext;

import com.prismtech.domain.sca.ppls.licensing.PLMLicenser;
import com.prismtech.domain.sca.ppls.utils.VPMImages;
import com.prismtech.domain.sca.ppls.utils.VPMNames;
import com.prismtech.domain.sca.ppls.vpm.provider.VpmEditPlugin;
import com.zeligsoft.base.licensing.LicenseCheck;
import com.zeligsoft.base.licensing.exceptions.LicenseException;

/**
 * This is the central singleton for the Vpm editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class VpmEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final VpmEditorPlugin INSTANCE = new VpmEditorPlugin();
	
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VpmEditorPlugin() {
		super
			(new ResourceLocator [] {
			});
		initImages();
	}
	
	/**
	 * Helper method to register the VPM Editor's images in the JFaceResources ImageRegistry
	 * 
	 * @generated NOT
	 */
	private void initImages(){
		JFaceResources.getImageRegistry().put(VPMNames.SETTABLE_ATTTRIBUTE, ImageDescriptor.createFromURL(
				(URL) VpmEditPlugin.INSTANCE
				.getImage(VPMImages.SETTABLE_ATTTRIBUTE__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION_POINT, ImageDescriptor.createFromURL(
				(URL) VpmEditPlugin.INSTANCE
				.getImage(VPMImages.CONFIGURATION_POINT__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION_POINT_WITH_VALUE, ImageDescriptor.createFromURL(
				(URL) VpmEditPlugin.INSTANCE
				.getImage(VPMImages.CONFIGURATION_POINT_WITH_VALUE__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION_POINT_WITH_SETTINGS, ImageDescriptor.createFromURL(
				(URL) VpmEditPlugin.INSTANCE
				.getImage(VPMImages.CONFIGURATION_POINT_WITH_SETTINGS__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION, ImageDescriptor.createFromURL(
				(URL) VpmEditPlugin.INSTANCE
				.getImage(VPMImages.CONFIGURATION__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION_POINT_WITH_VALUE__VALUE, ImageDescriptor.createFromURL(
				(URL) EMFEditPlugin.INSTANCE.getImage(VPMImages.GENERIC_VALUE__IMAGE)));
		JFaceResources.getImageRegistry().put(VPMNames.CONFIGURATION_POINT__GENERATE, ImageDescriptor.createFromURL(
				(URL) EMFEditPlugin.INSTANCE.getImage(VPMImages.BOOLEAN_VALUE__IMAGE)));
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
	
	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}
	
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {
		
		private static final String LICENSED_PLUGIN_ID = "com.prismtech.domain.sca.plm";
		
		private static final String LICENSED_PLUGIN_VERSION = "0.01";
		
		private static final String SHOW_PLM_UI = "grantShowLicensedPLMUI"; //$NON-NLS-1$
		
		private static BundleContext context = null;
		
		private static PLMLicenser licenser = new PLMLicenser();
		
		private static List<String> userRights = new ArrayList<String>();
		
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		public Implementation() {
			super();
		}
		
		@Override
		public void start(BundleContext context) throws Exception {
			try{
				LicenseCheck.require(context.getBundle(), LICENSED_PLUGIN_ID, LICENSED_PLUGIN_VERSION, false, null);
			}catch (LicenseException e){
				//
			}
			super.start(context);
			setBundleContext(context);
			// Remember the static instance.
			//			
			plugin = this;
		}
		
		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			plugin = null;
		}		
		
		public static IStatus checkLicense(){
			return licenser.check();
		}

		public static List<String> getUserRights() {		
			if(checkLicense().isOK()){
				if(!userRights.contains(SHOW_PLM_UI))			
					userRights.add(SHOW_PLM_UI);
			} else
				userRights.remove(SHOW_PLM_UI);
			return userRights;
		}
		
		private static void setBundleContext(BundleContext bc){
			context = bc;
		}
		
		public static BundleContext getBundleContext(){
			return context;
		}
	}
}
