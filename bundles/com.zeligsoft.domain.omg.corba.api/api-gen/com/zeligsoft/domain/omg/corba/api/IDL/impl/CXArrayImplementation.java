package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXArray;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTemplateImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXBound;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXArrayImplementation extends CXTemplateImplementation implements CXArray {
	protected java.util.List<CXBound> _bounds;

	public CXArrayImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CXBound> getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXArray",
					"bounds");
			_bounds = new java.util.ArrayList<CXBound>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXBound nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXBound.class);
					_bounds.add(nextWrapper);
				}
			}
		}
		return _bounds;
	}

	@Override
	public void addBounds(CXBound val) {
		// make sure the bounds list is created
		getBounds();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXArray", "bounds");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_bounds != null) {
			_bounds.add(val);
		}
	}

	@Override
	public <T extends CXBound> T addBounds(Class<T> typeToCreate, String concept) {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXArray", "bounds",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public CXBound addBounds() {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXArray", "bounds",
				"CXDomain::IDL::CXBound");
		CXBound element = ZDLFactoryRegistry.INSTANCE.create(newConcept, CXBound.class);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public String getIndex() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXArray",
				"index");
		return (String) rawValue;
	}

	@Override
	public void setIndex(String val) {
		ZDLUtil.setValue(element, "CXDomain::IDL::CXArray", "index", val);
	}

}
