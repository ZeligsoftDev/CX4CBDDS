package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXTyped;

import com.zeligsoft.domain.omg.corba.api.IDL.CXType;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class CXTypedImplementation extends ZObjectImpl implements CXTyped {
	protected CXType _idlType;

	public CXTypedImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
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

}
