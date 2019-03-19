package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAArray;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBATemplateImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBABound;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAArrayImplementation extends CORBATemplateImplementation
		implements CORBAArray {
	protected java.util.List<CORBABound> _bounds;

	public CORBAArrayImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CORBABound> getBounds() {
		if (_bounds == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAArray",
							"bounds");
			_bounds = new java.util.ArrayList<CORBABound>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBABound nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBABound.class);
					_bounds.add(nextWrapper);
				}
			}
		}
		return _bounds;
	}

	@Override
	public void addBounds(CORBABound val) {
		// make sure the bounds list is created
		getBounds();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAArray", "bounds");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_bounds != null) {
			_bounds.add(val);
		}
	}

	@Override
	public <T extends CORBABound> T addBounds(Class<T> typeToCreate,
			String concept) {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAArray", "bounds", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public CORBABound addBounds() {
		// make sure the bounds list is created
		getBounds();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAArray", "bounds",
				"CORBADomain::IDL::CORBABound");
		CORBABound element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, CORBABound.class);
		if (_bounds != null) {
			_bounds.add(element);
		}
		return element;
	}

	@Override
	public String getIndex() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "CORBADomain::IDL::CORBAArray", "index");
		return (String) rawValue;
	}

	@Override
	public void setIndex(String val) {
		ZDLUtil.setValue(element, "CORBADomain::IDL::CORBAArray", "index", val);
	}

}
