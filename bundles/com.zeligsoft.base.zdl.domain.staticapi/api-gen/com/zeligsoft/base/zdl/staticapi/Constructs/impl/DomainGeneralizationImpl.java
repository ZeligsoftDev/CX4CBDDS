package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainGeneralization;

public class DomainGeneralizationImpl extends DomainElementImpl implements
		DomainGeneralization {
	public DomainGeneralizationImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Generalization asGeneralization() {
		return (org.eclipse.uml2.uml.Generalization) eObject();
	}
}
