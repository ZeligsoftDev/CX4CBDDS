package com.zeligsoft.base.zdl.staticapi.Constructs.impl;

import com.zeligsoft.base.zdl.staticapi.Constructs.DomainReference;
import com.zeligsoft.base.zdl.util.ZDLUtil;

public class DomainReferenceImpl extends DomainStructuralFeatureImpl implements
		DomainReference {
	public DomainReferenceImpl(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public String getIconURI() {
		final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil.getValue(
				eObject(), "ZDL::Constructs::DomainReference", "iconURI");
		return (String) rawValue;
	}

	@Override
	public void setIconURI(String val) {
		ZDLUtil.setValue(element, "ZDL::Constructs::DomainReference",
				"iconURI", val);
	}

	@Override
	public org.eclipse.uml2.uml.Association asAssociation() {
		return (org.eclipse.uml2.uml.Association) eObject();
	}
}
