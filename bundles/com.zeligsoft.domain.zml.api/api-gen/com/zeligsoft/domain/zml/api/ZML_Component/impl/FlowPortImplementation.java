package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.domain.zml.api.ZML_Component.FlowPort;
import com.zeligsoft.domain.zml.api.ZML_Component.impl.PortImplementation;

public abstract class FlowPortImplementation extends PortImplementation
		implements FlowPort {
	public FlowPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

}
