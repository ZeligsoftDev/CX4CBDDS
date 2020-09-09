package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXCase;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXUnionFieldImplementation;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class CXCaseImplementation extends CXUnionFieldImplementation implements CXCase {
	protected java.util.List<String> _label;

	public CXCaseImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<String> getLabel() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(), "CXDomain::IDL::CXCase",
				"label");

		if (_label == null) {
			_label = new java.util.ArrayList<String>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				_label.add((String) next);

			}
		}
		return _label;
	}

	@Override
	public void addLabel(String val) {
		// make sure the label list is created
		getLabel();

		final Object rawValue = ZDLUtil.getValue(element, "CXDomain::IDL::CXCase", "label");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val);
		if (_label != null) {
			_label.add(val);
		}
	}

}
