package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXParameter;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTypedImplementation;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXParameterImplementation extends CXTypedImplementation implements CXParameter {
	protected org.eclipse.uml2.uml.ParameterDirectionKind _direction;

	public CXParameterImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getQualifiedName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"qualifiedName");
		return (String) rawValue;
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "ZMLMM::ZML_Core::NamedElement",
				"name");
		return (String) rawValue;
	}

	@Override
	public void setName(String val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Core::NamedElement", "name", val);
	}

	@Override
	public org.eclipse.uml2.uml.ParameterDirectionKind getDirection() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXParameter",
				"direction");
		return (org.eclipse.uml2.uml.ParameterDirectionKind) rawValue;
	}

	@Override
	public void setDirection(org.eclipse.uml2.uml.ParameterDirectionKind val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXParameter", "direction", val);
	}

	@Override
	public org.eclipse.uml2.uml.Parameter asParameter() {
		return (org.eclipse.uml2.uml.Parameter) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
