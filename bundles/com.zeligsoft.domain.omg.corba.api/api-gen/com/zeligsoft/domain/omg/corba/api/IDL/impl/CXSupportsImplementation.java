package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXSupports;

public class CXSupportsImplementation extends ZObjectImpl implements CXSupports {
	public CXSupportsImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Generalization asGeneralization() {
		return (org.eclipse.uml2.uml.Generalization) eObject();
	}
}
