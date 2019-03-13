package com.zeligsoft.domain.omg.dds.api.QOS.impl;

import com.zeligsoft.domain.omg.dds.api.QOS.ownershipQosPolicy;
import com.zeligsoft.domain.omg.dds.api.QOS.impl.qosPolicyZImpl;

import com.zeligsoft.domain.omg.dds.api.QOS.OwnershipQosPolicyKind;

public class ownershipQosPolicyZImpl extends qosPolicyZImpl implements
		ownershipQosPolicy {
	protected OwnershipQosPolicyKind _kind;

	public ownershipQosPolicyZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public OwnershipQosPolicyKind getKind() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS::QOS::ownershipQosPolicy", "kind");

		if (_kind == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_kind = OwnershipQosPolicyKind
						.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _kind;
	}

}
