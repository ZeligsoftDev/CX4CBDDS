package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXConstructed;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

public abstract class CXConstructedImplementation extends CXNamedElementImplementation implements CXConstructed {
	public CXConstructedImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
