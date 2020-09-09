package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.tdQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class tdQosPolicyZImpl extends qosPolicyZImpl implements tdQosPolicy {
	public tdQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::tdQosPolicy",
				"value");
		return (String) rawValue;
	}

	@Override
	public void setValue(String val) {
		ZDLUtil.setValue(element, "DDS::QOS::tdQosPolicy", "value", val);
	}

}
