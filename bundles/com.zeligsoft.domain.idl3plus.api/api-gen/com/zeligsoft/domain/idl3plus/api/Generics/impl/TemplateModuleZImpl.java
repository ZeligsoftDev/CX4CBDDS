package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.idl3plus.api.Generics.TemplateModule;
import com.zeligsoft.domain.omg.corba.api.IDL.impl.CXNamedElementImplementation;

import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class TemplateModuleZImpl extends CXNamedElementImplementation implements TemplateModule {
	protected TemplateSignature _signature;

	public TemplateModuleZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public TemplateSignature getSignature() {
		if (_signature == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(eObject(),
					"IDL3Plus::Generics::TemplateModule", "signature");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_signature = ZDLFactoryRegistry.INSTANCE.create((org.eclipse.emf.ecore.EObject) rawValue,
						TemplateSignature.class);
			}
		}
		return _signature;
	}

	@Override
	public void setSignature(TemplateSignature val) {
		ZDLUtil.setValue(element, "IDL3Plus::Generics::TemplateModule", "signature", val.eObject());
	}

	@Override
	public <T extends TemplateSignature> T createSignature(Class<T> typeToCreate, String concept) {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"IDL3Plus::Generics::TemplateModule", "signature", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(newConcept, typeToCreate);
		return element;
	}

	@Override
	public TemplateSignature createSignature() {
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(element,
				"IDL3Plus::Generics::TemplateModule", "signature", "IDL3Plus::Generics::TemplateSignature");
		TemplateSignature element = ZDLFactoryRegistry.INSTANCE.create(newConcept,
				TemplateSignature.class);
		return element;
	}

	@Override
	public org.eclipse.uml2.uml.Package asPackage() {
		return (org.eclipse.uml2.uml.Package) eObject();
	}
}
