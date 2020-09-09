package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXValueFactory;

public class CXValueFactoryImplementation extends ZObjectImpl implements CXValueFactory {
	public CXValueFactoryImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Operation asOperation() {
		return (org.eclipse.uml2.uml.Operation) eObject();
	}
}
