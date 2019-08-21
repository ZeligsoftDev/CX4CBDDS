package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainEnum;

public class DomainEnumImpl extends DomainDataTypeImpl implements DomainEnum {
	public DomainEnumImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Enumeration asEnumeration() {
		return (org.eclipse.uml2.uml.Enumeration) eObject();
	}
}
