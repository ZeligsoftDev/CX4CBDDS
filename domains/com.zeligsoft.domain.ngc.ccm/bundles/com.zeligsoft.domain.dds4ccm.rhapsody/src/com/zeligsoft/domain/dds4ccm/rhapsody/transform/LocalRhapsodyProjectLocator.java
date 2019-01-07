package com.zeligsoft.domain.dds4ccm.rhapsody.transform;

import com.telelogic.rhapsody.core.IRPProject;

public class LocalRhapsodyProjectLocator implements
		IRhapsodyProjectLocationStrategy {
	
	private final IRPProject project;

	public LocalRhapsodyProjectLocator(Object project) {
		this.project = (IRPProject) project;
		
	}

	@Override
	public IRPProject getProject() {
		return project;
	}

}
