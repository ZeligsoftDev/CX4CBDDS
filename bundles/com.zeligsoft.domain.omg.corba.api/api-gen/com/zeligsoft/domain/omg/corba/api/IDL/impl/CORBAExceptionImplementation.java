package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAException;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBAConstructedImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAField;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAExceptionImplementation extends
		CORBAConstructedImplementation implements CORBAException {
	protected java.util.List<CORBAField> _members;

	public CORBAExceptionImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CORBAField> getMembers() {
		if (_members == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAException",
							"members");
			_members = new java.util.ArrayList<CORBAField>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBAField nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBAField.class);
					_members.add(nextWrapper);
				}
			}
		}
		return _members;
	}

	@Override
	public void addMembers(CORBAField val) {
		// make sure the members list is created
		getMembers();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAException", "members");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_members != null) {
			_members.add(val);
		}
	}

	@Override
	public <T extends CORBAField> T addMembers(Class<T> typeToCreate,
			String concept) {
		// make sure the members list is created
		getMembers();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil
				.createZDLConcept(element, "CORBADomain::IDL::CORBAException",
						"members", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_members != null) {
			_members.add(element);
		}
		return element;
	}

	@Override
	public CORBAField addMembers() {
		// make sure the members list is created
		getMembers();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAException", "members",
				"CORBADomain::IDL::CORBAField");
		CORBAField element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, CORBAField.class);
		if (_members != null) {
			_members.add(element);
		}
		return element;
	}

}
