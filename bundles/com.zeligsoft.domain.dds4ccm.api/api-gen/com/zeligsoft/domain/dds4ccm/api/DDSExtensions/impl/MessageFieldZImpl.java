package com.zeligsoft.domain.dds4ccm.api.DDSExtensions.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.dds4ccm.api.DDSExtensions.MessageField;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXFieldImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class MessageFieldZImpl extends CXFieldImplementation implements MessageField {
	protected CXType _idlType;

	public MessageFieldZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"DDS4CCM::DDSExtensions::MessageField", "idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CXType val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDSExtensions::MessageField", "idlType", val.eObject());
	}

	@Override
	public Boolean getIsKey() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
				"DDS4CCM::DDSExtensions::MessageField", "isKey");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsKey(Boolean val) {
		ZDLUtil.setValue(element, "DDS4CCM::DDSExtensions::MessageField", "isKey", val);
	}

}
