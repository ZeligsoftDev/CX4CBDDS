package com.zeligsoft.domain.ngc.ccm;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.zeligsoft.cx.CXActivator;
import com.zeligsoft.cx.preferences.CXPreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.zeligsoft.domain.ngc.ccm.generator"; //$NON-NLS-1$

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
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// Enable comment generation if preference is not set by user
		IEclipsePreferences cxStore = new InstanceScope()
				.getNode(CXActivator.PLUGIN_ID);
		String value = cxStore.get(CXPreferenceConstants.GENERATE_IDL_COMMENT,
				"undefined"); //$NON-NLS-1$
		if (value.equals("undefined")) { //$NON-NLS-1$
			cxStore.putBoolean(CXPreferenceConstants.GENERATE_IDL_COMMENT, true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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
