package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.partitionQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

public class partitionQosPolicyZImpl extends qosPolicyZImpl implements
		partitionQosPolicy {
	public partitionQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::partitionQosPolicy", "name");
		return (String) rawValue;
	}

}
