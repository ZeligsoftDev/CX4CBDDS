package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainNamedElement;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class DomainNamedElementImpl extends DomainElementImpl
		implements DomainNamedElement {
	public DomainNamedElementImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getName() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainNamedElement", "name");
		return (String) rawValue;
	}

	@Override
	public void setName(String val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainNamedElement",
				"name", val);
	}

}
