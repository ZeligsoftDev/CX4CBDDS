package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

public class CORBAConstantsImplementation extends
		CORBANamedElementImplementation implements CORBAConstants {
	public CORBAConstantsImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
