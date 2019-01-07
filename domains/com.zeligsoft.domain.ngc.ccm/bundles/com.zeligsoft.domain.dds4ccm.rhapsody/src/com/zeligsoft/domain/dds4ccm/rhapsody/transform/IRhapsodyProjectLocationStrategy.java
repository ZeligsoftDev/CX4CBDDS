package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.telelogic.rhapsody.core.IRPProject;

/**
 * Interface encapsulating strategies for locating
 * the Rhapsody project object to be processed by the
 * transform.
 *
 */
public interface IRhapsodyProjectLocationStrategy {

	IRPProject getProject();
	
}
