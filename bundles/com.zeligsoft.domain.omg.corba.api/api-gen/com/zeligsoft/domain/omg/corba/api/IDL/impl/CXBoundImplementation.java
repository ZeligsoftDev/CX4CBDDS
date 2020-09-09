package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBound;

import com.zeligsoft.domain.omg.corba.api.IDL.CXConstant;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXBoundImplementation extends ZObjectImpl implements CXBound {
	protected CXConstant _constant;

	public CXBoundImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXConstant getConstant() {
		if (_constant == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXBound",
					"constant");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_constant = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						CXConstant.class);
			}
		}
		return _constant;
	}

	@Override
	public void setConstant(CXConstant val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXBound", "constant", val.eObject());
	}

	@Override
	public String getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXBound",
				"value");
		return (String) rawValue;
	}

	@Override
	public void setValue(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXBound", "value", val);
	}

}
