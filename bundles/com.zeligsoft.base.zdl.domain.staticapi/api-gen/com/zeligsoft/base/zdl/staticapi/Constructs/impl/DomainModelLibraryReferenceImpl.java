package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModelLibraryReference;

public class DomainModelLibraryReferenceImpl extends DomainElementImpl
		implements DomainModelLibraryReference {
	public DomainModelLibraryReferenceImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
