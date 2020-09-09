package com.zeligsoft.domain.dds4ccm.api.DDS4CCM.impl;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.DDS4CCMModel;
import com.zeligsoft.domain.idl3plus.api.IDL3Plus.impl.IDL3PlusModelZImpl;

import com.zeligsoft.domain.dds4ccm.api.DDS4CCM.ModelTypeEnum;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DDS4CCMModelZImpl extends IDL3PlusModelZImpl implements DDS4CCMModel {
	protected ModelTypeEnum _modelType;

	public DDS4CCMModelZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getFixedHeader() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedHeader");
		return (String) rawValue;
	}

	@Override
	public void setFixedHeader(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedHeader", val);
	}

	@Override
	public String getFixedFooter() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedFooter");
		return (String) rawValue;
	}

	@Override
	public void setFixedFooter(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel", "fixedFooter", val);
	}

	@Override
	public String getLocationPrefix() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS4CCM::DDS4CCM::DDS4CCMModel", "locationPrefix");
		return (String) rawValue;
	}

	@Override
	public void setLocationPrefix(String val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel", "locationPrefix", val);
	}

	@Override
	public ModelTypeEnum getModelType() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS4CCM::DDS4CCM::DDS4CCMModel", "modelType");

		if (_modelType == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_modelType = ModelTypeEnum.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _modelType;
	}

	@Override
	public void setModelType(ModelTypeEnum val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDS4CCM::DDS4CCMModel", "modelType", val.eObject(element));
	}

}
