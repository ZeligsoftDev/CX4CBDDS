package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBASupports;

public class CORBASupportsImplementation extends ZObjectImpl implements
		CORBASupports {
	public CORBASupportsImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Generalization asGeneralization() {
		return (org.eclipse.uml2.uml.Generalization) eObject();
	}
}
