package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAValueFactory;

public class CORBAValueFactoryImplementation extends ZObjectImpl implements
		CORBAValueFactory {
	public CORBAValueFactoryImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Operation asOperation() {
		return (org.eclipse.uml2.uml.Operation) eObject();
	}
}
