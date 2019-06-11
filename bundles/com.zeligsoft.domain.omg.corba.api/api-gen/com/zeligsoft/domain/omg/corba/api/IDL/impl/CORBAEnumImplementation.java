package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAEnum;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

public class CORBAEnumImplementation extends CORBANamedElementImplementation
		implements CORBAEnum {
	public CORBAEnumImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Enumeration asEnumeration() {
		return (org.eclipse.uml2.uml.Enumeration) eObject();
	}
}
