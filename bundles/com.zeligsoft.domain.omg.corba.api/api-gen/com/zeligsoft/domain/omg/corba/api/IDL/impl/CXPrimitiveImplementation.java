package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXPrimitive;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXPrimitiveKind;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXPrimitiveImplementation extends CXNamedElementImplementation implements CXPrimitive {
	protected CXPrimitiveKind _type;

	public CXPrimitiveImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CXPrimitiveKind getType() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXPrimitive",
				"type");

		if (_type == null) {
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_type = CXPrimitiveKind.create((org.eclipse.emf.ecore.EObject) rawValue);
			}
		}
		return _type;
	}

	@Override
	public void setType(CXPrimitiveKind val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXPrimitive", "type", val.eObject(element));
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
