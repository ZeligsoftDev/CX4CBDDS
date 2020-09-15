package com.zeligsoft.domain.omg.corba.api.IDL.impl;

import com.zeligsoft.domain.omg.corba.api.IDL.CXNamedElement;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

public class CXNamedElementImplementation extends NamedElementImplementation implements CXNamedElement {
	public CXNamedElementImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.NamedElement asNamedElement() {
		return (org.eclipse.uml2.uml.NamedElement) eObject();
	}
}
