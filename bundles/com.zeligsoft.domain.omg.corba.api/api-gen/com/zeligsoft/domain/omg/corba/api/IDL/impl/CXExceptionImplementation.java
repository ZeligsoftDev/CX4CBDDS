package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CXException;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXConstructedImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CXField;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXExceptionImplementation extends CXConstructedImplementation implements CXException {
	protected java.util.List<CXField> _members;

	public CXExceptionImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CXField> getMembers() {
		if (_members == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"CXDomain::IDL::CXException", "members");
			_members = new java.util.ArrayList<CXField>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CXField nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							CXField.class);
					_members.add(nextWrapper);
				}
			}
		}
		return _members;
	}

	@Override
	public void addMembers(CXField val) {
		// make sure the members list is created
		getMembers();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXException", "members");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_members != null) {
			_members.add(val);
		}
	}

	@Override
	public <T extends CXField> T addMembers(Class<T> typeToCreate, String concept) {
		// make sure the members list is created
		getMembers();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXException",
				"members", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_members != null) {
			_members.add(element);
		}
		return element;
	}

	@Override
	public CXField addMembers() {
		// make sure the members list is created
		getMembers();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element, "CXDomain::IDL::CXException",
				"members", "CXDomain::IDL::CXField");
		CXField element = ZDLFactoryRegistry.INSTANCE.create(newConcept, CXField.class);
		if (_members != null) {
			_members.add(element);
		}
		return element;
	}

}
