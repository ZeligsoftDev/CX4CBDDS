package com.zeligsoft.domain.idl3plus.api.Generics.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.idl3plus.api.Generics.ModuleBinding;

import com.zeligsoft.domain.idl3plus.api.Generics.ModuleInstantiation;
import com.zeligsoft.domain.idl3plus.api.Generics.ParameterBinding;
import com.zeligsoft.domain.idl3plus.api.Generics.TemplateSignature;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ModuleBindingZImpl extends ZObjectImpl implements ModuleBinding {
	protected TemplateSignature _template;
	protected java.util.List<ParameterBinding> _parameterBinding;
	protected ModuleInstantiation _boundElement;

	public ModuleBindingZImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public TemplateSignature getTemplate() {
		if (_template == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "IDL3Plus::Generics::ModuleBinding",
							"template");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_template = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						TemplateSignature.class);
			}
		}
		return _template;
	}

	@Override
	public void setTemplate(TemplateSignature val) {
		ZDLUtil.setValue(element, "IDL3Plus::Generics::ModuleBinding",
				"template", val.eObject());
	}

	@Override
	public java.util.List<ParameterBinding> getParameterBinding() {
		if (_parameterBinding == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "IDL3Plus::Generics::ModuleBinding",
							"parameterBinding");
			_parameterBinding = new java.util.ArrayList<ParameterBinding>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					ParameterBinding nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									ParameterBinding.class);
					_parameterBinding.add(nextWrapper);
				}
			}
		}
		return _parameterBinding;
	}

	@Override
	public void addParameterBinding(ParameterBinding val) {
		// make sure the parameterBinding list is created
		getParameterBinding();

		final Object rawValue = ZDLUtil.getValue(element,
				"IDL3Plus::Generics::ModuleBinding", "parameterBinding");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_parameterBinding != null) {
			_parameterBinding.add(val);
		}
	}

	@Override
	public <T extends ParameterBinding> T addParameterBinding(
			Class<T> typeToCreate, String concept) {
		// make sure the parameterBinding list is created
		getParameterBinding();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "IDL3Plus::Generics::ModuleBinding",
				"parameterBinding", concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_parameterBinding != null) {
			_parameterBinding.add(element);
		}
		return element;
	}

	@Override
	public ParameterBinding addParameterBinding() {
		// make sure the parameterBinding list is created
		getParameterBinding();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "IDL3Plus::Generics::ModuleBinding",
				"parameterBinding", "IDL3Plus::Generics::ParameterBinding");
		ParameterBinding element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept,
				ParameterBinding.class);
		if (_parameterBinding != null) {
			_parameterBinding.add(element);
		}
		return element;
	}

	@Override
	public ModuleInstantiation getBoundElement() {
		if (_boundElement == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "IDL3Plus::Generics::ModuleBinding",
							"boundElement");
			if (rawValue instanceof org.eclipse.emf.ecore.EObject) {
				_boundElement = ZDLFactoryRegistry.INSTANCE.create(
						(org.eclipse.emf.ecore.EObject) rawValue,
						ModuleInstantiation.class);
			}
		}
		return _boundElement;
	}

	@Override
	public void setBoundElement(ModuleInstantiation val) {
		ZDLUtil.setValue(element, "IDL3Plus::Generics::ModuleBinding",
				"boundElement", val.eObject());
	}

	@Override
	public org.eclipse.uml2.uml.TemplateBinding asTemplateBinding() {
		return (org.eclipse.uml2.uml.TemplateBinding) eObject();
	}
}
