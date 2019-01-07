package com.zeligsoft.base.langc.internal;

import com.zeligsoft.base.ZeligsoftAbstractPlugin;

public class Activator extends ZeligsoftAbstractPlugin {

	public static final String PLUGIN_ID = "com.zeligsoft.base.langc"; //$NON-NLS-1$

	private static Activator instance;

	public Activator() {
		instance = this;
	}

	public static Activator getDefault() {
		return instance;
	}
}
