package com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl;

import com.zeligsoft.domain.zml.api.ZML_HwPlatform.HwPort;
import com.zeligsoft.domain.zml.api.ZML_HwPlatform.impl.HwCommunicationEndPointImplementation;

public class HwPortImplementation extends HwCommunicationEndPointImplementation
		implements HwPort {
	public HwPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Port asPort() {
		return (org.eclipse.uml2.uml.Port) eObject();
	}
}
