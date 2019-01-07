package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.telelogic.rhapsody.core.IRPProject;
import com.telelogic.rhapsody.core.RhapsodyAppServer;

/**
 * A straightforward implementation of {@link IRhapsodyProjectLocationStrategy}
 * that uses the {@link RhapsodyAppServer} API to find the active
 * project.
 * Note that this will result in the use of Remote COM for communication
 * with Rhapsody, and that this my have a significant negative impact 
 * on performance (up to 200 times slower than alternatives).
 *
 */
public class LocateProjectViaRhapsodyAPI implements
		IRhapsodyProjectLocationStrategy {

	@Override
	public IRPProject getProject() {
		return RhapsodyAppServer.getActiveRhapsodyApplication().activeProject();
	}

}
