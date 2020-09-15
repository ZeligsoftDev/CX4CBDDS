package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature;

import com.zeligsoft.domain.idl3plus.api.Generics.TypeParameter;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TemplateSignatureZImpl extends ZObjectImpl implements TemplateSignature {
	protected java.util.List<TypeParameter> _typeParameter;

	public TemplateSignatureZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<TypeParameter> getTypeParameter() {
		if (_typeParameter == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"IDL3Plus::Generics::TemplateSignature", "typeParameter");
			_typeParameter = new java.util.ArrayList<TypeParameter>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					TypeParameter nextWrapper = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) next,
							TypeParameter.class);
					_typeParameter.add(nextWrapper);
				}
			}
		}
		return _typeParameter;
	}

	@Override
	public void addTypeParameter(TypeParameter val) {
		// make sure the typeParameter list is created
		getTypeParameter();

		final Object rawValue = ZDLUtil.getValue(element, "IDL3Plus::Generics::TemplateSignature", "typeParameter");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_typeParameter != null) {
			_typeParameter.add(val);
		}
	}

	@Override
	public <T extends TypeParameter> T addTypeParameter(Class<T> typeToCreate, String concept) {
		// make sure the typeParameter list is created
		getTypeParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"IDL3Plus::Generics::TemplateSignature", "typeParameter", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		if (_typeParameter != null) {
			_typeParameter.add(element);
		}
		return element;
	}

	@Override
	public TypeParameter addTypeParameter() {
		// make sure the typeParameter list is created
		getTypeParameter();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"IDL3Plus::Generics::TemplateSignature", "typeParameter", "IDL3Plus::Generics::TypeParameter");
		TypeParameter element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				TypeParameter.class);
		if (_typeParameter != null) {
			_typeParameter.add(element);
		}
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.TemplateSignature asTemplateSignature() {
		return (org.eclipse.uml2.uml.TemplateSignature) eObject();
	}
}
