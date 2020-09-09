package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXConstants;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

public class CXConstantsImplementation extends CXNamedElementImplementation implements CXConstants {
	public CXConstantsImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
