package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.efQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class efQosPolicyZImpl extends qosPolicyZImpl implements efQosPolicy {
	public efQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getAutoenable_created_entities() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::efQosPolicy",
				"autoenable_created_entities");
		return (Boolean) rawValue;
	}

	@Override
	public void setAutoenable_created_entities(Boolean val) {
		ZDLUtil.setValue(element, "DDS::QOS::efQosPolicy",
				"autoenable_created_entities", val);
	}

}
