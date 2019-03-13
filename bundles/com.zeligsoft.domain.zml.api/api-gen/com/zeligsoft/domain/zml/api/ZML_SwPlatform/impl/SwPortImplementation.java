package com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl;

import com.zeligsoft.domain.zml.api.ZML_SwPlatform.SwPort;
import com.zeligsoft.domain.zml.api.ZML_SwPlatform.impl.SwCommunicationEndPointImplementation;

public class SwPortImplementation extends SwCommunicationEndPointImplementation
		implements SwPort {
	public SwPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Port asPort() {
		return (org.eclipse.uml2.uml.Port) eObject();
	}
}
