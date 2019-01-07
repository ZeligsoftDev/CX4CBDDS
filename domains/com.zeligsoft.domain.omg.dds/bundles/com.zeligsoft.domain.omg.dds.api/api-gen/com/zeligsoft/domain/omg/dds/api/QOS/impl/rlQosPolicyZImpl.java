package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.rlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

public class rlQosPolicyZImpl extends qosPolicyZImpl implements rlQosPolicy {
	public rlQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getMax_samples_per_instance() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::rlQosPolicy", "max_samples_per_instance");
		return (Integer) rawValue;
	}

	@Override
	public Integer getMax_samples() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::rlQosPolicy", "max_samples");
		return (Integer) rawValue;
	}

	@Override
	public Integer getMax_instances() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::rlQosPolicy", "max_instances");
		return (Integer) rawValue;
	}

}
