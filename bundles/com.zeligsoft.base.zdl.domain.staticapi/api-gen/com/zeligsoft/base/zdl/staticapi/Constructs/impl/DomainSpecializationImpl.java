package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainSpecialization;

public class DomainSpecializationImpl extends DomainNamedElementImpl implements
		DomainSpecialization {
	public DomainSpecializationImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}
}
