package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.IDLFileSpecification;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class IDLFileSpecificationZImpl extends ZObjectImpl implements
		IDLFileSpecification {
	public IDLFileSpecificationZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getFilename() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
				.getValue(eObject(), "DDS4CCM::DDS4CCM::IDLFileSpecification",
						"filename");
		return (String) rawValue;
	}

	@Override
	public void setFilename(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::IDLFileSpecification",
				"filename", val);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
