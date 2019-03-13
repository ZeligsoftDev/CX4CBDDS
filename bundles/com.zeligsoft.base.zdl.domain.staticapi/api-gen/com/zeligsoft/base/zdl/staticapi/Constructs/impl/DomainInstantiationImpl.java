package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainInstantiation;

public class DomainInstantiationImpl extends DomainElementImpl implements
		DomainInstantiation {
	public DomainInstantiationImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Abstraction asAbstraction() {
		return (org.eclipse.uml2.uml.Abstraction) eObject();
	}
}
