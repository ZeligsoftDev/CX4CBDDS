package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.durabilityQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.DurabilityQosPolicyKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class durabilityQosPolicyZImpl extends qosPolicyZImpl implements durabilityQosPolicy {
	protected DurabilityQosPolicyKind _kind;

	public durabilityQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DurabilityQosPolicyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "DDS::QOS::durabilityQosPolicy",
				"kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = DurabilityQosPolicyKind.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(DurabilityQosPolicyKind val) {
		ZDLUtil.setValue(element, "DDS::QOS::durabilityQosPolicy", "kind", val.eObject(element));
	}

}
