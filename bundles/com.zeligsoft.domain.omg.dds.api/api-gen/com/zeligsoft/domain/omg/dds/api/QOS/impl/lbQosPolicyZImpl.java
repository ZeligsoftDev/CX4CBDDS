package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.lbQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

public class lbQosPolicyZImpl extends qosPolicyZImpl implements lbQosPolicy {
	protected Duration _duration;

	public lbQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getDuration() {
		if (_duration == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::lbQosPolicy", "duration");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_duration = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _duration;
	}

}
