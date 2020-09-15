package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.tpQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class tpQosPolicyZImpl extends qosPolicyZImpl implements tpQosPolicy {
	public tpQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::tpQosPolicy",
				"value");
		return (Integer) rawValue;
	}

	@Override
	public void setValue(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::tpQosPolicy", "value", val);
	}

}
