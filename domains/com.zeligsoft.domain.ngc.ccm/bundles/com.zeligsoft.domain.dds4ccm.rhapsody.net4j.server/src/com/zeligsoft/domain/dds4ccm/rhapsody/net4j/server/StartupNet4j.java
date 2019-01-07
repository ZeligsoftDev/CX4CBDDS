package com.zeligsoft.domain.dds4ccm.rhapsody.net4j.server;

import org.eclipse.ui.IStartup;

public class StartupNet4j implements IStartup {

	@Override
	public void earlyStartup() {
		CXNet4j.startup();
	}

}
