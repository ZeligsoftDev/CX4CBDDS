package com.zeligsoft.domain.zml.api.ZML_Core.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;

import com.zeligsoft.domain.zml.api.ZML_Core.Namespace;
import com.zeligsoft.domain.zml.api.ZML_Core.impl.NamedElementImplementation;

import com.zeligsoft.domain.zml.api.ZML_Core.NamedElement;

public abstract class NamespaceImplementation extends
		NamedElementImplementation implements Namespace {
	protected java.util.List<NamedElement> _member;

	public NamespaceImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<NamedElement> getMember() {
		if (_member == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(), "ZMLMM::ZML_Core::Namespace", "member");
			_member = new java.util.ArrayList<NamedElement>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					NamedElement nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									NamedElement.class);
					_member.add(nextWrapper);
				}
			}
		}
		return _member;
	}

	@Override
	public org.eclipse.uml2.uml.Namespace asNamespace() {
		return (org.eclipse.uml2.uml.Namespace) eObject();
	}
}
