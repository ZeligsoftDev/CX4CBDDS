package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.osQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class osQosPolicyZImpl extends qosPolicyZImpl implements osQosPolicy {
	public osQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::osQosPolicy",
				"value");
		return (Integer) rawValue;
	}

	@Override
	public void setValue(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::osQosPolicy", "value", val);
	}

}
