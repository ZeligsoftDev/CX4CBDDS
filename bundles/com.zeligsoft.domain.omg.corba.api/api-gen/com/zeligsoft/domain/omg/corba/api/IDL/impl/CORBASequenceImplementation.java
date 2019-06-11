package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBASequence;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBATemplateImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABound;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBASequenceImplementation extends CORBATemplateImplementation
		implements CORBASequence {
	protected CORBABound _bounds;

	public CORBASequenceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public CORBABound getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBASequence",
							"bounds");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_bounds = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						CORBABound.class);
			}
		}
		return _bounds;
	}

	@Override
	public void setBounds(CORBABound val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBASequence", "bounds",
				val.eObject());
	}

	@Override
	public <T extends CORBABound> T createBounds(Class<T> typeToCreate,
			String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBASequence", "bounds", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		return element;
	}

	@Override
	public CORBABound createBounds() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBASequence", "bounds",
				"CORBADomain::IDL::CORBABound");
		CORBABound element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, CORBABound.class);
		return element;
	}

	@Override
	public String getBound() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBASequence", "bound");
		return (String) rawValue;
	}

	@Override
	public void setBound(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBASequence", "bound",
				val);
	}

}
