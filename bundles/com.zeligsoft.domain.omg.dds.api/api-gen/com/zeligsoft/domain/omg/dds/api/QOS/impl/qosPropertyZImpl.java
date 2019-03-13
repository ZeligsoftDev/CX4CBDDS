package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.qosProperty;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.omg.dds.api.QOS.qosPolicy;

public class qosPropertyZImpl extends NamedElementImplementation implements
		qosProperty {
	protected qosPolicy _policy;

	public qosPropertyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public qosPolicy getPolicy() {
		if (_policy == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::qosProperty", "policy");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_policy = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						qosPolicy.class);
			}
		}
		return _policy;
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
