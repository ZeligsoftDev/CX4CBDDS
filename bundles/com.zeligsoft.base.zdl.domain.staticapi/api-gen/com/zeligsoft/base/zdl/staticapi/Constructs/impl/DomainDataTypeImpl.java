package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainDataType;

public class DomainDataTypeImpl extends DomainClassifierImpl implements
		DomainDataType {
	public DomainDataTypeImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}
}
