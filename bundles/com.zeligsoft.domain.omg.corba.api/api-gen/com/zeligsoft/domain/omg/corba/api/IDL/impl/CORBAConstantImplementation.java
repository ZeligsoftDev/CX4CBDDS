package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstant;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAConstantImplementation extends
		CORBANamedElementImplementation implements CORBAConstant {
	protected CORBAType _idlType;

	public CORBAConstantImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getDefault() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBAConstant", "default");
		return (String) rawValue;
	}

	@Override
	public void setDefault(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAConstant", "default",
				val);
	}

	@Override
	public CORBAType getIdlType() {
		if (_idlType == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBATyped",
							"idlType");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_idlType = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBAType.class);
			}
		}
		return _idlType;
	}

	@Override
	public void setIdlType(CORBAType val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBATyped", "idlType",
				val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.Property asProperty() {
		return (org.eclipse.uml2.uml.Property) eObject();
	}
}
