package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CORBANamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

public class CORBANamedElementImplementation extends NamedElementImplementation
		implements CORBANamedElement {
	public CORBANamedElementImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
