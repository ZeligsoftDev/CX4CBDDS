package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.domain.idl3plus.api.Generics.TemplateParameterType;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXTypeImplementation;

public class TemplateParameterTypeZImpl extends CXTypeImplementation implements TemplateParameterType {
	public TemplateParameterTypeZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.DataType asDataType() {
		return (org.eclipse.uml2.uml.DataType) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.Interface asInterface() {
		return (org.eclipse.uml2.uml.Interface) eObject();
	}
}
