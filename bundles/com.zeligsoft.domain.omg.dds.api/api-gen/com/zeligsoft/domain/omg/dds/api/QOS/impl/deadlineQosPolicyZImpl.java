package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.dds.api.QOS.deadlineQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

public class deadlineQosPolicyZImpl extends qosPolicyZImpl implements
		deadlineQosPolicy {
	protected Duration _period;

	public deadlineQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Duration getPeriod() {
		if (_period == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "DDS::QOS::deadlineQosPolicy",
							"period");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_period = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						Duration.class);
			}
		}
		return _period;
	}

}
