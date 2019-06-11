package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.presentationQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.PresentationQosPolicyAccessScopeKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class presentationQosPolicyZImpl extends qosPolicyZImpl implements
		presentationQosPolicy {
	protected PresentationQosPolicyAccessScopeKind _access_scope;

	public presentationQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getOrdered_access() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::presentationQosPolicy", "ordered_access");
		return (Boolean) rawValue;
	}

	@Override
	public void setOrdered_access(Boolean val) {
		ZDLUtil.setValue(element, "DDS::QOS::presentationQosPolicy",
				"ordered_access", val);
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
	public void setAccess_scope(PresentationQosPolicyAccessScopeKind val) {
		ZDLUtil.setValue(element, "DDS::QOS::presentationQosPolicy",
				"access_scope", val.eObject(element));
	}

	@Override
	public Boolean getCoherent_access() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
				.getValue(eObject(), "DDS::QOS::presentationQosPolicy",
						"coherent_access");
		return (Boolean) rawValue;
	}

	@Override
	public void setCoherent_access(Boolean val) {
		ZDLUtil.setValue(element, "DDS::QOS::presentationQosPolicy",
				"coherent_access", val);
	}

}
