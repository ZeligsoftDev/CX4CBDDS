package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.doQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.DestinationOrderQosPolicyKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class doQosPolicyZImpl extends qosPolicyZImpl implements doQosPolicy {
	protected DestinationOrderQosPolicyKind _kind;

	public doQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public DestinationOrderQosPolicyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::doQosPolicy", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = DestinationOrderQosPolicyKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public void setKind(DestinationOrderQosPolicyKind val) {
		ZDLUtil.setValue(element, "DDS::QOS::doQosPolicy", "kind",
				val.eObject(element));
	}

}
