package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.tbfQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

public class tbfQosPolicyZImpl extends qosPolicyZImpl implements tbfQosPolicy {
	protected Duration _minimum_separation;

	public tbfQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getMinimum_separation() {
		if (_minimum_separation == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::tbfQosPolicy",
							"minimum_separation");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_minimum_separation = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _minimum_separation;
	}

}
