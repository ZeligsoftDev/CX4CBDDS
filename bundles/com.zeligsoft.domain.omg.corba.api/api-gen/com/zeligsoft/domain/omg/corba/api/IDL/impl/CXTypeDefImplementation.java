package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXTypeDef;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXWrapperImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXTypeDefImplementation extends CXWrapperImplementation implements CXTypeDef {
	protected CXType _type;

	public CXTypeDefImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXType getType() {
		if (_type == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXTypeDef",
					"type");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _type;
	}

	@Override
	public void setType(CXType val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXTypeDef", "type", val.eObject());
	}

}
