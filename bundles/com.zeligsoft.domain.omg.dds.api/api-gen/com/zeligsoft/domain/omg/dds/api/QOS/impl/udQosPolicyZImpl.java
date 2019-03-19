package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.udQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class udQosPolicyZImpl extends qosPolicyZImpl implements udQosPolicy {
	public udQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::udQosPolicy", "value");
		return (String) rawValue;
	}

	@Override
	public void setValue(String val) {
		ZDLUtil.setValue(element, "DDS::QOS::udQosPolicy", "value", val);
	}

}
