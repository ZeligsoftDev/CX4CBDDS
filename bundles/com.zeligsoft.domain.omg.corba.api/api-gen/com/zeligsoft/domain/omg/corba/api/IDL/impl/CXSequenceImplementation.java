package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXSequence;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTemplateImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBound;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXSequenceImplementation extends CXTemplateImplementation implements CXSequence {
	protected CXBound _bounds;

	public CXSequenceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXSequence",
				"bound");
		return (String) rawValue;
	}

	@Override
	public void setBound(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXSequence", "bound", val);
	}

	@Override
	public CXBound getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXSequence",
					"bounds");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_bounds = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue, CXBound.class);
			}
		}
		return _bounds;
	}

	@Override
	public void setBounds(CXBound val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXSequence", "bounds", val.eObject());
	}

	@Override
	public <T extends CXBound> T createBounds(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXSequence",
				"bounds", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public CXBound createBounds() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXSequence",
				"bounds", "CXDomain::IDL::CXBound");
		CXBound element = ZDLFactoryRegistry.INSTANCE.create(newConcept, CXBound.class);
		return element;
	}

}
