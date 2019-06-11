package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.qosPolicy;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

public abstract class qosPolicyZImpl extends NamedElementImplementation
		implements qosPolicy {
	public qosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
