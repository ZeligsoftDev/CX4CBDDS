package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainMultiplicityElement;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public abstract class DomainMultiplicityElementImpl extends ZObjectImpl
		implements DomainMultiplicityElement {
	public DomainMultiplicityElementImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public Integer getUpper() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainMultiplicityElement",
				"upper");
		return (Integer) rawValue;
	}

	@Override
	public void setUpper(Integer val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainMultiplicityElement",
				"upper", val);
	}

	@Override
	public Boolean getOrdered() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainMultiplicityElement",
				"ordered");
		return (Boolean) rawValue;
	}

	@Override
	public void setOrdered(Boolean val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainMultiplicityElement",
				"ordered", val);
	}

	@Override
	public Integer getLower() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainMultiplicityElement",
				"lower");
		return (Integer) rawValue;
	}

	@Override
	public void setLower(Integer val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainMultiplicityElement",
				"lower", val);
	}

	@Override
	public Boolean getUnique() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainMultiplicityElement",
				"unique");
		return (Boolean) rawValue;
	}

	@Override
	public void setUnique(Boolean val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainMultiplicityElement",
				"unique", val);
	}

}
