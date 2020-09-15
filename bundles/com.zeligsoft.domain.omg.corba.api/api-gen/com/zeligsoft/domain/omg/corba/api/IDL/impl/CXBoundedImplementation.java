package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBounded;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBound;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class CXBoundedImplementation extends CXNamedElementImplementation implements CXBounded {
	protected CXBound _bounds;

	public CXBoundedImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXBounded",
				"bound");
		return (String) rawValue;
	}

	@Override
	public void setBound(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXBounded", "bound", val);
	}

	@Override
	public CXBound getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXBounded",
					"bounds");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_bounds = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXBound.class);
			}
		}
		return _bounds;
	}

	@Override
	public void setBounds(CXBound val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXBounded", "bounds", val.eObject());
	}

	@Override
	public <T extends CXBound> T createBounds(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXBounded",
				"bounds", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public CXBound createBounds() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXBounded",
				"bounds", "CXDomain::IDL::CXBound");
		CXBound element = ZDLFactoryRegistry.INSTANCE.create(newConcept, CXBound.class);
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
