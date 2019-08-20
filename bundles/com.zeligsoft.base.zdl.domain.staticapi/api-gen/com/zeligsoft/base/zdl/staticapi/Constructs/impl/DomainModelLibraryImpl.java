package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModelLibrary;

public class DomainModelLibraryImpl extends DomainNamedElementImpl implements
		DomainModelLibrary {
	public DomainModelLibraryImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Package asPackage() {
		return (org.eclipse.uml2.uml.Package) eObject();
	}
}
