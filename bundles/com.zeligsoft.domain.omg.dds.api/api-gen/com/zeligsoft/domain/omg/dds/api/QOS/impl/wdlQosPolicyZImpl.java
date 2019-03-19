package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.wdlQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class wdlQosPolicyZImpl extends qosPolicyZImpl implements wdlQosPolicy {
	public wdlQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getAutodispose_unregistered_instances() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::wdlQosPolicy",
				"autodispose_unregistered_instances");
		return (Boolean) rawValue;
	}

	@Override
	public void setAutodispose_unregistered_instances(Boolean val) {
		ZDLUtil.setValue(element, "DDS::QOS::wdlQosPolicy",
				"autodispose_unregistered_instances", val);
	}

}
