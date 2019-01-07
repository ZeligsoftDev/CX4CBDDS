package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.telelogic.rhapsody.core.IRPProject;
import com.zeligsoft.domain.dds4ccm.rhapsody.datacollector.DataCollector;

/**
 * An extension of {@link LocateProjectViaRhapsodyAPI} that collects
 * usage information on the Rhapsody API.
 * This usage information may be used to feed the generation
 * of the Kryo-based serialization/deserialization of Rhapsody elements
 * between processes.
 *
 */
public class DataCollectingRhapsodyProjectLocator extends LocateProjectViaRhapsodyAPI implements
		IRhapsodyProjectLocationStrategy {

	private DataCollector dataCollector;

	public synchronized DataCollector getDataCollector() {
		return dataCollector;
	}

	@Override
	public IRPProject getProject() {
		dataCollector = new DataCollector();
		final IRPProject project = super.getProject();
		return (IRPProject) dataCollector.proxy(project);
	}

}
