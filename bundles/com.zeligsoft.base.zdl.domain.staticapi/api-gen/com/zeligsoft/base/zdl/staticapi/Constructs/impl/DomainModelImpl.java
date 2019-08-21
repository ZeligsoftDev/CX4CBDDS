package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainModel;

public class DomainModelImpl extends DomainNamedElementImpl implements
		DomainModel {
	public DomainModelImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Model asModel() {
		return (org.eclipse.uml2.uml.Model) eObject();
	}
}
