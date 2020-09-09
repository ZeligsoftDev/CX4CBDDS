package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXEnum;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

public class CXEnumImplementation extends CXNamedElementImplementation implements CXEnum {
	public CXEnumImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Enumeration asEnumeration() {
		return (org.eclipse.uml2.uml.Enumeration) eObject();
	}
}
