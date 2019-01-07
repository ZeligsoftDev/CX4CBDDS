package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.presentationQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.PresentationQosPolicyAccessScopeKind;

public class presentationQosPolicyZImpl extends qosPolicyZImpl implements
		presentationQosPolicy {
	protected PresentationQosPolicyAccessScopeKind _access_scope;

	public presentationQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public PresentationQosPolicyAccessScopeKind getAccess_scope() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::presentationQosPolicy", "access_scope");

		if (_access_scope == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_access_scope = PresentationQosPolicyAccessScopeKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _access_scope;
	}

	@Override
	public Boolean getCoherent_access() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
				.getValue(eObject(), "DDS::QOS::presentationQosPolicy",
						"coherent_access");
		return (Boolean) rawValue;
	}

	@Override
	public Boolean getOrdered_access() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::presentationQosPolicy", "ordered_access");
		return (Boolean) rawValue;
	}

}
