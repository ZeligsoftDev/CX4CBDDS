package com.zeligsoft.domain.zml.api.ZML_Core.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Core.Model;

public class ModelImplementation extends ZObjectImpl implements Model {
	public ModelImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Model asModel() {
		return (org.eclipse.uml2.uml.Model) eObject();
	}
}
