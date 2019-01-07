/**
 * The Software and documentation are Copyright 2012 PrismTech Canada Inc. All rights reserved.
 */
package com.prismtech.domain.sca.ppls;

import org.eclipse.core.runtime.IStatus;
import org.osgi.framework.BundleContext;

import com.prismtech.domain.sca.ppls.licensing.PLMLicenser;
import com.zeligsoft.base.ui.ZeligsoftAbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends ZeligsoftAbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.prismtech.domain.sca.ppls"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private static BundleContext context = null;
	
	private static PLMLicenser licenser = new PLMLicenser();
	
	/**
	 * The constructor
	 */
	public Activator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setBundleContext(context);
		plugin = this;
	}

	private static void setBundleContext(BundleContext bc){
		context = bc;
	}
	
	public static BundleContext getBundleContext(){
		return context;
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

	public static IStatus checkLicense(){
		return licenser.check();
	}
}
