package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXTemplate;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

public abstract class CXTemplateImplementation extends CXNamedElementImplementation implements CXTemplate {
	public CXTemplateImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
