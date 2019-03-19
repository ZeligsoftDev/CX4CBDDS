package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.ConjugatedPort;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class ConjugatedPortImplementation extends ZObjectImpl implements
		ConjugatedPort {
	public ConjugatedPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getIsConjugated() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZMLMM::ZML_Component::ConjugatedPort",
				"isConjugated");
		return (Boolean) rawValue;
	}

	@Override
	public void setIsConjugated(Boolean val) {
		ZDLUtil.setValue(element, "ZMLMM::ZML_Component::ConjugatedPort",
				"isConjugated", val);
	}

}
