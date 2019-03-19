package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModule;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAModuleContained;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CORBAModuleImplementation extends CORBANamedElementImplementation
		implements CORBAModule {
	protected java.util.List<CORBAModuleContained> _contents;

	public CORBAModuleImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<CORBAModuleContained> getContents() {
		if (_contents == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "CORBADomain::IDL::CORBAModule",
							"contents");
			_contents = new java.util.ArrayList<CORBAModuleContained>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					CORBAModuleContained nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									CORBAModuleContained.class);
					_contents.add(nextWrapper);
				}
			}
		}
		return _contents;
	}

	@Override
	public void addContents(CORBAModuleContained val) {
		// make sure the contents list is created
		getContents();

		final Object rawValue = ZDLUtil.getValue(element,
				"CORBADomain::IDL::CORBAModule", "contents");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_contents != null) {
			_contents.add(val);
		}
	}

	@Override
	public <T extends CORBAModuleContained> T addContents(
			Class<T> typeToCreate, String concept) {
		// make sure the contents list is created
		getContents();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "CORBADomain::IDL::CORBAModule", "contents", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_contents != null) {
			_contents.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Package asPackage() {
		return (org.eclipse.uml2.uml.Package) eObject();
	}
}
