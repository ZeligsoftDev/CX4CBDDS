package com.prismtech.spectracx.target.eorb_dspbios_cl6x;

import org.osgi.framework.BundleContext;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;

public class Activator extends ZeligsoftAbstractPlugin {

	private static BundleContext context = null;
	
	@Override
	public void start(BundleContext context)
			throws Exception {
		
		super.start(context);
		setBundleContext(context);
	}
	
	private static void setBundleContext(BundleContext bc){
		context = bc;
	}
	
	public static BundleContext getBundleContext(){
		return context;
	}
}
