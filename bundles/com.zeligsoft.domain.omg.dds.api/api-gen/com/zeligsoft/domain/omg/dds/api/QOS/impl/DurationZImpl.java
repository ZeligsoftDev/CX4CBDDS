package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DurationZImpl extends ZObjectImpl implements Duration {
	public DurationZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getNanosecond() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::Duration",
				"nanosecond");
		return (Integer) rawValue;
	}

	@Override
	public void setNanosecond(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::Duration", "nanosecond", val);
	}

	@Override
	public Integer getSecond() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::Duration", "second");
		return (Integer) rawValue;
	}

	@Override
	public void setSecond(Integer val) {
		ZDLUtil.setValue(element, "DDS::QOS::Duration", "second", val);
	}

}
