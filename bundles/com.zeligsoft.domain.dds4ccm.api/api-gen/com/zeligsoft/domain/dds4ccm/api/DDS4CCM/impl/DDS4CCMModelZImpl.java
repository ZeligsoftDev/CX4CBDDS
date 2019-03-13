package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.impl.IDL3PlusModelZImpl;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DDS4CCMModelZImpl extends IDL3PlusModelZImpl implements
		DDS4CCMModel {
	public DDS4CCMModelZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	public String getFixedFooter() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedFooter");
		return (String) rawValue;
	}

	public void setFixedFooter(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel",
				"fixedFooter", val);
	}

	public String getFixedHeader() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedHeader");
		return (String) rawValue;
	}

	public void setFixedHeader(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel",
				"fixedHeader", val);
	}

	public String getLocationPrefix() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "DDS4CCM::DDS4CCM::DDS4CCMModel", "locationPrefix");
		return (String) rawValue;
	}

	public void setLocationPrefix(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel",
				"locationPrefix", val);
	}

}
