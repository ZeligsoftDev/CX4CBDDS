package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainEnumLiteral;

public class DomainEnumLiteralImpl extends DomainNamedElementImpl implements
		DomainEnumLiteral {
	public DomainEnumLiteralImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.EnumerationLiteral asEnumerationLiteral() {
		return (org.eclipse.uml2.uml.EnumerationLiteral) eObject();
	}
}
