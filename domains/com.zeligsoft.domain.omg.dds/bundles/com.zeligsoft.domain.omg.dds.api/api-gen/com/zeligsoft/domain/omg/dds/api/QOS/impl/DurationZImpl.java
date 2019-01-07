package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.Duration;

public class DurationZImpl extends ZObjectImpl implements Duration {
	public DurationZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getSecond() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::Duration", "second");
		return (Integer) rawValue;
	}

	@Override
	public Integer getNanosecond() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::Duration", "nanosecond");
		return (Integer) rawValue;
	}

}
