package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBAConstructed;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CORBANamedElementImplementation;

public abstract class CORBAConstructedImplementation extends
		CORBANamedElementImplementation implements CORBAConstructed {
	public CORBAConstructedImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
