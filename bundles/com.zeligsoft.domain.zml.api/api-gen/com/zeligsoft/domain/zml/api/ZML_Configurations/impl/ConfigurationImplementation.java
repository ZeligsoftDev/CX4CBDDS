package com.zeligsoft.domain.zml.api.ZML_Configurations.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Configurations.Configuration;

public abstract class ConfigurationImplementation extends ZObjectImpl implements
		Configuration {
	public ConfigurationImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public org.eclipse.uml2.uml.Class asClass() {
		return (org.eclipse.uml2.uml.Class) eObject();
	}

	@Override
	public org.eclipse.uml2.uml.InstanceSpecification asInstanceSpecification() {
		return (org.eclipse.uml2.uml.InstanceSpecification) eObject();
	}
}
