package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXConstant;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXConstantImplementation extends CXNamedElementImplementation implements CXConstant {
	protected CXType _idlType;

	public CXConstantImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getDefault() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXConstant",
				"default");
		return (String) rawValue;
	}

	@Override
	public void setDefault(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXConstant", "default", val);
	}

	@Override
	public CXType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXTyped",
					"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CXType val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXTyped", "idlType", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
