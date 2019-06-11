package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABound;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstant;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBABoundImplementation extends ZObjectImpl implements CORBABound {
	protected CORBAConstant _constant;

	public CORBABoundImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getValue() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBABound", "value");
		return (String) rawValue;
	}

	@Override
	public void setValue(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBABound", "value", val);
	}

	@Override
	public CORBAConstant getConstant() {
		if (_constant == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBABound",
							"constant");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_constant = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAConstant.class);
			}
		}
		return _constant;
	}

	@Override
	public void setConstant(CORBAConstant val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBABound", "constant",
				val.eObject());
	}

}
