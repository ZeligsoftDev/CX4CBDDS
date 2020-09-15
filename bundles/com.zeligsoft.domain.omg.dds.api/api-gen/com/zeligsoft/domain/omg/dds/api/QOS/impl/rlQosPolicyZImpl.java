package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.rlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class rlQosPolicyZImpl extends qosPolicyZImpl implements rlQosPolicy {
	public rlQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getMax_samples() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::rlQosPolicy",
				"max_samples");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_samples(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::rlQosPolicy", "max_samples", val);
	}

	@Override
	public Integer getMax_instances() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::rlQosPolicy",
				"max_instances");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_instances(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::rlQosPolicy", "max_instances", val);
	}

	@Override
	public Integer getMax_samples_per_instance() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::rlQosPolicy",
				"max_samples_per_instance");
		return (Integer) rawValue;
	}

	@Override
	public void setMax_samples_per_instance(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::rlQosPolicy", "max_samples_per_instance", val);
	}

}
