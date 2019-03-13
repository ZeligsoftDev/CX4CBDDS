package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainBlockReference;

public class DomainBlockReferenceImpl extends DomainElementImpl implements
		DomainBlockReference {
	public DomainBlockReferenceImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Dependency asDependency() {
		return (org.eclipse.uml2.uml.Dependency) eObject();
	}
}
