package com.zeligsoft.domain.omg.ccm.api.CCM_Component.impl;

import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.omg.ccm.api.CCM_Component.ConjugatedPort;

public class ConjugatedPortImplementation extends ZObjectImpl implements
		ConjugatedPort {
	public ConjugatedPortImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Boolean getIsConjugated() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
				.getValue(eObject(), "CCM::CCM_Component::ConjugatedPort",
						"isConjugated");
		return (Boolean) rawValue;
	}

}
