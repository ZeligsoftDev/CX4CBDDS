package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.historyQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.HistoryQosPolicyKind;

public class historyQosPolicyZImpl extends qosPolicyZImpl implements
		historyQosPolicy {
	protected HistoryQosPolicyKind _kind;

	public historyQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public HistoryQosPolicyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::historyQosPolicy", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = HistoryQosPolicyKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

	@Override
	public Integer getDepth() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::historyQosPolicy", "depth");
		return (Integer) rawValue;
	}

}
